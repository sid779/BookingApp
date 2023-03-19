package com.bookmyshow.bms.service;

import com.bookmyshow.bms.bean.Show;
import com.bookmyshow.bms.bean.Ticket;
import com.bookmyshow.bms.bean.Venue;
import com.bookmyshow.bms.bean.VenueWithShows;
import com.bookmyshow.bms.bean.requests.BookingRequest;
import com.bookmyshow.bms.dao.ShowRepository;
import com.bookmyshow.bms.dao.TicketRepostitory;
import com.bookmyshow.bms.dao.VenueRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.http.codec.ServerSentEventHttpMessageWriter;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    private final VenueRepository venueRepository;
    private final ShowRepository showRepository;
    private final TicketingService ticketingService;

    BookingService(VenueRepository venueRepository, ShowRepository showRepository, TicketingService ticketingService)
    {
        this.venueRepository = venueRepository;
        this.showRepository = showRepository;
        this.ticketingService = ticketingService;
    }

    public List<VenueWithShows> getAllVenuesAndShows(String cityName) {
        List<VenueWithShows> venueWithShowsList = new ArrayList<>();
        List<Venue> venueList = venueRepository.getVenueByByCityName(cityName);

        for(Venue venue:venueList)
        {
            List<Show> showList = showRepository.getAllByVenueNameAndCityName(venue.getName(),cityName);
            Map<String, List<Show>> eventShowList = new HashMap<>();
            eventShowList.put(venue.getName(),showList);
            venueWithShowsList.add(new VenueWithShows(venue,eventShowList ));
        }
        return venueWithShowsList;
    }

    public List<VenueWithShows> getAllVenuesAndShowsByEvent(String cityName, String eventName) {
        List<VenueWithShows> venueWithShowsList = new ArrayList<>();
        List<Venue> venueList = venueRepository.getVenueByByCityName(cityName);

        for(Venue venue:venueList)
        {
            List<Show> showList = showRepository.getAllByVenueNameAndEventNameAndCityName(venue.getName(),eventName,cityName);
            Map<String, List<Show>> eventShowList = new HashMap<>();
            eventShowList.put(venue.getName(),showList);
            venueWithShowsList.add(new VenueWithShows(venue,eventShowList ));
        }
        return venueWithShowsList;
    }

    @Transactional
    public String bookShow(String cityName, String eventName, BookingRequest bookingRequest) {
        Show show = showRepository.getAllByVenueNameAndEventNameAndAndShowTimeAndCityName(bookingRequest.getVenueName(),eventName,bookingRequest.getShowTime(),cityName);

        if(!areSeatsAvailable(show.getSeatsAvailable(),bookingRequest.getSeats())) return "SeatsNotAvailable";
        allotSeats(show,bookingRequest.getSeats());

        Integer id = ticketingService.generateTicket(show,bookingRequest.getSeats());
        String response = "Seats Booked with ticket id: " + id;
        return response;
    }


    private void allotSeats(Show show, Integer seatsRequired) {
        show.setSeatsAvailable(show.getSeatsAvailable()-seatsRequired);
        showRepository.save(show);
    }

    private Boolean areSeatsAvailable(Integer seatsAvailable, Integer seatsRequired) {
        return seatsAvailable > seatsRequired;
    }
}

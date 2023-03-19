package com.bookmyshow.bms.controller;

import com.bookmyshow.bms.bean.Ticket;
import com.bookmyshow.bms.bean.Venue;
import com.bookmyshow.bms.bean.VenueWithShows;
import com.bookmyshow.bms.bean.requests.BookingRequest;
import com.bookmyshow.bms.dao.TicketRepostitory;
import com.bookmyshow.bms.service.BookingService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "bms/")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping(path = "{city}/shows")
    List<VenueWithShows> getAllVenuesAndShows(@PathVariable("city") String cityName)
    {
        return bookingService.getAllVenuesAndShows(cityName);
    }

    @GetMapping(path = "{city}/{event}/shows")
    List<VenueWithShows> getAllVenuesAndShowsByEvent(@PathVariable("city") String cityName, @PathVariable("event") String eventName)
    {
        return bookingService.getAllVenuesAndShowsByEvent(cityName,eventName);
    }

    @PostMapping(path = "{city}/{event}/book")
    String bookShow(@PathVariable("city") String cityName, @PathVariable("event") String eventName, @RequestBody BookingRequest bookingRequest)
    {
        return bookingService.bookShow(cityName,eventName,bookingRequest);
    }



}

package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MockConfig {
    @Bean
    CommandLineRunner commandLineRunner(CityRepository cityRepository, EventRepository eventRepository,
                                        ShowRepository showRepository, VenueRepository venueRepository,
                                        TicketRepostitory ticketRepostitory) {
        return args -> {
            City city1 = new City("city1");
            City city2 = new City("city2");
            cityRepository.saveAll(List.of(city1,city2));

            Event event1 = new Event("event1","2022","city1");
            Event event2 = new Event("event2","2023","city1");

            eventRepository.saveAll(List.of(event1,event2));

            Venue venue1 = new Venue("venue1","city1");
            Venue venue2 = new Venue("venue2","city1");

            venueRepository.saveAll(List.of(venue1,venue2));

            Show show1 = new Show("event1","venue1", 9L,"city1");
            Show show2 = new Show("event1","venue2", 12L,"city1");
            Show show3 = new Show("event2","venue1", 9L,"city1");
            Show show4 = new Show("event2","venue2", 12L,"city1");
            Show show5 = new Show("event1","venue2", 9L,"city2");
            Show show6 = new Show("event1","venue2", 12L,"city2");

            showRepository.saveAll(List.of(show1,show2,show3,show4,show5,show6));
        };
    }
}

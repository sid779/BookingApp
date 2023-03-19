package com.bookmyshow.bms.controller;

import com.bookmyshow.bms.bean.Event;
import com.bookmyshow.bms.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "bms/")
public class EventController {

    private final EventService eventService;

    EventController(EventService eventService)
    {
        this.eventService = eventService;
    }

    @GetMapping(path = "{city}")
    List<Event> getAllEvents(@PathVariable("city") String city)
    {
        return eventService.getAllEvents(city);
    }

    @GetMapping(path = "{city}/{event}")
    Optional<Event> getEvent(@PathVariable("city") String cityName, @PathVariable("event") String eventName)
    {
        return eventService.getEvent(cityName,eventName);
    }
}

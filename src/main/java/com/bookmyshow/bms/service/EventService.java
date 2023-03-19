package com.bookmyshow.bms.service;

import com.bookmyshow.bms.bean.Event;
import com.bookmyshow.bms.dao.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    EventService(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents(String cityName){
        return eventRepository.getEventByCityName(cityName);
    }


    public Optional<Event> getEvent(String cityName, String eventName) {
        return eventRepository.getEventByCityNameAndName(cityName,eventName);
    }
}

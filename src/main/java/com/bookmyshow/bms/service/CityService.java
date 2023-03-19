package com.bookmyshow.bms.service;

import com.bookmyshow.bms.bean.Event;
import com.bookmyshow.bms.dao.CityRepository;
import com.bookmyshow.bms.dao.EventRepository;
import com.bookmyshow.bms.dao.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    CityService(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    public List<String> getAllCities() {
        return cityRepository.getAllCities();
    }


}

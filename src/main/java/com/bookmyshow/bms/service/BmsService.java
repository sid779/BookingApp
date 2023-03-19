package com.bookmyshow.bms.service;

import com.bookmyshow.bms.dao.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmsService {
    private List<String> cities;
    private final CityRepository cityRepository;

    @Autowired
    BmsService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<String> getAllCities() {
        return cityRepository.getAllCities();
    }
}

package com.bookmyshow.bms.controller;

import com.bookmyshow.bms.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "bms/")
public class CityController {

    private final CityService cityService;

    @Autowired
    CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping
    List <String> getAllCities(){
        return cityService.getAllCities();
    }

}

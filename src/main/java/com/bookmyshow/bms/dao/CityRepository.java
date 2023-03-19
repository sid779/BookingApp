package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    @Query(value = "SELECT distinct name from City",
            nativeQuery = true)
    public List<String> getAllCities();
}

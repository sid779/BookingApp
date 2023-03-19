package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Long> {
    @Query(value = "SELECT * from Venue where city_name = ?1",
            nativeQuery = true)
    public List<Venue> getVenueByByCityName(String cityName);

}

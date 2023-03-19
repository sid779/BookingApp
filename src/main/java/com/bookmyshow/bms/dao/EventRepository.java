package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query(value = "SELECT * from Event where city_name = ?1",
            nativeQuery = true)
    public List<Event> getEventByCityName(String cityName);

    public Optional<Event> getEventByCityNameAndName(String cityName,String name);
}

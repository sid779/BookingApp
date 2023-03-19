package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.Show;
import com.bookmyshow.bms.bean.Venue;
import com.bookmyshow.bms.bean.VenueWithShows;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {

    public List<Show> getAllByEventName(String eventName);
    public List<Show> getAllByVenueNameAndCityName(String venueName,String cityName);
    public List<Show> getAllByVenueNameAndEventNameAndCityName(String venueName, String eventName,String cityName);
    public Show getAllByVenueNameAndEventNameAndAndShowTimeAndCityName(String venueName, String eventName, Long showTime, String cityName);
    @Query(value = "with result as (SELECT distinct (v.*) , s.* from Show as s " +
            "INNER JOIN Venue as v on v.name = s.venue_name " +
            "where v.city_name = ?1 )" +
            "select row_to_json(r) from result r",
            nativeQuery = true)
    public JSONArray getAllByCityName(String cityName);
    @Query(value = "SELECT * from Show where venue_name = ?1 GROUP BY venue_name",
            nativeQuery = true)
    public List<Object> getShowGroupByVenue(String venueName);
}

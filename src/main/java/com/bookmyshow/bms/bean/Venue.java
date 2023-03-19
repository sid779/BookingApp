package com.bookmyshow.bms.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Venue {
    @Id
    @SequenceGenerator(
            name = "venue_seq",
            sequenceName = "venue_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "venue_seq"
    )
    private Integer id;
    private String name;
    private String cityName;

    public Venue(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public Venue(Venue venue)
    {
        this.id = venue.id;
        this.cityName = venue.cityName;
        this.name = venue.name;
    }

    public Venue() {

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

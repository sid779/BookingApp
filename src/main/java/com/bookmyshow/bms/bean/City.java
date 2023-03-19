package com.bookmyshow.bms.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class City {
    //private List<Event> events;
    //private List<Venue> venues;
    @Id
    @SequenceGenerator(
            name = "city_seq",
            sequenceName = "city_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_seq"
    )
    private Long id;
    private String name;

    public City(String name) {
        this.name = name;
    }

    public City() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

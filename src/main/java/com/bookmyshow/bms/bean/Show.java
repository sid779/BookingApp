package com.bookmyshow.bms.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Show {
    @Id
    @SequenceGenerator(
            name = "show_seq",
            sequenceName = "show_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "show_seq"
    )
    private Integer id;
    private String eventName;
    private String venueName;
    private Long showTime;
    private Integer seatsAvailable;
    private Integer price;
    private String cityName;

    public Show(String eventName, String venueName, Long showTime, String cityName) {
        this.eventName = eventName;
        this.venueName = venueName;
        this.showTime = showTime;
        this.price = 100;
        this.seatsAvailable = 100;
        this.cityName = cityName;
    }

    public Show() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Long getShowTime() {
        return showTime;
    }

    public void setShowTime(Long showTime) {
        this.showTime = showTime;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

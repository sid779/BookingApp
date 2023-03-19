package com.bookmyshow.bms.bean.requests;

public class BookingRequest {
    private Long showTime;
    private String venueName;
    private Integer seats;

    public BookingRequest(Long showTime, String venueName, Integer seats) {
        this.showTime = showTime;
        this.venueName = venueName;
        this.seats = seats;
    }

    public Long getShowTime() {
        return showTime;
    }

    public void setShowTime(Long showTime) {
        this.showTime = showTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}

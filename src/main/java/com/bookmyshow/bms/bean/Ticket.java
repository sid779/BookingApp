package com.bookmyshow.bms.bean;

import com.bookmyshow.bms.bean.enums.PaymentStatus;
import com.bookmyshow.bms.bean.enums.TicketStatus;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table
public class Ticket {
    @Id
    @SequenceGenerator(
            name = "ticket_seq",
            sequenceName = "ticket_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_seq"
    )
    private Integer id;
    private Integer seatsBooked;
    private Integer price;
    private PaymentStatus paymentInfo;
    private Integer showId;
    private String eventName;
    private String venueName;
    private TicketStatus ticketStatus;

    public Ticket(Show show,Integer seatsRequired)
    {
        this.seatsBooked = seatsRequired;
        this.price = seatsRequired*show.getPrice();
        this.paymentInfo = PaymentStatus.SUCCESS;
        this.showId = show.getId();
        this.venueName = show.getVenueName();
        this.eventName = show.getEventName();
        this.ticketStatus = TicketStatus.BOOKED;
    }

    public Ticket() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(Integer seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PaymentStatus getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentStatus paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
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

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}

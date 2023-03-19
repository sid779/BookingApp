package com.bookmyshow.bms.service;

import com.bookmyshow.bms.bean.Show;
import com.bookmyshow.bms.bean.Ticket;
import com.bookmyshow.bms.bean.enums.TicketStatus;
import com.bookmyshow.bms.dao.TicketRepostitory;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketingService {
    private final TicketRepostitory ticketRepostitory;

    @Autowired
    TicketingService(TicketRepostitory ticketRepostitory)
    {
        this.ticketRepostitory = ticketRepostitory;
    }

    public Optional<Ticket> getTicket(Integer id)
    {
        return ticketRepostitory.getAllById(id);
    }

    public Integer generateTicket(Show show, Integer seats) {
        Ticket ticket = new Ticket(show,seats);
        return ticketRepostitory.save(ticket).getId();
    }

    public Integer cancelTicket(Integer id)
    {
        Optional<Ticket> ticketfound = ticketRepostitory.getAllById(id);
        if(!ticketfound.isPresent()) return -1;
        Ticket ticket = ticketfound.get();
        ticket.setTicketStatus(TicketStatus.CANCELLED);
        return ticketRepostitory.save(ticket).getId();
    }

}

package com.bookmyshow.bms.controller;

import com.bookmyshow.bms.bean.Ticket;
import com.bookmyshow.bms.bean.enums.TicketStatus;
import com.bookmyshow.bms.service.TicketingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "bms/ticket")
public class TicketController {

    private final TicketingService ticketingService;

    TicketController(TicketingService ticketingService)
    {
        this.ticketingService = ticketingService;
    }

    @GetMapping(path = "{id}")
    public Optional<Ticket> getTicket(@PathVariable("id") Integer id)
    {
        return ticketingService.getTicket(id);
    }

    @PutMapping(path = "{id}/cancel")
    public String cancelTicket(@PathVariable("id") Integer id)
    {
        String response = (ticketingService.cancelTicket(id)==-1)? "Ticket cancellation failed" : "Ticket cancelled";
        return response;
    }


}

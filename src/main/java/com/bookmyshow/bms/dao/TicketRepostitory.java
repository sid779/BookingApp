package com.bookmyshow.bms.dao;

import com.bookmyshow.bms.bean.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface TicketRepostitory extends JpaRepository<Ticket,Long> {
    Optional<Ticket> getAllById(Integer id);
}

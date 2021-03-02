package com.payment.service;

import com.payment.model.Ticket;
import java.util.List;

public interface TicketService extends GenericService<Ticket, Long> {
    void consider(Long id, Boolean unblock);

    List<Ticket> getUserTickets(Long id);

    void decline(Long id);

    void approve(Long id);
}

package com.payment.service;

import com.payment.model.Ticket;

public interface TicketService extends GenericService<Ticket, Long> {
    void consider(Long id, Boolean unblock);
}

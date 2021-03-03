package com.payment.dao;

import com.payment.model.Ticket;
import java.util.List;

public interface TicketDao extends GenericDao<Ticket, Long> {
    List<Ticket> getUserTickets(Long id);
}

package com.payment.dao.impl;

import com.payment.dao.TicketDao;
import com.payment.db.Storage;
import com.payment.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket create(Ticket ticket) {
        Storage.addTicket(ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> get(Long id) {
        return getAll().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Ticket> getAll() {
        return Storage.TICKETS;
    }

    @Override
    public Ticket update(Ticket ticket) {
        IntStream.range(0, Storage.TICKETS.size())
                .filter(i -> Storage.TICKETS.get(i).getId().equals(ticket.getId()))
                .forEach(i -> Storage.TICKETS.set(i, ticket));
        return ticket;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.TICKETS.removeIf(t -> t.getId().equals(id));
    }
}

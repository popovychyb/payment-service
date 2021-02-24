package com.payment.service.impl;

import com.payment.dao.TicketDao;
import com.payment.dao.jdbs.TicketDaoJdbc;
import com.payment.model.Card;
import com.payment.model.Ticket;
import com.payment.service.CardService;
import com.payment.service.TicketService;
import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {
    private final TicketDao ticketDao = new TicketDaoJdbc();
    private final CardService cardService = new CardServiceImpl();

    @Override
    public Ticket create(Ticket ticket) {
        Card card = cardService.get(ticket.getCardId()).get();
        card.setActivityStatusId(3L);
        cardService.update(card);
        return ticketDao.create(ticket);
    }

    @Override
    public Optional<Ticket> get(Long id) {
        return ticketDao.get(id);
    }

    @Override
    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Override
    public Ticket update(Ticket ticket) {
//        ticket.setLastUpdate(LocalDateTime.now());
        return ticketDao.update(ticket);
    }

    @Override
    public boolean delete(Long id) {
        return ticketDao.delete(id);
    }

    @Override
    public void consider(Long id, Boolean unblock) {
        Ticket ticket = get(id).get();
        Long cardId = ticket.getCardId();
        Card card = cardService.get(cardId).get();
        if (unblock) {
            card.setActivityStatusId(1L);
            ticket.setTicketStatusId(2L);
        } else {
            card.setActivityStatusId(2L);
            ticket.setTicketStatusId(3L);
        }
        update(ticket);
        cardService.update(card);
    }
}

package com.payment.service.impl;

import com.payment.dao.TicketDao;
import com.payment.dao.impl.TicketDaoImpl;
import com.payment.model.Card;
import com.payment.model.Ticket;
import com.payment.model.enums.TicketStatus;
import com.payment.model.enums.UserCardStatus;
import com.payment.service.CardService;
import com.payment.service.TicketService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao = new TicketDaoImpl();
    CardService cardService = new CardServiceImpl();

    @Override
    public Ticket create(Ticket ticket) {
        Card card = cardService.get(ticket.getCardId()).get();
        card.setStatus(UserCardStatus.CONSIDERATION);
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
        ticket.setLastUpdate(LocalDateTime.now());
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
        if(unblock){
            card.setStatus(UserCardStatus.ACTIVE);
            ticket.setStatus(TicketStatus.APPROVED);
        } else {
            card.setStatus(UserCardStatus.BLOCKED);
            ticket.setStatus(TicketStatus.DECLINED);
        }
        update(ticket);
        cardService.update(card);
    }
}

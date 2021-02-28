package com.payment.model;

import com.payment.model.enums.TicketStatus;

public class Ticket {
    private Long id;
    private Long cardId;
    private Long ticketStatusId;

    public Ticket(Long cardId) {
        this.cardId = cardId;
        this.ticketStatusId = (long) TicketStatus.valueOf("NEW").ordinal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketStatusId() {
        return ticketStatusId;
    }

    public void setTicketStatusId(Long ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Ticket{"
                + "id=" + id
                + ", cardId=" + cardId
                + ", ticketStatusId=" + ticketStatusId
                + '}';
    }
}

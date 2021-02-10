package com.payment.model;

import com.payment.model.enums.TicketStatus;
import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private Long cardId;
    private TicketStatus status;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdate;
    private String ticketMessage;
    private String responseMessage;

    public Ticket(Long cardId) {
        this.cardId = cardId;
        this.status = TicketStatus.NEW;
        this.createTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
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
                + ", status=" + status
                + ", createTime=" + createTime
                + ", lastUpdate=" + lastUpdate
                + ", ticketMessage='" + ticketMessage + '\''
                + ", responseMessage='" + responseMessage + '\'' + '}';
    }
}

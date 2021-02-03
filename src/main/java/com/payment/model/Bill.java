package com.payment.model;

import java.math.BigDecimal;

public class Bill {
    private Long id;
    private Long idUser;
    private BankAccount sender;
    private BankAccount recipient;
    private BigDecimal amount;
    private Status status;

    public Bill(Long idUser, BankAccount sender, BankAccount recipient,
                BigDecimal amount, Status status) {
        this.idUser = idUser;
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public BankAccount getSender() {
        return sender;
    }

    public void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public BankAccount getRecipient() {
        return recipient;
    }

    public void setRecipient(BankAccount recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}

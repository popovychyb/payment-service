package com.payment.model;

import com.payment.model.enums.ActivityStatus;
import java.math.BigDecimal;

public class Card {
    private final int cvvBase = 1000;
    private final int pinBase = 10000;
    private final String cvvFormat = "%03d";
    private final String pinFormat = "%04d";

    private Long id;
    private String number;
    private Long idUser;
    private BigDecimal balance;
    private String title;
    private Long activityStatusId;

    public Card(String number) {
        this.number = number;
    }

    public Card(Long idUser) {
        this.idUser = idUser;
        this.balance = new BigDecimal("0");
        this.title = "";
        this.activityStatusId = (long) ActivityStatus.valueOf("ACTIVE").ordinal();
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getActivityStatusId() {
        return activityStatusId;
    }

    public void setActivityStatusId(Long activityStatusId) {
        this.activityStatusId = activityStatusId;
    }

    @Override
    public String toString() {
        return "Card{"
                + "id=" + id
                + ", number='" + number + '\''
                + ", idUser=" + idUser
                + ", balance=" + balance
                + ", title='" + title + '\''
                + ", activityStatusId=" + activityStatusId
                + '}';
    }
}

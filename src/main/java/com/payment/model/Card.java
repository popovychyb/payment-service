package com.payment.model;

import com.payment.model.enums.Currency;
import com.payment.model.enums.UserCardStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Card {
    private final int cvvBase = 1000;
    private final int pinBase = 10000;
    private final String cvvFormat = "%03d";
    private final String pinFormat = "%04d";

    private Long id;
    private String number;
    private Long idUser;
    private BigDecimal balance;
    private LocalDate expiry;
    private String title;
    private String cvv2;
    private String pinCode;
    private Currency currency;
    private UserCardStatus status;
    private LocalDateTime createTime;

    public Card(String number) {
        this.number = number;
    }

    public Card(Long idUser, String title, Currency currency) {
        this.idUser = idUser;
        this.balance = new BigDecimal("0");
        this.title = title;
        this.cvv2 = String.format(cvvFormat, (int) (Math.random() * cvvBase));
        this.pinCode = String.format(pinFormat, (int) (Math.random() * pinBase));
        this.currency = currency;
        this.status = UserCardStatus.ACTIVE;
        this.createTime = LocalDateTime.now();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public UserCardStatus getStatus() {
        return status;
    }

    public void setStatus(UserCardStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{"
                + "id=" + id
                + ", number='" + number + '\''
                + ", idUser=" + idUser
                + ", balance=" + balance
                + ", expiry=" + expiry
                + ", title='" + title + '\''
                + ", cvv2='" + cvv2 + '\''
                + ", pinCode='" + pinCode + '\''
                + ", currency=" + currency
                + ", status=" + status
                + ", createTime=" + createTime + '}';
    }
}

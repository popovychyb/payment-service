package com.payment.model;

import java.math.BigDecimal;
import java.time.YearMonth;

public class BankAccount {
    private Long id;
    private Long idUser;
    private BigDecimal number;
    private BigDecimal balance;
    private YearMonth expiry;
    private Integer cvv2;
    private boolean blocked;

    public BankAccount(Long idUser, BigDecimal number, BigDecimal balance,
                       YearMonth expiry, Integer cvv2, boolean blocked) {
        this.idUser = idUser;
        this.number = number;
        this.balance = balance;
        this.expiry = expiry;
        this.cvv2 = cvv2;
        this.blocked = blocked;
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

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
        this.expiry = expiry;
    }

    public Integer getCvv2() {
        return cvv2;
    }

    public void setCvv2(Integer cvv2) {
        this.cvv2 = cvv2;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", number=" + number +
                ", balance=" + balance +
                ", expiry=" + expiry +
                ", cvv2=" + cvv2 +
                ", blocked=" + blocked +
                '}';
    }
}

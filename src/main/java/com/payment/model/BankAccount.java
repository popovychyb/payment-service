package com.payment.model;

import java.math.BigDecimal;
import java.time.YearMonth;

public class BankAccount {
    private Long id;
    private Long idUser;
    private String number;
    private BigDecimal balance;
    private YearMonth expiry;
    private String cvv2;
    private Integer status;

    public BankAccount(Long idUser, String number, BigDecimal balance,
                       YearMonth expiry, String cvv2, Integer status) {
        this.idUser = idUser;
        this.number = number;
        this.balance = balance;
        this.expiry = expiry;
        this.cvv2 = cvv2;
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

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
        this.expiry = expiry;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", expiry=" + expiry +
                ", cvv2='" + cvv2 + '\'' +
                ", status=" + status +
                '}';
    }
}

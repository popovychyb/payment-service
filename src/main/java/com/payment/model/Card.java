package com.payment.model;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Date;

import static java.lang.Math.random;

public class Card {
    private final int cvvBase = 1000;
    private final int pinBase = 10000;
    private final String cvvFormat = "%03d";
    private final String pinFormat = "%04d";
    private Long id;
    private String number;
    private Long idUser;
    private BigDecimal balance;
    private YearMonth expiry;
    private String title;
    private String cvv2;
    private String pinCode;
    private Long currencyId;
    private Long blockedBy;
    private Date createTime;
    public Card(String number) {
        this.number = number;
    }
    public Card(Long idUser, String title, Long currencyId) {
        this.idUser = idUser;
        this.balance = new BigDecimal("0");
        this.title = title;
        this.cvv2 = String.format(cvvFormat, (int) (random() * cvvBase));
        this.pinCode = String.format(pinFormat, (int) (random() * pinBase));
        this.currencyId = currencyId;
        this.blockedBy = 0L;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public YearMonth getExpiry() {
        return expiry;
    }

    public void setExpiry(YearMonth expiry) {
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

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(Long blockedBy) {
        this.blockedBy = blockedBy;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", idUser=" + idUser +
                ", balance=" + balance +
                ", expiry=" + expiry +
                ", title='" + title + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", currencyId=" + currencyId +
                ", blockedBy=" + blockedBy +
                '}';
    }
}

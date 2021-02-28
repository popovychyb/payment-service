package com.payment.model;

import com.payment.model.enums.BillStatus;
import java.math.BigDecimal;

public class Bill {
    private Long id;
    private Long senderCardId;
    private Long recipientCardId;
    private BigDecimal payment;
    private Long billStatusId;

    public Bill(Long senderCardId, Long recipientCardId, BigDecimal payment) {
        this.senderCardId = senderCardId;
        this.recipientCardId = recipientCardId;
        this.payment = payment;
        this.billStatusId = (long) BillStatus.valueOf("PREPARED").ordinal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderCardId() {
        return senderCardId;
    }

    public void setSenderCardId(Long senderCardId) {
        this.senderCardId = senderCardId;
    }

    public Long getRecipientCardId() {
        return recipientCardId;
    }

    public void setRecipientCardId(Long recipientCardId) {
        this.recipientCardId = recipientCardId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Long getBillStatusId() {
        return billStatusId;
    }

    public void setBillStatusId(Long billStatusId) {
        this.billStatusId = billStatusId;
    }

    @Override
    public String toString() {
        return "Bill{"
                + "id=" + id
                + ", senderCardId=" + senderCardId
                + ", recipientCardId=" + recipientCardId
                + ", payment=" + payment
                + ", billStatusId=" + billStatusId
                + '}';
    }
}

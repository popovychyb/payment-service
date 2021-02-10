package com.payment.model;

import com.payment.model.enums.BillStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bill {
    private Long id;
    private Long senderCardId;
    private Long recipientCardId;
    private BigDecimal payment;
    private BillStatus billStatus;
    private LocalDateTime createTime;

    public Bill(Long senderCardId, Long recipientCardId, BigDecimal payment) {
        this.senderCardId = senderCardId;
        this.recipientCardId = recipientCardId;
        this.payment = payment;
        this.billStatus = BillStatus.PREPARED;
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

    public BillStatus getStatus() {
        return billStatus;
    }

    public void setStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", senderCardId=" + senderCardId +
                ", recipientCardId=" + recipientCardId +
                ", payment=" + payment +
                ", billStatus=" + billStatus +
                ", createTime=" + createTime +
                '}';
    }
}

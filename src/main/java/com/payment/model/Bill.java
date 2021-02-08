package com.payment.model;

import com.payment.model.enums.BillStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bill {
    private Long id;
    private Long senderAccountId;
    private Long recipientAccountId;
    private BigDecimal amount;
    private BillStatus billStatus;
    private LocalDateTime createTime;

    public Bill(Long senderAccountId, Long recipientAccountId, BigDecimal amount) {
        this.senderAccountId = senderAccountId;
        this.recipientAccountId = recipientAccountId;
        this.amount = amount;
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

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public Long getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(Long recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
                ", senderAccountId=" + senderAccountId +
                ", recipientAccountId=" + recipientAccountId +
                ", amount=" + amount +
                ", status=" + billStatus +
                ", createTime=" + createTime +
                '}';
    }
}

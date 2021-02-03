package com.payment.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Long id;
    private Long userId;
    private List<Bill> bills;

    public ShoppingCart(Long userId) {
        this.userId = userId;
        this.bills = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", bills=" + bills +
                '}';
    }
}

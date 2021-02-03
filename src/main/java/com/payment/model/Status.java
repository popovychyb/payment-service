package com.payment.model;

public class Status {
    private Long id;
    private StatusName statusName;

    private enum StatusName {
        PREPARED, SENT
    }

    public Status(StatusName statusName) {
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusName getStatusName() {
        return statusName;
    }

    public void setStatusName(StatusName statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName=" + statusName +
                '}';
    }
}

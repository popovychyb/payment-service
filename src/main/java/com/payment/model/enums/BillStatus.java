package com.payment.model.enums;

import com.payment.model.Bill;

public enum BillStatus {
    PREPARED,
    SENT,
    REJECTED;

    public static BillStatus getBillStatus(Bill bill){
        return BillStatus.values()[Math.toIntExact(bill.getBillStatusId())] ;
    }
}

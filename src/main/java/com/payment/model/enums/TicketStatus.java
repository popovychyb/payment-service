package com.payment.model.enums;

import com.payment.model.Ticket;

public enum TicketStatus{
    NEW,
    APPROVED,
    DECLINED;

    public static TicketStatus getTicketStatus(Ticket ticket){
        return TicketStatus.values()[Math.toIntExact(ticket.getTicketStatusId())];
    }
}



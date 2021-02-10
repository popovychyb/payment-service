package com.payment.db;

import com.payment.model.Bill;
import com.payment.model.Card;
import com.payment.model.Ticket;
import com.payment.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Card> CARDS = new ArrayList<>();
    public static final List<User> USERS = new ArrayList<>();
    public static final List<Bill> BILLS = new ArrayList<>();
    public static final List<Ticket> TICKETS = new ArrayList<>();
    private static Long cardId = 0L;
    private static Long userId = 0L;
    private static Long billId = 0L;
    private static Long ticketId = 0L;

    public static void addCard(Card card) {
        cardId++;
        card.setId(cardId);
        CARDS.add(card);
    }

    public static void addUser(User user) {
        userId++;
        user.setId(userId);
        USERS.add(user);
    }

    public static void addBill(Bill bill) {
        billId++;
        bill.setId(billId);
        BILLS.add(bill);
    }

    public static void addTicket(Ticket ticket) {
        ticketId++;
        ticket.setId(ticketId);
        TICKETS.add(ticket);
    }
}

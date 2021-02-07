package com.payment;

import com.payment.model.Bill;
import com.payment.model.Card;
import com.payment.model.User;
import com.payment.service.BillService;
import com.payment.service.CardService;
import com.payment.service.UserService;
import com.payment.service.impl.BillServiceImpl;
import com.payment.service.impl.CardServiceImpl;
import com.payment.service.impl.UserServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        CardService cardService = new CardServiceImpl();
        BillService billService = new BillServiceImpl();

        System.out.println("- User:");
        User bob = new User("Bob", "Smith", "bob@mail.com", "qwerty");
        User lisa = new User("Lisa", "Bing", "lisa@mail.com", "12345");
        userService.create(bob);
        userService.create(lisa);

        System.out.println("- get user id = 1");
        System.out.println(userService.get(1L).get());

        System.out.println("- get all");
        userService.getAll().forEach(System.out::println);

        System.out.println("- update");
        User bobUpdated = userService.get(1L).get();
        bobUpdated.setLastName("Blacksmith");
        System.out.println(userService.update(bobUpdated));

        System.out.println("- delete");
        User john = new User("John", "Doomed", "john@mail.com", "asdfg");
        john = userService.create(john);
        userService.getAll().forEach(System.out::println);

        System.out.println(userService.delete(john.getId()));
        userService.getAll().forEach(System.out::println);

        System.out.println("\n- BankAccount:");
        Card bobAccount = new Card(bob.getId(), "bob's card", 0L);
        Card bobSecondAccount = new Card(bob.getId(), "bob's second card", 0L);
        Card lisaAccount = new Card(lisa.getId(), "lisa's card", 0L);

        cardService.create(bobAccount);
        cardService.create(bobSecondAccount);
        cardService.create(lisaAccount);
        cardService.getAll().forEach(System.out::println);

        System.out.println("\n- Bills:");
        Bill bobsBill = new Bill(bobAccount.getId(), lisaAccount.getId(), new BigDecimal("1000"), 0);
        Bill lisaBill = new Bill(lisaAccount.getId(), bobAccount.getId(), new BigDecimal("500"), 0);
        billService.create(bobsBill);
        billService.create(lisaBill);
        billService.getAll().forEach(System.out::println);

        System.out.println("\n- getUserBankAccounts");
        System.out.println(cardService.getUserCards(1L));

        System.out.println("\n- getBillsByAccount");
        System.out.println(billService.getBillsByAccount(1L));

        System.out.println("\n- getBillsBySenderAccount");
        System.out.println(billService.getBillsBySenderAccount(1L));

        System.out.println("\n- getBillsByRecipientAccount");
        System.out.println(billService.getBillsByRecipientAccount(1L));
    }
}

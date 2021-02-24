package com.payment;

import com.payment.model.enums.BillStatus;
import com.payment.service.BillService;
import com.payment.service.impl.BillServiceImpl;

public class Main {
    public static void main(String[] args) {
        BillService billService = new BillServiceImpl();

        System.out.println(BillStatus.getBillStatus(billService.get(1L).get()));
        System.out.println(BillStatus.getBillStatus(billService.get(2L).get()));
        System.out.println(BillStatus.getBillStatus(billService.get(3L).get()));

//        UserService userService = new UserServiceImpl();
////        User bob = new User("Bob", "Smith", "bob4@mail.com", "qwerty");
////        userService.get(3L);
//        System.out.println(Role.getRole(userService.get(3L).get()));

//        UserService userService = new UserServiceImpl();
//        User bob = new User("Bob", "Smith", "bob3@mail.com", "qwerty");
//        User lisa = new User("Lisa", "Bing", "lisa3@mail.com", "12345");
//        userService.create(bob);
//        userService.create(lisa);
//        System.out.println(bob);
//        System.out.println(lisa);
//        System.out.println(userService.get(1L));
//        System.out.println(userService.delete(7L));

//        System.out.println("- update");
//        User bobUpdated = userService.get(1L).get();
//        bobUpdated.setLastName("Blacksmith");
//        System.out.println(userService.update(bobUpdated));

//        BillService billService = new BillServiceImpl();
//        System.out.println("\n- Bills:");
//        Bill bobsBill = new Bill(1L, 2L, new BigDecimal("999"));
//        Bill lisaBill = new Bill(2L, 1L, new BigDecimal("499"));
//        billService.create(bobsBill);
//        billService.create(lisaBill);
//        System.out.println(bobsBill);
//        System.out.println(lisaBill);

//                System.out.println("\n- Card:");
//        Card bobsCard = new Card(1L, "bob's card");
//        Card bobSecondAccount = new Card(1L, "bob's second card");
//        Card lisaCard = new Card(2L, "lisa's card");
//
//        CardService cardService = new CardServiceImpl();
//        cardService.create(bobsCard);
//        cardService.create(bobSecondAccount);
//        cardService.create(lisaCard);
//        System.out.println(bobsCard);
//        System.out.println(bobSecondAccount);
//        System.out.println(lisaCard);



//        UserService userService = new UserServiceImpl();
//
//        System.out.println("- User:");
//        User bob = new User("Bob", "Smith", "bob@mail.com", "qwerty");
//        User lisa = new User("Lisa", "Bing", "lisa@mail.com", "12345");
//        userService.create(bob);
//        userService.create(lisa);
//
//        System.out.println("- get user id = 1");
//        System.out.println(userService.get(1L).get());
//
//        System.out.println("- get all");
//        userService.getAll().forEach(System.out::println);
//
//        System.out.println("- update");
//        User bobUpdated = userService.get(1L).get();
//        bobUpdated.setLastName("Blacksmith");
//        System.out.println(userService.update(bobUpdated));
//
//        System.out.println("- delete");
//        User john = new User("John", "Doomed", "john@mail.com", "asdfg");
//        john = userService.create(john);
//        userService.getAll().forEach(System.out::println);
//
//        System.out.println(userService.delete(john.getId()));
//        userService.getAll().forEach(System.out::println);
//
//        System.out.println("\n- BankAccount:");
//        Card bobsCard = new Card(bob.getId(), "bob's card");
//        Card bobSecondAccount = new Card(bob.getId(), "bob's second card");
//        Card lisaCard = new Card(lisa.getId(), "lisa's card");
//
//        CardService cardService = new CardServiceImpl();
//        cardService.create(bobsCard);
//        cardService.create(bobSecondAccount);
//        cardService.create(lisaCard);
//        cardService.getAll().forEach(System.out::println);
//
//        BillService billService = new BillServiceImpl();
//        System.out.println("\n- Bills:");
//        Bill bobsBill = new Bill(bobsCard.getId(), lisaCard.getId(), new BigDecimal("1000"));
//        Bill lisaBill = new Bill(lisaCard.getId(), bobsCard.getId(), new BigDecimal("500"));
//        billService.create(bobsBill);
//        billService.create(lisaBill);
//        billService.getAll().forEach(System.out::println);
//
//        System.out.println("\n- getUserBankAccounts");
//        System.out.println(cardService.getUserCards(1L));
//
//        System.out.println("\n- getBillsByAccount");
//        System.out.println(billService.getBillsByAccount(1L));
//
//        System.out.println("\n- getBillsBySenderAccount");
//        System.out.println(billService.getBillsBySenderAccount(1L));
//
//        System.out.println("\n- getBillsByRecipientAccount");
//        System.out.println(billService.getBillsByRecipientAccount(1L));
//
//        System.out.println("\n- Block / Unblock user:");
//        System.out.println(bob);
//        userService.blockUser(bob.getId());
//        System.out.println(bob);
//        userService.unblockUser(bob.getId());
//        System.out.println(bob);
//
//        System.out.println("\n- Block / Unblock card:");
//        System.out.println(bobsCard);
//        cardService.blockCard(bobsCard.getId());
//        System.out.println(bobsCard);
//        cardService.unblockCard(bobsCard.getId());
//        System.out.println(bobsCard);
//
//        System.out.println("\n- Tickets:");
//        cardService.blockCard(bobsCard.getId());
//        TicketService ticketService = new TicketServiceImpl();
//        System.out.println("blocked:");
//        System.out.println(bobsCard);
//        Ticket bobsTicket = new Ticket(bobsCard.getId());
//        ticketService.create(bobsTicket);
//        System.out.println("after creating ticket:");
//        System.out.println(bobsCard);
//        System.out.println(bobsTicket);
//        System.out.println("all tickets:");
//        ticketService.getAll().forEach(System.out::println);
//        System.out.println("consider unblock:");
//        ticketService.consider(bobsTicket.getId(), true);
//        System.out.println(bobsTicket);
//        System.out.println(bobsCard);
//
//        System.out.println("\n- Add money:");
//        System.out.println("before");
//        System.out.println(bobsCard);
//        cardService.replenish(bobsCard.getId(), new BigDecimal("999"));
//        System.out.println("after");
//        System.out.println(bobsCard);
//        cardService.replenish(bobsCard.getId(), new BigDecimal("100"));
//        System.out.println(bobsCard);
//
//        System.out.println("\n- Minus money:");
//        System.out.println("before");
//        System.out.println(bobsCard);
//        cardService.deduct(bobsCard.getId(), new BigDecimal("9"));
//        System.out.println("after");
//        System.out.println(bobsCard);
//        cardService.deduct(bobsCard.getId(), new BigDecimal("10"));
//        System.out.println(bobsCard);
//
//        System.out.println("\n- Send bill:");
//        System.out.println("before");
//        System.out.println(bobsBill);
//        System.out.println(bobsCard);
//        System.out.println(lisaCard);
//        System.out.println("after");
//        billService.send(bobsBill.getId());
//        System.out.println(bobsBill);
//        System.out.println(bobsCard);
//        System.out.println(lisaCard);
//
//        System.out.println("\n- Raise to admin:");
//        System.out.println("before");
//        System.out.println(bob);
//        System.out.println("after");
//        userService.addAdminRole(bob.getId());
//        System.out.println(bob);
    }
}

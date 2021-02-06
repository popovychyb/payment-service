package com.payment;

import com.payment.model.BankAccount;
import com.payment.model.Bill;
import com.payment.model.Role;
import com.payment.model.ShoppingCart;
import com.payment.model.User;
import com.payment.service.BankAccountService;
import com.payment.service.BillService;
import com.payment.service.ShoppingCartService;
import com.payment.service.UserService;
import com.payment.service.impl.BankAccountServiceImpl;
import com.payment.service.impl.BillServiceImpl;
import com.payment.service.impl.ShoppingCartServiceImpl;
import com.payment.service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        BillService billService = new BillServiceImpl();
        ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

        System.out.println("- User:");
        User bob = new User("Bob", "Smith", "bob@mail.com",
                "qwerty", Role.of("USER"), 0);
        User lisa = new User("Lisa", "Bing", "lisa@mail.com",
                "12345", Role.of("ADMIN"), 0);
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
        User john = new User("John", "Doomed", "john@mail.com",
                "asdfg", Role.of("USER"), 0);
        john = userService.create(john);
        userService.getAll().forEach(System.out::println);

        System.out.println(userService.delete(john.getId()));

        userService.getAll().forEach(System.out::println);

        System.out.println("\n- BankAccount:");
        BankAccount bobAccount = new BankAccount(bob.getId(), "0000111122223333", new BigDecimal("0"),
                YearMonth.of(2025, 12), "main", "123", 0);
        BankAccount bobSecondAccount = new BankAccount(bob.getId(), "9999888877776666", new BigDecimal("0"),
                YearMonth.of(2024, 6), "second", "000", 0);
        BankAccount lisaAccount = new BankAccount(lisa.getId(), "5555666677778888", new BigDecimal("0"),
                YearMonth.of(2022, 5), "salary", "514", 0);
        bankAccountService.create(bobAccount);
        bankAccountService.create(bobSecondAccount);
        bankAccountService.create(lisaAccount);
        bankAccountService.getAll().forEach(System.out::println);

        System.out.println("\n- Bills:");
        Bill bobsBill = new Bill(bobAccount.getId(), lisaAccount.getId(), new BigDecimal("1000"), 0);
        Bill lisaBill = new Bill(lisaAccount.getId(), bobAccount.getId(), new BigDecimal("500"), 0);
        billService.create(bobsBill);
        billService.create(lisaBill);
        billService.getAll().forEach(System.out::println);

        System.out.println("\n- ShoppingCarts:");
        ShoppingCart bobCart = new ShoppingCart(bob.getId());
        ShoppingCart lisaCart = new ShoppingCart(lisa.getId());
        shoppingCartService.create(bobCart);
        shoppingCartService.create(lisaCart);
        shoppingCartService.getAll().forEach(System.out::println);
        System.out.println();

        bobCart.getBills().add(bobsBill);
        lisaCart.getBills().add(lisaBill);
        shoppingCartService.getAll().forEach(System.out::println);

        System.out.println("\n- getUserBankAccounts");
        System.out.println(bankAccountService.getUserBankAccounts(1L));

        System.out.println("\n- getBillsByAccount");
        System.out.println(billService.getBillsByAccount(1L));

        System.out.println("\n- getBillsBySenderAccount");
        System.out.println(billService.getBillsBySenderAccount(1L));

        System.out.println("\n- getBillsByRecipientAccount");
        System.out.println(billService.getBillsByRecipientAccount(1L));
    }
}

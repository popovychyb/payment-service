package com.payment;

import com.payment.db.Storage;
import com.payment.model.*;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob", "Smith", "bob@mail.com",
                "qwerty", Role.of("USER"), 0);
        User lisa = new User("Lisa", "Bing", "lisa@mail.com",
                "12345", Role.of("ADMIN"), 0);
        Storage.addUser(bob);
        Storage.addUser(lisa);
        Storage.users.forEach(System.out::println);
        System.out.println();

        BankAccount bobAccount = new BankAccount(bob.getId(), "0000111122223333", new BigDecimal("0"),
                YearMonth.of(2025, 12), "123", 0);
        BankAccount bobSecondAccount = new BankAccount(bob.getId(), "9999888877776666", new BigDecimal("0"),
                YearMonth.of(2024, 6), "000", 0);
        BankAccount lisaAccount = new BankAccount(lisa.getId(), "5555666677778888", new BigDecimal("0"),
                YearMonth.of(2022, 5), "514", 0);
        Storage.addBankAccount(bobAccount);
        Storage.addBankAccount(bobSecondAccount);
        Storage.addBankAccount(lisaAccount);
        Storage.bankAccounts.forEach(System.out::println);
        System.out.println();

        Bill bobsBill = new Bill(bobAccount.getId(), lisaAccount.getId(), new BigDecimal("1000"), 0);
        Bill lisaBill = new Bill(lisaAccount.getId(), bobAccount.getId(), new BigDecimal("500"), 0);
        Storage.addBill(bobsBill);
        Storage.addBill(lisaBill);
        Storage.bills.forEach(System.out::println);
        System.out.println();

        ShoppingCart bobCart = new ShoppingCart(bob.getId());
        ShoppingCart lisaCart = new ShoppingCart(lisa.getId());
        Storage.addShoppingCart(bobCart);
        Storage.addShoppingCart(lisaCart);
        Storage.shoppingCarts.forEach(System.out::println);
        System.out.println();

        bobCart.getBills().add(bobsBill);
        lisaCart.getBills().add(lisaBill);
        Storage.shoppingCarts.forEach(System.out::println);
    }
}

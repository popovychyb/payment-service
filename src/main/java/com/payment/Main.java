package com.payment;

import com.payment.db.Storage;
import com.payment.model.BankAccount;
import com.payment.model.Role;
import com.payment.model.User;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob", "Smith", "bob@mail.com",
                "qwerty", Role.of("USER"), false);
        User lisa = new User("Lisa", "Bing", "lisa@mail.com",
                "12345", Role.of("ADMIN"), false);
        Storage.addUser(bob);
        Storage.addUser(lisa);
        Storage.users.forEach(System.out::println);

        BankAccount bobAccount = new BankAccount(bob.getId(), new BigDecimal("0000111122223333"), new BigDecimal("0"),
                YearMonth.of(2025, 12), 123, false);
        BankAccount bobSecondAccount = new BankAccount(bob.getId(), new BigDecimal("9999888877776666"), new BigDecimal("0"),
                YearMonth.of(2024, 6), 000, false);
        BankAccount lisaAccount = new BankAccount(lisa.getId(), new BigDecimal("5555666677778888"), new BigDecimal("0"),
                YearMonth.of(2022, 5), 514, false);
        Storage.addBankAccount(bobAccount);
        Storage.addBankAccount(bobSecondAccount);
        Storage.addBankAccount(lisaAccount);
        Storage.bankAccounts.forEach(System.out::println);
    }
}

package com.payment.db;

import com.payment.model.BankAccount;
import com.payment.model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Long bankAccountId = 0L;
    private static Long userId = 0L;
    public static final List<BankAccount> bankAccounts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();

    public static void addBankAccount(BankAccount bankAccount){
        bankAccountId++;
        bankAccount.setId(bankAccountId);
        bankAccounts.add(bankAccount);
    }

    public static void addUser(User user){
        userId++;
        user.setId(userId);
        users.add(user);
    }
}

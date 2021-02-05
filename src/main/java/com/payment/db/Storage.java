package com.payment.db;

import com.payment.model.BankAccount;
import com.payment.model.Bill;
import com.payment.model.ShoppingCart;
import com.payment.model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<BankAccount> bankAccounts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    public static final List<Bill> bills = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    private static Long bankAccountId = 0L;
    private static Long userId = 0L;
    private static Long billId = 0L;
    private static Long shoppingCartId = 0L;

    public static void addBankAccount(BankAccount bankAccount) {
        bankAccountId++;
        bankAccount.setId(bankAccountId);
        bankAccounts.add(bankAccount);
    }

    public static void addUser(User user) {
        userId++;
        user.setId(userId);
        users.add(user);
    }

    public static void addBill(Bill bill) {
        billId++;
        bill.setId(billId);
        bills.add(bill);
    }

    public static void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartId++;
        shoppingCart.setId(shoppingCartId);
        shoppingCarts.add(shoppingCart);
    }
}

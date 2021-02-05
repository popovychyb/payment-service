package com.payment;

import com.payment.dao.BankAccountDao;
import com.payment.dao.BillDao;
import com.payment.dao.ShoppingCartDao;
import com.payment.dao.UserDao;
import com.payment.dao.impl.BankAccountDaoImpl;
import com.payment.dao.impl.BillDaoImpl;
import com.payment.dao.impl.ShoppingCartDaoImpl;
import com.payment.dao.impl.UserDaoImpl;
import com.payment.model.BankAccount;
import com.payment.model.Bill;
import com.payment.model.Role;
import com.payment.model.ShoppingCart;
import com.payment.model.User;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        BankAccountDao bankAccountDao = new BankAccountDaoImpl();
        BillDao billDao = new BillDaoImpl();
        ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();

        System.out.println("- User:");
        User bob = new User("Bob", "Smith", "bob@mail.com",
                "qwerty", Role.of("USER"), 0);
        User lisa = new User("Lisa", "Bing", "lisa@mail.com",
                "12345", Role.of("ADMIN"), 0);
        userDao.create(bob);
        userDao.create(lisa);

        System.out.println("- get user id = 1");
        System.out.println(userDao.get(1L).get());

        System.out.println("- get all");
        userDao.getAll().forEach(System.out::println);

        System.out.println("- update");
        User bobUpdated = userDao.get(1L).get();
        bobUpdated.setLastName("Blacksmith");
        System.out.println(userDao.update(bobUpdated));

        System.out.println("- delete");
        User john = new User("John", "Doomed", "john@mail.com",
                "asdfg", Role.of("USER"), 0);
        john = userDao.create(john);
        userDao.getAll().forEach(System.out::println);

        System.out.println(userDao.delete(john.getId()));

        userDao.getAll().forEach(System.out::println);

        System.out.println("\n- BankAccount:");
        BankAccount bobAccount = new BankAccount(bob.getId(), "0000111122223333", new BigDecimal("0"),
                YearMonth.of(2025, 12), "main", "123", 0);
        BankAccount bobSecondAccount = new BankAccount(bob.getId(), "9999888877776666", new BigDecimal("0"),
                YearMonth.of(2024, 6), "second", "000", 0);
        BankAccount lisaAccount = new BankAccount(lisa.getId(), "5555666677778888", new BigDecimal("0"),
                YearMonth.of(2022, 5), "salary", "514", 0);
        bankAccountDao.create(bobAccount);
        bankAccountDao.create(bobSecondAccount);
        bankAccountDao.create(lisaAccount);
        bankAccountDao.getAll().forEach(System.out::println);

        System.out.println("\n- Bills:");
        Bill bobsBill = new Bill(bobAccount.getId(), lisaAccount.getId(), new BigDecimal("1000"), 0);
        Bill lisaBill = new Bill(lisaAccount.getId(), bobAccount.getId(), new BigDecimal("500"), 0);
        billDao.create(bobsBill);
        billDao.create(lisaBill);
        billDao.getAll().forEach(System.out::println);

        System.out.println("\n- ShoppingCarts:");
        ShoppingCart bobCart = new ShoppingCart(bob.getId());
        ShoppingCart lisaCart = new ShoppingCart(lisa.getId());
        shoppingCartDao.create(bobCart);
        shoppingCartDao.create(lisaCart);
        shoppingCartDao.getAll().forEach(System.out::println);
        System.out.println();

        bobCart.getBills().add(bobsBill);
        lisaCart.getBills().add(lisaBill);
        shoppingCartDao.getAll().forEach(System.out::println);

        System.out.println("\n- getUserBankAccounts");
        System.out.println(bankAccountDao.getUserBankAccounts(1L));

        System.out.println("\n- getBillsByAccount");
        System.out.println(billDao.getBillsByAccount(1L));

        System.out.println("\n- getBillsBySenderAccount");
        System.out.println(billDao.getBillsBySenderAccount(1L));

        System.out.println("\n- getBillsByRecipientAccount");
        System.out.println(billDao.getBillsByRecipientAccount(1L));
    }
}

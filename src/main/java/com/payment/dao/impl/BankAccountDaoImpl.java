package com.payment.dao.impl;

import com.payment.dao.BankAccountDao;
import com.payment.db.Storage;
import com.payment.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankAccountDaoImpl implements BankAccountDao {
    @Override
    public BankAccount create(BankAccount bankAccount) {
        Storage.addBankAccount(bankAccount);
        return bankAccount;
    }

    @Override
    public Optional<BankAccount> get(Long id) {
        return getAll().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<BankAccount> getUserBankAccounts(Long id) {
        return getAll().stream()
                .filter(b -> b.getIdUser().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> getAll() {
        return Storage.bankAccounts;
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        IntStream.range(0, Storage.bankAccounts.size())
                .filter(i -> Storage.bankAccounts.get(i).getId().equals(bankAccount.getId()))
                .forEach(i -> Storage.bankAccounts.set(i, bankAccount));
        return bankAccount;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.bankAccounts.removeIf(b -> b.getId().equals(id));
    }

}

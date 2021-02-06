package com.payment.service.impl;

import com.payment.dao.BankAccountDao;
import com.payment.dao.impl.BankAccountDaoImpl;
import com.payment.model.BankAccount;
import com.payment.service.BankAccountService;

import java.util.List;
import java.util.Optional;

public class BankAccountServiceImpl implements BankAccountService {
    BankAccountDao bankAccountDao = new BankAccountDaoImpl();

    @Override
    public BankAccount create(BankAccount bankAccount) {
        return bankAccountDao.create(bankAccount);
    }

    @Override
    public Optional<BankAccount> get(Long id) {
        return bankAccountDao.get(id);
    }

    @Override
    public List<BankAccount> getAll() {
        return bankAccountDao.getAll();
    }

    @Override
    public List<BankAccount> getUserBankAccounts(Long id) {
        return bankAccountDao.getUserBankAccounts(id);
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return bankAccountDao.update(bankAccount);
    }

    @Override
    public boolean delete(Long id) {
        return bankAccountDao.delete(id);
    }
}

package com.payment.dao;

import com.payment.model.BankAccount;

import java.util.List;

public interface BankAccountDao extends GenericDao<BankAccount, Long> {
    List<BankAccount> getUserBankAccounts(Long id);
}

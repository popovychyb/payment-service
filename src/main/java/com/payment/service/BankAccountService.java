package com.payment.service;

import com.payment.model.BankAccount;

import java.util.List;

public interface BankAccountService
        extends GenericService<BankAccount, Long> {
    List<BankAccount> getUserBankAccounts(Long id);
}

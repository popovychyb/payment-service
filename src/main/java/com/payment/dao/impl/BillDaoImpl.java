package com.payment.dao.impl;

import com.payment.dao.BillDao;
import com.payment.db.Storage;
import com.payment.model.Bill;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BillDaoImpl implements BillDao {
    @Override
    public Bill create(Bill bill) {
        Storage.addBill(bill);
        return bill;
    }

    @Override
    public Optional<Bill> get(Long id) {
        return getAll().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Bill> getBillsBySenderAccount(Long id) {
        return getAll().stream()
                .filter(b -> b.getSenderAccountId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getBillsByRecipientAccount(Long id) {
        return getAll().stream()
                .filter(b -> b.getRecipientAccountId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getBillsByAccount(Long id) {
        return getAll().stream()
                .filter(b -> b.getSenderAccountId().equals(id)
                        || b.getRecipientAccountId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAll() {
        return Storage.bills;
    }

    @Override
    public Bill update(Bill bill) {
        IntStream.range(0, Storage.bills.size())
                .filter(i -> Storage.bills.get(i).getId().equals(bill.getId()))
                .forEach(i -> Storage.bills.set(i, bill));
        return bill;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.bills.removeIf(b -> b.getId().equals(id));
    }
}

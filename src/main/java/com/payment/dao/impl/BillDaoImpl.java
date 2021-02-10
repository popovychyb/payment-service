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
                .filter(b -> b.getSenderCardId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getBillsByRecipientAccount(Long id) {
        return getAll().stream()
                .filter(b -> b.getRecipientCardId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getBillsByAccount(Long id) {
        return getAll().stream()
                .filter(b -> b.getSenderCardId().equals(id)
                        || b.getRecipientCardId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAll() {
        return Storage.BILLS;
    }

    @Override
    public Bill update(Bill bill) {
        IntStream.range(0, Storage.BILLS.size())
                .filter(i -> Storage.BILLS.get(i).getId().equals(bill.getId()))
                .forEach(i -> Storage.BILLS.set(i, bill));
        return bill;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.BILLS.removeIf(b -> b.getId().equals(id));
    }
}

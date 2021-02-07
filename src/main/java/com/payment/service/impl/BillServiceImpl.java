package com.payment.service.impl;

import com.payment.dao.BillDao;
import com.payment.dao.impl.BillDaoImpl;
import com.payment.model.Bill;
import com.payment.service.BillService;

import java.util.List;
import java.util.Optional;

public class BillServiceImpl implements BillService {
    private final BillDao billDao = new BillDaoImpl();

    @Override
    public Bill create(Bill bill) {
        return billDao.create(bill);
    }

    @Override
    public Optional<Bill> get(Long id) {
        return billDao.get(id);
    }

    @Override
    public List<Bill> getAll() {
        return billDao.getAll();
    }

    @Override
    public List<Bill> getBillsBySenderAccount(Long id) {
        return billDao.getBillsBySenderAccount(id);
    }

    @Override
    public List<Bill> getBillsByRecipientAccount(Long id) {
        return billDao.getBillsByRecipientAccount(id);
    }

    @Override
    public List<Bill> getBillsByAccount(Long id) {
        return billDao.getBillsByAccount(id);
    }

    @Override
    public Bill update(Bill bill) {
        return billDao.update(bill);
    }

    @Override
    public boolean delete(Long id) {
        return billDao.delete(id);
    }


}

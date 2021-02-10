package com.payment.service.impl;

import com.payment.dao.BillDao;
import com.payment.dao.impl.BillDaoImpl;
import com.payment.model.Bill;
import com.payment.model.Card;
import com.payment.model.enums.BillStatus;
import com.payment.service.BillService;
import com.payment.service.CardService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BillServiceImpl implements BillService {
    private final BillDao billDao = new BillDaoImpl();
    private final CardService cardService = new CardServiceImpl();

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
    public void send(Long id) {
        Bill bill = get(id).get();
        BigDecimal payment = bill.getPayment();
        Card sender = cardService.get(bill.getSenderCardId()).get();
        if (sender.getBalance().compareTo(payment) < 0) {
            bill.setStatus(BillStatus.REJECTED);
            return;
        }
        Card recipient = cardService.get(bill.getRecipientCardId()).get();
        cardService.deduct(sender.getId(), payment);
        if (sender.getCurrency() != null
                && recipient.getCurrency() != null
                && sender.getCurrency() != recipient.getCurrency()) {
            payment = cardService.convert(sender.getCurrency(),
                    recipient.getCurrency(), payment);
        }
        cardService.replenish(recipient.getId(), payment);
        bill.setStatus(BillStatus.SENT);
        update(bill);
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

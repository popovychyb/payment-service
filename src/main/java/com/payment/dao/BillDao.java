package com.payment.dao;

import com.payment.model.Bill;
import java.util.List;

public interface BillDao extends GenericDao<Bill, Long> {
    List<Bill> getBillsBySenderAccount(Long id);

    List<Bill> getBillsByRecipientAccount(Long id);

    List<Bill> getBillsByAccount(Long id);

    List<Bill> getUserBills(Long id);
}

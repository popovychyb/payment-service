package com.payment.service;

import com.payment.model.Bill;
import java.util.List;

public interface BillService extends GenericService<Bill, Long> {
    List<Bill> getBillsBySenderAccount(Long id);

    List<Bill> getBillsByRecipientAccount(Long id);

    List<Bill> getBillsByAccount(Long id);

    void send(Long id);
}

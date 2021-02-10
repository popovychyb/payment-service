package com.payment.service;

import com.payment.model.Card;
import com.payment.model.enums.Currency;

import java.math.BigDecimal;
import java.util.List;

public interface CardService extends GenericService<Card, Long> {
    List<Card> getUserCards(Long id);

    void blockCard(Long id);

    void unblockCard(Long id);

    void replenish(Long id, BigDecimal amount);

    void deduct(Long id, BigDecimal amount);

    BigDecimal convert(Currency sender, Currency recipient, BigDecimal payment);
}

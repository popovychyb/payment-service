package com.payment.dao;

import com.payment.model.Card;
import java.util.List;
import java.util.Optional;

public interface CardDao extends GenericDao<Card, Long> {
    List<Card> getUserCards(Long id);

    Optional<Card> getByNumber(String number);
}

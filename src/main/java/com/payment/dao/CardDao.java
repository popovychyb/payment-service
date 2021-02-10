package com.payment.dao;

import com.payment.model.Card;
import java.util.List;

public interface CardDao extends GenericDao<Card, Long> {
    List<Card> getUserCards(Long id);
}

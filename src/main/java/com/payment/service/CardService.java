package com.payment.service;

import com.payment.model.Card;

import java.util.List;

public interface CardService extends GenericService<Card, Long> {
    List<Card> getUserCards(Long id);

    void blockCard(Long id);

    void unblockCard(Long id);
}

package com.payment.service.impl;

import com.payment.dao.CardDao;
import com.payment.dao.impl.CardDaoImpl;
import com.payment.model.Card;
import com.payment.model.enums.UserCardStatus;
import com.payment.service.CardService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.random;

public class CardServiceImpl implements CardService {
    private final Long bankCode = 4578L;
    private final Long cardBase = 10000_0000_0000L;
    private final String cardFormat = "%012d";
    private final Integer cardDuration = 2;
    CardDao cardDao = new CardDaoImpl();

    @Override
    public Card create(Card card) {
        card.setNumber(bankCode + String.format(cardFormat, (long) (random() * cardBase)));
        card.setExpiry(LocalDate.now().plusYears(cardDuration));
        return cardDao.create(card);
    }

    @Override
    public Optional<Card> get(Long id) {
        return cardDao.get(id);
    }

    @Override
    public List<Card> getAll() {
        return cardDao.getAll();
    }

    @Override
    public List<Card> getUserCards(Long id) {
        return cardDao.getUserCards(id);
    }

    @Override
    public void blockCard(Long id) {
        Card card = cardDao.get(id).get();
        card.setStatus(UserCardStatus.BLOCKED);
        cardDao.update(card);
    }

    @Override
    public void unblockCard(Long id) {
        Card card = cardDao.get(id).get();
        card.setStatus(UserCardStatus.ACTIVE);
        cardDao.update(card);
    }

    @Override
    public Card update(Card card) {
        return cardDao.update(card);
    }

    @Override
    public boolean delete(Long id) {
        return cardDao.delete(id);
    }
}

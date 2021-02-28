package com.payment.service.impl;

import com.payment.dao.CardDao;
import com.payment.dao.jdbs.CardDaoJdbc;
import com.payment.model.Card;
import com.payment.service.CardService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CardServiceImpl implements CardService {
    private final Long bankCode = 4578L;
    private final Long cardBase = 10000_0000_0000L;
    private final String cardFormat = "%012d";
    private final Integer cardDuration = 2;
    private final CardDao cardDao = new CardDaoJdbc();

    @Override
    public Card create(Card card) {
        card.setNumber(bankCode + String.format(cardFormat, (long) (Math.random() * cardBase)));
//        card.setExpiry(LocalDate.now().plusYears(cardDuration));
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
        card.setActivityStatusId(1L);
        cardDao.update(card);
    }

    @Override
    public void unblockCard(Long id) {
        Card card = cardDao.get(id).get();
        card.setActivityStatusId(0L);
        cardDao.update(card);
    }

    @Override
    public void replenish(Long id, BigDecimal amount) {
        Card card = get(id).get();
        if (card.getBalance() != null) {
            BigDecimal balance = card.getBalance();
            balance = balance.add(amount);
            card.setBalance(balance);
            update(card);
        }
    }

    @Override
    public void deduct(Long id, BigDecimal amount) {
        Card card = get(id).get();
        if (card.getBalance() != null) {
            BigDecimal balance = card.getBalance();
            balance = balance.subtract(amount);
            card.setBalance(balance);
            update(card);
        }
    }

//    @Override
//    public BigDecimal convert(Currency sender, Currency recipient, BigDecimal payment) {
//        return payment.multiply(sender.getConversionRate())
//                .multiply(recipient.getConversionRate());
//    }

    @Override
    public Card update(Card card) {
        return cardDao.update(card);
    }

    @Override
    public boolean delete(Long id) {
        return cardDao.delete(id);
    }
}

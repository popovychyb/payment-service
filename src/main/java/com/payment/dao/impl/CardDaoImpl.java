package com.payment.dao.impl;

import com.payment.dao.CardDao;
import com.payment.db.Storage;
import com.payment.model.Card;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardDaoImpl implements CardDao {
    @Override
    public Card create(Card card) {
        Storage.addCard(card);
        return card;
    }

    @Override
    public Optional<Card> get(Long id) {
        return getAll().stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Card> getUserCards(Long id) {
        return getAll().stream()
                .filter(b -> b.getIdUser().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Card> getAll() {
        return Storage.CARDS;
    }

    @Override
    public Card update(Card card) {
        IntStream.range(0, Storage.CARDS.size())
                .filter(i -> Storage.CARDS.get(i).getId().equals(card.getId()))
                .forEach(i -> Storage.CARDS.set(i, card));
        return card;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.CARDS.removeIf(b -> b.getId().equals(id));
    }
}

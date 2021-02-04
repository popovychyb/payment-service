package com.payment.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, S> {
    T create(T element);

    Optional<T> get(S id);

    List<T> getAll();

    T update(T element);

    boolean delete(S id);
}

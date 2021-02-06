package com.payment.service;

import com.payment.model.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService
        extends GenericService<ShoppingCart, Long> {
    Optional<ShoppingCart> getByUserId(Long userId);
}

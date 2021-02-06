package com.payment.service.impl;

import com.payment.dao.ShoppingCartDao;
import com.payment.dao.impl.ShoppingCartDaoImpl;
import com.payment.model.ShoppingCart;
import com.payment.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        return shoppingCartDao.create(shoppingCart);
    }

    @Override
    public Optional<ShoppingCart> get(Long id) {
        return shoppingCartDao.get(id);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return shoppingCartDao.getAll();
    }

    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        return shoppingCartDao.getByUserId(userId);
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return shoppingCartDao.update(shoppingCart);
    }

    @Override
    public boolean delete(Long id) {
        return shoppingCartDao.delete(id);
    }
}

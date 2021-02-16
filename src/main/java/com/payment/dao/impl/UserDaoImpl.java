package com.payment.dao.impl;

import com.payment.dao.UserDao;
import com.payment.db.Storage;
import com.payment.model.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return getAll().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.USERS;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.USERS.size())
                .filter(i -> Storage.USERS.get(i).getId().equals(user.getId()))
                .forEach(i -> Storage.USERS.set(i, user));
        return user;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.USERS.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Storage.USERS.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }
}

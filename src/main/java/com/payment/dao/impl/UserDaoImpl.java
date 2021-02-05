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
        return Storage.users;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.users.size())
                .filter(i -> Storage.users.get(i).getId().equals(user.getId()))
                .forEach(i -> Storage.users.set(i, user));
        return user;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.users.removeIf(user -> user.getId().equals(id));
    }
}

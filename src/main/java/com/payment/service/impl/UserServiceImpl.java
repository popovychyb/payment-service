package com.payment.service.impl;

import com.payment.dao.UserDao;
import com.payment.dao.impl.UserDaoImpl;
import com.payment.model.User;
import com.payment.model.enums.UserCardStatus;
import com.payment.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public void blockUser(Long id) {
        User user = userDao.get(id).get();
        user.setStatus(UserCardStatus.BLOCKED);
        update(user);
    }

    @Override
    public void unblockUser(Long id) {
        User user = userDao.get(id).get();
        user.setStatus(UserCardStatus.ACTIVE);
        update(user);
    }
}

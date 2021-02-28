package com.payment.service.impl;

import com.payment.dao.UserDao;
import com.payment.dao.jdbs.UserDaoJdbc;
import com.payment.model.User;
import com.payment.model.enums.ActivityStatus;
import com.payment.service.UserService;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJdbc();

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
        user.setActivityStatusId((long) ActivityStatus.valueOf("BLOCKED").ordinal());
        update(user);
    }

    @Override
    public void unblockUser(Long id) {
        User user = userDao.get(id).get();
        user.setActivityStatusId((long) ActivityStatus.valueOf("ACTIVE").ordinal());
        update(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}

package com.payment.dao;

import com.payment.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User, Long> {

    Optional<User> findByEmail(String email);
}

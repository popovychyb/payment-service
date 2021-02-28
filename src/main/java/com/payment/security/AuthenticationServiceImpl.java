package com.payment.security;

import com.payment.exception.AuthenticationException;
import com.payment.model.User;
import com.payment.service.UserService;
import com.payment.service.impl.UserServiceImpl;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService = new UserServiceImpl();

    @Override
    public User login(String email, String password)
            throws AuthenticationException {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new AuthenticationException("Incorrect email or password"));
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new AuthenticationException("Incorrect email or password");
    }
}

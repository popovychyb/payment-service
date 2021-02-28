package com.payment.security;

import com.payment.exception.AuthenticationException;
import com.payment.model.User;

public interface AuthenticationService {
    User login(String email, String password)
            throws AuthenticationException;
}

package com.payment.service;

import com.payment.model.User;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    void blockUser(Long id);

    void unblockUser(Long id);

//    void addAdminRole(Long id);
//
//    void addUserRole(Long id);

    Optional<User> findByEmail(String email);
}

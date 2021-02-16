package com.payment.service;

import com.payment.model.User;

public interface UserService extends GenericService<User, Long> {
    void blockUser(Long id);

    void unblockUser(Long id);

    void raiseToAdmin(Long id);

    void reduceToUser(Long id);
}

package com.payment.model.enums;

import com.payment.model.User;

public enum Role {
    ADMIN,
    CLIENT;

    public static Role getRole(User user) {
        return Role.values()[Math.toIntExact(user.getRoleId())];
    }

    public String getName() {
        return name().toLowerCase();
    }
}

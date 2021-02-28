package com.payment.model.enums;

import com.payment.model.Card;
import com.payment.model.User;

public enum ActivityStatus{
    ACTIVE,
    BLOCKED,
    CONSIDERATION;

    public static ActivityStatus getActivityStatus(User user){
        return ActivityStatus.values()[Math.toIntExact(user.getActivityStatusId())];
    }

    public static ActivityStatus getActivityStatus(Card card){
        return ActivityStatus.values()[Math.toIntExact(card.getActivityStatusId())];
    }
}

package com.ahohlov.util;


import com.ahohlov.dao.model.User;
import com.ahohlov.model.UserPrincipal;

public class UserPrincipalConverter {

    public static UserPrincipal toUserPrincipal(User user) {
        return UserPrincipal.newBuilder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getFirstName() + " " + user.getLastName())
                .role(user.getRole())
                .build();
    }
}

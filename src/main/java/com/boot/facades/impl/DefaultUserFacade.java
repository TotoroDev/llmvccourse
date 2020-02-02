package com.boot.facades.impl;

import com.boot.beans.User;
import com.boot.facades.UserFacade;
import com.boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserFacade implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public User registerUser(final User user) {
        return userService.registerUser(user);
    }
}

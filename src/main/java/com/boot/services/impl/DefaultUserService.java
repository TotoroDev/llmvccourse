package com.boot.services.impl;

import com.boot.beans.User;
import com.boot.repository.UserRepository;
import com.boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(final User user) {
        return userRepository.save(user);
    }
}

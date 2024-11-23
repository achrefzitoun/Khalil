package com.example.back.Services.impl;

import com.example.back.Entites.User;
import com.example.back.Repositories.IUserRepository;
import com.example.back.Services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userServices implements IUserServices {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}

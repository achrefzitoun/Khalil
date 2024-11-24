package com.example.back.Services.impl;

import com.example.back.Entites.User;
import com.example.back.Repositories.IUserRepository;
import com.example.back.Services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<?> recupPassword(String email) {
        User user = userRepository.findUserByEmail(email);

        if (user != null && user.getIdUser() != null) {
            // Send the email here
            return ResponseEntity.status(HttpStatus.FOUND).body("A password reset email has been successfully sent.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("No user is associated with the provided email address. Please check the email and try again.");
    }

}

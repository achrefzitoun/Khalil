package com.example.back.Services;

import com.example.back.Entites.User;
import org.springframework.http.ResponseEntity;

public interface IUserServices {

    User addUser(User user);
    public ResponseEntity<?> recupPassword(String email);
}

package com.example.back.Controllers;

import com.example.back.Entites.User;
import com.example.back.Services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    IUserServices userServices;

    @PostMapping("/addUser")
    void addUser(@RequestBody User user){
        userServices.addUser(user);
    }

}

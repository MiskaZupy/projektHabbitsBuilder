package com.example.projekt.Controller;

import com.example.projekt.Entities.User;
import com.example.projekt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/all")
    public Iterable<User>getAllHabits(){return userService.findAll();}
}

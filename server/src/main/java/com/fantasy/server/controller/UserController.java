package com.fantasy.server.controller;

import com.fantasy.server.service.UserService;
import com.fantasy.server.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
        this.userService = userService;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/post")
    public @ResponseBody String addSingleUser(@RequestBody User user) {
        return userService.postUser(user);
    }
    
}

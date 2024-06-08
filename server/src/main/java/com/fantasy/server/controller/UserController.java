package com.fantasy.server.controller;

import com.fantasy.server.models.User;
import com.fantasy.server.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/findAll")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/users/findOneById")
    public User getOneById(@RequestParam Integer id) {
        User u = userService.getOneById(id);
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @GetMapping("/users/findOneByEmail")
    public User getOneByEmail(@RequestParam String email) {
        User u = userService.getOneByEmail(email);
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @PostMapping("/users/login")
    public boolean userLogIn(@RequestBody User user) {
        User u = userService.checkIfUserExists(user);
        if (u != null) {
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/users/addOne")
    public @ResponseBody String addSingleUser(@RequestBody User user) {
        return userService.postUser(user);
    }
    
}

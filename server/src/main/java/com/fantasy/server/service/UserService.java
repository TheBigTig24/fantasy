package com.fantasy.server.service;

import com.fantasy.server.User;
import com.fantasy.server.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUser() {
        return userRepo.findAll();
    }
    
    public String postUser(User u) {
        userRepo.save(u);
        return "Saved";
    }
}

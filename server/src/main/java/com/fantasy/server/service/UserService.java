package com.fantasy.server.service;

import com.fantasy.server.models.User;
import com.fantasy.server.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public User getOneById(Integer id) {
        User u = new User();
        u.setId(id);
        Example<User> exam = Example.of(u);
        User opt = userRepo.findOne(exam).orElse(null);
        return opt;
    }
    
    public String postUser(User u) {
        userRepo.save(u);
        return "Saved";
    }
}

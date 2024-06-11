package com.fantasy.server.service;

import com.fantasy.server.models.User;
import com.fantasy.server.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
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

    public User getOneByEmail(String email) {
        User u = new User();
        u.setEmail(email);
        User bruh = userRepo.findOneByEmail(email);
        return bruh;
    }

    public User checkIfUserExists(User user) {
        User foundUser = userRepo.findOneByEmail(user.getEmail());
        if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return foundUser;
        } else {
            return null;
        }
    }
    
    public String postUser(User u) {
        String encodedPassword = this.passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        userRepo.save(u);
        return "Saved";
    }
}

package com.fantasy.server.service;

import com.fantasy.server.dataObjects.UserTransfer;
import com.fantasy.server.models.User;
import com.fantasy.server.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Example;
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
        return userRepo.findById(id).orElse(null);
    }

    public User getOneByEmail(String email) {
        User u = userRepo.findOneByEmail(email);
        return u;
    }

    public UserTransfer checkIfUserExists(User user) {
        try {
            User foundUser = userRepo.findOneByEmail(user.getEmail());
            if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
                UserTransfer userTransfer = new UserTransfer(foundUser.getUserId(), foundUser.getUsername());
                return userTransfer;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public UserTransfer checkIfUserExistsByEmail(User user) {
        User foundUser = userRepo.findOneByEmail(user.getEmail());
        if (foundUser == null) {
            return null;
        } else {
            UserTransfer userTransfer = new UserTransfer(foundUser.getUserId(), foundUser.getUsername());
            return userTransfer;
        }
    }

    public UserTransfer checkIfUserExistsByUsername(User user) {
        User foundUser = userRepo.findOneByUsername(user.getUsername());
        if (foundUser == null) {
            return null;
        } else {
            UserTransfer userTransfer = new UserTransfer(foundUser.getUserId(), foundUser.getUsername());
            return userTransfer;
        }
    }
    
    public UserTransfer postUser(User u) {
        String encodedPassword = this.passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        userRepo.save(u);

        UserTransfer userTransfer = new UserTransfer(u.getUserId(), u.getUsername());
        return userTransfer;
    }

    public boolean checkHasMissingParameters(User u) {
        if (u.getEmail() == null || u.getPassword() == null || u.getUsername() == null || u.getCreatedAt() == null) {
            return true;
        } else if (u.getEmail() == "" || u.getPassword() == "" || u.getUsername() == "" || u.getCreatedAt() == null) {
            return true;
        } else {
            return false;
        }
    }

    public UserTransfer deleteUser(User u) {
        userRepo.deleteById(u.getUserId());
        UserTransfer userTransfer = new UserTransfer(u.getUserId(), u.getUsername());
        return userTransfer;
    }
}

package com.fantasy.server.controller;

import com.fantasy.server.dataObjects.ResponseObject;
import com.fantasy.server.dataObjects.UserTransfer;
import com.fantasy.server.models.User;
import com.fantasy.server.service.UserService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
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

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getUser() {
        List<User> allUsers = userService.getUser();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/findOneById")
    public User getOneById(@RequestParam Integer id) {
        User u = userService.getOneById(id);
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @GetMapping("/findOneByEmail")
    public User getOneByEmail(@RequestParam String email) {
        User u = userService.getOneByEmail(email);
        if (u == null) {
            return null;
        } else {
            return u;
        }
    }

    @GetMapping("/emailOnly")
    public ResponseEntity<Map<String, String>> getOnlyEmail(@RequestParam Integer id) {
        try {
            User u = userService.getOneById(id);
            if (u == null) {
                return ResponseEntity.badRequest().body(Map.of("message", "User doesn't exist"));
            } else {
                return ResponseEntity.ok(Map.of("email", u.getEmail()));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Couldn't retrieve user email."));
        }
            
    }
    
    @DeleteMapping("/deleteOneById")
    public @ResponseBody ResponseEntity<ResponseObject<UserTransfer>> deleteSingleUser(@RequestBody User user) {

        ResponseObject<UserTransfer> responseObject = new ResponseObject<UserTransfer>();
        ResponseEntity<ResponseObject<UserTransfer>> responseEntity;
        
        User u1 = userService.getOneById(user.getUserId());
        if (u1 == null) {
            responseObject.setMsg("User was not found.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.NOT_FOUND);
            return responseEntity;
        }

        UserTransfer u = userService.deleteUser(u1);

        responseObject.setData(u);
        responseObject.setMsg("User has been deleted successfully.");
        responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.OK);
        return responseEntity;
    }
}

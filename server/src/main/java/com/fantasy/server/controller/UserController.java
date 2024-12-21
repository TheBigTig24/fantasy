package com.fantasy.server.controller;

import com.fantasy.server.dataObjects.ResponseObject;
import com.fantasy.server.dataObjects.UserTransfer;
import com.fantasy.server.models.User;
import com.fantasy.server.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public @ResponseBody ResponseEntity<ResponseObject<UserTransfer>> userLogIn(@RequestBody User user) {

        ResponseObject<UserTransfer> responseObject = new ResponseObject<UserTransfer>();
        ResponseEntity<ResponseObject<UserTransfer>> responseEntity;

        UserTransfer u = userService.checkIfUserExists(user);
        if (u != null) {
            responseObject.setData(u);
            responseObject.setMsg("Login Successful.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.OK);
            return responseEntity;
        } else {
            responseObject.setMsg("Unable to Log in.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.UNAUTHORIZED);
            return responseEntity;
        }
    }

    @PutMapping("/users/addOne")
    public @ResponseBody ResponseEntity<ResponseObject<UserTransfer>> addSingleUser(@RequestBody User user) {

        ResponseObject<UserTransfer> responseObject = new ResponseObject<UserTransfer>();
        ResponseEntity<ResponseObject<UserTransfer>> responseEntity;
        
        boolean hasMissingParameters = userService.checkHasMissingParameters(user);
        if (hasMissingParameters) {
            responseObject.setMsg("There are missing parameters.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.UNPROCESSABLE_ENTITY);
            return responseEntity;
        }

        UserTransfer foundUserByEmail = userService.checkIfUserExistsByEmail(user);
        if (foundUserByEmail != null) {
            responseObject.setData(foundUserByEmail);
            responseObject.setMsg("Email already exists.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.CONFLICT);
            return responseEntity;
        }

        UserTransfer foundUserByUsername = userService.checkIfUserExistsByUsername(user);
        if (foundUserByUsername != null) {
            responseObject.setData(foundUserByUsername);
            responseObject.setMsg("Username already exists.");
            responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.CONFLICT);
            return responseEntity;
        }

        UserTransfer response = userService.postUser(user);

        responseObject.setData(response);
        responseObject.setMsg("User was created successfully.");
        responseEntity = new ResponseEntity<ResponseObject<UserTransfer>>(responseObject, HttpStatus.CREATED);
        
        return responseEntity;
    }
    
    @DeleteMapping("users/deleteOneById")
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

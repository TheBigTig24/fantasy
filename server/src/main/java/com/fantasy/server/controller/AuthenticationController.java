package com.fantasy.server.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.server.dataObjects.LoginUserDto;
import com.fantasy.server.dataObjects.RegisterUserDto;
import com.fantasy.server.dataObjects.VerifyUserDto;
import com.fantasy.server.models.User;
import com.fantasy.server.reponses.LoginResponse;
import com.fantasy.server.service.AuthenticationService2;
import com.fantasy.server.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService2 authenticationService2;

    public AuthenticationController(JwtService jwtService, AuthenticationService2 authenticationService2) {
        this.jwtService = jwtService;
        this.authenticationService2 = authenticationService2;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) {
        try{
            // check for missing parameters
            boolean hasMissingParameters = authenticationService2.checkHasMissingParameters(registerUserDto);
            if (hasMissingParameters) {
                return ResponseEntity.badRequest().body("Missing parameters.");
            }

            // sign up user 
            User registeredUser = authenticationService2.signup(registerUserDto);
            if (registeredUser == null) {
                return ResponseEntity.badRequest().body("User already exists.");
            }
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().body(rte.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService2.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            authenticationService2.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Account verified successfully.");
        } catch(RuntimeException rte) {
            return ResponseEntity.badRequest().body(rte.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            authenticationService2.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent.");
        } catch(RuntimeException rte) {
            return ResponseEntity.badRequest().body(rte.getMessage());
        }
    }
}

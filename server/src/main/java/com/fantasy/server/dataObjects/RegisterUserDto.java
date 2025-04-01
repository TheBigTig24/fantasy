package com.fantasy.server.dataObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    
    private String email;
    private String password;
    private String username;
}

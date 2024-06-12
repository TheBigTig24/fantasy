package com.fantasy.server.dataObjects;

public class UserTransfer {
    
    private int userId;
    private String username;

    public UserTransfer() {}

    public UserTransfer(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

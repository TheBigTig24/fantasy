package com.fantasy.server.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "createdAt")
    private String createdAt;

    @Column
    @OneToMany(mappedBy = "user")
    private Set<ServerRank> playerServers;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(int userId, String email, String username, String password, String createdAt, Set<ServerRank> playerServers) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.playerServers = playerServers;
    }

    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<ServerRank> getServers() {
        return playerServers;
    }

    public void setPlayerServers(Set<ServerRank> playerServers) {
        this.playerServers = playerServers;
    }

    // just for testing purposes for now
    public String toString() {
        return "userId: " + this.userId + ", email: " + this.email + ", username: " + this.username;
    }

}

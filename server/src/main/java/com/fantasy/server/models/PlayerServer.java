package com.fantasy.server.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PlayerServers")
@SecondaryTable(name = "Settings", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ServerID"))
public class PlayerServer {
    
    @Id
    @Column(name = "serverId")
    private int serverId;

    @Column
    @ManyToMany
    @JoinTable(name = "user_to_servers", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "server_id"))
    private Set<User> users;

    @Embedded
    @Column
    private Setting settings;

    @Column(name = "accessCode")
    private String accessCode;

    public PlayerServer() {}

    public PlayerServer(int serverId, Set<User> users, Setting settings, String accessCode) {
        this.serverId = serverId;
        this.users = users;
        this.settings = settings;
        this.accessCode = accessCode;
    }


    public int getServerId() {
        return this.serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Setting getSettings() {
        return this.settings;
    }

    public void setSettings(Setting settings) {
        this.settings = settings;
    }

    public String getAccessCode() {
        return this.accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

}

package com.fantasy.server.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Servers")
@SecondaryTable(name = "Settings", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ServerID"))
public class PlayerServer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serverId")
    private int serverId;

    @OneToMany(mappedBy = "playerServer")
    private Set<ServerRank> users;

    @Embedded
    @Column
    private Setting settings;

    @Column(name = "accessCode")
    private String accessCode;

    public PlayerServer() {}

    public PlayerServer(int serverId, Set<ServerRank> users, Setting settings, String accessCode) {
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

    public Set<ServerRank> getUsers() {
        return this.users;
    }

    public void setUsers(Set<ServerRank> users) {
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

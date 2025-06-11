package com.fantasy.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "Roles")
@Getter
@Setter
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "abbreviation", nullable = false, length = 10)
    private String abbreviation;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Esport sportId;

    public Role() {}

    public Role(String name, String abbreviation, Esport sportId) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.sportId = sportId;
    }
}

package com.fantasy.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "Esport")
@Getter
@Setter
public class Esport {
    
    @Id
    @GeneratedValue()
    @Column(name = "sport_id")
    private int sport_id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "abbreviation", nullable = false, length = 10)
    private String abbreviation;

    public Esport() {}

    public Esport(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}

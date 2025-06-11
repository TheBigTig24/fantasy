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
@Table(name = "RealTeam")
@Getter
@Setter
public class RealTeam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rteam_id")
    private Integer rteam_id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "abbreviation", nullable = false, length = 10)
    private String abbreviation;

    @ManyToOne
    @JoinColumn(name = "rleague_id", nullable = false)
    private RealLeague rleagueId;

    public RealTeam() {}

    public RealTeam(String name, String abbreviation, RealLeague rleagueId) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.rleagueId = rleagueId;
    }
}

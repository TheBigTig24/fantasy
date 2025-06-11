package com.fantasy.server.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "FantasyLeagues")
@SecondaryTable(name = "Settings", pkJoinColumns = @PrimaryKeyJoinColumn(name = "league_id"))
@Getter
@Setter
public class FantasyLeague {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
    private Integer leagueId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Embedded
    @Column
    private Setting settings;

    @Column(name = "accessCode", length = 25)
    private String accessCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "commissioner_user_id", nullable = false)
    private int commissionerId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "current_week", nullable = false)
    private int currentWeek;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Esport sportId;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season seasonId;

    public FantasyLeague() {}

    public FantasyLeague(int leagueId, String name, Setting settings, String accessCode, LocalDateTime createdAt) {
        this.leagueId = leagueId;
        this.name = name;
        this.settings = settings;
        this.accessCode = accessCode;
        this.createdAt = createdAt;
    }

}

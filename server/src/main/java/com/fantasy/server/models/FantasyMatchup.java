package com.fantasy.server.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "FantasyMatchups")
@Getter
@Setter
@AllArgsConstructor
public class FantasyMatchup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchup_id")
    private Integer matchupId;

    @ManyToOne
    @JoinColumn(name = "fantasy_league_id", nullable = false)
    private int fleagueId;

    @Column(name = "week_number", nullable = false)
    private int weekNumber;

    @ManyToOne
    @JoinColumn(name = "team1_id", nullable = false)
    private int team1Id;

    @ManyToOne
    @JoinColumn(name = "team2_id", nullable = false)
    private int team2Id;

    @Column(name = "team1_score", nullable = false)
    private float team1Score;

    @Column(name = "team2_score", nullable = false)
    private float team2Score;

    @ManyToOne
    @JoinColumn(name = "winner_team_id", nullable = false)
    private int winnerId;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    public FantasyMatchup() {}

}

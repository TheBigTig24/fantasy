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
@Table(name = "FantasyTeamWeeklyScores")
@Getter
@Setter
public class FantasyTeamWeeklyScore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wscores_id")
    private Integer wscoresId;

    @ManyToOne
    @JoinColumn(name = "fteam_id", nullable = false)
    private FantasyTeam fteamId;

    @Column(name = "week_num", nullable = false)
    private int weekNumber;

    @Column(name = "weekly_score", nullable = false)
    private float weeklyScore;

    public FantasyTeamWeeklyScore() {}

    public FantasyTeamWeeklyScore(FantasyTeam fteamId, int weekNumber, float weeklyScore) {
        this.fteamId = fteamId;
        this.weekNumber = weekNumber;
        this.weeklyScore = weeklyScore;
    }
}

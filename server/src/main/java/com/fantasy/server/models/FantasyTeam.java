package com.fantasy.server.models;

import java.time.LocalDateTime;

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
@Getter
@Setter
@Table(name = "FantasyTeams")
@AllArgsConstructor
public class FantasyTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "total_points", nullable = false)
    private float totalPoints;

    @Column(name = "current_rank", nullable = false)
    private int currentRank;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User ownerId;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    private RealLeague leagueId;

    @Column(name = "wins", nullable = false)
    private int wins;

    @Column(name = "losses", nullable = false)
    private int losses;

    @Column(name = "ties", nullable = false)
    private int ties;

    @Column(name = "draft_position", nullable = false)
    private int draftPosition;

    @Column(name = "draft_time", nullable = false)
    private LocalDateTime draftTime;

    @Column(name = "starters_filled", nullable = false)
    private int startersFilled;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_lineup_change", nullable = false)
    private LocalDateTime lastLineupChange;

    public FantasyTeam() {}

}

package com.fantasy.server.models;

import java.util.Date;

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
@Table(name = "Season")
@Getter
@Setter
public class Season {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private Integer seasonId;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    private Esport sportId;

    public Season() {}

    public Season(int year, Date startDate, Date endDate, Esport sportId) {
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sportId = sportId;
    }
}

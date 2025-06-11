package com.fantasy.server.dataObjects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LeagueTransfer {
    
    private int leagueId;
    private String name;

    public LeagueTransfer() {};

    public LeagueTransfer(int leagueId, String name) {
        this.leagueId = leagueId;
        this.name = name;
    }
}

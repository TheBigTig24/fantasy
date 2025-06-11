package com.fantasy.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasy.server.dataObjects.LeagueTransfer;
import com.fantasy.server.models.FantasyLeague;
import com.fantasy.server.repository.FantasyLeagueRepository;

@Service
public class FantasyLeagueService {

    @Autowired
    private FantasyLeagueRepository fantasyLeagueRepository;

    public FantasyLeagueService(FantasyLeagueRepository fantasyLeagueRepository) {
        this.fantasyLeagueRepository = fantasyLeagueRepository;
    }

    /*
     * @param PlayerServer object
     * @return ServerTransfer obj containing id and name of server 
     */
    public LeagueTransfer createServer(FantasyLeague ps) {
        try {
            fantasyLeagueRepository.save(ps);
            LeagueTransfer serverTransfer = new LeagueTransfer(ps.getLeagueId(), ps.getName());
            return serverTransfer;
        } catch (Exception e) {
            LeagueTransfer serverTransfer = null;
            return serverTransfer;
        }
    }
    
}

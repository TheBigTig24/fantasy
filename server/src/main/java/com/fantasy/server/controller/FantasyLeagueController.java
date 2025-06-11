package com.fantasy.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.server.dataObjects.LeagueTransfer;
import com.fantasy.server.models.FantasyLeague;
import com.fantasy.server.service.FantasyLeagueService;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/servers")
@RestController
public class FantasyLeagueController {
    
    @Autowired
    private FantasyLeagueService fantasyLeagueService;

    public FantasyLeagueController() {}

    @Autowired
    public FantasyLeagueController(FantasyLeagueService fantasyLeagueService) {
        this.fantasyLeagueService = fantasyLeagueService;
    }

    @PostMapping("/createServer")
    public ResponseEntity<?> createServer(@RequestBody FantasyLeague ps) {
        try {
            LeagueTransfer st = fantasyLeagueService.createServer(ps);
            if (st == null) {
                return ResponseEntity.badRequest().body("Bad Request.");
            } else {
                return ResponseEntity.ok().body(st.getName() + " has been successfully created.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal Server Error.");
        }
    }
}

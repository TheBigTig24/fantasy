package com.fantasy.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fantasy.server.models.FantasyLeague;

@Repository
public interface FantasyLeagueRepository extends JpaRepository<FantasyLeague, Integer> {
    
}

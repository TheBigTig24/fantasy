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

@Entity
@Data
@Table(name = "ServerRank")
public class ServerRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rankingId")
    private int rankingId;

    @ManyToOne
    @JoinColumn(name = "Users_userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Servers_serverId")
    private PlayerServer playerServer;

    @Column(name = "ranking")
    private int ranking;

    public ServerRank() {}

    public ServerRank(int rankingId, User user, PlayerServer playerServer, int ranking) {
        this.rankingId = rankingId;
        this.user = user;
        this.playerServer = playerServer;
        this.ranking = ranking;
    }


}

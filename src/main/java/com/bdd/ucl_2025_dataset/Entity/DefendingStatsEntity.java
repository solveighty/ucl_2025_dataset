package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "defending_stats")
public class DefendingStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @Column(name = "balls_recovered")
    private Integer ballsRecovered;

    private Integer tackles;

    @Column(name = "tackles_won")
    private Integer tacklesWon;

    @Column(name = "tackles_lost")
    private Integer tacklesLost;

    @Column(name = "clearance_attempted")
    private Integer clearanceAttempted;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public Integer getBallsRecovered() {
        return ballsRecovered;
    }

    public void setBallsRecovered(Integer ballsRecovered) {
        this.ballsRecovered = ballsRecovered;
    }

    public Integer getTackles() {
        return tackles;
    }

    public void setTackles(Integer tackles) {
        this.tackles = tackles;
    }

    public Integer getTacklesWon() {
        return tacklesWon;
    }

    public void setTacklesWon(Integer tacklesWon) {
        this.tacklesWon = tacklesWon;
    }

    public Integer getTacklesLost() {
        return tacklesLost;
    }

    public void setTacklesLost(Integer tacklesLost) {
        this.tacklesLost = tacklesLost;
    }

    public Integer getClearanceAttempted() {
        return clearanceAttempted;
    }

    public void setClearanceAttempted(Integer clearanceAttempted) {
        this.clearanceAttempted = clearanceAttempted;
    }
}

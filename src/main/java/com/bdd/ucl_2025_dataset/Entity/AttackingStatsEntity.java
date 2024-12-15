package com.bdd.ucl_2025_dataset.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "attacking_stats")
public class AttackingStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    private Integer assists;

    @Column(name = "corners_taken")
    private Integer cornersTaken;

    private Integer offsides;
    private Integer dribbles;

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

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getCornersTaken() {
        return cornersTaken;
    }

    public void setCornersTaken(Integer cornersTaken) {
        this.cornersTaken = cornersTaken;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getDribbles() {
        return dribbles;
    }

    public void setDribbles(Integer dribbles) {
        this.dribbles = dribbles;
    }
}

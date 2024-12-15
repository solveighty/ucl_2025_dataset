package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "key_stats")
public class KeyStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @Column(name = "distance_covered")
    private Float distanceCovered;

    @Column(name = "top_speed")
    private Float topSpeed;

    @Column(name = "minutes_played")
    private Integer minutesPlayed;

    @Column(name = "matches_appearance")
    private Integer matchesAppearance;

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

    public Float getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(Float distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    public Float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getMatchesAppearance() {
        return matchesAppearance;
    }

    public void setMatchesAppearance(Integer matchesAppearance) {
        this.matchesAppearance = matchesAppearance;
    }
}

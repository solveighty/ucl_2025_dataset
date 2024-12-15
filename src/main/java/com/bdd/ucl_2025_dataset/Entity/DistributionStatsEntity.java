package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "distribution_stats")
public class DistributionStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @Column(name = "passing_accuracy")
    private Float passingAccuracy;

    @Column(name = "passes_attempted")
    private Integer passesAttempted;

    @Column(name = "passes_completed")
    private Integer passesCompleted;

    @Column(name = "crossing_accuracy")
    private Float crossingAccuracy;

    @Column(name = "crosses_attempted")
    private Integer crossesAttempted;

    @Column(name = "crosses_completed")
    private Integer crossesCompleted;

    @Column(name = "free_kick_taken")
    private Integer freeKickTaken;

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

    public Float getPassingAccuracy() {
        return passingAccuracy;
    }

    public void setPassingAccuracy(Float passingAccuracy) {
        this.passingAccuracy = passingAccuracy;
    }

    public Integer getPassesAttempted() {
        return passesAttempted;
    }

    public void setPassesAttempted(Integer passesAttempted) {
        this.passesAttempted = passesAttempted;
    }

    public Integer getPassesCompleted() {
        return passesCompleted;
    }

    public void setPassesCompleted(Integer passesCompleted) {
        this.passesCompleted = passesCompleted;
    }

    public Float getCrossingAccuracy() {
        return crossingAccuracy;
    }

    public void setCrossingAccuracy(Float crossingAccuracy) {
        this.crossingAccuracy = crossingAccuracy;
    }

    public Integer getCrossesAttempted() {
        return crossesAttempted;
    }

    public void setCrossesAttempted(Integer crossesAttempted) {
        this.crossesAttempted = crossesAttempted;
    }

    public Integer getCrossesCompleted() {
        return crossesCompleted;
    }

    public void setCrossesCompleted(Integer crossesCompleted) {
        this.crossesCompleted = crossesCompleted;
    }

    public Integer getFreeKickTaken() {
        return freeKickTaken;
    }

    public void setFreeKickTaken(Integer freeKickTaken) {
        this.freeKickTaken = freeKickTaken;
    }

    public Integer getMatchesAppearance() {
        return matchesAppearance;
    }

    public void setMatchesAppearance(Integer matchesAppearance) {
        this.matchesAppearance = matchesAppearance;
    }
}

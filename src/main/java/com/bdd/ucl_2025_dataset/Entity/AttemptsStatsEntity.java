package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attempts_stats")
public class AttemptsStatsEntity {

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @Column(name = "total_attempts")
    private Integer totalAttempts;

    @Column(name = "attempts_on_target")
    private Integer attemptsOnTarget;

    @Column(name = "attempts_off_target")
    private Integer attemptsOffTarget;

    private Integer blocked;

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

    public Integer getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(Integer totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    public Integer getAttemptsOnTarget() {
        return attemptsOnTarget;
    }

    public void setAttemptsOnTarget(Integer attemptsOnTarget) {
        this.attemptsOnTarget = attemptsOnTarget;
    }

    public Integer getAttemptsOffTarget() {
        return attemptsOffTarget;
    }

    public void setAttemptsOffTarget(Integer attemptsOffTarget) {
        this.attemptsOffTarget = attemptsOffTarget;
    }

    public Integer getBlocked() {
        return blocked;
    }

    public void setBlocked(Integer blocked) {
        this.blocked = blocked;
    }
}

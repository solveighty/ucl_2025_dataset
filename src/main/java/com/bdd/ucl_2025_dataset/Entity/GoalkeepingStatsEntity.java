package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "goalkeeping_stats")
public class GoalkeepingStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    private Integer saves;

    @Column(name = "goals_conceded")
    private Integer goalsConceded;

    @Column(name = "saves_on_penalty")
    private Integer savesOnPenalty;

    @Column(name = "clean_sheets")
    private Integer cleanSheets;

    @Column(name = "punches_made")
    private Integer punchesMade;

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

    public Integer getSaves() {
        return saves;
    }

    public void setSaves(Integer saves) {
        this.saves = saves;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public Integer getSavesOnPenalty() {
        return savesOnPenalty;
    }

    public void setSavesOnPenalty(Integer savesOnPenalty) {
        this.savesOnPenalty = savesOnPenalty;
    }

    public Integer getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(Integer cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public Integer getPunchesMade() {
        return punchesMade;
    }

    public void setPunchesMade(Integer punchesMade) {
        this.punchesMade = punchesMade;
    }
}

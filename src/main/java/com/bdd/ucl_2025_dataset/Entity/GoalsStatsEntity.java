package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "goals_stats")
public class GoalsStatsEntity {
    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    private Integer goals;

    @Column(name = "inside_area")
    private Integer insideArea;

    @Column(name = "outside_area")
    private Integer outsideArea;

    @Column(name = "right_foot")
    private Integer rightFoot;

    @Column(name = "left_foot")
    private Integer leftFoot;

    private Integer head;
    private Integer other;

    @Column(name = "penalties_scored")
    private Integer penaltiesScored;

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

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getInsideArea() {
        return insideArea;
    }

    public void setInsideArea(Integer insideArea) {
        this.insideArea = insideArea;
    }

    public Integer getOutsideArea() {
        return outsideArea;
    }

    public void setOutsideArea(Integer outsideArea) {
        this.outsideArea = outsideArea;
    }

    public Integer getRightFoot() {
        return rightFoot;
    }

    public void setRightFoot(Integer rightFoot) {
        this.rightFoot = rightFoot;
    }

    public Integer getLeftFoot() {
        return leftFoot;
    }

    public void setLeftFoot(Integer leftFoot) {
        this.leftFoot = leftFoot;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public Integer getPenaltiesScored() {
        return penaltiesScored;
    }

    public void setPenaltiesScored(Integer penaltiesScored) {
        this.penaltiesScored = penaltiesScored;
    }
}

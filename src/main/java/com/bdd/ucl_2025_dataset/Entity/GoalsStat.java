package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "goals_stats")
public class GoalsStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "inside_area")
    private Integer insideArea;

    @Column(name = "outside_area")
    private Integer outsideArea;

    @Column(name = "right_foot")
    private Integer rightFoot;

    @Column(name = "left_foot")
    private Integer leftFoot;

    @Column(name = "head")
    private Integer head;

    @Column(name = "other")
    private Integer other;

    @Column(name = "penalties_scored")
    private Integer penaltiesScored;

}
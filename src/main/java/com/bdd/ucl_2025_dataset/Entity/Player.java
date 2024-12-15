package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @Column(name = "player_name", nullable = false, length = 80)
    private String playerName;

    @Column(name = "nationality", length = 30)
    private String nationality;

    @Column(name = "field_position", length = 25)
    private String fieldPosition;

    @Column(name = "position", length = 30)
    private String position;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "photo_url", length = 105)
    private String photoUrl;

    @OneToOne(mappedBy = "player")
    private AttackingStat attackingStat;

    @OneToOne(mappedBy = "player")
    private AttemptsStat attemptsStat;

    @OneToOne(mappedBy = "player")
    private DefendingStat defendingStat;

    @OneToOne(mappedBy = "player")
    private DisciplinaryStat disciplinaryStat;

    @OneToOne(mappedBy = "player")
    private DistributionStat distributionStat;

    @OneToOne(mappedBy = "player")
    private GoalkeepingStat goalkeepingStat;

    @OneToOne(mappedBy = "player")
    private GoalsStat goalsStat;

    @OneToOne(mappedBy = "player")
    private KeyStat keyStat;

}
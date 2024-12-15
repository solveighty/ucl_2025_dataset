package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attacking_stats")
public class AttackingStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player players;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "corners_taken")
    private Integer cornersTaken;

    @Column(name = "offsides")
    private Integer offsides;

    @Column(name = "dribbles")
    private Integer dribbles;

}
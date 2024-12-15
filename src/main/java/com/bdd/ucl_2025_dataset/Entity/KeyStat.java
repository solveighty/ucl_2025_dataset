package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "key_stats")
public class KeyStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player players;

    @Column(name = "distance_covered")
    private Float distanceCovered;

    @Column(name = "top_speed")
    private Float topSpeed;

    @Column(name = "minutes_played")
    private Integer minutesPlayed;

    @Column(name = "matches_appearance")
    private Integer matchesAppearance;

}
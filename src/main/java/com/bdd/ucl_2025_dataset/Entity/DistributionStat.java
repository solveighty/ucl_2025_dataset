package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "distribution_stats")
public class DistributionStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

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

}
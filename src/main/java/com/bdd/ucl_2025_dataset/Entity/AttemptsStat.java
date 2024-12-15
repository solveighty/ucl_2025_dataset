package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attempts_stats")
public class AttemptsStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "total_attempts")
    private Integer totalAttempts;

    @Column(name = "attempts_on_target")
    private Integer attemptsOnTarget;

    @Column(name = "attempts_off_target")
    private Integer attemptsOffTarget;

    @Column(name = "blocked")
    private Integer blocked;

}
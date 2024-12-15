package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "goalkeeping_stats")
public class GoalkeepingStat {
    @Id
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "saves")
    private Integer saves;

    @Column(name = "goals_conceded")
    private Integer goalsConceded;

    @Column(name = "saves_on_penalty")
    private Integer savesOnPenalty;

    @Column(name = "clean_sheets")
    private Integer cleanSheets;

    @Column(name = "punches_made")
    private Integer punchesMade;

}
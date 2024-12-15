package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @Column(name = "team_id", nullable = false)
    private Integer id;

    @Column(name = "country", nullable = false, length = 14)
    private String country;

    @Column(name = "team", nullable = false, length = 30)
    private String team;

    @Column(name = "logo", nullable = false, length = 105)
    private String logo;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new LinkedHashSet<>();

}
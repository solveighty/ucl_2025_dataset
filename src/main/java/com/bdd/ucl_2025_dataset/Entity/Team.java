package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
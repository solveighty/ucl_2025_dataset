package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class TeamEntity {
    @Id
    @Column(name = "team_id")
    private Integer teamId;

    private String country;
    private String team;
    private String logo;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<PlayerEntity> players;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}

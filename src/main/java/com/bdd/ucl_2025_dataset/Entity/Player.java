package com.bdd.ucl_2025_dataset.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(String fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public AttackingStat getAttackingStat() {
        return attackingStat;
    }

    public void setAttackingStat(AttackingStat attackingStat) {
        this.attackingStat = attackingStat;
    }

    public AttemptsStat getAttemptsStat() {
        return attemptsStat;
    }

    public void setAttemptsStat(AttemptsStat attemptsStat) {
        this.attemptsStat = attemptsStat;
    }

    public DefendingStat getDefendingStat() {
        return defendingStat;
    }

    public void setDefendingStat(DefendingStat defendingStat) {
        this.defendingStat = defendingStat;
    }

    public DisciplinaryStat getDisciplinaryStat() {
        return disciplinaryStat;
    }

    public void setDisciplinaryStat(DisciplinaryStat disciplinaryStat) {
        this.disciplinaryStat = disciplinaryStat;
    }

    public DistributionStat getDistributionStat() {
        return distributionStat;
    }

    public void setDistributionStat(DistributionStat distributionStat) {
        this.distributionStat = distributionStat;
    }

    public GoalkeepingStat getGoalkeepingStat() {
        return goalkeepingStat;
    }

    public void setGoalkeepingStat(GoalkeepingStat goalkeepingStat) {
        this.goalkeepingStat = goalkeepingStat;
    }

    public GoalsStat getGoalsStat() {
        return goalsStat;
    }

    public void setGoalsStat(GoalsStat goalsStat) {
        this.goalsStat = goalsStat;
    }

    public KeyStat getKeyStat() {
        return keyStat;
    }

    public void setKeyStat(KeyStat keyStat) {
        this.keyStat = keyStat;
    }
}
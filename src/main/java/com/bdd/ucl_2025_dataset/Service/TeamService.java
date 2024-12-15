package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.TeamEntity;
import com.bdd.ucl_2025_dataset.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<TeamEntity> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<TeamEntity> getTeamById(int id) {
        return teamRepository.findById(id);
    }

    public TeamEntity saveTeam(TeamEntity team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}

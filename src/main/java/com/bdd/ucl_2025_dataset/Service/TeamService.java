package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.Team;
import com.bdd.ucl_2025_dataset.Repository.TeamRepository;
import com.bdd.ucl_2025_dataset.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    // Obtener todos los equipos
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Obtener un equipo por su ID
    public Optional<Team> getTeamById(Integer teamId) {
        return teamRepository.findById(teamId);
    }

    // Crear un nuevo equipo (solo si el usuario es admin)
    @Transactional
    public Team createTeam(Team team, Integer userId) {
        if (!userService.isAdmin(userId)) {
            throw new RuntimeException("No tiene permisos para crear un equipo");
        }
        return teamRepository.save(team);
    }

    // Actualizar un equipo (solo si el usuario es admin)
    @Transactional
    public Team updateTeam(Team team, Integer userId) {
        if (!userService.isAdmin(userId)) {
            throw new RuntimeException("No tiene permisos para actualizar un equipo");
        }
        return teamRepository.save(team);
    }

    // Eliminar un equipo (solo si el usuario es admin)
    @Transactional
    public void deleteTeam(Integer teamId, Integer userId) {
        if (!userService.isAdmin(userId)) {
            throw new RuntimeException("No tiene permisos para eliminar un equipo");
        }
        teamRepository.deleteById(teamId);
    }
}

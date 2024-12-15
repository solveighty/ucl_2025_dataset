package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.Team;
import com.bdd.ucl_2025_dataset.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    // Obtener todos los equipos
    @GetMapping
    public ResponseEntity<Iterable<Team>> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    // Obtener un equipo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo equipo (solo si es admin)
    @PostMapping("/crear")
    public ResponseEntity<Team> createTeam(@RequestBody Team team, @RequestParam Integer userId) {
        try {
            Team createdTeam = teamService.createTeam(team, userId);
            return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // 403 Forbidden
        }
    }

    // Actualizar un equipo (solo si es admin)
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Integer id, @RequestBody Team team, @RequestParam Integer userId) {
        team.setId(id);  // Asegurarse de que el equipo que se pasa tiene el ID correcto
        try {
            Team updatedTeam = teamService.updateTeam(team, userId);
            return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // 403 Forbidden
        }
    }

    // Eliminar un equipo (solo si es admin)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id, @RequestParam Integer userId) {
        try {
            teamService.deleteTeam(id, userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // 403 Forbidden
        }
    }
}

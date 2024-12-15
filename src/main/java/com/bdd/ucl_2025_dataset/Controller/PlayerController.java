package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.Player;
import com.bdd.ucl_2025_dataset.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    // Obtener todos los jugadores
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Integer id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un jugador (solo admin)
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player, @RequestParam Integer userId) {
        try {
            Player createdPlayer = playerService.createPlayer(player, userId);
            return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        } catch (SecurityException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // Responder con 403 si no es admin
        }
    }

    // Editar un jugador (solo admin)
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player, @RequestParam Integer userId) {
        try {
            Player updatedPlayer = playerService.updatePlayer(id, player, userId);
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } catch (SecurityException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // Responder con 403 si no es admin
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Responder con 404 si no se encuentra el jugador
        }
    }

    // Eliminar un jugador (solo admin)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id, @RequestParam Integer userId) {
        try {
            playerService.deletePlayer(id, userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SecurityException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);  // Responder con 403 si no es admin
        }
    }
}

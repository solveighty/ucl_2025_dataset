package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.KeyStatsEntity;
import com.bdd.ucl_2025_dataset.Service.KeyStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/key-stats")
public class KeyStatsController {
    @Autowired
    private KeyStatsService keyStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<KeyStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<KeyStatsEntity> stats = keyStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public KeyStatsEntity saveStats(@RequestBody KeyStatsEntity stats) {
        return keyStatsService.saveStats(stats);
    }
}

package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.AttemptsStatsEntity;
import com.bdd.ucl_2025_dataset.Service.AttemptsStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/attempts-stats")
public class AttemptsStatsController {
    @Autowired
    private AttemptsStatsService attemptsStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<AttemptsStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<AttemptsStatsEntity> stats = attemptsStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AttemptsStatsEntity saveStats(@RequestBody AttemptsStatsEntity stats) {
        return attemptsStatsService.saveStats(stats);
    }
}

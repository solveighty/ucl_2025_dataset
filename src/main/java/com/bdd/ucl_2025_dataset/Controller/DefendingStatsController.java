package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.DefendingStatsEntity;
import com.bdd.ucl_2025_dataset.Service.DefendingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/defending-stats")
public class DefendingStatsController {
    @Autowired
    private DefendingStatsService defendingStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<DefendingStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<DefendingStatsEntity> stats = defendingStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DefendingStatsEntity saveStats(@RequestBody DefendingStatsEntity stats) {
        return defendingStatsService.saveStats(stats);
    }
}

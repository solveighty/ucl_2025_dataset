package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.GoalsStatsEntity;
import com.bdd.ucl_2025_dataset.Service.GoalsStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/goals-stats")
public class GoalsStatsController {
    @Autowired
    private GoalsStatsService goalsStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<GoalsStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<GoalsStatsEntity> stats = goalsStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GoalsStatsEntity saveStats(@RequestBody GoalsStatsEntity stats) {
        return goalsStatsService.saveStats(stats);
    }
}

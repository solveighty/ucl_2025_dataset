package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.GoalkeepingStatsEntity;
import com.bdd.ucl_2025_dataset.Service.GoalkeepingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/goalkeeping-stats")
public class GoalkeepingStatsController {
    @Autowired
    private GoalkeepingStatsService goalkeepingStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<GoalkeepingStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<GoalkeepingStatsEntity> stats = goalkeepingStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GoalkeepingStatsEntity saveStats(@RequestBody GoalkeepingStatsEntity stats) {
        return goalkeepingStatsService.saveStats(stats);
    }
}

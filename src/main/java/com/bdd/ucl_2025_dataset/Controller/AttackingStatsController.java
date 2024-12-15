package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.AttackingStatsEntity;
import com.bdd.ucl_2025_dataset.Service.AttackingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/attacking-stats")
public class AttackingStatsController {
    @Autowired
    private AttackingStatsService attackingStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<AttackingStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<AttackingStatsEntity> stats = attackingStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AttackingStatsEntity saveStats(@RequestBody AttackingStatsEntity stats) {
        return attackingStatsService.saveStats(stats);
    }
}

package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.DistributionStatsEntity;
import com.bdd.ucl_2025_dataset.Service.DistributionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/distribution-stats")
public class DistributionStatsController {
    @Autowired
    private DistributionStatsService distributionStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<DistributionStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<DistributionStatsEntity> stats = distributionStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DistributionStatsEntity saveStats(@RequestBody DistributionStatsEntity stats) {
        return distributionStatsService.saveStats(stats);
    }
}

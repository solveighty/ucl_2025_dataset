package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.DisciplinaryStatsEntity;
import com.bdd.ucl_2025_dataset.Service.DisciplinaryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/disciplinary-stats")
public class DisciplinaryStatsController {
    @Autowired
    private DisciplinaryStatsService disciplinaryStatsService;

    @GetMapping("/{playerId}")
    public ResponseEntity<DisciplinaryStatsEntity> getStatsByPlayerId(@PathVariable int playerId) {
        Optional<DisciplinaryStatsEntity> stats = disciplinaryStatsService.getStatsByPlayerId(playerId);
        return stats.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DisciplinaryStatsEntity saveStats(@RequestBody DisciplinaryStatsEntity stats) {
        return disciplinaryStatsService.saveStats(stats);
    }
}

package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.GoalsStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.GoalsStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoalsStatsService {
    @Autowired
    private GoalsStatsRepository goalsStatsRepository;

    public Optional<GoalsStatsEntity> getStatsByPlayerId(int id) {
        return goalsStatsRepository.findById(id);
    }

    public GoalsStatsEntity saveStats(GoalsStatsEntity stats) {
        return goalsStatsRepository.save(stats);
    }
}

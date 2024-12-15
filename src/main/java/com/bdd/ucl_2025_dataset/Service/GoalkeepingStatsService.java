package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.GoalkeepingStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.GoalkeepingStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoalkeepingStatsService {
    @Autowired
    private GoalkeepingStatsRepository goalkeepingStatsRepository;

    public Optional<GoalkeepingStatsEntity> getStatsByPlayerId(int id) {
        return goalkeepingStatsRepository.findById(id);
    }

    public GoalkeepingStatsEntity saveStats(GoalkeepingStatsEntity stats) {
        return goalkeepingStatsRepository.save(stats);
    }
}

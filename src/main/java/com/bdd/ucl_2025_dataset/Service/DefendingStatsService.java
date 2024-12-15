package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.DefendingStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.DefendingStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefendingStatsService {
    @Autowired
    private DefendingStatsRepository defendingStatsRepository;

    public Optional<DefendingStatsEntity> getStatsByPlayerId(int id) {
        return defendingStatsRepository.findById(id);
    }

    public DefendingStatsEntity saveStats(DefendingStatsEntity stats) {
        return defendingStatsRepository.save(stats);
    }
}

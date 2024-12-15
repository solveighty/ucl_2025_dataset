package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.AttackingStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.AttackingStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttackingStatsService {
    @Autowired
    private AttackingStatsRepository attackingStatsRepository;

    public Optional<AttackingStatsEntity> getStatsByPlayerId(int id) {
        return attackingStatsRepository.findById(id);
    }

    public AttackingStatsEntity saveStats(AttackingStatsEntity stats) {
        return attackingStatsRepository.save(stats);
    }
}

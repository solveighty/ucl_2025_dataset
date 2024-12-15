package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.AttemptsStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.AttemptsStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttemptsStatsService {

    @Autowired
    private AttemptsStatsRepository attemptsStatsRepository;

    public Optional<AttemptsStatsEntity> getStatsByPlayerId(int id) {
        return attemptsStatsRepository.findById(id);
    }

    public AttemptsStatsEntity saveStats(AttemptsStatsEntity stats) {
        return attemptsStatsRepository.save(stats);
    }
}

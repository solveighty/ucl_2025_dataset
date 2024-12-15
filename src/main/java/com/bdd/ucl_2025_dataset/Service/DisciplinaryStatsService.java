package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.DisciplinaryStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.DisciplinaryStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaryStatsService {
    @Autowired
    private DisciplinaryStatsRepository disciplinaryStatsRepository;

    public Optional<DisciplinaryStatsEntity> getStatsByPlayerId(int id) {
        return disciplinaryStatsRepository.findById(id);
    }

    public DisciplinaryStatsEntity saveStats(DisciplinaryStatsEntity stats) {
        return disciplinaryStatsRepository.save(stats);
    }
}

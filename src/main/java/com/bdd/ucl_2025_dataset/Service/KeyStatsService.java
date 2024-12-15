package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.KeyStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.KeyStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeyStatsService {

    @Autowired
    private KeyStatsRepository keyStatsRepository;

    public Optional<KeyStatsEntity> getStatsByPlayerId(int id) {
        return keyStatsRepository.findById(id);
    }

    public KeyStatsEntity saveStats(KeyStatsEntity stats) {
        return keyStatsRepository.save(stats);
    }

}

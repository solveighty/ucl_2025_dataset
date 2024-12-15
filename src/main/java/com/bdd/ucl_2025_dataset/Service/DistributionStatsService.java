package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.DistributionStatsEntity;
import com.bdd.ucl_2025_dataset.Repository.DistributionStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistributionStatsService {
    @Autowired
    private DistributionStatsRepository distributionStatsRepository;

    public Optional<DistributionStatsEntity> getStatsByPlayerId(int id) {
        return distributionStatsRepository.findById(id);
    }

    public DistributionStatsEntity saveStats(DistributionStatsEntity stats) {
        return distributionStatsRepository.save(stats);
    }
}

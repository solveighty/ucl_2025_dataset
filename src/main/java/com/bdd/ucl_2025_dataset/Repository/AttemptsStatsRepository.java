package com.bdd.ucl_2025_dataset.Repository;

import com.bdd.ucl_2025_dataset.Entity.AttemptsStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptsStatsRepository extends JpaRepository<AttemptsStatsEntity, Integer> {
}

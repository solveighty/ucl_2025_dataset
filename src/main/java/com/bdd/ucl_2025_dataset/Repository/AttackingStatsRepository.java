package com.bdd.ucl_2025_dataset.Repository;

import com.bdd.ucl_2025_dataset.Entity.AttackingStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackingStatsRepository extends JpaRepository<AttackingStatsEntity, Integer> {
}

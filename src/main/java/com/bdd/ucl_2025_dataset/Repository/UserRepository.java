package com.bdd.ucl_2025_dataset.Repository;

import com.bdd.ucl_2025_dataset.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsuario(String usuario);
}

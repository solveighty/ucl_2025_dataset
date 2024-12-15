package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.PlayerEntity;
import com.bdd.ucl_2025_dataset.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<PlayerEntity> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    public PlayerEntity savePlayer(PlayerEntity player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}

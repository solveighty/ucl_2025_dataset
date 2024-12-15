package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.Player;
import com.bdd.ucl_2025_dataset.Entity.UserEntity;
import com.bdd.ucl_2025_dataset.Repository.PlayerRepository;
import com.bdd.ucl_2025_dataset.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private UserRepository userRepository;

    // Verifica si el usuario es admin
    public boolean isAdmin(Integer userId) {
        return userRepository.findById(userId)
                .map(usuario -> usuario.getRol().equals(UserEntity.Rol.ADMIN))
                .orElse(false);
    }

    // Obtener todos los jugadores
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Obtener un jugador por ID
    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    // Crear un jugador (solo admin)
    @Transactional
    public Player createPlayer(Player player, Integer userId) {
        if (!isAdmin(userId)) {
            throw new SecurityException("Solo un administrador puede crear jugadores.");
        }
        return playerRepository.save(player);
    }

    // Editar un jugador (solo admin)
    @Transactional
    public Player updatePlayer(Integer id, Player player, Integer userId) {
        if (!isAdmin(userId)) {
            throw new SecurityException("Solo un administrador puede editar jugadores.");
        }
        // Verifica si el jugador existe
        if (!playerRepository.existsById(id)) {
            throw new IllegalArgumentException("El jugador con el ID " + id + " no existe.");
        }
        player.setId(id);  // Asegúrate de que el ID no cambie al actualizar
        return playerRepository.save(player);
    }

    // Eliminar un jugador (solo admin)
    @Transactional
    public void deletePlayer(Integer id, Integer userId) {
        if (!isAdmin(userId)) {
            throw new SecurityException("Solo un administrador puede eliminar jugadores.");
        }
        playerRepository.deleteById(id);
    }
}

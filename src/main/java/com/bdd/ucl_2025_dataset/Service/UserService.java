package com.bdd.ucl_2025_dataset.Service;

import com.bdd.ucl_2025_dataset.Entity.UserEntity;
import com.bdd.ucl_2025_dataset.Repository.UserRepository;
import com.bdd.ucl_2025_dataset.Security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(int id) {
        return userRepository.findById(id);
    }

    public UserEntity save(UserEntity user) throws NoSuchAlgorithmException {
        String encodedPassword = PasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        userRepository.deleteById(id);
    }


    public UserEntity updateUsuario(Integer id, UserEntity usuario) {
        Optional<UserEntity> existingUsuario = userRepository.findById(id);

        if (existingUsuario.isPresent()) {
            UserEntity updatedUsuario = existingUsuario.get();
            updatedUsuario.setUsuario(usuario.getUsuario());
            updatedUsuario.setNombre(usuario.getNombre());

            try {
                // Only hash the password if it's different from the current hash
                if (!checkPassword(usuario.getPassword(), updatedUsuario.getPassword())) {
                    String encodedPassword = PasswordEncoder.encode(usuario.getPassword());
                    updatedUsuario.setPassword(encodedPassword);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Error al encriptar la contraseña", e);
            }

            updatedUsuario.setRol(usuario.getRol());
            updatedUsuario.setEmail(usuario.getEmail());

            return userRepository.save(updatedUsuario);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    public boolean isAdmin(Integer userId) {
        return userRepository.findById(userId)
                .map(usuario -> usuario.getRol().equals(UserEntity.Rol.ADMIN))
                .orElse(false);
    }

    public boolean checkPassword(String enteredPassword, String storedHash) throws NoSuchAlgorithmException {
        // Compara el hash de la contraseña ingresada con el hash almacenado
        String enteredPasswordHash = PasswordEncoder.encode(enteredPassword);
        return enteredPasswordHash.equals(storedHash);
    }
}

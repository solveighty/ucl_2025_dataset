package com.bdd.ucl_2025_dataset.Controller;

import com.bdd.ucl_2025_dataset.Entity.UserEntity;
import com.bdd.ucl_2025_dataset.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService usuarioService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsuarios() {
        List<UserEntity> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/obtenerusuario/{id}")
    public ResponseEntity<UserEntity> getUsuarioById(@PathVariable Integer id) {
        Optional<UserEntity> usuario = usuarioService.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crearusuario")
    public ResponseEntity<UserEntity> createUsuario(@RequestBody UserEntity usuario) throws NoSuchAlgorithmException {
        UserEntity createdUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }


    @PutMapping("/editarusuario/{id}")
    public ResponseEntity<UserEntity> updateUsuario(@PathVariable Integer id, @RequestBody UserEntity usuario) {
        try {
            UserEntity updatedUsuario = usuarioService.updateUsuario(id, usuario);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminarusuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        try {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/verificarPassword")
    public ResponseEntity<String> verificarPassword(@RequestParam String usuario, @RequestParam String contrasena) {
        Optional<UserEntity> usuarioOpt = usuarioService.getUsuarioByUsuario(usuario);

        if (usuarioOpt.isPresent()) {
            UserEntity usuarioExistente = usuarioOpt.get();
            try {
                boolean isPasswordCorrect = usuarioService.checkPassword(contrasena, usuarioExistente.getPassword());
                if (isPasswordCorrect) {
                    return new ResponseEntity<>("Contraseña correcta", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.UNAUTHORIZED);
                }
            } catch (NoSuchAlgorithmException e) {
                return new ResponseEntity<>("Error al verificar la contraseña", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/obtenerPorUsuario/{usuario}")  // Cambié el nombre para que coincida con el frontend
    public ResponseEntity<UserEntity> getUsuarioByUsuario(@PathVariable String usuario) {
        Optional<UserEntity> usuarioOpt = usuarioService.getUsuarioByUsuario(usuario);
        return usuarioOpt.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/esAdmin")
    public ResponseEntity<Boolean> esAdmin(@PathVariable Integer id) {
        boolean isAdmin = usuarioService.isAdmin(id);
        return ResponseEntity.ok(isAdmin);
    }
}

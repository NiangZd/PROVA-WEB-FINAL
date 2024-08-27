package com.academia.demo.controller;

import com.academia.demo.domain.Usuario;
import com.academia.demo.dto.UsuarioRequestDto;
import com.academia.demo.dto.UsuarioResponseDto;
import com.academia.demo.service.UsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDto> registerUser(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioService.registerUser(usuarioRequestDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDto> loginUser(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioService.loginUser(usuarioRequestDto.getEmail(), usuarioRequestDto.getPassword());
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/dados/{email}")
    public ResponseEntity<UsuarioResponseDto> getUserDataByEmail(@PathVariable("email") String email) {
        Optional<Usuario> usuarioOptional = usuarioService.getUserDataByEmail(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            UsuarioResponseDto response = new UsuarioResponseDto(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                usuario.getDataMatricula(),
                usuario.isInstrutor(),
                "http://localhost:4200" // Ou qualquer outra URL de redirecionamento
            );
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioResponseDto> updateUserData(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto response = usuarioService.updateUserData(usuarioRequestDto);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        boolean isDeleted = usuarioService.softDeleteUser(email);
        if (isDeleted) {
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }
        return ResponseEntity.status(404).body("Usuário não encontrado.");
    }
}

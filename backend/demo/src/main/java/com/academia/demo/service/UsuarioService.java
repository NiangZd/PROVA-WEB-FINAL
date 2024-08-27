package com.academia.demo.service;

import com.academia.demo.dto.UsuarioRequestDto;
import com.academia.demo.dto.UsuarioResponseDto;
import com.academia.demo.domain.Usuario;
import com.academia.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto registerUser(UsuarioRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getName());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getPassword());
        usuario.setDataNascimento(LocalDate.parse(dto.getDob()));
        usuario.setInstrutor(dto.getToken() != null && !dto.getToken().isEmpty());

        Usuario savedUsuario = usuarioRepository.save(usuario);

        String redirectUrl = "http://localhost:4200";

        return new UsuarioResponseDto(
                savedUsuario.getUsuarioId(),
                savedUsuario.getNome(),
                savedUsuario.getEmail(),
                savedUsuario.getDataNascimento(),
                savedUsuario.getDataMatricula(),
                savedUsuario.isInstrutor(),
                redirectUrl
        );
    }

    public UsuarioResponseDto loginUser(String email, String password) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getSenha().equals(password)) {
                String redirectUrl = usuario.isInstrutor()
                        ? "http://localhost:4200/instrutores-index"
                        : "http://localhost:4200/student";

                return new UsuarioResponseDto(
                        usuario.getUsuarioId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getDataNascimento(),
                        usuario.getDataMatricula(),
                        usuario.isInstrutor(),
                        redirectUrl
                );
            }
        }
        return null; 
    }

    public Optional<Usuario> getUserDataByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioResponseDto updateUserData(UsuarioRequestDto dto) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(dto.getEmail());

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Atualiza o nome, email e senha
            usuario.setNome(dto.getName());
            usuario.setSenha(dto.getPassword());

            // Verifica se o email mudou e atualiza o campo email
            if (!usuario.getEmail().equals(dto.getEmail())) {
                usuario.setEmail(dto.getEmail());
            }

            Usuario updatedUsuario = usuarioRepository.save(usuario);

            return new UsuarioResponseDto(
                    updatedUsuario.getUsuarioId(),
                    updatedUsuario.getNome(),
                    updatedUsuario.getEmail(),
                    updatedUsuario.getDataNascimento(), // Não é alterado
                    updatedUsuario.getDataMatricula(), // Não é alterado
                    updatedUsuario.isInstrutor(), // Não é alterado
                    "http://localhost:4200" // Ou qualquer outra URL de redirecionamento
            );
        }
        return null; // Ou lance uma exceção adequada
    }

    public boolean softDeleteUser(String email) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Marca o usuário como excluído definindo a data de exclusão
            usuario.setDeletedAt(LocalDate.now());
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }


}

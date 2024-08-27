package com.academia.demo.service;

import com.academia.demo.dto.FichaTreinoRequestDto;
import com.academia.demo.dto.FichaTreinoResponseDto;
import com.academia.demo.domain.FichaTreino;
import com.academia.demo.domain.Usuario;
import com.academia.demo.repository.FichaTreinoRepository;
import com.academia.demo.repository.UsuarioRepository; // Adicione o repositório Usuario
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FichaTreinoService {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Repositório para Usuario

    public List<FichaTreinoResponseDto> getAllFichasTreino() {
        return fichaTreinoRepository.findAll().stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }

    public Optional<FichaTreinoResponseDto> getFichaTreinoById(Long id) {
        return fichaTreinoRepository.findById(id).map(this::convertToResponseDto);
    }

    public FichaTreinoResponseDto saveFichaTreino(FichaTreinoRequestDto requestDto) {
        FichaTreino fichaTreino = convertToEntity(requestDto);
        FichaTreino savedFichaTreino = fichaTreinoRepository.save(fichaTreino);
        return convertToResponseDto(savedFichaTreino);
    }

    public void deleteFichaTreino(Long id) {
        fichaTreinoRepository.deleteById(id);
    }

    private FichaTreino convertToEntity(FichaTreinoRequestDto requestDto) {
        FichaTreino fichaTreino = new FichaTreino();
        fichaTreino.setUsuario(usuarioRepository.findById(requestDto.getUsuarioId()).orElse(null));
        fichaTreino.setInstrutor(usuarioRepository.findById(requestDto.getInstrutorId()).orElse(null));
        fichaTreino.setData_inicio(requestDto.getDataInicio());
        fichaTreino.setData_fim(requestDto.getDataFim());
        return fichaTreino;
    }

    private FichaTreinoResponseDto convertToResponseDto(FichaTreino fichaTreino) {
        return new FichaTreinoResponseDto(
            fichaTreino.getFicha_id(),
            fichaTreino.getUsuario() != null ? fichaTreino.getUsuario().getUsuarioId() : null, // Ajustado para getUsuarioId()
            fichaTreino.getInstrutor() != null ? fichaTreino.getInstrutor().getUsuarioId() : null, // Ajustado para getUsuarioId()
            fichaTreino.getData_inicio(),
            fichaTreino.getData_fim()
        );
    }
}

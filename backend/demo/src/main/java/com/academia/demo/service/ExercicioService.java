package com.academia.demo.service;

import com.academia.demo.dto.ExercicioRequestDto;
import com.academia.demo.dto.ExercicioResponseDto;
import com.academia.demo.domain.Exercicio;
import com.academia.demo.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<ExercicioResponseDto> getAllExercicios() {
        return exercicioRepository.findAll().stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }

    public Optional<ExercicioResponseDto> getExercicioById(Long id) {
        return exercicioRepository.findById(id).map(this::convertToResponseDto);
    }

    public ExercicioResponseDto saveExercicio(ExercicioRequestDto requestDto) {
        Exercicio exercicio = convertToEntity(requestDto);
        Exercicio savedExercicio = exercicioRepository.save(exercicio);
        return convertToResponseDto(savedExercicio);
    }

    public void deleteExercicio(Long id) {
        exercicioRepository.deleteById(id);
    }

    private Exercicio convertToEntity(ExercicioRequestDto requestDto) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(requestDto.getNome());
        exercicio.setDescricao(requestDto.getDescricao());
        return exercicio;
    }

    private ExercicioResponseDto convertToResponseDto(Exercicio exercicio) {
        return new ExercicioResponseDto(
            exercicio.getExercicioId(),
            exercicio.getNome(),
            exercicio.getDescricao()
        );
    }
}

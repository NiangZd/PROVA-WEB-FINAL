package com.academia.demo.service;

import com.academia.demo.dto.SetsRequestDto;
import com.academia.demo.dto.SetsResponseDto;
import com.academia.demo.domain.Sets;
import com.academia.demo.domain.FichaTreino;
import com.academia.demo.domain.Exercicio;
import com.academia.demo.repository.SetsRepository;
import com.academia.demo.repository.FichaTreinoRepository;
import com.academia.demo.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SetsService {

    @Autowired
    private SetsRepository setsRepository;

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<SetsResponseDto> getAllSets() {
        return setsRepository.findAll().stream()
            .map(this::convertToResponseDto)
            .collect(Collectors.toList());
    }

    public Optional<SetsResponseDto> getSetById(Long id) {
        return setsRepository.findById(id).map(this::convertToResponseDto);
    }

    public SetsResponseDto saveSet(SetsRequestDto requestDto) {
        Sets sets = convertToEntity(requestDto);
        Sets savedSet = setsRepository.save(sets);
        return convertToResponseDto(savedSet);
    }

    public void deleteSet(Long id) {
        setsRepository.deleteById(id);
    }

    private Sets convertToEntity(SetsRequestDto requestDto) {
        Sets sets = new Sets();
        sets.setFichaTreino(fichaTreinoRepository.findById(requestDto.getFichaId()).orElse(null));
        sets.setExercicio(exercicioRepository.findById(requestDto.getExercicioId()).orElse(null));
        sets.setRepeticoes(requestDto.getRepeticoes());
        sets.setCarga(requestDto.getCarga());
        sets.setTipo_set(requestDto.getTipoSet());
        return sets;
    }

    private SetsResponseDto convertToResponseDto(Sets sets) {
        return new SetsResponseDto(
            sets.getSet_id(),
            sets.getFichaTreino() != null ? sets.getFichaTreino().getFicha_id() : null, // Ajustado para getFicha_id()
            sets.getExercicio() != null ? sets.getExercicio().getExercicioId() : null, // Certifique-se de que Exercicio tem um método getExercicioId()
            sets.getRepeticoes(),
            sets.getCarga(),
            sets.getTipo_set()
        );
    }
}

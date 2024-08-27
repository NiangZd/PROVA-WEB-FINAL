package com.academia.demo.controller;

import com.academia.demo.dto.ExercicioRequestDto;
import com.academia.demo.dto.ExercicioResponseDto;
import com.academia.demo.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public List<ExercicioResponseDto> getAllExercicios() {
        return exercicioService.getAllExercicios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDto> getExercicioById(@PathVariable Long id) {
        Optional<ExercicioResponseDto> exercicio = exercicioService.getExercicioById(id);
        return exercicio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExercicioResponseDto> createExercicio(@RequestBody ExercicioRequestDto requestDto) {
        ExercicioResponseDto createdExercicio = exercicioService.saveExercicio(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioResponseDto> updateExercicio(@PathVariable Long id, @RequestBody ExercicioRequestDto requestDto) {
        if (!exercicioService.getExercicioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        requestDto.setId(id); // Ajuste aqui
        ExercicioResponseDto updatedExercicio = exercicioService.saveExercicio(requestDto);
        return ResponseEntity.ok(updatedExercicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercicio(@PathVariable Long id) {
        if (!exercicioService.getExercicioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        exercicioService.deleteExercicio(id);
        return ResponseEntity.noContent().build();
    }
}

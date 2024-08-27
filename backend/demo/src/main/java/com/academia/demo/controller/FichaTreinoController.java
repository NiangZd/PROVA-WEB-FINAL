package com.academia.demo.controller;

import com.academia.demo.dto.FichaTreinoRequestDto;
import com.academia.demo.dto.FichaTreinoResponseDto;
import com.academia.demo.service.FichaTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fichas-treino")
public class FichaTreinoController {

    @Autowired
    private FichaTreinoService fichaTreinoService;

    @GetMapping
    public List<FichaTreinoResponseDto> getAllFichasTreino() {
        return fichaTreinoService.getAllFichasTreino();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaTreinoResponseDto> getFichaTreinoById(@PathVariable Long id) {
        Optional<FichaTreinoResponseDto> fichaTreino = fichaTreinoService.getFichaTreinoById(id);
        return fichaTreino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FichaTreinoResponseDto> createFichaTreino(@RequestBody FichaTreinoRequestDto requestDto) {
        FichaTreinoResponseDto createdFichaTreino = fichaTreinoService.saveFichaTreino(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFichaTreino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaTreinoResponseDto> updateFichaTreino(@PathVariable Long id, @RequestBody FichaTreinoRequestDto requestDto) {
        if (!fichaTreinoService.getFichaTreinoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        requestDto.setId(id); // Ajuste aqui
        FichaTreinoResponseDto updatedFichaTreino = fichaTreinoService.saveFichaTreino(requestDto);
        return ResponseEntity.ok(updatedFichaTreino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFichaTreino(@PathVariable Long id) {
        if (!fichaTreinoService.getFichaTreinoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fichaTreinoService.deleteFichaTreino(id);
        return ResponseEntity.noContent().build();
    }
}

package com.academia.demo.controller;

import com.academia.demo.dto.SetsRequestDto;
import com.academia.demo.dto.SetsResponseDto;
import com.academia.demo.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sets")
public class SetsController {

    @Autowired
    private SetsService setsService;

    @GetMapping
    public List<SetsResponseDto> getAllSets() {
        return setsService.getAllSets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetsResponseDto> getSetById(@PathVariable Long id) {
        Optional<SetsResponseDto> sets = setsService.getSetById(id);
        return sets.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SetsResponseDto> createSet(@RequestBody SetsRequestDto requestDto) {
        SetsResponseDto createdSets = setsService.saveSet(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetsResponseDto> updateSet(@PathVariable Long id, @RequestBody SetsRequestDto requestDto) {
        if (!setsService.getSetById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        requestDto.setId(id); // Ajuste aqui
        SetsResponseDto updatedSets = setsService.saveSet(requestDto);
        return ResponseEntity.ok(updatedSets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        if (!setsService.getSetById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        setsService.deleteSet(id);
        return ResponseEntity.noContent().build();
    }
}

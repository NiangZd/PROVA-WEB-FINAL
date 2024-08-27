package com.academia.demo.dto;

public class ExercicioResponseDto {

    private Long exercicioId;
    private String nome;
    private String descricao;

    public ExercicioResponseDto() {}

    public ExercicioResponseDto(Long exercicioId, String nome, String descricao) {
        this.exercicioId = exercicioId;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

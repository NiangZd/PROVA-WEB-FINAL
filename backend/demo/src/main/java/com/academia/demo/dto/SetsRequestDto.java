package com.academia.demo.dto;

public class SetsRequestDto {

    private Long id; // Adicione este campo
    private Long fichaId;
    private Long exercicioId;
    private int repeticoes;
    private double carga;
    private String tipoSet;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFichaId() {
        return fichaId;
    }

    public void setFichaId(Long fichaId) {
        this.fichaId = fichaId;
    }

    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public String getTipoSet() {
        return tipoSet;
    }

    public void setTipoSet(String tipoSet) {
        this.tipoSet = tipoSet;
    }
}

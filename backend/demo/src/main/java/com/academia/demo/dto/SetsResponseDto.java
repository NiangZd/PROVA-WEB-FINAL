package com.academia.demo.dto;

public class SetsResponseDto {

    private Long setId;
    private Long fichaId;
    private Long exercicioId;
    private int repeticoes;
    private double carga;
    private String tipoSet;

    public SetsResponseDto() {}

    public SetsResponseDto(Long setId, Long fichaId, Long exercicioId, int repeticoes, double carga, String tipoSet) {
        this.setId = setId;
        this.fichaId = fichaId;
        this.exercicioId = exercicioId;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.tipoSet = tipoSet;
    }

    // Getters e Setters
    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
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

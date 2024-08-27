package com.academia.demo.dto;

import java.time.LocalDate;

public class FichaTreinoResponseDto {

    private Long fichaId;
    private Long usuarioId;
    private Long instrutorId;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public FichaTreinoResponseDto() {}

    public FichaTreinoResponseDto(Long fichaId, Long usuarioId, Long instrutorId, LocalDate dataInicio, LocalDate dataFim) {
        this.fichaId = fichaId;
        this.usuarioId = usuarioId;
        this.instrutorId = instrutorId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Long getFichaId() {
        return fichaId;
    }

    public void setFichaId(Long fichaId) {
        this.fichaId = fichaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(Long instrutorId) {
        this.instrutorId = instrutorId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}

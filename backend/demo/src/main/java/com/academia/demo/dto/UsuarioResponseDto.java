package com.academia.demo.dto;

import java.time.LocalDate;

public class UsuarioResponseDto {

    private Long usuarioId;
    private String nome;
    private String email;
    private LocalDate data_nascimento;
    private LocalDate data_matricula;
    private boolean isInstrutor;
    private String redirectUrl;

    public UsuarioResponseDto() {}

    public UsuarioResponseDto(Long usuarioId, String nome, String email, LocalDate data_nascimento, LocalDate data_matricula, boolean isInstrutor, String redirectUrl) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.data_matricula = data_matricula;
        this.isInstrutor = isInstrutor;
        this.redirectUrl = redirectUrl;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public LocalDate getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(LocalDate data_matricula) {
        this.data_matricula = data_matricula;
    }

    // Getters e Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInstrutor() {
        return isInstrutor;
    }

    public void setInstrutor(boolean isInstrutor) {
        this.isInstrutor = isInstrutor;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

}
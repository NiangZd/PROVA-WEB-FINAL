package com.academia.demo.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FichaTreino")
//@SQLDelete(sql = "UPDATE fichatreino SET deleted_at = CURRENT_TIMESTAMP where id=?")
//@SQLRestriction("deleted_at is null")
public class FichaTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ficha_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Usuario instrutor;

    @Column(nullable = false)
    private LocalDate data_inicio;

    private LocalDate data_fim;

    private LocalDateTime deleted_at;

    // Getters e Setters
    public Long getFicha_id() {
        return ficha_id;
    }

    public void setFicha_id(Long ficha_id) {
        this.ficha_id = ficha_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}

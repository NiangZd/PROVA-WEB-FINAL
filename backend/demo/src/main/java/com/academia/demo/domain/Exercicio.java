package com.academia.demo.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
//import com.academia.demo.domain.AbstractEntity.AbstractEntity;

@Entity
@Table(name = "exercicio")
//@SQLDelete(sql = "UPDATE exercicio SET deleted_at = CURRENT_TIMESTAMP where id=?")
//@SQLRestriction("deleted_at is null")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId; // Renomeado para seguir a convenção de nomes

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private LocalDateTime deleted_at;

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

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}

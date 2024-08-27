package com.academia.demo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Sets")
//@SQLDelete(sql = "UPDATE sets SET deleted_at = CURRENT_TIMESTAMP where id=?")
//@SQLRestriction("deleted_at is null")
public class Sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long set_id;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private FichaTreino fichaTreino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    @Column(nullable = false)
    private int repeticoes;

    @Column(nullable = false)
    private double carga;

    @Column(nullable = false)
    private String tipo_set;

    private LocalDateTime deleted_at;

      public Long getSet_id() {
        return set_id;
    }

    public void setSet_id(Long set_id) {
        this.set_id = set_id;
    }

    public FichaTreino getFichaTreino() {
        return fichaTreino;
    }

    public void setFichaTreino(FichaTreino fichaTreino) {
        this.fichaTreino = fichaTreino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
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

    public String getTipo_set() {
        return tipo_set;
    }

    public void setTipo_set(String tipo_set) {
        this.tipo_set = tipo_set;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }
}

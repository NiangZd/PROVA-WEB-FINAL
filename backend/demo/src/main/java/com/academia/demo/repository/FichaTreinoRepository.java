package com.academia.demo.repository;

import com.academia.demo.domain.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
}
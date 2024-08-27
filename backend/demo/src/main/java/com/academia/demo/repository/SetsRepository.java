package com.academia.demo.repository;

import com.academia.demo.domain.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetsRepository extends JpaRepository<Sets, Long> {
}
package com.portafolio.PrysmaPH.repository;

import com.portafolio.PrysmaPH.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
}
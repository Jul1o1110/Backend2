package com.portafolio.PrysmaPH.repository;

import com.portafolio.PrysmaPH.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
}
package com.portafolio.PrysmaPH.repository;

import com.portafolio.PrysmaPH.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
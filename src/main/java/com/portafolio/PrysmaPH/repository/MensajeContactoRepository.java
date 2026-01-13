package com.portafolio.PrysmaPH.repository;

import com.portafolio.PrysmaPH.model.MensajeContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeContactoRepository extends JpaRepository<MensajeContacto, Integer> {
}
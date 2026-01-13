package com.portafolio.PrysmaPH.repository;

import com.portafolio.PrysmaPH.model.TipoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProyectoRepository extends JpaRepository<TipoProyecto, Integer> {
}
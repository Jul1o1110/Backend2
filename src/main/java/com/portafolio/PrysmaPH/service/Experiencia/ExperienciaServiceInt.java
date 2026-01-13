package com.portafolio.PrysmaPH.service.Experiencia;

import com.portafolio.PrysmaPH.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface ExperienciaServiceInt {
    List<Experiencia> listarExperiencias();
    Optional<Experiencia> buscarPorId(int id);
    Experiencia guardarExperiencia(Experiencia experiencia);
    void eliminarExperiencia(int id);
}
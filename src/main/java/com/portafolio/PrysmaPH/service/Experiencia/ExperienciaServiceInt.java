package com.portafolio.PrysmaPH.service.Experiencia;

import com.portafolio.PrysmaPH.dto.ExperienciaDTO; 
import com.portafolio.PrysmaPH.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface ExperienciaServiceInt {
    List<Experiencia> listarExperiencias();
    
    Optional<Experiencia> buscarPorId(int id);
    
    Experiencia guardarExperiencia(ExperienciaDTO experienciaDTO);
    
    void eliminarExperiencia(int id);
}
package com.portafolio.PrysmaPH.service.Persona;

import com.portafolio.PrysmaPH.model.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaServiceInt {
    List<Persona> listarPersonas();
    Optional<Persona> buscarPorId(int id);
    Persona guardarPersona(Persona persona);
    void eliminarPersona(int id);
    
}
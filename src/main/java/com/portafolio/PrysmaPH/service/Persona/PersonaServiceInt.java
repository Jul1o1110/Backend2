package com.portafolio.PrysmaPH.service.Persona;
import com.portafolio.PrysmaPH.dto.PersonaDTO;
import com.portafolio.PrysmaPH.model.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaServiceInt {
    List<Persona> listarPersonas();
    Optional<Persona> buscarPorId(int id);
    Persona guardarPersona(PersonaDTO personaDTO);
    void eliminarPersona(int id);
    
}
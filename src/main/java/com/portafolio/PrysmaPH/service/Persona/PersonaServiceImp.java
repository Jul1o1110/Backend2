package com.portafolio.PrysmaPH.service.Persona;

import com.portafolio.PrysmaPH.model.Persona;
import com.portafolio.PrysmaPH.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaServiceInt {

    private final PersonaRepository personaRepository;

    public PersonaServiceImp(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> buscarPorId(int id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(int id) {
        personaRepository.deleteById(id);
    }
}
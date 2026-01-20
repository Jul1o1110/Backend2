package com.portafolio.PrysmaPH.service.Persona;
import com.portafolio.PrysmaPH.dto.PersonaDTO;
import com.portafolio.PrysmaPH.model.Persona;
import com.portafolio.PrysmaPH.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaServiceInt {

    private final PersonaRepository personaRepository;
    private final ModelMapper modelMapper;

    public PersonaServiceImp(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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
    public Persona guardarPersona(PersonaDTO personaDTO) {
        Persona persona = modelMapper.map(personaDTO, Persona.class);
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(int id) {
        personaRepository.deleteById(id);
    }
}
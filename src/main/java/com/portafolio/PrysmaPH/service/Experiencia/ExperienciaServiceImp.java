package com.portafolio.PrysmaPH.service.Experiencia;

import com.portafolio.PrysmaPH.model.Experiencia;
import com.portafolio.PrysmaPH.repository.ExperienciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaServiceImp implements ExperienciaServiceInt {

    private final ExperienciaRepository experienciaRepository;

    public ExperienciaServiceImp(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    @Override
    public List<Experiencia> listarExperiencias() {
        return experienciaRepository.findAll();
    }

    @Override
    public Optional<Experiencia> buscarPorId(int id) {
        return experienciaRepository.findById(id);
    }

    @Override
    public Experiencia guardarExperiencia(Experiencia experiencia) {
        if (experiencia.getTitulo() == null || experiencia.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }

        if (experiencia.getInstitucionEmpresa() == null || experiencia.getInstitucionEmpresa().isEmpty()) {
            throw new IllegalArgumentException("La institución o empresa es obligatoria");
        }

        if (experiencia.getFechaInicio() == null) {
            throw new IllegalArgumentException("La fecha de inicio es obligatoria");
        }

        if (experiencia.getPersona() == null || experiencia.getPersona().getId() == 0) {
            throw new IllegalArgumentException("La experiencia debe estar asociada a una persona válida");
        }

        return experienciaRepository.save(experiencia);
    }

    @Override
    public void eliminarExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }
}
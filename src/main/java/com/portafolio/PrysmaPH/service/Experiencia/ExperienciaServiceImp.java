package com.portafolio.PrysmaPH.service.Experiencia;

import com.portafolio.PrysmaPH.dto.ExperienciaDTO;
import com.portafolio.PrysmaPH.model.Experiencia;
import com.portafolio.PrysmaPH.repository.ExperienciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaServiceImp implements ExperienciaServiceInt {

    private final ExperienciaRepository experienciaRepository;
    private final ModelMapper modelMapper;

    public ExperienciaServiceImp(ExperienciaRepository experienciaRepository, ModelMapper modelMapper) {
        this.experienciaRepository = experienciaRepository;
        this.modelMapper = modelMapper;
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
    public Experiencia guardarExperiencia(ExperienciaDTO experienciaDTO) {
        if (experienciaDTO.getTitulo() == null || experienciaDTO.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }

        if (experienciaDTO.getInstitucionEmpresa() == null || experienciaDTO.getInstitucionEmpresa().isEmpty()) {
            throw new IllegalArgumentException("La institución o empresa es obligatoria");
        }

        if (experienciaDTO.getFechaInicio() == null) {
            throw new IllegalArgumentException("La fecha de inicio es obligatoria");
        }
        Experiencia experiencia = modelMapper.map(experienciaDTO, Experiencia.class);

        return experienciaRepository.save(experiencia);
    }

    @Override
    public void eliminarExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }
}
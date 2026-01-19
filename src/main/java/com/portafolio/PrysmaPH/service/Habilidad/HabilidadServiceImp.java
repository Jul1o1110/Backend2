package com.portafolio.PrysmaPH.service.Habilidad;

import com.portafolio.PrysmaPH.dto.HabilidadDTO;
import com.portafolio.PrysmaPH.model.Habilidad;
import com.portafolio.PrysmaPH.repository.HabilidadRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadServiceImp implements HabilidadServiceInt {

    private final HabilidadRepository habilidadRepository;
    private final ModelMapper modelMapper;

    public HabilidadServiceImp(HabilidadRepository habilidadRepository , ModelMapper modelMapper) {
        this.habilidadRepository = habilidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Habilidad> listarHabilidades() {
        return habilidadRepository.findAll();
    }

    @Override
    public Optional<Habilidad> buscarPorId(int id) {
        return habilidadRepository.findById(id);
    }

    @Override
    public Habilidad guardarHabilidad(HabilidadDTO habilidadDTO) {
        if (habilidadDTO.getNombre() == null || habilidadDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la habilidad es obligatorio");
        }

        if (habilidadDTO.getTipo() == null || habilidadDTO.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de habilidad es obligatorio");
        }
        Habilidad habilidad = modelMapper.map(habilidadDTO, Habilidad.class);


        return habilidadRepository.save(habilidad);
    }

    @Override
    public void eliminarHabilidad(int id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(int id) {
        return habilidadRepository.existsById(id);
    }
}
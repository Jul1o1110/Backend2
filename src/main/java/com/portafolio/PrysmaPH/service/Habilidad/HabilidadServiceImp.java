package com.portafolio.PrysmaPH.service.Habilidad;

import com.portafolio.PrysmaPH.model.Habilidad;
import com.portafolio.PrysmaPH.repository.HabilidadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadServiceImp implements HabilidadServiceInt {

    private final HabilidadRepository habilidadRepository;

    public HabilidadServiceImp(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
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
    public Habilidad guardarHabilidad(Habilidad habilidad) {
        if (habilidad.getNombre() == null || habilidad.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la habilidad es obligatorio");
        }

        if (habilidad.getTipo() == null || habilidad.getTipo().isEmpty()) {
            throw new IllegalArgumentException("El tipo de habilidad es obligatorio");
        }

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
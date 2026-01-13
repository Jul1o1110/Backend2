package com.portafolio.PrysmaPH.service.Proyecto;

import com.portafolio.PrysmaPH.model.Proyecto;
import com.portafolio.PrysmaPH.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImp implements ProyectoServiceInt {

    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImp(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> buscarPorId(int id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public Proyecto guardarProyecto(Proyecto proyecto) {
        if (proyecto.getNombre() == null || proyecto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proyecto es obligatorio");
        }

        if (proyecto.getUrlRepositorio() != null && !proyecto.getUrlRepositorio().startsWith("http")) {
            throw new IllegalArgumentException("La URL del repositorio debe ser un enlace válido");
        }

        if (proyecto.getTipoProyecto() == null || proyecto.getTipoProyecto().getId() == 0) {
            throw new IllegalArgumentException("El proyecto debe estar asociado a un tipo de proyecto válido");
        }

        return proyectoRepository.save(proyecto);
    }

    @Override
    public void eliminarProyecto(int id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(int id) {
        return proyectoRepository.existsById(id);
    }
}
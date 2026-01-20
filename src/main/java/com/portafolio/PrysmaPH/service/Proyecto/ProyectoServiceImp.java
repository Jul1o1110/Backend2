package com.portafolio.PrysmaPH.service.Proyecto;
import com.portafolio.PrysmaPH.dto.ProyectoDTO;
import com.portafolio.PrysmaPH.model.Proyecto;
import com.portafolio.PrysmaPH.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImp implements ProyectoServiceInt {

    private final ProyectoRepository proyectoRepository;
    private final ModelMapper modelMapper;

    public ProyectoServiceImp(ProyectoRepository proyectoRepository , ModelMapper modelMapper) {
        this.proyectoRepository = proyectoRepository;
        this.modelMapper = modelMapper;
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
    public Proyecto guardarProyecto(ProyectoDTO proyectoDTO) {
        if (proyectoDTO.getNombre() == null || proyectoDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proyecto es obligatorio");
        }

        if (proyectoDTO.getUrlRepositorio() != null && !proyectoDTO.getUrlRepositorio().startsWith("http")) {
            throw new IllegalArgumentException("La URL del repositorio debe ser un enlace válido");
        }

        if (proyectoDTO.getTipoProyectoId() <= 0) {
            throw new IllegalArgumentException("El proyecto debe estar asociado a un tipo de proyecto válido");
        }

        Proyecto proyecto = modelMapper.map(proyectoDTO, Proyecto.class);
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
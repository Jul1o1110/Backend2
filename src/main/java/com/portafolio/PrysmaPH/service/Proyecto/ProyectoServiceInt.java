package com.portafolio.PrysmaPH.service.Proyecto;
import com.portafolio.PrysmaPH.dto.ProyectoDTO;
import com.portafolio.PrysmaPH.model.Proyecto;
import java.util.List;
import java.util.Optional;

public interface ProyectoServiceInt {
    List<Proyecto> listarProyectos();
    Optional<Proyecto> buscarPorId(int id);
    Proyecto guardarProyecto(ProyectoDTO proyectoDTO);
    void eliminarProyecto(int id);
    boolean existePorId(int id);
}
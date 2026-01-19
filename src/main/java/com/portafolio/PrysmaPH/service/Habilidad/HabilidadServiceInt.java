package com.portafolio.PrysmaPH.service.Habilidad;

import com.portafolio.PrysmaPH.dto.HabilidadDTO;
import com.portafolio.PrysmaPH.model.Habilidad;
import java.util.List;
import java.util.Optional;

public interface HabilidadServiceInt {
    List<Habilidad> listarHabilidades();
    Optional<Habilidad> buscarPorId(int id);
    Habilidad guardarHabilidad(HabilidadDTO habilidadDTO);
    void eliminarHabilidad(int id);
    boolean existePorId(int id);
}
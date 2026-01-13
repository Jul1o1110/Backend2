package com.portafolio.PrysmaPH.service.TipoProyecto;

import com.portafolio.PrysmaPH.model.TipoProyecto;
import com.portafolio.PrysmaPH.repository.TipoProyectoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoProyectoServiceImp implements TipoProyectoServiceInt {

    private final TipoProyectoRepository tipoProyectoRepository;

    public TipoProyectoServiceImp(TipoProyectoRepository tipoProyectoRepository) {
        this.tipoProyectoRepository = tipoProyectoRepository;
    }

    @Override
    public List<TipoProyecto> listarTipos() {
        return tipoProyectoRepository.findAll();
    }

    @Override
    public TipoProyecto guardarTipo(TipoProyecto tipoProyecto) {
        if (tipoProyecto.getNombre() == null || tipoProyecto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tipo de proyecto es obligatorio");
        }
        return tipoProyectoRepository.save(tipoProyecto);
    }
}
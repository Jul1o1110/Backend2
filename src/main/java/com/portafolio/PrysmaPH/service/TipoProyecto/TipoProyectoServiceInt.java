package com.portafolio.PrysmaPH.service.TipoProyecto;
import com.portafolio.PrysmaPH.dto.TipoProyectoDTO;
import com.portafolio.PrysmaPH.model.TipoProyecto;
import java.util.List;

public interface TipoProyectoServiceInt {
    List<TipoProyecto> listarTipos();
    TipoProyecto guardarTipo(TipoProyectoDTO tipoProyectoDTO);
}
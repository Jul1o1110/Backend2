package com.portafolio.PrysmaPH.service.TipoProyecto;
import com.portafolio.PrysmaPH.dto.TipoProyectoDTO;
import com.portafolio.PrysmaPH.model.TipoProyecto;
import com.portafolio.PrysmaPH.repository.TipoProyectoRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Service
public class TipoProyectoServiceImp implements TipoProyectoServiceInt {

    private final TipoProyectoRepository tipoProyectoRepository;
    private final ModelMapper modelMapper;

    public TipoProyectoServiceImp(TipoProyectoRepository tipoProyectoRepository , ModelMapper modelMapper) {
        this.tipoProyectoRepository = tipoProyectoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoProyecto> listarTipos() {
        return tipoProyectoRepository.findAll();
    }

    @Override
    public TipoProyecto guardarTipo(TipoProyectoDTO tipoProyectoDTO) {
        if (tipoProyectoDTO.getNombre() == null || tipoProyectoDTO.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tipo de proyecto es obligatorio");
        }
        TipoProyecto tipoProyecto = modelMapper.map(tipoProyectoDTO, TipoProyecto.class);
        return tipoProyectoRepository.save(tipoProyecto);

    }
}
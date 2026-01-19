package com.portafolio.PrysmaPH.service.MensajeContacto;

import com.portafolio.PrysmaPH.dto.MensajeContactoDTO;
import com.portafolio.PrysmaPH.model.MensajeContacto;
import com.portafolio.PrysmaPH.repository.MensajeContactoRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;

@Service
public class MensajeContactoServiceImp implements MensajeContactoServiceInt {

    private final MensajeContactoRepository mensajeRepository;
    private final ModelMapper modelMapper;


    public MensajeContactoServiceImp(MensajeContactoRepository mensajeRepository , ModelMapper modelMapper) {
        this.mensajeRepository = mensajeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MensajeContacto> listarMensajes() {
        return mensajeRepository.findAll();
    }

    @Override
    public MensajeContacto guardarMensaje(MensajeContactoDTO mensajeDTO) {
        if (mensajeDTO.getNombreRemitente() == null || mensajeDTO.getNombreRemitente().isEmpty()) {
            throw new IllegalArgumentException("El nombre del remitente es obligatorio");
        }
        if (mensajeDTO.getEmailRemitente() == null || !mensajeDTO.getEmailRemitente().contains("@")) {
            throw new IllegalArgumentException("El email proporcionado no es válido");
        }
        if (mensajeDTO.getMensaje() == null || mensajeDTO.getMensaje().trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido del mensaje no puede estar vacío");
        }

        if (mensajeDTO.getFechaEnvio() == null) {
            mensajeDTO.setFechaEnvio(LocalDate.now());
        }
        MensajeContacto mensaje = modelMapper.map(mensajeDTO , MensajeContacto.class);

        return mensajeRepository.save(mensaje);
    }
}
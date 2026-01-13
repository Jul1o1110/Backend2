package com.portafolio.PrysmaPH.service.MensajeContacto;

import com.portafolio.PrysmaPH.model.MensajeContacto;
import com.portafolio.PrysmaPH.repository.MensajeContactoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeContactoServiceImp implements MensajeContactoServiceInt {

    private final MensajeContactoRepository mensajeRepository;

    public MensajeContactoServiceImp(MensajeContactoRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public List<MensajeContacto> listarMensajes() {
        return mensajeRepository.findAll();
    }

    @Override
    public MensajeContacto guardarMensaje(MensajeContacto mensaje) {
        if (mensaje.getNombreRemitente() == null || mensaje.getNombreRemitente().isEmpty()) {
            throw new IllegalArgumentException("El nombre del remitente es obligatorio");
        }
        if (mensaje.getEmailRemitente() == null || !mensaje.getEmailRemitente().contains("@")) {
            throw new IllegalArgumentException("El email proporcionado no es válido");
        }
        if (mensaje.getMensaje() == null || mensaje.getMensaje().trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido del mensaje no puede estar vacío");
        }

        if (mensaje.getFechaEnvio() == null) {
            mensaje.setFechaEnvio(LocalDateTime.now());
        }

        return mensajeRepository.save(mensaje);
    }
}
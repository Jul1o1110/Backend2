package com.portafolio.PrysmaPH.service.MensajeContacto;

import com.portafolio.PrysmaPH.model.MensajeContacto;
import java.util.List;

public interface MensajeContactoServiceInt {
    List<MensajeContacto> listarMensajes();
    MensajeContacto guardarMensaje(MensajeContacto mensaje);
}
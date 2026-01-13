package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.MensajeContacto;
import com.portafolio.PrysmaPH.repository.MensajeContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeContactoController {

    @Autowired
    private MensajeContactoRepository mensajeRepository;

    @GetMapping
    public List<MensajeContacto> listar() {
        return mensajeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> enviarMensaje(@RequestBody MensajeContacto mensaje) {
        if (mensaje.getNombreRemitente() == null || mensaje.getNombreRemitente().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del remitente es obligatorio");
        }

        if (mensaje.getEmailRemitente() == null || !mensaje.getEmailRemitente().contains("@")) {
            return ResponseEntity.badRequest().body("El email proporcionado no es válido");
        }

        if (mensaje.getMensaje() == null || mensaje.getMensaje().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El contenido del mensaje no puede estar vacío");
        }

        if (mensaje.getFechaEnvio() == null) {
            mensaje.setFechaEnvio(LocalDateTime.now());
        }

        MensajeContacto nuevoMensaje = mensajeRepository.save(mensaje);
        return ResponseEntity.ok(nuevoMensaje);
    }
}

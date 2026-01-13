package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.MensajeContacto;
import com.portafolio.PrysmaPH.service.MensajeContacto.MensajeContactoServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeContactoController {

    private final MensajeContactoServiceInt mensajeService;

    public MensajeContactoController(MensajeContactoServiceInt mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping
    public List<MensajeContacto> listar() {
        return mensajeService.listarMensajes();
    }

    @PostMapping
    public ResponseEntity<?> enviarMensaje(@RequestBody MensajeContacto mensaje) {
        try {
            MensajeContacto nuevoMensaje = mensajeService.guardarMensaje(mensaje);
            return new ResponseEntity<>(nuevoMensaje, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar el mensaje");
        }
    }
}
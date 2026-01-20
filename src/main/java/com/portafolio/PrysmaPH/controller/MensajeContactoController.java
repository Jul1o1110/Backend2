package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.dto.MensajeContactoDTO;
import com.portafolio.PrysmaPH.model.MensajeContacto;
import com.portafolio.PrysmaPH.service.MensajeContacto.MensajeContactoServiceInt;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
@Tag(name = "Mensajes", description = "Mensajes de posibles clientes.")
public class MensajeContactoController {

    private final MensajeContactoServiceInt mensajeService;

    public MensajeContactoController(MensajeContactoServiceInt mensajeService) {
        this.mensajeService = mensajeService;
    }

    @Operation(summary = "Obtener listado de mensajes", description = "Retorna un listado de todos los mensajes enviados por los clientes.")
    @GetMapping
    public List<MensajeContacto> listar() {
        return mensajeService.listarMensajes();
    }

    @Operation(summary = "Enviar mensaje", description = "Recibe un mensaje enviado por un cliente y lo guarda.")
    @PostMapping
    public ResponseEntity<?> enviarMensaje(@RequestBody MensajeContactoDTO mensajeDTO) {
        try {
            MensajeContacto nuevoMensaje = mensajeService.guardarMensaje(mensajeDTO);
            return new ResponseEntity<>(nuevoMensaje, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar el mensaje");
        }
    }
}
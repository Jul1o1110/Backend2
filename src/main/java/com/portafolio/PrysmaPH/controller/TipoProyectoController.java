package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.TipoProyecto;
import com.portafolio.PrysmaPH.service.TipoProyecto.TipoProyectoServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-proyecto")
@CrossOrigin(origins = "*")
public class TipoProyectoController {

    private final TipoProyectoServiceInt tipoProyectoService;

    public TipoProyectoController(TipoProyectoServiceInt tipoProyectoService) {
        this.tipoProyectoService = tipoProyectoService;
    }

    @GetMapping
    public List<TipoProyecto> listar() {
        return tipoProyectoService.listarTipos();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TipoProyecto tipoProyecto) {
        try {
            TipoProyecto nuevoTipo = tipoProyectoService.guardarTipo(tipoProyecto);
            return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear el tipo de proyecto");
        }
    }
}
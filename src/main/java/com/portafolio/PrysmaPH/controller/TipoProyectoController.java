package com.portafolio.PrysmaPH.controller;
import com.portafolio.PrysmaPH.dto.TipoProyectoDTO;
import com.portafolio.PrysmaPH.model.TipoProyecto;
import com.portafolio.PrysmaPH.service.TipoProyecto.TipoProyectoServiceInt;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-proyecto")
@CrossOrigin(origins = "*")
@Tag(name = "Tipos de proyecto", description = "Tipo de proyecto (Empresarial, Hogar, etc.).")
public class TipoProyectoController {

    private final TipoProyectoServiceInt tipoProyectoService;

    public TipoProyectoController(TipoProyectoServiceInt tipoProyectoService) {
        this.tipoProyectoService = tipoProyectoService;
    }

    @Operation(summary = "Obtener listado de tipos de proyecto", description = "Trae un listado de los tipos de proyecto registrados.")
    @GetMapping
    public List<TipoProyecto> listar() {
        return tipoProyectoService.listarTipos();
    }

    @Operation(summary = "Registrar nuevo tipo de proyecto", description = "Crea un nuevo tipo de proyecto.")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TipoProyectoDTO tipoProyectoDTO) {
        try {
            TipoProyecto nuevoTipo = tipoProyectoService.guardarTipo(tipoProyectoDTO);
            return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear el tipo de proyecto");
        }
    }
}
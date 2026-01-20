package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Proyecto;
import com.portafolio.PrysmaPH.service.Proyecto.ProyectoServiceInt;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portafolio.PrysmaPH.dto.ProyectoDTO;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
@Tag(name = "Proyectos", description = "Proyectos para muestras del trabajo.")
public class ProyectoController {

    private final ProyectoServiceInt proyectoService;

    public ProyectoController(ProyectoServiceInt proyectoService) {
        this.proyectoService = proyectoService;
    }

    @Operation(summary = "Obtener listado de proyectos", description = "Trae un listado de todos los proyectos registrados.")
    @GetMapping
    public List<Proyecto> listar() {
        return proyectoService.listarProyectos();
    }

    @Operation(summary = "Registrar nuevo proyecto", description = "Crea un nuevo proyecto.")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ProyectoDTO proyectoDTO) {
        try {
            Proyecto nuevoProyecto = proyectoService.guardarProyecto(proyectoDTO);
            return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar el proyecto.");
        }
    }

    @Operation(summary = "Eliminar proyecto", description = "Borra de la base de datos por Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!proyectoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.ok("Proyecto eliminado correctamente");
    }
}
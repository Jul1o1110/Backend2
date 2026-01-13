package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Proyecto;
import com.portafolio.PrysmaPH.service.Proyecto.ProyectoServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
public class ProyectoController {

    private final ProyectoServiceInt proyectoService;

    public ProyectoController(ProyectoServiceInt proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public List<Proyecto> listar() {
        return proyectoService.listarProyectos();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Proyecto proyecto) {
        try {
            Proyecto nuevoProyecto = proyectoService.guardarProyecto(proyecto);
            return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar el proyecto.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!proyectoService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.ok("Proyecto eliminado correctamente");
    }
}
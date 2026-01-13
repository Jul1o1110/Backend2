package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Proyecto;
import com.portafolio.PrysmaPH.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping
    public List<Proyecto> listar() {
        return proyectoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Proyecto proyecto) {
        if (proyecto.getNombre() == null || proyecto.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del proyecto es obligatorio");
        }

        if (proyecto.getUrlRepositorio() != null && !proyecto.getUrlRepositorio().startsWith("http")) {
            return ResponseEntity.badRequest().body("La URL del repositorio debe ser un enlace válido");
        }

        if (proyecto.getTipoProyecto() == null || proyecto.getTipoProyecto().getId() == 0) {
            return ResponseEntity.badRequest().body("El proyecto debe estar asociado a un tipo de proyecto válido");
        }

        Proyecto nuevoProyecto = proyectoRepository.save(proyecto);
        return ResponseEntity.ok(nuevoProyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!proyectoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proyectoRepository.deleteById(id);
        return ResponseEntity.ok("Proyecto eliminado correctamente");
    }
}
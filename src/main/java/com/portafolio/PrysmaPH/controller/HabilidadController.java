package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Habilidad;
import com.portafolio.PrysmaPH.repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @GetMapping
    public List<Habilidad> listar() {
        return habilidadRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Habilidad habilidad) {
        if (habilidad.getNombre() == null || habilidad.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la habilidad es obligatorio");
        }

        if (habilidad.getTipo() == null || habilidad.getTipo().isEmpty()) {
            return ResponseEntity.badRequest().body("El tipo de habilidad es obligatorio");
        }

        Habilidad nuevaHabilidad = habilidadRepository.save(habilidad);
        return ResponseEntity.ok(nuevaHabilidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!habilidadRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        habilidadRepository.deleteById(id);
        return ResponseEntity.ok("Habilidad eliminada correctamente");
    }
}

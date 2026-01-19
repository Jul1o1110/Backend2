package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.dto.HabilidadDTO;
import com.portafolio.PrysmaPH.model.Habilidad;
import com.portafolio.PrysmaPH.service.Habilidad.HabilidadServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    private final HabilidadServiceInt habilidadService;

    public HabilidadController(HabilidadServiceInt habilidadService) {
        this.habilidadService = habilidadService;
    }

    @GetMapping
    public List<Habilidad> listar() {
        return habilidadService.listarHabilidades();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody HabilidadDTO habilidadDTO) {
        try {
            Habilidad nuevaHabilidad = habilidadService.guardarHabilidad(habilidadDTO);
            return new ResponseEntity<>(nuevaHabilidad, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar la habilidad.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!habilidadService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        
        habilidadService.eliminarHabilidad(id);
        return ResponseEntity.ok("Habilidad eliminada correctamente");
    }
}
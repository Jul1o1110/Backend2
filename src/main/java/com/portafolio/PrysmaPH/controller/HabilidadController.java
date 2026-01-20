package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.dto.HabilidadDTO;
import com.portafolio.PrysmaPH.model.Habilidad;
import com.portafolio.PrysmaPH.service.Habilidad.HabilidadServiceInt;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
@CrossOrigin(origins = "*")
@Tag(name = "Habilidades", description = "Habilidades de los ingenieros.")
public class HabilidadController {

    private final HabilidadServiceInt habilidadService;

    public HabilidadController(HabilidadServiceInt habilidadService) {
        this.habilidadService = habilidadService;
    }

    @Operation(summary = "Obtener lista de habilidades", description = "Retorna un listado de todas las habilidades de los ingenieros.")
    @GetMapping
    public List<Habilidad> listar() {
        return habilidadService.listarHabilidades();
    }

    @Operation(summary = "Resgistrar nueva habilidad", description = "Registra una nueva habilidad adquirida por una nueva tecnica.")
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

    @Operation(summary = "Eliminar habilidad", description = "Borra de la base de datos por Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (!habilidadService.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        
        habilidadService.eliminarHabilidad(id);
        return ResponseEntity.ok("Habilidad eliminada correctamente");
    }
}
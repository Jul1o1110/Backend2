package com.portafolio.PrysmaPH.controller;

import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag;
import com.portafolio.PrysmaPH.model.Experiencia;
import com.portafolio.PrysmaPH.dto.ExperienciaDTO;
import com.portafolio.PrysmaPH.service.Experiencia.ExperienciaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
@CrossOrigin(origins = "*")
@Tag(name = "Experiencias", description = "Operaciones para gestionar la trayectoria laboral")
public class ExperienciaController {

    private final ExperienciaServiceInt experienciaService;

    public ExperienciaController(ExperienciaServiceInt experienciaService) {
        this.experienciaService = experienciaService;
    }

    @Operation(summary = "Obtener lista de experiencias", description = "Retorna un listado de todas las experiencias laborales guardadas en la base de datos.")
    @GetMapping
    public List<Experiencia> listar() {
        return experienciaService.listarExperiencias();
    }

    @Operation(summary = "Registrar nueva experiencia", description = "Recibe un DTO de experiencia y lo guarda. Es necesario que el DTO sea válido.")
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ExperienciaDTO experienciaDTO) { 
        try {
            Experiencia nuevaExperiencia = experienciaService.guardarExperiencia(experienciaDTO);
            return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar la experiencia: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar experiencia por ID", description = "Borra físicamente el registro de la experiencia basado en el ID proporcionado en la URL.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        experienciaService.eliminarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
package com.portafolio.PrysmaPH.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.portafolio.PrysmaPH.model.Experiencia;
import com.portafolio.PrysmaPH.service.Experiencia.ExperienciaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/experiencias")
@CrossOrigin(origins = "*")
@Tag(name = "Experiencias", description = "Operaciones sobre experiencias")
public class ExperienciaController {

    private final ExperienciaServiceInt experienciaService;

    public ExperienciaController(ExperienciaServiceInt experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping
    public List<Experiencia> listar() {
        return experienciaService.listarExperiencias();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Experiencia experiencia) {
        try {
            Experiencia nuevaExperiencia = experienciaService.guardarExperiencia(experiencia);
            return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar la experiencia: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        experienciaService.eliminarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
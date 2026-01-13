package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Experiencia;
import com.portafolio.PrysmaPH.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping
    public List<Experiencia> listar() {
        return experienciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Experiencia experiencia) {
        if (experiencia.getTitulo() == null || experiencia.getTitulo().isEmpty()) {
            return ResponseEntity.badRequest().body("El título es obligatorio");
        }

        if (experiencia.getInstitucionEmpresa() == null || experiencia.getInstitucionEmpresa().isEmpty()) {
            return ResponseEntity.badRequest().body("La institución o empresa es obligatoria");
        }

        if (experiencia.getFechaInicio() == null) {
            return ResponseEntity.badRequest().body("La fecha de inicio es obligatoria");
        }

        if (experiencia.getPersona() == null || experiencia.getPersona().getId() == 0) {
            return ResponseEntity.badRequest().body("La experiencia debe estar asociada a una persona válida");
        }

        Experiencia nuevaExperiencia = experienciaRepository.save(experiencia);
        return ResponseEntity.ok(nuevaExperiencia);
    }
}
package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Persona;
import com.portafolio.PrysmaPH.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas") 
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
        
        if (persona.getNombreCompleto() == null || persona.getNombreCompleto().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre completo es obligatorio.");
        }

        if (persona.getEmail() == null || !persona.getEmail().contains("@")) {
            return ResponseEntity.badRequest().body("Debe proporcionar un email válido.");
        }

        Persona nuevaPersona = personaRepository.save(persona);
        return ResponseEntity.ok(nuevaPersona);
    }
}
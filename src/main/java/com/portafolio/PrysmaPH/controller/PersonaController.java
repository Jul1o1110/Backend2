package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.Persona;
import com.portafolio.PrysmaPH.service.Persona.PersonaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

    private final PersonaServiceInt personaService;

    public PersonaController(PersonaServiceInt personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAll() {
        return personaService.listarPersonas();
    }

    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
        try {
            Persona nuevaPersona = personaService.guardarPersona(persona);
            return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}
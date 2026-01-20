package com.portafolio.PrysmaPH.controller;
import com.portafolio.PrysmaPH.dto.PersonaDTO;
import com.portafolio.PrysmaPH.model.Persona;
import com.portafolio.PrysmaPH.service.Persona.PersonaServiceInt;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*")
@Tag(name = "Personas", description = "Creacion de ingenieros.")
public class PersonaController {

    private final PersonaServiceInt personaService;

    public PersonaController(PersonaServiceInt personaService) {
        this.personaService = personaService;
    }

    @Operation(summary = "Obtener listado de personas", description = "Trae un listado de todos los ingenieros y arquitectos registradas.")
    @GetMapping
    public List<Persona> getAll() {
        return personaService.listarPersonas();
    }

    @Operation(summary = "Registrar persona", description = "Crea un nuevo ingeniro o arquitecto.")
    @PostMapping
    public ResponseEntity<?> crearPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            Persona nuevaPersona = personaService.guardarPersona(personaDTO);
            return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar persona", description = "Borra de la base de datos por Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}
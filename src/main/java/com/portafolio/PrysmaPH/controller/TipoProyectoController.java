package com.portafolio.PrysmaPH.controller;

import com.portafolio.PrysmaPH.model.TipoProyecto;
import com.portafolio.PrysmaPH.repository.TipoProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-proyecto")
public class TipoProyectoController {

    @Autowired
    private TipoProyectoRepository tipoProyectoRepository;

    @GetMapping
    public List<TipoProyecto> listar() {
        return tipoProyectoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TipoProyecto tipoProyecto) {
        if (tipoProyecto.getNombre() == null || tipoProyecto.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del tipo de proyecto es obligatorio");
        }
        
        TipoProyecto nuevoTipo = tipoProyectoRepository.save(tipoProyecto);
        return ResponseEntity.ok(nuevoTipo);
    }
}
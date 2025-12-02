package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "EXPERIENCIA")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String institucionEmpresa;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Experiencia(String titulo, String institucionEmpresa, LocalDate fechaInicio, Persona persona) {
        this.titulo = titulo;
        this.institucionEmpresa = institucionEmpresa;
        this.fechaInicio = fechaInicio;
        this.persona = persona;
    }

}
package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
}
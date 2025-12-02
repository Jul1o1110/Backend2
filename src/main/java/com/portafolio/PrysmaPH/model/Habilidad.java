package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HABILIDAD")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "nivel_dominio")
    private String nivelDominio;

    @Column(nullable = false)
    private String tipo;

    public Habilidad(String nombre, String nivelDominio, String tipo) {
        this.nombre = nombre;
        this.nivelDominio = nivelDominio;
        this.tipo = tipo;
    }
}
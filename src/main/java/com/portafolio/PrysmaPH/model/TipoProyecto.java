package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TIPO_PROYECTO")
public class TipoProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "tipoProyecto", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;

    public TipoProyecto(String nombre) {
        this.nombre = nombre;
    }
}
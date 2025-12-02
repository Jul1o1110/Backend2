package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PROYECTO")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "descripcion_corta", length = 1024)
    private String descripcionCorta;

    @Column(name = "url_repositorio")
    private String urlRepositorio;

    @ManyToOne
    @JoinColumn(name = "tipo_proyecto_id")
    private TipoProyecto tipoProyecto;

    public Proyecto(String nombre, String descripcionCorta, String urlRepositorio, TipoProyecto tipoProyecto) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.urlRepositorio = urlRepositorio;
        this.tipoProyecto = tipoProyecto;
    }
}
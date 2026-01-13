package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "titulo_profesional")
    private String tituloProfesional;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "resumen_bio", length = 2048)
    private String resumenBio;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;
}
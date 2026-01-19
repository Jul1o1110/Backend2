package com.portafolio.PrysmaPH.dto;

import java.time.LocalDate;

public class ExperienciaDTO {
    
    private String titulo;
    private String institucionEmpresa;
    private LocalDate fechaInicio;
    private int personaId;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getInstitucionEmpresa() { return institucionEmpresa; }
    public void setInstitucionEmpresa(String institucionEmpresa) { this.institucionEmpresa = institucionEmpresa; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public int getPersonaId() { return personaId; }
    public void setPersonaId(int personaId) { this.personaId = personaId; }
}
package com.portafolio.PrysmaPH.dto;

public class PersonaDTO {
 
    private int id;
    private String nombreCompleto;
    private String tituloProfesional;
    private String email;
    private String resumenBio;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTituloProfesional() { return tituloProfesional; }
    public void setTituloProfesional(String tituloProfesional) { this.tituloProfesional = tituloProfesional; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getResumenBio() { return resumenBio; }
    public void setResumenBio(String resumenBio) { this.resumenBio = resumenBio; }  
}

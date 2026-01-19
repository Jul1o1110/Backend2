package com.portafolio.PrysmaPH.dto;

public class HabilidadDTO {
    
    private String nombre;
    private String nivelDominio;
    private String tipo;
    private int id;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivelDominio() { return nivelDominio; }
    public void setNivelDominio(String nivelDominio) { this.nivelDominio = nivelDominio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}

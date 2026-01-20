package com.portafolio.PrysmaPH.dto;

public class ProyectoDTO {
    
    private int id;
    private String nombre;
    private String descripcionCorta;
    private String urlRepositorio;
    private int tipoProyectoId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcionCorta() { return descripcionCorta; }
    public void setDescripcionCorta(String descripcionCorta) { this.descripcionCorta = descripcionCorta; }

    public String getUrlRepositorio() { return urlRepositorio; }
    public void setUrlRepositorio(String urlRepositorio) { this.urlRepositorio = urlRepositorio; }

    public int getTipoProyectoId() { return tipoProyectoId; }
    public void setTipoProyectoId(int tipoProyectoId) { this.tipoProyectoId = tipoProyectoId; }
}

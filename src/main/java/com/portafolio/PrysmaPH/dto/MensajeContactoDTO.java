package com.portafolio.PrysmaPH.dto;

import java.time.LocalDate;

public class MensajeContactoDTO {

    private int id;
    private String nombreRemitente;
    private String emailRemitente;
    private String mensaje;
    private LocalDate fechaEnvio;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreRemitente() { return nombreRemitente; }
    public void setNombreRemitente(String nombreRemitente) { this.nombreRemitente = nombreRemitente; }

    public String getEmailRemitente() { return emailRemitente; }
    public void setEmailRemitente(String emailRemitente) { this.emailRemitente = emailRemitente; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDate getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDate fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}

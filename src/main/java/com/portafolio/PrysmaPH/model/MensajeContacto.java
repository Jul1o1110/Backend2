package com.portafolio.PrysmaPH.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MENSAJE_CONTACTO")
public class MensajeContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombreRemitente;

    @Column(nullable = false)
    private String emailRemitente;

    @Column(nullable = false, length = 2048)
    private String mensaje;

    @Column()
    private LocalDateTime fechaEnvio;

    public MensajeContacto(String nombreRemitente, String emailRemitente, String mensaje, LocalDateTime fechaEnvio) {
        this.nombreRemitente = nombreRemitente;
        this.emailRemitente = emailRemitente;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
    }
}
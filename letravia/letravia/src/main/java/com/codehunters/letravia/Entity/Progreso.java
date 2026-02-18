package com.codehunters.letravia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso")
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int porcentaje;

    @Column
    private String estado;

    @Column
    private int puntos;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "lectura_id")
    private Long lecturaId;

    // Constructor vacío
    public Progreso() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getLecturaId() {
        return lecturaId;
    }

    public void setLecturaId(Long lecturaId) {
        this.lecturaId = lecturaId;
    }
}
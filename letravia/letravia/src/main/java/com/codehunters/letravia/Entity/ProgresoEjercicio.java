package com.codehunters.letravia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso_ejercicio")
public class ProgresoEjercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "progreso_id")
    private Long progresoId;

    @Column(name = "ejercicio_id")
    private Integer ejercicioId;

    @Column
    private String estado;

    public ProgresoEjercicio() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProgresoId() { return progresoId; }
    public void setProgresoId(Long progresoId) { this.progresoId = progresoId; }

    public Integer getEjercicioId() { return ejercicioId; }
    public void setEjercicioId(Integer ejercicioId) { this.ejercicioId = ejercicioId; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
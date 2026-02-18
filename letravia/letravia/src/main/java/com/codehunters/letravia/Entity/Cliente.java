package com.codehunters.letravia.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String ubicacion;

    @ManyToMany @JoinTable( name = "cliente_lecturas", joinColumns =
    @JoinColumn(name = "cliente_id"), inverseJoinColumns =
    @JoinColumn(name = "lectura_id")
    )
    @JsonManagedReference
    private Set<Lecturas> lecturas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int edad, String ubicacion, Set<Lecturas> lecturas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ubicacion = ubicacion;
        this.lecturas = lecturas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Lecturas> getLecturas() {
        return lecturas;
    }

    public void setLecturas(Set<Lecturas> lecturas) {
        this.lecturas = lecturas;
    }
}

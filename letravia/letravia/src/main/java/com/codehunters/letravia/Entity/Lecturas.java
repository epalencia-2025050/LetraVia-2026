package com.codehunters.letravia.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturas")
public class Lecturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo_lectura")
    private String tituloLectura;

    @Column(name = "nivel_lectura")
    private String nivelLectura;

    @Lob
    @Column(name = "documento")
    private String documento;

    @ManyToMany(mappedBy = "lecturas")
    @JsonBackReference
    private List<Cliente> clientes = new ArrayList<>();

    public Lecturas() {
    }

    public Lecturas(String tituloLectura, String nivelLectura, String documento, List<Cliente> clientes) {
        this.tituloLectura = tituloLectura;
        this.nivelLectura = nivelLectura;
        this.documento = documento;
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public String getTituloLectura() {
        return tituloLectura;
    }

    public void setTituloLectura(String tituloLectura) {
        this.tituloLectura = tituloLectura;
    }

    public String getNivelLectura() {
        return nivelLectura;
    }

    public void setNivelLectura(String nivelLectura) {
        this.nivelLectura = nivelLectura;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

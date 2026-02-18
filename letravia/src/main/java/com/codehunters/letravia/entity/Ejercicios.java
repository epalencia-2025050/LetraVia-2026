package com.codehunters.letravia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicios")
public class Ejercicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Debe ser autoincremental en MySQL

    @Column(nullable = false)
    private String pregunta;

    @Column(nullable = false)
    private String opcion1;

    @Column(nullable = false)
    private String opcion2;

    @Column(nullable = false)
    private String opcion3;

    @Column(name = "opcion_correcta", nullable = false)
    private String opcionCorrecta;

    @Column(nullable = false)
    private String grupo;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPregunta() { return pregunta; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }
    public String getOpcion1() { return opcion1; }
    public void setOpcion1(String opcion1) { this.opcion1 = opcion1; }
    public String getOpcion2() { return opcion2; }
    public void setOpcion2(String opcion2) { this.opcion2 = opcion2; }
    public String getOpcion3() { return opcion3; }
    public void setOpcion3(String opcion3) { this.opcion3 = opcion3; }
    public String getOpcionCorrecta() { return opcionCorrecta; }
    public void setOpcionCorrecta(String opcionCorrecta) { this.opcionCorrecta = opcionCorrecta; }
    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    // Constructores
    public Ejercicios() {}
    public Ejercicios(String pregunta, String opcion1, String opcion2, String opcion3, String opcionCorrecta, String grupo) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcionCorrecta = opcionCorrecta;
        this.grupo = grupo;
    }
}

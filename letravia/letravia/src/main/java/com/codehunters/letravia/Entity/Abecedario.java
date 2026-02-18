package com.codehunters.letravia.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "abecedario" )
public class Abecedario {
    @Id
    @Column
    private String letra;
    @Column
    private String letraEjemplo;

    public Abecedario() {
    }

    public Abecedario(String letra, String letraEjemplo) {
        this.letra = letra;
        this.letraEjemplo = letraEjemplo;
    }

    public String getLetraEjemplo() {
        return letraEjemplo;
    }

    public void setLetraEjemplo(String letraEjemplo) {
        this.letraEjemplo = letraEjemplo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
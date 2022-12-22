package com.example.apac3;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Socio")
public class Socio implements Serializable {
    @Id
    private String dni;
    @Column
    private String nom;
    @Column
    private String direccio;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "tiene",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(name = "FK_tiene"))
    private int tiene;

    public Socio() {
    }

    public Socio(String dni, String nom, String direccio, int tiene) {
        this.dni = dni;
        this.nom = nom;
        this.direccio = direccio;
        this.tiene = tiene;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public int getTiene() {
        return tiene;
    }

    public void setTiene(int tiene) {
        this.tiene = tiene;
    }

    
}

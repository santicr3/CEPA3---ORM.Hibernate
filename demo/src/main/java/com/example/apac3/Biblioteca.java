package com.example.apac3;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Biblioteca")
public class Biblioteca implements Serializable {
    
    @Id
    private String nom;

    @Column
    private String direccio;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="dni",
        foreignKey = @ForeignKey(name = "FK_es_socio" ))

    private int es_socio;
    
    @ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(name="Libro",
        joinColumns={@JoinColumn(
                name="id",
                foreignKey = @ForeignKey(name = "FK_esta_l" ))},
                inverseJoinColumns = {@JoinColumn(
                    name="nom",
                    foreignKey = @ForeignKey(name = "FK_esta_b" ))})
    private int esta;
    
    public Biblioteca(){
    }

    public Biblioteca(String nom, String direccio,int es_socio, int esta){
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

    public int getEs_socio() {
        return es_socio;
    }

    public void setEs_socio(int es_socio) {
        this.es_socio = es_socio;
    }

    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }

    
}

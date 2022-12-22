package com.example.apac3;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Libro")
public class Libro implements Serializable{
    @Id
    private int id;
    @Column
    private String titulo;
    @Column
    private String autor;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,
    mappedBy = "losModulos")
    private Biblioteca esta;
    
    public Libro() {
    }

    public Libro(int id, String titulo, String autor, Biblioteca esta) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.esta = esta;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Biblioteca getEsta() {
        return esta;
    }

    public void setEsta(Biblioteca esta) {
        this.esta = esta;
    }
}

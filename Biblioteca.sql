DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;

USE biblioteca;

#Un socio puede tener un libro
CREATE TABLE Socio(
	dni INT PRIMARY KEY,
    nom VARCHAR(30),
	direccio VARCHAR(30),
    tiene INT
);

#Una biblioteca puede tener muchos socios
CREATE TABLE Biblioteca(
    nom VARCHAR(30) PRIMARY KEY,
    direccio VARCHAR(30),
    es_socio INT,
    esta INT,
    FOREIGN KEY (es_socio) REFERENCES Socio(dni),
    FOREIGN KEY (esta) REFERENCES Esta(libro)
);

# Muchos libros pueden estar en muchas bibliotecas
CREATE TABLE Libro(
	id INT PRIMARY KEY,
    titulo VARCHAR(50),
    autor VARCHAR(30),
    esta VARCHAR(30),
    FOREIGN KEY (esta) REFERENCES Esta(biblioteca)
);

ALTER TABLE Socio ADD CONSTRAINT tiene FOREIGN KEY (tiene) REFERENCES Libro(id) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE Esta(
	biblioteca VARCHAR(30),
    libro int,
    FOREIGN KEY (biblioteca) REFERENCES Biblioteca(nom),
    FOREIGN KEY (libro) REFERENCES Libro(id)
);
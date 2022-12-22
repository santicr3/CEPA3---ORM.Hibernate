DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;

USE biblioteca;

#Un socio puede tener un libro
CREATE TABLE Socio(
	dni VARCHAR(9) PRIMARY KEY,
    nom VARCHAR(30),
	direccio VARCHAR(30),
    tiene INT
);

#Una biblioteca puede tener muchos socios
CREATE TABLE Biblioteca(
    nom VARCHAR(30) PRIMARY KEY,
    direccio VARCHAR(30),
    es_socio VARCHAR(9),
    esta INT
);

# Muchos libros pueden estar en muchas bibliotecas
CREATE TABLE Libro(
	id INT PRIMARY KEY,
    titulo VARCHAR(50),
    autor VARCHAR(30),
    esta VARCHAR(30)
);


CREATE TABLE Esta(
	biblioteca VARCHAR(30),
    libro int,
    FOREIGN KEY (biblioteca) REFERENCES Biblioteca(nom),
    FOREIGN KEY (libro) REFERENCES Libro(id)
);

ALTER TABLE Socio ADD CONSTRAINT FK_tiene FOREIGN KEY (tiene) REFERENCES Libro(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Biblioteca ADD CONSTRAINT FK_es_socio FOREIGN KEY (es_socio) REFERENCES Socio(dni) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Biblioteca ADD CONSTRAINT FK_esta_b FOREIGN KEY (esta) REFERENCES Esta(libro) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Libro ADD CONSTRAINT FK_esta_l FOREIGN KEY (esta) REFERENCES Esta(biblioteca) ON DELETE CASCADE ON UPDATE CASCADE;
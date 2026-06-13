CREATE DATABASE IF NOT EXISTS futbool;
USE futbool;

DROP TABLE IF EXISTS jugadores;
CREATE TABLE jugadores (
    id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    edad DECIMAL(10,2) NOT NULL,
    nacionalidad VARCHAR(100),
    posicion VARCHAR(50),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS entrenadores;
CREATE TABLE entrenadores (
    id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    edad DECIMAL(10,2) NOT NULL,
    posicion INT NOT NULL,
    nacionalidad VARCHAR(100),
    estrategia VARCHAR(100),
    experiencia_anios INT,
    sueldo DECIMAL(10,2),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS partidos;
CREATE TABLE partidos (
    id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    edad DECIMAL(10,2) NOT NULL,
    posicion INT NOT NULL,
    nacionalidad VARCHAR(100),
    PRIMARY KEY (id)
);

SELECT * FROM jugadores;
SELECT * FROM entrenadores;
SELECT * FROM partidos;
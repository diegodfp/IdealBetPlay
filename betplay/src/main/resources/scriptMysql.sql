-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `Rol_idRol` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_Rol1_idx` (`Rol_idRol` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Rol1`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permiso` (
  `idPermiso` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `Rol_idRol` INT NOT NULL,
  PRIMARY KEY (`idPermiso`),
  INDEX `fk_Permiso_Rol_idx` (`Rol_idRol` ASC) VISIBLE,
  CONSTRAINT `fk_Permiso_Rol`
    FOREIGN KEY (`Rol_idRol`)
    REFERENCES `mydb`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- estadio
CREATE TABLE IF NOT EXISTS estadio(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(200) NOT NULL,
  ubicacion VARCHAR(200) NOT NULL,
  capacidad INT NOT NULL
);

-- Equipo
CREATE TABLE IF NOT EXISTS equipo(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(200) NOT NULL,
  ciudad VARCHAR(200) NOT NULL,
  idEstadio INT NOT NULL,
  FOREIGN KEY(idEstadio) REFERENCES estadio(id)
);

-- Jugador 
CREATE TABLE IF NOT EXISTS jugador(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(200) NOT NULL,
  edad INT NOT NULL,
  posicion VARCHAR(20) NOT NULL,
  nacionalidad VARCHAR(50) NOT NULL,
  dorsal INT NOT NULL,
  idEquipo INT NOT NULL,
  FOREIGN KEY (idEquipo) REFERENCES equipo(id)
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

use mydb;

INSERT INTO Rol (nombre) values 
("administrador"),
("equipo tecnico"),
("arbitro"),
("aficionado"),
("periodista"),
("medico");
INSERT INTO Usuario (nombre, email, password, Rol_idRol) VALUES 
("administrador", "administrador@betplay.com", "123", 1),
("equipo_tecnico_1", "equipotecnico1@betplay.com", "123", 2),
("arbitro_1", "arbitro1@betplay.com", "123", 3),
("aficionado_1", "aficionado1@betplay.com", "123", 4),
("periodista_1", "periodista1@betplay.com", "123", 5),
("medico_1", "medico1@betplay.com", "123", 6),
("equipo_tecnico_2", "equipotecnico2@betplay.com", "123", 2),
("periodista_2", "periodista2@betplay.com", "123", 5);
INSERT INTO Permiso (descripcion, Rol_idRol) VALUES
("Gestión de Equipos", 1),
("Gestión de Jugadores", 1),
("Gestión de Jugadores", 2),
("Programación de Partidos", 1),
("Registro de Resultados", 1),
("Registro de Resultados", 3),
("Visualización de Estadísticas", 4),
("Visualización de Estadísticas", 5),
("Visualización de Estadísticas", 2),
("Gestión de Noticias y Comunicados", 1),
("Gestión de Noticias y Comunicados", 5),
("Gestión de Entrenadores", 1),
("Gestión de Entrenadores", 2),
("Gestión de Árbitros", 1),
("Gestión de Estadios", 1),
("Venta de Entradas", 4),
("Gestión de Patrocinios", 1),
("Generación de Informes", 1),
("Generación de Informes", 2),
("Gestión de Incidentes y Sanciones", 1),
("Gestión de Incidentes y Sanciones", 3),
("Consulta de Calendario de Partidos", 4),
("Consulta de Calendario de Partidos", 5),
("Consulta de Calendario de Partidos", 2),
("Gestión de Medios de Comunicación", 1),
("Gestión de Medios de Comunicación", 5),
("Gestión de Lesiones de Jugadores", 1),
("Gestión de Lesiones de Jugadores", 6),
("Gestión de Entrenamientos", 1),
("Seguimiento de Rendimiento de Jugadores", 2),
("Gestión de Transferencias de Jugadores", 1),
("Gestión de Transferencias de Jugadores", 2),
("Gestión de Equipamiento", 1),
("Gestión de Equipamiento", 2),
("Gestión de Convocatorias de Jugadores", 2),
("Gestión de Premios y Reconocimientos", 1),
("Gestión de Usuarios y Roles", 1),
("Gestión de Patrocinadores y Publicidad", 1),
("Gestión de Relaciones Públicas", 1),
("Gestión de Relaciones Públicas", 5);

CREATE TABLE partido(
  id INT PRIMARY KEY auto_increment,
  idEquipoLocal int,
  idEquipoVisitante int,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  idEstadio INT NOT NULL,
  golesLocal INT NOT NULL,
  golesVisitante INT NOT NULL,
  Foreign Key (idEquipoLocal) REFERENCES equipo(id),
  Foreign Key (idEquipoVisitante) REFERENCES equipo(id),
  Foreign Key (idEstadio) REFERENCES estadio(id)
);
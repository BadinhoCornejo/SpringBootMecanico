use mecanicodb;

SET
    FOREIGN_KEY_CHECKS = 0;

SET
    GLOBAL time_zone = '-3:00';

/* Drop Tables */
DROP TABLE IF EXISTS `ServicioMecanico` CASCADE;
DROP TABLE IF EXISTS `DetalleServicio` CASCADE;
DROP TABLE IF EXISTS `ServiciosSolicitados` CASCADE;
DROP TABLE IF EXISTS `Usuario` CASCADE;
DROP TABLE IF EXISTS `Roles` CASCADE;
DROP TABLE IF EXISTS `Servicio` CASCADE;
DROP TABLE IF EXISTS `Cliente` CASCADE;
DROP TABLE IF EXISTS `Personal` CASCADE;

/*Create tables*/

CREATE TABLE `Usuario`(
    `usuarioID` INT NOT NULL AUTO_INCREMENT,
    `username` NVARCHAR(30) NOT NULL,
    `password` NVARCHAR(100) NOT NULL,
    `roleID` INT NOT NULL,
    CONSTRAINT `PK_Usuario` PRIMARY KEY (`usuarioID` ASC)
);

CREATE TABLE `Roles`(
    `roleID` INT NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(20) NOT NULL,
    CONSTRAINT `PK_Role` PRIMARY KEY (`roleID` ASC)
);

CREATE TABLE `Servicio` (
    `servicioID` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `monto` DECIMAL(10,2) NULL,
    CONSTRAINT `PK_Servicio` PRIMARY KEY (`servicioID` ASC)
);

CREATE TABLE `Cliente` (
    `clienteID` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `apellidos` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_Cliente` PRIMARY KEY (`clienteID` ASC)
);

CREATE TABLE `Personal` (
    `personalID` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `apellidos` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_Personal` PRIMARY KEY (`personalID` ASC)
);

CREATE TABLE `ServicioMecanico` (
    `servmcID` INT NOT NULL AUTO_INCREMENT,
    `fecha` DATETIME NOT NULL,
    `personalID` INT NOT NULL,
    `clienteID` INT NOT NULL,
    CONSTRAINT `PK_ServicioMecanico` PRIMARY KEY (`servmcID` ASC)
);

CREATE TABLE `DetalleServicio` (
    `servdtID` INT NOT NULL AUTO_INCREMENT,
    `servmcID` INT NOT NULL,
    `servicioID` INT NOT NULL,
    `marca` VARCHAR(50) NOT NULL,
    `modelo` VARCHAR(50) NOT NULL,
    `placa` VARCHAR(10) NOT NULL,
    `contenido` VARCHAR(255) NOT NULL,
    CONSTRAINT `PK_DetalleServicio` PRIMARY KEY (`servdtID` ASC)
);

CREATE TABLE `ServiciosSolicitados` (
    `servsoID` INT NOT NULL AUTO_INCREMENT,
    `servicioID` INT NOT NULL,
    `clienteID` INT NOT NULL,
    `fecha` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_ServiciosSolicitados` PRIMARY KEY (`servsoID` ASC)
);

/* Create Foreign Key Constraints */
ALTER TABLE
  `Usuario`
ADD
  CONSTRAINT `FK_Usuario_Role` FOREIGN KEY (`roleID`) REFERENCES `Roles` (`roleID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `ServicioMecanico`
ADD
  CONSTRAINT `FK_Servmc_Personal` FOREIGN KEY (`personalID`) REFERENCES `Personal` (`personalID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `ServicioMecanico`
ADD
  CONSTRAINT `FK_Servmc_Cliente` FOREIGN KEY (`clienteID`) REFERENCES `Cliente` (`clienteID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `DetalleServicio`
ADD
  CONSTRAINT `FK_Servdt_Mec` FOREIGN KEY (`servmcID`) REFERENCES `ServicioMecanico` (`servmcID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `DetalleServicio`
ADD
  CONSTRAINT `FK_Servdt_Serv` FOREIGN KEY (`servicioID`) REFERENCES `Servicio` (`servicioID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `ServiciosSolicitados`
ADD
  CONSTRAINT `FK_Servso_Serv` FOREIGN KEY (`servicioID`) REFERENCES `Servicio` (`servicioID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `ServiciosSolicitados`
ADD
  CONSTRAINT `FK_Servso_Cli` FOREIGN KEY (`clienteID`) REFERENCES `Cliente` (`clienteID`) ON DELETE No Action ON UPDATE No Action;

-- MySQL Script generated by MySQL Workbench
-- 09/18/16 22:39:22
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fhir
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fhir
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fhir` DEFAULT CHARACTER SET utf8 ;
USE `fhir` ;

-- -----------------------------------------------------
-- Table `fhir`.`glucose`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fhir`.`glucose` ;

CREATE TABLE IF NOT EXISTS `fhir`.`glucose` (
  `id` INT UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `identifier` JSON NOT NULL,
  `code` JSON NOT NULL,
  `subject` JSON NOT NULL,
  `issued` TEXT NOT NULL,
  `performer` JSON NOT NULL,
  `valueQuantity` JSON NOT NULL,
  `interpretation` JSON NOT NULL,
  `referenceRange` JSON NOT NULL,
  `comments` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `idgluc_UNIQUE` ON `fhir`.`glucose` (`id` ASC);


-- -----------------------------------------------------
-- Table `fhir`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fhir`.`patient` ;

CREATE TABLE IF NOT EXISTS `fhir`.`patient` (
  `id` INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `identifier` JSON NOT NULL,
  `name` JSON NOT NULL,
  `telecom` JSON NOT NULL,
  `gender` TINYTEXT NOT NULL,
  `birthDate` TINYTEXT NOT NULL,
  `address` JSON NOT NULL,
  `maritalStatus` JSON NOT NULL,
  `contact` JSON NOT NULL,
  `communication` JSON NOT NULL,
  `managingOrganization` LONGTEXT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `token_id` VARCHAR(200) NOT NULL,
  `bloodType` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fhir`.`personal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fhir`.`personal` ;

CREATE TABLE IF NOT EXISTS `fhir`.`personal` (
  `id` INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `identifier` JSON NOT NULL,
  `name` JSON NOT NULL,
  `telecom` JSON NOT NULL,
  `address` JSON NULL DEFAULT NULL,
  `gender` TINYTEXT NOT NULL,
  `birthDate` TINYTEXT NOT NULL,
  `practitionerRole` JSON NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `token_id` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `id_UNIQUE` ON `fhir`.`personal` (`id` ASC);


-- -----------------------------------------------------
-- Table `fhir`.`root`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fhir`.`root` ;

CREATE TABLE IF NOT EXISTS `fhir`.`root` (
  `id` INT(11) UNSIGNED ZEROFILL NOT NULL,
  `ndi` VARCHAR(45) NOT NULL,
  `ndiValue` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `fhir`.`root` (`id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
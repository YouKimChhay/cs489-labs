-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ads-system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ads-system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ads-system` DEFAULT CHARACTER SET utf8 ;
USE `ads-system` ;

-- -----------------------------------------------------
-- Table `ads-system`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ads-system`.`address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ads-system`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ads-system`.`patient` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  `address_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patient_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `ads-system`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ads-system`.`dentist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ads-system`.`dentist` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `specialization` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ads-system`.`surgery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ads-system`.`surgery` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_surgery-location_address_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_surgery-location_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `ads-system`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ads-system`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ads-system`.`appointment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `datetime` DATETIME NOT NULL,
  `patient_id` INT UNSIGNED NOT NULL,
  `dentist_id` INT UNSIGNED NOT NULL,
  `surgery_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_appointment_patient1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_appointment_dentist1_idx` (`dentist_id` ASC) VISIBLE,
  INDEX `fk_appointment_surgery1_idx` (`surgery_id` ASC) VISIBLE,
  CONSTRAINT `fk_appointment_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `ads-system`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_dentist1`
    FOREIGN KEY (`dentist_id`)
    REFERENCES `ads-system`.`dentist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_surgery1`
    FOREIGN KEY (`surgery_id`)
    REFERENCES `ads-system`.`surgery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- -----------------------------------------------------
-- Populate the Database tables with dummy data
-- -----------------------------------------------------
INSERT INTO address
  (street, city, state, zipcode)
VALUES
  ('1000 N 4th St', 'Fairfield', 'IA', '52556'),
  ('2000 S Main St', 'Fairfield', 'IA', '52556'),
  ('1300 W Burlington Ave', 'Fairfield', 'IA', '52556'),
  ('2701 W Burlington Ave', 'Fairfield', 'IA', '52556'),
  ('1000 Granville Ave', 'Fairfield', 'IA', '52556');


INSERT INTO surgery
  (name, phone, address_id)
VALUES
  ('ADS 1', '555-123-9876', 1),
  ('ADS 2', '555-123-9886', 2);


INSERT INTO dentist
  (firstName, lastName, phone, email, specialization)
VALUES
  ('John', 'Doe', '555-999-1234', 'johnd@ads.com', 'Prosthodontist'),
  ('Mary', 'Jane', '555-999-1235', 'maryj@ads.com', 'Bone grafting'),
  ('Sarah', 'Robin', '555-999-1236', 'sarahr@ads.com', 'Dental implant'),
  ('Cindy', 'Anna', '555-999-1234', 'cindya@ads.com', 'Orthodontics');


INSERT INTO patient
  (firstName, lastName, phone, email, dateOfBirth, address_id)
VALUES
  ('Ava', 'Carter', '555-987-9090', 'avac@gmail.com', '1989-12-15', 3),
  ('Bob', 'Carter', '555-987-9090', 'bobc@gmail.com', '1988-08-23', 3),
  ('Liam', 'Patel', '555-987-8080', 'liamp@yahoo.com', '1990-10-05', 4),
  ('Noah', 'Patel', '555-987-8080', 'noahp@yahoo.com', '2001-05-20', 4),
  ('Sophia', 'Williams', '555-987-7077', 'sophiaw@gmail.com', '1996-03-21', 5);


INSERT INTO appointment
  (datetime, patient_id, dentist_id, surgery_id)
VALUES
  ('2024-04-15 10:00:00', 3, 1, 1),
  ('2024-04-16 12:00:00', 4, 1, 1),
  ('2024-04-15 10:00:00', 1, 3, 2),
  ('2024-04-17 10:00:00', 5, 3, 2),
  ('2024-04-20 15:00:00', 2, 3, 2);


-- -----------------------------------------------------
-- SQL Queries
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Display the list of ALL Dentists registered in the system, sorted in ascending
order of their lastNames
-- -----------------------------------------------------
SELECT *
FROM dentist
ORDER BY lastName;


-- -----------------------------------------------------
-- Display the list of ALL Appointments for a given Dentist by their dentist_Id
number. Include in the result, the Patient information.
-- -----------------------------------------------------
SELECT a.id AS appointment_id, a.datetime, a.dentist_id, p.*
FROM appointment AS a
JOIN patient AS p
ON a.patient_id = p.id
WHERE a.dentist_id = 3;


-- -----------------------------------------------------
-- Display the list of ALL Appointments that have been scheduled at a Surgery
Location
-- -----------------------------------------------------
SELECT *
FROM appointment
WHERE surgery_id = 1;


-- -----------------------------------------------------
-- Display the list of the Appointments booked for a given Patient on a given Date
-- -----------------------------------------------------
SELECT *
FROM appointment
WHERE patient_id = 2 AND DATE(datetime) = '2024-04-20';


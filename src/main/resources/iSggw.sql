-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema local_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema local_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `local_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `local_db` ;

-- -----------------------------------------------------
-- Table `local_db`.`buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`buildings` (
  `id` BIGINT UNIQUE NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `number` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`floors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`floors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
  `level` VARCHAR(255) NULL DEFAULT NULL,
  `building_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKdhibx5frs3cwiltccr79uks37` (`building_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(19) unsigned DEFAULT NULL,
  `last_updated_by` bigint(19) unsigned DEFAULT NULL,	
  `manufacturer` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `serial_number` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `room_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKmgtx1ngyf35vl0pl95w5kdebe` (`room_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `room_nbr` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `floor_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK71tvfklk03awky6oydmacgcoo` (`floor_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  INDEX `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id` ASC) VISIBLE,
  INDEX `FKj345gk1bovqvfame88rcx7yyx` (`user_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `local_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `local_db`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NOT NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NOT NULL DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL DEFAULT NULL,
  `username` VARCHAR(255) NOT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into roles values (1, 'ADMIN'), (2, 'USER')

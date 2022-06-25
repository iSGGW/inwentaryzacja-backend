-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema isggw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema isggw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `isggw` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `isggw` ;

-- -----------------------------------------------------
-- Table `isggw`.`buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`buildings` (
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
-- Table `isggw`.`floors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`floors` (
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
-- Table `isggw`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`items` (
                                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               `created_by` VARCHAR(255) NULL DEFAULT NULL,
    `last_updated_by` VARCHAR(255) NULL DEFAULT NULL,
    `manufacturer` VARCHAR(255) NULL DEFAULT NULL,
    `name` VARCHAR(255) NULL DEFAULT NULL,
    `serial_number` VARCHAR(255) NULL DEFAULT NULL,
    `status` BIGINT NULL NOT NULL,
    `type` VARCHAR(255) NULL DEFAULT NULL,
    `room_id` BIGINT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `FKmgtx1ngyf35vl0pl95w5kdebe` (`room_id` ASC) VISIBLE)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `isggw`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`roles` (
                                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = MyISAM
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `isggw`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`rooms` (
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
-- Table `isggw`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`user_role` (
                                                   `user_id` BIGINT NOT NULL,
                                                   `role_id` BIGINT NOT NULL,
                                                   INDEX `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id` ASC) VISIBLE,
    INDEX `FKj345gk1bovqvfame88rcx7yyx` (`user_id` ASC) VISIBLE)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `isggw`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `isggw`.`users` (
                                               `id` BIGINT NOT NULL AUTO_INCREMENT,
                                               `email` VARCHAR(255) NOT NULL ,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = MyISAM
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into roles values (1, 'ADMIN'), (2, 'USER')

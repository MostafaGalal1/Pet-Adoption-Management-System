-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb`;
USE `mydb`;

-- -----------------------------------------------------
-- Table `mydb`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`account`
(
    `Id`       INT AUTO_INCREMENT,
    `email`    VARCHAR(50)  NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role`     VARCHAR(7)   NOT NULL,
    PRIMARY KEY (`Id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`admin`
(
    `id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `AccountAdmin_idx` (`id` ASC) VISIBLE,
    CONSTRAINT `AccountAdmin`
        FOREIGN KEY (`id`)
            REFERENCES `mydb`.`account` (`Id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`adopter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adopter`
(
    `id`      INT         NOT NULL,
    `name`    VARCHAR(50) NOT NULL,
    `contact` VARCHAR(25) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `AccountAdopter_idx` (`id` ASC) VISIBLE,
    CONSTRAINT `AccountAdopter`
        FOREIGN KEY (`id`)
            REFERENCES `mydb`.`account` (`Id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`staff`
(
    `id`        INT         NOT NULL,
    `name`      VARCHAR(50) NOT NULL,
    `jobTitle`  VARCHAR(25) NOT NULL,
    `contact`   VARCHAR(25) NOT NULL,
    `shelterId` INT         NULL,
    PRIMARY KEY (`id`),
    INDEX `shelter_staff_id_idx` (`shelterId` ASC) VISIBLE,
    CONSTRAINT `AccountStaff`
        FOREIGN KEY (`id`)
            REFERENCES `mydb`.`account` (`Id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`shelter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shelter`
(
    `id`        INT         NOT NULL,
    `name`      VARCHAR(50) NOT NULL,
    `location`  VARCHAR(50) NOT NULL,
    `contact`   VARCHAR(25) NOT NULL,
    `managerId` INT         NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `manager_id_UNIQUE` (`managerId` ASC) VISIBLE,
    CONSTRAINT `StaffShelter`
        FOREIGN KEY (`managerId`)
            REFERENCES `mydb`.`staff` (`id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pet`
(
    `id`           INT          NOT NULL,
    `name`         VARCHAR(50)  NOT NULL,
    `species`      VARCHAR(25)  NOT NULL,
    `breed`        VARCHAR(25)  NOT NULL,
    `age`          INT          NULL,
    `gender`       VARCHAR(6)   NOT NULL,
    `healthStatus` VARCHAR(25)  NOT NULL,
    `behaviour`    VARCHAR(25)  NOT NULL,
    `description`  VARCHAR(511) NULL DEFAULT NULL,
    `shelterId`    INT          NULL,
    `vaccinated`   TINYINT      NOT NULL,
    `Castrated`    TINYINT      NOT NULL,
    `houseTrained` TINYINT      NOT NULL,
    `adopted`      TINYINT      NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `pet_selter_idx` (`shelterId` ASC) INVISIBLE,
    INDEX `species_idx` (`species` ASC) INVISIBLE,
    INDEX `breed_idx` (`breed` ASC) INVISIBLE,
    INDEX `age_idx` (`age` ASC) VISIBLE,
    CONSTRAINT `pet_selter`
        FOREIGN KEY (`shelterId`)
            REFERENCES `mydb`.`shelter` (`id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`adoptionapplication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adoptionapplication`
(
    `petId`     INT        NOT NULL,
    `adopterId` INT        NOT NULL,
    `status`    VARCHAR(8) NULL DEFAULT NULL,
    PRIMARY KEY (`petId`, `adopterId`),
    INDEX `application_adopter_idx` (`adopterId` ASC) VISIBLE,
    CONSTRAINT `ApplicationAdopter`
        FOREIGN KEY (`adopterId`)
            REFERENCES `mydb`.`adopter` (`id`),
    CONSTRAINT `ApplicationPet`
        FOREIGN KEY (`petId`)
            REFERENCES `mydb`.`pet` (`id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`adoptionrecord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adoptionrecord`
(
    `petId`     INT NOT NULL,
    `adopterId` INT NOT NULL,
    `staffId`   INT NOT NULL,
    PRIMARY KEY (`petId`, `adopterId`, `staffId`),
    INDEX `adopted-adopter_id_idx` (`adopterId` ASC) VISIBLE,
    INDEX `StaffAdoption_idx` (`staffId` ASC) VISIBLE,
    CONSTRAINT `AdopterAdoption`
        FOREIGN KEY (`adopterId`)
            REFERENCES `mydb`.`adopter` (`id`),
    CONSTRAINT `PetAdoption`
        FOREIGN KEY (`petId`)
            REFERENCES `mydb`.`pet` (`id`),
    CONSTRAINT `StaffAdoption`
        FOREIGN KEY (`staffId`)
            REFERENCES `mydb`.`staff` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table `mydb`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`document`
(
    `petId`      INT          NOT NULL,
    `documentId` INT          NOT NULL,
    `type`       VARCHAR(25)  NOT NULL,
    `link`       VARCHAR(255) NOT NULL,
    PRIMARY KEY (`petId`, `documentId`),
    CONSTRAINT `PetDocument`
        FOREIGN KEY (`petId`)
            REFERENCES `mydb`.`pet` (`id`)
);


-- -----------------------------------------------------
-- Table `mydb`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`image`
(
    `petId`   INT          NOT NULL,
    `imageId` INT          NOT NULL,
    `link`    VARCHAR(255) NOT NULL,
    PRIMARY KEY (`petId`, `imageId`),
    CONSTRAINT `PetImage`
        FOREIGN KEY (`petId`)
            REFERENCES `mydb`.`pet` (`id`)
);

ALTER TABLE mydb.staff
    ADD CONSTRAINT ShelterStaff
        FOREIGN KEY (shelterId)
            REFERENCES mydb.shelter (id);

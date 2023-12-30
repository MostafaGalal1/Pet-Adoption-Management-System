-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `mydb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mydb`;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(7) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin@example.com','adminpassword','ADMIN'),(2,'adopter@example.com','adopterpassword','ADOPTER'),(3,'staff@example.com','staffpassword','STAFF'),(4,'mostafa1@lol.com','lol','ADOPTER');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AccountAdmin_idx` (`id`),
  CONSTRAINT `AccountAdmin` FOREIGN KEY (`id`) REFERENCES `account` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adopter`
--

DROP TABLE IF EXISTS `adopter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adopter` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `contact` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `AccountAdopter_idx` (`id`),
  CONSTRAINT `AccountAdopter` FOREIGN KEY (`id`) REFERENCES `account` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopter`
--

LOCK TABLES `adopter` WRITE;
/*!40000 ALTER TABLE `adopter` DISABLE KEYS */;
INSERT INTO `adopter` VALUES (1,'John Doe','123-456-7899'),(2,'John Doe','123-456-7890'),(3,'Jane Doe','987-654-3210');
/*!40000 ALTER TABLE `adopter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adoptionapplication`
--

DROP TABLE IF EXISTS `adoptionapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adoptionapplication` (
  `petId` int NOT NULL,
  `adopterId` int NOT NULL,
  `status` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`petId`,`adopterId`),
  KEY `application_adopter_idx` (`adopterId`),
  CONSTRAINT `ApplicationAdopter` FOREIGN KEY (`adopterId`) REFERENCES `adopter` (`id`),
  CONSTRAINT `ApplicationPet` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoptionapplication`
--

LOCK TABLES `adoptionapplication` WRITE;
/*!40000 ALTER TABLE `adoptionapplication` DISABLE KEYS */;
INSERT INTO `adoptionapplication` VALUES (1,1,'PENDING'),(1,2,'PENDING'),(1,3,'PENDING'),(2,1,'PENDING'),(2,2,'PENDING'),(2,3,'PENDING'),(3,1,'PENDING'),(3,2,'PENDING'),(3,3,'PENDING');
/*!40000 ALTER TABLE `adoptionapplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adoptionrecord`
--

DROP TABLE IF EXISTS `adoptionrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adoptionrecord` (
  `petId` int NOT NULL,
  `adopterId` int NOT NULL,
  `staffId` int NOT NULL,
  PRIMARY KEY (`petId`,`adopterId`,`staffId`),
  KEY `adopted-adopter_id_idx` (`adopterId`),
  KEY `StaffAdoption_idx` (`staffId`),
  CONSTRAINT `AdopterAdoption` FOREIGN KEY (`adopterId`) REFERENCES `adopter` (`id`),
  CONSTRAINT `PetAdoption` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`),
  CONSTRAINT `StaffAdoption` FOREIGN KEY (`staffId`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoptionrecord`
--

LOCK TABLES `adoptionrecord` WRITE;
/*!40000 ALTER TABLE `adoptionrecord` DISABLE KEYS */;
INSERT INTO `adoptionrecord` VALUES (1,2,1),(2,3,2);
/*!40000 ALTER TABLE `adoptionrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `petId` int NOT NULL,
  `documentId` int NOT NULL,
  `type` varchar(25) NOT NULL,
  `link` varchar(255) NOT NULL,
  PRIMARY KEY (`petId`,`documentId`),
  CONSTRAINT `PetDocument` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,1,'Vaccination Record','vaccination_link'),(2,2,'Medical History','medical_history_link');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `petId` int NOT NULL,
  `imageId` int NOT NULL,
  `link` varchar(255) NOT NULL,
  PRIMARY KEY (`petId`,`imageId`),
  CONSTRAINT `PetImage` FOREIGN KEY (`petId`) REFERENCES `pet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,1,'image_link_1'),(2,2,'image_link_2');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `species` varchar(25) NOT NULL,
  `breed` varchar(25) NOT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `healthStatus` varchar(25) NOT NULL,
  `behaviour` varchar(25) NOT NULL,
  `description` varchar(511) DEFAULT NULL,
  `shelterId` int DEFAULT NULL,
  `vaccinated` tinyint NOT NULL,
  `Castrated` tinyint NOT NULL,
  `houseTrained` tinyint NOT NULL,
  `adopted` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_selter_idx` (`shelterId`) /*!80000 INVISIBLE */,
  KEY `species_idx` (`species`) /*!80000 INVISIBLE */,
  KEY `breed_idx` (`breed`) /*!80000 INVISIBLE */,
  KEY `age_idx` (`age`),
  CONSTRAINT `pet_selter` FOREIGN KEY (`shelterId`) REFERENCES `shelter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,'Pet 1','Dog','Breed 1',2,'MALE','HEALTHY','FRIENDLY','Description 1',1,1,0,1,0),(2,'Pet 2','Cat','Breed 2',3,'FEMALE','HEALTHY','SHY','Description 2',2,1,1,0,0),(3,'Pet 3','Cat','Breed 2',3,'FEMALE','HEALTHY','SHY','Description 2',2,1,1,0,0);
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shelter`
--

DROP TABLE IF EXISTS `shelter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shelter` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `contact` varchar(25) NOT NULL,
  `managerId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `manager_id_UNIQUE` (`managerId`),
  CONSTRAINT `StaffShelter` FOREIGN KEY (`managerId`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelter`
--

LOCK TABLES `shelter` WRITE;
/*!40000 ALTER TABLE `shelter` DISABLE KEYS */;
INSERT INTO `shelter` VALUES (1,'Shelter 1','Location 1','111-222-3333',1),(2,'Shelter 2','Location 2','444-555-6666',2);
/*!40000 ALTER TABLE `shelter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `jobTitle` varchar(25) NOT NULL,
  `contact` varchar(25) NOT NULL,
  `shelterId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shelter_staff_id_idx` (`shelterId`),
  CONSTRAINT `AccountStaff` FOREIGN KEY (`id`) REFERENCES `account` (`Id`),
  CONSTRAINT `ShelterStaff` FOREIGN KEY (`shelterId`) REFERENCES `shelter` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Staff Member 1','MANAGER','111-222-3333',1),(2,'Staff Member 2','VET','444-555-6666',2);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-30 10:32:44

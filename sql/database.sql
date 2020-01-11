-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: AtlantaMovie
-- ------------------------------------------------------
-- Server version	8.0.18

CREATE DATABASE  IF NOT EXISTS `AtlantaMovie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `AtlantaMovie`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  CONSTRAINT `fk9` FOREIGN KEY (`Username`) REFERENCES `employee` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin'),('cool_class4400');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('4400 Theater Company'),('AI Theater Company'),('Awesome Theater Company'),('EZ Theater Company');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcard` (
  `CreditCardNum` varchar(45) NOT NULL,
  `Owner` varchar(45) NOT NULL,
  PRIMARY KEY (`CreditCardNum`),
  KEY `fk16_idx` (`Owner`),
  CONSTRAINT `fk16` FOREIGN KEY (`Owner`) REFERENCES `customer` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES ('1111111111000000','calcultron'),('1111111100000000','calcultron2'),('1111111110000000','calcultron2'),('1111111111100000','calcwizard'),('2222222222000000','cool_class4400'),('0123456789123456','customer'),('1111111100000011','customer2'),('2220000000000000','DNAhelix'),('2222222200000000','does2Much'),('2222222222222200','eeqmcsquare'),('2222222222200000','entropyRox'),('2222222222220000','entropyRox'),('1100000000000000','fullMetal'),('1111111111110000','georgep'),('1111111111111000','georgep'),('1111111111111100','georgep'),('1111111111111110','georgep'),('1111111111111111','georgep'),('2222222222222220','ilikemoney$$'),('2222222222222222','ilikemoney$$'),('9000000000000000','ilikemoney$$'),('1111110000000000','imready'),('1110000000000000','isthisthekrustykrab'),('1111000000000000','isthisthekrustykrab'),('1111100000000000','isthisthekrustykrab'),('1000000000000000','notFullMetal'),('2222222000000000','programerAAL'),('3333333333333300','RitzLover28'),('2222222220000000','thePiGuy3.14'),('2222222222222000','theScienceGuy');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  CONSTRAINT `fk8` FOREIGN KEY (`Username`) REFERENCES `user` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('calcultron'),('calcultron2'),('calcwizard'),('clarinetbeast'),('cool_class4400'),('customer'),('customer2'),('DNAhelix'),('does2Much'),('eeqmcsquare'),('entropyRox'),('fullMetal'),('georgep'),('ilikemoney$$'),('imready'),('isthisthekrustykrab'),('notFullMetal'),('programerAAL'),('RitzLover28'),('thePiGuy3.14'),('theScienceGuy');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `Username` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  CONSTRAINT `fk7` FOREIGN KEY (`Username`) REFERENCES `user` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('admin'),('calcultron'),('cool_class4400'),('entropyRox'),('fatherAI'),('georgep'),('ghcghc'),('imbatman'),('manager'),('manager1'),('manager2'),('manager3'),('manager4'),('radioactivePoRa');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `Username` varchar(45) NOT NULL,
  `Zipcode` varchar(45) NOT NULL DEFAULT ' ',
  `Street` varchar(45) NOT NULL DEFAULT ' ',
  `City` varchar(45) NOT NULL DEFAULT ' ',
  `State` varchar(2) NOT NULL,
  `Works_in` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `UniqueAddress` (`Zipcode`,`City`,`Street`,`State`),
  KEY `validWorksIn_idx` (`Works_in`),
  CONSTRAINT `fk10` FOREIGN KEY (`Username`) REFERENCES `employee` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk11` FOREIGN KEY (`Works_in`) REFERENCES `company` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('calcultron','30308','123 Peachtree St','Atlanta','GA','EZ Theater Company'),('entropyRox','94016','200 Cool Place','San Francisco','CA','4400 Theater Company'),('fatherAI','10001','456 Main St','New York','NY','EZ Theater Company'),('georgep','98105','10 Pearl Dr','Seattle','WA','4400 Theater Company'),('ghcghc','31415','100 Pi St','Pallet Town','KS','AI Theater Company'),('imbatman','78653','800 Color Dr','Austin','TX','Awesome Theater Company'),('manager','30339','2550 Akera MILL RD SE','Atlanta','GA','4400 Theater Company'),('manager1','30332','123 Ferst Drive','Atlanta','GA','4400 Theater Company'),('manager2','30332','456 Ferst Drive','Atlanta','GA','AI Theater Company'),('manager3','30332','789 Ferst Drive','Atlanta','GA','4400 Theater Company'),('manager4','30332','000 Ferst Drive','Atlanta','GA','4400 Theater Company'),('radioactivePoRa','94088','100 Blu St','Sunnyvale','CA','4400 Theater Company');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `Name` varchar(45) NOT NULL,
  `ReleaseDate` date NOT NULL,
  `Duration` int(11) NOT NULL,
  PRIMARY KEY (`Name`,`ReleaseDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('4400 The Movie','2019-08-12',130),('avengers','2018-05-01',180),('Avengers: Endgame','2019-04-26',181),('avengers2','2018-06-01',180),('Calculus Returns: A ML Story','2019-09-19',314),('George P Burdell\'s Life Story','1927-08-12',100),('Georgia Tech The Movie','1985-08-13',100),('How to Train Your Dragon','2010-03-21',98),('Spaceballs','1987-06-24',96),('Spider-Man: Into the Spider-Verse','2018-12-01',117),('The First Pokemon Movie','1998-07-19',75),('The King\'s Speech','2010-11-26',119);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieplay`
--

DROP TABLE IF EXISTS `movieplay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieplay` (
  `MovieName` varchar(45) NOT NULL,
  `ReleaseDate` date NOT NULL,
  `CompanyName` varchar(45) NOT NULL,
  `TheaterName` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`MovieName`,`ReleaseDate`,`CompanyName`,`TheaterName`,`Date`),
  KEY `fk14_idx` (`CompanyName`,`TheaterName`),
  CONSTRAINT `fk14` FOREIGN KEY (`CompanyName`, `TheaterName`) REFERENCES `theater` (`CompanyName`, `TheaterName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk3` FOREIGN KEY (`MovieName`, `ReleaseDate`) REFERENCES `movie` (`Name`, `ReleaseDate`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieplay`
--

LOCK TABLES `movieplay` WRITE;
/*!40000 ALTER TABLE `movieplay` DISABLE KEYS */;
INSERT INTO `movieplay` VALUES ('4400 The Movie','2019-08-12','4400 Theater Company','Cinema Star','2019-09-12'),('George P Burdell\'s Life Story','1927-08-12','4400 Theater Company','Cinema Star','2010-05-20'),('Georgia Tech The Movie','1985-08-13','4400 Theater Company','Cinema Star','2019-09-30'),('How to Train Your Dragon','2010-03-21','4400 Theater Company','Cinema Star','2010-04-02'),('Spaceballs','1987-06-24','4400 Theater Company','Cinema Star','2000-02-02'),('The King\'s Speech','2010-11-26','4400 Theater Company','Cinema Star','2019-12-20'),('Calculus Returns: A ML Story','2019-09-19','AI Theater Company','ML Movies','2019-10-10'),('Calculus Returns: A ML Story','2019-09-19','AI Theater Company','ML Movies','2019-12-30'),('Spaceballs','1987-06-24','AI Theater Company','ML Movies','2010-04-02'),('Spaceballs','1987-06-24','AI Theater Company','ML Movies','2023-01-23'),('Spider-Man: Into the Spider-Verse','2018-12-01','AI Theater Company','ML Movies','2019-09-30'),('4400 The Movie','2019-08-12','Awesome Theater Company','ABC Theater','2019-10-12'),('Georgia Tech The Movie','1985-08-13','Awesome Theater Company','ABC Theater','1985-08-13'),('The First Pokemon Movie','1998-07-19','Awesome Theater Company','ABC Theater','2018-07-19'),('George P Burdell\'s Life Story','1927-08-12','EZ Theater Company','Main Movies','2019-07-14'),('George P Burdell\'s Life Story','1927-08-12','EZ Theater Company','Main Movies','2019-10-22'),('How to Train Your Dragon','2010-03-21','EZ Theater Company','Main Movies','2010-03-22'),('How to Train Your Dragon','2010-03-21','EZ Theater Company','Main Movies','2010-03-23'),('Spaceballs','1987-06-24','EZ Theater Company','Main Movies','1999-06-24'),('The King\'s Speech','2010-11-26','EZ Theater Company','Main Movies','2019-12-20'),('4400 The Movie','2019-08-12','EZ Theater Company','Star Movies','2019-08-12'),('How to Train Your Dragon','2010-03-21','EZ Theater Company','Star Movies','2010-03-25');
/*!40000 ALTER TABLE `movieplay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `CompanyName` varchar(45) NOT NULL,
  `TheaterName` varchar(45) NOT NULL DEFAULT ' ',
  `Zipcode` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Manager` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CompanyName`,`TheaterName`),
  KEY `fk2_idx` (`Manager`),
  CONSTRAINT `fk1` FOREIGN KEY (`CompanyName`) REFERENCES `company` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`Manager`) REFERENCES `manager` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES ('4400 Theater Company','Cinema Star','94016','100 Cool Place','San Francisco','CA',4,'entropyRox'),('4400 Theater Company','Jonathan\'s Movies','98101','67 Pearl Dr','Seattle','WA',2,'georgep'),('4400 Theater Company','Star Movies','80301','4400 Rocks Ave','Boulder','CA',5,'radioactivePoRa'),('AI Theater Company','ML Movies','31415','314 Pi St','Pallet Town','KS',3,'ghcghc'),('Awesome Theater Company','ABC Theater','73301','880 Color Dr','Austin','TX',5,'imbatman'),('EZ Theater Company','Main Movies','10001','123 Main St','New York','NY',3,'fatherAI'),('EZ Theater Company','Star Movies','30332','745 GT St','Atlanta','GA',2,'calcultron');
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `used`
--

DROP TABLE IF EXISTS `used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `used` (
  `CreditCardNum` varchar(45) NOT NULL,
  `MovieName` varchar(45) NOT NULL,
  `ReleaseDate` date NOT NULL,
  `Date` date NOT NULL,
  `TheaterName` varchar(45) NOT NULL,
  `CompanyName` varchar(45) NOT NULL,
  PRIMARY KEY (`MovieName`,`ReleaseDate`,`CompanyName`,`TheaterName`,`Date`,`CreditCardNum`),
  KEY `validDate_idx` (`Date`),
  KEY `validMoviePlayCompanyName_idx` (`CompanyName`),
  KEY `fk12_idx` (`CreditCardNum`),
  CONSTRAINT `fk12` FOREIGN KEY (`CreditCardNum`) REFERENCES `creditcard` (`CreditCardNum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk13` FOREIGN KEY (`MovieName`, `ReleaseDate`, `CompanyName`, `TheaterName`, `Date`) REFERENCES `movieplay` (`MovieName`, `ReleaseDate`, `CompanyName`, `TheaterName`, `Date`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `used`
--

LOCK TABLES `used` WRITE;
/*!40000 ALTER TABLE `used` DISABLE KEYS */;
INSERT INTO `used` VALUES ('1111111111111111','How to Train Your Dragon','2010-03-21','2010-03-22','Main Movies','EZ Theater Company'),('1111111111111111','How to Train Your Dragon','2010-03-21','2010-03-23','Main Movies','EZ Theater Company'),('1111111111111100','How to Train Your Dragon','2010-03-21','2010-03-25','Star Movies','EZ Theater Company'),('1111111111111111','How to Train Your Dragon','2010-03-21','2010-04-02','Cinema Star','4400 Theater Company');
/*!40000 ALTER TABLE `used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Username` varchar(45) NOT NULL,
  `Status` enum('Pending','Declined','Approved') NOT NULL DEFAULT 'Pending',
  `Password` varchar(45) NOT NULL,
  `Firstname` varchar(45) NOT NULL,
  `Lastname` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang'),('calcultron','Approved','333333333','Dwight','Schrute'),('calcultron2','Approved','444444444','Jim','Halpert'),('calcwizard','Approved','222222222','Issac','Newton'),('clarinetbeast','Declined','999999999','Squidward','Tentacles'),('cool_class4400','Approved','333333333','A. TA','Washere'),('customer','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang'),('customer2','Pending','202cb962ac59075b964b07152d234b70','Wang','Kexin'),('DNAhelix','Approved','777777777','Rosalind','Franklin'),('does2Much','Approved','1212121212','Carl','Gauss'),('eeqmcsquare','Approved','111111110','Albert','Einstein'),('entropyRox','Approved','999999999','Claude','Shannon'),('fatherAI','Approved','222222222','Alan','Turing'),('fullMetal','Approved','111111100','Edward','Elric'),('gdanger','Declined','555555555','Gary','Danger'),('georgep','Approved','111111111','George P.','Burdell'),('ghcghc','Approved','666666666','Grace','Hopper'),('ilikemoney$$','Approved','111111110','Eugene','Krabs'),('imbatman','Approved','666666666','Bruce','Wayne'),('imready','Approved','777777777','Spongebob','Squarepants'),('isthisthekrustykrab','Approved','888888888','Patrick','Star'),('manager','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang'),('manager1','Approved','1122112211','Manager','One'),('manager2','Approved','3131313131','Manager','Two'),('manager3','Approved','8787878787','Three','Three'),('manager4','Approved','5755555555','Four','Four'),('notFullMetal','Approved','111111100','Alphonse','Elric'),('programerAAL','Approved','3131313131','Ada','Lovelace'),('radioactivePoRa','Approved','1313131313','Marie','Curie'),('RitzLover28','Approved','444444444','Abby','Normal'),('smith_j','Pending','333333333','John','Smith'),('texasStarKarate','Declined','111111110','Sandy','Cheeks'),('thePiGuy3.14','Approved','1111111111','Archimedes','Syracuse'),('theScienceGuy','Approved','999999999','Bill','Nye'),('user','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang'),('user1','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang'),('user2','Pending','202cb962ac59075b964b07152d234b70','Rongguo','Liang');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Visitor` varchar(45) NOT NULL,
  `TheaterName` varchar(45) NOT NULL,
  `CompanyName` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `validVisitor_idx` (`Visitor`),
  KEY `fk6_idx` (`CompanyName`,`TheaterName`),
  CONSTRAINT `fk5` FOREIGN KEY (`Visitor`) REFERENCES `user` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk6` FOREIGN KEY (`CompanyName`, `TheaterName`) REFERENCES `theater` (`CompanyName`, `TheaterName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
INSERT INTO `visit` VALUES (1,'2010-03-22','georgep','Main Movies','EZ Theater Company'),(2,'2010-03-22','calcwizard','Main Movies','EZ Theater Company'),(3,'2010-03-25','calcwizard','Star Movies','EZ Theater Company'),(4,'2010-03-25','imready','Star Movies','EZ Theater Company'),(5,'2010-03-20','calcwizard','ML Movies','AI Theater Company'),(6,'2020-01-09','admin','Cinema Star','4400 Theater Company'),(7,'2019-01-01','user','Star Movies','4400 Theater Company'),(8,'1990-01-01','customer','Star Movies','4400 Theater Company'),(9,'2020-01-10','manager','ABC Theater','Awesome Theater Company'),(10,'2019-01-01','customer','ABC Theater','Awesome Theater Company'),(11,'1990-01-01','manager','Star Movies','EZ Theater Company'),(12,'2019-01-01','admin','ML Movies','AI Theater Company');
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-11 13:48:29

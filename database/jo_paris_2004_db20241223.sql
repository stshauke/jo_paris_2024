-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: jo_paris_2024_db
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `billet`
--

DROP TABLE IF EXISTS `billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billet` (
  `id_billet` bigint NOT NULL AUTO_INCREMENT,
  `id_offre` int NOT NULL,
  `type_billet` varchar(50) NOT NULL,
  `prix_billet` decimal(10,2) NOT NULL,
  `stock` int DEFAULT '0',
  PRIMARY KEY (`id_billet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billet`
--

LOCK TABLES `billet` WRITE;
/*!40000 ALTER TABLE `billet` DISABLE KEYS */;
/*!40000 ALTER TABLE `billet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offre` (
  `id_offre` bigint NOT NULL AUTO_INCREMENT,
  `nom_offre` varchar(255) DEFAULT NULL,
  `description_offre` varchar(255) DEFAULT NULL,
  `prix_offre` decimal(38,2) DEFAULT NULL,
  `nombre_personnes` bigint DEFAULT NULL,
  `date_fin_offre` date DEFAULT NULL,
  PRIMARY KEY (`id_offre`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre`
--

LOCK TABLES `offre` WRITE;
/*!40000 ALTER TABLE `offre` DISABLE KEYS */;
INSERT INTO `offre` VALUES (1,'SINGLE Ticket','SINGLE : Pour les aventuriers en solo, les billets individuels sont le choix gagnant !',400.00,1,'2024-12-13'),(2,'DUO Ticket','DUO : Profitez ensemble, vivez des moments inoubliables !',500.00,2,'2024-12-13'),(3,'TRIPLE Ticket','TRIPLE : Trois fois plus de plaisir, trois fois plus de souvenirs !',600.00,3,'2024-12-13'),(4,'FAMILY  Ticket','FAMILY : Ensemble, créons des souvenirs inoubliables !',700.00,4,'2024-12-13');
/*!40000 ALTER TABLE `offre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panier`
--

DROP TABLE IF EXISTS `panier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `panier` (
  `id_panier` int NOT NULL AUTO_INCREMENT,
  `id_visiteur` int DEFAULT NULL,
  `id_billet` int DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  `date_ajout` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_panier`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panier`
--

LOCK TABLES `panier` WRITE;
/*!40000 ALTER TABLE `panier` DISABLE KEYS */;
/*!40000 ALTER TABLE `panier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stade`
--

DROP TABLE IF EXISTS `stade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stade` (
  `id_stade` bigint NOT NULL AUTO_INCREMENT,
  `adresse_stade` varchar(255) DEFAULT NULL,
  `nom_stade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_stade`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stade`
--

LOCK TABLES `stade` WRITE;
/*!40000 ALTER TABLE `stade` DISABLE KEYS */;
INSERT INTO `stade` VALUES (1,'Paris','Stade'),(2,'Saint-Denis','Stade de France'),(3,'Paris','Parc de Prince'),(4,'Kinshasa','Stade de Martyrs'),(9,'klkkklkl','kjkjkjj');
/*!40000 ALTER TABLE `stade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visiteur` (
  `id_visiteur` bigint NOT NULL AUTO_INCREMENT,
  `email_visiteur` varchar(255) DEFAULT NULL,
  `nom_visiteur` varchar(255) DEFAULT NULL,
  `password_visiteur` varchar(255) DEFAULT NULL,
  `prenom_visiteur` varchar(255) DEFAULT NULL,
  `solde_visiteur` decimal(38,2) DEFAULT NULL,
  `cle_visiteur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_visiteur`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visiteur`
--

LOCK TABLES `visiteur` WRITE;
/*!40000 ALTER TABLE `visiteur` DISABLE KEYS */;
INSERT INTO `visiteur` VALUES (12,'tshaukemulumba@yahoo.com','Network ABCabc123@','$2a$10$bODmksGJQHFrCr8j6X7uOOi3y.wYtjBdqivK53eekGVHWJKO0okjK','Scrapy',400.00,'87ece59e-315e-4151-b97d-c8e746e4b008'),(13,'tshaukemulumbua@yahoo.com','uytrre','$2a$10$lhcP2xuCyy8hDQugLTWKquhTXAFPnDWtMehA1ZHeYjmqB7K6j0cRi','Scrapy',400.00,'8ab1f945-9774-4e77-9ae7-6624d644274d');
/*!40000 ALTER TABLE `visiteur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-23 13:37:12

-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: gsi
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `atributos_jugadores`
--

DROP TABLE IF EXISTS `atributos_jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributos_jugadores` (
  `nombre` varchar(45) NOT NULL,
  `posicion` varchar(45) DEFAULT NULL,
  `disparo` int DEFAULT NULL,
  `pase` int DEFAULT NULL,
  `regate` int DEFAULT NULL,
  `defensa` int DEFAULT NULL,
  `goles_encajados` int DEFAULT NULL,
  `velocidad` int DEFAULT NULL,
  `valor` int DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `altura` int DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributos_jugadores`
--

LOCK TABLES `atributos_jugadores` WRITE;
/*!40000 ALTER TABLE `atributos_jugadores` DISABLE KEYS */;
INSERT INTO `atributos_jugadores` VALUES ('D.Upamecano','Defensa',NULL,NULL,NULL,NULL,0,79,55,22,185),('E.Haaland','Delantero',80,74,85,10,0,89,110,20,194),('K.Mbappe','Delantero',87,79,90,10,0,94,160,22,178),('L.Messi','Delantero',90,95,95,10,0,89,97,33,170),('L.Modric','Centrocampista',NULL,NULL,NULL,NULL,0,70,10,35,173),('Marquinhos','Defensa',NULL,NULL,NULL,NULL,0,70,68,26,183),('R.Varane','Defensa',NULL,NULL,NULL,NULL,0,80,63,27,191);
/*!40000 ALTER TABLE `atributos_jugadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-01 18:50:37

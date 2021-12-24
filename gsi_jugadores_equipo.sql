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
-- Table structure for table `jugadores_equipo`
--

DROP TABLE IF EXISTS `jugadores_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores_equipo` (
  `nombre` varchar(45) NOT NULL,
  `equipo` varchar(45) NOT NULL,
  `posicion` varchar(45) NOT NULL,
  `edad` int DEFAULT NULL,
  `forma_fisica` int DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `lesiones` int DEFAULT NULL,
  `ataque` int DEFAULT NULL,
  `defensa` int DEFAULT NULL,
  `pase` int DEFAULT NULL,
  `comentarios` varchar(45) DEFAULT NULL,
  `paradas_partido` int DEFAULT NULL,
  `goles_concedidos` int DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores_equipo`
--

LOCK TABLES `jugadores_equipo` WRITE;
/*!40000 ALTER TABLE `jugadores_equipo` DISABLE KEYS */;
INSERT INTO `jugadores_equipo` VALUES ('Blas','UD Alzira','Portero',23,21,'Muy descontento',1,3,1,2,'ss',1,1),('Dav','UD Alzira','Portero',0,0,'Muy descontento',0,0,0,0,'',0,0),('Jav','UD Alzira','Defensa',0,0,'Muy descontento',0,0,36,0,'',0,0),('Javi','UD Alzira','Portero',1,1,'Muy descontento',1,1,1,1,'',1,1),('Javier','UD Alzira','Portero',26,87,'Muy descontento',1,0,0,0,'',6,1),('V.Dolz','UD Alzira','Portero',25,90,'Muy contento',2,15,78,70,'Muy buen rendimiento',6,4);
/*!40000 ALTER TABLE `jugadores_equipo` ENABLE KEYS */;
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

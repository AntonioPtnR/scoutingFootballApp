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
-- Table structure for table `atributo_ataque`
--

DROP TABLE IF EXISTS `atributo_ataque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributo_ataque` (
  `nombre` varchar(40) NOT NULL,
  `goles` int DEFAULT NULL,
  `punteria` int DEFAULT NULL,
  `penaltis_lanzados` int DEFAULT NULL,
  `penaltis_marcados` int DEFAULT NULL,
  `efectividad_penaltis` int GENERATED ALWAYS AS (((`penaltis_marcados` / `penaltis_lanzados`) * 100)) VIRTUAL,
  `goles_last` int DEFAULT NULL,
  `ataque` int GENERATED ALWAYS AS (((`goles` + `punteria`) + 10)) VIRTUAL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo_ataque`
--

LOCK TABLES `atributo_ataque` WRITE;
/*!40000 ALTER TABLE `atributo_ataque` DISABLE KEYS */;
INSERT INTO `atributo_ataque` (`nombre`, `goles`, `punteria`, `penaltis_lanzados`, `penaltis_marcados`, `goles_last`) VALUES ('D.Upamecano',3,12,NULL,NULL,1),('E.Haaland',21,57,2,1,18),('K.Mbappe',21,61,5,5,19),('L.Messi',23,59,9,7,18),('L.Modric',3,40,NULL,NULL,2),('Marquinhos',1,30,NULL,NULL,1),('R.Varane',2,10,NULL,NULL,1);
/*!40000 ALTER TABLE `atributo_ataque` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-01 18:50:36

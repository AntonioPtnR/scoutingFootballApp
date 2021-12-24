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
-- Table structure for table `atributo_pase`
--

DROP TABLE IF EXISTS `atributo_pase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributo_pase` (
  `nombre` varchar(40) NOT NULL,
  `asistencias` int DEFAULT NULL,
  `toques` int DEFAULT NULL,
  `ocasiones_creadas` int DEFAULT NULL,
  `pases_clave` int DEFAULT NULL,
  `pases_completados` int DEFAULT NULL,
  `pases_completados_last` int DEFAULT NULL,
  `pases` int GENERATED ALWAYS AS (((((((`asistencias` * 2) + (`toques` / 100)) + `ocasiones_creadas`) + `pases_clave`) + (`pases_completados` - 60)) + (`pases_completados_last` - 50))) STORED,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo_pase`
--

LOCK TABLES `atributo_pase` WRITE;
/*!40000 ALTER TABLE `atributo_pase` DISABLE KEYS */;
INSERT INTO `atributo_pase` (`nombre`, `asistencias`, `toques`, `ocasiones_creadas`, `pases_clave`, `pases_completados`, `pases_completados_last`) VALUES ('D.Upamecano',0,73,1,0,70,61),('E.Haaland',5,27,4,1,72,74),('K.Mbappe',7,49,8,1,81,79),('L.Messi',8,92,17,2,86,75),('L.Modric',7,94,16,2,90,80),('Marquinhos',1,84,0,0,80,69),('R.Varane',0,74,1,0,71,62);
/*!40000 ALTER TABLE `atributo_pase` ENABLE KEYS */;
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

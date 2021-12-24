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
-- Table structure for table `atributo_defensa`
--

DROP TABLE IF EXISTS `atributo_defensa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributo_defensa` (
  `nombre` varchar(40) NOT NULL,
  `entradas_exito` int DEFAULT NULL,
  `despejes` int DEFAULT NULL,
  `tiros_bloqueados` int DEFAULT NULL,
  `intercepciones` int DEFAULT NULL,
  `defensa` int GENERATED ALWAYS AS (((((`entradas_exito` + `despejes`) + `tiros_bloqueados`) + `intercepciones`) / 1.5)) VIRTUAL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo_defensa`
--

LOCK TABLES `atributo_defensa` WRITE;
/*!40000 ALTER TABLE `atributo_defensa` DISABLE KEYS */;
INSERT INTO `atributo_defensa` (`nombre`, `entradas_exito`, `despejes`, `tiros_bloqueados`, `intercepciones`) VALUES ('D.Upamecano',14,70,12,26),('E.Haaland',4,9,2,4),('K.Mbappe',2,2,1,1),('L.Messi',9,0,0,5),('L.Modric',10,2,1,12),('Marquinhos',20,58,9,21),('R.Varane',15,75,15,30);
/*!40000 ALTER TABLE `atributo_defensa` ENABLE KEYS */;
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

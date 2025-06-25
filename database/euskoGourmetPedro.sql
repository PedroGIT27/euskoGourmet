-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: euskogourmetpedro
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `idrutas` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `url` varchar(200) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `completado` tinyint DEFAULT '0',
  PRIMARY KEY (`idrutas`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,'ruta1','ciudad1','url1','descripcion1',1),(2,'ruta2','ciudad2','url2','descripcion2',1),(3,'ruta3','ciudad3','url3','descripcion3',1),(4,'titulo4','ciudad4','url4','descripcion4',1),(5,'titulo4','ciudad4','url4','descripcion4',1),(6,'tiutl5','c5','url5','descripcion5',1),(7,'titulo','titulo','titulo','titulo',1),(8,'titulo6','getxo','url6','una ciudad bonita',1),(9,'titulo6','getxo','url6','una ciudad bonita',1),(10,'ejemplo','ejemplo','ejemplo','ejemplo',1),(11,'ejemplo','ejemplo','ejemplo','ejemplo',0),(12,'melbo','melbo','melbo','melbo',0),(13,'ejemplo','ejemplo','ejemplo','ejemplo',0),(14,'Name','Name','Name','Name',0),(15,'titulop','ciudadp','urlp','descripcionp',0),(16,'ejemplo','ejemplo','ejemplo','ejemplo',0),(17,'tituloej','ciudadej','urlej','descripcionej',0);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-25 14:48:23

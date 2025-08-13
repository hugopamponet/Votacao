-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: apivotacao
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `votacao`
--

DROP TABLE IF EXISTS `votacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `votacao` (
  `id` varchar(255) NOT NULL,
  `votacao` enum('Nao','Sim') DEFAULT NULL,
  `pauta_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9pch705ooj8xj4lo07f85eu5m` (`pauta_id`),
  CONSTRAINT `FK9pch705ooj8xj4lo07f85eu5m` FOREIGN KEY (`pauta_id`) REFERENCES `pauta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votacao`
--

LOCK TABLES `votacao` WRITE;
/*!40000 ALTER TABLE `votacao` DISABLE KEYS */;
INSERT INTO `votacao` VALUES ('0b9a5b88-a7ee-43bd-bb36-053177f31ca1','Sim','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('0ffed321-e27c-48be-bd5a-afa3f68e547c','Sim','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('1b35daed-47dd-4838-be11-dccfa60b2b69','Nao','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('36b5fda5-368b-4acb-9caf-b08252ac84ed','Sim','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('6b189560-f9a7-4ae2-9e42-33fbc1299770','Sim','9627e954-fb5e-49a7-8237-354a7fb1ac24'),('7fdc3392-3466-46a5-bbba-0f5f230a6bb6','Nao','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('9079f9a0-dc34-48df-af07-4c869aeda620','Nao','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('c63cdd19-6cb6-405f-a391-e4324ab7e05c','Nao','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('e68c9306-8604-4304-8919-3230a1cd75a2','Sim','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8'),('e756f949-0fc2-45f6-93ca-b66db184a53c','Sim','9627e954-fb5e-49a7-8237-354a7fb1ac24'),('fe8522fc-57ba-42fb-aca2-6a690b4a3e76','Nao','07a4a2ac-dbdf-4cfa-8af2-ef5b8108a3f8');
/*!40000 ALTER TABLE `votacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-12 23:08:01

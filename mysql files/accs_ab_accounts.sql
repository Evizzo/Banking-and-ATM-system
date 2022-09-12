-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: accs
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `ab_accounts`
--

DROP TABLE IF EXISTS `ab_accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_accounts` (
  `id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `pin` varchar(45) DEFAULT NULL,
  `number_of_account` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number_of_account`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_accounts`
--

LOCK TABLES `ab_accounts` WRITE;
/*!40000 ALTER TABLE `ab_accounts` DISABLE KEYS */;
INSERT INTO `ab_accounts` VALUES ('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','Nalog','dbc4d84bfcfe2284ba11beffb853a8c4',74),('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','Nalog','dbc4d84bfcfe2284ba11beffb853a8c4',75),('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','Nalog','dbc4d84bfcfe2284ba11beffb853a8c4',79),('e8f75437-2639-4048-b248-223e857102f4','Nalog2','deb54ffb41e085fd7f69a75b6359c989',80),('3851b600-4879-4d74-ab39-11bc7fd7e075','Nalog2','934b535800b1cba8f96a5d72f72f1611',81),('d523b111-3128-4af4-9e4a-8261a21fec05','EvoMe','3c8a49145944fed2bbcaade178a426c4',82),('f911703d-b5ae-43e3-9131-bb64d32de212','AAAAAA','9fe77ac7060e716f2d42631d156825c0',83),('9143d5a4-e960-439c-9976-5903d280cc93','sfdfsd','7a430339c10c642c4b2251756fd1b484',84),('c6972bf1-59da-49ab-9c6d-0fe42ffe7610','das','d5438e589313fc0036bbc291299c6fd4',85),('1a7f1d10-d059-4839-943c-85b18f0cfd88','z','781877bda0783aac5f1cf765c128b437',86),('44707cbf-0318-42b2-a4cb-a9e5be58ebc6','sx','5af12af744c7a634787ec678b7dbdaf0',87),('62a8ccf4-b309-476f-a7c4-fede8e5506c0','g','23ad3e314e2a2b43b4c720507cec0723',88),('e76a239d-90ec-47ff-b7d4-25ceddd2e164','Mica','36e425d506a15b14cec0d71abfb2ac44',89),('3851b600-4879-4d74-ab39-11bc7fd7e075','Nalog2','934b535800b1cba8f96a5d72f72f1611',90);
/*!40000 ALTER TABLE `ab_accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-12 16:01:58

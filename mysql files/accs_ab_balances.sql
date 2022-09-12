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
-- Table structure for table `ab_balances`
--

DROP TABLE IF EXISTS `ab_balances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ab_balances` (
  `id` varchar(45) DEFAULT NULL,
  `account_id` varchar(45) DEFAULT NULL,
  `account_type` varchar(45) DEFAULT NULL,
  `ammout` int DEFAULT NULL,
  `number_of_account` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`number_of_account`),
  CONSTRAINT `user_balances` FOREIGN KEY (`number_of_account`) REFERENCES `ab_accounts` (`number_of_account`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ab_balances`
--

LOCK TABLES `ab_balances` WRITE;
/*!40000 ALTER TABLE `ab_balances` DISABLE KEYS */;
INSERT INTO `ab_balances` VALUES ('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','PrviCC','CREDIT_CARD',52,74),('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','DrugiCC','CREDIT_CARD',20,75),('fc19ea54-9e87-4c33-8dc3-0ebd376c6971','TreciAccSA','SAVINGS_ACCOUNT',0,79),('e8f75437-2639-4048-b248-223e857102f4','PrviCC2','CREDIT_CARD',0,80),('3851b600-4879-4d74-ab39-11bc7fd7e075','NeZnamFr','CREDIT_CARD',218,81),('d523b111-3128-4af4-9e4a-8261a21fec05','Da','CREDIT_CARD',0,82),('f911703d-b5ae-43e3-9131-bb64d32de212','AAAAAAAAA','CREDIT_CARD',0,83),('9143d5a4-e960-439c-9976-5903d280cc93','dasdas','SAVINGS_ACCOUNT',0,84),('c6972bf1-59da-49ab-9c6d-0fe42ffe7610','das','SAVINGS_ACCOUNT',0,85),('1a7f1d10-d059-4839-943c-85b18f0cfd88','zzz','SAVINGS_ACCOUNT',0,86),('44707cbf-0318-42b2-a4cb-a9e5be58ebc6','ss','CREDIT_CARD',0,87),('62a8ccf4-b309-476f-a7c4-fede8e5506c0','g','CREDIT_CARD',0,88),('e76a239d-90ec-47ff-b7d4-25ceddd2e164','MiskovaDebitnaKartica','DEBIT_CARD',0,89),('3851b600-4879-4d74-ab39-11bc7fd7e075','JaZnamCC','CREDIT_CARD',0,90);
/*!40000 ALTER TABLE `ab_balances` ENABLE KEYS */;
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

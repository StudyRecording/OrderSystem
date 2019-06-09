-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: order_system
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dining`
--

DROP TABLE IF EXISTS `dining`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dining` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(15) NOT NULL COMMENT '订单单号',
  `personnel_id` int(5) NOT NULL COMMENT '订餐人id',
  `dinner_number` varchar(5) NOT NULL COMMENT '就餐人数',
  `order_date` varchar(10) DEFAULT NULL COMMENT '订单日期',
  `dinner_date` varchar(10) DEFAULT NULL COMMENT '就餐日期',
  `dinner_time` int(2) DEFAULT NULL COMMENT '就餐段',
  `dinner_way` int(2) DEFAULT NULL COMMENT '就餐方式',
  `dinner_instructions` varchar(200) DEFAULT NULL COMMENT '订餐说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_number` (`order_number`),
  KEY `personnel_id` (`personnel_id`),
  CONSTRAINT `dining_ibfk_1` FOREIGN KEY (`personnel_id`) REFERENCES `personnel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='就餐表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dining`
--

LOCK TABLES `dining` WRITE;
/*!40000 ALTER TABLE `dining` DISABLE KEYS */;
INSERT INTO `dining` VALUES (1,'20190508-1',2,'32','2019-05-08','2019-05-31',1,0,'少辣'),(4,'20190509-1',17,'43','2019-05-09','2019-05-14',2,0,'多辣'),(5,'20190509-2',18,'54','2019-05-09','2019-05-21',1,0,'不要辣'),(6,'20190509-3',19,'98','2019-05-09','2019-05-20',2,0,'主食是馒头'),(7,'20190509-4',20,'87','2019-05-09','2019-05-10',2,0,'要吃米饭'),(8,'20190510-1',20,'3','2019-05-10','2019-06-01',2,1,'喝酒');
/*!40000 ALTER TABLE `dining` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 17:10:33

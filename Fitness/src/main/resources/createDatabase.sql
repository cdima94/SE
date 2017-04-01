-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: fitness
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fitness`
--

DROP TABLE IF EXISTS `fitness`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fitness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `min_age` int(11) NOT NULL,
  `max_age` int(11) NOT NULL,
  `min_weight` int(11) NOT NULL,
  `max_weight` int(11) NOT NULL,
  `min_height` int(11) NOT NULL,
  `max_height` int(11) NOT NULL,
  `style` enum('ACTIVE','PASSIVE') NOT NULL,
  `biceps` int(11) NOT NULL,
  `triceps` int(11) NOT NULL,
  `forearm` int(11) NOT NULL,
  `shoulder` int(11) NOT NULL,
  `chest` int(11) NOT NULL,
  `back` int(11) NOT NULL,
  `abdomen` int(11) NOT NULL,
  `feet` int(11) NOT NULL,
  `legs` int(11) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `dificulty` enum('EASY','NORMAL','HARD') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fitness`
--

LOCK TABLES `fitness` WRITE;
/*!40000 ALTER TABLE `fitness` DISABLE KEYS */;
INSERT INTO `fitness` VALUES (1,14,15,40,45,146,150,'PASSIVE',10,10,10,10,8,8,8,8,8,'FEMALE','NORMAL'),(2,16,17,46,51,151,155,'PASSIVE',12,12,12,12,10,10,10,10,10,'MALE','HARD'),(3,18,19,52,55,156,160,'PASSIVE',15,15,15,15,12,12,12,12,12,'FEMALE','EASY'),(4,18,19,51,55,160,164,'PASSIVE',15,15,14,15,12,11,12,11,12,'MALE','NORMAL'),(5,18,19,56,60,165,170,'PASSIVE',16,15,18,15,12,15,14,15,12,'FEMALE','HARD'),(6,18,19,61,65,170,175,'PASSIVE',16,16,18,15,12,15,14,15,13,'MALE','EASY'),(7,18,19,66,70,175,180,'PASSIVE',16,15,18,15,14,15,14,15,12,'FEMALE','NORMAL'),(8,18,19,71,75,175,180,'PASSIVE',16,15,18,15,14,15,14,15,13,'MALE','HARD'),(9,18,19,76,80,175,180,'PASSIVE',16,15,18,15,14,15,14,15,15,'FEMALE','EASY'),(11,23,26,51,55,160,164,'PASSIVE',15,15,14,15,11,11,12,10,11,'FEMALE','HARD'),(12,23,26,56,60,165,170,'PASSIVE',14,15,12,15,12,11,12,10,11,'MALE','EASY'),(13,23,26,61,65,170,175,'PASSIVE',14,15,15,15,12,11,12,12,15,'FEMALE','NORMAL'),(14,23,26,66,70,170,175,'PASSIVE',14,13,15,16,11,11,12,12,15,'MALE','HARD'),(15,23,26,71,75,176,180,'PASSIVE',14,13,15,16,11,11,12,12,15,'FEMALE','EASY'),(16,23,26,76,80,180,185,'PASSIVE',14,13,15,16,15,14,12,14,15,'MALE','NORMAL'),(17,23,26,80,85,180,185,'PASSIVE',14,12,15,16,15,14,15,14,15,'FEMALE','HARD'),(18,23,26,86,93,180,185,'PASSIVE',14,15,15,20,21,22,22,15,15,'MALE','EASY'),(19,23,26,94,100,186,190,'PASSIVE',15,15,20,21,22,22,14,15,14,'FEMALE','NORMAL'),(20,23,26,94,100,191,195,'PASSIVE',20,21,22,22,14,15,14,13,14,'MALE','HARD'),(21,23,26,101,105,191,195,'PASSIVE',10,11,15,12,14,15,14,13,11,'FEMALE','EASY'),(22,23,26,106,110,196,200,'PASSIVE',10,11,22,12,14,15,14,13,14,'MALE','NORMAL'),(23,27,32,50,55,150,155,'PASSIVE',14,21,22,22,14,15,14,13,14,'FEMALE','HARD'),(24,27,32,56,60,156,160,'PASSIVE',10,21,12,22,14,15,15,11,14,'MALE','EASY'),(25,27,32,60,65,161,165,'PASSIVE',10,21,12,22,18,15,15,15,14,'FEMALE','NORMAL'),(26,27,32,66,70,166,170,'PASSIVE',10,21,12,22,18,12,15,15,12,'MALE','HARD'),(27,27,32,71,76,171,176,'PASSIVE',15,14,12,18,18,15,15,15,14,'FEMALE','EASY'),(28,27,32,77,80,177,185,'PASSIVE',18,21,12,18,18,15,18,15,14,'MALE','NORMAL'),(29,27,32,81,86,185,190,'PASSIVE',20,21,22,18,18,15,11,18,14,'FEMALE','HARD'),(30,27,32,87,91,191,200,'PASSIVE',18,19,12,18,18,22,18,19,11,'MALE','EASY'),(31,14,15,40,45,146,150,'ACTIVE',15,15,15,15,12,14,12,14,15,'FEMALE','NORMAL'),(32,16,17,46,51,151,155,'ACTIVE',20,20,20,20,20,20,20,20,20,'MALE','HARD'),(33,18,19,52,55,156,160,'ACTIVE',20,21,22,22,20,22,21,20,22,'FEMALE','EASY'),(34,18,19,51,55,160,164,'ACTIVE',20,21,21,22,21,22,21,22,25,'MALE','NORMAL'),(35,18,19,56,60,165,170,'ACTIVE',22,21,22,22,25,22,21,25,20,'FEMALE','HARD'),(36,18,19,61,65,170,175,'ACTIVE',22,21,25,22,25,25,21,25,25,'MALE','EASY'),(37,18,19,66,70,175,180,'ACTIVE',25,21,25,22,25,22,21,25,25,'FEMALE','NORMAL'),(38,18,19,71,75,175,180,'ACTIVE',26,25,22,25,22,26,21,25,26,'MALE','HARD'),(39,18,19,76,80,175,180,'ACTIVE',26,22,22,25,23,25,26,25,26,'FEMALE','EASY'),(41,23,26,51,55,160,164,'ACTIVE',25,26,24,25,22,25,28,26,25,'FEMALE','HARD'),(42,23,26,56,60,165,170,'ACTIVE',25,26,24,26,22,25,29,26,25,'MALE','EASY'),(43,23,26,61,65,170,175,'ACTIVE',25,25,30,25,22,25,30,25,28,'FEMALE','NORMAL'),(44,23,26,66,70,170,175,'ACTIVE',25,21,22,25,27,25,21,25,27,'MALE','HARD'),(45,23,26,71,75,176,180,'ACTIVE',30,27,30,30,27,30,30,25,25,'FEMALE','EASY'),(46,23,26,76,80,180,185,'ACTIVE',25,30,30,25,22,25,21,25,25,'MALE','NORMAL'),(47,23,26,80,85,180,185,'ACTIVE',30,30,30,30,22,25,21,30,30,'FEMALE','HARD'),(48,23,26,86,93,180,185,'ACTIVE',30,30,30,25,22,25,21,25,30,'MALE','EASY'),(49,23,26,94,100,186,190,'ACTIVE',25,21,30,25,30,25,21,25,25,'FEMALE','NORMAL'),(50,23,26,94,100,191,195,'ACTIVE',30,21,30,29,30,25,30,25,30,'MALE','HARD'),(51,23,26,101,105,191,195,'ACTIVE',10,11,15,12,14,15,14,13,11,'FEMALE','EASY'),(52,23,26,106,110,196,200,'ACTIVE',10,11,22,12,14,15,14,13,14,'MALE','NORMAL'),(53,27,32,50,55,150,155,'ACTIVE',14,21,22,22,14,15,14,13,14,'FEMALE','HARD'),(54,27,32,56,60,156,160,'ACTIVE',10,21,12,22,14,15,15,11,14,'MALE','EASY'),(55,27,32,60,65,161,165,'ACTIVE',10,21,12,22,18,15,15,15,14,'FEMALE','NORMAL'),(56,27,32,66,70,166,170,'ACTIVE',10,21,12,22,18,12,15,15,12,'MALE','HARD'),(57,27,32,71,76,171,176,'ACTIVE',15,14,12,18,18,15,15,15,14,'FEMALE','EASY'),(58,27,32,77,80,177,185,'ACTIVE',18,21,12,18,18,15,18,15,14,'MALE','NORMAL'),(59,27,32,81,86,185,190,'ACTIVE',20,21,22,18,18,15,11,18,14,'FEMALE','HARD'),(60,27,32,87,91,191,200,'ACTIVE',18,19,12,18,18,22,18,19,11,'MALE','EASY');
/*!40000 ALTER TABLE `fitness` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-31 12:10:16

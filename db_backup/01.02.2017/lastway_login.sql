-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 192.168.56.101    Database: lastway
-- ------------------------------------------------------
-- Server version	5.5.51-log

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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL COMMENT 'Name which views in system',
  `login` varchar(45) DEFAULT NULL COMMENT 'Login name which uses for autentification',
  `password` varchar(64) DEFAULT NULL COMMENT 'User Password',
  `active` varchar(1) DEFAULT 'Y',
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `login_id_UNIQUE` (`login_id`),
  KEY `user_id_fk_idx` (`login_id`,`user_id`),
  KEY `user_id_fk_idx1` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Spirited','admin','qwerty','Y','2016-12-08 19:10:13','2016-12-10 19:44:35',NULL),(2,'P@PiC','oduvanchik','gUdv!n','Y','2016-12-08 19:10:13',NULL,NULL),(3,'Orlando','pukan','qqqwerty','Y','2016-12-08 19:10:13',NULL,NULL),(5,'romeo','romeo_login','julet2016','Y','2016-12-10 13:52:22',NULL,NULL),(6,'Litr','litr_login','g@mlet','Y','2016-12-10 13:54:30',NULL,NULL),(7,'fredy','markyry','fef7185dd6e69d561bc286f3fe6e391f','Y','2016-12-10 19:59:05',NULL,NULL),(8,'fredy','markyry','fef7185dd6e69d561bc286f3fe6e391f','Y','2017-01-05 21:57:45',NULL,NULL),(9,'trest','test','remove','Y','2017-03-05 10:11:24',NULL,NULL),(10,'remove','this','line','Y','2017-03-05 10:06:29',NULL,NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-01 10:56:05

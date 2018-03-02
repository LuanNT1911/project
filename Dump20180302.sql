-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ifar
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `link` varchar(250) NOT NULL,
  `status` int(11) NOT NULL COMMENT '-1: deactived (is used for product, remove at local)\n0: unused\n1: used',
  `created_at` datetime NOT NULL,
  `seller_request_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Model_seller_request1_idx` (`seller_request_id`),
  CONSTRAINT `fk_Model_seller_request1` FOREIGN KEY (`seller_request_id`) REFERENCES `seller_request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,2,2,2,'https://s3-ap-southeast-1.amazonaws.com/luannt1911/1-30.jpg',2,'2018-02-24 00:00:00',2),(2,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-01 04:13:02',1),(36,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-01 11:08:35',1),(37,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-01 11:10:42',1),(38,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-01 11:11:50',1),(39,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/1 (1).obj',-1,'2018-03-01 11:31:10',1),(40,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/1 (1).obj',-1,'2018-03-01 11:35:55',1),(41,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/result.obj',-1,'2018-03-01 13:13:30',1),(42,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/result.obj',-1,'2018-03-01 13:39:17',1),(43,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:17:53',1),(44,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:22:47',1),(45,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:24:19',1),(46,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:31:02',1),(47,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_3_IFAR/3Dmodel/',-1,'2018-03-02 17:33:49',3),(48,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:39:06',1),(49,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:45:30',1),(50,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:47:04',1),(51,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:50:09',1),(52,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_3_IFAR/3Dmodel/',-1,'2018-03-02 17:51:17',3),(53,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/',-1,'2018-03-02 17:55:04',1),(54,1,1,1,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/3Dmodel/result.obj',-1,'2018-03-02 18:38:01',1);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `created_at` datetime NOT NULL,
  `user_account_username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Order_user_account1_idx` (`user_account_username`),
  CONSTRAINT `fk_Order_user_account1` FOREIGN KEY (`user_account_username`) REFERENCES `user_account` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`),
  KEY `fk_order_detail_order1_idx` (`order_id`),
  KEY `fk_order_detail_product1_idx` (`product_id`),
  CONSTRAINT `fk_order_detail_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `origin` varchar(50) NOT NULL,
  `weight` double NOT NULL DEFAULT '0',
  `describe` varchar(2000) DEFAULT NULL,
  `image` varchar(250) NOT NULL,
  `status` int(11) NOT NULL COMMENT '-1 rejected\n0 pending\n1 approved\n',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `model_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `reject_reason` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `image_UNIQUE` (`image`),
  KEY `fk_Product_Model1_idx` (`model_id`),
  KEY `fk_product_product1_idx` (`product_id`),
  CONSTRAINT `fk_Product_Model1` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'ghe',100,100,'VN',10,'khong co gi','khong co',1,'2018-02-24 00:00:00','2018-02-24 00:00:00',1,NULL,'asdad'),(2,'test',1,1,'test',1,'test','test',1,'2018-02-24 00:00:00','2018-02-24 00:00:00',1,NULL,NULL),(3,'test',1,1,'test',1,'test','1',1,'2018-02-24 00:00:00','2018-02-24 00:00:00',1,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'staff'),(3,'customer'),(4,'seller');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_request`
--

DROP TABLE IF EXISTS `seller_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL COMMENT '-1: rejected\n0: pending\n1: approved\n',
  `image_set` mediumblob COMMENT 'Byte stream of list images\n',
  `public_link` varchar(250) NOT NULL,
  `width` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_account_username` varchar(50) NOT NULL,
  `reject_reason` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_seller_request_user_account1_idx` (`user_account_username`),
  CONSTRAINT `fk_seller_request_user_account1` FOREIGN KEY (`user_account_username`) REFERENCES `user_account` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_request`
--

LOCK TABLES `seller_request` WRITE;
/*!40000 ALTER TABLE `seller_request` DISABLE KEYS */;
INSERT INTO `seller_request` VALUES (1,1,NULL,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_IFAR/image/',1,1,1,'2018-02-24 00:00:00','2018-03-02 18:22:16','seller',NULL),(2,0,NULL,'https://s3.amazonaws.com/3dimagetest/seller/seller_2_ifAR/image/',11,1,1,'2018-02-24 00:00:00','2018-02-28 14:56:06','seller','123'),(3,1,NULL,'https://s3.amazonaws.com/3dimagetest/seller/seller_1_ifAR/image/',1,1,1,'2018-02-24 00:00:00','2018-03-01 22:32:11','seller','');
/*!40000 ALTER TABLE `seller_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_store`
--

DROP TABLE IF EXISTS `seller_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller_store` (
  `id_card` varchar(12) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(250) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `balance` double NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_account_username` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `reject_reason` varchar(250) NOT NULL,
  `seller_store_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `id_card_UNIQUE` (`id_card`),
  KEY `fk_seller_store_seller_store1_idx` (`seller_store_name`),
  KEY `fk_seller_store_user_account1` (`user_account_username`),
  CONSTRAINT `fk_seller_store_seller_store1` FOREIGN KEY (`seller_store_name`) REFERENCES `seller_store` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_seller_store_user_account1` FOREIGN KEY (`user_account_username`) REFERENCES `user_account` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_store`
--

LOCK TABLES `seller_store` WRITE;
/*!40000 ALTER TABLE `seller_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL,
  `amount` double NOT NULL,
  `created_at` datetime NOT NULL,
  `user_account_username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Transaction_user_account1_idx` (`user_account_username`),
  CONSTRAINT `fk_Transaction_user_account1` FOREIGN KEY (`user_account_username`) REFERENCES `user_account` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_user_account_Role_idx` (`role_id`),
  CONSTRAINT `fk_user_account_Role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES ('customer','123',4),('seller','123',4);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `fullname` varchar(50) CHARACTER SET utf8 NOT NULL,
  `birth` datetime NOT NULL,
  `address` varchar(250) NOT NULL,
  `city` varchar(30) NOT NULL,
  `email` varchar(90) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `sexual` int(11) NOT NULL COMMENT '0: Female\n1: Male\n2: Other\n',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_account_username` varchar(50) NOT NULL,
  PRIMARY KEY (`user_account_username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  CONSTRAINT `fk_user_profile_user_account1` FOREIGN KEY (`user_account_username`) REFERENCES `user_account` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES ('khoa','1996-09-26 00:00:00','HCm','HCM','khoaseller@ifar.com','09096969696',1,'2018-02-23 00:00:00','2018-02-23 00:00:00','seller');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-02 21:31:29

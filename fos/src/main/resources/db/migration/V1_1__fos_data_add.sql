CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'drink'),(2,'pizza'),(3,'burger'),(4,'pasta'),(5,'other');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('fn2','ln2',2),('fn3','ln3',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food_item`
--

LOCK TABLES `food_item` WRITE;
/*!40000 ALTER TABLE `food_item` DISABLE KEYS */;
INSERT INTO `food_item` VALUES (3,'cola','cola','https://media.officedepot.com/image/upload/b_rgb:FFFFFF,c_pad,dpr_1.0,f_auto,h_1665,q_auto,w_1250/c_pad,h_1665,w_1250/v1/products/208206/208206_p?pgw=1&pgwact=1',1,1,1),(4,'pizza','dd','https://post.healthline.com/wp-content/uploads/2020/07/pizza-beer-1200x628-facebook-1200x628.jpg',2,1,1),(5,'burger','burger','https://cdn.donesi.ba/cdn-cgi/image/w=800,h=450,fit=cover,q=100,f=auto/restaurants/100000341/banner_item/0000000017938',1.5,1,1),(6,'pasta','pasta','https://pinchofyum.com/wp-content/uploads/Vegan-Vodka-Pasta-Square.jpg',1.8,4,4);
/*!40000 ALTER TABLE `food_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,2,'2021-02-01 00:45:38',2,3,1),(2,2,'2021-02-01 00:45:39',2,2,1),(3,2,'2021-02-01 00:45:40',2,2,1),(4,2,'2021-02-01 00:45:41',2,4,1),(5,2,'2021-02-01 00:45:42',2,1,1),(6,12,'2021-02-01 00:45:43',2,1,1),(7,2,'2021-02-01 00:45:45',2,1,1),(8,6,'2021-02-01 00:45:46',3,1,1),(9,2,'2021-02-01 00:45:47',2,1,1),(10,1,'2021-02-01 00:45:48',2,1,1),(11,1.8,'2021-02-01 00:45:49',2,1,4);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,2,1,4,1),(2,2,1,4,2),(3,2,1,4,3),(4,2,1,4,4),(5,2,1,4,5),(6,12,6,4,6),(7,2,1,4,7),(8,6,3,4,8),(9,2,1,4,9),(10,1,1,3,10),(11,1.8,1,6,11);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES (1,'NEW'),(2,'FINISHED'),(3,'CANCELED'),(4,'ACCEPTED');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES ('restaurant1',1),('restaurant2',4);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_RESTAURANT'),(2,'ROLE_CUSTOMER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'add1','add1@test','$2a$10$EO1h2O/WRovdDTngNyCh7uW5nzwBHvAAlI3YOTQDEAaqhZ8NNfjSq','065968624','testing1',1),(2,'add2','add2@test','$2a$10$m5.rcG5Nfm4sLohfbKt.OOTlaGCxuD/kLp1BQ6wnsvzKWXh6Svsta','065968624','testing2',2),(3,'add3','add3@test','$2a$10$VVKPxq64qujfPBWPtn.X0uIutNRzJnSPjoAy.mXWYw2C.tA9ufksq','065968624','testing3',2),(4,'add4','add4@test','$2a$10$a4TGd2QhvGe0Dvdsz/ThEON/CaSzq.mAWNVmz5BYcygqUHdPvB2g.','065968624','testing4',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-01  8:41:41

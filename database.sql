DROP database IF EXISTS `db_web_store`;

CREATE DATABASE  IF NOT EXISTS `db_web_store` ;
USE `db_web_store`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_web_store
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles` (
  `Articles_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Price` double NOT NULL,
  PRIMARY KEY (`Articles_ID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (1,'Wilson A360','- Youth 12-inch model - Velcro design for easy in-game adjustments - Black / gray leather in a timeless look - CarbonLite Shell helps reduce weight without sacrificing durability',36.8),(2,'Tanners V70L Pickelball Equipment Remo','The Vulcan V700 Series Pickleball Paddles are engineered to elevate performance. Made with new Stateracore and Vulcan V-Skin Technology, these paddles are lighter, stronger, and utilize a tighter and more efficient structure. Paddles available in a variety of designs and play performance preferences.',149.99),(3,'Louisville Slugger Omaha 518','The new Louisville Slugger omaha 518 (-10) 2 5/8 inch USA baseball bat is designed to help players dominate at the highest levels, the way the omaha series has dominated the scene, year after year, game after game.',145),(4,'Wilson Sporting Goods Tennis Bag','Designed in the spirit of the Clash Revolution, the Clash Large Duffel holds 3-4 rackets and includes a plethora of attractive features for tennis enthusiasts. Store tennis shoes in a side zip shoe pocket, place keys and other personal effects inside interior accessory pockets, and get everything organized with an interior divider system that keeps rackets, clothing and other items separated during transit.',99),(5,'Wilson A9117 Soft Compression Softball','Wilson Baseballs and Softballs are the preferred choice of more than 40 collegiate conferences. Sold in Dozens.',87.5),(6,'Spalding NBA Marble Series Outdoor Basketball','Made for players who create their own lane, The Spalding NBA Marble Series Outdoor Basketball shakes free from convention with a unique marble print. Aside from the durable outdoor cover and embossed logos, no two balls in the series are the same.',22.5),(7,'quan Basketball net Luminous Outdoor Portable Sun-Powered Sports Nylon','Luminescent outdoor basketball net brings basketball night light, by absorbing the sun is shining in the dark energy, to ensure the best performance of the light, it needs a whole day´s sunshine, just like sun lamp each mesh has 12 holes (standard basketball net) and 20 inches (standard size of the NBA and NCAA basketball). Our luminous basketball nets made out of cotton and nylon, which means that the firm structure, not like other net tear or tear ',10.99),(8,'BARNETT Vision I bk XL, Competition Football Shoulder pad, QB-WR',' Designed for the skill positions: QB-WR-DB. High quality shoulder pad. Protection and ease of motion. Clamping through 2 elastic strips. Very resistant ABS shell, dual density PU foam. Cushions with heavy duty nylon. Very comfortable and secure.',59),(9,'WAKA Official Kickball - Adult 10',' Country Of Origin : Thailand. The Package Height Of The Product Is 9.9 Inches. The Package Length Of The Product Is 10.3 Inches. The Package Width Of The Product Is 10.3 Inches',87.5),(10,'WIFFLE Ball U.S.A Set - 32\" Bat with Red, White, and Blue Official Balls - 4 Pack','Wiffle America distributed by GoIdeo now offers the Exclusive U.S.A Wiffle Set that includes: 1 32\" Yellow Wiffle Ball Bat 1 Red Wiffle Baseball 1 Blue Wiffle Baseball 1 White Wiffle Baseball All of which are made in America (in Connecticut) and are the highest possible standard of quality. Create forever lasting memories with the classic game of Wiffle Ball!',19.99);
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articles_purchase`
--

DROP TABLE IF EXISTS `articles_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles_purchase` (
  `Articles_Purchase_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Article_ID` int(11) NOT NULL,
  `Purchase_Order_ID` int(11) NOT NULL,
  PRIMARY KEY (`Articles_Purchase_ID`),
  KEY `fk_Art_Purch_Articles` (`Article_ID`),
  KEY `fk_Art_Purch_Purchase` (`Purchase_Order_ID`),
  CONSTRAINT `fk_Art_Purch_Articles` FOREIGN KEY (`Article_ID`) REFERENCES `articles` (`Articles_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Art_Purch_Purchase` FOREIGN KEY (`Purchase_Order_ID`) REFERENCES `purchase_orders` (`Purchase_Order_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles_purchase`
--

LOCK TABLES `articles_purchase` WRITE;
/*!40000 ALTER TABLE `articles_purchase` DISABLE KEYS */;
INSERT INTO `articles_purchase` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `articles_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billing` (
  `Billing_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Amount` double NOT NULL,
  `Date` date NOT NULL,
  `Purchase_Order_ID` int(11) NOT NULL,
  PRIMARY KEY (`Billing_ID`),
  KEY `fk_Billing_Purchase_Order` (`Purchase_Order_ID`),
  CONSTRAINT `fk_Billing_Purchase_Order` FOREIGN KEY (`Purchase_Order_ID`) REFERENCES `purchase_orders` (`Purchase_Order_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES (1,648.5,'2021-04-18',1),(2,159,'2021-04-18',2),(3,157,'2021-04-18',3),(4,364,'2021-04-18',4),(5,120,'2021-04-18',5),(6,210,'2021-04-18',6),(7,145,'2021-04-18',7),(8,21.5,'2021-04-18',8),(9,312.5,'2021-04-18',9),(10,410,'2021-04-18',10);
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `City_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  `State_ID` int(11) NOT NULL,
  PRIMARY KEY (`City_ID`),
  KEY `fk_city_state` (`State_ID`),
  CONSTRAINT `fk_city_state` FOREIGN KEY (`State_ID`) REFERENCES `state` (`State_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Dublin',1),(2,'Hilliard',1),(3,'Calera',2),(4,'Clay',2),(5,'Manlius',3),(6,'Rye',3),(7,'Phoenix',4),(8,'Flagstaff',4),(9,'Salem',5),(10,'Cale',5),(11,'Fresno',6),(12,'Los Angeles',6),(13,'RedStone',7),(14,'Crisman',7),(15,'Portland',8),(16,'Cos Cob',8),(17,'Scotlan',9),(18,'Bon Air',9),(19,'Allen',10),(20,'Coppell',10);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_credit_card`
--

DROP TABLE IF EXISTS `client_credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_credit_card` (
  `Client_Credit_Card_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Client_ID` int(11) NOT NULL,
  `Credit_Card_ID` int(11) NOT NULL,
  PRIMARY KEY (`Client_Credit_Card_ID`),
  KEY `fk_C_C_C_Clients` (`Client_ID`),
  KEY `fk_C_C_C_Credit_Card` (`Credit_Card_ID`),
  CONSTRAINT `fk_C_C_C_Clients` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`Client_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_C_C_C_Credit_Card` FOREIGN KEY (`Credit_Card_ID`) REFERENCES `credit_cards` (`Credit_Card_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_credit_card`
--

LOCK TABLES `client_credit_card` WRITE;
/*!40000 ALTER TABLE `client_credit_card` DISABLE KEYS */;
INSERT INTO `client_credit_card` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `client_credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_del_add`
--

DROP TABLE IF EXISTS `client_del_add`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_del_add` (
  `Client_Del_Add_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Client_ID` int(11) NOT NULL,
  `Del_Add_ID` int(11) NOT NULL,
  PRIMARY KEY (`Client_Del_Add_ID`),
  KEY `fk_C_D_A_Clients` (`Client_ID`),
  KEY `fk_C_D_A_Del_Add` (`Del_Add_ID`),
  CONSTRAINT `fk_C_D_A_Clients` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`Client_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_C_D_A_Del_Add` FOREIGN KEY (`Del_Add_ID`) REFERENCES `delivery_address` (`Del_Add_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_del_add`
--

LOCK TABLES `client_del_add` WRITE;
/*!40000 ALTER TABLE `client_del_add` DISABLE KEYS */;
INSERT INTO `client_del_add` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);
/*!40000 ALTER TABLE `client_del_add` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `Client_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  `Last_Name` varchar(25) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `Email` varchar(25) NOT NULL,
  PRIMARY KEY (`Client_ID`),
  UNIQUE KEY `Username` (`Username`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Mark','Lee','MarkitoLee','Mark123456','mark@gmail.com'),(2,'Jhon','Marquez','JhonM','Jhon123456','jhon@gmail.com'),(3,'Tania','Lopez','TaniaL','Tania123456','tania@gmail.com'),(4,'Marcela','Avila','MarceA','marcela123456','marcela@gmail.com'),(5,'Derek','Mendez','DerekM','derek123123','derek@gmail.com'),(6,'Brian','Smith','BrianS','brian123456','brian@gmail.com'),(7,'Erik','Johnson','ErikJ','erik123456','erik@gmail.com'),(8,'Dylan','Jones','DylanJ','dylan123456','dylan@gmail.com'),(9,'David','Jones','DavidJ','david123456','david@gmail.com'),(10,'Rose','Young','RoseY','rose123456','rose@gmail.com');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `Country_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  PRIMARY KEY (`Country_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'USA');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_cards`
--

DROP TABLE IF EXISTS `credit_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_cards` (
  `Credit_Card_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NOT NULL,
  `Cardholder` varchar(50) NOT NULL,
  `Type_CC_ID` int(11) NOT NULL,
  PRIMARY KEY (`Credit_Card_ID`),
  UNIQUE KEY `Number` (`Number`),
  KEY `fk_Credit_Cards_Type_CC` (`Type_CC_ID`),
  CONSTRAINT `fk_Credit_Cards_Type_CC` FOREIGN KEY (`Type_CC_ID`) REFERENCES `type_cc` (`Type_CC_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_cards`
--

LOCK TABLES `credit_cards` WRITE;
/*!40000 ALTER TABLE `credit_cards` DISABLE KEYS */;
INSERT INTO `credit_cards` VALUES (1,46456454,'Mark Lee',1),(2,11156454,'Dharius Marce',1),(3,64448421,'Maradona Espinoza',1),(4,6454684,'Terrie Mondai',2),(5,34864945,'Mario Capistrano',2),(6,71564846,'Jose Badia',2),(7,94231648,'Mike Smit',2),(8,10454452,'Gelen De Mora',3),(9,64541214,'Louren Lovato',3),(10,3186446,'Dihana Jane',3);
/*!40000 ALTER TABLE `credit_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_address`
--

DROP TABLE IF EXISTS `delivery_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_address` (
  `Del_Add_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Street` varchar(25) NOT NULL,
  `Number` int(11) NOT NULL,
  `City_ID` int(11) NOT NULL,
   `State_ID` int(11) NOT NULL,
   `Country_ID` int(11) NOT NULL,
  PRIMARY KEY (`Del_Add_ID`),
  KEY `fk_Delivery_Address_City` (`City_ID`),
  CONSTRAINT `fk_Delivery_Address_City` FOREIGN KEY (`City_ID`) REFERENCES `city` (`City_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Delivery_Address_State` FOREIGN KEY (`State_ID`) REFERENCES `state` (`State_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Delivery_Address_Country` FOREIGN KEY (`Country_ID`) REFERENCES `country` (`Country_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_address`
--

LOCK TABLES `delivery_address` WRITE;
/*!40000 ALTER TABLE `delivery_address` DISABLE KEYS */;
INSERT INTO `delivery_address` VALUES (1,'Laverty Ct',486,1, 1, 1),(2,'Claymill Dr',795,2, 1, 1),(3,'4th Ave',241,3, 1, 1),(4,'Old Springville Rd',512,4, 2, 2),(5,'Fayette St',124,5, 2, 2),(6,'Milton Rd',720,6, 2, 2),(7,'W Tierra Buena Ln',612,7, 2, 2),(8,'E Huntington Dr',341,8, 3, 3),(9,'N Walnut St',211,9, 2, 2),(10,'Westmoreland Dr',811,10, 3, 3),(11,'E Shields Ave',111,11, 3, 3),(12,'Longbow Dr',392,12, 3, 3),(13,'Firehouse Rd',333,13, 3, 3),(14,'Four Mile Canyon Dr',975,14, 1, 1);
/*!40000 ALTER TABLE `delivery_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_company`
--

DROP TABLE IF EXISTS `delivery_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_company` (
  `Delivery_Company_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  PRIMARY KEY (`Delivery_Company_ID`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_company`
--

LOCK TABLES `delivery_company` WRITE;
/*!40000 ALTER TABLE `delivery_company` DISABLE KEYS */;
INSERT INTO `delivery_company` VALUES (1,'DHL'),(5,'DPD'),(2,'FedEx'),(10,'Hermes'),(6,'net despatch'),(7,'night freight'),(8,'PALLETFORCE'),(3,'Royal Mail'),(4,'TNT'),(9,'UKMail');
/*!40000 ALTER TABLE `delivery_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_packeges`
--

DROP TABLE IF EXISTS `delivery_packeges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_packeges` (
  `Delivery_Packeges_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Delivery_Date` date NOT NULL,
  `Packege_Number` int(11) NOT NULL,
  `Delivery_Company_ID` int(11) NOT NULL,
  PRIMARY KEY (`Delivery_Packeges_ID`),
  UNIQUE KEY `Packege_Number` (`Packege_Number`),
  KEY `fk_Del_Pack_Del_Company` (`Delivery_Company_ID`),
  CONSTRAINT `fk_Del_Pack_Del_Company` FOREIGN KEY (`Delivery_Company_ID`) REFERENCES `delivery_company` (`Delivery_Company_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_packeges`
--

LOCK TABLES `delivery_packeges` WRITE;
/*!40000 ALTER TABLE `delivery_packeges` DISABLE KEYS */;
INSERT INTO `delivery_packeges` VALUES (1,'2021-04-18',489464,1),(2,'2021-04-18',459725,2),(3,'2021-04-18',489782,3),(4,'2021-04-18',156456,4),(5,'2021-04-18',597754,5),(6,'2021-04-18',167875,6),(7,'2021-04-18',974564,7),(8,'2021-04-18',15648,8),(9,'2021-04-18',784123,9),(10,'2021-04-18',116446,10);
/*!40000 ALTER TABLE `delivery_packeges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_orders`
--

DROP TABLE IF EXISTS `purchase_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_orders` (
  `Purchase_Order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Client_ID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Delivery_Packeges_ID` int(11) NOT NULL,
  PRIMARY KEY (`Purchase_Order_ID`),
  KEY `fk_Purchase_Orders_Del_P` (`Delivery_Packeges_ID`),
  KEY `fk_Purchase_Orders_Clients` (`Client_ID`),
  CONSTRAINT `fk_Purchase_Orders_Clients` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`Client_ID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Orders_Del_P` FOREIGN KEY (`Delivery_Packeges_ID`) REFERENCES `delivery_packeges` (`Delivery_Packeges_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_orders`
--

LOCK TABLES `purchase_orders` WRITE;
/*!40000 ALTER TABLE `purchase_orders` DISABLE KEYS */;
INSERT INTO `purchase_orders` VALUES (1,1,'2021-04-18',1),(2,2,'2021-04-18',2),(3,3,'2021-04-18',3),(4,4,'2021-04-18',4),(5,5,'2021-04-18',5),(6,6,'2021-04-18',6),(7,7,'2021-04-18',7),(8,8,'2021-04-18',8),(9,9,'2021-04-18',9),(10,10,'2021-04-18',10);
/*!40000 ALTER TABLE `purchase_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `State_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  `Country_ID` int(11) NOT NULL,
  PRIMARY KEY (`State_ID`),
  KEY `fk_state_country` (`Country_ID`),
  CONSTRAINT `fk_state_country` FOREIGN KEY (`Country_ID`) REFERENCES `country` (`Country_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Ohio',1),(2,'Alabama',1),(3,'New York',1),(4,'Arizona',1),(5,'Arkansas',1),(6,'California',1),(7,'Colorado',1),(8,'Connecticut',1),(9,'Virginia',1),(10,'Texas',1);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_cc`
--

DROP TABLE IF EXISTS `type_cc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_cc` (
  `Type_CC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(20) NOT NULL,
  PRIMARY KEY (`Type_CC_ID`),
  UNIQUE KEY `Type` (`Type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_cc`
--

LOCK TABLES `type_cc` WRITE;
/*!40000 ALTER TABLE `type_cc` DISABLE KEYS */;
INSERT INTO `type_cc` VALUES (3,'AMEX'),(2,'MASTER CARD'),(1,'VISA');
/*!40000 ALTER TABLE `type_cc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 13:41:20

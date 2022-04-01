-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ngo_management_system
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cause`
--

DROP TABLE IF EXISTS `cause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cause` (
  `cause_id` int NOT NULL AUTO_INCREMENT,
  `cause_name` varchar(45) NOT NULL,
  `cause_supported` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cause_funds_raised` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`cause_id`),
  UNIQUE KEY `cause_id_UNIQUE` (`cause_id`),
  UNIQUE KEY `cause_name_UNIQUE` (`cause_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cause`
--

LOCK TABLES `cause` WRITE;
/*!40000 ALTER TABLE `cause` DISABLE KEYS */;
INSERT INTO `cause` VALUES (1,'visually impaired children','y',100000.00),(2,'vocal and hearing impaired','y',50000.00),(3,'physically handicapped','y',30000.00),(4,'orphans','y',75000.00),(5,'old age people','y',200000.00);
/*!40000 ALTER TABLE `cause` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cause_organization`
--

DROP TABLE IF EXISTS `cause_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cause_organization` (
  `cause_id` int NOT NULL,
  `organization_id` int NOT NULL,
  PRIMARY KEY (`cause_id`,`organization_id`),
  KEY `organization_id_idx` (`organization_id`),
  CONSTRAINT `cause_id_cause_organization` FOREIGN KEY (`cause_id`) REFERENCES `cause` (`cause_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `organization_id_cause_organization` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cause_organization`
--

LOCK TABLES `cause_organization` WRITE;
/*!40000 ALTER TABLE `cause_organization` DISABLE KEYS */;
INSERT INTO `cause_organization` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `cause_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `cause_volunteer`
--

DROP TABLE IF EXISTS `cause_volunteer`;
/*!50001 DROP VIEW IF EXISTS `cause_volunteer`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `cause_volunteer` AS SELECT 
 1 AS `volunteer_id`,
 1 AS `first_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `donate_time`
--

DROP TABLE IF EXISTS `donate_time`;
/*!50001 DROP VIEW IF EXISTS `donate_time`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `donate_time` AS SELECT 
 1 AS `first_name`,
 1 AS `last_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donation` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `donor_id` int DEFAULT NULL,
  `resource_id` int NOT NULL,
  `organization_id` int DEFAULT NULL,
  `time` datetime NOT NULL,
  `amount` decimal(12,2) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`),
  UNIQUE KEY `resource_id_UNIQUE` (`resource_id`),
  KEY `donor_id_idx` (`donor_id`),
  KEY `organization_id_idx` (`organization_id`),
  CONSTRAINT `donor_id_donation` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`donor_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `organization_donation` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `resource_id_donation` FOREIGN KEY (`resource_id`) REFERENCES `resource_store` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation`
--

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
INSERT INTO `donation` VALUES (1,5,1,NULL,'2022-01-13 05:00:00',1500.00),(2,4,2,3,'2022-05-15 05:00:00',10.00),(3,3,3,NULL,'2022-02-03 05:00:00',15.00),(4,2,4,1,'2020-12-16 06:00:00',1000.00),(5,1,5,5,'2022-01-01 07:00:00',10.00);
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donation_donation_type`
--

DROP TABLE IF EXISTS `donation_donation_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donation_donation_type` (
  `transaction_id` int NOT NULL,
  `donation_type` varchar(20) NOT NULL,
  PRIMARY KEY (`transaction_id`,`donation_type`),
  KEY `transaction_id_idx` (`transaction_id`),
  CONSTRAINT `transaction_id_donation_donation_type` FOREIGN KEY (`transaction_id`) REFERENCES `donation` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donation_donation_type`
--

LOCK TABLES `donation_donation_type` WRITE;
/*!40000 ALTER TABLE `donation_donation_type` DISABLE KEYS */;
INSERT INTO `donation_donation_type` VALUES (1,'money'),(2,'clothing'),(3,'clothing'),(4,'money'),(5,'tech_gadgets');
/*!40000 ALTER TABLE `donation_donation_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donor` (
  `donor_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `address` varchar(75) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `num_of_donations` int DEFAULT NULL,
  `last_donation` date DEFAULT NULL,
  PRIMARY KEY (`donor_id`),
  UNIQUE KEY `volunteer_id_UNIQUE` (`donor_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,'Stanton','Floy','1988-01-31','6195 Carey Curve West Willborough, IL 14351','stanton.floy@gmail.com','2088293218',50,'2020-05-20'),(2,'Marvin','Jovani','1995-05-06','3718 Purdy Courts Apt. 987 Port Karelleborough, IN 44346-2536','marvin.jovani@gmail.com','4432263670',46,'2021-12-15'),(3,'Emmerich','Laurine','1980-12-07','74317 Tanya Flat Fletcherside, WI 67916-1699','emm.laurine@gmail.com','2549749482',150,'2022-10-02'),(4,'Weber','Leanne','1992-12-10','844 Anastacio Trail Oberbrunnerside, WV 42260-0117','weber.leanne@gmail.com','2023415815',95,'2022-02-03'),(5,'Purdy','Ari','1977-03-17','68038 Bo Union Apt. 897 Isaiton, IN 99322','purdy.ari@gmail.com','304241741',78,'2020-01-02');
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `emp_org`
--

DROP TABLE IF EXISTS `emp_org`;
/*!50001 DROP VIEW IF EXISTS `emp_org`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `emp_org` AS SELECT 
 1 AS `employee_id`,
 1 AS `first_name`,
 1 AS `organization_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `ssn` varchar(10) NOT NULL,
  `organization_id` int NOT NULL,
  `salary` int NOT NULL,
  `birth_date` date NOT NULL,
  `address` varchar(75) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` char(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  UNIQUE KEY `ssn_UNIQUE` (`ssn`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `organization_id_idx` (`organization_id`),
  CONSTRAINT `organization_id_employee` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Hackett','Jayme','2644215841',4,50000,'1973-04-27','16916 Skyla Keys Suite 732 Greenfeldermouth, FL 63280','hackett.jayme@gmail.com','2145813674'),(2,'Padberg','Hilton','5742958631',5,20000,'1978-01-25','348 Titus Centers Connerton, AK 64000-6389','padberg.hilton@gmail.com	','3017975249'),(3,'Feil','Elijah','4238208831',1,40000,'1975-08-14','57759 Fadel Squares Augustton, AL 38014-7835','feil.elijah@gmail.com	','3192368374'),(4,'Strosin','Autumn','5253168841',2,35000,'1982-05-05','28187 Rick Neck Crooksberg, NM 59051','strosin.autumn@gmail.com','6623061396'),(5,'Kulas','Yazmin','4192690911',3,55000,'1980-02-15','937 Hartmann Knolls New Rosalee, CT 11502','kulas.yazmin@gmail.com','4077193097');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
INSERT INTO `entity1` VALUES ('carlson','password3','carlson@gmail.com'),('glover','password2','glover@gmail.com'),('lindsey','password1','lindsey@gmail.com'),('peters','password4','peters@gmail.com'),('thornton','password5','thornton@gmail.com');
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `organization_id` int NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(50) NOT NULL,
  `address` varchar(75) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` char(10) NOT NULL,
  PRIMARY KEY (`organization_id`),
  UNIQUE KEY `organization_id_UNIQUE` (`organization_id`),
  UNIQUE KEY `organization_name_UNIQUE` (`organization_name`),
  UNIQUE KEY `address_UNIQUE` (`address`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'Isha foundation for visually impaired','7201 183rd St, Tinley Park, Indiana, 60477','vichildren@isha.com','7085323373'),(2,'Isha foundation for hearing and vocal impaired','300 Northtown Dr NE, Blaine, Minnesota, 55434','hvichildren@isha.com','7637808668'),(3,'Isha foundation for physically challenged','205 N Fairview St, Santa Ana, California, 92703','pcpeople@isha.com','7145429829'),(4,'Isha foundation for orphans','119 N Broadway, Rochester, Minnesota, 55906','ochildren@isha.com','5072584105'),(5,'Isha foundation for elderly','1845 New York Ave, Huntington Station, North Dakota, 11746','epeople@isha.com','6315491544');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_store`
--

DROP TABLE IF EXISTS `resource_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_store` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `type_name` varchar(20) NOT NULL,
  `resource_count` decimal(12,2) NOT NULL,
  PRIMARY KEY (`resource_id`),
  UNIQUE KEY `resource_id_UNIQUE` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_store`
--

LOCK TABLES `resource_store` WRITE;
/*!40000 ALTER TABLE `resource_store` DISABLE KEYS */;
INSERT INTO `resource_store` VALUES (1,'money_donation','money',1500.00),(2,'sweaters','clothing',10.00),(3,'shirts and jeans','clothing',15.00),(4,'money_donation','money',1000.00),(5,'laptops','tech_gadgets',10.00);
/*!40000 ALTER TABLE `resource_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_usage`
--

DROP TABLE IF EXISTS `resource_usage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_usage` (
  `usage_id` int NOT NULL,
  `resource_id` int NOT NULL,
  `organization_id` int NOT NULL,
  `usage_count` decimal(12,2) NOT NULL,
  PRIMARY KEY (`usage_id`),
  UNIQUE KEY `usage_id_UNIQUE` (`usage_id`),
  KEY `resource_id_idx` (`resource_id`),
  KEY `organization_id_idx` (`organization_id`),
  CONSTRAINT `organization_id_resource_usage` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resource_id_resource_usage` FOREIGN KEY (`resource_id`) REFERENCES `resource_store` (`resource_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_usage`
--

LOCK TABLES `resource_usage` WRITE;
/*!40000 ALTER TABLE `resource_usage` DISABLE KEYS */;
INSERT INTO `resource_usage` VALUES (1,1,2,500.00),(2,2,3,5.00),(3,3,4,10.00),(4,4,1,600.00),(5,5,5,5.00);
/*!40000 ALTER TABLE `resource_usage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('carlson','password3','carlson@gmail.com'),('glover','password2','glover@gmail.com'),('lindsey','password1','lindsey@gmail.com'),('peters','password4','peters@gmail.com'),('thornton','password5','thornton@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `volunteer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `address` varchar(75) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  PRIMARY KEY (`volunteer_id`),
  UNIQUE KEY `volunteer_id_UNIQUE` (`volunteer_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,'Dickens','Bruce','1978-11-10','152 Zelma Meadows Suite 983 New Idellfurt, KS 95384','dickens.bruce@gmail.com','2124942383'),(2,'Heathcote','Velma','1984-09-12',NULL,NULL,NULL),(3,'Stroman','Boyd',NULL,'2879 Keshawn Mills Apt. 617 Dietrichtown, ME 11898',NULL,NULL),(4,'Kerluke','Reyes','1975-11-28','61591 Cummings Radial Apt. 524 Funkmouth, UT 15727-0980','kerluke.reyes@gmail.com','4106655994'),(5,'Crooks','Alize','1996-01-17','660 Velda Ramp Apt. 114 Hilpertfort, IL 43711-5684','crooks.alize@gmail.com','3016966307');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer_support_cause`
--

DROP TABLE IF EXISTS `volunteer_support_cause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_support_cause` (
  `volunteer_id` int NOT NULL,
  `support_cause_id` int NOT NULL,
  PRIMARY KEY (`volunteer_id`,`support_cause_id`),
  KEY `support_cause_id_idx` (`support_cause_id`),
  CONSTRAINT `support_cause_id_cause` FOREIGN KEY (`support_cause_id`) REFERENCES `cause` (`cause_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `volunteer_id_volunteer` FOREIGN KEY (`volunteer_id`) REFERENCES `volunteer` (`volunteer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_support_cause`
--

LOCK TABLES `volunteer_support_cause` WRITE;
/*!40000 ALTER TABLE `volunteer_support_cause` DISABLE KEYS */;
INSERT INTO `volunteer_support_cause` VALUES (4,2),(5,2),(3,3),(2,4),(1,5);
/*!40000 ALTER TABLE `volunteer_support_cause` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `cause_volunteer`
--

/*!50001 DROP VIEW IF EXISTS `cause_volunteer`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cause_volunteer` AS select `v`.`volunteer_id` AS `volunteer_id`,`v`.`first_name` AS `first_name` from (`volunteer` `v` join `volunteer_support_cause` `vs` on((`vs`.`volunteer_id` = `v`.`volunteer_id`))) group by `vs`.`support_cause_id` order by `v`.`first_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `donate_time`
--

/*!50001 DROP VIEW IF EXISTS `donate_time`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `donate_time` AS select `d`.`first_name` AS `first_name`,`d`.`last_name` AS `last_name` from `donor` `d` where exists(select `n`.`donor_id` from `donation` `n` where ((`d`.`donor_id` = `n`.`donor_id`) and (`n`.`time` < '2022-02-03 05:00:00'))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_org`
--

/*!50001 DROP VIEW IF EXISTS `emp_org`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_org` AS select `e`.`employee_id` AS `employee_id`,`e`.`first_name` AS `first_name`,`o`.`organization_name` AS `organization_name` from (`employee` `e` join `organization` `o` on((`o`.`organization_id` = `e`.`organization_id`))) group by `e`.`organization_id` order by `e`.`first_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-01 11:47:08

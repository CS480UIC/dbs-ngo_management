-- -----------------------------------------------------
-- Schema ngo_management_system
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ngo_management_system` ;

-- -----------------------------------------------------
-- Schema ngo_management_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ngo_management_system` ;
USE `ngo_management_system` ;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`cause`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`cause` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`cause` (
  `cause_id` INT NOT NULL AUTO_INCREMENT,
  `cause_name` VARCHAR(45) NOT NULL,
  `cause_supported` CHAR(1) BINARY NULL,
  `cause_funds_raised` DECIMAL(12,2) NULL,
  PRIMARY KEY (`cause_id`),
  UNIQUE INDEX `cause_id_UNIQUE` (`cause_id` ASC) VISIBLE,
  UNIQUE INDEX `cause_name_UNIQUE` (`cause_name` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `cause` WRITE;
/*!40000 ALTER TABLE `cause` DISABLE KEYS */;
INSERT INTO `cause` VALUES (1,'visually impaired children','y',100000.00),(2,'vocal and hearing impaired','y',50000.00),(3,'physically handicapped','y',30000.00),(4,'orphans','y',75000.00),(5,'old age people','y',200000.00);
/*!40000 ALTER TABLE `cause` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`organization` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`organization` (
  `organization_id` INT NOT NULL AUTO_INCREMENT,
  `organization_name` VARCHAR(50) NOT NULL,
  `address` VARCHAR(75) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` CHAR(10) NOT NULL,
  PRIMARY KEY (`organization_id`),
  UNIQUE INDEX `organization_id_UNIQUE` (`organization_id` ASC) VISIBLE,
  UNIQUE INDEX `organization_name_UNIQUE` (`organization_name` ASC) VISIBLE,
  UNIQUE INDEX `address_UNIQUE` (`address` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'Isha foundation for visually impaired','7201 183rd St, Tinley Park, Indiana, 60477','vichildren@isha.com','7085323373'),(2,'Isha foundation for hearing and vocal impaired','300 Northtown Dr NE, Blaine, Minnesota, 55434','hvichildren@isha.com','7637808668'),(3,'Isha foundation for physically challenged','205 N Fairview St, Santa Ana, California, 92703','pcpeople@isha.com','7145429829'),(4,'Isha foundation for orphans','119 N Broadway, Rochester, Minnesota, 55906','ochildren@isha.com','5072584105'),(5,'Isha foundation for elderly','1845 New York Ave, Huntington Station, North Dakota, 11746','epeople@isha.com','6315491544');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`employee` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `ssn` VARCHAR(10) NOT NULL,
  `organization_id` INT NOT NULL,
  `salary` INT NOT NULL,
  `birth_date` DATE NOT NULL,
  `address` VARCHAR(75) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` CHAR(10) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC) VISIBLE,
  UNIQUE INDEX `ssn_UNIQUE` (`ssn` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  INDEX `organization_id_idx` (`organization_id` ASC) VISIBLE,
  CONSTRAINT `organization_id_employee`
    FOREIGN KEY (`organization_id`) REFERENCES `ngo_management_system`.`organization` (`organization_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Hackett','Jayme','2644215841',4,50000,'1973-04-27','16916 Skyla Keys Suite 732 Greenfeldermouth, FL 63280','hackett.jayme@gmail.com','2145813674'),(2,'Padberg','Hilton','5742958631',5,20000,'1978-01-25','348 Titus Centers O\'Connerton, AK 64000-6389','padberg.hilton@gmail.com	','3017975249'),(3,'Feil','Elijah','4238208831',1,40000,'1975-08-14','57759 Fadel Squares Augustton, AL 38014-7835','feil.elijah@gmail.com	','3192368374'),(4,'Strosin','Autumn','5253168841',2,35000,'1982-05-05','28187 Rick Neck Crooksberg, NM 59051','strosin.autumn@gmail.com','6623061396'),(5,'Kulas','Yazmin','4192690911',3,55000,'1980-02-15','937 Hartmann Knolls New Rosalee, CT 11502','kulas.yazmin@gmail.com','4077193097');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`donor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`donor` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`donor` (
  `donor_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `birth_date` DATE NULL,
  `address` VARCHAR(75) NULL,
  `email` VARCHAR(45) NULL,
  `phone` CHAR(10) NULL,
  `num_of_donations` INT NULL,
  `last_donation` DATE NULL,
  PRIMARY KEY (`donor_id`),
  UNIQUE INDEX `volunteer_id_UNIQUE` (`donor_id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,'Stanton','Floy','1988-01-31','6195 Carey Curve West Willborough, IL 14351','stanton.floy@gmail.com','2088293218',50,'2020-05-20'),(2,'Marvin','Jovani','1995-05-06','3718 Purdy Courts Apt. 987 Port Karelleborough, IN 44346-2536','marvin.jovani@gmail.com','4432263670',46,'2021-12-15'),(3,'Emmerich','Laurine','1980-12-07','74317 Tanya Flat Fletcherside, WI 67916-1699','emm.laurine@gmail.com','2549749482',150,'2022-10-02'),(4,'Weber','Leanne','1992-12-10','844 Anastacio Trail Oberbrunnerside, WV 42260-0117','weber.leanne@gmail.com','2023415815',95,'2022-02-03'),(5,'Purdy','Ari','1977-03-17','68038 Bo Union Apt. 897 Isaiton, IN 99322','purdy.ari@gmail.com','304241741',78,'2020-01-02');
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`cause_organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`cause_organization` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`cause_organization` (
  `cause_id` INT NOT NULL,
  `organization_id` INT NOT NULL,
  PRIMARY KEY (`cause_id`, `organization_id`),
  INDEX `organization_id_idx` (`organization_id` ASC) VISIBLE,
  CONSTRAINT `cause_id_cause_organization`
    FOREIGN KEY (`cause_id`) REFERENCES `ngo_management_system`.`cause` (`cause_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `organization_id_cause_organization`
    FOREIGN KEY (`organization_id`) REFERENCES `ngo_management_system`.`organization` (`organization_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `cause_organization` WRITE;
/*!40000 ALTER TABLE `cause_organization` DISABLE KEYS */;
INSERT INTO `cause_organization` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `cause_organization` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`entity1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`entity1` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`entity1` (
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
INSERT INTO `entity1` VALUES ('carlson','password3','carlson@gmail.com'),('glover','password2','glover@gmail.com'),('lindsey','password1','lindsey@gmail.com'),('peters','password4','peters@gmail.com'),('thornton','password5','thornton@gmail.com');
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`resource_store`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`resource_store` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`resource_store` (
  `resource_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `type_name` VARCHAR(20) NOT NULL,
  `resource_count` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`resource_id`),
  UNIQUE INDEX `resource_id_UNIQUE` (`resource_id` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `resource_store` WRITE;
/*!40000 ALTER TABLE `resource_store` DISABLE KEYS */;
INSERT INTO `resource_store` VALUES (1,'money_donation','money',1500.00),(2,'sweaters','clothing',10.00),(3,'shirts and jeans','clothing',15.00),(4,'money_donation','money',1000.00),(5,'laptops','tech_gadgets',10.00);
/*!40000 ALTER TABLE `resource_store` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`donation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`donation` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`donation` (
  `transaction_id` INT NOT NULL AUTO_INCREMENT,
  `donor_id` INT NULL,
  `resource_id` INT NOT NULL,
  `organization_id` INT NULL,
  `time` DATETIME NOT NULL,
  `amount` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE INDEX `transaction_id_UNIQUE` (`transaction_id` ASC) VISIBLE,
  UNIQUE INDEX `resource_id_UNIQUE` (`resource_id` ASC) VISIBLE,
  INDEX `donor_id_idx` (`donor_id` ASC) VISIBLE,
  INDEX `organization_id_idx` (`organization_id` ASC) VISIBLE,
  CONSTRAINT `donor_id_donation`
    FOREIGN KEY (`donor_id`) REFERENCES `ngo_management_system`.`donor` (`donor_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `resource_id_donation`
    FOREIGN KEY (`resource_id`) REFERENCES `ngo_management_system`.`resource_store` (`resource_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `organization_donation`
    FOREIGN KEY (`organization_id`) REFERENCES `ngo_management_system`.`organization` (`organization_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `donation` WRITE;
/*!40000 ALTER TABLE `donation` DISABLE KEYS */;
INSERT INTO `donation` VALUES (1,5,1,NULL,'2022-01-13 05:00:00',1500.00),(2,4,2,3,'2022-05-15 05:00:00',10.00),(3,3,3,NULL,'2022-02-03 05:00:00',15.00),(4,2,4,1,'2020-12-16 06:00:00',1000.00),(5,1,5,5,'2022-01-01 07:00:00',10.00);
/*!40000 ALTER TABLE `donation` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`donation_donation_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`donation_donation_type` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`donation_donation_type` (
  `transaction_id` INT NOT NULL,
  `donation_type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`transaction_id`, `donation_type`),
  INDEX `transaction_id_idx` (`transaction_id` ASC) VISIBLE,
  CONSTRAINT `transaction_id_donation_donation_type`
    FOREIGN KEY (`transaction_id`) REFERENCES `ngo_management_system`.`donation` (`transaction_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `donation_donation_type` WRITE;
/*!40000 ALTER TABLE `donation_donation_type` DISABLE KEYS */;
INSERT INTO `donation_donation_type` VALUES (1,'money'),(2,'clothing'),(3,'clothing'),(4,'money'),(5,'tech_gadgets');
/*!40000 ALTER TABLE `donation_donation_type` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`resource_usage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`resource_usage` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`resource_usage` (
  `usage_id` INT NOT NULL,
  `resource_id` INT NOT NULL,
  `organization_id` INT NOT NULL,
  `usage_count` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`usage_id`),
  UNIQUE INDEX `usage_id_UNIQUE` (`usage_id` ASC) VISIBLE,
  INDEX `resource_id_idx` (`resource_id` ASC) VISIBLE,
  INDEX `organization_id_idx` (`organization_id` ASC) VISIBLE,
  CONSTRAINT `resource_id_resource_usage`
    FOREIGN KEY (`resource_id`) REFERENCES `ngo_management_system`.`resource_store` (`resource_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `organization_id_resource_usage`
    FOREIGN KEY (`organization_id`) REFERENCES `ngo_management_system`.`organization` (`organization_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `resource_usage` WRITE;
/*!40000 ALTER TABLE `resource_usage` DISABLE KEYS */;
INSERT INTO `resource_usage` VALUES (1,1,2,500.00),(2,2,3,5.00),(3,3,4,10.00),(4,4,1,600.00),(5,5,5,5.00);
/*!40000 ALTER TABLE `resource_usage` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`user` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`user` (
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('carlson','password3','carlson@gmail.com'),('glover','password2','glover@gmail.com'),('lindsey','password1','lindsey@gmail.com'),('peters','password4','peters@gmail.com'),('thornton','password5','thornton@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`volunteer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`volunteer` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`volunteer` (
  `volunteer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `birth_date` DATE NULL,
  `address` VARCHAR(75) NULL,
  `email` VARCHAR(45) NULL,
  `phone` CHAR(10) NULL,
  PRIMARY KEY (`volunteer_id`),
  UNIQUE INDEX `volunteer_id_UNIQUE` (`volunteer_id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB;

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES (1,'Dickens','Bruce','1978-11-10','152 Zelma Meadows Suite 983 New Idellfurt, KS 95384','dickens.bruce@gmail.com','2124942383'),(2,'Heathcote','Velma','1984-09-12',NULL,NULL,NULL),(3,'Stroman','Boyd',NULL,'2879 Keshawn Mills Apt. 617 Dietrichtown, ME 11898',NULL,NULL),(4,'Kerluke','Reyes','1975-11-28','61591 Cummings Radial Apt. 524 Funkmouth, UT 15727-0980','kerluke.reyes@gmail.com','4106655994'),(5,'Crooks','Alize','1996-01-17','660 Velda Ramp Apt. 114 Hilpertfort, IL 43711-5684','crooks.alize@gmail.com','3016966307');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `ngo_management_system`.`volunteer_support_cause`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ngo_management_system`.`volunteer_support_cause` ;

CREATE TABLE IF NOT EXISTS `ngo_management_system`.`volunteer_support_cause` (
  `volunteer_id` INT NOT NULL,
  `support_cause_id` INT NOT NULL,
  PRIMARY KEY (`volunteer_id`, `support_cause_id`),
  INDEX `support_cause_id_idx` (`support_cause_id` ASC) VISIBLE,
  CONSTRAINT `volunteer_id_volunteer`
    FOREIGN KEY (`volunteer_id`) REFERENCES `ngo_management_system`.`volunteer` (`volunteer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `support_cause_id_cause`
    FOREIGN KEY (`support_cause_id`) REFERENCES `ngo_management_system`.`cause` (`cause_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

LOCK TABLES `volunteer_support_cause` WRITE;
/*!40000 ALTER TABLE `volunteer_support_cause` DISABLE KEYS */;
INSERT INTO `volunteer_support_cause` VALUES (4,2),(5,2),(3,3),(2,4),(1,5);
/*!40000 ALTER TABLE `volunteer_support_cause` ENABLE KEYS */;
UNLOCK TABLES;

-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: sport_store
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id_bill` int NOT NULL AUTO_INCREMENT,
  `bill_code` varchar(45) NOT NULL,
  `bill_createdate` datetime NOT NULL,
  `id_bill_user` int NOT NULL,
  `bill_description` varchar(200) DEFAULT NULL,
  `bill_status` int NOT NULL,
  PRIMARY KEY (`id_bill`),
  UNIQUE KEY `bill_code_UNIQUE` (`bill_code`),
  KEY `user_foreignkey_idx` (`id_bill_user`),
  CONSTRAINT `user_foreignkey` FOREIGN KEY (`id_bill_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'Bill1','2020-12-26 06:15:00',8,'cọc 30% xong trả hết ',0),(2,'Bill2','2020-12-26 06:15:00',7,'cọc 30% xong trả hết ',0),(4,'Bill3','2020-12-26 06:00:00',5,'cọc 30% xong trả hết ',0),(5,'Bill4','2020-12-26 06:05:00',6,'cọc 30% xong trả hết ',0),(6,'Biil5','2020-12-26 06:15:00',3,'cọc 30% xong trả hết ',0),(7,'Bill6','2020-12-26 06:15:00',5,'none',1),(105,'Bill7','2020-12-24 00:00:00',1,'none',1),(106,'Bill8','2020-12-25 00:00:00',1,'Done',1),(107,'Bill9','2020-12-25 00:00:00',1,'Done',1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billdetail` (
  `id_billdetail_bill` int NOT NULL,
  `billdetail_quantity` int NOT NULL,
  `billdetail_price` int NOT NULL,
  `id_billdetail_stock` int NOT NULL,
  UNIQUE KEY `uni_idbill_idpro` (`id_billdetail_bill`,`id_billdetail_stock`),
  KEY `billdetail_stock_foreignkey` (`id_billdetail_stock`),
  CONSTRAINT `billdetail_bi_foreignkey` FOREIGN KEY (`id_billdetail_bill`) REFERENCES `bill` (`id_bill`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `billdetail_stock_foreignkey` FOREIGN KEY (`id_billdetail_stock`) REFERENCES `stock` (`id_stock`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
INSERT INTO `billdetail` VALUES (1,1,325000,1),(1,5,400000,2),(2,3,300000,1),(2,5,300000,2),(4,10,325000,1),(5,14,325000,5),(6,16,50000,6),(7,2,400000,45),(105,2,300000,40),(105,1,400000,45),(106,3,20000,47),(106,2,250000,68),(107,1,120000,41);
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`cuong`@`localhost`*/ /*!50003 TRIGGER `saveupdatesto` AFTER INSERT ON `billdetail` FOR EACH ROW begin
update stock
    set
    stock_quantity=stock.stock_quantity-New.billdetail_quantity
    where stock.id_stock=New.id_billdetail_stock AND stock.stock_activeflag=1;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`cuong`@`localhost`*/ /*!50003 TRIGGER `delupdatesto` AFTER DELETE ON `billdetail` FOR EACH ROW begin
update stock
    set stock_quantity=stock.stock_quantity+OLD.billdetail_quantity
    where stock.id_stock=OLD.id_billdetail_stock && stock.stock_activeflag=1;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `id_bra` int NOT NULL,
  `bra_code` varchar(45) NOT NULL,
  `bra_name` varchar(45) NOT NULL,
  `bra_description` varchar(200) DEFAULT NULL,
  `bra_activeflag` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_bra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'NhanhieuNike','Nike','Nike là một tập đoàn đa quốc gia của Mỹ hoạt động trong lĩnh vực thiết kế, phát triển, sản xuất, quảng bá cũng như kinh doang các mặt hàng giày dép, quần áo phụ kiện,…',1),(2,'NhanhieuAdidas','Adidas','Adidas là thương hiệu thời trang thể thao của Đức, được thành lập bởi anh em nhà Dassler vào năm 1942.',1),(3,'NhanhieuBitis','Bitis','Biti\'s là một thương hiệu chuyên về sản xuất giày dép tại Việt Nam, được thành lập tại quận 6, thành phố Hồ Chí Minh',1),(4,'NhanhieuPuma','Puma','Puma là một công ty đa quốc gia lớn của Đức chuyên sản xuất giày và các dụng cụ thể thao khác có trụ sở tại Herzogenaurach, Bavaria, Đức',1),(5,'NhanhieuMizubo','Mizuno','Mizuno là một công ty về dụng cụ và đồ thể thao như golf, tennis, bóng chày, bóng đá, bóng chuyền,…',1);
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch_category`
--

DROP TABLE IF EXISTS `branch_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch_category` (
  `id_bracate_bra` int NOT NULL,
  `id_bracate_cate` int NOT NULL,
  `id_bracate` int NOT NULL,
  `bracate_activeflag` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_bracate`),
  KEY `fk_branch_has_category_branch1_idx` (`id_bracate_bra`),
  KEY `category_foreignkey_idx` (`id_bracate_cate`),
  CONSTRAINT `branch_foreignkey` FOREIGN KEY (`id_bracate_bra`) REFERENCES `branch` (`id_bra`),
  CONSTRAINT `category_foreignkey` FOREIGN KEY (`id_bracate_cate`) REFERENCES `category` (`id_cate`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch_category`
--

LOCK TABLES `branch_category` WRITE;
/*!40000 ALTER TABLE `branch_category` DISABLE KEYS */;
INSERT INTO `branch_category` VALUES (1,1,1,1),(2,1,2,1),(3,1,3,1),(4,1,4,1),(5,1,5,1),(1,2,6,1),(2,2,7,1),(3,2,8,1),(4,2,9,1),(5,2,10,1),(1,3,11,1),(2,3,12,1),(3,3,13,1),(4,3,14,1),(5,3,15,1),(1,4,16,1),(2,4,17,1),(3,4,18,1),(4,4,19,1),(5,4,20,1),(1,5,21,1),(2,5,22,1),(3,5,23,1),(4,5,24,1),(5,5,25,1),(1,6,26,1),(2,6,27,1),(3,6,28,1),(4,6,29,1),(5,6,30,1),(1,7,31,1),(2,7,32,1),(3,7,33,1),(4,7,34,1),(5,7,35,1),(1,8,36,1),(2,8,37,1),(3,8,38,1),(4,8,39,1),(5,8,40,1),(1,9,41,1),(2,9,42,1),(3,9,43,1),(4,9,44,1),(5,9,45,1),(1,10,46,1),(2,10,47,1),(3,10,48,1),(4,10,49,1),(5,10,50,1);
/*!40000 ALTER TABLE `branch_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id_cate` int NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(100) DEFAULT NULL,
  `cate_measureunit` varchar(45) NOT NULL,
  `cate_code` varchar(45) NOT NULL,
  `cate_groupsize` int NOT NULL,
  `cate_activeflag` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_cate`),
  UNIQUE KEY `cate_code_UNIQUE` (`cate_code`),
  UNIQUE KEY `c_name_UNIQUE` (`cate_name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Quần áo bóng đá','Bộ','QuanAo',0,1),(2,'Vớ bóng đá','Đôi','Vo',0,1),(3,'Áo lót bóng đá','Cái','Ao',0,1),(4,'Túi đựng phụ kiện','Cái','Tui',0,1),(5,'Bọc gối','Đôi','Bocgoi',0,1),(6,'Bọc khuỷu tay','Đôi','Bocavb',0,1),(7,'Bóng đá','Cái','Bong',0,1),(8,'Giày đá bóng','Đôi','Giay',1,1),(9,'Bọc ống đồng','Đôi','Boc',1,1),(10,'Cúp bóng đá','Cái','Cup',1,1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `id_color` int NOT NULL AUTO_INCREMENT,
  `color_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_color`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Màu xanh lá chuối'),(2,'Màu xanh da trời'),(3,'Màu đỏ '),(4,'Màu đen'),(5,'Màu tím'),(6,'Màu trắng'),(7,'Màu bạc'),(8,'Màu đồng'),(9,'Màu cam'),(10,'Màu vàng');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_info` (
  `id_pro` int NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(45) NOT NULL,
  `pro_description` varchar(200) DEFAULT NULL,
  `pro_code` varchar(45) NOT NULL,
  `pro_current_price` int NOT NULL,
  `id_pro_bracate` int NOT NULL,
  `pro_create_date` date NOT NULL,
  `pro_update_date` date NOT NULL,
  `pro_active_flag` int NOT NULL,
  PRIMARY KEY (`id_pro`),
  UNIQUE KEY `code_UNIQUE` (`pro_code`),
  KEY `bracate_foreignkey_idx` (`id_pro_bracate`),
  CONSTRAINT `bracate_foreignkey` FOREIGN KEY (`id_pro_bracate`) REFERENCES `branch_category` (`id_bracate`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
INSERT INTO `product_info` VALUES (1,'Áo đá banh Juventus','Áo sọc trắng-đen','AoJuve',325000,5,'2020-04-12','2020-12-26',1),(2,'Áo đá banh Bayer','Áo màu đỏ','AoBayer',325000,4,'2020-12-22','2020-12-22',1),(3,'Bọc bảo vệ khuỷu tay Bitis','co dãn tốt ','Bkt1',50000,28,'2020-12-09','2020-12-24',1),(4,'Áo lót thể thao Mizuno','thấm mồ hôi tốt ','AlttMi1',300000,15,'2020-12-09','2020-12-24',1),(5,'Áo lót cao cấp Mizuno','chất lượng cao','AlttMi2',400000,15,'2020-12-09','2020-12-24',1),(6,'Túi phụ kiện Bitis','đen sọc đỏ,trắng sọc\nxanh da trời','tpkBi1',20000,18,'2020-12-09','2020-12-24',1),(7,'GiayNike','none','GiaydbNi',100000,36,'2020-12-22','2020-12-22',1),(8,'GiayAdidas','none','GiaydbAd',120000,37,'2020-12-22','2020-12-22',1),(9,'Bọc đồng Nike ','none','BocNIke',100000,41,'2020-12-24','2020-12-24',1),(28,'Bọc gối Puma','vải co dãn ,đỏ chủ \nđạo','BocPuma',170000,24,'2020-12-24','2020-12-24',1),(29,'Túi phụ kiện Adidas','none','TpkAdi',150000,17,'2020-12-24','2020-12-24',0),(35,'Bộ quần áo Mizuno','none','QAMi',150000,5,'2020-12-25','2020-12-25',1),(36,'Bộ quần áo Puma','Đa dạng về kích cỡ ','QAPu',170000,4,'2020-12-25','2020-12-25',1),(37,'Quần áo Nike cao cấp ','none','QANicc',250000,1,'2020-12-25','2020-12-25',1),(38,'Vớ bóng đá Bitis','Nhắm vào phân khúc \ngiá rẻ ','VoBitis ',30000,8,'2020-12-25','2020-12-25',0),(39,'Boc goi Adidas','none','BocAd',40000,22,'2020-12-25','2020-12-25',0),(40,'Bóng đá Nike','màu đen+trằng,cam\n+trắng ','BDNi',120000,31,'2020-12-25','2020-12-25',1),(41,'Cup Bóng Đá Nike','số lượng có hạn','CupNike',1500000,46,'2020-12-25','2020-12-25',0),(42,'Cúp bóng đá Puma','Số lượng có hạn ','CupPu',1300000,49,'2020-12-25','2020-12-25',1),(43,'Bọc tay Puma','chất lượng tốt','BktPu',100000,29,'2020-12-25','2020-12-25',1);
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id_size` int NOT NULL AUTO_INCREMENT,
  `size_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_size`),
  UNIQUE KEY `ten_size_UNIQUE` (`size_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (8,'38'),(9,'39'),(10,'40'),(11,'41'),(12,'42'),(13,'43'),(14,'44'),(15,'45'),(4,'L'),(3,'M'),(2,'S'),(5,'XL'),(1,'XS'),(6,'XXL'),(7,'XXXL');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id_stock` int NOT NULL AUTO_INCREMENT,
  `stock_quantity` int NOT NULL,
  `id_stock_size` int NOT NULL,
  `id_stock_color` int NOT NULL,
  `id_stock_pro` int NOT NULL,
  `stock_activeflag` int NOT NULL,
  PRIMARY KEY (`id_stock`),
  UNIQUE KEY `uni_size_color_pro` (`id_stock_size`,`id_stock_color`,`id_stock_pro`),
  KEY `pro_foreignkey_idx` (`id_stock_pro`),
  KEY `color_foreignkey_idx` (`id_stock_color`),
  KEY `size_foreignkey_idx` (`id_stock_size`),
  CONSTRAINT `color_foreignkey` FOREIGN KEY (`id_stock_color`) REFERENCES `color` (`id_color`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pro_foreignkey` FOREIGN KEY (`id_stock_pro`) REFERENCES `product_info` (`id_pro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `size_foreignkey` FOREIGN KEY (`id_stock_size`) REFERENCES `size` (`id_size`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,23,1,3,1,1),(2,0,1,3,2,0),(3,0,2,4,1,0),(4,0,2,4,2,0),(5,25,3,2,1,1),(6,20,4,2,1,1),(7,0,3,4,2,0),(8,16,6,4,1,1),(16,0,5,6,3,0),(17,0,7,5,4,0),(18,3,5,4,5,1),(19,97,3,1,3,1),(20,98,1,4,3,1),(21,100,3,2,3,1),(25,100,2,1,3,1),(26,0,5,1,5,0),(27,0,2,5,5,0),(29,0,6,3,5,0),(30,0,2,2,6,0),(31,0,10,3,7,0),(32,0,13,3,7,0),(33,34,12,2,7,1),(34,20,9,1,7,1),(35,0,12,1,7,0),(36,23,15,5,7,1),(37,0,4,1,4,0),(38,23,3,2,2,1),(39,34,4,2,2,1),(40,19,3,1,4,1),(41,22,13,7,8,1),(42,21,13,8,8,1),(43,3,10,5,9,1),(44,3,9,1,9,1),(45,-1,3,3,5,1),(46,50,1,4,6,1),(47,28,1,6,6,1),(48,30,1,4,28,1),(49,40,6,8,28,1),(50,40,6,5,28,1),(59,50,4,2,35,1),(60,40,3,4,35,1),(61,35,3,5,35,1),(62,50,1,4,36,1),(63,50,4,4,36,1),(64,60,3,4,36,1),(65,55,2,4,36,1),(66,55,1,4,37,1),(67,45,2,4,37,1),(68,33,3,4,37,1),(69,35,4,4,37,1),(72,0,2,2,38,0),(73,0,1,2,39,0),(74,40,13,4,40,1),(75,30,13,9,40,1),(76,0,13,7,41,0),(77,15,8,10,42,1),(78,50,2,3,43,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `user_code` varchar(45) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_phone` varchar(45) NOT NULL,
  `user_gmail` varchar(100) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_active_flag` int NOT NULL,
  `user_gender` varchar(10) NOT NULL,
  `user_createdate` datetime NOT NULL,
  `user_updatedate` datetime NOT NULL,
  `user_isadmin` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `code_UNIQUE` (`user_code`),
  UNIQUE KEY `phonenum_UNIQUE` (`user_phone`),
  UNIQUE KEY `gmail_UNIQUE` (`user_gmail`),
  UNIQUE KEY `password_UNIQUE` (`user_password`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'NV0001','Phan Văn Cường','0905000001','phanvancuong@gmail.com','phanvancuong',1,'Male','2020-09-02 00:00:00','2020-12-23 00:00:00',1),(2,'NV0002','Lê Minh Lợi','0905000002','leminhloi@gmail.com','leminhloi',1,'Male','2020-09-02 00:00:00','2020-12-24 00:00:00',1),(3,'NV0003','Dương Đại Phước','0905000003','duongdaiphuoc@gmail.com','duongdaiphuoc',1,'Male','2020-09-02 00:00:00','2020-12-24 00:00:00',0),(4,'NV0004','Trà My','0905000004','tramy@gmail.com','tramy123',1,'Female','2020-09-02 00:00:00','2020-12-24 00:00:00',0),(5,'NV0005','Đoàn Vinh Quang','0905000005','doanvinhquang@gmail.com','doanvinhquang',0,'Male','2020-09-03 00:00:00','2020-12-23 00:00:00',0),(6,'NV0006','Lê Viết Nhân','0905000006','levietnhan@gmail.com','levietnhan',1,'Female','2020-09-04 00:00:00','2020-12-24 00:00:00',0),(7,'NV0007','Nguyễn Hữu Phước','0905000007','nguyenhuuphuoc@gmail.com','nguyenhuuphuoc',1,'Male','2020-09-05 00:00:00','2020-09-06 00:00:00',0),(8,'NV0008','Hồ Thanh Phúc','0905000008','hothanhphuc@gmail.com','hothanhphuc',1,'Female','2020-09-06 00:00:00','2020-12-24 00:00:00',0),(9,'NV0009','Trần Anh Quyền','0905000009','trananhquyen@gmail.com','trananhquyen',1,'Male','2020-09-07 00:00:00','2020-12-24 00:00:00',0),(10,'NV0010','Hứa Thị Linh Chi','0905000010','huathilinhchi@gmail.com','huathilinhchi',0,'Female','2020-09-08 00:00:00','2020-12-25 00:00:00',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sport_store'
--

--
-- Dumping routines for database 'sport_store'
--
/*!50003 DROP PROCEDURE IF EXISTS `productpro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`cuong`@`localhost` PROCEDURE `productpro`(IN offsett int,IN rowcount int ,IN sortoption int1)
begin
	select product_info.*,branch.*,branch_category.*,category.*  from product_info 
join branch_category
on product_info.id_pro_bracate=branch_category.id_bracate
join branch
on branch_category.id_bracate_bra=branch.id_bra
join category
on branch_category.id_bracate_cate=category.id_cate
order by
	if (sortoption=0,product_info.pro_code,'' ) asc,
    if (sortoption=1,product_info.pro_code,'' ) desc,
    if (sortoption=2,product_info.pro_name,'' ) asc,
    if (sortoption=3,product_info.pro_name,'' ) desc,
    if (sortoption=4,product_info.pro_current_price,'' ) asc,
    if (sortoption=5,product_info.pro_current_price,'' ) desc,
    if (sortoption=6,category.cate_name,'' ) asc,
    if (sortoption=7,category.cate_name,'' ) desc
limit offsett,rowcount
;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-19 16:27:11

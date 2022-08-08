-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: v2_system
-- ------------------------------------------------------
-- Server version	5.7.38

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
-- Table structure for table `menu_operate`
--

DROP TABLE IF EXISTS `menu_operate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_operate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '所属菜单',
  `location` char(10) NOT NULL DEFAULT '' COMMENT '操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)',
  `permission_identify` varchar(50) NOT NULL DEFAULT '' COMMENT '权限标识',
  `name_en` varchar(20) NOT NULL DEFAULT '' COMMENT '操作名称(英文)',
  `name_zh` varchar(50) NOT NULL DEFAULT '' COMMENT '操作名称(中文)',
  `uri` varchar(50) NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='模块-菜单-操作';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_operate`
--

LOCK TABLES `menu_operate` WRITE;
/*!40000 ALTER TABLE `menu_operate` DISABLE KEYS */;
INSERT INTO `menu_operate` VALUES (1,2,'TABLE','SYSTEM:MODULE:INDEX','index','列表','/module/index',0),(2,2,'TABLE-HEAD','SYSTEM:MODULE:CREATE','create','添加','/module/store',0),(3,2,'TABLE-BODY','SYSTEM:MODULE:UPDATE','update','编辑','/module/update',0),(4,2,'TABLE-BODY','SYSTEM:MODULE:DESTROY','destroy','删除','/module/destroy',0),(5,2,'TABLE-BODY','SYSTEM:MODULE:LOGS','logs','日志','/module/logs',0),(6,2,'TABLE-BODY','SYSTEM:MODULE:ACTIVE','active','启用','/module/active',0),(7,2,'TABLE-HEAD','SYSTEM:MODULE:BATCH-ACTIVE','batchActive','批量启用','/module/batchactive',0),(8,2,'TABLE-BODY','SYSTEM:MODULE:INACTIVE','inactive','禁用','/module/inactive',0),(9,2,'TABLE-HEAD','SYSTEM:MODULE:BATCH-INACTIVE','batchInActive','批量禁用','/module/batchinactive',0),(10,2,'TABLE-HEAD','SYSTEM:MODULE:BATCH-DESTROY','batchDestroy','批量删除','/module/batchdestroy',0);
/*!40000 ALTER TABLE `menu_operate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-08 23:49:11

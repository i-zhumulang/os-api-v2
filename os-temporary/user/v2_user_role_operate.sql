-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: v2_user
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
-- Table structure for table `role_operate`
--

DROP TABLE IF EXISTS `role_operate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_operate` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键',
  `role_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '角色ID',
  `role_module_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色-模块ID',
  `role_menu_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '模块-菜单ID',
  `system_module_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '模块ID',
  `system_menu_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '菜单ID',
  `system_menu_operate_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '操作ID',
  `sorting` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='菜单-操作';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_operate`
--

LOCK TABLES `role_operate` WRITE;
/*!40000 ALTER TABLE `role_operate` DISABLE KEYS */;
INSERT INTO `role_operate` VALUES (1100236037722001408,1,1100230276350537728,1100230278099562496,1100176417150205952,1100177341767860224,1100236037722001408,0),(1100236038808326144,1,1100230276350537728,1100230278099562496,1100176417150205952,1100177341767860224,1100230273687154688,0),(1100236039747850240,1,1100230276350537728,1100230278099562496,1100176417150205952,1100177341767860224,1100230274244997120,0),(1100236040255361024,1,1100230276350537728,1100230278099562496,1100176417150205952,1100177341767860224,1100230275067080704,0),(1100236043107487744,1,1100230276350537728,1100230279420768256,1100176417150205952,1100177342397005824,1100236041077444608,0),(1100236043623387136,1,1100230276350537728,1100230279420768256,1100176417150205952,1100177342397005824,1100236041568178176,0),(1100236044206395392,1,1100230276350537728,1100230279420768256,1100176417150205952,1100177342397005824,1100236042088271872,0),(1100903754149928960,1,1100230276350537728,1100230279420768256,1100176417150205952,1100177342397005824,1100236042570616832,0),(1104211676212879360,1,1100230276350537728,1104209218967199744,1100176417150205952,1102868720906162176,1104209217075568640,0),(1104211676724584448,1,1100230276350537728,1104209218967199744,1100176417150205952,1102868720906162176,1104209217704714240,0),(1106525606733967360,1,1100230276350537728,1104209218967199744,1100176417150205952,1102868720906162176,1105072550674710528,0),(1106525606981431296,1,1100230276350537728,1104209218967199744,1100176417150205952,1102868720906162176,1105072956964356096,1),(1106526075837497344,1,1100230276883214336,1106526076093349888,1100176417951318016,1102872191327817728,1106529978750615552,0),(1106888317007331328,1,1100230276883214336,1106888316755673088,1100176417951318016,1102872407070232576,1106888317242212352,0),(1107061488520065024,1,1100230276883214336,1106888317477093376,1100176417951318016,1102873120315822080,1107059570620084224,0),(1107172442549309440,1,1100230276883214336,1106888317477093376,1100176417951318016,1102873120315822080,1107171405813903360,0),(1107172442788384768,1,1100230276883214336,1106888317477093376,1100176417951318016,1102873120315822080,1107170681164001280,0),(1107172443019071488,1,1100230276883214336,1106888317477093376,1100176417951318016,1102873120315822080,1107170901645979648,1),(1108694226037653504,1,1100230276883214336,1108694225790189568,1100176417951318016,1102873569563529216,1108694226276728832,0);
/*!40000 ALTER TABLE `role_operate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-08 21:13:44

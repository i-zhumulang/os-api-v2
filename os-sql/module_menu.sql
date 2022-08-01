/*
 Navicat Premium Data Transfer

 Source Server         : 本地-127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : v2_system

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 01/08/2022 20:04:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for module_menu
-- ----------------------------
DROP TABLE IF EXISTS `module_menu`;
CREATE TABLE `module_menu`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` int(0) UNSIGNED NOT NULL COMMENT '上级菜单ID',
  `module_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属模块',
  `name_en` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '英文名称',
  `name_zh` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '中文名称',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '模块-菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module_menu
-- ----------------------------
INSERT INTO `module_menu` VALUES (1, 0, 1, 'system.module', '模块菜单', '#', 0);
INSERT INTO `module_menu` VALUES (2, 1, 1, 'system.module.index', '模块列表', '/module/index', 0);
INSERT INTO `module_menu` VALUES (3, 1, 1, 'system.menu.index', '菜单列表', '/modulemenu/index', 1);

SET FOREIGN_KEY_CHECKS = 1;

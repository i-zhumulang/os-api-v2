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

 Date: 01/08/2022 20:02:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for module_menu_operate
-- ----------------------------
DROP TABLE IF EXISTS `module_menu_operate`;
CREATE TABLE `module_menu_operate`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `module_menu_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属菜单',
  `location` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)',
  `permission_identify` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `name_en` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '操作名称(英文)',
  `name_zh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '操作名称(中文)',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '模块-菜单-操作' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module_menu_operate
-- ----------------------------
INSERT INTO `module_menu_operate` VALUES (1, 2, 'TABLE', 'SYSTEM:MODULE:INDEX', 'index', '列表', '/module/index', 0);
INSERT INTO `module_menu_operate` VALUES (2, 2, 'TABLE-HEAD', 'SYSTEM:MODULE:CREATE', 'create', '添加', '/module/store', 0);
INSERT INTO `module_menu_operate` VALUES (3, 2, 'TABLE-BODY', 'SYSTEM:MODULE:UPDATE', 'update', '编辑', '/module/update', 0);
INSERT INTO `module_menu_operate` VALUES (4, 2, 'TABLE-BODY', 'SYSTEM:MODULE:DESTROY', 'destroy', '删除', '/module/destroy', 0);
INSERT INTO `module_menu_operate` VALUES (5, 2, 'TABLE-BODY', 'SYSTEM:MODULE:LOGS', 'logs', '日志', '/module/logs', 0);
INSERT INTO `module_menu_operate` VALUES (6, 2, 'TABLE-BODY', 'SYSTEM:MODULE:ACTIVE', 'active', '启用', '/module/active', 0);
INSERT INTO `module_menu_operate` VALUES (7, 2, 'TABLE-HEAD', 'SYSTEM:MODULE:BATCH-ACTIVE', 'batchActive', '批量启用', '/module/batchactive', 0);
INSERT INTO `module_menu_operate` VALUES (8, 2, 'TABLE-BODY', 'SYSTEM:MODULE:INACTIVE', 'inactive', '禁用', '/module/inactive', 0);
INSERT INTO `module_menu_operate` VALUES (9, 2, 'TABLE-HEAD', 'SYSTEM:MODULE:BATCH-INACTIVE', 'batchInActive', '批量禁用', '/module/batchinactive', 0);
INSERT INTO `module_menu_operate` VALUES (10, 2, 'TABLE-HEAD', 'SYSTEM:MODULE:BATCH-DESTROY', 'batchDestroy', '批量删除', '/module/batchdestroy', 0);

SET FOREIGN_KEY_CHECKS = 1;

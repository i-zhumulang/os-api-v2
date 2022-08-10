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

 Date: 09/08/2022 17:58:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parent_id` int(0) UNSIGNED NOT NULL COMMENT '上级菜单ID',
  `module_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属模块',
  `name_en` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '英文名称',
  `name_zh` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '中文名称',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块-菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, 1, 'system.module', '模块菜单', '#', 0);
INSERT INTO `menu` VALUES (2, 1, 1, 'system.module.index', '模块列表', '/system/module/index', 0);
INSERT INTO `menu` VALUES (3, 1, 1, 'system.menu.index', '菜单列表', '/system/menu/index', 1);

-- ----------------------------
-- Table structure for menu_operate
-- ----------------------------
DROP TABLE IF EXISTS `menu_operate`;
CREATE TABLE `menu_operate`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `menu_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属菜单',
  `location` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)',
  `type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'element-plus button 对应type属性',
  `permission_identify` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `name_en` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作名称(英文)',
  `name_zh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作名称(中文)',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块-菜单-操作' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu_operate
-- ----------------------------
INSERT INTO `menu_operate` VALUES (1, 2, 'TABLE', '', 'SYSTEM:MODULE:INDEX', 'index', '列表', '/module/index', 0);
INSERT INTO `menu_operate` VALUES (2, 2, 'TABLE-HEAD', '', 'SYSTEM:MODULE:CREATE', 'create', '添加', '/module/store', 0);
INSERT INTO `menu_operate` VALUES (3, 2, 'TABLE-BODY', '', 'SYSTEM:MODULE:UPDATE', 'update', '编辑', '/module/update', 0);
INSERT INTO `menu_operate` VALUES (4, 2, 'TABLE-BODY', '', 'SYSTEM:MODULE:DESTROY', 'destroy', '删除', '/module/destroy', 0);
INSERT INTO `menu_operate` VALUES (5, 2, 'TABLE-BODY', '', 'SYSTEM:MODULE:LOGS', 'logs', '日志', '/module/logs', 0);
INSERT INTO `menu_operate` VALUES (6, 2, 'TABLE-BODY', '', 'SYSTEM:MODULE:ACTIVE', 'active', '启用', '/module/active', 0);
INSERT INTO `menu_operate` VALUES (7, 2, 'TABLE-HEAD', '', 'SYSTEM:MODULE:BATCH-ACTIVE', 'batchActive', '批量启用', '/module/batchactive', 0);
INSERT INTO `menu_operate` VALUES (8, 2, 'TABLE-BODY', '', 'SYSTEM:MODULE:INACTIVE', 'inactive', '禁用', '/module/inactive', 0);
INSERT INTO `menu_operate` VALUES (9, 2, 'TABLE-HEAD', '', 'SYSTEM:MODULE:BATCH-INACTIVE', 'batchInActive', '批量禁用', '/module/batchinactive', 0);
INSERT INTO `menu_operate` VALUES (10, 2, 'TABLE-HEAD', '', 'SYSTEM:MODULE:BATCH-DESTROY', 'batchDestroy', '批量删除', '/module/batchdestroy', 0);

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_en` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称(英文)',
  `name_zh` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称(中文)',
  `domain` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块域名',
  `home_page` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块首页',
  `sorting` tinyint(0) NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES (1, 'SYSTEM', '系统管理', 'http://127.0.0.1:8080/system', '/module/index', 0);
INSERT INTO `module` VALUES (2, 'USER', '个人中心', 'http://127.0.0.1:8080/user', '/user/index', 0);

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `branch_id` bigint(0) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(0) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'AT transaction mode undo table' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

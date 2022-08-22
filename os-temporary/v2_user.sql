/*
 Navicat Premium Data Transfer

 Source Server         : 本地-127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : v2_user

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 22/08/2022 20:32:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu_operate
-- ----------------------------
DROP TABLE IF EXISTS `menu_operate`;
CREATE TABLE `menu_operate`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '主键',
  `module_menu_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '模块-菜单ID',
  `role_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `system_module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '模块ID',
  `system_menu_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单ID',
  `system_menu_operate_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作ID',
  `sorting` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单-操作' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_operate
-- ----------------------------
INSERT INTO `menu_operate` VALUES (1100236037722001408, 1100230278099562496, 1, 1100176417150205952, 1100177341767860224, 1100236037722001408, 0);
INSERT INTO `menu_operate` VALUES (1100236038808326144, 1100230278099562496, 1, 1100176417150205952, 1100177341767860224, 1100230273687154688, 0);
INSERT INTO `menu_operate` VALUES (1100236039747850240, 1100230278099562496, 1, 1100176417150205952, 1100177341767860224, 1100230274244997120, 0);
INSERT INTO `menu_operate` VALUES (1100236040255361024, 1100230278099562496, 1, 1100176417150205952, 1100177341767860224, 1100230275067080704, 0);

-- ----------------------------
-- Table structure for module_menu
-- ----------------------------
DROP TABLE IF EXISTS `module_menu`;
CREATE TABLE `module_menu`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `role_module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色-模块ID',
  `role_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `system_module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '模块ID',
  `system_menu_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单ID(v2_system.menu表ID)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块-菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of module_menu
-- ----------------------------
INSERT INTO `module_menu` VALUES (1100230277583663104, 1100230276350537728, 1, 1100176417150205952, 1100177340668952576);
INSERT INTO `module_menu` VALUES (1100230278099562496, 1100230276350537728, 1, 1100176417150205952, 1100177341767860224);
INSERT INTO `module_menu` VALUES (1100230279420768256, 1100230276350537728, 1, 1100176417150205952, 1100177342397005824);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_en` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称(英文)',
  `name_zh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称(中文)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `role` VALUES (2, '普通用户', '普通用户');
INSERT INTO `role` VALUES (3, '公司管理员', '公司管理员');
INSERT INTO `role` VALUES (4, '集团管理员', '集团管理员');

-- ----------------------------
-- Table structure for role_module
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `role_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `system_module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '模块ID(v2_system.module表ID)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-模块' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_module
-- ----------------------------
INSERT INTO `role_module` VALUES (1100230276350537728, 1, 1100176417150205952);
INSERT INTO `role_module` VALUES (1100230276883214336, 1, 1100176417951318016);

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'AT transaction mode undo table' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of undo_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '用户ID',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-主表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1035433978183557120, '18120827456', '吴荣超', 1657633419071);

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `user_id` bigint(0) UNSIGNED NOT NULL COMMENT '用户ID',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `authentication` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `salt` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '加密用的盐',
  `iv` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '一个非空初始化向量',
  `state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `deleted_state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0:否,1:是)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-账号' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1035433978183557120, '18120827456', 'IpIj+iIo3C7GeURjG30EnA==', 'CeKASEI8J8IZJa67F2PkEn4X9mDihzpe', 'uoI20c88igFvi6eE', 0, 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `user_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1035433978183557120, 1658239800000);

SET FOREIGN_KEY_CHECKS = 1;

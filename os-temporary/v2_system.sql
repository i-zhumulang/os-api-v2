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

 Date: 02/09/2022 14:22:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(0) UNSIGNED NOT NULL DEFAULT 0,
  `parent_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级菜单ID',
  `module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属模块',
  `name_en` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '英文名称',
  `name_zh` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '中文名称',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块-菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1100177340668952576, 0, 1100176417150205952, 'system.module', '模块菜单', '#', 0);
INSERT INTO `menu` VALUES (1100177341767860224, 1100177340668952576, 1100176417150205952, 'system.module.index', '模块列表', '/system/module/index', 0);
INSERT INTO `menu` VALUES (1100177342397005824, 1100177340668952576, 1100176417150205952, 'system.menu.index', '菜单列表', '/system/menu/index', 1);
INSERT INTO `menu` VALUES (1102868720906162176, 1100177340668952576, 1100176417150205952, 'system.operate.index', '菜单操作', '/system/operate/index', 2);
INSERT INTO `menu` VALUES (1102871794815094784, 0, 1100176417951318016, 'user.user', '会员管理', '#', 2);
INSERT INTO `menu` VALUES (1102872191327817728, 1102871794815094784, 1100176417951318016, 'user.user.index', '会员列表', '/user/user/index', 0);
INSERT INTO `menu` VALUES (1102872407070232576, 1102871794815094784, 1100176417951318016, 'user.role.index', '角色列表', '/user/role/index', 1);
INSERT INTO `menu` VALUES (1102873120315822080, 1102871794815094784, 1100176417951318016, 'user.rolemodule.index', '角色模块', '/user/rolemodule/index', 2);
INSERT INTO `menu` VALUES (1102873569563529216, 1102871794815094784, 1100176417951318016, 'user.rolemenu.index', '角色菜单', '/user/rolemenu/index', 3);
INSERT INTO `menu` VALUES (1102873731409137664, 1102871794815094784, 1100176417951318016, 'user.roleoperate.index', '角色操作', '/user/roleoperate/index', 4);

-- ----------------------------
-- Table structure for menu_operate
-- ----------------------------
DROP TABLE IF EXISTS `menu_operate`;
CREATE TABLE `menu_operate`  (
  `id` bigint(0) UNSIGNED NOT NULL DEFAULT 0,
  `module_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属模块',
  `menu_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属菜单',
  `location` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作位置(TABLE:表格数据,TABLE-HEAD:表头,TABLE-BODY:表体)',
  `type` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'element-plus button 对应type属性',
  `permission_identify` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `name_en` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作名称(英文)',
  `name_zh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作名称(中文)',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `sorting` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块-菜单-操作' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu_operate
-- ----------------------------
INSERT INTO `menu_operate` VALUES (1100230273204809728, 1100176417150205952, 1100177341767860224, 'TABLE', '', 'SYSTEM:MODULE:INDEX', 'index', '列表', '/module/index', 0);
INSERT INTO `menu_operate` VALUES (1100230273687154688, 1100176417150205952, 1100177341767860224, 'TABLE-HEAD', 'primary', 'SYSTEM:MODULE:CREATE', 'create', '添加', '/module/store', 0);
INSERT INTO `menu_operate` VALUES (1100230274244997120, 1100176417150205952, 1100177341767860224, 'TABLE-BODY', '', 'SYSTEM:MODULE:UPDATE', 'update', '编辑', '/module/update', 0);
INSERT INTO `menu_operate` VALUES (1100230275067080704, 1100176417150205952, 1100177341767860224, 'TABLE-BODY', '', 'SYSTEM:MODULE:DESTROY', 'destroy', '删除', '/module/destroy', 0);
INSERT INTO `menu_operate` VALUES (1100236041077444608, 1100176417150205952, 1100177342397005824, 'TABLE', '', 'SYSTEM:MENU:INDEX', 'index', '列表', '/menu/index', 0);
INSERT INTO `menu_operate` VALUES (1100236041568178176, 1100176417150205952, 1100177342397005824, 'TABLE-HEAD', 'primary', 'SYSTEM:MENU:CREATE', 'create', '添加', '/menu/store', 0);
INSERT INTO `menu_operate` VALUES (1100236042088271872, 1100176417150205952, 1100177342397005824, 'TABLE-BODY', '', 'SYSTEM:MENU:UPDATE', 'update', '编辑', '/menu/update', 0);
INSERT INTO `menu_operate` VALUES (1100236042570616832, 1100176417150205952, 1100177342397005824, 'TABLE-BODY', '', 'SYSTEM:MENU:DESTROY', 'destroy', '删除', '/menu/destroy', 0);
INSERT INTO `menu_operate` VALUES (1104209217075568640, 1100176417150205952, 1102868720906162176, 'TABLE', '', 'SYSTEM:OPERATE:INDEX', 'index', '列表', '/operate/index', 0);
INSERT INTO `menu_operate` VALUES (1104209217704714240, 1100176417150205952, 1102868720906162176, 'TABLE-HEAD', 'primary', 'SYSTEM:OPERATE:CREATE', 'create', '添加', '/operate/create', 0);

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `id` bigint(0) UNSIGNED NOT NULL DEFAULT 0,
  `name_en` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称(英文)',
  `name_zh` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称(中文)',
  `domain` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块域名',
  `home_page` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块首页',
  `sorting` tinyint(0) NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '模块' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES (1100176417150205952, 'SYSTEM', '系统管理', 'http://127.0.0.1:8080', '/system/module/index', 0);
INSERT INTO `module` VALUES (1100176417951318016, 'USER', '个人中心', 'http://127.0.0.1:8080', '/user/user/index', 0);
INSERT INTO `module` VALUES (1100176418634989568, 'DOCUMENT', '操作手册', 'http://127.0.0.1:8080', '/document/system/index', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_en` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称(英文)',
  `name_zh` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称(中文)',
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

SET FOREIGN_KEY_CHECKS = 1;

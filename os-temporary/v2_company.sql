/*
 Navicat Premium Data Transfer

 Source Server         : 本地-127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 127.0.0.1:3306
 Source Schema         : v2_company

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 02/08/2022 09:46:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clique
-- ----------------------------
DROP TABLE IF EXISTS `clique`;
CREATE TABLE `clique`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '集团ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '集团名称',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `deleted_state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '集团-主表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of clique
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '公司ID',
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属集团ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公司名称',
  `name_full` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公司全称',
  `state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `expire_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '到期时间',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `deleted_state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0:否,1:是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司-主表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for company_admin
-- ----------------------------
DROP TABLE IF EXISTS `company_admin`;
CREATE TABLE `company_admin`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID(对应v2_user库user表id字段)',
  `role_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID(1:集团管理员,2:公司管理员)',
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '集团ID(对应v2_company库clique表id字段)',
  `company_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '公司ID(对应v2_company库company表id字段)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司-管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_admin
-- ----------------------------

-- ----------------------------
-- Table structure for company_organization
-- ----------------------------
DROP TABLE IF EXISTS `company_organization`;
CREATE TABLE `company_organization`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '部门ID',
  `pid` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级部门ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0:正常)',
  `company_id` bigint(0) NOT NULL COMMENT '所属公司ID',
  `clique_id` bigint(0) NOT NULL COMMENT '所属集团ID',
  `created_at` bigint(0) UNSIGNED NOT NULL COMMENT '创建时间',
  `deleted_state` int(0) NOT NULL DEFAULT 0 COMMENT '是否删除(0:否,1:是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司-组织架构表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_organization
-- ----------------------------

-- ----------------------------
-- Table structure for company_position
-- ----------------------------
DROP TABLE IF EXISTS `company_position`;
CREATE TABLE `company_position`  (
  `id` bigint(0) UNSIGNED NOT NULL COMMENT '职位ID',
  `pid` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级职位ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '职位名称',
  `state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `company_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属公司ID',
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属集团ID',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  `deleted_state` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除(0:否,1:是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司-职位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of company_position
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '集团ID',
  `user_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `user_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户手机',
  `employee_position_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '默认公司职位',
  `created_at` bigint(0) UNSIGNED NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工-主表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for employee_company
-- ----------------------------
DROP TABLE IF EXISTS `employee_company`;
CREATE TABLE `employee_company`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `clique_id` bigint(0) UNSIGNED NOT NULL COMMENT '集团ID',
  `company_id` bigint(0) UNSIGNED NOT NULL COMMENT '公司ID',
  `employee_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '员工ID',
  `entry_date` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '入职日期',
  `resign_date` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '离职日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工-公司信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee_company
-- ----------------------------

-- ----------------------------
-- Table structure for employee_position
-- ----------------------------
DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '集团ID',
  `company_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '公司ID',
  `organization_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '部门ID',
  `position_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '职位ID',
  `employee_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '员工ID',
  `leader_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级ID',
  `start_date` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始时间(入职本职位开始时间)',
  `end_date` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束时间(入职本职位结束时间)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工-职位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee_position
-- ----------------------------

-- ----------------------------
-- Table structure for renewal
-- ----------------------------
DROP TABLE IF EXISTS `renewal`;
CREATE TABLE `renewal`  (
  `id` bigint(0) UNSIGNED NOT NULL,
  `clique_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属集团',
  `company_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属公司',
  `time_length` tinyint(0) UNSIGNED NOT NULL DEFAULT 3 COMMENT '时间长度(月)',
  `expire_time` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '本次续费过期时间',
  `order_amount` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单金额',
  `payment_amount` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '实际付款金额',
  `created_at` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公司-续费表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of renewal
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql80admin
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-21 11:28:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键' ,
`code`  int(32) NOT NULL COMMENT '编码' ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称' ,
`cn_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典中文名称' ,
PRIMARY KEY (`uuid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
BEGIN;
INSERT INTO `t_dictionary` VALUES ('1', '1', 'user_type', '用户类型'), ('2', '2', 'user_state', '用户状态');
COMMIT;

-- ----------------------------
-- Table structure for t_dictionary_info
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary_info`;
CREATE TABLE `t_dictionary_info` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键' ,
`dictionary_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典id' ,
`sort`  int(11) NOT NULL COMMENT '序号' ,
`key`  int(11) NOT NULL COMMENT '字典值' ,
`value`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典内容' ,
PRIMARY KEY (`uuid`),
FOREIGN KEY (`dictionary_id`) REFERENCES `t_dictionary` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `1` (`dictionary_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_dictionary_info
-- ----------------------------
BEGIN;
INSERT INTO `t_dictionary_info` VALUES ('1', '1', '0', '0', '超级管理员'), ('2', '1', '1', '1', '管理员'), ('3', '1', '2', '2', '用户'), ('4', '2', '1', '0', '注册'), ('5', '2', '2', '2', '封禁'), ('6', '2', '3', '1', '激活'), ('7', '2', '4', '3', '注销');
COMMIT;

-- ----------------------------
-- Table structure for t_manager_info
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_info`;
CREATE TABLE `t_manager_info` (
`uid`  int(32) NOT NULL AUTO_INCREMENT ,
`name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`nickname`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`state`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`uid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of t_manager_info
-- ----------------------------
BEGIN;
INSERT INTO `t_manager_info` VALUES ('1', '1', 'b34e82712243096b6ae71b89e1453a0dd1a1f9ac31b4600fd1fa3ab69d03957e', '1', '1'), ('3', 'admin', '8d26584ca49160d402a353ea07a832f15191014f8d2cce265849d38beca982b1', '管理员账号', '1'), ('4', '2', 'bbac89e189d434274f5265197cc7785d90b6dc7d43dd253045ddc93bfd841d41', '2', '0'), ('5', '3', '659f55a79b6fd1f3590d68f0081e0e29f19be3a292a47c6cc8ac7482922a7763', '3', '1');
COMMIT;

-- ----------------------------
-- Table structure for t_manager_role
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_role`;
CREATE TABLE `t_manager_role` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键' ,
`manager_id`  int(32) NOT NULL COMMENT '用户ID' ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID' ,
FOREIGN KEY (`manager_id`) REFERENCES `t_manager_info` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`role_id`) REFERENCES `t_role_info` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `role` (`role_id`) USING BTREE ,
INDEX `manager` (`manager_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_manager_role
-- ----------------------------
BEGIN;
INSERT INTO `t_manager_role` VALUES ('1', '3', '1');
COMMIT;

-- ----------------------------
-- Table structure for t_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_info`;
CREATE TABLE `t_menu_info` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menu_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menu_cnname`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menu_path`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menu_parent_id`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`uuid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_menu_info
-- ----------------------------
BEGIN;
INSERT INTO `t_menu_info` VALUES ('1', 'menu1', '菜单1', '/index', '');
COMMIT;

-- ----------------------------
-- Table structure for t_role_info
-- ----------------------------
DROP TABLE IF EXISTS `t_role_info`;
CREATE TABLE `t_role_info` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`role_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`role_cnname`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`uuid`),
INDEX `role` (`role_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_role_info
-- ----------------------------
BEGIN;
INSERT INTO `t_role_info` VALUES ('1', 'admin', '管理员');
COMMIT;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
`uuid`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`menu_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`uuid`),
FOREIGN KEY (`menu_id`) REFERENCES `t_menu_info` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`role_id`) REFERENCES `t_role_info` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `menu` (`menu_id`) USING BTREE ,
INDEX `roles` (`role_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menu` VALUES ('1', '1', '1');
COMMIT;

-- ----------------------------
-- Auto increment value for t_manager_info
-- ----------------------------
ALTER TABLE `t_manager_info` AUTO_INCREMENT=4;

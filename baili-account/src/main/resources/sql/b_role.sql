/*
Navicat MySQL Data Transfer

Source Server         : zhumingming
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : baili-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-07 16:05:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_role
-- ----------------------------
DROP TABLE IF EXISTS `b_role`;
CREATE TABLE `b_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `created_by` varchar(25) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updated_by` varchar(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by_id` bigint(20) DEFAULT NULL,
  `created_by_company` varchar(40) DEFAULT NULL,
  `created_by_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_role
-- ----------------------------
INSERT INTO `b_role` VALUES ('1', '管理', null, null, null, null, null, null, null, null, null, null);

/*
Navicat MySQL Data Transfer

Source Server         : zhumingming
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : baili-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-11 17:09:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_authority
-- ----------------------------
DROP TABLE IF EXISTS `b_authority`;
CREATE TABLE `b_authority` (
  `id` bigint(20) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `button` varchar(25) DEFAULT NULL,
  `button_description` varchar(55) DEFAULT NULL,
  `permissions_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*
Navicat MySQL Data Transfer

Source Server         : zhumingming
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : baili-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-07 16:16:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_department
-- ----------------------------
DROP TABLE IF EXISTS `b_department`;
CREATE TABLE `b_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num` int(25) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `simplen_name` varchar(20) DEFAULT NULL,
  `tips` varchar(30) DEFAULT NULL,
  `full_name` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `created_by` varchar(25) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updated_by` varchar(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by_id` bigint(20) DEFAULT NULL,
  `created_by_company` varchar(40) DEFAULT NULL,
  `created_by_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `b_created_by_company_id` (`created_by_company_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

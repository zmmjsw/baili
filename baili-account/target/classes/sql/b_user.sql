/*
Navicat MySQL Data Transfer

Source Server         : zhumingming
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : baili-test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-07 16:05:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `created_by` varchar(25) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updated_by` varchar(25) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `created_by_id` bigint(20) DEFAULT NULL,
  `created_by_company` varchar(30) DEFAULT NULL,
  `created_by_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_user
-- ----------------------------
INSERT INTO `b_user` VALUES ('1', 'string', 'string', 'ed152cdd3674622a741438640529e277', '', '', '', '', '', null, null, null, null, null, null, null, null, null);
INSERT INTO `b_user` VALUES ('2', '小明管理员', 'admin', '41758d82d816794a7ab538db1d1722f9', null, 'string', null, null, null, null, null, null, null, null, null, null, null, null);

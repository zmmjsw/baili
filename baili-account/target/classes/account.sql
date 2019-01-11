


-- ----------------------------
/*
Source Server         : zhumingming
*/
DROP TABLE IF EXISTS `b_permissions`;
CREATE TABLE `b_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
   `seq` varchar(25) DEFAULT NULL,
  `relation` enum('role','owner') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO `b_permissions` VALUES ('1', '账号管理', null, null, null, 'userInfo:user', null, null);


-- ----------------------------
/*
Source Server         : zhumingming
*/
DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions` (
  `permissions_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

INSERT INTO `role_permissions` VALUES ('1', '1');

-- ----------------------------
/*
Source Server         : zhumingming
*/

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
INSERT INTO `user_role` VALUES ('1', '1');





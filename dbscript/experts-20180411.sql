/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : experts

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-04-11 09:45:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_sequence
-- ----------------------------
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
  `NAME` varchar(50) NOT NULL,
  `CURRENT_VALUE` int(11) NOT NULL DEFAULT '0',
  `INCREMENT` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for udexpert
-- ----------------------------
DROP TABLE IF EXISTS `udexpert`;
CREATE TABLE `udexpert` (
  `expert_id` int(11) NOT NULL,
  `no` varchar(255) CHARACTER SET utf32 DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`expert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udexpert_major
-- ----------------------------
DROP TABLE IF EXISTS `udexpert_major`;
CREATE TABLE `udexpert_major` (
  `id` int(11) NOT NULL,
  `expert_id` int(255) DEFAULT NULL,
  `major_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udmajor
-- ----------------------------
DROP TABLE IF EXISTS `udmajor`;
CREATE TABLE `udmajor` (
  `id` int(11) NOT NULL,
  `major_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `major_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `major_desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for udprojects
-- ----------------------------
DROP TABLE IF EXISTS `udprojects`;
CREATE TABLE `udprojects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `purchase_project` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `purchase_company` varchar(255) CHARACTER SET utf8 DEFAULT 'N',
  `proxy_org` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `extract_company` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bidding_time` timestamp(6) NULL DEFAULT NULL,
  `bidding_location` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bidding_period` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `purchase_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sms_info` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udset
-- ----------------------------
DROP TABLE IF EXISTS `udset`;
CREATE TABLE `udset` (
  `id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetcompany
-- ----------------------------
DROP TABLE IF EXISTS `udsetcompany`;
CREATE TABLE `udsetcompany` (
  `project_id` int(11) DEFAULT NULL,
  `company` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetexpert
-- ----------------------------
DROP TABLE IF EXISTS `udsetexpert`;
CREATE TABLE `udsetexpert` (
  `project_id` int(11) NOT NULL,
  `expert_id` int(11) DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetmajor
-- ----------------------------
DROP TABLE IF EXISTS `udsetmajor`;
CREATE TABLE `udsetmajor` (
  `project_id` int(11) NOT NULL,
  `major_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `major_number` decimal(10,0) DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetregion
-- ----------------------------
DROP TABLE IF EXISTS `udsetregion`;
CREATE TABLE `udsetregion` (
  `project_id` int(11) NOT NULL,
  `region` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetresult
-- ----------------------------
DROP TABLE IF EXISTS `udsetresult`;
CREATE TABLE `udsetresult` (
  `project_id` int(11) NOT NULL,
  `expert_id` int(11) DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `random_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `notice_status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `confirm_status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for udsetsms
-- ----------------------------
DROP TABLE IF EXISTS `udsetsms`;
CREATE TABLE `udsetsms` (
  `project_id` int(11) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `send_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `send_status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `login_name` char(32) COLLATE utf8_bin NOT NULL,
  `password` char(32) COLLATE utf8_bin NOT NULL,
  `name` char(32) COLLATE utf8_bin NOT NULL,
  `state` char(2) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `created_dt` timestamp NULL DEFAULT NULL,
  `updated_dt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100113 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
BEGIN  
DECLARE VALUE INTEGER;  
SET VALUE=0;  
SELECT current_value INTO VALUE  
FROM sys_sequence   
WHERE NAME=seq_name;  
RETURN VALUE;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `nextval`(seq_name varchar(50)) RETURNS int(11)
BEGIN  
UPDATE sys_sequence  
SET CURRENT_VALUE = CURRENT_VALUE + INCREMENT  
where name=seq_name;  
return currval(seq_name);  
END
;;
DELIMITER ;

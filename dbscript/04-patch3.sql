/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : experts

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-04-03 22:51:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for udexpert
-- ----------------------------
DROP TABLE IF EXISTS `udexpert`;
CREATE TABLE `udexpert` (
  `expert_id` int(11) NOT NULL,
  `no` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`expert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of udexpert
-- ----------------------------
INSERT INTO `udexpert` VALUES ('1', '1', '1', '张三1', '111', '电厂1', '开发区', '01');
INSERT INTO `udexpert` VALUES ('2', '2', '2', '李四2', '222', '电视剧2', '金石滩', '01');

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
-- Records of udexpert_major
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of udmajor
-- ----------------------------
INSERT INTO `udmajor` VALUES ('1', '0101', 'java', null, null, '01');
INSERT INTO `udmajor` VALUES ('2', '0102', 'c', null, null, '01');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of udprojects
-- ----------------------------

-- ----------------------------
-- Table structure for udset
-- ----------------------------
DROP TABLE IF EXISTS `udset`;
CREATE TABLE `udset` (
  `id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `create_time` DATETIME NOT NULL,
  `update_time` TIMESTAMP,
  `record_flag` varchar(2) CHARACTER SET utf8 DEFAULT '01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of udset
-- ----------------------------
INSERT INTO `udset` VALUES ('3', '123', '2018-04-01 13:35:40', '2018-04-01 13:35:40', '01');
INSERT INTO `udset` VALUES ('4', '123', '2018-04-01 14:07:33', '2018-04-01 14:07:33', '01');

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
-- Records of udsetcompany
-- ----------------------------
INSERT INTO `udsetcompany` VALUES ('123', null, null);

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
-- Records of udsetexpert
-- ----------------------------

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
-- Records of udsetmajor
-- ----------------------------

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
-- Records of udsetregion
-- ----------------------------

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
-- Records of udsetresult
-- ----------------------------

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
-- Records of udsetsms
-- ----------------------------

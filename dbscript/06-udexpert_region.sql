/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : experts

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2018-04-09 20:43:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for udexpert_region
-- ----------------------------
DROP TABLE IF EXISTS `udexpert_region`;
CREATE TABLE `udexpert_region` (
  `expert_id` int(255) DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

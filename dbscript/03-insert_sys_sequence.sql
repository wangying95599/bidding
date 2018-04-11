/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : experts

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-04-11 10:31:49
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
-- Records of sys_sequence
-- ----------------------------
INSERT INTO `sys_sequence` VALUES ('expert_id_seq', '0', '1');
INSERT INTO `sys_sequence` VALUES ('expert_major_id_seq', '0', '1');
INSERT INTO `sys_sequence` VALUES ('expert_region_id_seq', '0', '1');
INSERT INTO `sys_sequence` VALUES ('projects_id_seq', '0', '1');
INSERT INTO `sys_sequence` VALUES ('set_id_seq', '0', '1');

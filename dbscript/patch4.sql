-- ----------------------------
-- Table structure for udvoicelog
-- ----------------------------
DROP TABLE IF EXISTS `udvoicelog`;
CREATE TABLE `udvoicelog` (
  `callId` varchar(255) NOT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `status_code` varchar(255) DEFAULT NULL,
  `status_msg` varchar(255) DEFAULT NULL,
  `out_id` varchar(255) DEFAULT NULL,
  `dtmf` varchar(255) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `expert_id` int(11) DEFAULT NULL,
  `random_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

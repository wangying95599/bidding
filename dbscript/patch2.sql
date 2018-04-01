ALTER TABLE `udsetcompany`
MODIFY COLUMN `project_id`  int(11) NULL DEFAULT NULL FIRST ;


-- ----------------------------
-- Table structure for udexpert
-- ----------------------------
DROP TABLE IF EXISTS `udexpert`;
CREATE TABLE `udexpert` (
  `id` int(11) NOT NULL,
  `no` varchar(255) DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for udexpert_major
-- ----------------------------
DROP TABLE IF EXISTS `udexpert_major`;
CREATE TABLE `udexpert_major` (
  `id` int(11) NOT NULL,
  `expert_id` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major_code` varchar(255) DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for udmajor
-- ----------------------------
DROP TABLE IF EXISTS `udmajor`;
CREATE TABLE `udmajor` (
  `id` int(11) NOT NULL,
  `major_code` varchar(255) DEFAULT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  `major_desc` varchar(255) DEFAULT NULL,
  `created_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

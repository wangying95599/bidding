/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : experts

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-04-10 17:36:11
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
INSERT INTO `sys_sequence` VALUES ('projects_id_seq', '7', '1');
INSERT INTO `sys_sequence` VALUES ('set_id_seq', '19', '1');

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
-- Records of udexpert
-- ----------------------------
INSERT INTO `udexpert` VALUES ('0', '123', '456', '', '', '', null, null);
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of udmajor
-- ----------------------------
INSERT INTO `udmajor` VALUES ('4', '01', '商务专家', '指从事采购业务工作的人员，胜任审查商务招标文件工作的相关专家（指表参加标审会议的商务代表）。', '2018-04-04 20:47:16', '01');
INSERT INTO `udmajor` VALUES ('5', '0101', '商务综合', '指从事采购业务工作的人员，胜任审查商务招标文件工作的相关专家（指表参加标审会议的商务代表）。', '2018-04-04 20:47:05', '01');
INSERT INTO `udmajor` VALUES ('6', '0102', '财务审计', '指从事会计、审计相关工作，胜任审查财务报表及经营状况分析等工作的人员。', '2018-04-04 20:47:12', '01');
INSERT INTO `udmajor` VALUES ('7', '0103', '技术经济', '指从事火电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('8', '010301', '火电技术经济', '指从事火电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('9', '01030101', '火电安装技术经济', '指从事火电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('10', '01030102', '火电土建技术经济', '指从事火电土建经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('11', '010302', '水电技术经济', '指从事水电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('12', '01030201', '水电安装技术经济', '指从事水电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('13', '01030202', '水电土建技术经济', '指从事水电土建经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('14', '010303', '风电技术经济', '指从事风电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('15', '01030301', '风电安装技术经济', '指从事风电安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('16', '01030302', '风电土建技术经济', '指从事风电土建经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('17', '010304', '光伏电力技术经济', '指从事光伏安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('18', '01030401', '光伏安装技术经济', '指从事光伏安装经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('19', '01030402', '光伏土建技术经济', '指从事光伏土建经济分析，对项目概预算管理等熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('20', '010305', '输变电技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('21', '01030501', '输电线路技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('22', '0103050101', '直流特高压输电线路技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('23', '0103050102', '常规输电线路技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('24', '01030502', '变电电气技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('25', '0103050201', '直流特高压变电电气技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('26', '0103050202', '常规变电电气技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('27', '01030503', '变电土建技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('28', '0103050301', '直流特高压变电土建技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('29', '0103050302', '常规变电土建技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('30', '01030504', '换流站技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('31', '0103050401', '直流特高压换流站技术经济', '', null, '01');
INSERT INTO `udmajor` VALUES ('32', '01030505', '概预算', '', null, '01');
INSERT INTO `udmajor` VALUES ('33', '0103050501', '直流特高压概预算', '', null, '01');
INSERT INTO `udmajor` VALUES ('34', '0103050502', '常规概预算', '', null, '01');
INSERT INTO `udmajor` VALUES ('35', '02', '技术专家', '6-35kV箱式变电站、10kV站用变成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('36', '0201', '电网物资类', '6-35kV箱式变电站、10kV站用变成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('37', '020101', '一次设备', '6-35kV箱式变电站、10kV站用变成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('38', '02010101', '交流变压器', '6-35kV箱式变电站、10kV站用变成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('39', '0201010101', '箱式变电站', '6-35kV箱式变电站、10kV站用变成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('40', '0201010102', '35kV及以下交流变压器', '6-35kV变压器。', null, '01');
INSERT INTO `udmajor` VALUES ('41', '0201010103', '66kV-220kV交流变压器', '66-220kV变压器。', null, '01');
INSERT INTO `udmajor` VALUES ('42', '0201010104', '330kV-750kV交流变压器', '330-750kV变压器。', null, '01');
INSERT INTO `udmajor` VALUES ('43', '0201010105', '特高压交流变压器', '1000kV变压器。', null, '01');
INSERT INTO `udmajor` VALUES ('44', '02010102', '换流变压器', '220-500kV单级及多式换流变。', null, '01');
INSERT INTO `udmajor` VALUES ('45', '02010103', '交流电抗器', '并联电抗器、串联电抗器、滤波器组电抗器、交流PLC电抗器、中性点电抗器、阀电抗器等。', null, '01');
INSERT INTO `udmajor` VALUES ('46', '02010104', '直流电抗器', '平波电抗器、直流PLC电抗器、滤波器组电抗器、其他直流电抗器等。', null, '01');
INSERT INTO `udmajor` VALUES ('47', '02010105', '交流电流互感器', '35kV及以下电磁式电流互感器/组合互感器（电子式电流互感器单独设立专业）。', null, '01');
INSERT INTO `udmajor` VALUES ('48', '0201010501', '35kV及以下交流电流互感器（组合互感器）', '35kV及以下电磁式电流互感器/组合互感器（电子式电流互感器单独设立专业）。', null, '01');
INSERT INTO `udmajor` VALUES ('49', '0201010502', '66kV及以上交流电流互感器', '66kV及以上电磁式电流互感器/组合互感器（电子式电流互感器单独设立专业）。', null, '01');
INSERT INTO `udmajor` VALUES ('50', '02010106', '交流电压互感器', '35kV及以下电磁式、电容式电压互感器/组合互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('51', '0201010601', '35kV及以下交流电压互感器（组合互感器）', '35kV及以下电磁式、电容式电压互感器/组合互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('52', '0201010602', '66kV及以上交流电压互感器', '66kV及以上电磁式、电容式电流互感器/组合互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('53', '02010107', '电子式互感器', '各电压等级的电子式电压互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('54', '0201010701', '电子式电压互感器', '各电压等级的电子式电压互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('55', '0201010702', '电子式电流互感器', '各电压等级的电子式电流互感器。', null, '01');
INSERT INTO `udmajor` VALUES ('56', '0201010703', '/', '零磁通式、光学式直流电流互感器、直流电压分压器。', null, '01');
INSERT INTO `udmajor` VALUES ('57', '02010108', '组合电器', '35kV及以下气体绝缘封闭式、复合式、敞开式组合电器。', null, '01');
INSERT INTO `udmajor` VALUES ('58', '0201010801', '35kV及以下组合电器', '35kV及以下气体绝缘封闭式、复合式、敞开式组合电器。', null, '01');
INSERT INTO `udmajor` VALUES ('59', '0201010802', '66kV及以上组合电器', '66kV及以上气体绝缘封闭式、复合式、敞开式组合电器。', null, '01');
INSERT INTO `udmajor` VALUES ('60', '02010109', '交流断路器', '35kV及以下瓷柱式、罐式交流断路器、柱上断路器、高压交流自动重合器。', null, '01');
INSERT INTO `udmajor` VALUES ('61', '0201010901', '35kV及以下交流断路器', '35kV及以下瓷柱式、罐式交流断路器、柱上断路器、高压交流自动重合器。', null, '01');
INSERT INTO `udmajor` VALUES ('62', '0201010902', '66kV及以上交流断路器', '66kV及以上瓷柱式、罐式交流断路器。', null, '01');
INSERT INTO `udmajor` VALUES ('63', '02010110', '直流断路器', '4-800kV直流断路器。', null, '01');
INSERT INTO `udmajor` VALUES ('64', '02010111', '交流隔离开关', '35kV及以下交流单相、三相隔离开关，中性点隔离开关、交流接地开关。', null, '01');
INSERT INTO `udmajor` VALUES ('65', '0201011101', '35kV及以下交流隔离开关', '35kV及以下交流单相、三相隔离开关，中性点隔离开关、交流接地开关。', null, '01');
INSERT INTO `udmajor` VALUES ('66', '0201011102', '66kV及以上交流隔离开关', '66kV及以上交流单相、三相隔离开关，中性点隔离开关、交流接地开关。', null, '01');
INSERT INTO `udmajor` VALUES ('67', '02010112', '直流隔离开关', '4-800kV直流隔离开关、接地开关。', null, '01');
INSERT INTO `udmajor` VALUES ('68', '02010113', '高压开关柜（箱）', '各电压等级的高压开关柜、环网柜、高压计量柜、箱式开闭所、充气式高压开关柜等。', null, '01');
INSERT INTO `udmajor` VALUES ('69', '02010114', '低压配电箱（柜、屏）', '低压开关柜、配电箱、低压电源应急自动投切装置柜、端子箱、JP柜等。', null, '01');
INSERT INTO `udmajor` VALUES ('70', '02010115', '负荷开关', '各电压等级负荷开关。', null, '01');
INSERT INTO `udmajor` VALUES ('71', '02010116', '熔断器', '各电压等级熔断器。', null, '01');
INSERT INTO `udmajor` VALUES ('72', '02010117', '电力电容器', '框架式/集合式电容器组（不含电抗器）、框架式/集合式并联电容器成套装置、滤波器组电容器、单台电容器、柱上无功补偿成套装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('73', '0201011701', '交流电容器', '框架式/集合式电容器组（不含电抗器）、框架式/集合式并联电容器成套装置、滤波器组电容器、单台电容器、柱上无功补偿成套装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('74', '0201011702', '直流电容器', '滤波器组电容器、单台电容器。', null, '01');
INSERT INTO `udmajor` VALUES ('75', '02010118', '串联补偿装置', '各电压等级的串联补偿装置。', null, '01');
INSERT INTO `udmajor` VALUES ('76', '02010119', '静态补偿装置', '各电压等级的静态补偿装置。', null, '01');
INSERT INTO `udmajor` VALUES ('77', '02010120', '避雷器', '各电压等级的交流避雷器。', null, '01');
INSERT INTO `udmajor` VALUES ('78', '0201012001', '交流避雷器', '各电压等级的交流避雷器。', null, '01');
INSERT INTO `udmajor` VALUES ('79', '0201012002', '直流避雷器', '各电压等级的直流避雷器。', null, '01');
INSERT INTO `udmajor` VALUES ('80', '02010121', '消弧线圈、接地变及成套装置', '各电压等级的消弧线圈接地变成套装置、接地变压器、消弧线圈。', null, '01');
INSERT INTO `udmajor` VALUES ('81', '02010122', '小电阻接地成套装置', '各电压等级的小电阻接地成套装置。', null, '01');
INSERT INTO `udmajor` VALUES ('82', '02010123', '调压器', '各电压等级的调压器。', null, '01');
INSERT INTO `udmajor` VALUES ('83', '02010124', '换流阀', '各电压等级的换流阀。', null, '01');
INSERT INTO `udmajor` VALUES ('84', '02010125', '滤波器电阻器', '各电压等级的滤波器电阻器。', null, '01');
INSERT INTO `udmajor` VALUES ('85', '02010126', '母线', '各电压等级的封闭绝缘母线、管状母线、槽形母线、矩形母线。', null, '01');
INSERT INTO `udmajor` VALUES ('86', '02010127', '支柱绝缘子', '各电压等级的交流支柱绝缘子。', null, '01');
INSERT INTO `udmajor` VALUES ('87', '0201012701', '交流支柱绝缘子', '各电压等级的交流支柱绝缘子。', null, '01');
INSERT INTO `udmajor` VALUES ('88', '0201012702', '直流支柱绝缘子', '各电压等级的直流支柱绝缘子。', null, '01');
INSERT INTO `udmajor` VALUES ('89', '02010128', '穿墙套管', '各电压等级的交流穿墙套管。', null, '01');
INSERT INTO `udmajor` VALUES ('90', '0201012801', '交流穿墙套管', '各电压等级的交流穿墙套管。', null, '01');
INSERT INTO `udmajor` VALUES ('91', '0201012802', '直流穿墙套管', '各电压等级的直流穿墙套管。', null, '01');
INSERT INTO `udmajor` VALUES ('92', '02010130', '投切电容器电抗器开关', '对投切电容器电抗器设备较为熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('93', '02010131', '换流站一次设备', '对换流站线圈类设备较为熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('94', '0201013101', '换流站线圈类设备', '对换流站线圈类设备较为熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('95', '0201013102', '换流站开关类设备', '对换流站开关类设备较为熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('96', '0201013103', '换流站换流设备', '对换流站交直流切换设备较为熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('97', '0201013104', '换流站四小类设备', '含电容器、电阻器、互感器和避雷器', null, '01');
INSERT INTO `udmajor` VALUES ('98', '02010132', '直流输电高电压与绝缘技术', '对特高压直流输电绝缘技术熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('99', '02010133', '特高压专有变压器、电抗器', '', null, '01');
INSERT INTO `udmajor` VALUES ('100', '02010134', '特高压专有开关', '', null, '01');
INSERT INTO `udmajor` VALUES ('101', '02010135', '特高压专有避雷器', '', null, '01');
INSERT INTO `udmajor` VALUES ('102', '02010136', '特高压专有电容器', '', null, '01');
INSERT INTO `udmajor` VALUES ('103', '02010137', '特高压专有CVT、互感器', '', null, '01');
INSERT INTO `udmajor` VALUES ('104', '02010138', '特高压专有支柱绝缘子', '', null, '01');
INSERT INTO `udmajor` VALUES ('105', '020102', '二次设备', '各电压等级的线路保护、母线保护、变压器保护、断路器保护、电容器保护、电抗器保护、最后断路器跳闸装置、短引线保护、旁路保护、过电压及远方跳闸就地判别、母联（分段）保护、接地变保护、PT并列装置、同期装置、备用设备及备用电源自动投入、无功自动投切装置、静止无功补偿控制保护装置、串联补偿控制保护装置、故障录波装置、故障测距装置、保护信息管理主站/子站、小电流接地选线装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('106', '02010201', '继电保护', '各电压等级的线路保护、母线保护、变压器保护、断路器保护、电容器保护、电抗器保护、最后断路器跳闸装置、短引线保护、旁路保护、过电压及远方跳闸就地判别、母联（分段）保护、接地变保护、PT并列装置、同期装置、备用设备及备用电源自动投入、无功自动投切装置、静止无功补偿控制保护装置、串联补偿控制保护装置、故障录波装置、故障测距装置、保护信息管理主站/子站、小电流接地选线装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('107', '0201020101', '继电保护及自动装置', '各电压等级的线路保护、母线保护、变压器保护、断路器保护、电容器保护、电抗器保护、最后断路器跳闸装置、短引线保护、旁路保护、过电压及远方跳闸就地判别、母联（分段）保护、接地变保护、PT并列装置、同期装置、备用设备及备用电源自动投入、无功自动投切装置、静止无功补偿控制保护装置、串联补偿控制保护装置、故障录波装置、故障测距装置、保护信息管理主站/子站、小电流接地选线装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('108', '0201020102', '换流站直流控制保护系统', '各电压等级的换流站监控系统、直流控制保护、交流控制保护、阀控装置、换流变压器保护、滤波器保护、接地极线路阻抗监视装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('109', '02010202', '电气自动化', '各电压等级的防误闭锁系统、线路在线监测装置、变电在线监测装置、谐波检测装置、测控装置、电压在线监测装置、电能质量在线监测装置、在线监测系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('110', '0201020201', '测控及在线监测系统', '各电压等级的防误闭锁系统、线路在线监测装置、变电在线监测装置、谐波检测装置、测控装置、电压在线监测装置、电能质量在线监测装置、在线监测系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('111', '0201020202', '安全稳定自动控制装置', '各电压等级的减载装置、解列装置、稳定控制装置、消谐装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('112', '0201020203', '自动化系统及设备', '各电压等级的变电站监控系统、远动终端设备（RTU）、时间同步装置、集控站监控系统、二次系统安全防护设备、电能量计量采集系统、电能量计量系统、相量测量系统、能量管理系统、调度管理系统、调度备用系统、变电站综合自动化系统、相量测量装置、专用防火墙、纵向加密认证装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('113', '0201020204', '配电自动化', '配电SCADA主站、配电自动化子站、配电GIS系统、数据采集终端、配电主站系统、配电信息交互总线、配电终端、配电子站等。', null, '01');
INSERT INTO `udmajor` VALUES ('114', '0201020205', '用电信息采集', '用电信息采集系统主站、公变采集终端、专变采集终端、厂站终端、集中器、采集器、抄表机等。', null, '01');
INSERT INTO `udmajor` VALUES ('115', '0201020206', '屏幕系统', '对调度或监控中心使用大屏幕系统与设备熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('116', '02010203', '电源系统', '直流电源系统所使用的屏（柜）、蓄电池组、蓄电池充电机、直流绝缘监测装置、UPS电源、逆变电源、一体化电源系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('117', '0201020301', '直流电源系统', '直流电源系统所使用的屏（柜）、蓄电池组、蓄电池充电机、直流绝缘监测装置、UPS电源、逆变电源、一体化电源系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('118', '0201020302', '交流电源系统', '交流电源系统所使用的屏（柜）、蓄电池组、蓄电池充电机、直流绝缘监测装置、UPS电源、逆变电源、一体化电源系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('119', '02010204', '数据网络设备', '交换机、数据网网络管理系统、路由器等。', null, '01');
INSERT INTO `udmajor` VALUES ('120', '02010205', '特高压交流输电控制与保护', '对特高压交流输电控制与保护系统熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('121', '02010206', '换流站二次设备', '对换流站二次设备熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('122', '020103', '通信设备', '同步时钟设备。', null, '01');
INSERT INTO `udmajor` VALUES ('123', '02010305', '同步时钟设备', '同步时钟设备。', null, '01');
INSERT INTO `udmajor` VALUES ('124', '02010306', '图像监控及视频监视系统', '图像监控系统及视频监视系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('125', '02010307', '数据通信网设备', 'ATM设备、帧中继(FR)、通信网关等。', null, '01');
INSERT INTO `udmajor` VALUES ('126', '02010308', '无线设备', '无线通信设备、无线接入设备、数字无线多地址通信系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('127', '02010309', '电力线载波设备', '电力线载波机、阻波器、耦合电容器、结合滤波器、电感耦合器等。', null, '01');
INSERT INTO `udmajor` VALUES ('128', '02010310', '光纤通信设备', '光传输设备、光路子系统、光缆终端设备、光网络单元设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('129', '02010311', '接入设备', 'PCM设备、协议转换设备、切换装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('130', '02010312', '卫星通信系统', '卫星收发信机、卫星通信终端设备、卫星接收天线等。', null, '01');
INSERT INTO `udmajor` VALUES ('131', '02010313', '通信网络管理系统', '光通信传输网管、微波系统网管、交换系统网管、同步设备网管、数据设备网管等。', null, '01');
INSERT INTO `udmajor` VALUES ('132', '02010314', '交换系统', '数字程控交换系统、软交换机、计费系统、95598呼叫平台系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('133', '02010315', '电话及电视会议系统', '电视会议MCU、电视会议终端设、电话会议汇接机、电话会议终端设备、流媒体设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('134', '02010316', '通信电源系统', '直流-48V通信电源成套设备。', null, '01');
INSERT INTO `udmajor` VALUES ('135', '020104', '仪器仪表', '标准电流表、标准电压表、标准功率表等。', null, '01');
INSERT INTO `udmajor` VALUES ('136', '02010401', '电气标准器及检测装置', '标准电流表、标准电压表、标准功率表等。', null, '01');
INSERT INTO `udmajor` VALUES ('137', '02010402', '电气仪器仪表', '直流电阻箱、电桥、检流计等。', null, '01');
INSERT INTO `udmajor` VALUES ('138', '02010403', '高压试验仪器', '变压器变比测试仪、回路电阻测试仪、直流高压发生器等。', null, '01');
INSERT INTO `udmajor` VALUES ('139', '02010404', '通信仪器仪表', '2M测试仪、光谱分析仪、光万用表等。', null, '01');
INSERT INTO `udmajor` VALUES ('140', '02010405', '化学仪器仪表', '天平、颗粒度仪、电导率测试仪等。', null, '01');
INSERT INTO `udmajor` VALUES ('141', '02010406', '金属仪器仪表', '探伤仪、内窥镜、金属密度仪等。', null, '01');
INSERT INTO `udmajor` VALUES ('142', '02010407', '勘查仪器仪表', '经纬仪、全站仪、GPS定位仪等。', null, '01');
INSERT INTO `udmajor` VALUES ('143', '02010408', '热工仪器仪表', '气体流量计、温度校验仪等。', null, '01');
INSERT INTO `udmajor` VALUES ('144', '02010409', '计量仪器仪表', '电能表校验台、现场检测仪器等。', null, '01');
INSERT INTO `udmajor` VALUES ('145', '02010410', '检测仪器仪表', '', null, '01');
INSERT INTO `udmajor` VALUES ('146', '020105', '电能表', '单相电能表、三相电能表、智能电能表等。', null, '01');
INSERT INTO `udmajor` VALUES ('147', '020106', '装置性材料', '锥形水泥杆、等径水泥杆等。', null, '01');
INSERT INTO `udmajor` VALUES ('148', '02010601', '杆塔类', '锥形水泥杆、等径水泥杆等。', null, '01');
INSERT INTO `udmajor` VALUES ('149', '0201060101', '水泥杆', '锥形水泥杆、等径水泥杆等。', null, '01');
INSERT INTO `udmajor` VALUES ('150', '0201060102', '铁塔', '角钢塔、钢管塔（杆）、变电站构支架等。', null, '01');
INSERT INTO `udmajor` VALUES ('151', '0201060103', '铁附件', '铁横担、成套抱箍、变压器台架、固定支架等。', null, '01');
INSERT INTO `udmajor` VALUES ('152', '02010602', '线路绝缘子', '特高压复合绝缘子、盘形悬式绝缘子、棒形悬式绝缘子、瓷绝缘子、复合绝缘子、玻璃绝缘子等。', null, '01');
INSERT INTO `udmajor` VALUES ('153', '0201060201', '特高压直流线路绝缘子', '特高压复合绝缘子、盘形悬式绝缘子、棒形悬式绝缘子、瓷绝缘子、复合绝缘子、玻璃绝缘子等。', null, '01');
INSERT INTO `udmajor` VALUES ('154', '0201060202', '常规输电线路绝缘子', '常规复合绝缘子、盘形悬式绝缘子、棒形悬式绝缘子、瓷绝缘子、复合绝缘子、玻璃绝缘子等。', null, '01');
INSERT INTO `udmajor` VALUES ('155', '02010603', '导、地线', '特高压钢芯铝绞线、铝包钢绞线、铝包钢芯铝绞线、钢绞线、架空绝缘导线、铝绞线、集束绝缘导线、布电线等。', null, '01');
INSERT INTO `udmajor` VALUES ('156', '0201060301', '特高压直流线路导地线', '特高压钢芯铝绞线、铝包钢绞线、铝包钢芯铝绞线、钢绞线、架空绝缘导线、铝绞线、集束绝缘导线、布电线等。', null, '01');
INSERT INTO `udmajor` VALUES ('157', '0201060302', '常规输电线路导、地线', '常规钢芯铝绞线、铝包钢绞线、铝包钢芯铝绞线、钢绞线、架空绝缘导线、铝绞线、集束绝缘导线、布电线等。', null, '01');
INSERT INTO `udmajor` VALUES ('158', '02010604', '光缆', '特高压ADSS光缆（全介质自承式）、OPPC光缆（光纤复合相线）、普通光缆、OPGW光缆等。', null, '01');
INSERT INTO `udmajor` VALUES ('159', '0201060401', '特高压直流线路光缆', '特高压ADSS光缆（全介质自承式）、OPPC光缆（光纤复合相线）、普通光缆、OPGW光缆等。', null, '01');
INSERT INTO `udmajor` VALUES ('160', '0201060402', '常规输电线路光缆', '常规ADSS光缆（全介质自承式）、OPPC光缆（光纤复合相线）、普通光缆、OPGW光缆等。', null, '01');
INSERT INTO `udmajor` VALUES ('161', '02010605', '电缆及附件', '低压电力电缆、10-35kV电力电缆及电缆终端、接地箱等附件。', null, '01');
INSERT INTO `udmajor` VALUES ('162', '0201060501', '35kV及以下电缆及附件', '低压电力电缆、10-35kV电力电缆及电缆终端、接地箱等附件。', null, '01');
INSERT INTO `udmajor` VALUES ('163', '0201060502', '66kV及以上电缆及附件', '66kV及以上电力电缆及电缆终端、接地箱等附件。', null, '01');
INSERT INTO `udmajor` VALUES ('164', '0201060503', '控制及通信电缆', '控制电缆、通信电缆、同轴电缆、计算机电缆、网络线、信号电缆等。', null, '01');
INSERT INTO `udmajor` VALUES ('165', '0201060504', '光纤复合低压电力电缆', '', null, '01');
INSERT INTO `udmajor` VALUES ('166', '02010606', '导地线金具', '特高压导地线金具、附件。', null, '01');
INSERT INTO `udmajor` VALUES ('167', '0201060601', '特高压直流线路导地线金具', '特高压导地线金具、附件。', null, '01');
INSERT INTO `udmajor` VALUES ('168', '0201060602', '常规输电线路导、地线金具', '常规导地线金具、附件。', null, '01');
INSERT INTO `udmajor` VALUES ('169', '02010607', '光缆金具', '光缆金具、附件等。', null, '01');
INSERT INTO `udmajor` VALUES ('170', '02010608', '特高压杆塔', '特高压线路使用的杆塔等。', null, '01');
INSERT INTO `udmajor` VALUES ('171', '02010609', '特高压材料', '特高压线路使用的绝缘子、导地线等。', null, '01');
INSERT INTO `udmajor` VALUES ('172', '02010610', '换流站材料类', '换流站内构架、出线等材料等。', null, '01');
INSERT INTO `udmajor` VALUES ('173', '020107', '充电设备', '包括交流充电机、交流充电桩等设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('174', '02010701', '动力电池', '包括交流充电机、交流充电桩等设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('175', '02010702', '储能装置', '充电站储能设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('176', '02010703', '充电站设备', '', null, '01');
INSERT INTO `udmajor` VALUES ('177', '0201070301', '运营监控系统', '', null, '01');
INSERT INTO `udmajor` VALUES ('178', '0201070302', '电动汽车充换电设备', '', null, '01');
INSERT INTO `udmajor` VALUES ('179', '020108', '电力交费设备', '电力交费自助终端、电力交费POS终端等', null, '01');
INSERT INTO `udmajor` VALUES ('180', '020109', '电力交易设备', '熟悉电力交易业务，熟悉展示大屏幕、图形工作站、多媒体设备及相关线缆布置、客服坐席办公设备、土建及室内装潢、防雷接地、空调、UPS电源。', null, '01');
INSERT INTO `udmajor` VALUES ('181', '02010901', '交易大厅运营配套设备', '熟悉电力交易业务，熟悉展示大屏幕、图形工作站、多媒体设备及相关线缆布置、客服坐席办公设备、土建及室内装潢、防雷接地、空调、UPS电源。', null, '01');
INSERT INTO `udmajor` VALUES ('182', '02010902', '电力交易自动化', '熟悉应用/数据服务器、安全防护、内外网隔离、存储、交换机/路由器。', null, '01');
INSERT INTO `udmajor` VALUES ('183', '0201090201', '系统硬件', '熟悉应用/数据服务器、安全防护、内外网隔离、存储、交换机/路由器。', null, '01');
INSERT INTO `udmajor` VALUES ('184', '0201090202', '系统软件', '熟悉电力交易业务，熟悉信息化建设相关知识。', null, '01');
INSERT INTO `udmajor` VALUES ('185', '020110', '直流换流站设备材料', '', null, '01');
INSERT INTO `udmajor` VALUES ('186', '0202', '火电物资类', '包括汽轮机本体、盘车专职、螺栓、燃气轮机、加热器、除氧器和凝汽器等设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('187', '020201', '汽机', '包括汽轮机本体、盘车专职、螺栓、燃气轮机、加热器、除氧器和凝汽器等设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('188', '020202', '锅炉', '包括锅炉本体、预热器、安全门、主给水调节门、磨煤机、给煤机、排粉机、点火装置和燃烧器等。', null, '01');
INSERT INTO `udmajor` VALUES ('189', '020203', '热工自动化', 'DCS、化学控制系统、燃料控制系统、脱硫控制系统、汽机监视系统、通风空调系统、火灾报警及控制系统、火电自动化装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('190', '020204', '输煤', '包括翻车机、斗轮机、卸车机、推煤机、轨道衡、汽车衡、皮带秤、采集装置、筛煤机、碎煤机、皮带机和除尘器等。', null, '01');
INSERT INTO `udmajor` VALUES ('191', '020205', '环保化学', '包括脱硫脱硝设备、活性炭过滤器、阳离子交换器、阴离子交换器、凝结谁精处理装置、电解槽、脱水机、制水设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('192', '020206', '水工', '包括泵及阀门等水处理相关设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('193', '020207', '发电机设备', '包括定子、转子及发电机主要辅助设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('194', '0203', '风电物资类', '风力发电机组及配件等。', null, '01');
INSERT INTO `udmajor` VALUES ('195', '020301', '风力发电机组', '风力发电机组及配件等。', null, '01');
INSERT INTO `udmajor` VALUES ('196', '020302', '风电塔架及基础设施', '包括风电塔架及基础环等。', null, '01');
INSERT INTO `udmajor` VALUES ('197', '0204', '水电物资类', '水轮机及配件等。', null, '01');
INSERT INTO `udmajor` VALUES ('198', '020401', '水轮机', '水轮机及配件等。', null, '01');
INSERT INTO `udmajor` VALUES ('199', '020402', '主阀设备', '包括主阀、主阀操作装置等。', null, '01');
INSERT INTO `udmajor` VALUES ('200', '020403', '发电电动机', '包括发电机、发电电动机、永磁机、励磁机等水电发电相关的机电设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('201', '020404', '水电监测系统', '包括水电发电机组状态监测系统、计算机监控设备等。', null, '01');
INSERT INTO `udmajor` VALUES ('202', '020405', '电站观测系统', '包括水电站数据采集及中央处理系统等。', null, '01');
INSERT INTO `udmajor` VALUES ('203', '020406', '调速器', '水电站用调整器等。', null, '01');
INSERT INTO `udmajor` VALUES ('204', '0205', '光伏物资类', '光伏电池组件等。', null, '01');
INSERT INTO `udmajor` VALUES ('205', '020501', '光伏电池组件', '光伏电池组件等。', null, '01');
INSERT INTO `udmajor` VALUES ('206', '020502', '逆变器', '包括汇流箱、交、直流柜、逆变器及跟踪支架等。', null, '01');
INSERT INTO `udmajor` VALUES ('207', '0206', '信息设备类', '', null, '01');
INSERT INTO `udmajor` VALUES ('208', '020603', '云终端', '', null, '01');
INSERT INTO `udmajor` VALUES ('209', '020605', '信息化软件', '', null, '01');
INSERT INTO `udmajor` VALUES ('210', '020606', '信息化硬件', '', null, '01');
INSERT INTO `udmajor` VALUES ('211', '0207', '辅助设备设施类', '客梯、货梯、客货梯。', null, '01');
INSERT INTO `udmajor` VALUES ('212', '020701', '辅助设备', '客梯、货梯、客货梯。', null, '01');
INSERT INTO `udmajor` VALUES ('213', '02070101', '电梯', '客梯、货梯、客货梯。', null, '01');
INSERT INTO `udmajor` VALUES ('214', '02070102', '小型发电机', '汽油及柴油发电机组。', null, '01');
INSERT INTO `udmajor` VALUES ('215', '02070103', '起重设备', '卷扬机、梁式/门式/桥式/塔式/履带式起重机、堆垛机、机器臂等。', null, '01');
INSERT INTO `udmajor` VALUES ('216', '02070104', '厨柜及厨具', '厨柜及厨具等设备。', null, '01');
INSERT INTO `udmajor` VALUES ('217', '02070105', '普通空调', '办公使用的壁挂式、柜式空调。', null, '01');
INSERT INTO `udmajor` VALUES ('218', '02070106', '供暖系统', '电能供暖、燃气供暖、燃煤供暖、太阳能供暖等。', null, '01');
INSERT INTO `udmajor` VALUES ('219', '02070107', '消防系统', '变电站内消防系统建设及消防设备、设施。', null, '01');
INSERT INTO `udmajor` VALUES ('220', '02070108', '火灾报警系统', '变电站及建筑物火灾报警系统建设及设备、设施。', null, '01');
INSERT INTO `udmajor` VALUES ('221', '02070109', '防雷设备', '避雷针、低压防雷器、线路防雷装置、线路过电压保护器等。', null, '01');
INSERT INTO `udmajor` VALUES ('222', '02070110', '启闭机（液压、卷扬）', '对于液压或卷扬式启闭机闸门等设备。', null, '01');
INSERT INTO `udmajor` VALUES ('223', '02070111', '直升机作业设备', '吊舱、航空电台、防撞预警系统', null, '01');
INSERT INTO `udmajor` VALUES ('224', '02070112', '变压器及电抗器生产设备', '变压器及电抗器生产用设备及工装。', null, '01');
INSERT INTO `udmajor` VALUES ('225', '02070113', '无人机作业设备', '', null, '01');
INSERT INTO `udmajor` VALUES ('226', '02070114', '智能巡检机器人', '', null, '01');
INSERT INTO `udmajor` VALUES ('227', '02070115', '精密空调', '', null, '01');
INSERT INTO `udmajor` VALUES ('228', '02070116', '中央空调', '', null, '01');
INSERT INTO `udmajor` VALUES ('229', '020702', '车辆', '普通客车、越野客车、轿车、载货汽车等。', null, '01');
INSERT INTO `udmajor` VALUES ('230', '02070201', '通用车辆', '普通客车、越野客车、轿车、载货汽车等。', null, '01');
INSERT INTO `udmajor` VALUES ('231', '02070202', '特种车辆', '高空作业车、带电作业车、应急通信车、电力计量车、牵引车、机动起重专用车等。', null, '01');
INSERT INTO `udmajor` VALUES ('232', '020703', '换流站辅助设施', '阀外冷系统', null, '01');
INSERT INTO `udmajor` VALUES ('233', '02070301', '阀外冷系统', '阀外冷系统', null, '01');
INSERT INTO `udmajor` VALUES ('234', '02070302', '水系统', '水系统', null, '01');
INSERT INTO `udmajor` VALUES ('235', '02070303', '降噪系统', '降噪系统', null, '01');
INSERT INTO `udmajor` VALUES ('236', '02070304', '钢结构及构支架', '钢结构及构支架', null, '01');
INSERT INTO `udmajor` VALUES ('237', '020704', '金属材料', '有色金属、钢材、金属制品等。', null, '01');
INSERT INTO `udmajor` VALUES ('238', '020705', '五金材料', '机械五金、橡胶/塑料/石棉制品、水暖材料、建筑装饰五金等。', null, '01');
INSERT INTO `udmajor` VALUES ('239', '020706', '建筑材料', '建筑材料等。', null, '01');
INSERT INTO `udmajor` VALUES ('240', '020707', '燃料化工', '汽油、煤油等燃料、化工材料等。', null, '01');
INSERT INTO `udmajor` VALUES ('241', '020708', '低压电器及照明设备', '低压电器及变电站内照明设备。', null, '01');
INSERT INTO `udmajor` VALUES ('242', '020709', '工器具', '手电钻、机床、电缆切割机、电动自爬式锯管机等。', null, '01');
INSERT INTO `udmajor` VALUES ('243', '02070901', '电器及电动工具', '手电钻、机床、电缆切割机、电动自爬式锯管机等。', null, '01');
INSERT INTO `udmajor` VALUES ('244', '02070902', '登高、安全工具', '验电指示器、接地线（棒）、登高台、升降平台、个人保安接地线、安全帽、安全带、标识牌、安全工具柜、安全工具箱、升降机等。', null, '01');
INSERT INTO `udmajor` VALUES ('245', '02070903', '消防器材', '灭火器、消防水带、消防水枪、消防栓、风力灭火机等。', null, '01');
INSERT INTO `udmajor` VALUES ('246', '02070904', '起重工器具', '起重滑轮、葫芦、千斤顶等。', null, '01');
INSERT INTO `udmajor` VALUES ('247', '020710', '劳保类用品', '作业工作服、手套、工作鞋、毛巾、口罩等。', null, '01');
INSERT INTO `udmajor` VALUES ('248', '020711', '办公类用品', '办公纸品、办公耗材、办公笔类、办公本册、财务用品、文件管理、办公日用、办公耗材等。', null, '01');
INSERT INTO `udmajor` VALUES ('249', '02071105', '办公用品及耗材', '办公纸品、办公耗材、办公笔类、办公本册、财务用品、文件管理、办公日用、办公耗材等。', null, '01');
INSERT INTO `udmajor` VALUES ('250', '02071102', '办公设备', '打印机、复印机、扫描仪、投影仪、触摸屏等。', null, '01');
INSERT INTO `udmajor` VALUES ('251', '02071103', '办公家具及电器', '办公桌、会议桌、办公椅、沙发、办公用柜/架/箱、电视机、电冰箱、饮水机、洗衣机等。', null, '01');
INSERT INTO `udmajor` VALUES ('252', '02071104', '调度控制台', '电力调度用控制台。', null, '01');
INSERT INTO `udmajor` VALUES ('253', '020712', '药品及医疗器械', '药品。', null, '01');
INSERT INTO `udmajor` VALUES ('254', '02071201', '药品', '药品。', null, '01');
INSERT INTO `udmajor` VALUES ('255', '02071202', '医疗器械', '医疗器械。', null, '01');
INSERT INTO `udmajor` VALUES ('256', '020713', '水上交通工具', '', null, '01');
INSERT INTO `udmajor` VALUES ('257', '02071301', '趸船', '', null, '01');
INSERT INTO `udmajor` VALUES ('258', '0208', '设计类', '对火电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('259', '020801', '火电工程设计', '对火电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('260', '02080101', '火电土建设计', '对火电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('261', '02080102', '火电热力设计', '对火电建设热力系统设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('262', '02080103', '火电电气设计', '对火电建设电气系统设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('263', '02080104', '火电热控设计', '对火电建设热控系统设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('264', '02080105', '火电化学设计', '对火电建设化学技术设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('265', '02080106', '火电燃料设计', '对火电建设燃料技术设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('266', '020802', '水电工程设计', '对水电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('267', '02080201', '水电土建设计', '对水电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('268', '02080202', '水电电气设计', '对水电建设电气系统设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('269', '02080203', '水电机械设计', '对水电建设机械系统设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('270', '020803', '风电工程设计', '对风电建设机械系统设计熟悉的人员，包括风力发电机组、塔架、基础环等。', null, '01');
INSERT INTO `udmajor` VALUES ('271', '02080301', '风电机械设计', '对风电建设机械系统设计熟悉的人员，包括风力发电机组、塔架、基础环等。', null, '01');
INSERT INTO `udmajor` VALUES ('272', '02080302', '风电土建设计', '对风电建设土建工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('273', '020804', '输变电工程设计', '对输变电工程线路电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('274', '02080401', '线路电气设计', '对输变电工程线路电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('275', '02080402', '线路结构设计', '对输变电工程线路结构设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('276', '02080403', '变电电气设计', '对输变电工程变电电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('277', '02080404', '变电土建设计', '对输变电工程变电土建设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('278', '02080405', '电网系统规划设计', '对输变电工程电网系统规划设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('279', '02080406', '调度通信工程设计', '对输变电工程信息化工程设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('280', '02080407', '信息化工程规划与设计', '对输变电工程规划与设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('281', '020805', '工业与民用建筑设计', '包括楼堂馆所等建筑设计等。', null, '01');
INSERT INTO `udmajor` VALUES ('282', '020806', '数据网络设计', '对电网数据网络设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('283', '02080601', '数据通信骨干网', '对电网数据网络设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('284', '020807', '特高压设计', '对特高压工程变电电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('285', '02080701', '特高压变电设计', '对特高压工程变电电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('286', '0208070101', '特高压变电电气', '对特高压工程变电电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('287', '0208070102', '特高压变电土建', '对特高压工程变电土建设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('288', '02080702', '特高压线路设计', '对特高压工程线路电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('289', '0208070201', '特高压线路电气', '对特高压工程线路电气设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('290', '0208070202', '特高压线路结构', '对特高压工程线路结构设计熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('291', '020808', '直流换流站设计及监理', '', null, '01');
INSERT INTO `udmajor` VALUES ('292', '0209', '施工类', '对火电建设工程土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('293', '020901', '火电工程施工', '对火电建设工程土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('294', '02090101', '火电土建施工', '对火电建设工程土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('295', '02090102', '火电电气安装', '对火电建设工程电气安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('296', '02090103', '火电机务安装', '对火电建设工程机务安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('297', '02090104', '火电热控安装', '对火电建设工程热控安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('298', '020902', '水电工程施工', '包括通风兼安全洞、进厂交通洞、施工支洞、地下厂房、引水管道等施工。', null, '01');
INSERT INTO `udmajor` VALUES ('299', '02090201', '水电土建施工', '包括通风兼安全洞、进厂交通洞、施工支洞、地下厂房、引水管道等施工。', null, '01');
INSERT INTO `udmajor` VALUES ('300', '0209020101', '洞群施工', '包括通风兼安全洞、进厂交通洞、施工支洞、地下厂房、引水管道等施工。', null, '01');
INSERT INTO `udmajor` VALUES ('301', '0209020102', '水库施工', '包括上水库、下水库等土建施工。', null, '01');
INSERT INTO `udmajor` VALUES ('302', '02090202', '水电电气安装', '对水电建设工程土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('303', '02090203', '水电机械安装', '对水电建设工程机械安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('304', '020903', '风电工程施工', '对风电工程施工熟悉的人员，包括风电土建施工等。', null, '01');
INSERT INTO `udmajor` VALUES ('305', '020904', '输变电工程施工', '对输变电工程输电线路施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('306', '02090401', '输电线路施工', '对输变电工程输电线路施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('307', '02090402', '变电土建施工', '对输变电工程变电土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('308', '02090403', '变电设备安装', '对输变电工程变电设备安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('309', '02090404', '综合布线与机房施工', '对输变电工程综合布线与机房施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('310', '020905', '道路及桥梁施工', '对道路及桥梁施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('311', '020906', '装修与装饰工程', '对装修与装饰工程熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('312', '020907', '工业与民用建筑施工', '对工业与民用建筑施工熟悉的人员，包括火电、风电、水电等各类小型建筑基础开挖、回填等。', null, '01');
INSERT INTO `udmajor` VALUES ('313', '020909', '特高压施工', '对特高压工程线路施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('314', '02090901', '特高压线路施工', '对特高压工程线路施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('315', '02090902', '特高压土建施工', '对特高压工程土建施工熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('316', '02090903', '特高压设备安装', '对特高压工程设备安装熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('317', '020910', '直流换流站工程施工', '', null, '01');
INSERT INTO `udmajor` VALUES ('318', '0210', '监理类', '对火电建设工程电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('319', '021001', '火电工程监理', '对火电建设工程电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('320', '02100101', '火电电气监理', '对火电建设工程电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('321', '02100102', '火电热力监理', '对火电建设工程热力监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('322', '02100103', '火电热工监理', '对火电建设工程热工监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('323', '02100104', '火电化学监理', '对火电建设工程化学监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('324', '02100105', '火电燃料监理', '对火电建设工程燃料监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('325', '021002', '水电工程监理', '对水电建设工程电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('326', '02100201', '水电电气监理', '对水电建设工程电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('327', '02100202', '水电机械监理', '对水电建设工程机械监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('328', '021003', '风电工程监理', '对风电建设工程监理熟悉的人员，包括风电机械监理等。', null, '01');
INSERT INTO `udmajor` VALUES ('329', '021004', '输变电工程监理', '对输变电工程变电土建监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('330', '02100401', '变电土建监理', '对输变电工程变电土建监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('331', '02100402', '变电电气监理', '对输变电工程变电电气监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('332', '02100403', '输电线路监理', '对输变电工程输电线路监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('333', '021005', '工业与民用建筑监理', '对工业与民用建筑监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('334', '021006', '特高压监理', '对特高压工程线路施工监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('335', '02100601', '特高压线路施工监理', '对特高压工程线路施工监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('336', '02100602', '特高压土建施工监理', '对特高压工程土建施工监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('337', '02100603', '特高压设备安装监理', '对特高压工程设备安装监理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('338', '0211', '服务类', '对输变电工程环境保护、水土保持业务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('339', '021101', '咨询服务', '对输变电工程环境保护、水土保持业务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('340', '02110101', '环保水保', '对输变电工程环境保护、水土保持业务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('341', '02110102', '结算审核', '对工程总包、监理、造价审计工作熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('342', '02110103', '换流站调试', '对换流站投运前整体调试，保障运行技术熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('343', '02110104', '换流站设备监造', '对换流站内主要设备制造工艺、关键点熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('344', '021102', '会务服务', '能够为各类大、中型会议、展览或团体活动提供全程策划执行的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('345', '021103', '运输服务', '熟悉采购物资提供运输、配送服务要求的人员，含大件运输、物流配送等。', null, '01');
INSERT INTO `udmajor` VALUES ('346', '021104', '物业管理', '熟悉楼宇的维修及设施管护，清洁卫生、绿化等物业管理与服务的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('347', '021105', '安保服务', '熟悉楼宇的安全保卫工作、设施使用的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('348', '021106', '商业保险', '商业组织根据保险合同的约定，向投标人收取保险费，对于合同约定发生造成的财产损失承担赔偿责任。', null, '01');
INSERT INTO `udmajor` VALUES ('349', '021107', '科研开发', '对于输变电工程设计与施工科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('350', '02110701', '输变电工程设计与施工', '对于输变电工程设计与施工科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('351', '02110702', '输变电设备运行及管理', '对于输变电设备运行及管理科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('352', '02110703', '特高压输变电', '对于特高压输变电技术科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('353', '02110704', '新材料应用', '对于对新材料应用科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('354', '02110705', '一次设备及其智能化', '对于一次设备及其智能化科技开发项目熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('355', '02110706', '电力交易科研开发', '熟悉国内外电力市场，了解电力交易实务。', null, '01');
INSERT INTO `udmajor` VALUES ('356', '02110707', '新能源发电及装备', '对于新能源发电及装备熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('357', '02110708', '新能源发电源网协调', '对于新能源发电源网协调熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('358', '02110709', '配电网', '对于配电网熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('359', '02110710', '用电服务', '对于用电服务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('360', '02110711', '电动汽车充换电', '对于电动汽车充换电熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('361', '02110712', '分布式电源与微网', '对于分布式电源与微网熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('362', '02110713', '大电网安全分析与规划', '对于大电网安全分析与规划熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('363', '02110714', '电网安全控制与保护技术', '对于电网安全控制与保护技术熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('364', '02110715', '常规电源网源协调', '对于常规电源网源协调熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('365', '02110716', '电力系统自动化', '对于电力系统自动化熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('366', '02110717', '电力信息', '对于电力信息熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('367', '02110718', '电力通信', '对于电力通信熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('368', '02110719', '电力电子', '对于电力电子熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('369', '02110720', '大规模储能', '对于大规模储能熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('370', '02110721', '电网环保与节能', '对于电网环保与节能熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('371', '02110722', '电测量', '对于电测量熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('372', '02110723', '知识产权管理', '对于知识产权管理熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('373', '021108', '工程保险', '对进行中的建筑工程项目、安装工程项目及工程运行中的机器设备等面临的风险提供经济保障的风险。', null, '01');
INSERT INTO `udmajor` VALUES ('374', '021109', '车辆维修', '对车辆维修技术与价格熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('375', '021110', '车辆租赁', '对车辆租赁业务需求、开展方式与价格趋势熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('376', '021111', '法律服务', '对企业经营提供法律服务的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('377', '021112', '管理咨询', '', null, '01');
INSERT INTO `udmajor` VALUES ('378', '02111201', '电网发展类', '', null, '01');
INSERT INTO `udmajor` VALUES ('379', '02111202', '经营管理类', '', null, '01');
INSERT INTO `udmajor` VALUES ('380', '02111203', '科技信息类', '', null, '01');
INSERT INTO `udmajor` VALUES ('381', '02111204', '生产运行类', '', null, '01');
INSERT INTO `udmajor` VALUES ('382', '02111205', '政工管理类', '', null, '01');
INSERT INTO `udmajor` VALUES ('383', '02111206', '综合管理类', '', null, '01');
INSERT INTO `udmajor` VALUES ('384', '02111207', '法律咨询类', '', null, '01');
INSERT INTO `udmajor` VALUES ('385', '021113', '设备维保', '对于电网建设与运行的主要设备维修与保养业务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('386', '021114', '设备监造', '对于电网建设与运行的主要设备制造过程中关键环节检测与管控业务熟悉的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('387', '021115', '科技服务', '熟悉运用高新技术为企业生产经营提供技术支持与服务的相关人员。', null, '01');
INSERT INTO `udmajor` VALUES ('388', '021116', '科技咨询', '熟悉运用管理咨询模型设计为企业生产经营提供技术支持与服务的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('389', '021117', '科技开发', '熟悉运用管理咨询模型设计为企业生产经营提供技术支持与服务的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('390', '021118', '教育培训', '', null, '01');
INSERT INTO `udmajor` VALUES ('391', '021119', '文印印刷', '', null, '01');
INSERT INTO `udmajor` VALUES ('392', '021120', '直流换流站技术服务', '', null, '01');
INSERT INTO `udmajor` VALUES ('393', '021121', '广告宣传', '', null, '01');
INSERT INTO `udmajor` VALUES ('394', '021122', '服装订制', '', null, '01');
INSERT INTO `udmajor` VALUES ('395', '021123', '技改大修', '', null, '01');
INSERT INTO `udmajor` VALUES ('396', '0212', '生物质能源物资类', '熟悉利用生物化工技术，在材料制造、能源发展方面有所运用的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('397', '021201', '生物化工', '熟悉利用生物化工技术，在材料制造、能源发展方面有所运用的人员。', null, '01');
INSERT INTO `udmajor` VALUES ('398', '03', '法律专家', '熟悉公司并掌握公司招投标相关法律法规，从事公司法律工作的人员', null, '01');
INSERT INTO `udmajor` VALUES ('399', '04', '监察专家', '熟悉公司招投标纪检监察相关知识与要求，从事公司纪检检查的相关人员。', null, '01');
INSERT INTO `udmajor` VALUES ('400', '05', '物资监督专家', '熟悉并掌握公司监督检查相关知识与要求，从事公司物资监督检查工作的人员。', null, '01');

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
-- Records of udprojects
-- ----------------------------
INSERT INTO `udprojects` VALUES ('4', '113333eee', '55', '66', 'XX代理', '', null, '', '', '竞争性谈判', '', null);
INSERT INTO `udprojects` VALUES ('5', '33', '', '', 'XX代理', '', null, '', '', '竞争性谈判', '', '01');
INSERT INTO `udprojects` VALUES ('6', 'a', 'b', 'c', 'XX代理', '', null, '', '', '竞争性谈判', '', '01');

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
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('100112', 'admin', '0fedf119cd212806b710ca35cbfb4091', 'admin', '0', '2018-03-21 18:08:01', '2018-03-21 18:08:04');

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

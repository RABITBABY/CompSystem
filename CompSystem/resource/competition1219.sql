/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50619
Source Host           : 127.0.0.1:3306
Source Database       : competition

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2016-12-19 00:01:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administer
-- ----------------------------
DROP TABLE IF EXISTS `administer`;
CREATE TABLE `administer` (
  `adminNo` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `adminName` varchar(50) DEFAULT NULL COMMENT '姓名',
  `departmentId` int(50) DEFAULT NULL COMMENT '系',
  PRIMARY KEY (`adminNo`),
  KEY `fk_department` (`departmentId`),
  CONSTRAINT `fk_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administer
-- ----------------------------
INSERT INTO `administer` VALUES ('12345', '123456', null, null);
INSERT INTO `administer` VALUES ('12354', '2154', null, null);
INSERT INTO `administer` VALUES ('201306114450', '111111', null, null);
INSERT INTO `administer` VALUES ('201306114451', '000000', null, null);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` mediumtext COMMENT '内容',
  `pubDate` datetime DEFAULT NULL COMMENT '发布日期',
  `pubUser` varchar(50) DEFAULT NULL COMMENT '发布用户',
  `articleType` int(30) DEFAULT NULL COMMENT '发布的类型（1--竞赛信息,2—动态,3—预告）\r\n',
  `comId` int(11) DEFAULT NULL,
  PRIMARY KEY (`articleId`),
  KEY `pubUser` (`pubUser`),
  KEY `FKD458CCF6EDBA9C01` (`comId`),
  KEY `FKD458CCF6CB59385B` (`comId`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`pubUser`) REFERENCES `administer` (`adminNo`),
  CONSTRAINT `FKD458CCF6CB59385B` FOREIGN KEY (`comId`) REFERENCES `project` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('25', 'App设计大赛开始报名啦~~163333', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-07 14:25:04', '12345', '1', '1');
INSERT INTO `article` VALUES ('28', 'App设计大赛开始报名啦~~14', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('29', 'App设计大赛开始报名啦~~12', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-07 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('30', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('31', 'App设计大赛开始报名啦~~4', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-02 11:00:00', '12345', '2', null);
INSERT INTO `article` VALUES ('32', 'App设计大赛开始报名啦~~5', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-07 16:43:54', '12345', '1', '1');
INSERT INTO `article` VALUES ('33', 'App设计大赛开始报名啦~~6', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('37', 'App设计大赛开始报名啦~~5', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('38', 'App设计大赛开始报名啦~~8', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('39', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('40', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('41', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('42', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '1', '1');
INSERT INTO `article` VALUES ('43', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('44', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);
INSERT INTO `article` VALUES ('45', 'App设计大赛开始报名啦~~3', '<p>&nbsp; app设计大赛是有广州商学院举办的创新创意大赛，只要你有好的创意，好的构思，你就是最棒的！！快来展示你的大脑洞</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: right;\">&nbsp;&nbsp;&nbsp;&nbsp;竞赛负责老师：王新宗 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp; 竞赛主办单位：信息技术与工程学院 &nbsp;&nbsp;<br/></p><p style=\"text-align: right;\">&nbsp; &nbsp;竞赛报名时间：2016.12.25--2016.12.30&nbsp;</p>', '2016-12-06 00:00:00', '12345', '3', null);

-- ----------------------------
-- Table structure for awards
-- ----------------------------
DROP TABLE IF EXISTS `awards`;
CREATE TABLE `awards` (
  `awardsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `comId` int(11) DEFAULT NULL,
  `name` varchar(23) DEFAULT NULL COMMENT '竞赛名称',
  `date` date DEFAULT NULL COMMENT '竞赛时间',
  `hunit` varchar(45) DEFAULT NULL COMMENT '主办单位',
  `prizeId` int(11) DEFAULT NULL COMMENT '获奖等级',
  `levelId` int(11) DEFAULT NULL COMMENT '竞赛等级',
  `groupsNo` int(45) DEFAULT NULL COMMENT '获奖组别',
  `isPublish` int(11) DEFAULT '0' COMMENT '发布状态(0未，1发布)',
  PRIMARY KEY (`awardsId`),
  KEY `award_grade` (`prizeId`),
  KEY `FKAC40D1B69954ECC3` (`groupsNo`),
  KEY `FKAC40D1B68EA1F525` (`prizeId`),
  KEY `FKAC40D1B6A549AF89` (`levelId`),
  KEY `FKAC40D1B6EDBA9C01` (`comId`),
  CONSTRAINT `FKAC40D1B68EA1F525` FOREIGN KEY (`prizeId`) REFERENCES `prize` (`prizeId`),
  CONSTRAINT `FKAC40D1B69954ECC3` FOREIGN KEY (`groupsNo`) REFERENCES `groups` (`groupsNo`),
  CONSTRAINT `FKAC40D1B6A549AF89` FOREIGN KEY (`levelId`) REFERENCES `level` (`levelId`),
  CONSTRAINT `FKAC40D1B6EDBA9C01` FOREIGN KEY (`comId`) REFERENCES `project` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of awards
-- ----------------------------
INSERT INTO `awards` VALUES ('1', '3', '美术杯', '2016-11-15', '甲骨文公司', '3', '1', '1', '0');
INSERT INTO `awards` VALUES ('2', '3', '美术杯', '2016-11-21', '蓝桥杯公司', '1', '2', '2', '0');

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `budgetId` int(11) NOT NULL AUTO_INCREMENT,
  `comId` int(11) DEFAULT NULL COMMENT '序号',
  `subject` varchar(45) DEFAULT NULL COMMENT '支出科目',
  `sum` int(11) DEFAULT NULL COMMENT '金额',
  `reasons` varchar(45) DEFAULT NULL COMMENT '计算依据及理由',
  PRIMARY KEY (`budgetId`),
  KEY `decl_bud` (`comId`),
  KEY `FKADDAAF4589FF68C5` (`budgetId`),
  CONSTRAINT `com_bud` FOREIGN KEY (`comId`) REFERENCES `competition` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of budget
-- ----------------------------
INSERT INTO `budget` VALUES ('1', '1', '车费', '100', '赛场远');

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `comId` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `comName` varchar(23) DEFAULT NULL COMMENT '竞赛名称',
  `teacherNo` int(14) NOT NULL COMMENT '竞赛负责人',
  `unit` varchar(45) DEFAULT NULL COMMENT '所在单位',
  `levelId` int(3) DEFAULT NULL COMMENT '竞赛类别',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮箱',
  `departmentId` int(11) DEFAULT NULL COMMENT '负责人所在系部',
  `date` date DEFAULT NULL COMMENT '填表日期',
  `host` varchar(45) DEFAULT NULL COMMENT '院级以上竞赛举办者',
  `time` date DEFAULT NULL COMMENT '竞赛时间',
  `place` varchar(45) DEFAULT NULL COMMENT '竞赛地点',
  `introduce` varchar(255) DEFAULT NULL COMMENT '注释',
  `object` varchar(12) DEFAULT NULL COMMENT '参赛对象',
  `people` int(11) DEFAULT NULL COMMENT '人数',
  `sponsor` varchar(45) DEFAULT NULL COMMENT '校外资助单位',
  `plan` varchar(45) DEFAULT NULL COMMENT '学科竞赛实施方案',
  `tgoal` varchar(45) DEFAULT NULL COMMENT '能力训练目标',
  `wgoal` varchar(45) DEFAULT NULL COMMENT '竞赛获奖目标',
  `sopinion` varchar(45) CHARACTER SET utf8 COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '校外资助单位意见',
  `slsign` varchar(45) DEFAULT NULL COMMENT '资助单位负责人签字',
  `slsdate` date DEFAULT NULL COMMENT '资助单位负责人签字日期',
  `uopinion` varchar(45) DEFAULT NULL COMMENT '竞赛组织实施单位意见',
  `dsign` varchar(45) DEFAULT NULL COMMENT '系部签字',
  `dsdate` date DEFAULT NULL COMMENT '系部签字日期',
  `tdopinion` varchar(45) DEFAULT NULL COMMENT '教学处意见',
  `olsign` varchar(45) DEFAULT NULL COMMENT '竞赛办公室负责人签字',
  `olsdate` date DEFAULT NULL COMMENT '竞赛办公室负责人签字日期',
  `lsign` varchar(45) DEFAULT NULL COMMENT '负责人签字',
  `lsdate` date DEFAULT NULL COMMENT '负责人签字日期',
  `status` int(2) DEFAULT NULL COMMENT '申报状态。0等待系主任审批 1.等待教学处审批 2申报成功3申报失败',
  PRIMARY KEY (`comId`),
  KEY `level_com` (`levelId`),
  KEY `tno` (`teacherNo`),
  KEY `FKBEB591BF6741EFEB` (`teacherNo`),
  KEY `FKBEB591BF77CD9A99` (`departmentId`),
  CONSTRAINT `FKBEB591BF6741EFEB` FOREIGN KEY (`teacherNo`) REFERENCES `teacher` (`teacherNo`),
  CONSTRAINT `FKBEB591BF77CD9A99` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `level_com` FOREIGN KEY (`levelId`) REFERENCES `level` (`levelId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('1', '甲骨文', '1', '信息技术与工程学院', '1', '111222', 'a@qq.com', '1', '2016-11-06', '甲骨文', '2016-11-30', '华农', '好玩的比赛', '全国大学生', '2', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', '校外资助单位说我同意', '冯', '2016-11-14', '同意', '', '2016-11-23', null, null, null, null, null, '2');
INSERT INTO `competition` VALUES ('2', '软件设计大赛', '1', '信息技术与工程学院', '2', '111222', 'b@qq.com', '1', '2016-11-06', '小马哥', '2016-11-29', '华农', '好玩的比赛', '计算机系学生', '2', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', '校外资助单位说我同意', '冯', '2016-11-15', '同意', '', '2016-11-11', '', null, null, null, null, '2');
INSERT INTO `competition` VALUES ('3', '美术杯', '1', '信息技术与工程学院', '2', '2321323', 'c@qq.com', '1', '2016-11-06', '广州商学院', '2016-11-29', '华农', '好玩的比赛', '全院学生', '1', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', '校外资助单位说我同意', '冯', '2016-11-09', '同意', '林主任', null, null, null, null, null, null, '2');
INSERT INTO `competition` VALUES ('4', '小马哥杯', '1', '信息技术与工程学院', '2', '111222', 'b@qq.com', '1', '2016-11-06', '小马哥', '2016-11-29', '华农', '好玩的比赛', '计算机系学生', '2', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `competition` VALUES ('5', '大数据比赛', '1', '信息技术与工程学院', '2', '111222', 'b@qq.com', '1', '2016-11-06', '小马哥', '2016-11-29', '华农', '好玩的比赛', '计算机系学生', '2', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', null, null, null, null, null, null, null, null, null, null, null, '0');
INSERT INTO `competition` VALUES ('6', '小数据比赛', '1', '信息技术与工程学院', '1', '111222', 'b@qq.com', '1', '2016-11-06', '小马哥', '2016-11-29', '华农', '好玩的比赛', '计算机系学生', '2', '娇兰佳人', '就这么干吧', '就这么干吧', '要达到这个目标', null, null, null, null, null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for conditions
-- ----------------------------
DROP TABLE IF EXISTS `conditions`;
CREATE TABLE `conditions` (
  `conditionId` int(11) NOT NULL AUTO_INCREMENT,
  `conditionName` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '0.需要上传图片的  1.根据系别',
  PRIMARY KEY (`conditionId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conditions
-- ----------------------------
INSERT INTO `conditions` VALUES ('1', '学生证', '0');
INSERT INTO `conditions` VALUES ('2', '无敌证', '0');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) DEFAULT NULL COMMENT '系部名称',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机系');
INSERT INTO `department` VALUES ('2', '外语系');
INSERT INTO `department` VALUES ('3', '会计系');
INSERT INTO `department` VALUES ('4', '教学处');

-- ----------------------------
-- Table structure for fileupload
-- ----------------------------
DROP TABLE IF EXISTS `fileupload`;
CREATE TABLE `fileupload` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `fileName` int(11) DEFAULT NULL COMMENT '文件名',
  `saveName` varchar(100) DEFAULT NULL COMMENT '存储名',
  `uploadDate` date DEFAULT NULL COMMENT '上传日期',
  `uploadUser` varchar(50) DEFAULT NULL COMMENT '上传用户',
  PRIMARY KEY (`fileId`),
  KEY `uploadUser` (`uploadUser`),
  CONSTRAINT `fileupload_ibfk_1` FOREIGN KEY (`uploadUser`) REFERENCES `administer` (`adminNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileupload
-- ----------------------------

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `groupsNo` int(11) NOT NULL AUTO_INCREMENT,
  `comId` int(11) DEFAULT NULL,
  `groupsName` varchar(45) DEFAULT NULL COMMENT '组名',
  `teacherNo` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '报名状态（0.正在审核1.审核未通过 2.等待缴费3报名成功 4比赛结束）',
  PRIMARY KEY (`groupsNo`),
  KEY `com_id` (`comId`),
  KEY `FK_2klbi1qhox9yt1b0j5ovl5lbe` (`teacherNo`),
  KEY `FKB63DD9D4EDBA9C01` (`comId`),
  KEY `FKB63DD9D46741EFEB` (`teacherNo`),
  KEY `FKB63DD9D4CB59385B` (`comId`),
  KEY `FKB63DD9D46422C3A` (`groupsNo`),
  CONSTRAINT `FKB63DD9D46741EFEB` FOREIGN KEY (`teacherNo`) REFERENCES `teacher` (`teacherNo`),
  CONSTRAINT `FKB63DD9D4EDBA9C01` FOREIGN KEY (`comId`) REFERENCES `competition` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '1', '1111', '1', '3');
INSERT INTO `groups` VALUES ('2', '2', '一剑侠', '1', '3');
INSERT INTO `groups` VALUES ('3', '3', 'xxx', '1', '3');
INSERT INTO `groups` VALUES ('4', '2', '二货', '1', '3');
INSERT INTO `groups` VALUES ('5', '3', '无敌', '1', '0');

-- ----------------------------
-- Table structure for groupsdetail
-- ----------------------------
DROP TABLE IF EXISTS `groupsdetail`;
CREATE TABLE `groupsdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `groupsNo` int(11) DEFAULT NULL COMMENT '组号',
  `studentNo` int(11) DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`id`),
  KEY `gno` (`groupsNo`),
  KEY `sno` (`studentNo`),
  KEY `FKC52F2F459954ECC3` (`groupsNo`),
  KEY `FKC52F2F45F2872A5D` (`studentNo`),
  CONSTRAINT `FKC52F2F459954ECC3` FOREIGN KEY (`groupsNo`) REFERENCES `groups` (`groupsNo`),
  CONSTRAINT `FKC52F2F45F2872A5D` FOREIGN KEY (`studentNo`) REFERENCES `student` (`studentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groupsdetail
-- ----------------------------
INSERT INTO `groupsdetail` VALUES ('1', '1', '1');
INSERT INTO `groupsdetail` VALUES ('2', '1', '2');
INSERT INTO `groupsdetail` VALUES ('3', '2', '1');
INSERT INTO `groupsdetail` VALUES ('4', '3', '1');
INSERT INTO `groupsdetail` VALUES ('5', '4', '1');
INSERT INTO `groupsdetail` VALUES ('6', '4', '2');

-- ----------------------------
-- Table structure for guideteacher
-- ----------------------------
DROP TABLE IF EXISTS `guideteacher`;
CREATE TABLE `guideteacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comId` int(11) DEFAULT NULL,
  `teacherNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE7E27D66EDBA9C01` (`comId`),
  KEY `FKE7E27D666741EFEB` (`teacherNo`),
  KEY `FKE7E27D66E81376C0` (`id`),
  CONSTRAINT `FKE7E27D666741EFEB` FOREIGN KEY (`teacherNo`) REFERENCES `teacher` (`teacherNo`),
  CONSTRAINT `FKE7E27D66EDBA9C01` FOREIGN KEY (`comId`) REFERENCES `competition` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guideteacher
-- ----------------------------
INSERT INTO `guideteacher` VALUES ('1', '1', '1');
INSERT INTO `guideteacher` VALUES ('2', '1', '2');
INSERT INTO `guideteacher` VALUES ('3', '2', '1');

-- ----------------------------
-- Table structure for hours
-- ----------------------------
DROP TABLE IF EXISTS `hours`;
CREATE TABLE `hours` (
  `hoursId` int(11) NOT NULL AUTO_INCREMENT,
  `comId` int(11) DEFAULT NULL COMMENT '序号',
  `type` varchar(45) DEFAULT NULL COMMENT '课时类型',
  `hours` int(11) DEFAULT NULL COMMENT '课时数',
  `remarks` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`hoursId`),
  KEY `decl_hour` (`comId`),
  KEY `FK5EDC70F29ABB60F` (`hoursId`),
  CONSTRAINT `com_hour` FOREIGN KEY (`comId`) REFERENCES `competition` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hours
-- ----------------------------
INSERT INTO `hours` VALUES ('1', '1', '基础课程', '2', '无');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `levelId` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `levelName` varchar(15) DEFAULT NULL COMMENT '竞赛等级',
  PRIMARY KEY (`levelId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '国家级');
INSERT INTO `level` VALUES ('2', '省级');
INSERT INTO `level` VALUES ('3', '市级');
INSERT INTO `level` VALUES ('4', '校级 ');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `materialId` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `studentNo` int(11) DEFAULT NULL COMMENT '学号',
  `conditionId` int(11) DEFAULT NULL,
  `materialPic` varchar(50) DEFAULT NULL COMMENT '材料图片',
  `status` int(255) DEFAULT NULL COMMENT '材料审核状态。0未通过，1通过',
  PRIMARY KEY (`materialId`),
  KEY `FK11D36527F2872A5D` (`studentNo`),
  CONSTRAINT `FK11D36527F2872A5D` FOREIGN KEY (`studentNo`) REFERENCES `student` (`studentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '1', '1', null, '1');
INSERT INTO `material` VALUES ('2', '1', '2', null, '0');

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `prizeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `prizeName` varchar(15) DEFAULT NULL COMMENT '获奖等级',
  PRIMARY KEY (`prizeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize
-- ----------------------------
INSERT INTO `prize` VALUES ('1', '一等奖');
INSERT INTO `prize` VALUES ('2', '二等奖');
INSERT INTO `prize` VALUES ('3', '三等奖');
INSERT INTO `prize` VALUES ('4', '优秀奖');

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `proId` int(11) NOT NULL AUTO_INCREMENT COMMENT '作品序号',
  `proName` varchar(45) DEFAULT NULL COMMENT '作品名称',
  `award` varchar(30) DEFAULT NULL COMMENT '奖项',
  `membersName` varchar(50) NOT NULL COMMENT '组员名称',
  `introduction` text COMMENT '作品介绍',
  `pic` varchar(45) DEFAULT NULL COMMENT '作品图片',
  PRIMARY KEY (`proId`),
  KEY `id` (`proId`),
  KEY `gno` (`membersName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('1', '不知道什么App', 'App设计大赛一等奖', '李大锤', '爱谁谁的客户反馈绝地反击阿喀琉斯打飞机第三空间弗兰克空间但是福利科技点开链接来看东方健康的健康更健康的房间里大咖啡连锁店。。。', '38399b7d-de00-4839-bb45-7e90fee1c386.png');
INSERT INTO `production` VALUES ('2', '四则运算App', '不知道什么比赛一等奖', '王宝、李林', '就是一个像迷一样的APP', '8fc7ccaf-fea9-439e-8229-e6395c6c5093.png');
INSERT INTO `production` VALUES ('3', '数据统计小程序', '剁手赛之优秀奖', '李尚、王湾', '数据分析', '007b2653-5fae-4d9c-ba57-4aad6873dd8f.png');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `comId` int(11) NOT NULL COMMENT '竞赛ID',
  `comName` varchar(23) DEFAULT NULL COMMENT '竞赛名称',
  `levelId` int(11) DEFAULT NULL COMMENT '竞赛等级',
  `hunit` varchar(45) DEFAULT NULL COMMENT '主办单位',
  `sOrganizer` varchar(45) DEFAULT NULL COMMENT '校承办单位',
  `introduction` text COMMENT '竞赛简介',
  `applyBeginDate` date DEFAULT NULL COMMENT '报名开始时间',
  `applyEndDate` date DEFAULT NULL COMMENT '报名结束时间',
  `comDate` date DEFAULT NULL COMMENT '比赛时间',
  `cost` decimal(10,2) DEFAULT NULL COMMENT '报名费',
  `status` int(11) DEFAULT NULL COMMENT '比赛状态(0.赛前准备 1比赛结束 2.已反馈)',
  `isPublish` int(11) NOT NULL DEFAULT '0' COMMENT '发布状态',
  `isGroup` int(11) DEFAULT '0' COMMENT '0不需要组队 1 需要组队',
  PRIMARY KEY (`comId`),
  KEY `pro_gra` (`levelId`),
  CONSTRAINT `level_pro` FOREIGN KEY (`levelId`) REFERENCES `level` (`levelId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '甲骨文', '1', null, null, null, '2016-10-01', '2016-10-03', '2016-10-11', '300.00', '1', '0', '0');
INSERT INTO `project` VALUES ('2', '软件设计比赛', '2', null, null, null, '2016-11-01', '2016-11-02', '2016-11-22', '200.00', '1', '0', '0');
INSERT INTO `project` VALUES ('3', '美术杯', '2', null, null, null, '2016-01-01', '2016-01-10', '2016-03-10', '0.00', '2', '0', '0');
INSERT INTO `project` VALUES ('4', '小马哥杯', '1', null, null, null, null, null, '2016-07-08', '200.00', '1', '0', '0');

-- ----------------------------
-- Table structure for projectcondition
-- ----------------------------
DROP TABLE IF EXISTS `projectcondition`;
CREATE TABLE `projectcondition` (
  `proId` int(11) DEFAULT NULL COMMENT '比赛id',
  `conditionId` int(11) DEFAULT NULL COMMENT '条件id',
  KEY `pro_fk` (`proId`),
  KEY `con_fk` (`conditionId`),
  CONSTRAINT `con_fk` FOREIGN KEY (`conditionId`) REFERENCES `conditions` (`conditionId`),
  CONSTRAINT `pro_fk` FOREIGN KEY (`proId`) REFERENCES `project` (`comId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectcondition
-- ----------------------------
INSERT INTO `projectcondition` VALUES ('1', '1');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `scheduleId` int(11) NOT NULL AUTO_INCREMENT,
  `comId` int(11) DEFAULT NULL COMMENT '序号',
  `teacherNo` int(11) DEFAULT NULL COMMENT '职工号',
  `content` varchar(45) DEFAULT NULL COMMENT '培训内容',
  `position` varchar(45) DEFAULT NULL COMMENT '培训地点',
  `date` date DEFAULT NULL COMMENT '培训日期',
  `hours` int(11) DEFAULT NULL COMMENT '学时',
  PRIMARY KEY (`scheduleId`),
  KEY `decl_sche` (`comId`),
  KEY `decl_no` (`teacherNo`),
  KEY `FKD66692976741EFEB` (`teacherNo`),
  KEY `FKD6669297BF1FBF97` (`scheduleId`),
  CONSTRAINT `com_sch` FOREIGN KEY (`comId`) REFERENCES `competition` (`comId`),
  CONSTRAINT `FKD66692976741EFEB` FOREIGN KEY (`teacherNo`) REFERENCES `teacher` (`teacherNo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '1', '1', 'java基础', 'A栋202', '2016-12-18', '2');

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `standardId` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖励标准ID',
  `levelId` int(3) DEFAULT NULL COMMENT '获奖类别(外键)',
  `prizeId` int(6) DEFAULT NULL COMMENT '获奖等级(外键)',
  `student` int(11) DEFAULT NULL COMMENT '奖励标准（学生）',
  `teacher` int(11) DEFAULT NULL COMMENT '奖励标准（老师）',
  PRIMARY KEY (`standardId`),
  KEY `stan_type` (`levelId`),
  KEY `stan_grade` (`prizeId`),
  KEY `FK4E3D1EBD8EA1F525` (`prizeId`),
  CONSTRAINT `stan_grade` FOREIGN KEY (`prizeId`) REFERENCES `prize` (`prizeId`),
  CONSTRAINT `stan_type` FOREIGN KEY (`levelId`) REFERENCES `level` (`levelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNo` int(11) NOT NULL COMMENT '学号',
  `studentName` varchar(15) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `departmentId` int(15) DEFAULT NULL COMMENT '学院',
  `profession` varchar(15) DEFAULT NULL COMMENT '专业',
  `classNo` int(11) DEFAULT NULL COMMENT '班级',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(45) NOT NULL COMMENT '密码',
  PRIMARY KEY (`studentNo`),
  KEY `FK8FFE823B77CD9A99` (`departmentId`),
  CONSTRAINT `FK8FFE823B77CD9A99` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'max', '女', '1', '商业软件工程', '1', '2013', '18829839888', '53635657@qq.com', '123456');
INSERT INTO `student` VALUES ('2', 'huanwen', '女', '1', '商业软件工程', '1', '2013', '18829839888', '53635657@qq.com', '111111');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNo` int(11) NOT NULL COMMENT '职工号',
  `teacherName` varchar(14) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `departmentId` int(30) DEFAULT NULL COMMENT '部门',
  `subject` varchar(15) DEFAULT NULL COMMENT '科室',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `title` varchar(10) DEFAULT NULL COMMENT '职称',
  `post` varchar(45) DEFAULT NULL COMMENT '职务',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮箱',
  `type` varchar(10) DEFAULT NULL COMMENT '教职工类型',
  `direction` varchar(45) DEFAULT NULL COMMENT '教学研究方向',
  `education` varchar(45) DEFAULT NULL COMMENT '学历',
  `lab` int(11) DEFAULT '0' COMMENT '是否实验人员',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `examiner` int(11) DEFAULT '0' COMMENT '是否审批人员',
  PRIMARY KEY (`teacherNo`),
  KEY `no` (`teacherNo`),
  KEY `FKAA31CBE277CD9A99` (`departmentId`),
  CONSTRAINT `FKAA31CBE277CD9A99` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'max', null, null, '1', null, null, '外聘老师', '助教', null, null, null, null, '0', '123456', '1');
INSERT INTO `teacher` VALUES ('2', 'admin', '女', null, '2', null, null, '', '助教', null, null, null, null, '0', '000000', '0');
INSERT INTO `teacher` VALUES ('3', 'hw', null, null, '4', null, null, '教学处老师', '教师', null, null, null, null, '0', '123', '1');

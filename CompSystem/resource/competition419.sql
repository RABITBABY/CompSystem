/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50018
Source Host           : 127.0.0.1:3306
Source Database       : competition

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-04-19 20:02:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administer
-- ----------------------------
DROP TABLE IF EXISTS `administer`;
CREATE TABLE `administer` (
  `adminNo` varchar(20) NOT NULL,
  `password` varchar(255) default NULL,
  `adminName` varchar(255) default NULL COMMENT '姓名',
  `department` varchar(11) default NULL COMMENT '系',
  PRIMARY KEY  (`adminNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administer
-- ----------------------------
INSERT INTO `administer` VALUES ('1', '123123', 'max', '计算机系');
INSERT INTO `administer` VALUES ('2', '123123', 'lhw', '经济系');
INSERT INTO `administer` VALUES ('3', '123123', 'yzp', '会计系');
INSERT INTO `administer` VALUES ('4', '123123', 'cj', '外语系');
INSERT INTO `administer` VALUES ('5', '123123', 'wst', '艺术系');
INSERT INTO `administer` VALUES ('6', '123123', 'admin', '旅游管理系');
INSERT INTO `administer` VALUES ('7', '123123', 'cp', '国际学院');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `content` mediumtext COMMENT '内容',
  `pubDate` date default NULL COMMENT '发布日期',
  `pubUserNo` int(11) default NULL COMMENT '发布用户(管理员)',
  `articleType` int(11) default NULL COMMENT '发布的类型（\r\n1--竞赛信息\r\n2—动态\r\n3—预告）\r\n',
  `comId` int(11) default NULL,
  PRIMARY KEY  (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '“蓝桥杯”校赛报名通知', '报名啦', '2017-03-18', '1', '1', '1');
INSERT INTO `article` VALUES ('2', '“蓝桥杯”校赛动态', '报名啦', '2017-03-18', '1', '2', '1');
INSERT INTO `article` VALUES ('3', '“蓝桥杯”校赛即将开启', '报名啦', '2017-03-18', '1', '3', '1');
INSERT INTO `article` VALUES ('4', '“艺术杯”校赛报名通知', '报名啦', '2017-03-18', '2', '1', '2');
INSERT INTO `article` VALUES ('5', '“文化杯”校赛报名通知', '报名啦', '2017-03-18', '2', '1', '3');

-- ----------------------------
-- Table structure for awards
-- ----------------------------
DROP TABLE IF EXISTS `awards`;
CREATE TABLE `awards` (
  `awardsId` int(11) NOT NULL auto_increment,
  `comId` int(11) default NULL,
  `prizeName` varchar(11) default NULL COMMENT '获奖等级',
  `groupsNo` int(11) default NULL COMMENT '获奖组别',
  `awardsImg` varchar(255) default NULL COMMENT '获奖证书照片',
  `awardTime` date default NULL COMMENT '获奖时间',
  `isPublish` int(11) default NULL COMMENT '发布状态',
  PRIMARY KEY  (`awardsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of awards
-- ----------------------------
INSERT INTO `awards` VALUES ('1', '1', '一等奖', '1', null, null, '1');
INSERT INTO `awards` VALUES ('2', '1', '二等奖', '2', null, null, '1');
INSERT INTO `awards` VALUES ('3', '1', '三等奖', '3', null, null, '0');
INSERT INTO `awards` VALUES ('4', '2', '三等奖', '4', null, null, '1');

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `budgetId` int(11) NOT NULL auto_increment,
  `comId` int(11) default NULL,
  `subject` varchar(255) default NULL COMMENT '支出科目',
  `sum` int(11) default NULL COMMENT '金额',
  `reasons` varchar(255) default NULL COMMENT '计算依据及理由',
  PRIMARY KEY  (`budgetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of budget
-- ----------------------------
INSERT INTO `budget` VALUES ('1', '1', '车费', '300', '路途遥远');
INSERT INTO `budget` VALUES ('2', '1', '午餐费', '300', '路途遥远，又饿');
INSERT INTO `budget` VALUES ('3', '1', '早餐费', '300', '路途遥远');
INSERT INTO `budget` VALUES ('4', '2', '车费', '600', '路途遥远');
INSERT INTO `budget` VALUES ('5', '2', '午餐费', '600', '路途遥远');

-- ----------------------------
-- Table structure for compcondition
-- ----------------------------
DROP TABLE IF EXISTS `compcondition`;
CREATE TABLE `compcondition` (
  `id` int(11) NOT NULL,
  `comId` int(11) default NULL COMMENT '竞赛id',
  `conditionId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compcondition
-- ----------------------------
INSERT INTO `compcondition` VALUES ('1', '1', '1');
INSERT INTO `compcondition` VALUES ('2', '1', '2');
INSERT INTO `compcondition` VALUES ('3', '2', '1');
INSERT INTO `compcondition` VALUES ('4', '2', '2');

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `comId` int(11) NOT NULL auto_increment,
  `comName` varchar(255) default NULL,
  `teacherNo` int(11) default NULL COMMENT '竞赛负责人',
  `unit` varchar(255) default NULL COMMENT '负责人所在单位',
  `levelName` varchar(11) default NULL COMMENT '竞赛等级ABC',
  `department` varchar(11) default NULL COMMENT '所在系部',
  `date` date default NULL COMMENT '填表日期',
  `host` varchar(255) default NULL COMMENT '院级以上竞赛举办者',
  `time` date default NULL COMMENT '竞赛时间',
  `place` varchar(255) default NULL COMMENT '竞赛地点',
  `introduce` varchar(255) default NULL COMMENT '竞赛简介',
  `object` varchar(255) default NULL COMMENT '参赛对象',
  `people` int(12) default NULL COMMENT '人数',
  `sponsor` varchar(255) default NULL COMMENT '校外资助单位',
  `plan` varchar(255) default NULL COMMENT '学科竞赛实施方案',
  `tgoal` varchar(255) default NULL COMMENT '能力训练目标',
  `wgoal` varchar(255) default NULL COMMENT '竞赛获奖目标',
  `sopinion` varchar(255) default NULL COMMENT '校外资助单位意见',
  `slsign` varchar(255) default NULL COMMENT '资助单位负责人签字',
  `slsdate` date default NULL COMMENT '资助单位负责人签字日期',
  `uopinion` varchar(255) default NULL COMMENT '竞赛组织实施单位意见',
  `dsign` varchar(255) default NULL COMMENT '系部签字(盖章)',
  `dsdate` date default NULL COMMENT '系部签字日期',
  `tdopinion` varchar(255) default NULL COMMENT '教学处意见',
  `olsign` varchar(255) default NULL COMMENT '竞赛办公室负责人签字',
  `olsdate` datetime default NULL COMMENT '竞赛办公室负责人签字日期',
  `lsign` varchar(255) default NULL COMMENT '负责人签字',
  `lsdate` date default NULL COMMENT '负责人签字日期',
  `depSpStatus` int(11) default NULL COMMENT '系主任审批状态0,1',
  `teaSpStatus` int(11) default NULL COMMENT '教学处审批状态0,1',
  `completeStatus` int(11) default NULL COMMENT '竞赛资料完善状态0,1',
  `applyBeginDate` date default NULL COMMENT '报名开始时间',
  `applyEndDate` date default NULL COMMENT '报名结束时间',
  `cost` decimal(10,0) default NULL COMMENT '报名费用',
  `compStatus` int(11) default NULL COMMENT '竞赛过程状态（比赛前，比赛中，比赛后）',
  `isPublish` int(11) default NULL COMMENT '发布状态',
  `isNeedGroup` int(11) default NULL COMMENT '是否需要组队',
  `groupNum` int(11) default NULL COMMENT '需要组队时，人数限制。',
  PRIMARY KEY  (`comId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('1', '蓝桥杯', '1', '计算机系', '校级', '计算机系', '2017-03-15', '计算机系', '2017-04-01', '校内', '蓝桥杯是一款炫酷安林匹克竞赛', '全校学生', '10', '娇兰佳人', '实施方案是这样的', '能力训练目标是使学生学习能力更好', '目标是一等奖', '娇兰佳人同意', '娇兰佳人', '2017-03-18', '计算机系举办单位同意', '林树青', '2017-03-18', '教学处同意', '林教学', '2017-03-18 20:56:33', '邱珍珍', '2017-03-18', '1', '1', '1', '2017-03-18', '2017-03-31', '100', '1', '1', null, null);
INSERT INTO `competition` VALUES ('2', '艺术杯', '2', '艺术系', '省级', '艺术系', '2017-03-13', '艺术系', '2017-04-01', '大学城', '艺术杯旨在培养大学生艺术感', '艺术系学生', '10', '娇兰佳人', '实施方案是这样的', '能力训练目标是使学生学习能力更好', '目标是一等奖', '娇兰佳人同意', '娇兰佳人', '2017-03-18', '艺术系举办单位同意', '林小树', '2017-03-18', '', '', '2017-03-18 20:56:57', '吴广裕', '2017-03-18', '1', '0', '0', '2017-03-18', '2017-03-23', '100', '1', '1', null, null);
INSERT INTO `competition` VALUES ('3', '文化杯', '3', '经济系', '校级', '经济系', '2017-03-13', '经济系', '2017-04-01', '校内', '文化杯培养文化水平', '全校学生', '10', '娇兰佳人', '实施方案是这样的', '能力训练目标是使学生学习能力更好', '目标是一等奖', '娇兰佳人同意', '娇兰佳人', '2017-03-18', '经济系举办单位同意', '林大树', '2017-03-18', '', '', null, '吴明珠', '2017-03-18', '1', '0', '0', null, null, null, '0', '0', null, null);
INSERT INTO `competition` VALUES ('4', '那个啥赛改一下', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for conditions
-- ----------------------------
DROP TABLE IF EXISTS `conditions`;
CREATE TABLE `conditions` (
  `conditionId` int(11) NOT NULL auto_increment,
  `conditionName` varchar(255) default NULL,
  `type` int(11) default NULL COMMENT '条件类型\r\n0.需要图片\r\n1.系别限制\r\n',
  PRIMARY KEY  (`conditionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of conditions
-- ----------------------------
INSERT INTO `conditions` VALUES ('1', '学生证', '0');
INSERT INTO `conditions` VALUES ('2', '计算机系', '1');
INSERT INTO `conditions` VALUES ('3', '外语系', '1');
INSERT INTO `conditions` VALUES ('4', '通过校级竞赛', '0');

-- ----------------------------
-- Table structure for fileupload
-- ----------------------------
DROP TABLE IF EXISTS `fileupload`;
CREATE TABLE `fileupload` (
  `fileId` int(11) NOT NULL auto_increment,
  `fileName` varchar(255) default NULL,
  `saveName` varchar(255) default NULL COMMENT '存储名',
  `uploadDate` date default NULL COMMENT '上传日期',
  `uploadUserNo` varchar(20) default NULL COMMENT '上传用户',
  PRIMARY KEY  (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileupload
-- ----------------------------

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `groupsNo` int(11) default NULL,
  `comId` int(11) default NULL,
  `groupsName` varchar(255) default NULL,
  `teacherNo` int(11) default NULL COMMENT '指导老师',
  `studentNo` int(11) default NULL COMMENT '学生',
  `status` int(11) default NULL COMMENT '报名状态(等待审核0，报名成功1，报名失败2)',
  `captainStatus` int(11) default NULL COMMENT '队长审批状态(0未审核1同意2不同意)',
  `isCaptain` int(11) default NULL COMMENT '是否为队长',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '1', '1', '火星组', '1', '1', '1', '1', '1');
INSERT INTO `groups` VALUES ('2', '2', '1', '木星组', '1', '8', '1', '1', '1');
INSERT INTO `groups` VALUES ('3', '3', '1', '地球组', '1', '9', '1', '1', '1');
INSERT INTO `groups` VALUES ('4', '4', '2', '超艺术', '5', '5', '1', '1', '1');
INSERT INTO `groups` VALUES ('5', '1', '1', '火星组', '1', '2', '1', '1', '0');

-- ----------------------------
-- Table structure for guideteacher
-- ----------------------------
DROP TABLE IF EXISTS `guideteacher`;
CREATE TABLE `guideteacher` (
  `guideTeaId` int(11) NOT NULL auto_increment,
  `teacherNo` int(11) default NULL,
  `comId` int(11) default NULL,
  PRIMARY KEY  (`guideTeaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guideteacher
-- ----------------------------
INSERT INTO `guideteacher` VALUES ('1', '1', '1');
INSERT INTO `guideteacher` VALUES ('2', '2', '2');
INSERT INTO `guideteacher` VALUES ('3', '3', '3');
INSERT INTO `guideteacher` VALUES ('4', '8', '1');
INSERT INTO `guideteacher` VALUES ('5', '9', '1');

-- ----------------------------
-- Table structure for hours
-- ----------------------------
DROP TABLE IF EXISTS `hours`;
CREATE TABLE `hours` (
  `hoursId` int(11) NOT NULL auto_increment,
  `comId` int(11) default NULL,
  `type` varchar(255) default NULL COMMENT '课时类别',
  `hours` int(11) default NULL COMMENT '课时数',
  `remarks` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`hoursId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hours
-- ----------------------------

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `levelId` int(11) NOT NULL auto_increment,
  `levelName` varchar(23) default NULL COMMENT '竞赛等级名称ABC',
  `prizeName` varchar(23) default NULL COMMENT '获奖等级名称',
  PRIMARY KEY  (`levelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '国家级', '一等奖');
INSERT INTO `level` VALUES ('2', '国家级', '二等奖');
INSERT INTO `level` VALUES ('3', '国家级', '三等奖');
INSERT INTO `level` VALUES ('4', '省级', '一等奖');
INSERT INTO `level` VALUES ('5', '省级', '三等奖');
INSERT INTO `level` VALUES ('6', '省级', '二等奖');
INSERT INTO `level` VALUES ('7', '校级', '一等奖');
INSERT INTO `level` VALUES ('8', '校级', '二等奖');
INSERT INTO `level` VALUES ('9', '校级', '三等奖');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `materialId` int(11) NOT NULL auto_increment,
  `studentNo` int(11) default NULL,
  `conditionId` int(11) default NULL COMMENT '该材料所符合的竞赛条件',
  `materialPic` varchar(255) default NULL COMMENT '材料图片',
  `status` int(255) default NULL COMMENT '审核状态',
  PRIMARY KEY  (`materialId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '1', '1', null, '1');
INSERT INTO `material` VALUES ('2', '1', '2', '11492099080121', null);

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `proId` int(11) NOT NULL auto_increment,
  `proName` varchar(255) default NULL,
  `award` varchar(255) default NULL COMMENT '奖项',
  `membersName` varchar(255) default NULL COMMENT '组员名称',
  `introduction` text COMMENT '作品介绍',
  `pic` varchar(255) default NULL COMMENT '作品图片',
  `createDate` date default NULL COMMENT '上传日期日期',
  PRIMARY KEY  (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of production
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `comId` int(11) NOT NULL,
  `teacherNo` int(11) default NULL,
  `content` varchar(255) default NULL COMMENT '培训内容',
  `position` varchar(255) default NULL COMMENT '培训地点',
  `date` date default NULL COMMENT '培训日期',
  `hours` int(11) default NULL COMMENT '学时',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `standardId` int(11) NOT NULL auto_increment,
  `levelId` int(11) default NULL,
  `student` varchar(255) default NULL COMMENT '奖励标准(学生)',
  `teacher` varchar(255) default NULL COMMENT '奖励标准(指导老师)',
  PRIMARY KEY  (`standardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------
INSERT INTO `standard` VALUES ('1', '1', '100块', '1000块');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNo` int(11) NOT NULL auto_increment,
  `studentName` varchar(14) default NULL,
  `gender` varchar(2) default NULL COMMENT '性别',
  `department` varchar(12) default NULL COMMENT '学院或者系',
  `profession` varchar(18) default NULL COMMENT '专业',
  `classNo` int(11) default NULL COMMENT '班别',
  `grade` int(11) default NULL COMMENT '年级',
  `phone` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  PRIMARY KEY  (`studentNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '林欢雯', '女', '计算机系', '计算机科学与技术', '2', '13', '18819297382', '545306388@qq.com', '123123');
INSERT INTO `student` VALUES ('2', '冯美欣', '女', '经济系', '金融', '1', '13', '18827392992', '545306381@qq.com', '123123');
INSERT INTO `student` VALUES ('3', '叶子鹏', '男', '会计系', '审计学', '1', '13', '18827363778', '545306382@qq.com', '123123');
INSERT INTO `student` VALUES ('4', '吴舒婷', '女', '外语系', '日语', '1', '13', '18812772828', '545306383@qq.com', '123123');
INSERT INTO `student` VALUES ('5', '陈健', '男', '艺术系', '艺术学', '1', '13', '18822228839', '545306384@qq.com', '123123');
INSERT INTO `student` VALUES ('6', '陈皮', '男', '旅游管理系', '酒管', '1', '13', '18827272889', '545306385@qq.com', '123123');
INSERT INTO `student` VALUES ('7', '叶问', '男', '国际学院', '国际会计', '1', '13', '18819292839', '545306386@qq.com', '123123');
INSERT INTO `student` VALUES ('8', '林小欢', '女', '计算机系', '计算机科学与技术', '2', '13', '18819297382', '545306388@qq.com', '123123');
INSERT INTO `student` VALUES ('9', '林小雯', '女', '计算机系', '计算机科学与技术', '2', '13', '18819297382', '545306388@qq.com', '123123');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherNo` int(11) NOT NULL auto_increment,
  `teacherName` varchar(255) default NULL,
  `gender` varchar(255) default NULL,
  `birth` date default NULL,
  `department` varchar(11) default NULL,
  `subject` varchar(255) default NULL COMMENT '科室',
  `phone` varchar(255) default NULL,
  `title` varchar(255) default NULL COMMENT '职称',
  `post` varchar(255) default NULL COMMENT '职务',
  `email` varchar(255) default NULL,
  `type` varchar(255) default NULL COMMENT '教职工类别',
  `direction` varchar(255) default NULL COMMENT '教学研究方向',
  `education` varchar(255) default NULL COMMENT '学历',
  `lab` varchar(255) default NULL COMMENT '是否实验室人员',
  `password` varchar(255) default NULL COMMENT '密码',
  `examiner` int(255) default NULL COMMENT '是否审批人员(是审批人员并且是计算机的，就是计算机系主任，是教学处的，就是教学处审批员)',
  PRIMARY KEY  (`teacherNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '邱珍珍', '女', '2010-12-01', '计算机系', '计算机原理', '18827283778', null, null, null, null, null, null, null, '123123', '1');
INSERT INTO `teacher` VALUES ('2', '吴明珠', '女', '2010-12-01', '经济系', '经济原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('3', '梁建军', '男', '2010-12-01', '会计系', '会计原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('4', '林树青', '男', '2010-12-01', '外语系', '外语原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('5', '吴广裕', '男', '2010-12-01', '艺术系', '艺术原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('6', '李蓉', '女', '2010-12-01', '旅游管理系', '旅游原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('7', '陈瑛', '女', '2010-12-01', '国际学院', '国际原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('8', '邱小珍', '女', '2010-12-01', '计算机系', '计算机原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');
INSERT INTO `teacher` VALUES ('9', '邱大珍', '女', '2010-12-01', '计算机系', '计算机原理', '18827283778', '', '', '', '', '', '', '', '123123', '1');

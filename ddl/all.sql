-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: 172.16.4.95
-- 生成日期: 2017 年 02 月 23 日 07:29
-- 服务器版本: 5.7.17
-- PHP 版本: 6.0.0-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `ahis`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `BankCardInfo`
-- 

CREATE TABLE `BankCardInfo` (
  `userId` bigint(8) NOT NULL COMMENT '用户ID',
  `ownCardName` varchar(64) NOT NULL COMMENT '用户姓名',
  `idCardNo` varchar(18) NOT NULL COMMENT '身份证号',
  `bankCardNo` varchar(50) NOT NULL COMMENT '银行卡号',
  `bank` char(10) NOT NULL COMMENT '银行',
  `bankCardType` char(1) NOT NULL COMMENT '银行卡类型	 1:借记卡 2:信用卡',
  `phoneNo` char(11) NOT NULL COMMENT '手机号码',
  `insertTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`userId`,`bankCardNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡绑定表';

-- 
-- 导出表中的数据 `BankCardInfo`
-- 

INSERT INTO `BankCardInfo` VALUES (2, '测试帐号', '320981199011223455', '6228542116546498461', '1', '1', '15051215456', '2017-01-22 16:45:49');
INSERT INTO `BankCardInfo` VALUES (17, '许悦', '320111111111111111', '2222222222222222222', '2', '1', '13911111111', '2017-01-24 10:46:38');
INSERT INTO `BankCardInfo` VALUES (17, '许悦', '320111111111111111', '3699999955002103320', '1', '1', '13699999999', '2017-01-24 11:49:18');
INSERT INTO `BankCardInfo` VALUES (17, '许悦', '320111111111111111', '6225899698881445622', '4', '1', '13911111111', '2017-01-24 11:08:57');
INSERT INTO `BankCardInfo` VALUES (17, '许悦', '320111111111111111', '7669999999999587744', '3', '1', '13911111111', '2017-01-24 10:46:39');

-- --------------------------------------------------------

-- 
-- 表的结构 `DepartmentBasicInfo`
-- 

CREATE TABLE `DepartmentBasicInfo` (
  `hospitalCode` varchar(64) NOT NULL COMMENT '医院代码',
  `parentCode` varchar(64) NOT NULL COMMENT '0：表示无父科室',
  `departmentCode` varchar(32) NOT NULL COMMENT '科室代码',
  `departmentName` varchar(64) NOT NULL COMMENT '科室名称',
  `hasChild` char(1) NOT NULL COMMENT '是否有子科室	 0：无子科室\r\n1：有子科室',
  `departmentDescription` varchar(255) DEFAULT NULL COMMENT '科室介绍',
  PRIMARY KEY (`hospitalCode`,`parentCode`,`departmentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室情报';

-- 
-- 导出表中的数据 `DepartmentBasicInfo`
-- 

INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S001', '内科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S002', '烧伤整形科门诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S003', '急诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S004', '外科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S005', '消化科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S006', '骨科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S007', '妇产科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S008', '儿科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S009', '眼科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S010', '耳鼻咽喉科门诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S011', '口腔科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S012', '皮肤科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S013', '中医科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S014', '康复理疗科门诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S015', '麻醉科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S016', '放射科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S021', '门急诊', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S033', '护理门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S034', '体检门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', '0', 'S035', '疼痛科门诊诊室', '1', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0412', '内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0413', '心血管内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0414', '呼吸内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0415', '血液科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0416', '肿瘤科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0417', '内分泌科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0418', '肾内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0419', '神经内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0420', '心理科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0421', '风湿科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0422', '感染性疾病科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0481', '营养科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0757', '肠道门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0758', '发热门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S001', '0759', '风湿免疫科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S002', '0440', '伤口专病门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S002', '0441', '烧伤科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S002', '0442', '整形科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S002', '0443', '手外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0424', '外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0425', '门诊手术室', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0426', '胸心外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0427', '神经外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0428', '泌尿外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S004', '0705', '手足外科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0430', '消化科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0431', '肝胆外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0432', '胃肠外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0433', '肛肠外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0434', '普外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0435', '消化内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0436', '中医消化内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0437', '颈部乳房外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0486', '胃肠病门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0715', '脾胃病中心', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0755', '内镜中心门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S005', '0781', '肝胆外科专病门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S006', '0445', '骨科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S006', '0446', '脊柱外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S006', '0447', '足踝外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S006', '0474', '中医骨伤科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S006', '0482', '颈椎病门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S007', '0449', '妇科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S007', '0450', '产科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S008', '0452', '儿科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S008', '0453', '新生儿科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S009', '0455', '眼科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S009', '0485', '泪道门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S010', '0457', '耳鼻咽喉科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S011', '0459', '口腔科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S012', '0461', '皮肤科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S012', '0462', '皮肤性病科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S013', '0439', '中医外科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S013', '0464', '中医内科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S013', '0475', '中医专病门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S014', '0466', '康复科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S014', '0473', '针灸科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S016', '0470', '介入科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S016', '0765', '影像科门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0402', '急诊内科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0403', '急诊外科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0405', '急诊烧伤科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0406', '急诊妇产科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0407', '急诊儿科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0408', '急诊眼科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0409', '急诊耳鼻咽喉科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0410', '急诊口腔科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0476', '急诊骨科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0477', '急诊皮肤性病科', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0479', '方便门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0480', '老干部门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S021', '0756', '日间病房门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S033', '0472', 'PICC护理门诊', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S034', '0700', '门诊内科2', '0', '');
INSERT INTO `DepartmentBasicInfo` VALUES ('0001', 'S035', '0468', '疼痛门诊', '0', '');

-- --------------------------------------------------------

-- 
-- 表的结构 `DoctorBasicInfo`
-- 

CREATE TABLE `DoctorBasicInfo` (
  `hospitalCode` varchar(64) NOT NULL COMMENT '医院代码',
  `departmentCode` varchar(32) NOT NULL COMMENT '科室代码',
  `departmentName` varchar(64) NOT NULL COMMENT '科室名称',
  `doctorCode` varchar(32) NOT NULL COMMENT '医生代码',
  `doctorName` varchar(64) NOT NULL COMMENT '医生姓名',
  `skill` varchar(128) DEFAULT NULL COMMENT '医生擅长',
  `summary` varchar(255) DEFAULT NULL COMMENT '医生简介',
  `portrait` blob,
  `rank` varchar(64) DEFAULT NULL COMMENT '医生职称',
  PRIMARY KEY (`hospitalCode`,`departmentCode`,`doctorCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生信息表';

-- 
-- 导出表中的数据 `DoctorBasicInfo`
-- 

INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0101', '院办公室', '009104', '储兴', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0101', '院办公室', '089204', '高宇峰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0105', '人事科', '003101', '黄继人', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0105', '人事科', '009102', '章斐然', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0105', '人事科', '009103', '李建平', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0105', '人事科', '077203', '周奚钟', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0105', '人事科', '081201', '尹光耀', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0111', '医务处', '005400', '吕季方', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0111', '医务处', '082201', '陆树洪', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0111', '医务处', '083102', '王亚梅', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0111', '医务处', '083208', '乔琳琳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0111', '医务处', '086202', '谭雪芳', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0116', '科教科', '088103', '李成万', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0122', '中西医结合研究所', '008403', '袁凤来', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0130', '预防保健科', '003207', '尹群', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0131', '院内感染管理科', '098211', '吴小龙', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0159', '体检中心', '010604', '肖丹', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0159', '体检中心', '016602', '黄爱国', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0159', '体检中心', '016671', '韩欣均', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0159', '体检中心', '070205', '蒋铭毅', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0159', '体检中心', '087202', '胡盘娣', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '012208', '俞慧', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '013221', '朱海杰', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '016205', '贾圣男', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '095205', '黄伟', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '096205', '郑勇', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '098201', '杜梁枫', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0305', '重症监护室', '099219', '昌震', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0306', '高压氧舱', '087205', '季惠君', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '008204', '王广艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '009206', '李拜红', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '010203', '鲍骏', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '011216', '朱君', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '012212', '吴德旭', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '013208', '于生才', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '086206', '金伟东', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '092203', '王晓彦', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '096203', '庄瑞娟', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0308', '心血管内科', '098206', '王锡惠', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '005222', '左志通', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '006201', '陈宝华', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '008207', '史建平', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '011202', '董乔菁', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '011219', '孙燕', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '014205', '白翠青', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '015202', '高小伟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '016218', '周海跃', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '091202', '王旭', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '095207', '张彩娣', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0309', '呼吸内科', '096209', '邹新中', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '002215', '周晔', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '008206', '王志清', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '010218', '张艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '014223', '吴霜', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '015203', '李锦', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '080202', '李兰萍', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '087204', '高华强', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '097208', '朱文艳', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0310', '血液科', '098208', '华海应', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '001208', '朱娅', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '008209', '许彬', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '008404', '严一旦', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '008410', '周晶', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '009217', '张振勇', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '014202', '吴锐荣', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0311', '肿瘤科', '085204', '文洽先', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '003206', '张亮', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '006203', '孙道崎', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '008205', '曹敏', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '011217', '俞丹', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '011228', '张安星', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '014203', '王艳萍', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '089201', '华文进', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '091203', '韩勤芬', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '095204', '黄德芳', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '095206', '曹宏', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '097204', '陈慧', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0312', '内分泌科', '098202', '薛俊', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '001212', '李春庆', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '008208', '陈英兰', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '009224', '周健淞', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '011223', '王友云', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '012206', '蒋宏伟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '014208', '汤琼', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '014662', '张晟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '090205', '杜浩昌', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '099202', '陈高翔', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0313', '肾内科', '099207', '杜渊', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '001201', '邵小鹏', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '006205', '王引明', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '011225', '范长燕', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '012218', '狄美琪', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '090204', '胡玲玲', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0315', '神经内科', '097209', '桂树华', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '000203', '瞿伟丰', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '002201', '孙振宇', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '002211', '孙琦', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '004213', '张卫民', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '006208', '赵永', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '011215', '崔启辰', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '013209', '李金友', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '014210', '申健', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '090207', '丁小云', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0317', '胸心外科', '099205', '顾敏威', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '000208', '王泳', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '003210', '陈革', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '015643', '戈纯', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '016222', '陈东栋', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '091204', '周建宏', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '096204', '蒋云召', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0318', '神经外科', '098210', '陆爻忠', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '004215', '戴枫', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '005207', '吴升', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '007211', '彭涛', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '010205', '秦锋', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '011221', '糜远源', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '013215', '王建', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '014211', '黄懿', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '016213', '汪骏', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '087206', '祝黎洁', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '092205', '尤晓明', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0319', '泌尿外科', '099215', '邵红宝', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '002217', '严炯', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '005211', '谢龙炜', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '006280', '张钒', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '008219', '黄崇根', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '008220', '过云', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '009216', '尹朝红', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '012214', '贾志刚', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '013217', '周滇', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '084204', '吕国忠', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '085205', '顾在秋', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0323', '烧伤科', '088201', '虞俊杰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '000202', '何友钊', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '007209', '陈武强', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '009203', '杨军', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '009225', '许晋彦', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '010221', '胡浩', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '013204', '胡本顺', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '016211', '熊书名', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '090201', '顾元龙', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '093202', '翟年宽', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '093207', '钱毅', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0326', '肝胆外科', '099206', '刘敏丰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '000211', '沈晓明', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '001207', '苏志坚', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '003201', '张淳', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '004210', '许炳华', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '009202', '杨增辉', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '015644', '赵天天', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '016223', '史益凡', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '088202', '鲍传庆', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0327', '胃肠外科', '091206', '卞晋荣', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '000000', '普通号', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '000204', '李江海', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '005225', '王京立', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '012211', '朱从元', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '014215', '兰杨', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '015209', '过晓强', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '016209', '刘波', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '016215', '孙静秋', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '074203', '王兴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '094205', '华玉明', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0328', '普外科', '099225', '王珂', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '003211', '刘宗良', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '004214', '李航', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '005208', '张萍芳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '006209', '薛育政', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '007201', '沈效杰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '010213', '盛颖玥', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '010214', '杨晴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '010215', '余利华', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '010223', '林刚', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '011222', '王文远', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '012201', '吴燕敏', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '013202', '戴圆圆', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '014206', '夏蓓蕾', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '015208', '吴铁龙', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '090203', '韦毅', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0329', '消化内科', '093205', '周峰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0330', '内镜中心', '001216', '朱骊', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0330', '内镜中心', '072203', '俞宪明', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0330', '内镜中心', '095211', '林周', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '000209', '吴洁石', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '001214', '彭玮', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '001215', '徐瑞生', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '002213', '薛骏', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '007202', '王雪松', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '010224', '司志平', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '083206', '赵基栋', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '095210', '王刊石', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '096206', '赵磊', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '096211', '王立邦', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0332', '脊柱外科', '098205', '钱寒光', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '000213', '查涛', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '003214', '荆浩', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '005201', '王松华', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '007203', '吴红富', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '008212', '张健', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '013205', '杨志刚', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '014209', '叶俊星', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '016210', '杨晓斐', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '097210', '张斌', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '099217', '戴涟生', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0333', '骨关节外科', '099220', '程飞', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '001204', '朱佳尔', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '003202', '蔡良良', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '004201', '孙敏', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '005203', '濮莲芳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '011204', '糜媛媛', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '013203', '邱锜敏', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '016219', '张媛', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '085207', '李建新', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '086203', '蔡钱根', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '091207', '孙晓芳', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0335', '妇科', '092207', '华玉蓉', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '010207', '何晶', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '010208', '金友存', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '011203', '葛海艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '013213', '张小惠', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '013214', '何苗', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '014216', '谢绮', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '016216', '王佩佩', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '016665', '刘伟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '016676', '朱长巍', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '082203', '刘洪兴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '084206', '钱丹', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '089202', '虞蔚', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0336', '产科', '098203', '汤浩', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '000212', '周雪梅', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '004206', '赵光耀', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '009218', '胥会英', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '009405', '邵东', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '011205', '陈洁', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '012215', '王舒静', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '013625', '魏农', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '015216', '李果', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '016214', '邓敏超', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '016667', '郑琪', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '082206', '黄建萍', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '089203', '陈丽君', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '092208', '童晓', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '096207', '乔健', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0338', '儿科', '096208', '陆立东', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0339', '新生儿科', '007206', '仇午娴', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0339', '新生儿科', '015201', '陈涯', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0339', '新生儿科', '077206', '陈海平', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0340', '中医科', '009208', '苏强', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0340', '中医科', '010219', '朱春花', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0340', '中医科', '014207', '杜琰', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0340', '中医科', '077101', '戴建良', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0340', '中医科', '081206', '李小钢', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '008216', '徐静艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '010212', '李成', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '011209', '魏小丽', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '012209', '谢寅飞', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '013201', '阚俊微', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0341', '康复理疗科', '082101', '陆伟慧', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '001211', '张云', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '004204', '钱欣', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '005224', '蒋磊', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '007207', '王春芳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '009209', '史叶琴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '013220', '刘溢', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '015210', '凌丽琴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '016208', '汪村', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '071208', '肖锡英', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0342', '眼科', '081204', '卢江', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '003205', '龚明杰', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '004205', '周健', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '006202', '陈彧', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '009219', '宋俊', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '009220', '肖栋', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '011206', '沈帆', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '011207', '陈玉卿', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '012202', '闫飚', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '012217', '张义建', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '077205', '夏成忠', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '082207', '邹嘉平', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '092209', '张磊', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '098207', '李伟忠', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0343', '耳鼻咽喉科', '099203', '杨契超', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '005210', '季炼', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '006210', '吴苏宁', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '007204', '许海凤', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '007210', '周静艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '008203', '马红', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '009222', '曾参', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '010201', '盖云', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '011208', '朱房勇', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '012213', '成晓栋', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '013212', '曹彦南', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '015211', '顾云凯', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '084208', '邹建明', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '086205', '崔菊萍', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0344', '口腔科', '098214', '陈小虎', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '001213', '邹俊', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '002208', '邹军', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '002209', '高洁', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '002214', '丁娴', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '005223', '张宇', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '006206', '王岚', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '010209', '李倩', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '011210', '李莎', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '011211', '姜虹宇', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '012203', '叶雷', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '014217', '胡娜', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '014218', '毛洪雅', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '014674', '王明珠', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '015212', '宗嘉颖', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '091205', '陈肖', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '092204', '彭玉梅', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '093212', '顾丽莉', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '094210', '方明', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '094211', '华琪', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '095208', '张中军', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '096201', '李荣', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '097206', '毛倩倩', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '097207', '汪涛', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '098209', '华海峰', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0346', '麻醉科', '099210', '项舒玮', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '001206', '成岗', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '002219', '顾琛', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '007208', '杨飞', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '009401', '周怡婷', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '010220', '王鹏', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '011212', '吴清华', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '013403', '张猛', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '095401', '吴震海', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0372', '介入科', '096401', '李新胜', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0373', '普外科2', '006215', '杨敖霖', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0373', '普外科2', '013216', '龚龙伟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0373', '普外科2', '016228', '陆春雷', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0373', '普外科2', '016680', '吴涛', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0373', '普外科2', '016681', '葛晨', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0378', '风湿免疫科', '015205', '宋冬明', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0378', '风湿免疫科', '016201', '孙建', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0378', '风湿免疫科', '016664', '朱笑夏', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0378', '风湿免疫科', '016673', '刘敏黎', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0378', '风湿免疫科', '016677', '王方明', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '001202', '吴学明', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '004208', '苏衡', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '014224', '蔡文渊', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '016217', '刘倩', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '083203', '陶以嘉', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '097202', '施晶晶', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0383', '心血管内科2', '099213', '陈翀昊', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '003203', '陶杨', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '012210', '韩利坤', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '015204', '眭晨燕', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '092202', '孔亮', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '093203', '殷晓菁', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '095203', '顾俊泉', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0385', '神经内科2', '096210', '王挺刚', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '000206', '韩冬', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '000214', '谈晨', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '003204', '张雷', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '005206', '陆宇峰', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '005209', '陈科平', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '008215', '周萍', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '009211', '邓增', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '009212', '赵继来', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '009213', '李超生', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '010202', '腾名子', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '010211', '杨挺', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '011218', '黄铭', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '012207', '张君琳', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '013207', '李冬方', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '014204', '程小伟', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '014672', '徐东升', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '016226', '胡仕静', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '093204', '叶郁英', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0402', '急诊内科', '094202', '陈炜', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0412', '内科门诊', '078202', '温晋华', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0413', '心血管内科门诊', '079203', '臧蒙德', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0417', '内分泌科门诊', '073205', '高玉芬', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0420', '心理科门诊', '014902', '王志强', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0425', '门诊手术室', '079206', '周德泉', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0430', '消化科门诊', 'T95201', '陈布克', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0435', '消化内科门诊', '053900', '吴玉珍', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0439', '中医外科门诊', '000011', '诸曙夫', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0439', '中医外科门诊', '008221', '诸华健', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0442', '整形科门诊', '003208', '俞舜', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0442', '整形科门诊', '099224', '苏青和', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0449', '妇科门诊', '005200', '聂国瑛', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0449', '妇科门诊', '016805', '时燕萍', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0449', '妇科门诊', '070206', '徐惠琴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0449', '妇科门诊', '071204', '袁美琴', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0449', '妇科门诊', '072204', '计霞萍', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0450', '产科', '005216', '刘建文', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0450', '产科', '008202', '孙文艳', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0450', '产科', '009223', '吴蕴春', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0461', '皮肤科门诊', '003212', '曹志翔', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0461', '皮肤科门诊', '004202', '张佳音', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0461', '皮肤科门诊', '005205', '钟咪', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0461', '皮肤科门诊', '010210', '饶美荣', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0461', '皮肤科门诊', '014219', '曾芬', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0464', '中医内科门诊', '016801', '周晓虹', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0464', '中医内科门诊', '016802', '黄季伟', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0464', '中医内科门诊', '016804', '李小荣', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0481', '营养科门诊', '014679', '管崟', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0487', '中医内科专家', '016808', '丰衍增', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '002218', '堵红群', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '004406', '殷允娟', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '005214', '曹磊', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '009409', '付天鹏', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '010641', '韩明明', '', '', NULL, '未定级（技）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '011213', '刘群', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '012403', '乔红艳', '', '', NULL, '未定级（技）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '012404', '刘丽', '', '', NULL, '未定级（技）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '014221', '黄虹', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '014225', '邢炯', '', '', NULL, '技师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '014670', '周彬彬', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '015213', '朱玥', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '015650', '张淑明', '', '', NULL, '未定级（医）');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '016221', '陈素静', '', '', NULL, '技士');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '016655', '孙姚晨', '', '', NULL, '技士');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '085404', '姜建威', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '085405', '朱力平', '', '', NULL, '主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '086401', '李鹤松', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '094402', '蒋立伟', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '096403', '王均干', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '099204', '姜旭栋', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0512', '放射科', '099212', '唐健', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '004403', '蒋燕东', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '004404', '徐锦', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '005204', '马逸宜', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '009403', '王闽', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '009404', '朱嫣婷', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '012408', '过濛姣', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '094209', '刘小铭', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '097205', '朱栋晓', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '098401', '赵维群', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0527', 'B超室', '099403', '毛坚', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '004405', '胡锋', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '006204', '陈杰伟', '', '', NULL, '医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '010222', '倪成韵', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '011224', '崔传玉', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '082401', '王伊敏', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0529', '心电图室', '099404', '吴超', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '007205', '冯晓星', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '011214', '谢碧琛', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '015215', '杨瑾', '', '', NULL, '住院医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '084401', '朱明月', '', '', NULL, '副主任医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '092402', '茅青', '', '', NULL, '主治医师');
INSERT INTO `DoctorBasicInfo` VALUES ('0001', '0533', '病理科', '097401', '魏喆强', '', '', NULL, '主治医师');

-- --------------------------------------------------------

-- 
-- 表的结构 `FavoriteDoctors`
-- 

CREATE TABLE `FavoriteDoctors` (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `deptCode` char(10) NOT NULL COMMENT '科室代码',
  `deptName` varchar(50) NOT NULL COMMENT '科室名称',
  `doctorCode` char(10) NOT NULL COMMENT '医生代码',
  `doctorName` varchar(50) NOT NULL COMMENT '医生姓名',
  `insertTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`userId`,`deptCode`,`doctorCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生收藏表';

-- 
-- 导出表中的数据 `FavoriteDoctors`
-- 

INSERT INTO `FavoriteDoctors` VALUES (2, '0001', '耳鼻喉科', '0001', '张承明', '2017-02-10 13:46:29');
INSERT INTO `FavoriteDoctors` VALUES (2, '0001', '耳鼻喉科', '0002', '李黎', '2017-02-10 13:46:28');
INSERT INTO `FavoriteDoctors` VALUES (2, '0003', '风湿科', '0005', '吴冉', '2017-01-20 16:43:14');
INSERT INTO `FavoriteDoctors` VALUES (2, '0007', '骨伤科', '0013', '朱宜', '2017-01-20 16:41:38');
INSERT INTO `FavoriteDoctors` VALUES (17, '0001', '耳鼻喉科', '0001', '张承明', '2017-02-03 13:25:36');
INSERT INTO `FavoriteDoctors` VALUES (17, '0001', '耳鼻喉科', '0002', '李黎', '2017-01-23 17:48:13');
INSERT INTO `FavoriteDoctors` VALUES (17, '0003', '风湿科', '0006', '李帆帆', '2017-01-20 17:10:42');
INSERT INTO `FavoriteDoctors` VALUES (17, '0005', '妇科', '0009', '夏蔚成', '2017-01-23 09:25:24');

-- --------------------------------------------------------

-- 
-- 表的结构 `HospitalCardInfo`
-- 

CREATE TABLE `HospitalCardInfo` (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `jiuzhenkahao` varchar(25) NOT NULL COMMENT '就诊卡号',
  `insertTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`userId`,`jiuzhenkahao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='就诊卡绑定表';

-- 
-- 导出表中的数据 `HospitalCardInfo`
-- 

INSERT INTO `HospitalCardInfo` VALUES (2, '12345678901234567', '2017-02-11 20:22:18');
INSERT INTO `HospitalCardInfo` VALUES (17, '55988423333333333333', '2017-01-25 13:46:35');

-- --------------------------------------------------------

-- 
-- 表的结构 `MedicareCardInfo`
-- 

CREATE TABLE `MedicareCardInfo` (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `yibaokahao` varchar(25) NOT NULL COMMENT '医保卡号',
  `insertTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`userId`,`yibaokahao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医保卡绑定表';

-- 
-- 导出表中的数据 `MedicareCardInfo`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `OrderInfo`
-- 

CREATE TABLE `OrderInfo` (
  `orderId` varchar(30) NOT NULL,
  `orderRefType` char(1) NOT NULL,
  `orderRefSeqNo` char(20) NOT NULL,
  `userId` bigint(19) NOT NULL,
  `orderFee` double(10,2) NOT NULL,
  `payFee` double(10,2) NOT NULL,
  `orderdatetime` varchar(30) NOT NULL,
  `orderStatus` char(1) NOT NULL,
  `loginTime` varchar(30) NOT NULL DEFAULT '9999',
  `loginUser` bigint(19) NOT NULL,
  `updateTime` varchar(30) NOT NULL DEFAULT '9999',
  `updateUser` bigint(19) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `OrderInfo`
-- 

INSERT INTO `OrderInfo` VALUES ('20170217173942192000', '2', '1234567', 17, 500.23, 500.23, '2017-02-17 17:39:42.191', '0', '2017-02-17 17:39:42.191', 17, '2017-02-17 17:39:42.191', 17);

-- --------------------------------------------------------

-- 
-- 表的结构 `PatientsHospitalized`
-- 

CREATE TABLE `PatientsHospitalized` (
  `stayNo` char(20) NOT NULL COMMENT '住院单号',
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `hospitalCode` char(10) NOT NULL COMMENT '医院ID',
  `deptCode` char(10) NOT NULL COMMENT '科室ID',
  `doctorCode` char(10) NOT NULL COMMENT '医生ID',
  `nurseCode` char(10) NOT NULL COMMENT '护士ID',
  `diagnoseInfo` varchar(255) DEFAULT NULL COMMENT '诊断信息',
  `area` varchar(80) DEFAULT NULL COMMENT '病区',
  `bed` varchar(80) DEFAULT NULL COMMENT '病床',
  `inDate` date NOT NULL COMMENT '入院时间',
  `outDate` date DEFAULT NULL COMMENT '出院时间',
  `advancedPay` double DEFAULT NULL COMMENT '预缴费',
  `supplementaryPay` double DEFAULT NULL COMMENT '补缴费',
  `returnPay` double DEFAULT NULL COMMENT '退费',
  `statusFlg` char(1) NOT NULL COMMENT '状态Flag	 0:未入院，1:已在院，2：已出院',
  `validFlg` char(1) NOT NULL COMMENT '有效Flag',
  `commentInfo` varchar(255) DEFAULT NULL COMMENT '备考',
  PRIMARY KEY (`stayNo`,`userId`,`hospitalCode`,`deptCode`,`doctorCode`,`nurseCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='住院信息';

-- 
-- 导出表中的数据 `PatientsHospitalized`
-- 

INSERT INTO `PatientsHospitalized` VALUES ('2266551', 1, '0001', '0001', '0002', '0001', '急性心脏病', '7病区', NULL, '2017-01-03', NULL, 15000, NULL, NULL, '0', '1', NULL);
INSERT INTO `PatientsHospitalized` VALUES ('2266552', 1, '0001', '0001', '0002', '0001', '急性鼻炎', '6病区', '6号床', '2016-11-06', '2016-12-29', 10000, NULL, NULL, '1', '1', NULL);
INSERT INTO `PatientsHospitalized` VALUES ('2277803', 1, '0001', '0001', '0002', '0001', '急性胃炎', '5病区', '6号床', '2016-09-07', '2016-10-05', 9800, NULL, NULL, '2', '1', NULL);

-- --------------------------------------------------------

-- 
-- 表的结构 `PaymentDetail`
-- 

CREATE TABLE `PaymentDetail` (
  `paymentNo` varchar(19) NOT NULL COMMENT '缴费单号',
  `paymentDetailNo` int(10) unsigned NOT NULL COMMENT '明细SEQ',
  `orderFee` double(22,0) NOT NULL COMMENT '商户订单金额',
  `payFee` double(22,0) NOT NULL COMMENT '订单实际支付金额',
  `payType` char(2) NOT NULL COMMENT '支付方式',
  `orderDateTime` datetime NOT NULL COMMENT '商户订单提交时间',
  `extPayResultCode` varchar(10) DEFAULT NULL COMMENT '外部支付结果',
  `extPayResultMsg` varchar(200) DEFAULT NULL COMMENT '外部支付结果详细',
  `paymentSuccessDateTime` datetime DEFAULT NULL COMMENT '外部支付成功时间',
  `extPaymentId` char(20) DEFAULT NULL COMMENT '外部支付流水号',
  `paymentStatus` char(2) NOT NULL COMMENT '支付状态',
  `loginTime` datetime NOT NULL COMMENT '登录时间',
  `loginUser` varchar(19) NOT NULL COMMENT '登录者',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `updateUser` varchar(19) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`paymentNo`,`paymentDetailNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `PaymentDetail`
-- 

INSERT INTO `PaymentDetail` VALUES ('117022218260584002', 1, 10, 10, '01', '2017-02-22 18:26:11', '0000', '交易成功', '2017-02-22 18:27:14', '20170222182632200845', '20', '2017-02-22 18:26:11', '2', '2017-02-22 18:26:11', '2');
INSERT INTO `PaymentDetail` VALUES ('117022218575619100', 1, 10, 10, '01', '2017-02-22 18:58:00', '0000', '交易成功', '2017-02-22 18:59:43', '20170222185943200850', '20', '2017-02-22 18:58:00', '25', '2017-02-22 18:58:00', '25');
INSERT INTO `PaymentDetail` VALUES ('117022310554962600', 1, 10, 10, '01', '2017-02-23 10:56:23', NULL, NULL, NULL, NULL, '00', '2017-02-23 10:56:24', '29', '2017-02-23 10:56:24', '29');
INSERT INTO `PaymentDetail` VALUES ('217022215164665101', 1, 4000, 4000, '01', '2017-02-22 15:16:46', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:16:47', '17', '2017-02-22 15:16:47', '17');
INSERT INTO `PaymentDetail` VALUES ('217022215204958402', 1, 500, 500, '01', '2017-02-22 15:20:49', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:20:50', '17', '2017-02-22 15:20:50', '17');
INSERT INTO `PaymentDetail` VALUES ('217022215281159103', 1, 500, 500, '01', '2017-02-22 15:28:11', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:28:12', '17', '2017-02-22 15:28:12', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216024053604', 1, 4000, 4000, '01', '2017-02-22 16:02:40', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 16:02:41', '17', '2017-02-22 16:02:41', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216053931105', 1, 500, 500, '01', '2017-02-22 16:05:39', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 16:05:39', '17', '2017-02-22 16:05:39', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216201510910', 1, 1000, 1000, '01', '2017-02-22 16:20:15', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:20:16', '17', '2017-02-22 16:20:16', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216260638611', 1, 500, 500, '01', '2017-02-22 16:26:06', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:26:07', '17', '2017-02-22 16:26:07', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216264598312', 1, 1000, 1000, '01', '2017-02-22 16:26:46', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:26:46', '17', '2017-02-22 16:26:46', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216271136913', 1, 1000, 1000, '01', '2017-02-22 16:27:11', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:27:12', '17', '2017-02-22 16:27:12', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216275574114', 1, 1000, 1000, '01', '2017-02-22 16:27:56', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:27:56', '17', '2017-02-22 16:27:56', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216283992115', 1, 4000, 4000, '01', '2017-02-22 16:28:40', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:28:40', '17', '2017-02-22 16:28:40', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216290742616', 1, 1000, 1000, '01', '2017-02-22 16:29:07', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:29:07', '17', '2017-02-22 16:29:07', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216303339217', 1, 500, 500, '01', '2017-02-22 16:30:33', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:30:34', '17', '2017-02-22 16:30:34', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216310886518', 1, 4000, 4000, '01', '2017-02-22 16:31:09', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:31:09', '17', '2017-02-22 16:31:09', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216312362519', 1, 500, 500, '01', '2017-02-22 16:31:24', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:31:24', '17', '2017-02-22 16:31:24', '17');
INSERT INTO `PaymentDetail` VALUES ('217022216552476720', 1, 500, 500, '01', '2017-02-22 16:55:25', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 16:55:25', '17', '2017-02-22 16:55:25', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217113460621', 1, 500, 500, '01', '2017-02-22 17:11:35', NULL, NULL, NULL, NULL, '00', '2017-02-22 17:11:35', '17', '2017-02-22 17:11:35', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217124635222', 1, 500, 500, '01', '2017-02-22 17:12:46', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 17:12:47', '17', '2017-02-22 17:12:47', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217162182100', 1, 1000, 1000, '01', '2017-02-22 17:16:21', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 17:16:22', '17', '2017-02-22 17:16:22', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217174036400', 1, 500, 500, '01', '2017-02-22 17:17:40', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 17:17:40', '17', '2017-02-22 17:17:40', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217204998300', 1, 500, 500, '01', '2017-02-22 17:20:50', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 17:20:50', '17', '2017-02-22 17:20:50', '17');
INSERT INTO `PaymentDetail` VALUES ('217022217212160501', 1, 500, 500, '01', '2017-02-22 17:21:21', '0001', '用户主动放弃订单支付！', NULL, NULL, '10', '2017-02-22 17:21:22', '17', '2017-02-22 17:21:22', '17');
INSERT INTO `PaymentDetail` VALUES ('217022218305216703', 1, 500, 500, '01', '2017-02-22 18:30:52', '0000', '交易成功', '2017-02-22 18:31:03', '20170222183056200846', '20', '2017-02-22 18:30:52', '2', '2017-02-22 18:30:52', '2');
INSERT INTO `PaymentDetail` VALUES ('317022215161974100', 1, 200, 200, '01', '2017-02-22 15:16:24', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:16:25', '2', '2017-02-22 15:16:25', '2');
INSERT INTO `PaymentDetail` VALUES ('317022215450011101', 1, 200, 200, '01', '2017-02-22 15:45:04', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:45:04', '2', '2017-02-22 15:45:04', '2');
INSERT INTO `PaymentDetail` VALUES ('317022215461406002', 1, 200, 200, '01', '2017-02-22 15:46:21', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:46:21', '2', '2017-02-22 15:46:21', '2');
INSERT INTO `PaymentDetail` VALUES ('317022215521088600', 1, 200, 200, '01', '2017-02-22 15:52:17', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:52:18', '2', '2017-02-22 15:52:18', '2');
INSERT INTO `PaymentDetail` VALUES ('317022215552825601', 1, 200, 200, '01', '2017-02-22 15:55:28', NULL, NULL, NULL, NULL, '00', '2017-02-22 15:55:28', '2', '2017-02-22 15:55:28', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216051435802', 1, 200, 200, '01', '2017-02-22 16:05:15', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:05:16', '2', '2017-02-22 16:05:16', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216141143006', 1, 200, 200, '01', '2017-02-22 16:14:11', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:14:11', '2', '2017-02-22 16:14:11', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216174655207', 1, 200, 200, '01', '2017-02-22 16:17:46', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:17:47', '2', '2017-02-22 16:17:47', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216230894208', 1, 200, 200, '01', '2017-02-22 16:23:10', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:23:10', '2', '2017-02-22 16:23:10', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216250733010', 1, 200, 200, '01', '2017-02-22 16:25:07', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:25:07', '2', '2017-02-22 16:25:07', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216261659311', 1, 200, 200, '01', '2017-02-22 16:26:17', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:26:18', '2', '2017-02-22 16:26:18', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216324447112', 1, 200, 200, '01', '2017-02-22 16:32:45', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:32:46', '2', '2017-02-22 16:32:46', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216402676813', 1, 200, 200, '01', '2017-02-22 16:40:27', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 16:40:27', '2', '2017-02-22 16:40:27', '2');
INSERT INTO `PaymentDetail` VALUES ('317022216414350714', 1, 200, 200, '01', '2017-02-22 16:41:44', NULL, NULL, NULL, NULL, '00', '2017-02-22 16:41:44', '2', '2017-02-22 16:41:44', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217071358115', 1, 200, 200, '01', '2017-02-22 17:07:14', '0000', '交易成功', NULL, NULL, '10', '2017-02-22 17:07:14', '2', '2017-02-22 17:07:14', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217244532200', 1, 200, 200, '01', '2017-02-22 17:24:45', NULL, NULL, NULL, NULL, '00', '2017-02-22 17:24:46', '2', '2017-02-22 17:24:46', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217255615302', 1, 200, 200, '01', '2017-02-22 17:25:57', NULL, NULL, NULL, NULL, '00', '2017-02-22 17:25:57', '2', '2017-02-22 17:25:57', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217294685003', 1, 200, 200, '01', '2017-02-22 17:29:47', NULL, NULL, NULL, NULL, '00', '2017-02-22 17:29:47', '2', '2017-02-22 17:29:47', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217320344904', 1, 200, 200, '01', '2017-02-22 17:32:03', '0000', '交易成功', '2017-02-22 17:32:07', '20170222173206200833', '20', '2017-02-22 17:32:03', '2', '2017-02-22 17:32:03', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217393873705', 1, 200, 200, '01', '2017-02-22 17:39:38', '0000', '交易成功', '2017-02-22 17:39:42', '20170222173941200834', '20', '2017-02-22 17:39:39', '2', '2017-02-22 17:39:39', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217413406500', 1, 200, 200, '01', '2017-02-22 17:41:34', '0000', '交易成功', '2017-02-22 17:41:37', '20170222174136200835', '20', '2017-02-22 17:41:34', '2', '2017-02-22 17:41:34', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217472125200', 1, 200, 200, '01', '2017-02-22 17:47:21', '0000', '交易成功', '2017-02-22 17:47:26', '20170222174725200836', '20', '2017-02-22 17:47:21', '2', '2017-02-22 17:47:21', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217491139101', 1, 200, 200, '01', '2017-02-22 17:49:11', '0000', '交易成功', '2017-02-22 17:49:40', '20170222174937200838', '20', '2017-02-22 17:49:11', '2', '2017-02-22 17:49:11', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217552093200', 1, 200, 200, '01', '2017-02-22 17:55:20', '0000', '交易成功', '2017-02-22 17:55:25', '20170222175524200839', '20', '2017-02-22 17:55:21', '2', '2017-02-22 17:55:21', '2');
INSERT INTO `PaymentDetail` VALUES ('317022217594985501', 1, 200, 200, '01', '2017-02-22 17:59:50', '0000', '交易成功', '2017-02-22 17:59:55', '20170222175954200840', '20', '2017-02-22 17:59:50', '2', '2017-02-22 17:59:50', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218031458703', 1, 200, 200, '01', '2017-02-22 18:03:14', '0000', '交易成功', '2017-02-22 18:03:38', '20170222180337200841', '20', '2017-02-22 18:03:15', '2', '2017-02-22 18:03:15', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218064874004', 1, 200, 200, '01', '2017-02-22 18:06:49', '0000', '交易成功', '2017-02-22 18:06:54', '20170222180653200842', '20', '2017-02-22 18:06:49', '2', '2017-02-22 18:06:49', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218204857700', 1, 200, 200, '01', '2017-02-22 18:20:49', '0000', '交易成功', '2017-02-22 18:20:52', '20170222182051200843', '20', '2017-02-22 18:20:49', '2', '2017-02-22 18:20:49', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218241261701', 1, 200, 200, '01', '2017-02-22 18:24:12', '0000', '交易成功', '2017-02-22 18:24:16', '20170222182415200844', '20', '2017-02-22 18:24:13', '2', '2017-02-22 18:24:13', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218315529305', 1, 60, 60, '01', '2017-02-22 18:31:55', '0000', '交易成功', '2017-02-22 18:32:05', '20170222183202200847', '20', '2017-02-22 18:31:55', '2', '2017-02-22 18:31:55', '2');
INSERT INTO `PaymentDetail` VALUES ('317022218330633800', 1, 200, 200, '01', '2017-02-22 18:33:06', '0000', '交易成功', '2017-02-22 18:33:10', '20170222183309200848', '20', '2017-02-22 18:33:07', '2', '2017-02-22 18:33:07', '2');

-- --------------------------------------------------------

-- 
-- 表的结构 `PaymentRecord`
-- 

CREATE TABLE `PaymentRecord` (
  `paymentNo` bigint(20) unsigned NOT NULL COMMENT '缴费单号',
  `paymentRefType` char(1) NOT NULL COMMENT '缴费来源',
  `userID` bigint(19) unsigned NOT NULL COMMENT '用户ID',
  `departmentName` varchar(64) NOT NULL COMMENT '科室名称',
  `doctorName` varchar(64) DEFAULT NULL COMMENT '医生名称',
  `paymentName` varchar(32) NOT NULL COMMENT '缴费项名称',
  `orderFee` double(22,0) NOT NULL COMMENT '商户订单金额',
  `payFee` double(22,0) DEFAULT NULL COMMENT '实际支付金额',
  `orderDateTime` datetime DEFAULT NULL COMMENT '商户订单提交时间',
  `medicalInsuranceAmount` double(22,0) NOT NULL COMMENT '医保部分金额',
  `medicalselfAmount` double(22,0) NOT NULL COMMENT '自费部分金额',
  `paidDate` datetime DEFAULT NULL COMMENT '缴费完成日期',
  `paidState` char(1) NOT NULL COMMENT '缴费完成状态',
  `orderType` char(1) NOT NULL COMMENT '订单类型',
  `paymentNotice` char(1) NOT NULL COMMENT '支付通知',
  `hisOrdNum` bigint(19) unsigned NOT NULL COMMENT '缴费来源流水号',
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `loginUser` varchar(19) NOT NULL COMMENT '登录者',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `updateUser` varchar(19) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`paymentNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `PaymentRecord`
-- 

INSERT INTO `PaymentRecord` VALUES (117022111085551100, '2', 17, '内科', '', '住院押金补缴 ', 524, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 11:38:06', '17', '2017-02-21 11:08:56', '17');
INSERT INTO `PaymentRecord` VALUES (117022114144492301, '2', 17, '内科', '', '住院押金补缴 ', 700, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:14:45', '17', '2017-02-21 14:14:45', '17');
INSERT INTO `PaymentRecord` VALUES (117022114173815302, '2', 17, '内科', '', '住院押金补缴 ', 800, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:17:38', '17', '2017-02-21 14:17:38', '17');
INSERT INTO `PaymentRecord` VALUES (117022114205849103, '2', 17, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:20:58', '17', '2017-02-21 14:20:58', '17');
INSERT INTO `PaymentRecord` VALUES (117022114330888004, '2', 17, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:33:09', '17', '2017-02-21 14:33:09', '17');
INSERT INTO `PaymentRecord` VALUES (117022114362620405, '2', 17, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:36:26', '17', '2017-02-21 14:36:26', '17');
INSERT INTO `PaymentRecord` VALUES (117022114553511602, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:35', '24', '2017-02-21 14:55:35', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554029703, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:40', '24', '2017-02-21 14:55:40', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554140104, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:41', '24', '2017-02-21 14:55:41', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554160805, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:42', '24', '2017-02-21 14:55:42', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554181506, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:42', '24', '2017-02-21 14:55:42', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554233107, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:42', '24', '2017-02-21 14:55:42', '24');
INSERT INTO `PaymentRecord` VALUES (117022114554257808, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:55:43', '24', '2017-02-21 14:55:43', '24');
INSERT INTO `PaymentRecord` VALUES (117022114562378000, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:41:10', '2', '2017-02-22 13:41:10', '2');
INSERT INTO `PaymentRecord` VALUES (117022114585599109, '2', 24, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 14:58:56', '24', '2017-02-21 14:58:56', '24');
INSERT INTO `PaymentRecord` VALUES (117022115155013902, '2', 17, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 15:15:50', '17', '2017-02-21 15:15:50', '17');
INSERT INTO `PaymentRecord` VALUES (117022115382014500, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 15:38:20', '2', '2017-02-21 15:38:20', '2');
INSERT INTO `PaymentRecord` VALUES (117022115411355301, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 15:41:14', '2', '2017-02-21 15:41:14', '2');
INSERT INTO `PaymentRecord` VALUES (117022115495032700, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 15:49:50', '2', '2017-02-21 15:49:50', '2');
INSERT INTO `PaymentRecord` VALUES (117022115510544801, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 15:51:05', '2', '2017-02-21 15:51:05', '2');
INSERT INTO `PaymentRecord` VALUES (117022116323202002, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 16:32:32', '2', '2017-02-21 16:32:32', '2');
INSERT INTO `PaymentRecord` VALUES (117022116383284600, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-21 18:04:01', '2', '2017-02-21 18:04:01', '2');
INSERT INTO `PaymentRecord` VALUES (117022116473917900, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 11:27:36', '2', '2017-02-22 11:27:36', '2');
INSERT INTO `PaymentRecord` VALUES (117022117423744700, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:41:14', '2', '2017-02-22 13:41:14', '2');
INSERT INTO `PaymentRecord` VALUES (117022117514996201, '2', 17, '内科', '', '住院押金补缴', 2000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 17:51:50', '17', '2017-02-21 17:51:50', '17');
INSERT INTO `PaymentRecord` VALUES (117022118452578600, '2', 2, '内科', '', '住院押金补缴 ', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 18:45:26', '2', '2017-02-21 18:45:26', '2');
INSERT INTO `PaymentRecord` VALUES (117022122272975602, '2', 25, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-21 22:27:30', '25', '2017-02-21 22:27:30', '25');
INSERT INTO `PaymentRecord` VALUES (117022208464493800, '2', 2, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 08:46:45', '2', '2017-02-22 08:46:45', '2');
INSERT INTO `PaymentRecord` VALUES (117022208472946601, '2', 2, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 08:47:29', '2', '2017-02-22 08:47:29', '2');
INSERT INTO `PaymentRecord` VALUES (117022208561242202, '2', 2, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 08:56:12', '2', '2017-02-22 08:56:12', '2');
INSERT INTO `PaymentRecord` VALUES (117022208574195400, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 08:57:42', '17', '2017-02-22 08:57:42', '17');
INSERT INTO `PaymentRecord` VALUES (117022210295932700, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 10:30:04', '2', '2017-02-22 10:30:04', '2');
INSERT INTO `PaymentRecord` VALUES (117022211281860400, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 11:28:21', '2', '2017-02-22 11:28:21', '2');
INSERT INTO `PaymentRecord` VALUES (117022211375974207, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 11:46:40', '2', '2017-02-22 11:46:40', '2');
INSERT INTO `PaymentRecord` VALUES (117022211391662910, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 11:39:18', '29', '2017-02-22 11:39:18', '29');
INSERT INTO `PaymentRecord` VALUES (117022211470009911, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 11:47:03', '29', '2017-02-22 11:47:03', '29');
INSERT INTO `PaymentRecord` VALUES (117022213082360800, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:08:26', '29', '2017-02-22 13:08:26', '29');
INSERT INTO `PaymentRecord` VALUES (117022213180561903, '2', 17, '内科', '', '住院押金补缴', 620, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 13:18:06', '17', '2017-02-22 13:18:06', '17');
INSERT INTO `PaymentRecord` VALUES (117022213252811301, '1', 29, '产科', '吴蕴春', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:25:32', '29', '2017-02-22 13:25:32', '29');
INSERT INTO `PaymentRecord` VALUES (117022213282411300, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:43:13', '2', '2017-02-22 13:43:13', '2');
INSERT INTO `PaymentRecord` VALUES (117022213315731401, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:31:59', '2', '2017-02-22 13:31:59', '2');
INSERT INTO `PaymentRecord` VALUES (117022213361917602, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:36:24', '2', '2017-02-22 13:36:24', '2');
INSERT INTO `PaymentRecord` VALUES (117022213363818503, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:36:49', '2', '2017-02-22 13:36:49', '2');
INSERT INTO `PaymentRecord` VALUES (117022213450602700, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:45:08', '2', '2017-02-22 13:45:08', '2');
INSERT INTO `PaymentRecord` VALUES (117022213594407600, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 13:59:47', '29', '2017-02-22 13:59:47', '29');
INSERT INTO `PaymentRecord` VALUES (117022214023478101, '2', 17, '内科', '', '住院押金补缴', 770, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 14:02:35', '17', '2017-02-22 14:02:35', '17');
INSERT INTO `PaymentRecord` VALUES (117022214043355201, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-22 14:04:36', '29', '2017-02-22 14:04:36', '29');
INSERT INTO `PaymentRecord` VALUES (117022215322500500, '2', 1, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 15:32:25', '1', '2017-02-22 15:32:25', '1');
INSERT INTO `PaymentRecord` VALUES (117022218260584002, '1', 2, '产科', '刘建文', '挂号缴费 ', 10, 10, '2017-02-22 18:26:11', 0, 0, '2017-02-22 18:27:14', '1', '1', '1', 922525, '2017-02-22 18:25:36', '2', '2017-02-22 18:26:11', '2');
INSERT INTO `PaymentRecord` VALUES (117022218575619100, '1', 25, '产科', '刘建文', '挂号缴费 ', 10, 10, '2017-02-22 18:58:00', 0, 0, '2017-02-22 18:59:43', '1', '1', '1', 922525, '2017-02-22 18:57:59', '25', '2017-02-22 18:58:00', '25');
INSERT INTO `PaymentRecord` VALUES (117022310554962600, '1', 29, '产科', '刘建文', '挂号缴费 ', 10, NULL, NULL, 0, 0, NULL, '0', '1', '0', 922525, '2017-02-23 10:56:24', '29', '2017-02-23 10:56:24', '29');
INSERT INTO `PaymentRecord` VALUES (217022215164665101, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 15:16:47', '17', '2017-02-22 15:16:47', '17');
INSERT INTO `PaymentRecord` VALUES (217022215204958402, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 15:20:50', '17', '2017-02-22 15:20:50', '17');
INSERT INTO `PaymentRecord` VALUES (217022215281159103, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 15:28:12', '17', '2017-02-22 15:28:12', '17');
INSERT INTO `PaymentRecord` VALUES (217022216024053604, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:02:41', '17', '2017-02-22 16:02:41', '17');
INSERT INTO `PaymentRecord` VALUES (217022216053931105, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:05:39', '17', '2017-02-22 16:05:39', '17');
INSERT INTO `PaymentRecord` VALUES (217022216153586606, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:15:36', '17', '2017-02-22 16:15:36', '17');
INSERT INTO `PaymentRecord` VALUES (217022216155873207, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:15:59', '17', '2017-02-22 16:15:59', '17');
INSERT INTO `PaymentRecord` VALUES (217022216165812108, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:16:58', '17', '2017-02-22 16:16:58', '17');
INSERT INTO `PaymentRecord` VALUES (217022216194154109, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:19:42', '17', '2017-02-22 16:19:42', '17');
INSERT INTO `PaymentRecord` VALUES (217022216201510910, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:20:15', '17', '2017-02-22 16:20:15', '17');
INSERT INTO `PaymentRecord` VALUES (217022216260638611, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:26:06', '17', '2017-02-22 16:26:06', '17');
INSERT INTO `PaymentRecord` VALUES (217022216264598312, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:26:46', '17', '2017-02-22 16:26:46', '17');
INSERT INTO `PaymentRecord` VALUES (217022216271136913, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:27:11', '17', '2017-02-22 16:27:11', '17');
INSERT INTO `PaymentRecord` VALUES (217022216275574114, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:27:56', '17', '2017-02-22 16:27:56', '17');
INSERT INTO `PaymentRecord` VALUES (217022216283992115, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:28:40', '17', '2017-02-22 16:28:40', '17');
INSERT INTO `PaymentRecord` VALUES (217022216290742616, '2', 17, '内科', '', '住院押金补缴', 1000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:29:07', '17', '2017-02-22 16:29:07', '17');
INSERT INTO `PaymentRecord` VALUES (217022216303339217, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:30:33', '17', '2017-02-22 16:30:33', '17');
INSERT INTO `PaymentRecord` VALUES (217022216310886518, '2', 17, '内科', '', '住院押金补缴', 4000, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:31:09', '17', '2017-02-22 16:31:09', '17');
INSERT INTO `PaymentRecord` VALUES (217022216312362519, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 16:31:24', '17', '2017-02-22 16:31:24', '17');
INSERT INTO `PaymentRecord` VALUES (217022216552476720, '2', 17, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 16:55:25', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 16:53:43', '17', '2017-02-22 16:55:25', '17');
INSERT INTO `PaymentRecord` VALUES (217022217113460621, '2', 17, '内科', '', '住院押金补缴', 500, NULL, NULL, 0, 0, NULL, '0', '1', '0', 1566320, '2017-02-22 17:11:35', '17', '2017-02-22 17:11:35', '17');
INSERT INTO `PaymentRecord` VALUES (217022217124635222, '2', 17, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 17:12:46', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 17:11:03', '17', '2017-02-22 17:12:47', '17');
INSERT INTO `PaymentRecord` VALUES (217022217162182100, '2', 17, '内科', '', '住院押金补缴', 1000, 1000, '2017-02-22 17:16:21', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 17:14:37', '17', '2017-02-22 17:16:22', '17');
INSERT INTO `PaymentRecord` VALUES (217022217174036400, '2', 17, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 17:17:40', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 17:15:56', '17', '2017-02-22 17:17:40', '17');
INSERT INTO `PaymentRecord` VALUES (217022217204998300, '2', 17, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 17:20:50', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 17:19:06', '17', '2017-02-22 17:20:50', '17');
INSERT INTO `PaymentRecord` VALUES (217022217212160501, '2', 17, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 17:21:21', 0, 0, NULL, '1', '1', '0', 1566320, '2017-02-22 17:19:37', '17', '2017-02-22 17:21:22', '17');
INSERT INTO `PaymentRecord` VALUES (217022218305216703, '2', 2, '内科', '', '住院押金补缴', 500, 500, '2017-02-22 18:30:52', 0, 0, '2017-02-22 18:31:03', '1', '1', '1', 1566320, '2017-02-22 18:29:24', '2', '2017-02-22 18:30:52', '2');
INSERT INTO `PaymentRecord` VALUES (317022218315529305, '1', 2, '耳鼻喉科', '沈帆', '挂号费', 60, 60, '2017-02-22 18:31:55', 0, 0, '2017-02-22 18:32:05', '1', '1', '1', 8261124, '2017-02-22 18:30:20', '2', '2017-02-22 18:31:55', '2');
INSERT INTO `PaymentRecord` VALUES (317022218330633800, '3', 2, '内科', '王大生', '诊疗费', 200, 200, '2017-02-22 18:33:06', 0, 200, '2017-02-22 18:33:10', '1', '1', '1', 8261133, '2017-02-22 18:31:34', '2', '2017-02-22 18:33:07', '2');

-- --------------------------------------------------------

-- 
-- 表的结构 `PersonPaymentInfo`
-- 

CREATE TABLE `PersonPaymentInfo` (
  `userID` bigint(19) NOT NULL COMMENT '用户ID',
  `diagnosisCardNo` char(10) DEFAULT NULL COMMENT '诊疗卡号',
  `socailSecurityCardNo` char(16) DEFAULT NULL COMMENT '社保卡号',
  `medicareCardNo` char(10) DEFAULT NULL COMMENT '医保卡号',
  `healthCardNo` char(10) DEFAULT NULL COMMENT '健康卡号',
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `loginUser` varchar(19) NOT NULL COMMENT '登录者',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updateUser` varchar(19) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `PersonPaymentInfo`
-- 

INSERT INTO `PersonPaymentInfo` VALUES (2, '3300635425', NULL, NULL, NULL, '2017-02-17 11:21:22', '测试帐号', '2017-02-17 11:21:22', '测试帐号');
INSERT INTO `PersonPaymentInfo` VALUES (24, '3300635425', NULL, NULL, NULL, '2017-02-21 14:48:01', '李桐', '2017-02-21 14:48:01', '李桐');
INSERT INTO `PersonPaymentInfo` VALUES (25, '3300635425', NULL, NULL, NULL, '2017-02-21 22:17:47', '郑超', '2017-02-21 22:17:47', '郑超');
INSERT INTO `PersonPaymentInfo` VALUES (29, '3300635425', NULL, NULL, NULL, '2017-02-22 11:31:22', '卢德美', '2017-02-22 11:31:22', '卢德美');

-- --------------------------------------------------------

-- 
-- 表的结构 `RegisterHistory`
-- 

CREATE TABLE `RegisterHistory` (
  `registerNo` char(21) NOT NULL COMMENT '挂号单号',
  `userID` bigint(19) NOT NULL COMMENT '用户ID',
  `hospitalCode` char(19) NOT NULL COMMENT '医院CD',
  `departmentCode` char(19) NOT NULL COMMENT '科室CD',
  `doctorCode` char(19) NOT NULL COMMENT '医生CD',
  `registerDate` date NOT NULL COMMENT '预约日期',
  `happenDate` date NOT NULL COMMENT '就诊日期',
  `happenPeriod` char(1) NOT NULL COMMENT '时段（1：上午 2：下午 3：晚上 4：全天）',
  `registerFee` double NOT NULL COMMENT '挂号费',
  `returnOrderNo` varchar(19) DEFAULT NULL COMMENT '退费单号',
  `stopFlag` char(1) NOT NULL DEFAULT '0' COMMENT '停诊区分（0：正常 1：停诊）',
  `hisOrdNum` char(19) NOT NULL COMMENT '医院订单号',
  `registerStatus` char(1) NOT NULL DEFAULT '0' COMMENT '挂号状态（0：预约成功 1：预约取消）',
  `serialNum` varchar(40) DEFAULT NULL COMMENT '就诊序列',
  `visitPosition` varchar(200) DEFAULT NULL COMMENT '就诊位置',
  `loginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `loginUser` varchar(19) NOT NULL COMMENT '登录者',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `updateUser` varchar(19) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`registerNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `RegisterHistory`
-- 

INSERT INTO `RegisterHistory` VALUES ('117022112111163900', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:50', '测试帐号', '2017-02-21 16:43:50', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022114532897400', 24, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:51', '李桐', '2017-02-21 16:43:51', '李桐');
INSERT INTO `RegisterHistory` VALUES ('117022114551418301', 24, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:52', '李桐', '2017-02-21 16:43:52', '李桐');
INSERT INTO `RegisterHistory` VALUES ('117022114562378000', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:53', '测试帐号', '2017-02-21 16:43:53', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022116383284600', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:53', '测试帐号', '2017-02-21 16:43:53', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022116473917900', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-21 16:45:53', '测试帐号', '2017-02-21 16:45:53', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022117423744700', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-21 17:40:51', '测试帐号', '2017-02-21 17:40:51', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022117573915400', 2, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-21 17:55:53', '测试帐号', '2017-02-21 17:55:53', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022122193535001', 25, '0001', '0450', '005216', '2017-02-21', '2017-02-21', '1', 10.2, NULL, '0', 'ld201701251517', '0', '123456789', '门诊3号楼', '2017-02-21 22:17:48', '郑超', '2017-02-21 22:17:48', '郑超');
INSERT INTO `RegisterHistory` VALUES ('117022210295932700', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 10:28:13', '测试帐号', '2017-02-22 10:28:13', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022211281860400', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:26:31', '测试帐号', '2017-02-22 11:26:31', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022211330888801', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:31:22', '卢德美', '2017-02-22 11:31:22', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211331702502', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:31:30', '卢德美', '2017-02-22 11:31:30', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211332079203', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:31:34', '卢德美', '2017-02-22 11:31:34', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211333279404', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:31:46', '卢德美', '2017-02-22 11:31:46', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211333928405', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:31:52', '卢德美', '2017-02-22 11:31:52', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211340907106', 29, '0001', '0457', '0007', '2017-02-22', '2017-02-22', '1', 8, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:32:22', '卢德美', '2017-02-22 11:32:22', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211375974207', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:36:13', '测试帐号', '2017-02-22 11:36:13', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022211385682408', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:37:10', '卢德美', '2017-02-22 11:37:10', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211390462509', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:37:17', '卢德美', '2017-02-22 11:37:17', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211391662910', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:37:29', '卢德美', '2017-02-22 11:37:29', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022211470009911', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 11:45:13', '卢德美', '2017-02-22 11:45:13', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022213082360800', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:06:36', '卢德美', '2017-02-22 13:06:36', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022213252811301', 29, '0001', '0450', '009223', '2017-02-22', '2017-02-22', '1', 10.4, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:23:41', '卢德美', '2017-02-22 13:23:41', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022213282411300', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:26:38', '测试帐号', '2017-02-22 13:26:38', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022213315731401', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:30:11', '测试帐号', '2017-02-22 13:30:11', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022213361917602', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:34:33', '测试帐号', '2017-02-22 13:34:33', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022213363818503', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:34:52', '测试帐号', '2017-02-22 13:34:52', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022213450602700', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:43:20', '测试帐号', '2017-02-22 13:43:20', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022213594407600', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 13:57:56', '卢德美', '2017-02-22 13:57:56', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022214043355201', 29, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 14:02:46', '卢德美', '2017-02-22 14:02:46', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('117022218260584002', 2, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 18:24:19', '测试帐号', '2017-02-22 18:24:19', '测试帐号');
INSERT INTO `RegisterHistory` VALUES ('117022218315509404', 2, '0001', '0343', '011206', '2017-01-20', '2017-01-20', '1', 60, NULL, '0', '8261124', '0', '123456789', '门诊 3号楼', '2017-02-22 18:30:08', '2', '2017-02-22 18:30:08', '2');
INSERT INTO `RegisterHistory` VALUES ('117022218575619100', 25, '0001', '0450', '005216', '2017-02-22', '2017-02-22', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-22 18:56:10', '郑超', '2017-02-22 18:56:10', '郑超');
INSERT INTO `RegisterHistory` VALUES ('117022310554962600', 29, '0001', '0450', '005216', '2017-02-23', '2017-02-23', '1', 10.2, NULL, '0', '922525', '0', '', '三楼3053、3055诊室', '2017-02-23 10:54:02', '卢德美', '2017-02-23 10:54:02', '卢德美');
INSERT INTO `RegisterHistory` VALUES ('20170217101720468000', 17, '0001', '0305', '012208', '2017-02-17', '2017-02-17', '1', 8, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:43:54', '', '2017-02-21 16:43:54', '');
INSERT INTO `RegisterHistory` VALUES ('20170217101950896001', 2, '0001', '0310', '002215', '2017-02-17', '2017-02-17', '1', 8, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:43:54', '', '2017-02-21 16:43:54', '');
INSERT INTO `RegisterHistory` VALUES ('20170217111437214000', 2, '0001', '0312', '095206', '2017-02-17', '2017-02-17', '1', 8, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:43:55', '', '2017-02-21 16:43:55', '');
INSERT INTO `RegisterHistory` VALUES ('20170217112256177000', 2, '0001', '0328', '000204', '2017-02-17', '2017-02-17', '1', 8, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:43:56', '', '2017-02-21 16:43:56', '');
INSERT INTO `RegisterHistory` VALUES ('20170217143033799003', 2, '0001', '0450', '005216', '2017-02-17', '2017-03-17', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:43:58', '', '2017-02-21 16:43:58', '');
INSERT INTO `RegisterHistory` VALUES ('20170217143424493000', 2, '0001', '0450', '005216', '2017-02-17', '2017-02-28', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:43:59', '', '2017-02-21 16:43:59', '');
INSERT INTO `RegisterHistory` VALUES ('20170217164330580000', 2, '0001', '0450', '005216', '2017-02-17', '2017-02-17', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:44:02', '', '2017-02-21 16:44:02', '');
INSERT INTO `RegisterHistory` VALUES ('20170217164751175001', 2, '0001', '0450', '005216', '2017-02-17', '2017-02-17', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:44:00', '', '2017-02-21 16:44:00', '');
INSERT INTO `RegisterHistory` VALUES ('20170220151113287000', 2, '0001', '0450', '005216', '2017-02-20', '2017-02-20', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:44:05', '', '2017-02-21 16:44:05', '');
INSERT INTO `RegisterHistory` VALUES ('20170220151152669001', 2, '0001', '0450', '005216', '2017-02-20', '2017-02-20', '1', 10.2, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:44:10', '', '2017-02-21 16:44:10', '');
INSERT INTO `RegisterHistory` VALUES ('20170220152815044002', 2, '0001', '0450', '009223', '2017-02-20', '2017-02-20', '1', 10.4, NULL, '0', '922525', '1', '123456789', '门诊3号楼', '2017-02-21 16:44:12', '', '2017-02-21 16:44:12', '');
INSERT INTO `RegisterHistory` VALUES ('20170220164708197003', 2, '0001', '0450', '005216', '2017-02-20', '2017-02-20', '1', 10.2, NULL, '0', '922525', '0', '123456789', '门诊3号楼', '2017-02-21 16:44:15', '', '2017-02-21 16:44:15', '');

-- --------------------------------------------------------

-- 
-- 表的结构 `SiteInfo`
-- 

CREATE TABLE `SiteInfo` (
  `siteid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `UserID` bigint(20) NOT NULL COMMENT '用户ID',
  `lianxiren` varchar(18) NOT NULL COMMENT '联系人',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `mobileno` varchar(20) NOT NULL COMMENT '联系电话',
  `address` varchar(200) NOT NULL COMMENT '联系地址',
  `mark` varchar(20) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`siteid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='地址信息' AUTO_INCREMENT=2 ;

-- 
-- 导出表中的数据 `SiteInfo`
-- 

INSERT INTO `SiteInfo` VALUES (1, 2, '王静', '女', '13612831258', '南京奥体大街68号新城科技园国际研发总部2栋15楼', '2');

-- --------------------------------------------------------

-- 
-- 表的结构 `UserInfo`
-- 

CREATE TABLE `UserInfo` (
  `userID` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `identityCardNo` char(18) NOT NULL COMMENT '身份证号',
  `fullName` varchar(64) NOT NULL COMMENT '姓名',
  `portrait` mediumblob COMMENT '头像',
  `birthDate` date DEFAULT NULL COMMENT '出生日期',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(200) DEFAULT NULL COMMENT '居住地址',
  `occupation` varchar(20) DEFAULT NULL COMMENT '职业',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `identityCardNo` (`identityCardNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='个人基本情报' AUTO_INCREMENT=30 ;

-- 
-- 导出表中的数据 `UserInfo`
-- 

INSERT INTO `UserInfo` VALUES (2, '320981199011223455', '测试帐号', 0x89504e470d0a1a0a0000000d49484452000000a8000000a708020000000a7f8036000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000ec300000ec301c76fa86400008ea849444154785eddfd057c5467be3f8eb3f7eeddedd671e2c9c443b0d25288e30e6da9ed76bb5b378abb4620b8d50d97b6b884e090102c44270ac1dde29e99c9ccf37f7f9ecf99939384d2844bef7e7fffbc9ed770989ccc9c73de1fb7a789f8cffd58f8abf10f2fb35c16515d5dcd6f54cb651616b3d96cc18ff544fa9dd12cca4da2cc2cca842815a244ae5be522e58a717f6af986d8bc2f765c8fd87075caca9ccfbf4a7b777eca1be14983a726f41e9fd87d6c52d0e8848091f17e9f9ff2fffc54e0c8d3ddc7d0fbfd27e9df08d3bf3d3be3e38567c77d73396cf5cda55b0ad71c34ec3c2d4e5f12978a45a110c582be0e5f5a6a12065c83852f5859b5ef467b0b267923cafdfee71eb8f69b9bfce72f437d709a2748600b425a12847cbef2fff43f1ce3415649a4ef0871a6426c4a2d0bdf74f9a32f2ebfb3f8e26b91997d2667fa8fc9ea3aeaacffd873fee3ce078cbf143ce97af7a9377a4cbbd573fa9d9e336ef7987eb73bad7b3d6660d1813cbe1938f946f094abc1932f864c3a1b343edd7f7466e0d8b3bd265f1d1271fdef0baebeb7f4f6a455e297d322b398beb740884a792520415c5bb5d964c27f709175f1ad4d18fff9e7cd57f0ff1ef02a0b31cee01482d9222a2ca25cf21c161efaf18b39116be35e9b7ebaef84ec9e932e044eb8ee3ff18edfa4dc6e934a03a657068796fb4faf0898511e38a322686605fe1b34b32468065671f08c92909958a5c1b4f03ece290ba0932bfda663e1189f50163803af25fed3f0db12bfa9b92f4ebcd96dc2e590c9e9bd261eed31eac42bd3f463beaada112fee994912e419491280162b4cf7676d06ffffa59fff24f0755841fdafd1021e67596f11060b3d50405e6011e9c562c5f1f3ef2c3a193022b9cb70b0f2f59029e0d13bc1530b4208cee240820a8031a8801cb061d13b01d38b02a6e104bc4ff007d27f957724cca0002291a09938c6096521a1f8c0a2a0e958ea7ff303a7e5064f23d9d0631aa4487ad7cf4fbcf051da2b33c4d7fb44c26d71d34844c962c04ab475d5d9ff33d8ff51c0d790b895d2eb4bbcfa325ef92bfc8367872708e59d6f11d9b9a59b4e5c98b9fa648f3119dd465ded3a0e8019026656769d56e6370d5031968096f91bc80157e26ce0275164cee663753171f0dff2c2c7aa64413424c5436977a200fe2f8b07fa16291eaafca696769b7c2f6872badf88a3419f657eb2c8b02e56245c2581040100234055ec8d14f7b504447d69d190777e8fc21e29f0d60b62e0a4c65356b5c5cc321bdcac286f557fcb4b24cdcd3f38304a797e57887d39c553d7436da7058d87c2bed57d5a7ef0f4026641c8e7da8b21e1c518170785160687e215ab44aeb2c09ac5eff06f95256945fbe1fc517528463d07440601039a28ec3ef34ec8b48bfee3cf048dcfea3f357fec4ab1215e5ca9222ba49278dfc214400b4764bdf27f6119d4a8000d71284f4f6bf9aa9a42cb2eaa026924613d6a1daff97a36c8557357e161b3899f00dd39c439fe27ef87cc22e00d16a99026db3d61f8f978cef02f53fa4c3cdb6ddc5dffa945dda6550586b3f6555535f3b48a930ab90a9516d4df02be16fc0d001e5faa2e160ff83ad6293005b04097570227a6761f97f4cfd9b9df468b5bd5a4a42000706b74f3b521973a8d7e348f8e9e0f3fbd7aefd7571c3532b2be187820d33f528ed75ea8f473f81ef04a66afa2fba4dd4bbf90af50e2240b24ea80fcb62859b43379e09434bf5117fcc6dd0d99561042ec581a30b32230ac3ef3d5e77b96cf8572ddf7b7aa60d7feb63e676b0156294cab29f858c59ead04bc03e00b7b86de0e9e7a2d787276c0d8e49ee3f3a7ae13fa229147f7a8b038d13f1e00c16eac36d5419dd0d5b235cb06ab995bc72d6c3cab2be4f0a881572f9a3d7216f844e870c595fbc481023c7e673093ed0686b8509cf7c3dec3fdc62676fd1cc61a381b6c04e39ca571697058b19fc2ebf59153df61b400396c3d06bebe18a8f3e75a0551e7731e80bda24aa4e267f3822c0c097c61e034b607abfc675406ce849791e337f6d08b1f5d9db61ac60aa9b0523351b9498955684538333abd630d696845263f4c3524c07f585bf03f90c76bfff25102afbd08be0769de4a475c3abb38e0736a647b61b5c8cab7fc70f0cc6bb33202c64048825df0ecd83e27832b7066011e288027854d70d651c3cce22a97f339fc8eaa05ea73ea7da9a730641aafe2607cf5fd5759d034acf2407ad57e886af4b11351d53d1c621f6e246e045498db7326b83fb5f744d3c22871ea06597fcce7160b47abb4a04a3c2990a1cacb7afcaf95118d005b7beaa3075e855c419d81671296646e341ac97c2bb540fa1937c49dfd60614ac088eb7e1380b43124bcb4db547a88d208874f551a12ce061a284005556b7f6965bbf684fb825d8789ebc870e0cda833f08cb104b8d6d2bc3f83995b0d06b05bc18a833d46761cf0dfa26e53f2fda79ced3646ff5af89da5dbc5cd4a627dc427248ff343d388717a5e4c0daa5d785f6ba096d66f0c0d3c4ae0b5e6487d31c43157526eb89b7cb33876e5c6c75f65f79878316822647b71f7503c1ab849c6c0d08a6ee4ade1f115fa4f05f753bc4571cc6aec7336caee2b9c7f4b17a852012cc8ba40950daa78b8af19af5a035abb926948f1f2ad486b153f502fef1e46d20b3e21b00f09c587e37cf826e94163b3df982d362591e287d75a63f3ab529e78e53efa9bdfb2c6896becb9c6abfa3f0cf8daca477160003902dd79e2c6acf5f13d475ff21f5f103095bc643cc4c0e9952161c4ebd6881bd8881e2b426cdd61dc91cab782adf8665ae0b5fcfd5b365d7d8d50472fb083ae7a83bfa52054b1813f2f9217af9c298f71cdb817c04c6e5ee034baf8eea1057e53d8e080d6870ac039d7fc2624068f3e33ee3b915da80dfbb07a97a84b07b73ea20c7c6ddbf92144ff23035e5e0f99eefc0a7fbdc69de3bb8078cf338b4317f543a623907e2760323ff7fa025c35d0982f499672002e380c02bf18cf8e3c7269bbd50bcbf0f365fce00be04cfc15161d0440e4921f5f1ea4bca3f5e5704e4570387ecb7fc546255b1858ac6ef87dfc399f86401e3c78925521a486380cac929d2a60f8fae99282e83270fdf828042460f9b3e3277e3824ee5a88f5a5e0e627a91e09133d3d58c7aaca5761266b49ebf8fd47443d9326f096d28ab0a76594b16b72d5cce25c41ee97bb527a8c43d01bec0ba3976c602bf02ccc99dbd82c57515735ba02bc7cfa1c705599521b78af61dc907072e525ade0a163c1272c0f085597369e4378fb13ade05bca42c2e92b2442645776a7cf290c8058629a53165819bc0ba1050a6031c0e17dc65e051e078aef2081a7050a96faabe2c5a9797e9313bb7d7673ca0aa1bf49760fd8434675c8e8e3f00eb1917c47f2528d7fcf66b26a413706759cfbc838bee67b250950a886a31308b6170a7128e7cac75f9e099900462ff69b5a1363b15ae05a4e55ed7686507d88f4bc0006fea47b28f1590f62353c743602280e8fa87b006cc36978c531e3a4723cfe4bb8c27ab0625f1910a65d351c2969a5463c4851418c0edb33380c1480cbc0c570e8063e27ac77501ec589a590574d813af28cbf976f8780e7cb0e9e713770cab9c0f139afcd16eb4f8a22291aada18d3233fec342807c799399ac63f587a9a28e67df400278a4c0cb8babd150a046e4ad0b2ca6b5710903275f0e9800f3ad2a240c0b8f89b4bb355d869baf0f3ca3cec02bea80e5bc94ab7992cf38cfa6f23d89dc9e33f2fbccbcd73ff4f680d01b03c36f0c8eb83e24f2dad059575f9e73f5b539575e9f7fe5cd7997df987ff98db9175f9b7be1d5d91787cdb9386cf6956173f1db4bafcfbbf4fa9ccbafcdc3f1d557e65e1f3aebe68059b7fb85e5f689c8eb49021ffc0d2fa3ac47185e490ec177f797d93c789e92d1a17a9468bf26c0a7da0465fe33697138d9ea82e200a40332bde53731abef94ebf37e218b0f810d13894fc43808697eb0729118903fb58d283578db40dc1f2dc75baf8f2e0eabcc226e897b935626fb8dbc153485ac1ee9dac256cf8383d42b9ccd221689aae7ad3e14adafc5c7c45b7096ac0f979d28b87f06f8cd2133cbfb84170e88b83e34fccc2ba149afcd38f6f71951af8c5bdfff932ffddf0aed3470a4578fb7755d86d8b5efdedafdc5a6cecf35b5eff8b47dfba7da7478c2a6c313ad3b3e6ed3f9f1365d9f74087ed679908def3f5cbb8ceed07751d09b9b068d3cfefab4ccd722aebe1c913b687641ef9952444b618ee46fa0cce685846251664f666e9037526f41b54ef89dfa1628df383e8a56e00c8843583ff0f7c4652325a84ca2d200874faa7cc6993cbc1a0340e1feba24d020ec1f29c75b2512092bd06ceacd73ef2fcc091e77cf6f72555028189d44a20cb617f70c03f62af02a4fd439a8138a017b61518235687a5ec8f4fcde61050367038f1b8342cff49d7ca2c7c86d7eef7eddf19549bae0b79bfbf67bdc29f031dbae7f23443b3e63dbbeb593af83ced3c555e7e6eaeaede9dc969613968f0796b3b787cecbc3c5ddcdddddddd3d5cddbc1a56d2b870e4fdb747dac4dafffb17dfb19ef698e81ab9f7be370cfcfd3074cbe3c78e6ad21e1f98322106b428016b207d7c3fe080c1703199235745c2b69a4092ba9d60cee917d163c22f2688266e6741975fad599e2e059512853d26619ede6c0360c3d29d9eb1b7a0a653408743ae951020feb43a65ee0a61ba1d473fe3def8cdfa87b01934838fb4fa588a6ff34b6b729ae6915d1f5f5bdd63b576d7e9c060e83502505d96fd6bd97e79e7b25e240df91dffbff635287be6f7b74eb65ebf55c3387f6cded3bb5767ec1d6a5b3bdae8393aea38b5b47378f8e1e9eeddcdc7ddcdcbcdc5c3d3d80bc8babbb0ecbcdc3d5156fa9cbdb5de7e9eae1eeeaebeaf69cab4767578fe774ee9df0092e6e6ddbd8fb366de3d7cce17587f693daf5fa21e49f7bfb8eb8faf26c505e716f84986ae2f6b853ad0a63daad79471a224a8447cd29f4205a297c7192a14704f417321497fd279d193c53ac8e25b15f41b612ec632c09b84cf7a9f6fc43b17ba381e76ff9cd1fbec002b3d895ac1f32f5bcdf6804c210e762c3874c21703cb0a7087c4d4855e50955e6d7318ef8c1e1095299d4d059d75f9b7b6ac0f8e5cfbd39ced1fff5d6bedd5bba756ce5e4e5002cdd5c3cddb1dc3d3d80ae8f87bba7a7bb87871b96bb3bc189e5ed4eeff3c23958f42b3ec7d30dbf0611e018a731a1109578b939b675b3f37175f271f3f072f77174eed8d23ea495ee1f36ed421d8377f97f78f6d559d787cdb9d17726e2b2b0373973afd5e26a9899dfe7c0be56d373b907bbfef065c01230056e4bec4b96ece0200fe43b01cf8eb195e36b2cfc07a1727fb81ec4f1359f66055cb12195e237049ac9d0e0909c74e60419f0ab4fa03e098550b813703647ac98d1b51a5ddae1532bbbcf64f5c641ae7c58bcd2772a0a09c3236075804fa8ea119ad73f2ce71f915b067e36a15def816d3cbbb4d175b077f675706ee7e2daced50d3c4a28023c2f7ac531c063681bb8187e2c3e1f7fce9fa0d084fc581c831a7c75aeed9d7490285d5b38f668eefa77e7ce4b83ff91f466e8ad5723615ae28e6a443d5570d04284404611acb55f56cf9edfa963d6a8de20acfdaca07179d3d78b9b24f329de2de32404bc7ce494ee923f5ceed7a89f87011e5f400eba4a172c7f507150200abfdd838804c21a455d274332c300069c75bc320d07401848daf7974e390220f097109c8731df7336421c45bdc2f2fa86df1e107eeda5f0c3bd467cd8cc37f849bb76cd6cf0e801b0bda78b0e0ceae54e7c2cb99341c252616b20ea8d3d8de58797a7bba78b4b3b7b5de7a76c5f795cf753e7d7cf0fc3d586e6f50ac513a0caad009881e40722b5581912a1ea75d5b3af0fbc36ec086e81e44fed3ae2fa84e5a851508aba90d0d7946fe0582d4a7e64c0d7fa2009b3a25024b9713a99888e2ae3a0d78571d99ef4e071370326b19e5323d57c336ab6949d377667e1d441f223582b050064204551e80ffda7928fd47ff6859742b7f5f868a44790ff93f65dda3843e382b9dddd742490bd3de9d1bbea803a9066d4996bf10ebfd958441b7e3ebe0556829797475b29009eb373edfa8cc33b4e2f6cecfd31aeb9a87f3880278a977a8db235b29e13ef68bd1835c853276b608d54c2879c0e4f322364fc8d492bc53523f85e6537c5a7979050cefb814ab83e4d3ca471a73817324e4729a60251f64d7466c87898b87487a86aed199eeb3f05374fde8e14685a334da16bd605148b95457314ef24fea0937b86160d5b8072f7596ebd8634f7841687b10da3ccd3db032c4e072c8d5d5ddbba13c7abecceb2fa8fe678fe3a481d6718151e6e6d7dbcc8647076e968e3d2fb59dd6cf7dea7fb8ebbfbd21c687d20c7191a0e5468237ada88b50a3c1f30f0787aec32a0ee1bb1afdc19ebc52d03f4697515826232626255b35ab1df40beff1d51af15e75a0382d9dd6032d2f7c3e3fcf1507ad068b8a1b83116da50cf65bd22909ca8134e574d39c69e21c7ede1012118a74882eea1375e8efcc9efad37ec3bfad9b8b5777005c0c05bd7d6c3cec3198fdbc7c70bd699978e789d0df53a1a5aabad1bcec48d3a9328ccdb838d415888e07e1cb477f7eaececd1ad8deb1b36edd787bc77e1d588dc3e0815933b43b61b7bed56f8b5315dd58f656ac033a18703fbbf3bd93ab019c1216702c7dd09db207265258f14baf0f2a99605615276f61af3d378e0a560619b8e3cb74263c5961319bd27dcf59bc0b7846b8566a2603bbc5b5cb7df14d53d63aa672b8f962cb5e0102c9b7288eae40f987579d8ec459efd7bb57083e7edeeeae6e60143ddcdc543e7ecede6e2e30e0a80a807eabe1e1ebe5e9e6e6e3ad6ebaa5dc6565e9d771a056a434ec6d7e1abe1102a4406a5434e04aed51ddfdfdec6b9d753ce5f75792de7d55977fb2a917906951f421d83aebe07a83a811496ee36d9e84faf89fe236f87ff4c95c795d0b0c474b0f7a166159dfba880576284da68b014314ad11c8209a892db9298d867dcf580f130d338c1aa38b2f0dd91bc02a83d89665577564bef4872d0f990f63dc22826d37366ee90c8b8bee33e72eefa7c73476f47e22160ecede5a1be2a8ceea2ebe0e18963c87c92fc1a4b9ec53e9bf75a526808968d3d87af0a6a5e7522880e4097f01b5d5d3b3ab9fb35759ae4dd33fee529f903c22b64c906b332cb7c951fb407fc3ee7a80039058903a657f79a4dc1ab2092a3a7bb7c56bc7827f13dac69e9cd83e309967a1d3c0f2683dfe6786b64a0c677b7be439f885a39a07ef47cf6cb3309f5ee334a03c9a0e3b43a87e700275a5b28bca5015eeba34324503e1b8e2f5443c8f4db43661f1d30fec3d69d3ab470a0870721ee4e4fb6ad27f888e4390ef040e161777027930abf57cd7876be559beeff80e3713d4485b806796d2ac1017b26200f2f4f44175e6cea38ceb33b547edec070eafad01486d7015e9197922670667e77855b80777137d298d4218422bee069e97d265956c4ca740e79f4754b741ac6f70f14f5d26d20379dfd07b541101486d696a4bc736fce41ef12b819b25df5d755975dcdae92b52263ec5a3f1ea853412a0767bacfbc3b68564cbfb1ff727abe7d0b075f5785875420558b9d1f3139d3ae75ed763e5935e6ff6876a7cb70d76169dd48be3ca25828232f0f1c7770f5ecd6d2e553a7ae70f4115de654322c1bca5c70442f64a65a1aca4929d5f25729431be7c713bb1538396be074b13f9ba226466a49a861ce86a18eb31a66d553700669566b9e0001e4bbe64bef2ebe1c383137702a796580d0eaafab724cf55b40c2756e493173a4970f819f3738f2c480899fd83edfa99513c969ab65aee5600eacaa9a5bfd151bf0ea62e0ff5047aee6f224f0ec49aaea8688129e8794463a58261e1e3e8ebaaead7523dd02335f092b1c1449a60f523bf2dec9d30b9a0ee606f6786e08f56b235d2c03546b40758be0e85eec3a36e3cdd922a3882c6b287b2ed46acccf03391eac2ead778ad0c8880d45e3614bdc1377227e49ee3682cc31d6439a5ea43a9157469db2177ef4cafe8c929e4196b6d7acc23ea129fd277eeaeaff5c0bc78e6e5e7864aa7ba67ae4fc6455ec393677dfa52582c6eaec469d8f2f82d4c1d25eadaa6e88e93ddd10f987c5070de5e5e4dca5a57344bb41909105bdc390c1237746faba14af94c0f38362b6d15a005a67984d25fadb1e6197ba8c39f3662405742991c3adc58df87910f0fc69ec2f2ae11b9041a9302d3f4285342153e9ba1169b1969433e46ae58ce2ac5b6ba1989c5512e6fb84197ffe95b099ae3d9027452c1c4eb9ea9e310f3167ab863a2b6f355053c78b6b1472ffcb93b52685ea4f2a2104e4ff90e8e3ebe4348197bbafb32ef859ddb75dff717d5038550f73efa6df5476d858fdaba86b19bd0edf538e0a817d10c78b53329eff3c67e62a12f868256ea4b8ff7d778e743c9b8cd0f460f793e7b306cf8089018ca99054a623492dc93e45551ca96e9bfa66ad1b90399bcac0e948ba2ce9f6faf34fdb2103460fcbc519c138774f586e64bca9c157958f15bb491342d7ca7f15cbff033f5efd2ed5acd33a901c528429dadecd1d0166d02eacd1768eee035afb1cea3d8a52fb41d4cbcd790aad8cd43e25ad4faf55a0201158d030f4402ec981a3a94f0f7d1aac881bfcf33b1c4f4ccf261ea37ead2c7becd7181d50d255f1cea938028c8be664a4e034f514aa91c2e48cc5324a2558aa9c191c19db777448531777278a7f61b523d70d7178025e6b996b0d37557fd7499f28dc668de2fdd1c65d1d81c157cb6f92470237cfcdd5076ea7bb07f920943274f3f4f2e9d8ca65ac2e38fda599282640e61e39784e34d7096baa4f5235ebb40441024396fd80f150b773e69570917c8b957dc37f7e9fe395a43f1cc63c93f1cb6844e89035425016ed01b0cbc83a935957b65755fdcd1c5fe79654e0516e50d0273cebcd88e14edd7c5bda79b7f54230841c24d84a30883c75582c3f9186014f7bbb7bc0d467c81f206355faf85f8af186fc395f869a2350c98edf816a67670f7c0f520629c0cd0369b475f678fe6987a57e7f473d01b1bbdf34d4a790756cf5785586215748f30c6bc542424211cc21b719156c41d3cf769f780d599c1bd5a4ec1bfcd3e4bee241f5d895e03fa2f1456671f2caa96e9fe6054d517aca65bd1b2975245a7a500d5a9d089d2ac4341d11d20890b9e75b43672f7ce195c0163a1f67173682f080ac0e1250276b194f53051e16401d6bbf8ee7a6a2fe47a767b497a102af2547c879578419bd3c7cbc3d49c1934f4fc14778f62080f62e5e3d9e72497f2d1c4c4f317c2e49b21abc5ae0d91562b250a526390201d3f0c0b9b613bc87d11028d1affee908097c6d6f461dad5ffbbf4d9444aee65db2e1b5d13a9c01affd8638d16ffcd5a049aac159df00514310aa42625bafa60a16fe6b0885208a06461eeb3566689bb69d20d1c1131e6e782694e88478b4964868d539f39356add6f7d9eadbf370a5f0830fc652ce97c7f5df47e90d55df343879af62af5ea456d1d4ff1cc5e6f0469857e7e3e5ddf159bb196e3dcebf3eabb06f0455a6f887a2d8976b70b9464371776bbb735a6f5e8983c9a20ff2ec83a6c4f7198f5a37ea57e1d635a44ca1f5594db3f6b742ccacde84ea3ad477adc63b03af787228af2810a6793b319a00df4165cbf5920daa01affa244cc5aa852f33d35452012f0042fefce0d0a5ed87766be3e2e68a42b7463ff10622d470e0a53bfe475d864a1ca4ce50dca773eeecec36a4a5d7ee41a36ef50f932d06a158b2f2baa629ecbe01dd3a6faad53e78aae7ba4f4a1dbeb8a6195bedb7958daa35105b09a036c76b82b238246180bf07bb1fbf9cd67be2bd004ab3529c4efa9d1c7d648019f83a04a13558b89e9095566eff888383c7bed6c2a7a38d9352ce006128eb1a98ef1b88eb233cede138be5117c04c0f658ff00e8a01bbb47299d2ae2f2ab8694e93845c6b1a3f18f59aea2ec9f16c63a12f27d1ff73b1fe04f0527bee390c632da3a855a5d9a456dd960abc2a1fc0ee77cc5726afc0a4212aff0e568007f62af0dac8a22a8eb42e0ad520cb0a4388359824375e9a1df9c24b2f3475806bcb8a90ec3889f7ff1f034f77e7454987f6ee1ea8154321ef4b76ed50704065e6b25dab7ea1ca6fc1af02af3d01cefd6dff09fac153c41d93ecafa10c2a826e75f0653d8e570df04c1aaa8860f9802ae94d49a8a18362066c1c69e24b648cebfb9d4cb92abb93d3098ae93615f0933dd23b3465e8d4be2ddcbd9d95089d8a3a034f1e702375ed6f9f4f46e2fdd61f5899f3808b270310168c8b0bb2c9a8f246dafea7f6afdd1a3c2b1fa55ab52d383cd50764f0ee4b10a46483a667078cc668460ae954518bbd92adbfaf8eaf5100b5353d1101d8fd72f9e5b717a2791da63b8f11534d501578ed3b6a55896aa672408a17e4c4bd6173beef38acdd33360099a49fb5780dacafa5804784fdff63c0cb881ec5a960dcfb78b56be334c2c10f2da4f7fa8651aa06592b6bc760a3806701407fd275726ef094f497a68b83d918b9835a3c2ac8af5f88cdc69d56edabc7440df88b22615c7334bddb28ee61a0ac7900c96ad57a5775bc5a39f45b8a8ab373b77bcf4c7b33fcada63e9decc9bd850bc700ab8cce74f08850c723fe7d93cd1af495f6ff239334bf914770259f85bd3bdc7e0767f7becd3c36f5f9ece6c070cabd5a439f3cd64b9dc8f8bb569e0abc01f52c01932ff88f2942915691a2add551b0359a5e72782de06bf9f4e8dabd664e7a2d14ae02f5afc85801c5686567329511d6ae98564b2df842b52a00be26a23d5013e864db34f8f380a71cda3b510e4e1b5c5375fc2314f50d019ec40cadff0be0097519d4439d016ebf9d9b67a7e64e73fc5ec7c85404c4d4f02d03af1dc0571ffbfbaa792a890840abdad4b47e13c5a90b540b593395c46ad85b2dfc260a2158ad3fcca052ecc0628bf8ee30e6d220fbcbed61ca681a2bae6aa6955d4955eb6babea580b2831e790e9575f9b3ddab7272a277d9c5cdba244f68fe630cecf5a7d776a8f92c70480ce85c80218e89cdbb66d8bf22e4ffcfcc1d7c3aa8dd43cc2f8de70eadddbdabbbce7e97f76083d5e70178d4db006731e0cfc7dc50025cca4859f1d380e039c51f7cc53f6eae8707ec70abcfc0f8c40259e43430cc4b1e09137fc272203c8f33cea5019333d726e38d002afb6b8aa4c8fa00d9594f49a913a78ca103b5fa08ea2442fdd1f9e3507ea941777a32238025d56c5c19690461628cfcdd3150d74880e226ee80d4c882cfe30ec59a780dda9405487981555e7b9bbe8d092717ac024d8f6d471eda70cf28362e56c7da31627fdf0d8316d252e688488b94cb6b944561957a092400df0722c38fa720978f07c7175fe8a7dc8b8e353b8868e677eb09cd706e4916557c38a5c4ea302cf661dcea75a835ea1f706866feaf23662b4b06c60d682eaffb8a7ac46d698e3e50f7c29f216b100b6a7cea92db0f720fe4379be97970f355efdc1c02bc91b9d8e73361cc46dff78abed01ef170c8cc0b305f0a4ec258fdd57983f980e78ae0c3f70d8e31831c4e3b554134ff5e9f18ed4f1d6ce0c25a88760de9dea940fe661ce372b72e48c95227959f3ab8dcc70965d1ba463e0f912953443e0f47bbd432fbf1c1ee9d6bb6b1b94cdd66a56fae3e0e7d43e589ca4b8157892012e8e1d7c3c7c51b2ab7342cc8ef28128dffee38d3b2570ebaa03dd53f61996ac8f37ba3ce779f643fb15cad7a85e2184a66c50a0d33a60a1e14ccf0d783c711b03a492ba7e2e2e9453e646ea7aad438fff4ae0655f3be5dc79ea0e06726c3a9dd8730ce43c2c0ea48f988868f24737b2d17e2b4fccf69db6805ab1ff8366dee9137a6ac8a4cf1cbb766ae30881fb7f530c0949cec0931949c624713c64405b0f9d8fab433b37275f77276f37672f3797b6de3eff073a9ebe9e05be27358180e040747070de69e68bb6c0bb3d689607ebf887039e1c014c20400c1889bb2e93cff88db93a6b0331bd9caaa1b5eaadc073ba9dc71ae0bd02717be4779703c601696a6e92795f26403eb8afcfa6bec936bf964ec9911b3c6b539f4f0634f7e8e4a8fb3f031ee69b17f27e52c30378408f270eedeeee6ceb6cd3b4838793bb7d4b4f675b5f6fd9152bbb73fee8c5195bfe2e842cd9a9ebf1573b8c71c81d1086092ed46c2547eb3c84a86745cca97a24fb512215fff234711da3fe6b456d59e55bd3b2ca141314f1548ba3d9e7fb4f2df39ba284ea38c3c6337d208864ba852d7956eaaad6af5f35a0c880a0993787cc5ae8ff7aa767ed3ae1f15b3b93ffe8a70c8cadc0a3024e32bc9bb39b8bbd43aba7c77df6eee1a84deddcecdc1d5b79b93be2fdb66d9143fd6381e7583d87a5a91e1c5fe8e5de5ee7f6fc1336abfa7f846224e27808eaee94a1e7097a8d5ae433f7a0bfc52720d37fd77f329adacabf88a61a0d4d309e8f0978ee8ca1361cb07b89b8b578f3b96ea34c5da9c90f5f8cae55943f5344504e3181ddc8265b7de0b557a9250e888d7303668ceed0bba3832b02964cec0ff1941be897ab9fec418d6d3a3c6b469dca3a9c6c9d5a3df546ffa08a1bd995b7b2d77c11d1cea5a5ab7d0b0f7767a4ce881d7fc3be537dfd8617f668f3c8aa49cfa948dc3e775d81fba962b3995de88b4331c40531579aa883848875a253c38127ae9329345a301790fbe91e76a5ebb82bef2f65134f29ccb25200c5eaa580978e1c8236e72b50b78b2e3d9e2da9ba95f541d50665d5df2ab13c5952476287077bf798a9ef37f17597ce9e8e843a113ed2d230a7b59135696f5b73e7d0c4d60c3a372748cbcbd7d3152ad943e744f15d702f8a303dc94aa2053ded09e7cd855c64fc565af2ee1e2e5ede64e0b9e0bf9ede4e8ef64ead9ef9eccd017753f61bcf1d359e3d6c387fec972fc37d9d5b383bb471d6e12c381bc044d108f8227c20d1a81cb6c09e2013908c2ebb3061a9b13fb612e4f8058a18aaa95e3630785c032feb9f284318d077f18663a76baf4452159ebf9cb227e77b351c75f54cb5c6894b9fc9a7ef338522b8f0ebd8baa32c0df1b9e478eb4c71cac0eeca4eea36e25ee0741eccd5a8ef561d7796ffbc88127b851eef3d3aa485abf498a581e30e371ad05a43aa0ae48abba5a2ae29afa3a7e6e6ec007d0ce9cd32937c7332d7dd90d4f7f126e50d6b0ef404aac217517393a7abab9b13ce4493a55deb566e76ad22277c72577fc8722ed6981665d2ef3065ee359e3f19b775f9f33eceb62d9bba3839fbf8f8d09f4307bb3ab7f7419796ababce512a66fa215bc14d11d75289900da15e0c5d4f4daf6e5de0b55e831678795f2e036c7dcebe1486ba1a999297c314e52c9d462ded307f9eb688dcd8f9a009c55fee9695b835295acace718506256ef14fb1c89db81a3b2d14f5a0090e8dfa56065b2b211878481e0cb3d819f801a607d0cd4b37a6969cd7f0bab65a46e633d42c0b31bdb73739c070bd28c82fe3fc54cbe4ea82a8083e54a7a370183a964936a06d9988c0d5c3d511a65c8b27fedcc1a5cdc15f7fac381f5f7de14445eaaeeab49dc6d4ed55a93b2bd2f7555f3a793d3efaa361bd5b3ffd37db56cd9596284f2f508fcc1d10111007cb980fc91569304abe27e039c6ac6419a458607d61a55abe05a55a50e5f85aacefe61ed4cce568afd1457d23787ea63219a4f6a0acdf8543655416fb246efda662ca5cf6fb8bc4a54ad4ca1ad4b164168b02bc9c2c4e9d12c7434651e97400cd0ffddd6faa73427da30fef2023777d50e8973e83319988e524f514ca3e4805fe3ac05bbbdbadf2c0fae0487a932826218e601c77aca14d49b62d4a464438105e3ada6a31cdcacdc3c5c1d9a6b9a7438b764e2d660e7fdb7c3ddd7239b122f360a53ecaa0df6548d9664cd9694adf6d488f2e4bdd0d1920ae241efef5bb017eed5c6d9e756ad3ccd9de86c49237e8883a22e862dc5ca068f00af94fb593ca35007b4d2a99c4991218b61237d70ff2aa11f55ae071d95d9e7558ddf14df4916163068c5104f0180653bfd6eac188705e8727ea5010451af928d0c0660962ef19d8f604bcf4de61d511f0549705b15f621107cf9c7cee2354f9f34cc887035e6d0f60bf0e7341ce0e0bfba459874eb608542a729e4a12d4d40803af1968c0bc5e1778f0b7acc8e33e45360f1169a748084a32a1fed11eeb2e517171b46fd312e00de8d661c6c77fcf39b2555c4d329d395c96bc83c0d6efa8d64755266eab48de599eb2b3f4f40e9175a82a69a7256bbfb870d872f1c88685e3dfeaf722f0b76dddcccececed9851ab54160482ea0e013a5f2d4f8e1e985c5c6791d2b95085a73475c0df0bbc03fdfc229c2b5e795576892220053a6e73692e3192f0efcf1c3273bb1fbccb35d4619e7ee80d95e13c361514fc0cbc2baccd15fa309122e606550789135fad670f8d918aca9a2e7eece3e6129ff081ff017874e30cb7812153f2f6b28556b485b0b26b5a8d73c595f44d7754e087b61a9e63124308c3e2f173b38e576cdfe66fbec5f3bb8dbbff7daa0954bc2cfc5ee345d88379f3b5e961a0dc82d69bbccfaedc6e42d86e41d06fd6e53c6fecad46853dabef2c45d86e45dc6e41da6e4cde2cc6e71e1486eeadebd6bbf081bfb719fc02ef6ad9bb76afab4a34d2b4f27072fa80fb4464000b879b962008f95d7ef9b4afe2d51cf0a5e2d16c5315a2c3bdbe8863bbc98fe5a281e175535f2364a8d049e5d7ffe2bf2bcacf5bbf7ba4ec4864eb56c7b33443d774821b0774bc4f61e03af9fc6c9f9413d379ae3e5647172ff94f68980e9700deef50bdff3ca78bfc76ddbeba8819875333f296d32b436976bad5f960da4507dc0d0ce0e08b0532d0384ad8787a3835dcba64f3ff397268e4d1febd7c5277cf8dbd13f2dc83ef87341fa21712dc17426a6226daf216d5f75c65e005f99b4a52a796b15abf6d45d1529bbcb93a3ca9377e30443eadecae4ddd5fae88a84ed200853d6117129be2ae7c4b553bb4f6d5dfed5cc111fbcdc132aa3c5e37f6af5ccdfec6c5b614ea28c0a10372b79646bde4f7a2b24b1b4059cda3bad0f3c4aee3b3ab8fcddb6034a11f1b8a447473b72349ce5f84c6578a406780e04210590f2e2e722bb00f69d92acab86a86707afa45ac4ddc0a6ab98ae4722c28f676c37ceaae43ddfb89284eb71b1ebc09d8111dff4f8170a8a7da5bb24c5b2b5a892d4b682b146b62bfe9b5205adfc23eb35dc5cdac16ad339e91c6c5c6c5ab57aeab117daea664f1c7e72f7cf79674e565d4ca83c7bcc72e198392786b8591f5595126dd4ef35a4ee2939bdd598160d8d5e9eb2bd2a6d1750873d0f398f737002e0af48da0decab52f61893f7e0b532399a8ed3f79bb20f8a0b71f8cc8a7371a517e3af241f5af3d59ca17d031c6c9e6dd9ec0957fb569034d40b009296da1d8b59991b0458af4bc7d28bcc3ee9945ae958d3d5ebedd1d6de0986fdba5e1f60c4174d4a0d46d97ca38d6b56ea8a82575daaa019d5fe33d33b0f2f5b132347e4caca0ca51083801715b3b66027561ac4403d3134f4b9b1c073608713f0c8e641c154759b7e6768244237be762ed4f50eef5c161c6aabe2ebf33a87d6a152c96f963f30d960b1e34d67676757bb361d743623df1a94b66fbdb89b21ae9d369f8f35661f32641ea8cad85fa5df43023c75371680c7c27fcbf57bb0cae815c7d1c09bc822752796310507514679a62175bf5c440115494437d0089529bb70b2e9ec81caacfd15678f98af9e1677f445e74eac58386960b776de76cd5c5a3d0b394474e905db939c16dc20dc0a065e8eed70556200f256ea004f1ac1d31de59768a35fd8f5554c87a02c971c83d0d8e7affacf80a0c69796db225d0a9870f29d48cad01b65a48e80e7504ea1b8f9fe1737ba8ee7202b0f9b6bec172bb162d9f5afa468bb4dc318a3375d5f70738476a4b04c1d234eba3daaeda3b44d01602fefb694b644ea1aca817aea3053cac1a665b3cebe1ee33f7a2b79df2fe25ab2b8100bf635e8a1b07754a6ec80b1462025efc681316997291970127812f868a04e2bad16f090ff9a15054607ebe31320244854e877f36fe10294256e36a64141ec201d91b6075f6dbe78bc2ce7e4b7616387063daf6bf30c841084193006fc4ca9941470719461637237a0c8998655e0d9e56353002d95be2d1d2675ea8f6a1c9ed5cc05398d8240653c2df03846140f7ba2ee0bfe8ce2f6e5d2b2271d0f530f1335ae969d7b291c43f39546b890b087302e3843c0e5633c501cc7575e9f8ba9a32e2e78109ec09e453d1be77ccff58107a363d22c585c56cbb87abb38badbb7b67bfa7fde7d29e4d8d6ef0d174f19cfc7183201cc0e805199b28d1837630f78bd2c691798b53a7dbf3935da9048dccc0c8dc55c5e6731d34bbea78503787a20262c9c095d5091bcdd94ba4ba44755256eb2c0304cda5c8d77527696c56fc5b7549f8dadbe187fe978d4fc49c3dbbab471b26d052f8304bb742c995ea19e9450636dc859c731f0e437e24f6c1cdff5f0cb1e8c58bdd280f0bf015ea518ca98074dbfd37be6d1173e12a7ee528c4e011ea15a446a63cf209c4e438683290d43b3d9d19dd548ab922e1439062bf0986555da333cfbd588cecfd8c19e07f06de1e26a80d7c6b9acb11a9e5308d79c3c726217275b0f9ba6de6d9efd62da883b497b2c178e1ab30e80f3107aab48de8a05a8e0a7c117075bb3290796857b06514f70a66e575f55987f03feedf2d37654a5ed802940ba206d371639fd30f853b65b5277027563e256a1df6d819b00224b8d32651f2acb8ca9b89018b375957f7bf7364d9f40b447e6dadde1703a3b39c00580d807fc144ed6f87eb54c3c99a1c764edc10eed12fa8d2fee49725edddeb8e14caf8a7716b7aa7787f91518038c4628f1cd61246c78b64d13b91398c8ff710f46e821d043e162e0171c06ec1b0b3c4b0b7ec5a29e9bde6147fb8debd4d41e93c20128b0e749518a88d36444b4c033ea08c22065eed1e6197f4ffbe8954baa2e9cb29c8b23152e191760133019fb00395e2bd3f7923c4fdd0dc10e412dd536a16e4ad90accacafc4ac92b325eb4b15504fe54384ec201990168dd80e2cff92e45d38934e4e8ec23bd026b0fce1fe41128020f05fba06c485ce9f2cb998f48f0181cead9e7273b28390275346cede64d4c900d4c4efea002f53f51efe2d75077a0ecfeb4b150f8d65776de454059e3f844bdfb019f3cd8fbea2c64a998597c01758aecd5a97e9379aec7965a47044817fa38d0bd589a403b9d56ede80591bbbbddbb9a5938b0f358a62d40139726a9f941ab353029cd6d6689d330949173bfb67fe3a2ce4b9ac839b1074836f86a75f9a408117e645605602972c0366d7a1f2ac23869cd8ea73470d5987c1f7441f8004f881e3097e829c972aff15be07a85615604ac75f5190c79c46d2a23c694765ea9eca8c8355593155678f55e51cc7b7987320720e420b40e48080a4f5478a1ff09bcec795e51c9f3de63d2fbb66b878c0acc41325f60c3c19fcb2b95a3b73977c1d547d7a7920b8f973d7b7ef0da649f80f91965543e65ae0d55459ee8b1351d5491bbf715a9680bf567171cc3708d183ddb9d39d375a6ab890e133d9a6a32b86498f52fc1ea17787467eedf3d2f3ad9c699ab89cfcc7a11b16f81cc2a99f09a5a89cced1f699bfbddedbff5ae241e85158ecd0dfb0b4a159c95c4f92d678daeeca8cfd15d931374fef3eb5edc7c3ebbed4ef5d773b714fe51932f24b53a298a189a78965e1a791e90e039eb1978bb8bfc602006125916aa84edd5195b8850ec0ca9947f2520febf76f3cba7945ccafdf5f3ababd2cf3b021733f511e64807e37c2fe06e8fe942d26fd36f359b0fe89653346fa38b746d057a691bc29f0670df56881476fb0a2e6bd10de7375f476edd0ca7ea9e7805b4323eef6a2b6e2c64a5c55b66b81e7480e95f0fa4d3fd377aab854c495764d68ce4566fe99b7e760135c1a6c21870e6292306fe2db28ec393740d35bb1e7ba3fcdf4c128ff30a71e043cec38f2e494f609ea1bd5d4c1a9ca4f4961e91c1d9b3ff5af4121178fedaebe781a3c070e4374c504f0e065254599d3f690dd9eba272f7e5bdcda856be68c89fcfccdcf87057f32d47ff1e87f256ffb0132a032731f7b71ea92d813fc8c3a8b7db6e9087b1047fa3ec876c870cadf246fb564ed450ae74aece6afa77c3262589f8f86769ffafeb0e5e1230ffe34fb66dccf9510fbe97ba1714025b0fbaa13375543ad201e9c7318d87f1f39d1b1e5936eae4e32774c56aa2ae725c75396561dc1484e80971be6e177b0759a64ef9ff3d24c18e1286e7e68e0b57f08101118a0ddeebb4d3fd37392387696589d802fb788439732fa4f454d2ec12c094d9da4df28e0cb83a1daa7b2130f8191db33ecdceb7387b7781eb3e5a9b0908603c0c85352f27424d3e41000682593497317776f1f24d91c5a3cf36ac80be70ffd2ace1d83dc86fb04690c031b60835f811099ee497baa53f69626efb913bffdc6c94db9493bee9eda76e9e08698e5f337cf9b7062cd42a0c8ba9917843fe97e30bd6471690428070ad3a74657e8f757c81360d095a7ed2c4fdf7366efca75b347edfd76d6d9e8b5774fefbe97109597b0f3d6f15fcba11d32a2ca0073162e63b729699745bfcf9018852bc4df1ab3f6992f9f58163ae299bf36215b4f5a3692e929d7473e2de6f07a508e8f849f074d0021b9e0eddeced6f99fcddb270c9b71a7ef0c3ccc463d7c55c7f35f691366e466fb4d43302d276462e1aa43549063843b8768ce663d36bd44c70cd756b075c6f3b61bb5504082660e093c698abbbdc3535e8b78a745c7176c29ad8251d3001eda8e8359326c4b39733c0b9d8bbd0fc2dfde94097774b0e9d3b543f6a1cde2fc516063cedc070d4a3a35837811a2957c36fddeeae4fdd5a907105b2d48da599a4e011604da4476ac39e75865c661a08ee09d8a71830e5260ca914620f30dfe3a2479fa1e64f38cd947444e1c3e19621fab2263efd9e81faacf1c306445576444e7c76f86043224eeae4c8051b9d79c7100f2c39cbecb94bdbfea4afcf4cfff69d7ec09187ada4c1d713f4afb3dbce8f6f118e4dc172c48410c400ef99bfdfe619311ee7c08deab530f01ecb4f3b4101742f9e5cdb91b29686f807107fc97c761bff67bdd15839ce62ecadd701b853a4e46c91875f14066c85df9eef49f7564f0e4d75af86296bbe478069ec376328a27135cb0debdbda8380e14e064dfbab3b7f3e15f7e10d753290c077f2995023264c6a7ee2a4ddd5a91be032e3b38386af1c4aaf483c63307d3b77f71725d247c3c43cac1aae403324a13057eadd42bfabb41a82b32209a9408dc740ad744c1d683318155727a33a2fde069b37e7f514af49a888f2c3947cc670faf0bfdf4de4988fa7d22fd8051bfaf2439aa24950c0b908e317d5f55f6e1d2b3273e1cd65767d3828a3b68689b9262b6567c4b1307d11b487da47fdc75cfe95c9f7fbccd8fbd3fb8f5f2bc8708d9d6079e2bb194e104fed37302c6e54cfe89eb6e9b50b66e497446b751053d68de9e52476bdd58a551d8d3f6330834ca040371fca0595bfa0ce7ca5ae99d135db37583488e5c14bd01f0a875a4949daba37db3c7d62d0b1737f515e987ca64d0b432112e3b096a005f99b5ab22732734ab387f6cff8ab9bf2e9b2cf2d232f7afdcbb3cbce26c6c657aac21f3e895c36bee9dfaa5229db896ad6e5e0d819fcd46d2f108e34bf3be3a79a7488b3ebbfdab7b71bf8a9c5871e1e45dfd81a5d3de1725179377acfc296c142ed574e6e89d631be1f5411894a6c9f860127980a68c03103f39313b06fa757468d382433a6a828a27be70111165fc5c5ddab9bb76d4e99e6bed38a1437fec92571a44bb5d36eef96b363a510d3d56dcd4a61338f372c8e4ec915fd1661706005f682e9af1f399aea3e17d4119a895d40fc1f14c719459a26d1a6720ecfc7df0bf69b32067998bab011e23acbc10baf745e59dcc70704eddaec5d31fbfda5bdc48ad42d45dbf070f0e8297ac30e0a1df530aff2a6d7bc68e65099bbe32dfd08ba22b837b758e3bb8f18b7993a68e785b1fb355dccbaaba70fcf0caf0cb8756823860a6a96037107e180115093b0dc9bbc1eb102d1030c8d582d1b3377f7f6cf562d34dfd81ad3f8e1ef18fb6bef6c33f79b74ba7b68b668dbf9973ec44d44f31bf2c2c48dd25e3c17ba06570fd14504ada61ce3868397f6adf9a2fbc9d6d5c9c1d21e728fd80a26f5408528e514e3d4773059ae810b9737506f65e8e4eaf3a74bcf4f29c8ae088ff3df00c3fef7b05970d73ead2df5b20ce972219db0443cc6e8ffce152b7711c34509be01b456baa41a1024fb5f42fcd9ad3e5e5aead9d5141ac002fcb58e5ec32029e66fe216b255ba35d9dec9ff774bc9bbccf9213439e7a6a14381e6138a00ea607f030f1a059213f777e3d7bfed80f3e1dd6c7e17f9a783df9a7b68fffc9e3cf4dbab47ae2c3012feefa3e7c65d827e6f371e633b1e54948b2c9140b39f48acffd3b7ccfd9bcc4ddc09e6446fa0e73f67e1898570f6f9ffce6e057519cf364936e4ecd8675edf056f71e81aebab6cdffe6f4789390f66d0e6f5c62ba78d4723e86a84dbf07021fce24823cf044e0881a2ec64ffeec6d9035627354cd8170b53b30d6f940afa3a68fda3d4820f2906e4cc8096cea8c5d3079bfd346a1a0faf1da3a58851b657b0d80cf7c6b8e48b98b586d1371a7eacabb4bd012cbfd76945e9372fe210208b44bb3dc8a596ee23bf3facb1113dbf741eb0c2a8889dd39ad2e81f77143358b176b7a4a6d3839ea6c9a45affb465c3c8ee0092a64f08aea092c8ec191bb9c79d07cf664f2e635ff0ceed6f9d92747fbbfb0e5c37fa74c187376e284cc891377bcf7afc176cf7afea5c98c775e29493f66cc88b3641ee1448b8afdef0a7c12ef08d82546999229228b389de1dc91bb69fba77df886f7137ffaa0b3efa9d9336f2e9a77333c3477fe82aad5ab447c5c794cd4da19235e795137f215bf0b8757c314ad9616282578f009c9bb4001c60bc7abaea606b475716963830740ad7ac82fd37e1b043ce23654150ac5e7e343559e3e9e1d9f6c933a702af676a963a8ff2e116803389c6c634079e439d68dee5369dffae3d75086d544dcaa3cff7a245ae35820c098e70efd87039ef7c8a69afee0e9575e0a1fee13e4dbda1e624d0b3c614f263c393892dabd5cec6d3efbe7cb85d971b0980c495b95a819bc6ac4e052a3400796f4e8fc639ba316cdf8b47bb7a8b9732e6ede92bdfcc7bb2b7f2a983befcef8492513a6e5ce08cb9e1bb1f2c37fbeeee9f09e5ffb233fcc379f8903ad9081061f5d323d03af0a807adc4ff91ed87440cb9cb64f90a28986f530f879c7b7fd3b6d9f3d33eda71faeffb43c77eefcdba3c6e47f362a77c4c89cd19f17adf846a49e1037b372f6affd76d25bd95b97d2f5c3b94fd98d05c901f95f9ab9cf72e9d4c1f55fdb3cf3940e3babc09e9313fdf05864cd3f6dc1812007fec15341b960db676da2023e28e91fc1c8fd2edeea09f7059ea3b1eca3a1ca2663c80cb13f07a99a26e272099c788ab1a3520abf96c349792675c3bf92cf04c71722d08b443ecd659e913370dabb6e5d7ced9d50a786a83585df65092cc73289cec1f630f974ba8edeaefbd77d83a70354e00b113652b6c362025a22634f6eccda8495b38e7d1b2a328f17ffbceee2773f885bb74479a9b87825ffcb1f72474d324c9c7e77d2c49bb367dcfe6ed1ee29c327bc14b274f43f2f1f582db20f30c7cb706c8dd8bf9fcc47d6755ba57ebb213d0abedcf5d8f51be67c36f9ed1ec7572e2cddb6f1e2b73f8a4b57445985b8955ff8e39a825113ab478f2b1833e2f2d811f7962e12c70f89ece3f03fefc6ad2b3cf9334243d5c951d549142524e0d3a310e9335e3afd72dfa0366d5ad18e16d29f83bee7fa418aea937f43d929e471919f5dd676201425366f5076f491a0b09bfd0050b4a25edbc7a8a64c11aac9ec37456cd3c3876f222e15a7f59cc0fbda72fe9f81d766781a4801ca36dcbc4776cf99a97d27bca5eb8cad19a1d568b01fe257e856914557f8af978f927b4561e41b03ba1765c5c24702c3c19532a4ed85718405618bc828423765f19b4b8e6d105907c491cd899f7f22f61f1265a5c250258a4a8d1bb61c0b1e50f5de7031714aeea81177664c12fbb715c5eddafd4d58c28685b0b0c852435d651219f9e420580338f539de908e2cc08eb2e42dc6ec3d774e6c4cdbfe7545fa01911a9b3e7e8265c366515a26caab444995387aea60177ff3071f89f163f2460dbf327a9461f58f227e1f5c385806f810324893a3adc04795a653392f2c8f3d3f7fd7aad9df10ce9395b824f390ae6ce7e9a974ea239683aa036f0f847146d9be78e18dd908dc32f01c6fff5d735b150f5c0b4372974b2eb9f82e70fa9d9069193d278a8dc912f80b8529fea3783b6cf53bf82f1b88b7e634aadba1f25eb8f2bd43e3423e7fd9b11d46b5d3385adeb885ca6fa8fba4ad2f0654535803dacecda6f92bc19d60b5e1e99096cd40f6453a45f0df646e148e994c8aef16a95137bf9f93f1d9c7627b94282d1695a5e2ee9dbb73e66f6aed14aff3159f8c308d9e903b726cd19285427f18fc872a4a66742aad94329f6a347e1b7b501816b2ef48bb211463493b2032e3eeacfc26fd93cfc5bacda2304f54148b82c2eae52b7f6dd63cc1cdadf483774c5327dcfaec93c279b3c4490ae151ac49e6fd28309c844c4f34220a657a68909dd5670e5d3ab1bdc70bee1e0ead64a5b6978b13b2b1de54ff8ff086ab437b6ad627c98f46b361cf7824fd3d023b98ab4aba21586881e7a82d2978cdf4fbbbdda7a7058d15eb4f2378d344e4e42774f98c1ba6385a44011c75e38cc605efc8ac036551c0a87f7874c0873d5bbb61e80815254a874d7ab1e83c0259633b2927378796def62ddada3cf5d1c0ae79a7b640977372bd144f3063af2c8540891cf13dd5c8266e13297b32a68db83272e4b5f1932ab76c1437ae947dfdcdcf3ebe87ec5c4fdab966bf1820264c2b1b3eeed2e851e21832a7544a0bd4c1ebec26f07f1f60e2913198bcdb9cb2db98484e9d4064461f7b367cead591e3ae8f9f5ab2768db87c41fcfaebcf3e3e275c74276c6c4ef8b6171326568e197d79f4a7d5d16b04a2c27aca19725a089f00d6471c091a844202197b8bf47ba7bf3fd4bbf5133e0ead756d5acbee10d94be4e6d0d6cb05fdfad0fa78441d1cdd301469d790b1b70651fc4e15d49cf2fe5d514fccadd9b69a49876145563ed57f14f68055803fd5f963ec6e05e0b91e9b4dfa87c91004938ea7b2f09019c82d6eecf6ef179ba38309269cd25c2243572ee84e6dabb3736df55490afe3bc31ef9edcf40dd23022e730743910829c278e918c4e41183ad885b80a5017a7f7268ffab070d2e4cad1e3777b79af7dea999dcd5ac7dab924b978c63bb91df3f41163c78bd113cf7ffcb138b6456483c5c91d80a5ad859c89e03e0b21dbe4fdc6e403a6c4bd42bf9f0a784e6d01c7a78cf9f4c6d8b15593a61dead465c5134f47b5b68db1754c7474d3ebdac6d8b98931532ca3c65d19f5b161ef2a414541bb2166341901ba00aeeca32413944edade2b47b7af889cf272d08b6ead9a7b3ad98307dcddd00de8ea895739561593a1425a7b7e15f436e63c131cb24f59f1c8356a5eebb3a9eeb41ab7d1d2871ad143d17e8adf48b1f298027c7ca78f5088c955f1ea94ad87045e160a221684dc22f65aedd41cfdb164b863722fb4bb6c3842f8c2cebdd533ffece37f7ce3b748a3dd3dfacbddc36b51dd80a783c42b5c617e585c5345b957d87a29d12205fc77543ff6b33b9f8f1493669cefe29764e390e3ec91e5e89aecea11ebac3bf9dc7362fcc4f2cf465d1f3b5224ec42390d2c06d4d7525a5d323a43ce32ff3780df8bb8af39796fe5a91da042a18f166987b3a68cbc3d668c1837f1769f81c98eaee9764ed92e1e7a679f387b8fc32eedc5e4888acf4600f8ea036bab33a4f3295509957049bc29a388f823ac4b5404256fbbb1f7c7c253db0cd9711762767efefa404fdb66e8f002ea48d5a89d78d8d8e085d62e533bf6bffed26c9a86557ba712d5bebb2ff02a89680d3d96f9f84305f815715651dfe96300cf0dba7c06375d3644afa8e748b3805afdf039453d665c1d1ab6d077100c5438a6e4c6cbd26a34207a7b3841c9f5e9ec9bbe7b6359cade82b80d65c7d615c5acaa3cbdd394b61f116fd28ec9db5033c3bd6d84592a126b7b8d09bb45f2c1cb91d30b468c1563a655befd619ca37b8a836b828dd3615b0770ffd961af178c1d5f347acced9993c589ed489b92a8803788a27a78e7e04569dffd963b479a05e594e988ba908e8788ae4cd82ad2626e2f8dbc376a8c183bb1ec5f6f9ff4743b656b9fe4a03bdcc6696373fbd37d86148e9f92fbc988fc999344cc46b251f45125a803d36f8391485d3b30f152a86617c21f148c7a90d213eb730fad2c3cfa4b797cd48dd81d9fbf3958d7ba29d43c152be00951d282a65fb6b375fcd8c3efe2e099e830574b58d940d33e70c65e454a4b22b58239529023260be0f501a389e34ba0e3cf1524bdf0991678f6e81aebceb1eb8fc67c74686237ed334343a77bf4c4f046e8739ed30e810ff3d5cdc9c6d3b6e9f6afe797a51e2e3cf66bc9d13585077e2c3db2aae214dc77a54a020f08fd2e1433a7c2ba9d54f68a105eca5e9172d0f0cbf2eb9f8fac183e1622bde4ad77e2dd7d76b6b439d9bd873872589ccbb911392bfd934f8cf0ad93f722b7266ba8096940ced29e6dbddf32ec11aa2bd36f294fd94a657728af80270931b3fb97f39f7d543172a4183ba6ea9d7f27b5edb8abb55d6cd700b17db7b87af3f6c225991f7d5cf9cd22114f055bf00369a552e1af045ec682920978f2124fff5a78644571cc4a107ac9b18d15c97be337ffd0af8baf8b4d6b1f2f1ab986782ee43e6c7b046effeedc2963206d05a116b431f04ae7f96fef3fae75fd992c3886c3c0230d2b561d971c7fbe00721fa5d764d9615e16ea2dad7bc4358ae3e5c9d310b781838031ec8983a77f68f342277b171992a6d142de683ad6b9b8da367f39b893e9ecf1e2135bf28faecf3db28ab03fb4a2fcf8cfa8634451036a19b85e4a56492815ef5c4223f487c4c97df98be6dcf87cb861e418317a1c647ef1c42922255114de112579225b9f18364d1c8912e9fbca284127ebe76b0a6fc8d8a6252bb728c70fc7818ba951426fb5c5cad377c3f32e859989a65afd5e91b4376fc9ec9b233f33d2374e14e366944e9c2a8e1c1479b74549a1b8753d811cc82d02921cfe086a7252c9bc470c07d453a1df022236733101ccfbf80d79479617c7ae2a88599317bb2eeff826548b7c31f17d0f3b1b141ed3163c54a0a13458f569edb93fe0a3e20111e49849bc810e0d96953bf0aac30455cf8de5791dbd5063d84b8f0e563db6fbb65af5170af11fa0c5a9581e33cd4660638147760e99d972bf99b97d67c50c99f27acb76001e111a1f5fea8b0045230d65f3cc5f7e5e1a8af84c61ecdafcd8755845316bb04a63d755276e06f052c2939097c15a9201a4232187514b99182db28f89039bef2d0abb397678dea811f9a3c79f1939b674f77651962b2af34af42773776d84295e95b41d191d12d7f581875387da78e92bd6fc36790f58934bf129e49246811796cf64549e8c2afe22f2da679f168c18933f7ae2d951e3eeae5f214aef89f2c2caece49b5b578a94fd16fa58d4e845a338df9c8c8e1c280b5c0057fc51ae0f1aa4f0e8ea22c9ee001e3a0e748fdfc66f58da01f5e3ae32802da3da88e322a217d0ca75c30b6fdd1d148efa3be2753fb991a7cac1d6c9a25ae055eceb18f63c301e80deee311d311bf16b92f4e32f97e4f45776b651a3bbbfeb39dc97260878707c40e89d01915183c7f77eda95461d7920164ffbee215c0577a5e97f373917b3ad247e3bee3f3f764dc1d1b585475697c4d06bd5e9cd10eff4f8acae3097c8598107175211ad40c1c5d14d456b965d9f3b3d67f488f4e19f274c995812bdc3927e2af778b429e99025651f998a19c4d3ea5278bd265ba354d12bde9dfc2284db803d57dfb22f0ee0618d0b7450c46d295ffbf59d0511e7c78dd67ffe79d29409795bd65932e3ef9e44d50d8c8f5d54a697ba1d4e3c689a0415150b9125af94e7a6a1792faa20661deeb4f808113a56fea195a5716b8b12a2bab6757771914d583ce6162300dc75cfb77458da76f0a5212864225e07f0d44c8969b5d2e102676a47cad637c8b41e9deaca237297d677b2d8918ec1664dc4f5f22baf4642af33ed30a33f5c2106014f6a22ecc6a0c855fd3e7bf14907246421e9b9b2160bfde52dffdc2437e550c9c9ad4587a5aa3bba0607781c458757979dd808b69031107ef45422c7b59164e5e91103395094b80d06b3058c98b8531cdf21a23789a82dd5db7f31ecdf6e483850a13f68d01f00cfb10d5fab7e9e815480a78c3b39fa10c86ce1cb5f4995ac00af966572925e64c2a73820627788dd1bc5ae4d62c746d3feade527f7942751476679d2166ee8e1c08394554410a8d140550f16ca81408b05311b0a0e49f116b71ef75b1abba63c76b5381b13d8d1cbd11153e0e4386fb97b0dc464a736f6135d03f543a6deea499b7273993d174a736c8d122bd67dfceaf021a35ea7d616e72049933e78ba38704e027fbbead63f17e7769b041fac6693b0872ac4e0af07f0d786ce9913f80fdfa6b69d10a5c74029da778f4aeabcdd1c5bfc771314ad161fdb0c83aee8c88ab29855658757961e5a81ffe27180e359aa5362bb36f0e494a76cc3e2420918ea16b03e597c48a81c41b0855a5fd3952629343f23d742961d7d1a2fc9c40c7312155c933d9142711e4955dc4d471486021e2cc9b81476a5a83b643eb04cda256067a4ec1749fb45da21917cc0927cc894b29fac84740ad410ea8aa328dd7792557baa125131b6c794beabe8c4bafc236bf30eafc93fb2ba284e9a35b1ab2b63d798b30e0574f0b0024f763005343d5d3b3938fdbd8defa121e36ef50de56c3a8057479b7338b60ef02a97d7079e1274c133af854c491f16264e5c1765003ed794ffe9f737ba8c63e0894c10696f5cc04e1b5e00c7875f7979cea7edfaa027a83d0aad304190a792b853b4aed5634d4e6efeb13c31aa24663dc47bf191556531ab8b0fad288981fe5b83d43b02385c17cb05d16a1d34997bc9dba8c15daa4c16a154148ba808c500e0f17385e4ae6214ba2749abb00ef0125aae9e465b8c80e440730cb97cd4352d8127f90f2aa1e22d809d126d01f049d10826a2630b757fe4a0236f64b507a153c0d6f25b64df753295022bd13a188fa8de84cd884fc047e9b7e6c7adcac33d1edd80d7fc989505875740d4551edf70e3c82f2f7839b9b83871984ba95042e3b4b34bd0b30e3ff7ff0425ea2895648ca94745ee0ba3d8eab523b25ad7eebe6e1e2a70281fafcfc39e45a8c0b118a6ff8a8d4a910b5237376387beb1f0a3d51221dbcaa008003fc4e13928771e6d85c212cc34407d1562762ead9f081bfe0f43c691fc985ff3627fc18200042b14c6aecf87243cbe19a576b2ad950aeb1499c975d0d2d437a33842763b58c0eb88a58399c088286c45662575ab216d1b15bfa629d1f2dac02b3c0d534ba445194f6fae38b6de10ff2b7545a56e9786454dc705fda1540d64f1a1cb3a6d5759d69e525c401ae588058790711968ad82f8c9805d42720834047b1e7a011fc5a483d833c81721e792845f72635700efa2a3b06761dcacc24171dccff893a865d3db39b79163c064ca8ef7c476d7b547d2b299edbc80d751c8049f8bb7e505f0b536a0d398f75a83ae8e71c7c1782c02fe8345e262054aab9b504fcd82dde7ba8e41b1256c07ee88a8ef1534880810b20d9881691a175e890c684a834f68dc8d4c3c637c2cb27308db39db3c13dcc13937e940fea95df76237e51ffd157803785ab1eb7263d623c745a5aed6120c2e7de7327806aceaf4d6ca135b0c311b2d47b798633757c76d329fda6c4ed82cf43b2c945bdb064f1a825ad5e8aab4c701f9d6f89c941df90756dcd8be2c6fff8f6451a2d996ec7ffa22eab651db6c518325812fcb20070fbadc8478c0c9cda6131babe27e361cfbc5707263d5a98df0cef1bdf84c73e20ec4f921122078e00d22ad4ced5db892d4a8a2131b0a625796c4ae828427abfee85adc69feb14de5a9fbc6bfd1d7d3b685b255b61ca9ce7de3b45db1add3a84e7d2e0f0c45260515730ac7a3865dea787e55fd3af51d2d528c23f7dec28cbbd2732ad5dcdda56e492ab614cb8f2577198e6135d40e1140db822352f810fdd9fcddd8203a63e8cc8e8fdb50f70ccf88a254841b7067a6f7b06fb664f2f08a3327f2e23681d161e3941cfea92c66059e0b046055e236d93b21e713c9c606301902e022fd60f5918dd507d657ec5f5fbe6f9d217a6d75d46a2ce39e3555fb56551e5c638afb4560940db539520504fbe5aafe662daed44fa6eebab1edcbfc3ddfdfdcf1059083e487c1c8de04cb18c61eaf2cead962301edf623cb4c1b86fad217aa569f74abc1af6ae29dbb3aae2c0caaa98b5e2e466914484427d5e5046196c4c50ef2688a9e0e0ca8a98d525077ea83abab68c343dd2f63b4af5870ead5a1ce869efe5688fe82669770a70caad0965bf116a9306d9fb5e7a65168d4a90c11512f58172c4a866cf2f6dfe4debd1a94ebcd24c133823277842d6c4ef79036a5957bf4d9fdc7d2c3754b055cf92a1415caeb10678e436b6c93ed0fdb30e4f0378b9c922981e9073e7300defd57938b57ed1db79d74f8b511f5d7afcd7fc833f02f58ad8e580bff0c84af8f7108092f9803ab12342a1d59907720f6ea8dcbdceb46b4de5ee3555d16bcdbbd788dd6bb12cd16b1980f2fd6b0c473721b126a722ec51ba65d5164955c153e1ecee9bdbbfbab5f34b006f88df6406af433b48a75f1287d26ba1a6d5f1691527b7571ed850b57b0d7def9e3562ef6a81745cf406cbde0dc63dabca76ff5479701d1204082f52e3667a340c3dd02e37eb949fdc547a784de98115e530608f80e9d7e4c56c2a4b3b9216fd0bfa4690b6f0c10827373925c44beeb9287753c631a2782f3c639fd87f5279ef599cade13e27e6722e9d6674b548311df09b4a3ede9f363245682e2b68dc95859b48c653952d1aa68f5e4e193afd7ac8146e93e6ef68f89e28fcad2c526021de1814fab5ef50f4ffc11fe5b9ad5457e4e5e9820a33c4efe4f06817db165d3d1db62f9986a1539849547c6c6d69dc9aa2b8d525277e2d39b919c12f54ce50cc5cdaf0945cd1ef2d3db1ad72df2fd5bbf1a0d799f6ae177bd6e1d10375b060f9ded525d1ab4bf7af33c46d256bcbda51cb8defda00adc2f1fa5d77a2bfbfb9eb9bbb7b7e00f0b019f13e05d7e420059c2fed3be86919ffa1daafbd86533b187863d42ab11b6b85d8b5526c5f2f76fd2c76afaf8c5a5975f06788078496a98f53fa8ae614caf420378866fae2989fcb8efe5c02bd7efc17b45e94eb8fc46f5b33d8bf9343f3c731479b943aaa71789a0a2a9530be8b0ad2b087ba57db275a6decf2ef82419184b1ff34b6bbd983677d5fdf83bf0ff0a8adc2c083ae9333bb4f285c2707a250270d9ae333f333de997fbdfb54256c27871b343672475416301dd106ec9c39a2f5f39ddb38e136780002460501786f1f5fe27b9036dd9a0baa2b3bd83c19f6feb063eb96a0fb09061d3a204b520f66ed5e93b0f1db92d4fde891202e4ca1303b4c7d53f21e43ec56e3c18d95fbd757ed5d63885e0d615b11bdaa78efaaf2c33f57c4fe5a7d620749663d6575552bbd3ef0a4e3d18e73e217c040729e061d10777278985ab4a4558fb2192cb213f5043c04bee5e4f6ea984da6033f43c04869bf1a54886539f82b4c0d4bfc0e732af92388328156d09881e10c22fb48e2e6af53a37eca3b8d96ab835599876ec66d49def2d30f33c6bce86e87fe4072793cc90406f04ad5bdb52415d043547668e938d53ee8ca2bb3b1d3833278c00a3c09d7fb015f2755c3817aea61ed36e56cbf6922e60c216e84558fa6c99bc6b363bfbb103c11ba84f61d92fbcb35364943515ebf19984b9ffacf59439fd03d6747794654dbd16e01de68155322f6c8cfc2cac3e4088c027075707268d9bcb397eef5fe211fbe3160d4bf5efdfcad6143835e0c6eabfbf58b599854568e4107d492be432a4b3c4a744e451912761850b5719296297e2b6c3dbc634adc8d40294e20e4c8288bc273571b2255a6e70e59a812c4cfc1e810368a5aa1290ad6bc00fbfdf00cd310f725a38f93aaa43e10e139bd03797ad389cdf876f3a9ad209dca84cde46ec8c13b401da17e72e293a244e6d1f30736067572e919d8eedfc37a8f7d6fd8b877867ef84acfee1d5c752d9e907538843a6fa32ddb669551316a472d8d4173741ff2984eff56e4ddbe94a6e3882a0bf03ac15a55dad7079e237278cd1e304d9c2fa6a6491a85827f0ac5e5d91bd04c434604fc4528786b68b0516a1eb5d5b706cedefbfa94e027edb07d2a754a60cc286db34655a4b80dd4d95158128366dd2107d058e38b7d42506ce964d706cd538e362ded5bb5d2d9d83ab568f6469fa0dbc947aace1e85890ee0799891ccae729e9bc0c3e26e3a6ea4e5a5a6f8d8b2e3987f9d25532634508387e7b0d740dd52d6f0b06cbfc2e268bfb5955a765ea24a07574269185c431a7410757549faa02a31e4754034b84e4a295d4d9bf4eeebad9b3feee0dcdad6f659fb36cf38b67e4a67f3ac8f8b2dc43bf41d07b33167979b88b5e35c950db1dd3d301cb0eb5f6d0fbc35e3c6c070d6bfda4c8c362eab9a7b0c591d9f9ecc76bf29e903a6d2fc230cb3a46e598c422915c52b0f65058ca5665ab9b9108706ebeb8f07d3010aee6ebe34f7bb1eeffa3573e8e8820a3becf643639f680f1869a63aeb9c30c70a07b8b1f628b1255d86ba5b1daa50daa2040523c6d15882349e8babdd538f7f1f31de74f9346ab0a0e345c6be2a30ba126455a65571d5ac35e24646b852d40c490ee6a36966f7e9a09316dc4ec4dae097336054912729466da29665b2d2ba94e922692762341239e538876a2b382593b20d0bb448963c024a08252110247593b878e2f4aeb56d9ef86f9da31dd06d0b512e072ccb392f04333a29693296147eacdae57e6cea105c1203e8bec070c0e79a392de9f1af6b436731f04ae5a4b55a8231d2daf9f7051e8efacdce63723ffa067b09ca6967001ec38fb083c181ac8bfd6508d08f3e1da1412ed36c14c7a3a21ea19b499d06766ee38232121a1f2e81a72147681ca0e14fd06024dc506ee683c99072b718f878546d481dd4f00240076d294fe560e7d5faa984a835a8b9c6b0092a92b4b6b3d3501ac9f77266891c8fc0261820b166d84856a7933f5ddf5627158ea07afa2e7a853c97d9014866adb4d0004f44c6317c35bdcb49232909686c8e8cf6ec41d71c164dd04bdf83ee80d2cc183f5f27479be6d4188a893e72182b10c7544e9a718d9224b487a3831ae60e713ac625b223a78e3627e0c91076766b6fe7f2be7bc0c561b32186956a6bcdce7e6abeeebe1ccfbf85d6061b9fef3c527c7904de3bef4f23c79de1f072c9c55723f2ba4e50b620f98d9a3bfe20220839d4aa2e6584ccbcf0eaec7fb876c18eb9d84dafce3e53da495f1c9f522662c8a9953ce259f65750b90ea694c2e21de4e75b72e6388d1841248413b590a25458b10df13b1e442c8940ce32a4d4aac49ec27c5b2184297e4e144012184a1d110244e969c0218575b75565203e48bd4e081921b0aa128dd532a84b34d6e0313b7b5217246da7ac12cc78841aa98f7f2f80a7bedd9cb8991fbfe1d4f2492a9ba7394e18aa5e7b407bbd09b875c6a0a95314a820d3c5a5bfad4fcaab33f27ad363a72a78b9dd931ac45593315ac95f8bef43a663c39bf8e73f12a77311a507da1889619d7397577df99d853703266042126f66745f3f5e05be860234d39530971e3bcbbde4d2c9c3193c4d0148ed98dfdf00bed61060069e14809b0b760ac288b3f9133f365c3a5d997580865ae11127c92e2739898a542c4d2eb1f222b2e04a6c9fa434576e411e40e653c925861426917f053941920091dde46db01c813d8aa5d03783ea4aeb6824653a9292da519237729a52cd040d59be87ca7f8c46822d99b1bf3411e537e498982f9edcf2cdac0e8e2da890121d13bc95216d70d7e87d4f584e208e1368e3ba25e4833b4322c0b850c41cc15581e72dddeb8469d98fb792c2b49b3da6ecf3ff505c31c2a4e751c64de4f6d1d8684e18e66c3d1b341635f790f3b4816c2307ecd106a4fdc30f76ffacb70dd9aad4052d7b8514cb45b32d833a0348a56b952154e0e91c341738dbf8da3fb36bc522f3b5e4d20c8c3e400f2545f4309596422eb0cbf454d1c6ba99736bbc94200c66e6e8f722ab468976500c25e2a838029f00a24168086116c8fcca4c69a9f10414d51e94a33738786c4def2a3240311511c94fdb87614c607a84172975944edb1e641ededae3796ff4c453259dabb2d7490dc7d7e375ebcc84fb90853afeb04b6ba779defdafbc3a0b199aaaa0d03a7b7caa4ab98eada70676501d733e60ec89772264cc4e995c6e051e4e7dcce553419fdfea250799c871390dc9d3a8ee3ee82e7750c4fa4e6ffa379371286affac3bd85b1dea587ba4a96656b5b2a50845faa80e5fe7e866db34b09d73cca61fcc5793a4b2df0e7bca9c4985d854cfaacc9d551271aa46e79428353c27470bbc9ec6f8825d226b5f65fc26417939944e6c33532de54ef4699893b6a0f8078900cefa33ae6af18f5a06c20681a648640f062083f238bd0b42c40cdd5b49075feed9d5a93536b9a1782529781d360da7fa7965d6716380a75d30e5360c683cc5ce6d092f4dc1f67de4726b92721cbf53a3f79cb5d35afee0fbcae019c95d3e2d597b9842375534cf14634da5a8a7dd682ce2962566e0d82bdda750f00e7940e939fcae71a73a1828e4437bec428f7ecf37c75e1e34c192c7d6327fab74ad9de868e5f8bac0a3a74e6e0f43310d4cacc6c0d041419dd30e6dc6cc5a532655c570851325c2e5c869068c6ab36487ba92d9434a1425fac9bb91c7431c171403ec6f6f5c7666d9547170ad40603f61bb38b949ec5f77f387f0f46f260bb0be266dcf069d2afc157341532b006180ac2be91d5459a1d9e35c4c79cef10f5ee9d3f2a9c7a9430c734ebc7ce8061f4ac8f393e1b101307f3bd83bbfd4da675b9f4feff40fd746e6eb6b5e15783e4d392170ea69ffe1e27ca1a832638831c9f86a75870a4c352d1459e3bfc9ee361ac28468aa61c03371e1641063d64b332638053cd7da59f67ed6d0b896bf1f003cb71310d17878d9a3abd4bb2d1310f8deb1e5d36ff6f3bf99b8bbfa5c0c627c259438d98f9e566063ada490c05b675cf1c023186e184e0173dd82f187c4dcd195fb57ebe78d3d39f9bd6b5fcfc85d33efc6f76169d33f4e0dfda470d757e07efc49999e462691fe268f6e3bc7f538fc67ad1061f92ff387a8ae81ea81cb7e21aee2ccb1b0cffed9f2f13f5388025daf3eed49bb935343614a39dfb6d11bd7f27e0c3412d959d7adb9f362bfd7b11d37cf86bf2fe4aaad4d8858818724bed175ecb9376723ffae6c2da86e3f26a7dac29baf167bf4a92f0cc75c2cfef4df5a6a85af52f22d43bc18b47e6cd0f877da74c4d689009e37586376d702afd1eb750796abc083e329be0b0b4f7a3eacef6d9b3ef67a9f2eb959b1a6f3270d19872ab1bb00aaaf8065225a5cad55565c5fa5b85b5445435862788e7e57896c811619d1a57b57dc5931276bd6c8c489ef02f29c6fa715eff95e200748a5927b902795c0937928e761d2604c0578758096b5cc86ea85101f3c73b438fb44f888f7dc6d5bb839d9935ef744c4924a66db4b3f1db40bc545a3791b23e7b9f0925c621e716ce3f4a94f70ce40da534e0bfc7d31a2bc898ce78314727bccc8ee36d2b470a7b2a33c8237b4fb90a0edc7c8cc63a72e5724f88d40c8f6c19bdade17780c6adad5eff3a12dbcd0fa0521057f9d04b5925daebb71b456f8d71f5b4e3b0b21d04b93d0688035ab0c2f57274c0b7da3afdfddd458713901f51a542a9f48706a74339b75d6581bc23b1457d95d0ccd9d495db730eea0cb45fc76716cb388c3da2892b6229b0e8091a3538aa5a49128eb3ea8a94389eb715db63421b92a041f45ad1ad9470c9792c3467ee0d2aa99ced1416d16e3240571bcdc628e4497758faa46c04f2d2814db26775fe736d0ae6d52bf493cff4e8dd7d651e74c139cc861b3ff4ecf1909dd4789bd7207320bed3a85ade6c88fe79de868cf41307da1281ebf1a434fef5b7dc56d1caa35478d76d2ebe3efc65cfae5dddf0978d609a3d729bf048b4633c1538b74cd9d3f68a382ba7bffe113bc9c1df17c7b3fef83b1e5c64b27abd0fb2ebb5e28872b1b1868030a3878a868a6980c55c071c6858a5fad23aae5d88b2858f5a8bb02d83cb598fa1f641d34969c508b37a1f2ad255932520b7381a94aa1898c5de2d2f11ba7f7bcf7522fbb679f74717004b2dc29267729a0fde9996ba5abc29b6c346e51f9824ce1e033ddbdbd300b1aa3c78bfbcfa63d05ac8116ceab71448fbb2678db772ad343ed86dfb42b41932e7eba4c5c2ce78d46e1c10371da5b5601de248d3d8c3edb9185aee9bb81537e372dab02cf02ffda90086c228a6c2cc41c12b288416a81bfef3d2be19a9a01deaa9577ff07e4e3eeedeae040295d5fe76d2be6975f3c01958fe967847df236a08ea10a989d41ce1ed8111b8c6992f15c5da3988108db65ec822347836e28f0c735fc3bd1d1815c2a8d2845149606ac51e8974634a07b57d6d3c9e61ef2eeaab3f6894bc7ce1cdaf85260078c5e455121420fb41b01b933282da4a501bed68cfac6c04f9b2c912bef4e2352da35b35bd9e9cd9b03c3319facc673d300cfb5f7d81aa6b8a7ecafc650c390f02cff31f9cbb6a3b292b27132586b94d84b515f2d51c788534cb9bc5899facf489009d9840fdcc55cadbd6719707170d8844efd30f884ac1b8a5b6867f6d6ecbda635f255af5de506edecfa3a73ece979e93c3afab6d3611a1ebc64a716df444ec8cb382c2ec641e4c29956f796927df698750cf5ac4e2c957b18c8e6a99a4a7b2e8256623ed44d4115191485dd89324e540020b9cec390a9ca4f56fc410cc07ec4ce759855bdedbbb93d9e6febd8f2598cd327518c69fcb4ad250d2baeb3cd8a1569eb766b0de67bded3b006f8364e339d7b5c7e791672df6a0d84c2f1c1345ab2aa7b38c2baa89dc4a21390bff79f76aeef3411778ed89d3725b1ee2f69dd5498747c351145a1b8be684b46f0fda5bd6a4a681bba284910129a3378fafb5e015ef634ee80a8dfcac772a22101cfe2aeb6855f037d1dd7ae36eaf29129f38f29a20db3d1c5be9553eb27df7db97bfafe0d089661c2189c2b4c33206b2e99e6520224e6723539ab76cd717847c668b95b4fe9d9e3f83f197794d4276f8d834254d6ada79e6dec4a6abc147f23f9f0e48ffe810a49377b5b3767273519810d0928ef2281afc7d6b548bf814ccf431fb940032d881898f0ceb3edcebc1979b70ff5d6b08655a68d4be001332ae7a008107e251b306426f696bdf6fe3271ab8a843bb69b93be3be3aff8f10ad3c3bba7829c1c4c5dc21c2cc813d56ed7f669f27c6a35018003ec8d993568ea2b4e1d79cf60c61857cc33dd7e0bf8dfbafffbf03acfb9f6f281b58cb8106a767db0aba09b23129dedddda2c5f30dd783d0dd6be31f330d5ead02cf37dc52881b2d6d0c9766599d8d540cea86b2b71412ef00015e0699b12252c4f2339b2118b3d2e6ea71ddef453d7b63a6c8504538ed32db80bc69b3d370e5da8ebe16276563fbe0678da69ded1addf5f1d12fe11a64ccad08456d1ca42d325312e05e3a37b84a1751544807da55242c6567cb38f77932699ce56bcdc9c44d96992a33824ed411ad89f66f48fd8800eda42addfa80fbc8a3d80afec1991d67f52af966486f0b6cc2af00aeaeab8b3daf19cfb62af11955afb08793dca7850ee07a84395e8c06dae2e8e36cf3cd6a45b3b9713dbd71465c5d1de8267e3307b02d853789ff2a4b4187b2ea15479bd4efd3565d349c8932907039eca7eb09b15066962fb99b37149d1ebdeecd7ed99ff69e2ea688b5d68652acd9b1c1017ba0c0ed4f07427b6e65419a66e31da4046d79ca6a3be792ec972777fcec93df02f3687df9c0a35cff54e9a8c1cea2ca8308b6a6579ba85df54d4d225be1e262e54a0b492b690e5edc6f81fde8c088460106603362762871ec578ab8e67f69a743b48ce4093b65b9dce6c15753ea8e81591d07b6cb7671ce4064214baa189ccd8934d65f7fb017f1fceaeafff24afc37462de52f7b391e54aea16763a07db9636cd1efff7b0be512b17634aa2b87452e490ddc7613e9a3b6875c6a85eb6666eb512dbe7103d8c036ed39181e11d18c604c88bb36231a97efcfb7fc76e538ed879160dbf3ab9d9bc2c27f46dcb031f60747346ca03752556c8ebee8ddb58e0699c37665b4b2e42e2e379278f6e8fdb6e7e69d4cd4111048a1578999d23e0a91433703ae26f48e1a0223bbdebc84b737f21348dca96630abbabc0b3a5c7fb89131540dadf1469ff9c03130f3e7d9d109e9a96e5037c19cdb8ea151ed773e4734fda101a7810780a1278ded99714fcc302af3100a9bd8837f6a103d8cfc8dfcab67b88010c847473c7d600cddced9afea36fd71fa67f7efee0cfa69c584c39a6c0ad94f9ea9c3b3a90597c6ba50de7752868832975d5a9db3046c59473f846fc8e8d5f867dfa467f6c486cdffc4932dd118975f7f2f5690bec59b6d356e35c502a371ed3066aac42be4668351678f5b9e10f91ed84a87ffe099b1ffabc7773c82cf6df38a62e5d3bb43e928287b145a53432cf72bceba7e2722555d8214c6b657496f32004da70103fc66ada3e5ea1081c56887babf7a7fb8fe64a2c24eb283280cd2ba4fbc8b97d6ae194a310a95667d09ced5ddf81a3c91ebc0c5990ac530c9f06dbb18d7f348a4455c2daa8e1d139d8b77c063b86fbb7d3850f7fbdea5c6c7112060f45c3d187b3471535bcc314f2e83cc4403a75f0df7082251df97574ec6e42b467f33733bbb573f2d6d9dab67c06c55218da23c7ee7ac2a5942359dda8e141938378e82b7fc01f72010bfbf1f8d24e3acfe79ada2f0a7803b371786e0d876629422781a011a8fe33e0c2410ca343e6ea675fcb41d53238af022f95ba34eed41fb9470dbd6730d1a979d5d8593a4fea0caae886cc97862271b976d321d9cd756fe0ac759dff8ecb62e0d99763cfed8f7e3af816ea3f92316dca0c797b4300605f42c00fd62fd0efcb3db6b1e0e87af4a6579efe85c766524f4c3a1a19f728e5f454ccb91d7b91941c5f577c0c9debab8a53767d1936b6e9937f714021106ac1dc1c511c40c68a752f152e24f9436f4d29b9c41ec6acd13c406d1e1d9bd9cfeefa0a03cf563d87669921b11d705570445197497782a7023b71ec3aba62a1de6b50b7625d17f89a20bec94c1d36df1fc6b00c3885c8d7f14c4c1626dc92836f4257075e9197c360ae1fdabdfc9f029e93192c727986225e51befdef7e5dabcfc6151edd884696e203cb3173256ffff2fc83ab73f7d3ca3bb026efc0aadc43abd1a78e13681d5a8316f6bb875695e90f7c376b7acb279f82d6827941521d9a0b8a85cc16985b72ab0dd2658d8bc435ea7caabb42811a939727bc23527aed5b38cce83ce8c64b043c43ceacafecf088dda0432268270abfb11766ae86914ed97732e395024b667bd6e90ac753c896dfe6101e344199191b1326bf1e7639702235eff85354885bab6a323fd2af43eb0cb4ce179e0311b6e32e10d9395593a169d40d3fdcc99408918960fe5e722eec5a7c30a01b1cbc7b07d7a091c578745df9a19525875796c7ac2b3dac2cf4e5cbb5bafcc8eaf2c36bd1e38246c6fc23ebd167ff43c474db679bb6f7ee00ad050f02721eca8b81a7cd16502fee759f3dc41feee27fdbad55b6238410a551421e1eed5a394eeed80fd3b0d41e690eda2b1c1f38b3287066beff94ec7e5345fc15da281a225c63c9aba84b77cefa43d8037a96f6001e65d7c5a2624d6c5ae018b905212978cad8fad39e72aac0278eef158a1a5064e23b3777d4022f35d31f2b0fd547c6de33a3cedc8f4ceebb03ba22e49227a12d3bb2bce4107ab556a139198dd96865428736e610d128a2232b4a0eaf283eb49c7e7b84ba97110cf82e745c9ba7fec61b0761f42016719ee2625043a00cabfd811c2fc5bbdc7e518e95c08da1a809c04fe8d097391e721e9023f906550b4448e0074c43e7ebb9c0f1f953d7895c4abeb0d95e5bbf4bbc7953618ee4994c56fb8e953d7403027997ca2ebcbde0c28b638a7a51e89fe7ddaa5bc7724c1711c4cb432322dd7a637fb9ff14c7f3fe5e809faa95a57f85294bff1ef042c5998318338406d5e2433f6295c9890480bc06f8d8559846847e4da05e1ebb12e7007bd454fd386b82c3b38f63f628d85b0bbcd2c2ae6c16fd07026fadb9b67e85bb473b9d4787160e533af567e02180b5c073c405be7bd2d06922f6225c33f869cce2bc143f9ef99c81675ee71f84f0980e14dd004dffcbe9b4de136f064c22396f9d76aacdf903f88b2f4784b9f6e8d4ea3ec0b36df248d66f45c1d8a4a72a25e94fb34b0d1dffeea06e00fe6eec7a346282e989c563d762f1201afa2f5a18d1a629174d6491c20027205efb4de8d8364ffd95be111ebb9c3ec87936b6b9da6197026c70fd475af50cbcf4e0919b22abbe83ab2776630f7b7e08443d5b766a8da53218c76fdad9a0f1e767af27ed2edb652860c768d6b5ebada29e3c7ceb192c0394ffc30bbc27ae8cfbf162d0447c0d19f9080a5a2725523b4fd04c88fa0bafcc9ae9da03b537f539feff007855c8abe4451dc6b6cddf19f002443de64bf1e80dac82c3ab68040d7a57b188ef49d417c762fad26a405e767855d9a135689d477a6679e424db67ff0add8af080276d16a6e39e07e952bbff1fb873809cc75ff9a208df05794b8fe75c29333bf7c557003c2060cb8e653ecbe03b7e9332074d17374d1275556bd730bb2a006ae97895e96b0ec8b51394c03f752da3efe4dce069b0f0f10590f69ce4878307a30f1c7fe9d548703c8047c806bd3218daa4c4b3fed73a9ec2619ae8b77a4c0684b5a68ff1d69e09eef7b06ffe41ffe7b1b70866ce541c5d83493be8502f3af85339460e1d5a0543aff2d0f2f2c3cba1fb4b8f2cc76fe53bb4309705b5b92b22c6d83ff1a7f69e98c5ebe0e9e9e4eae184d814da20109754b6c9ac2dc6b854e6d12ed2eee078e93a2243d1d1c5e385276dbf0a7a0b1970da4fe2c5c95478290b7230212737706a52d7cfc5da53e48e49a52d4d751997653fde5a6d632dafbe0fe0aadc977f83130b8461e12e7db791370327c38ce79d0b69c882accb40b51d443dea7f9f6b81e966948957ad7a75aff0877b22acb955439d02035c8d2365bba383ddd34f3df1d85fffe7bfffab09affffa13bdfef9bfff8483bf3469d2fb3997bbc97b2f1d587b61d78fd7f7afbeb267c5f5fd6b2eed5e7e7dcfaa1b7b56cab5fceabee557f7aec43bea9b370faebb19b72d72d47b8f3569f23f4df0694dfeebbf9bfce9bf9b34f913ad3ffff9bff08dcf3cfda49d6d1b90571d9a8385f15bd5b47592378d7a20f231521fdd8b8fb559d3ef23f8f100de104c2def70b0694357ff6997fcc79ffb7899b883c0ab557643d4337cd6004e0dc7b38effcd1fa924e8a7c2226e8ba34326207343115c398b07bdf61ccb03f097868463281b8d2c96997800af2064dd24be71f76975c99889d5c51f4216bb83dd138f3f86aff8faab2f525392ae5fbb8275cdfa73fdfa751c5ebd72e9ceed6bc25422aa0a45459e28be4daf9505f4dff27c519e2bd75d51818503bc932faad068725b94df11c6e2e282bbe7ce9dbb71ebe6b51bd76fddba75f9f2e59bb7eedcbe7df7fae54be7b333562fffa177f790c7fff6575c09e5e0ad510484ee556aa873cb0f073c191632128ad22bc4eafdfeda26eaf509370628d3cfa824a267386612dced3629bdd74471fa2ae5ddb9809a153cfb689a1f55e1ff1ef09ccb83c428328ba317e28346dd09984cf91f6ba0185abfa04f38d55d3df73a4c0fc843ea8eb3ee28a6a6521a057c1d36524d36e4bea80ac3cec6d6a6f5e2450b383061ad21abb14ff93671c7d07452e6c1b1e1aa137375b5d47ef44bae41c27fe5598ac98bfb846ea37770d75ca2446cc39f6d112643359c1ffa432c737552e2e936ad5bdab469c551046d45f943dc6ffd3f21c1463b74ca89326eee2f387a747fcceed8bfc26ef6a3e115ca462281d368fb01bf51e29b43948fa10b97061d63afc8f8daac2d6ff681c0cb27546134b03f085bb174f1aed4eee3e02c5263a59cab4a0d793d66e6f68fd81ef03eb64fe2ab64518f0781968087307d55a75c159baafe7672b407f63f6f5847c44c28d6fdd11ab1dc1d586dc2f5032a221119c562a297c02bf567d6e01520b6204959659667928a4404b38e17ac500c510f2e203b2b03d7e6608fd1e3d4070976e720527d81ff5b2ae00124a254db21e1494fd5031b760e7bca3de52ddab9826aeb64f81c40204e7775fc4fe266b5a820a82539d3bda917ce545be7461e043c2771a58e901444b13cd3f991df60a7790e15f148169ac9d163666ccf119d9fb275419a44ce6f616b8b1aa4913e6fa4d5a355edeadfe24d6727076cdbf7e9271fc954a264778d27c224a0ba2344abb2a89498bbda204c4425aa47ab606fe56a7e28d2ad6579009f964fe10206c80c0b8534e94d3a41496fd3ffcdab562e6fddaa059993d68af2fb02dfd887c0215bd97649c0c3cc6bdfda69a44d97ec61a1d0ad1c41c193bfe13f31e7d55922f936d9e028a132195950b1e36e3293acafefcfe11d097c1d72d068051c22554fe2038fc060261572ec1c9cb79b2f8e27cb4e46ec417a861e548811dc12ed622e72f74499a9943ee84300af8a7a55a9331961fca3abab6b6c6c2c636c341296da20848abd72c0ff20f1480169a21216eed6fb03842ccb952740444214251b0ff8878027d4f91413825a1278f56942eedcbc7e232820d096f694a35a7abcf2e24107b5566318409d8b01690fcb09a1e2f6cded97fa0cba3e2814638da988363814c99853c1a3c40669c9937262835d534429fd7826855a40370478a9ede483902484ef307f77086374a81297e347fe53a99ab3ef94971cda0366c5ea96594b1e70c8d2fe3e25c6d65dd56bb8417d52729f22cc46f37269ed62f7944db3ff6afe7893a68f3579f3a59e1063009b91b1069855aa6696ad414d010fec2effa01ec7cb28b515f81a065092d61cc5926cae6a03f93f9602f47754a56e9a1f31b5f9934d9afdad499ba67f72b67dd24367e3a9b3e77db391c6c5a27afb3aee5fadb632b9c572bdce13391489d43ccd93f1f6ecf4acdda62e6f63b31f2a790a0e454c1e7ed6c5292ba815b2d24acda4d0acc61d8b2b982612f85ab7592b2dab3e30f5c00ab72a11e8af6541e6d5d9eb32fdc770ba16c057759f85268fcfdbf7f46aedd001f780ca38dc2d8d3c824d4e234d7157c834c136255d8804335534c8e11772e70aae5b22fad079500db58b9b8b83bd935d3317dbc77c1dffd4dfaff9e2c90393f7cc365dde6abe1d2b2ca5e03ca56c04a696154cc9a76ccf5933135a32d7507cfd1b7df03bf5f489c2054a2cbcba5494e6945eda7e39e1ab6f67bffa5a3fc7b6ce7ff6707cc2d5b6a9ab4d1b4f07f7b670c225897305225b3f0aa8e0642f59978d1ca01ba5f9391dc7e52768a540c10fcd7ff6c6a694ae7e4d9d4ef61d8f923a1e5274bedbd833ff9a8f1e18ea7bb4ba5fca8d684578bd602d9ff340e3ce2af088c05592c111927d79e2fc074b682b624c34c40c35bf190827cdf57f0d791a049868a77817575cb7bb0785bd501b094940d3b829694ec524e4fe50970c6ae87c087b626e675f4f176f9dbd7dcba7503a1dd0d1f9df2fbfb86ad1f0dbfaf5e2de2ecbb575e60b3f98b29755e6c0accb53843629ef9a004535a9a4fb01df389ceb7a07355c20c5a6fa435e032e002930c33dcbade395393f992f7e2d6eaeb5dcda547269cbf6d55386ff33b86f57f7764ead9c5a3cedeed8065b4de11e69833114717879230a4bb39de5f6b2043ca6a2c879a6bcd13275dec8ad664963ca1c84b7b3eb5b1e5d113b470d354cfa732f8e46b9ad48cda7c637a2743c88dfbcf2fb3e80dfb1eaebf20ceb387c57b149a4e7a5fd6bee65bff1152f4eadf20fbd3778f6fabe1ff4b3f16ee740b924c4b73d3c9ddc3c9d91baa62661144879b7437dac17026eb24e09d6008a15c1f96895a2522d57fb36cdfecbc7f97f3e7ce3f91fe6bc9513b3c4726553f5857586333f1ace7c5f9ef15559c692ca8cb9c559df0acb0d3c6eee03224a973257ea23885db2c655c92d0ff97134f055d1fa8a8957fbafa42169b5fea4b427f9694621639ef1e2c19294af2b53e757a52f34662d359effbef2fc8fe2e6afd712bf59bff4bd916ff9f977b0b169fa6757671b8492dbbaf9fab8623f0ae20f9dbb23a5f6658315ac1868430c45c2b6b3aa6644a64087dca0ccc487be38f4ea0072e46ef94dcc79395ceccdc44ee0b8228860931965758a826f209d371e78567bb8696aa93f77ee950884882b02c372fb841d1f3ce15dbbce1ddbd0be3ab82b37770700ef86fdc668e30ddca52718dbc7bd2d84398d40920966927b3a07079ba75c6cfe3cfafdee07364ebb9df6bde5caeaea9c6faab3979ab3969a321657a62da8c403cd5e64cc9a5b92f1a5c84f82b2a93621a85423d8c0ee401daf1ac3947f5b0355c38e5953d45a78a6f2b1aa6f82bc380702e4cb45e585928c0d55fa2f45f6524bea5c4bfa5c63c61c63f6022ccba56fcc5756969d5f9bb867e19c096ff8e89e6afdec5fb003233654c67e936eee4e3eeda8389113be32f025e7405165be62150178c4bf7d1d9cfbb4f2f8b1db3ff287cc4168967699587954e493b483f75929cd51ad71d310ec1f047c9d8758a3e999a7d06c8d82ed5fe351844fed763dc2104a5ce4d6d7af1555d9b247cb7bc6cb725b576f574f683b94add126aa58e87f767372b17ba6d5134dfe3db46dd29ec8e233cbc5955580dc988969a7f38d19f34c99730de9b38c6911d569b3cce9b3abd3e794ea97555cda254c578585aa474d06c56a636254c45d6d0dd790a7a039e7c102937d48a603981706b0bbe97a5451ea224be62273ea6c4bca6ca19f674e9b670005642eaad2cfc312e7be325dfcce7061f585e35f4f1bdedfb9cdffd8b47a0a7d7132148f19fece981704f52765a41c0e28e9406a4099f2f7f6e864ebfc51ab4e498327232d8276e6bc253bd4ea1a766d6accd206df6d0380e7e758fbc315bb1a52a64058d61d4fe9350199e0fc7eb38ff7183da89587afa323597672140a0d3d43b18abb4b3bccb694a5310874a092c9ddb18587dd5ffd7d9f4adabf54e4465b2eacb09cfda23a7d9e25731ebf56a5cdaed4878becb92233d2a28f101991226d4e55eae2d2f4e5d5370f4aecf385a54c9861d156d1a28a132c198c43d48e02777c6c0d69fc2f8fe9cf39ae27bf085f5d9d27ee9e2ad07f091d2432e6e1f244fa024bfa7c402eb2161b53f0e6029135d7a00f3765469a73961ace612fe46d1712d6fefda5ce6e0e4fe8ec9aa2940fe9ddf6ae9e342bca5a8b6c1d78a74cb2c623f36be5fc95f7e00b4366a6048da1228b0269d0492254fc0e7633ea89bb079041438167fb8ef12787811d6869dcc0d033af3a7aaae7d8eb41536f0d9b3fddb76fd7d6ce1d40b8883d80a8bde08db8b878c8cd1465565be7620f9fa78bd753f3c6f52a3bb7ca7c71b5f1cc77a6f46566fd22634a64b57eae513f5b64cd3765ceaf4a9b032200a39b5267cb273b17fc549e3c372f69a9e1ea4e519222f5fd3d987bc29c2fccc5520c145a97fc2fadd2ffedabb944f92833a6c4c9afb020e67f55dc395290fa6db97ebe38b3d09434cfac5f8cab35a4cf25dd94b6c098bec0a89f03c92fb2169852c1fa0b2a321797652f83952a6e6edcb0ecdd904ecdec9bfdad1deac4c12470fd61e2918753d36806d6879def61eb38b88d4f7cfff159fd279f9fb98250e74a3a5e12effa31f9dfe5fc46005fcb1194df4adfc7d8e78ae2afa2d37a4cba3820ecd0d089c39af974b2258e974147da880ad8c3bcc75e9a5840bd5fa04bf4ea71c60bcbc5f92f0c198b8ce98baad316e1e988b34b4da973cc19f3f1c8cc190bc137a6b4f9e6b405601dbc4f82342d5264cc31a4cd2f48f9a2287b5df99528d39d5871e7a4b8132f6e2756df4d34e4c61b724f1aef61c557df3d8d65bef3085ecdf712cc77e34d774ef16bf9d52305673617a67d5595b1c89406628581bd18c0936eca9c63c85a68c85c6ccc5c68c95c604e03d5ceb1a42d36652ca1934122e911e2ec42e8fe84ddb3de7da98b5beba73d5c1c200861d863c69f2ce3a4a633e9d4b9b57371edf294dd1cbf574f0d9994377dadb86de0081477bfa87572cc8a8dfa6928f0753f94c98d4d0a7ca974eecbbeda93d06fe2d921111b033e7afe6907771778e7e4aa29fe2b243f869736ffcb2bbdbccf1efbda7c65bd296b09443a381bcc01a56ec85800bd8e05be01d8b4f48b68d131bf3947a4418902fe39c6f4c5e5e9cb8ad3bf284effb22cf9cb8ac46f2b127e284ffabe24655949eae2b294c5e529785d5a92bab431afcbf0e765f884baafdacf595caa5f529ebaa4346d4155e63cc00c8184cb23e0d3165467cc326686c3b833c81bc1012e9b0ed21719d21757652c05959b33675767841bcf2e315cf8f156f277133eec6e6ff3184c771ef208d3d7dddd8e7af064a364db368e1f35ef7070d8c49cd96bc42d03a549ad9ab7c6b2b52ae247097c8dd6d068fa1a85cfc0f349c01ec9cf2f77c5f798903464e694ce839f7fd6deb7b5238672429aa186c4d3c1d1b9d9df5e0a76cdcfde24ae6e80dc33652c24e696cf084fcafab080f1022c057ba600093c8b7d021ef2004f396d51553aacbf48c87f91b248a42cc5d327459b364b9e03fa78b825c98b894cbe5af4b3ac2b82ac0d7c3e199bb30c59e186cc59127849a3784d9f05ecf10e5f2a1fc8bb5b40822d6309280056aa312ddc9cbdb0fa0ce615fc547171c3d4b1439a3ed1c4c7919e15a6e3219e01c54fa341db380637d7fd18f8cfab116bc53de460acbeba167b16bd3571e886a2ff3bee1cab76f698f90b94488e6aeca95f090a4027468149fc72e2f8abd3135e9efe45bb97fb34757fcecedddbc913a87768dd7cecb0a0ca33bf8a0b2bab321683ddf12ca49c2746970ccdd02a7c0f663266ccc66296a2f7e5af08e6543ce8c5005efe214881de11f2d157e3fc8cd956a22121d1f8c57fa57dadf521968c482c736624503764e20ae9daacc289ee8229953e241d574237450e1e4e8335a05f0003100786e44596f4aff02acefd24f276cd9b30d0b7e963ed5ab481e7e661e7d4d6cef1c5e60eff6ed97e79df0fce7db949e499499f42c21b0c5a27968f558c1a63dbfd5e5a169f5513e2d718f65a8f49d1fd941a870632893c93d896a87f6376c2d019dffaffebdf0e5dfd9f740cb4b19bffdecbe5891bc4f915d53076d2e657c3db495f480e3af1373d2fb0977c5e9245a02969cd964f56e51b920a74a69e1e348067ae22be944e148e8d9910b6b3e8576930b5e8931ff5623ea605a224ea248ac49558a5947e114890002669a1dc115f0320c775c2d71799cb0cc94bcc695f8ab4a566a88033cb2c177fd934e3937ff9b67bcda5fdab4e9dffae7b61e273fd77be3e21ef87685160616b0e7a9d9343f5857ded1c448398fef743b6d263adcbe82a4128a873ca0a279a10c2345345c0e1f3291f2cca1c18aaef35615dbba13bdffc97f1c88fe2dc8f96b38b4b926710fbea590baa4a5dba4330e3f591f299b278e4c574404fd9aa5359962ae294798bc40358302b145a966090f240b25a6357cd85a957a839a8f934964fa030181caa4697dc4f861e610f512417cb035879f04de0ee8bcc85d5994b2bf58b8da9c403885b08c430127fcd9c36e1d4d0cf4ef51871b2ff84b8bf8717ef88a74889445df5aa6ab2911ae67bd4a2de6a35b078572489f5fbee97f321fca9ca05bfcb1722f1eef50fbf4e09fe2c71f0fb62f5772273a5c8861107f536579c590c1b5e02ac4028f998b067e0493ca6935e944bc19e215475a7468fce817867f100f10b0a60c96195b18f1678abdc060713a80433389e0c3a95fbd3d82065812f17e453fa0298b130662dfac8aaa470dc144293884b4aa77fa13969be485d21b67f7ff98de1fae04fd25e0915872e93e726d36a92cda8b68278590d4e6aa5eea3d5f17590c6972ad93d1602aa676f250bd4ab28892c160868b7be5595346b41dcb44f45c62f42bf0c86980991b8d47044395832934a96305b552309ccda225afe97a43acb6d9c5cf38ef2218a84602aa133ad6256150c0f21f0d52ba97f20953a53aa5431ccee44a060fd74a818be2fa6bc1aa903d155a98fc4bd8bccf944a9e99195a97349f8a5cc129973042840bfe2f6828883ef8e1037ca29c50ecf4d494228125ea9a45313661a8bbb510a1ed8fd8e3ba748720d9793a1c7c05b5381b50c40bc6da9a69c014ec30bc2ba15c5e24e5265c6bab2f42fe1c8c28c67950c55a79a5d08da30f052371372acf859966afc3ae6e39ad3d88652c443fa6243fa5263da527c020b0fab136865bb1ab34bfb4efde33a0e05d962b55d0ce5043817f01d38962c75137cb6a552ec0378081e7ad30a3c69a24ad87a30e6f5148632e923601e82dde9063328bc5f82f86eda8fe262bc28ccc79e3178800a6f4bd749697390ef2a70d746fd51025f6324d4a1ac7a2aa5e65be9c86a0e32df53a6b45814a6975dd882e866592adb710b44d21c32c5d3178934d8ba78871eae49bfd0227d1ef2e915f8d968aab1f93518a8985965000cba9aa51290866525556951ac6dfac9ef522207749ad4d3cae2bf5248530a73e9ef29490436f108755a90ea6065d24a14de9122cd9436b73a6b1e3006f064dfd15d1349e19611d4a37843ce7a91172f0cb9642799ad05071aefa941365b834f6a5076aec19f462a482d4f55ec0272f491322d1655e70d37f697642c4722cb02b71b7c09af2c659e29694e7532925a0b09f8d47930fa60ef2036c78bec7f3d3d2c2c1cab4b7d531ee01ceb4a5d589dba104f9396f513e8aff81d3dfd567b3ef0b02ef9e1b54fb0a4cea7849b7c55ff8a2e497e089c7b648f6094e0130c690b79e113c86ed5c3586131062f8efe167757990cab933c43061ef75e958c4ceed705c9df19ae4689f24c6141f819494f5914da58166e0c48bf23ea1bf551520a707e503505b54460a46c4a75a1c8cfc8d7ff5c90b0a4029013f72f008b93612ced5b7a52c871d1b3561f341dcb478f382e25bb78c987ab2c58cb14e84da185b02e2f1c2b64944a5f644a59c0cb4c6b1e111cbf5f6f49801552a3cf4ca58f525ee557a8df451fc21fab27c8c1b844b5083c43f1a7809a2371cdc4d620c49405c664ba057a1f84a28fa84e09c7fd56a67d959bb4d2742741189074802f546131952966dcff8780973530d2f454740180879e37e27da25f2c1ca250a9fabae9fade7bc9df20325a9a34bf227511143380271e4a9d6b4a8eb03e658207cb928c4580d1e3c39395af389f8fadc849e065625483bd065705f21ae07f1b7b82b6016b9e3979a13979b12965a131158b5197c4078606b126cf3327cd9574862b07f60b2dc90b2d3833652e08b752bf303f795959ce16517156580aa5d386824614d270df1bd799fc813f8f52d4d7313a2401207b40757154c6c0240cb16f2c1626f4ac9c2dbbb0a320f5fbc2c4c548b682214c09917858226d2124bf75cd879f5367591217c877e8b53a694175f27c5ef8043c53f9879172e1a1836e18695aa01e7569dfb71ecfb3fe2d7d083e8a1732eb8694f9da4518cb559db4080bf04b5c8904f9ab8d8991f86a91ba88ae30116f82a01792764b5e664efaa222796961d297f9591baaa1d121dbc955af40c25742aeb0cc7dabfc1e2d153c4ae0eb5f9934f8210668961a79a22848e70226aa6406eb5f1677638bb33614247e5596b0c492b20421775382e4951ab4c0280cd83c4bd25c91381fcb2297c41e4f9f96319917c1afa51b952cea1390fa2bcd3973c1a3b52829798121a5cea2af60096ffd52fa5efe2b6271b9f89af1a574008300ba3c714155e2d7e5893f9524af315c3e208c9791d7b258107f675b58167ae34729e6666be90ffc79a4c0d70e2928ca9e637af4a3540871dc113d2b029ba0219b5e79d178fd58b17e4371fcd755f10b5468ad703296f44c2d49b344d22c4b52a439399211b23efa45c6645e2400e8712b94711f81a1a1801aba61ea21ee4c847c568809ef9812179a1249aed0abf25b5c06165d4355ca1c38e228b5833cc039f843924609f345f22273c23c50707522d9adb05e2103ca9316e527fe54757ebf28394fb68ea50a116e593544129ec5bba6ba8b7a21fe40d87fa7cab6d1dfac2955d3128164722e5ae27a5025f143648e8ab1722aa3a8bc64ba7ca030f1a7a213cb8ca7979a4e2f32262c3026cc3326cead920b07d549b3cd89b3f18a078aa789da07032d30d33c5e7c3e3df1d3b470f0c0056ce49f5817fe4bebf482ea848558f20268e11dbc5f7d1a6b6e7542a448982312e84a109caa4cc68aa4cb937f8b732cf1f3ccf1738ca722412ba0c5d2844579271614277d5381ec54b95e986f0933449d523166b588258f801db87f433eac3fd8b6fbbd244da3a0b7baf7f2d2a93e4796696852b71acb5fa97eb7062360f3a3880adb9edeacbc72342f7175d1a9af2a4fcdc78306eb184fcfa9383da72a69a12189c0309c9e8fa75c9d089b40c1152748f6826748c0d34a986720e02518c4acb4f8bf46ebfb0accfca644d7786a8e291e14239156d622a60363fc7cc329eba749aa0205584ecf02fc304d946f4f986b8c9f653a1d21df9c5b7a6a5edea96579c9abca2e1e14c567a43a871147fb01292d2a2a6f4871a83cea7a31924641d0f0931f99a897ea9c73391c6a928d4bda847d4dc09fdd3c126e563700e61f1bb298b39c278c57c4edb8f20c12fe252716959d5c58797ab12171b13101628090000c5690880b45c23cd007b178fc1c03b80d07890b617631a7d65f5a3a50b91c2793943e0d6a23c665e0f145fc0aeccd898bf0aa900ed1c7dcea131102d8c7835ce6f06782282b4f2f2c3a36afe8f49725e9eb4cd70ec086a5ca300bcc37383864eab2785790aec15e6dd55134e4ff67389ec374328fc7d5d70ab4bf29b3e43d2b012a3e4656572d6584ad6bbc63c9cfa83cbfa7386955e9f16595c716549d80089dc3c0984fcdad3e3947ae799693f3f16a3a81d70596534bb0aa4f2c329c80b85e5c831f20a405c0e6e1150b1f25d73ccd22116d5dc4fdda653819c98bfef634fdb980603f35070be4623839b7282632efe892e2a4d5e567a24d379345c52d59a04716bb62bb29029c1e8eaaef6a34bb14f2eafb35750f0de7e2c69cf988395e028e1277b2e4b9cafdfe94abfe820f48b771d3b911c93d161e922720ffef88d22c71f5b0257353c1f12f0b8e2d293ab6a8f4f8a2aa138b8c2717994f2d14a71688930bc489f9e2f802f309ac45e6938bcd2797984e2d01f65527e76301152c09b014e627250129af043ce8867f5b7b01e6d958203282fcd82c893a11104ec6c7561e5f68885f868bc98f59987fe2ebf2f45fc5f5a3a2304b9850f9891a5ce82f6b50c382a1525a638d01d6843d944226e5fd5a79f0c6c0d9f0731f19f0aadd2e7b1ba8108be9bc26a4c3f7260941815bf90ffc7c44a7d1c50e934752bdb547990400554f9792fa37df434975f5cd937753b7dc38bee24edc37854797961f9d67383ac77c749638365b9c982380eef1391571732a8ecf0765184e8138166041124891305759c7679b4e44569f88a4d7e3f2cd6373f08755c7e7559e98c75482f341193801cb2c0fcc27206648a8d0e7c7cda93cb9e45ecc97b78ffe989bf04bd5e55851764e54df95d709c8d1618c9b82218b851646d67df52a28ac5d10b59d219297d0085229fc811edd23069e551767efac92bf6e22df0abcb5e5953339ccf1ca260a127e4c2720d9611519208b6a9439170a739ea8be21f2522ab3a30a4ead2c88fbaa24ee8b92d8852531f34ae3e6559c58587e6a51f9c92555a7968223ab8e2f301e5b002d20d75cc04c4803f8e3b3cdc7e46bdc1ca05e7d34d218176902079f5016feaaf2d87cb916541c5b84cf2f8c5d0452c3d7151cfbb6387e7971cacfe2d64951795954df21af04d429836ed272e17277ab852b6fca6ac65a795211f1d27db79a475699400fa4c60e68381737e6cc4707bc958b55d2b61232351c59fb5835468d2a22349d9e5697460966f08d289f43e33d4007187100f70f8bbd807ba2fcaaf9766ac5c598c2b4ad79896b0be27f2a38fe757ecc92bcc3f3cb631754c6cead8a9d0ba980658c9b0b98691d9b5d1d370b7242be4602758b7c5f9e39cf103bbf327641e9910525471615c52e2b88fba6247e7561d2cfc5faeda5670f1a6f2489e2f3b03f88fe7001b045e84a68cb17465de3b97093a542068cae42c5358a9df5ba62176bf4bae2d43506cac69dfb4881d73a6f8a5427035e028f58b4868a6bcb7cbaf39a88552d91484acffaec9447285d5eebf40a96169208a00b8cd74449a6b87d4a5c392c2eed33666c32ea7fae4a5e5b767a65d189eff3e3bec98bfd22376659eea125b9871729ebd092fc23cb0a62be288cfdbae8d80f25a7565424acab4af9d598be4de4448bcb31e2c629919b212aae8a6ae89a0281e60a1a0f814e59036250d6abb386a8acc0537ac23a8f84e164ad67b55d34010fab2554ab6e8e9e4fe33a631a07fb230ee0dc478db18da65d8dbdc2079fcf9fccf0a3ada942f21fdb0485d4e264b82b2a31c8eaa628bd2a8a2f8bc28ba2e09cc8cfa95979383e270ace8bc24ba2e43a4dbdaabc270c79c254441f8294127d1a326630cef1f9dc90c572eb414cc99c5de755b568ef7b4bb57efbe0531fc5237c741cff28aee6517f06d3044c076b079ddaffa6a0c858c2b4e4763beb38575511d71ef8f9a82fef3ff979ff3fafcd9985bacb1a270000000049454e44ae426082, '2017-02-13', '男', '三里屯', '4');
INSERT INTO `UserInfo` VALUES (10, '32098119901124455', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (11, '325684350321', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (12, '2359854652', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (13, '14567484161', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (14, '320101199001014784', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (15, '320981199001126478', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (16, '320981199001126455', '1', NULL, '1800-01-01', '男', NULL, '1');
INSERT INTO `UserInfo` VALUES (17, '320111111111111111', '许悦', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (23, '320981199001126488', '李桐', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (24, '320981199001126477', '李桐', NULL, '1990-01-12', '男', 'TEST', '2');
INSERT INTO `UserInfo` VALUES (25, '321181198609176512', '郑超', NULL, '1986-09-17', '男', '江苏省南京市建邺区奥体大街68号新城研发总部园2栋14楼', '1');
INSERT INTO `UserInfo` VALUES (26, '320981198801126477', '邓邓', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (27, '320981199001016477', '李桐', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (28, '320981192201226477', '李桐', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (29, '321026197810185125', '卢德美', NULL, '1978-10-18', '女', '', '1');

-- --------------------------------------------------------

-- 
-- 表的结构 `UserLogin`
-- 

CREATE TABLE `UserLogin` (
  `userID` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `mobileNo` varchar(11) NOT NULL COMMENT '手机号码',
  `validFlag` char(1) NOT NULL DEFAULT '1' COMMENT '有效区分',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `MobileNo` (`mobileNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='个人登陆情报' AUTO_INCREMENT=30 ;

-- 
-- 导出表中的数据 `UserLogin`
-- 

INSERT INTO `UserLogin` VALUES (1, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '13901234567', '1');
INSERT INTO `UserLogin` VALUES (2, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '1234', '1');
INSERT INTO `UserLogin` VALUES (4, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '15050556355', '1');
INSERT INTO `UserLogin` VALUES (14, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '13805151234', '1');
INSERT INTO `UserLogin` VALUES (16, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '15050553656', '1');
INSERT INTO `UserLogin` VALUES (17, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '13911111111', '1');
INSERT INTO `UserLogin` VALUES (23, '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '15012345678', '1');
INSERT INTO `UserLogin` VALUES (24, '7c4a8d09ca3762af61e59520943dc26494f8941b,', '15050553644', '1');
INSERT INTO `UserLogin` VALUES (25, 'fc5acc343265b07e75fe37bb4e35af6959ca5c4d', '13951741096', '1');
INSERT INTO `UserLogin` VALUES (26, 'd889e741dbaf88aee0249348d0c1addc6a3ef794', '15189845671', '1');
INSERT INTO `UserLogin` VALUES (27, 'd889e741dbaf88aee0249348d0c1addc6a3ef794', '15050553611', '1');
INSERT INTO `UserLogin` VALUES (28, 'd889e741dbaf88aee0249348d0c1addc6a3ef794', '15050553622', '1');
INSERT INTO `UserLogin` VALUES (29, '3d4f2bf07dc1be38b20cd6e46949a1071f9d0e3d', '13815882360', '1');

-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- 主机: 172.16.4.95
-- 生成日期: 2017 年 02 月 09 日 04:59
-- 服务器版本: 5.7.17
-- PHP 版本: 6.0.0-dev

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `ahis`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `AppointmentOrder`
-- 

CREATE TABLE `AppointmentOrder` (
  `userId` bigint(20) NOT NULL,
  `psOrdNum` varchar(40) NOT NULL,
  `hisOrdNum` varchar(40) NOT NULL,
  `jiuzhenkaType` varchar(1) NOT NULL,
  `jiuzhenkahao` varchar(40) NOT NULL,
  `ord_status` int(11) NOT NULL,
  `insertTimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`,`psOrdNum`,`hisOrdNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `AppointmentOrder`
-- 

INSERT INTO `AppointmentOrder` VALUES (2, '00000014', 'ld201701251517', '1', '12345678901234567', 2, '2017-02-07 16:46:10');
INSERT INTO `AppointmentOrder` VALUES (2, '00000015', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 10:45:49');
INSERT INTO `AppointmentOrder` VALUES (2, '00000016', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 10:46:36');
INSERT INTO `AppointmentOrder` VALUES (2, '00000017', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 11:17:41');
INSERT INTO `AppointmentOrder` VALUES (2, '00000018', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 11:17:42');
INSERT INTO `AppointmentOrder` VALUES (2, '00000019', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 11:41:41');
INSERT INTO `AppointmentOrder` VALUES (2, '00000020', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 11:48:45');
INSERT INTO `AppointmentOrder` VALUES (2, '00000021', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 11:58:00');
INSERT INTO `AppointmentOrder` VALUES (2, '00000022', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 13:19:17');
INSERT INTO `AppointmentOrder` VALUES (2, '00000023', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-06 13:23:26');
INSERT INTO `AppointmentOrder` VALUES (2, '00000024', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:43:47');
INSERT INTO `AppointmentOrder` VALUES (2, '00000025', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:47:05');
INSERT INTO `AppointmentOrder` VALUES (2, '00000026', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:47:51');
INSERT INTO `AppointmentOrder` VALUES (2, '00000027', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:47:58');
INSERT INTO `AppointmentOrder` VALUES (2, '00000028', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:49:33');
INSERT INTO `AppointmentOrder` VALUES (2, '00000029', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 11:49:38');
INSERT INTO `AppointmentOrder` VALUES (2, '00000030', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 13:16:13');
INSERT INTO `AppointmentOrder` VALUES (2, '00000031', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 13:46:20');
INSERT INTO `AppointmentOrder` VALUES (2, '00000032', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 13:58:41');
INSERT INTO `AppointmentOrder` VALUES (2, '00000033', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 13:59:15');
INSERT INTO `AppointmentOrder` VALUES (2, '00000034', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 14:00:29');
INSERT INTO `AppointmentOrder` VALUES (2, '00000035', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 15:38:30');
INSERT INTO `AppointmentOrder` VALUES (2, '00000036', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 16:14:29');
INSERT INTO `AppointmentOrder` VALUES (2, '00000037', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 17:12:11');
INSERT INTO `AppointmentOrder` VALUES (2, '00000038', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 17:13:37');
INSERT INTO `AppointmentOrder` VALUES (2, '00000039', 'ld201701251517', '1', '12345678901234567', 2, '2017-02-07 17:44:55');
INSERT INTO `AppointmentOrder` VALUES (2, '00000040', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-07 17:48:24');
INSERT INTO `AppointmentOrder` VALUES (2, '00000041', 'ld201701251517', '1', '12345678901234567', 2, '2017-02-08 09:25:14');
INSERT INTO `AppointmentOrder` VALUES (2, '00000049', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 11:17:36');
INSERT INTO `AppointmentOrder` VALUES (2, '00000050', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 11:18:16');
INSERT INTO `AppointmentOrder` VALUES (2, '00000057', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 13:12:57');
INSERT INTO `AppointmentOrder` VALUES (2, '00000058', 'ld201701251517', '1', '12345678901234567', 2, '2017-02-08 14:08:02');
INSERT INTO `AppointmentOrder` VALUES (2, '00000059', 'ld201701251517', '1', '12345678901234567', 2, '2017-02-08 14:18:11');
INSERT INTO `AppointmentOrder` VALUES (2, '00000060', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-08 14:27:22');
INSERT INTO `AppointmentOrder` VALUES (2, '00000061', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 14:26:42');
INSERT INTO `AppointmentOrder` VALUES (2, '00000062', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-08 14:31:53');
INSERT INTO `AppointmentOrder` VALUES (2, '00000063', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-08 14:40:56');
INSERT INTO `AppointmentOrder` VALUES (2, '00000064', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 14:40:34');
INSERT INTO `AppointmentOrder` VALUES (2, '00000065', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-08 14:51:46');
INSERT INTO `AppointmentOrder` VALUES (2, '00000069', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 15:55:53');
INSERT INTO `AppointmentOrder` VALUES (2, '00000070', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 15:58:13');
INSERT INTO `AppointmentOrder` VALUES (2, '00000071', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-08 15:59:31');
INSERT INTO `AppointmentOrder` VALUES (2, '00000072', 'ld201701251517', '1', '12345678901234567', 1, '2017-02-08 16:11:50');
INSERT INTO `AppointmentOrder` VALUES (2, '00000074', 'ld201701251517', '1', '12345678901234567', 3, '2017-02-09 11:38:39');

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

INSERT INTO `FavoriteDoctors` VALUES (2, '0001', '耳鼻喉科', '0001', '张承明', '2017-01-24 14:46:08');
INSERT INTO `FavoriteDoctors` VALUES (2, '0001', '耳鼻喉科', '0002', '李黎', '2017-02-08 10:08:32');
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

INSERT INTO `HospitalCardInfo` VALUES (2, '12345678901234567', '2017-01-24 10:35:12');
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
-- 表的结构 `PaidDetailInfo`
-- 

CREATE TABLE `PaidDetailInfo` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hisOrdNum` int(10) unsigned NOT NULL,
  `payName` varchar(45) NOT NULL,
  `deptName` varchar(45) NOT NULL,
  `doctorName` varchar(45) NOT NULL,
  `totalAmt` double NOT NULL,
  `medInsAmt` double NOT NULL,
  `selfAmt` double NOT NULL,
  `totalAmt_all` double NOT NULL,
  `totalAmt_paid` double NOT NULL,
  `totalAmt_pay` double NOT NULL,
  `medIns_all` double NOT NULL,
  `medIns_paid` double NOT NULL,
  `medIns_pay` double NOT NULL,
  `selfAmt_all` double NOT NULL,
  `selfAmt_paid` double NOT NULL,
  `selfAmt_pay` double NOT NULL,
  `scheduleDate` varchar(45) DEFAULT NULL,
  `timeFlag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`,`hisOrdNum`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

-- 
-- 导出表中的数据 `PaidDetailInfo`
-- 

INSERT INTO `PaidDetailInfo` VALUES (2, 8261124, '挂号费', '耳鼻喉科', '王大生', 50, 0, 50, 50, 0, 50, 0, 0, 0, 50, 0, 50, '2017-01-18', '上午');
INSERT INTO `PaidDetailInfo` VALUES (2, 8261133, '诊疗费', '内科', '王大生', 200, 0, 200, 200, 0, 200, 0, 0, 0, 200, 0, 200, NULL, NULL);
INSERT INTO `PaidDetailInfo` VALUES (17, 8261124, '挂号费', '耳鼻喉科', '王大生', 50, 0, 50, 50, 0, 50, 0, 0, 0, 50, 0, 50, '2017-01-18', '上午');

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
-- 表的结构 `sequence`
-- 

CREATE TABLE `sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` int(11) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `sequence`
-- 

INSERT INTO `sequence` VALUES ('TestSeq', 74, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='地址信息' AUTO_INCREMENT=5 ;

-- 
-- 导出表中的数据 `SiteInfo`
-- 

INSERT INTO `SiteInfo` VALUES (4, 2, '张三', '男', '15989897878', '江苏省南京市建邺区奥体大街69号新城科技园05栋5F（联迪旧地址）', '1');

-- --------------------------------------------------------

-- 
-- 表的结构 `UserInfo`
-- 

CREATE TABLE `UserInfo` (
  `UserID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `Shenfenzhenghao` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `Yibaokahao` varchar(20) DEFAULT NULL COMMENT '医保卡号',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  `jzcardno` varchar(20) DEFAULT NULL COMMENT '就诊卡号',
  `username` varchar(20) DEFAULT NULL COMMENT '姓名',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `zhiye` varchar(20) DEFAULT NULL COMMENT '职业',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='个人基本情报' AUTO_INCREMENT=19 ;

-- 
-- 导出表中的数据 `UserInfo`
-- 

INSERT INTO `UserInfo` VALUES (2, '320981199011223455', NULL, '测试地址', NULL, '测试帐号', '0100-09-24', '女', '4');
INSERT INTO `UserInfo` VALUES (4, '32098119901124455', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (6, '32098119901124455', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (8, '32098119901124455', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (10, '32098119901124455', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (11, '325684350321', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (12, '2359854652', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (13, '14567484161', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (14, '320101199001014784', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (15, '320981199001126478', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (16, '320981199001126455', NULL, '江苏省南京市建邺区奥体大街68号', NULL, '李桐', '1800-01-01', '男', '1');
INSERT INTO `UserInfo` VALUES (17, '320111111111111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `UserInfo` VALUES (18, '320101198001011234', NULL, '江苏省南京市建邺区', NULL, '郑超', '1979-12-31', '男', '4');

-- --------------------------------------------------------

-- 
-- 表的结构 `UserLogin`
-- 

CREATE TABLE `UserLogin` (
  `UserID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `Password` varchar(32) NOT NULL COMMENT '密码',
  `Name` varchar(64) NOT NULL COMMENT '姓名',
  `MobileNo` varchar(11) NOT NULL COMMENT '手机号码',
  `IsEnabled` char(1) NOT NULL DEFAULT '1' COMMENT '有效flag',
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `MobileNo` (`MobileNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='个人登陆情报' AUTO_INCREMENT=26 ;

-- 
-- 导出表中的数据 `UserLogin`
-- 

INSERT INTO `UserLogin` VALUES (1, '12345678', '郑超', '13901234567', '1');
INSERT INTO `UserLogin` VALUES (2, '1234', '测试帐号', '1234', '1');
INSERT INTO `UserLogin` VALUES (4, '900112', '李桐', '15050556355', '1');
INSERT INTO `UserLogin` VALUES (14, '123456', '张三丰', '13805151234', '1');
INSERT INTO `UserLogin` VALUES (16, '123456789', '李桐', '15050553644', '1');
INSERT INTO `UserLogin` VALUES (17, '321321', '许悦', '13911111111', '1');
INSERT INTO `UserLogin` VALUES (18, '0123456', '郑超', '13951741096', '1');

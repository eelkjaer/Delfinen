/*
 Navicat Premium Data Transfer

 Source Server         : DigitalOcean
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : delfinen

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 07/05/2020 10:23:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Competitons
-- ----------------------------
DROP TABLE IF EXISTS `Competitons`;
CREATE TABLE `Competitons` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `DateTime` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Competitons
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for Members
-- ----------------------------
DROP TABLE IF EXISTS `Members`;
CREATE TABLE `Members` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Birthday` date NOT NULL,
  `Email` varchar(255) NOT NULL,
  `PhoneNo` int(255) NOT NULL,
  `Membership` int(255) NOT NULL,
  `MemberSince` timestamp(1) NOT NULL DEFAULT CURRENT_TIMESTAMP(1) ON UPDATE CURRENT_TIMESTAMP(1),
  PRIMARY KEY (`ID`),
  KEY `fk_Members_Memberships_1` (`Membership`),
  CONSTRAINT `fk_Members_Memberships_1` FOREIGN KEY (`Membership`) REFERENCES `Memberships` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=90364 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Members
-- ----------------------------
BEGIN;
INSERT INTO `Members` VALUES (90361, 'Jacob', '1997-03-26', 'jacob@ingenmail.dk', 112, 3, '2020-05-07 08:09:24.5');
INSERT INTO `Members` VALUES (90362, 'Andreas', '1997-05-07', 'andreas@ingenmail.dk', 114, 2, '2020-05-07 08:18:30.7');
INSERT INTO `Members` VALUES (90363, 'Emil', '1994-04-22', 'emil@ingenmail.dk', 118, 2, '2020-05-07 08:20:18.5');
COMMIT;

-- ----------------------------
-- Table structure for Memberships
-- ----------------------------
DROP TABLE IF EXISTS `Memberships`;
CREATE TABLE `Memberships` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Price` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Memberships
-- ----------------------------
BEGIN;
INSERT INTO `Memberships` VALUES (1, 'Junior', 1000);
INSERT INTO `Memberships` VALUES (2, 'Senior', 1600);
INSERT INTO `Memberships` VALUES (3, 'Passiv', 500);
COMMIT;

-- ----------------------------
-- Table structure for Payments
-- ----------------------------
DROP TABLE IF EXISTS `Payments`;
CREATE TABLE `Payments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` int(11) NOT NULL,
  `Paid` double NOT NULL,
  `Timestamp` timestamp(1) NOT NULL DEFAULT CURRENT_TIMESTAMP(1) ON UPDATE CURRENT_TIMESTAMP(1),
  PRIMARY KEY (`ID`),
  KEY `fk_Payments_Members_1` (`MemberID`),
  CONSTRAINT `fk_Payments_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Payments
-- ----------------------------
BEGIN;
INSERT INTO `Payments` VALUES (2, 90361, 400, '2020-05-07 07:51:52.8');
INSERT INTO `Payments` VALUES (3, 90362, 5000, '2020-05-07 07:51:52.8');
INSERT INTO `Payments` VALUES (5, 90363, 1600, '2020-05-07 07:51:52.8');
COMMIT;

-- ----------------------------
-- Table structure for Results
-- ----------------------------
DROP TABLE IF EXISTS `Results`;
CREATE TABLE `Results` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` int(11) NOT NULL,
  `Disciplin` varchar(255) NOT NULL,
  `CompetitionID` int(11) NOT NULL,
  `ResultMeters` double(255,2) NOT NULL,
  `ResultTime` time NOT NULL,
  `Training` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Results_Competitons_1` (`CompetitionID`),
  KEY `fk_Results_Members_1` (`MemberID`),
  CONSTRAINT `fk_Results_Competitons_1` FOREIGN KEY (`CompetitionID`) REFERENCES `Competitons` (`ID`),
  CONSTRAINT `fk_Results_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Results
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for TeamMembers
-- ----------------------------
DROP TABLE IF EXISTS `TeamMembers`;
CREATE TABLE `TeamMembers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TeamID` int(11) NOT NULL,
  `MemberID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_TeamMembers_Teams_1` (`TeamID`),
  KEY `fk_TeamMembers_Members_1` (`MemberID`),
  CONSTRAINT `fk_TeamMembers_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`),
  CONSTRAINT `fk_TeamMembers_Teams_1` FOREIGN KEY (`TeamID`) REFERENCES `Teams` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TeamMembers
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for Teams
-- ----------------------------
DROP TABLE IF EXISTS `Teams`;
CREATE TABLE `Teams` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CoachID` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Teams_Users_1` (`CoachID`),
  CONSTRAINT `fk_Teams_Users_1` FOREIGN KEY (`CoachID`) REFERENCES `Users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Teams
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for Users
-- ----------------------------
DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Permissions` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of Users
-- ----------------------------
BEGIN;
INSERT INTO `Users` VALUES (1, 'admin', 'admin', 3);
INSERT INTO `Users` VALUES (2, 'mod', 'mod', 2);
INSERT INTO `Users` VALUES (3, 'user', 'user', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

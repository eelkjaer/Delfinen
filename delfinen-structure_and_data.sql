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

 Date: 13/05/2020 22:35:44
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
  `DateTime` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Competitons
-- ----------------------------
BEGIN;
INSERT INTO `Competitons` VALUES (1, 'Klubmesterskab 2020', 'Esbjerg', '2020-06-19');
INSERT INTO `Competitons` VALUES (2, 'Teststævne', 'Roskilde', '2020-05-11');
INSERT INTO `Competitons` VALUES (3, 'Finale stævne', 'Zoom', '2020-06-09');
INSERT INTO `Competitons` VALUES (4, 'Testcomp', 'hillerød', '2020-06-19');
INSERT INTO `Competitons` VALUES (5, 'testcomp', 'hillerød', '2020-06-19');
INSERT INTO `Competitons` VALUES (6, 'testcomp', 'hillerød', '2020-06-19');
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
  `MemberSince` timestamp(1) NOT NULL DEFAULT CURRENT_TIMESTAMP(1),
  PRIMARY KEY (`ID`),
  KEY `fk_Members_Memberships_1` (`Membership`),
  CONSTRAINT `fk_Members_Memberships_1` FOREIGN KEY (`Membership`) REFERENCES `Memberships` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=90438 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Members
-- ----------------------------
BEGIN;
INSERT INTO `Members` VALUES (90361, 'Jacob', '1997-03-26', 'jacob@ingenmail.dk', 112, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90362, 'Andreas', '1997-05-07', 'andreas@ingenmail.dk', 114, 2, '2020-05-07 08:18:30.7');
INSERT INTO `Members` VALUES (90363, 'Emil', '1994-04-22', 'emil@ingenmail.dk', 60146057, 2, '2020-05-12 20:59:05.4');
INSERT INTO `Members` VALUES (90364, 'Peter', '1999-02-25', 'peter@ingenmail.dk', 120, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90365, 'Søren', '1994-04-12', 'Søren@ingenmail.dk', 122, 2, '2020-05-11 08:45:12.6');
INSERT INTO `Members` VALUES (90366, 'Alexander', '1995-06-22', 'Alex@ingenmail.dk', 124, 2, '2020-05-11 08:45:12.7');
INSERT INTO `Members` VALUES (90367, 'Simon', '2001-02-02', 'Simon@ingenmail.dk', 126, 2, '2020-05-11 08:45:12.8');
INSERT INTO `Members` VALUES (90368, 'Emilie', '2005-06-12', 'Emilie@ingenmail.dk', 128, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90369, 'Frederikke', '1999-02-02', 'Frederikke@ingenmail.dk', 130, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90370, 'Freja', '1998-11-23', 'Freja@ingenmail.dk', 132, 2, '2020-05-11 08:45:13.1');
INSERT INTO `Members` VALUES (90371, 'Cille', '1996-05-21', 'Cille@ingenmail.dk', 134, 2, '2020-05-11 08:45:13.2');
INSERT INTO `Members` VALUES (90372, 'Mads', '1998-01-01', 'Mads@ingenmail.dk', 136, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90373, 'Mikkel', '1995-07-01', 'Mikkel@ingenmail.dk', 138, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90374, 'Simone', '1997-05-15', 'Simone@ingenmail.dk', 140, 2, '2020-05-11 08:45:14.5');
INSERT INTO `Members` VALUES (90375, 'Olivia ', '1995-02-05', 'Olivia@ingenmail.dk', 142, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90376, 'Jakob', '1994-06-07', 'Jakob@ingenmail.dk', 144, 2, '2020-05-11 08:45:15.2');
INSERT INTO `Members` VALUES (90377, 'Frederik', '1997-01-01', 'Frederik@ingenmail.dk', 146, 2, '2020-05-11 08:45:15.3');
INSERT INTO `Members` VALUES (90378, 'Henrik', '1997-03-26', 'Henrik@ingenmail.dk', 148, 2, '2020-05-11 08:45:15.4');
INSERT INTO `Members` VALUES (90379, 'Emil', '1999-05-18', 'Emil@ingenmail.dk', 150, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90380, 'Mohammad', '1995-02-11', 'Mohammed@ingenmail.dk', 152, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90381, 'Nikolai', '2008-01-01', 'Nikolai@ingenmail.dk', 154, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90382, 'Simone', '1999-04-22', 'some@ingenmail.dk', 156, 2, '2020-05-11 08:45:16.2');
INSERT INTO `Members` VALUES (90386, 'John', '2010-01-19', 'john@john.dk', 12121212, 1, '2020-05-12 17:21:27.6');
INSERT INTO `Members` VALUES (90387, 'Jacob Lange Nielsen', '2005-03-25', 'Hejjacob@ingenmail.dk', 51941066, 1, '2020-05-12 17:32:07.7');
INSERT INTO `Members` VALUES (90388, 'Rhiamon Haldon', '1975-08-24', 'rhaldon0@bbc.co.uk', 39105929, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90389, 'Quincy Jedrzejewicz', '2003-04-06', 'qjedrzejewicz1@nasa.gov', 88228175, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90390, 'Sargent Haynes', '1957-07-07', 'shaynes2@biblegateway.com', 84469054, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90391, 'Sharline Wittrington', '1990-08-25', 'swittrington3@utexas.edu', 49998427, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90392, 'Rob Seed', '1998-11-17', 'rseed4@csmonitor.com', 44146669, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90393, 'Celestyna McAloren', '1965-06-10', 'cmcaloren5@goo.ne.jp', 13520485, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90394, 'Lisette Bowe', '2006-06-04', 'lbowe6@cornell.edu', 68759184, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90395, 'Doroteya Burnitt', '1988-11-27', 'dburnitt7@dion.ne.jp', 52223282, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90396, 'Lissie Gronaver', '1989-11-01', 'lgronaver8@ustream.tv', 95360560, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90397, 'Sutton Clement', '1990-09-07', 'sclement9@umich.edu', 72369780, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90398, 'Paul McCormick', '1990-11-29', 'pmccormicka@usgs.gov', 62987793, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90399, 'Abe Aleswell', '2001-10-25', 'aaleswellb@dmoz.org', 25336030, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90400, 'Jourdain Boosey', '1976-07-04', 'jbooseyc@altervista.org', 16305619, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90401, 'Oswald Billington', '1996-04-14', 'obillingtond@bandcamp.com', 26678925, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90402, 'Montague Heinzel', '1972-12-30', 'mheinzele@illinois.edu', 62447779, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90403, 'Fancy Leeburn', '1967-09-04', 'fleeburnf@zdnet.com', 26912671, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90404, 'Alissa Stratford', '1955-09-14', 'astratfordg@acquirethisname.com', 94786770, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90405, 'Dicky Melburg', '1963-04-06', 'dmelburgh@slideshare.net', 89915836, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90406, 'Marris Fake', '1979-03-19', 'mfakei@jimdo.com', 39667373, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90407, 'Glenine Lilburne', '1961-08-19', 'glilburnej@goodreads.com', 68607834, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90408, 'Anjanette Lujan', '1955-04-24', 'alujank@facebook.com', 30104397, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90409, 'Hillier Cowan', '1971-04-04', 'hcowanl@meetup.com', 96316556, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90410, 'Letitia Lefley', '1991-08-12', 'llefleym@nps.gov', 40368965, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90411, 'Shir Sollom', '2004-02-16', 'ssollomn@bloglines.com', 30131113, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90412, 'Johnathon Tatchell', '1997-03-02', 'jtatchello@guardian.co.uk', 57191593, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90413, 'Gasper Kiehl', '1953-05-15', 'gkiehlp@yahoo.co.jp', 33938564, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90414, 'Candy Paddon', '1985-11-02', 'cpaddonq@yandex.ru', 78196520, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90415, 'Mathew Corington', '1958-10-09', 'mcoringtonr@dion.ne.jp', 94881332, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90416, 'Rosalinde Breckell', '1954-07-12', 'rbreckells@admin.ch', 39827267, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90417, 'Anitra Slater', '1984-04-12', 'aslatert@sfgate.com', 48240006, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90418, 'Christel Greated', '1962-07-05', 'cgreatedu@gravatar.com', 93350916, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90419, 'Federica Belfitt', '1988-01-29', 'fbelfittv@xrea.com', 55599707, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90420, 'Solly Allison', '1999-02-12', 'sallisonw@i2i.jp', 87677807, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90421, 'Conrado McTrustie', '1970-09-01', 'cmctrustiex@ning.com', 20036828, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90422, 'Yul Garnett', '2003-01-29', 'ygarnetty@spiegel.de', 84003330, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90423, 'Noelyn Slateford', '1950-03-21', 'nslatefordz@squidoo.com', 35614335, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90424, 'Bonnibelle Daubeny', '2003-02-13', 'bdaubeny10@smh.com.au', 96710726, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90425, 'Henri Rostern', '1969-11-15', 'hrostern11@ft.com', 65366898, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90426, 'Gabe Gheorghe', '1983-09-08', 'ggheorghe12@taobao.com', 68149323, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90427, 'Finley Edworthy', '1986-05-19', 'fedworthy13@blog.com', 27194723, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90428, 'Maryjane Ubanks', '1952-06-28', 'mubanks14@artisteer.com', 39770281, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90429, 'Tabitha Bromidge', '1960-11-05', 'tbromidge15@blogtalkradio.com', 79976293, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90430, 'Imelda Cleaves', '2007-04-06', 'icleaves16@symantec.com', 76124131, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90431, 'Bertram MacPaike', '2002-02-03', 'bmacpaike17@moonfruit.com', 33414632, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90432, 'Gabbi Point', '1951-05-13', 'gpoint18@oakley.com', 97860783, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90433, 'Austina Bruineman', '1955-03-31', 'abruineman19@cocolog-nifty.com', 87592662, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90434, 'Evaleen Barrack', '1969-03-12', 'ebarrack1a@nifty.com', 93459991, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90435, 'Jasper State', '2005-10-15', 'jstate1b@globo.com', 52278892, 1, '2020-05-12 17:54:53.0');
INSERT INTO `Members` VALUES (90436, 'Rube Munehay', '1973-12-27', 'rmunehay1c@ca.gov', 50657768, 2, '2020-05-12 17:55:05.4');
INSERT INTO `Members` VALUES (90437, 'Kayla McGuinness', '1993-11-18', 'kmcguinness1d@theatlantic.com', 85009518, 2, '2020-05-12 20:57:50.1');
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
  `Timestamp` date NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `fk_Payments_Members_1` (`MemberID`),
  CONSTRAINT `fk_Payments_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Payments
-- ----------------------------
BEGIN;
INSERT INTO `Payments` VALUES (2, 90361, 400, '2020-05-07');
INSERT INTO `Payments` VALUES (3, 90362, 5000, '2020-05-07');
INSERT INTO `Payments` VALUES (5, 90363, 1600, '2020-05-07');
INSERT INTO `Payments` VALUES (6, 90361, 100, '2020-05-07');
INSERT INTO `Payments` VALUES (7, 90362, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (8, 90363, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (9, 90364, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (10, 90365, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (11, 90366, 1500, '2020-05-11');
INSERT INTO `Payments` VALUES (12, 90367, 1500, '2020-05-11');
INSERT INTO `Payments` VALUES (13, 90368, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (14, 90369, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (15, 90370, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (16, 90371, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (17, 90372, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (18, 90373, 2500, '2020-05-11');
INSERT INTO `Payments` VALUES (19, 90374, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (20, 90375, 1599, '2020-05-11');
INSERT INTO `Payments` VALUES (21, 90376, 1550, '2020-05-11');
INSERT INTO `Payments` VALUES (22, 90377, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (23, 90378, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (24, 90379, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (25, 90380, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (26, 90382, 1600, '2020-05-11');
INSERT INTO `Payments` VALUES (28, 90395, 430.38, '2020-05-12');
INSERT INTO `Payments` VALUES (29, 90403, 716.98, '2020-05-12');
INSERT INTO `Payments` VALUES (30, 90406, 833.8, '2020-05-12');
INSERT INTO `Payments` VALUES (31, 90422, 815.24, '2020-05-12');
INSERT INTO `Payments` VALUES (32, 90425, 312.81, '2020-05-12');
INSERT INTO `Payments` VALUES (33, 90361, 400, '2020-05-13');
INSERT INTO `Payments` VALUES (34, 90361, 400, '2020-05-13');
INSERT INTO `Payments` VALUES (35, 90362, 400, '2020-05-12');
INSERT INTO `Payments` VALUES (36, 90362, 400, '2020-05-12');
COMMIT;

-- ----------------------------
-- Table structure for Results
-- ----------------------------
DROP TABLE IF EXISTS `Results`;
CREATE TABLE `Results` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` int(11) NOT NULL,
  `Disciplin` enum('bryst','crawl','rygcrawl','butterfly') NOT NULL,
  `CompetitionID` int(11) NOT NULL,
  `ResultMeters` double(255,2) NOT NULL DEFAULT '100.00',
  `ResultTime` double(11,0) NOT NULL,
  `Training` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Results_Competitons_1` (`CompetitionID`),
  KEY `fk_Results_Members_1` (`MemberID`),
  CONSTRAINT `fk_Results_Competitons_1` FOREIGN KEY (`CompetitionID`) REFERENCES `Competitons` (`ID`),
  CONSTRAINT `fk_Results_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Results
-- ----------------------------
BEGIN;
INSERT INTO `Results` VALUES (2, 90361, 'crawl', 1, 100.00, 72, 0);
INSERT INTO `Results` VALUES (3, 90362, 'crawl', 1, 100.00, 71, 0);
INSERT INTO `Results` VALUES (4, 90363, 'crawl', 1, 100.00, 73, 0);
INSERT INTO `Results` VALUES (5, 90364, 'crawl', 1, 100.00, 74, 0);
INSERT INTO `Results` VALUES (6, 90365, 'crawl', 1, 100.00, 72, 0);
INSERT INTO `Results` VALUES (7, 90366, 'crawl', 1, 100.00, 69, 0);
INSERT INTO `Results` VALUES (8, 90367, 'crawl', 1, 100.00, 72, 0);
INSERT INTO `Results` VALUES (9, 90368, 'crawl', 1, 100.00, 100, 0);
INSERT INTO `Results` VALUES (10, 90369, 'crawl', 1, 100.00, 68, 0);
INSERT INTO `Results` VALUES (11, 90370, 'crawl', 1, 100.00, 62, 0);
INSERT INTO `Results` VALUES (12, 90371, 'crawl', 1, 100.00, 78, 0);
INSERT INTO `Results` VALUES (13, 90372, 'crawl', 1, 100.00, 76, 0);
INSERT INTO `Results` VALUES (14, 90373, 'crawl', 1, 100.00, 75, 0);
INSERT INTO `Results` VALUES (15, 90374, 'crawl', 1, 100.00, 69, 0);
INSERT INTO `Results` VALUES (16, 90375, 'crawl', 1, 100.00, 66, 0);
INSERT INTO `Results` VALUES (17, 90376, 'crawl', 1, 100.00, 61, 0);
INSERT INTO `Results` VALUES (18, 90377, 'crawl', 1, 100.00, 69, 0);
INSERT INTO `Results` VALUES (19, 90378, 'crawl', 1, 100.00, 78, 0);
INSERT INTO `Results` VALUES (20, 90379, 'crawl', 1, 100.00, 81, 0);
INSERT INTO `Results` VALUES (21, 90380, 'crawl', 1, 100.00, 62, 0);
INSERT INTO `Results` VALUES (22, 90381, 'crawl', 1, 100.00, 71, 0);
INSERT INTO `Results` VALUES (23, 90382, 'crawl', 1, 100.00, 82, 0);
INSERT INTO `Results` VALUES (24, 90362, 'butterfly', 1, 100.00, 55, 0);
INSERT INTO `Results` VALUES (25, 90362, 'butterfly', 1, 100.00, 54, 0);
INSERT INTO `Results` VALUES (26, 90362, 'butterfly', 1, 100.00, 57, 0);
INSERT INTO `Results` VALUES (27, 90361, 'rygcrawl', 2, 100.00, 32, 1);
INSERT INTO `Results` VALUES (28, 90361, 'butterfly', 2, 100.00, 33, 1);
INSERT INTO `Results` VALUES (29, 90361, 'bryst', 2, 100.00, 35, 1);
INSERT INTO `Results` VALUES (30, 90363, 'rygcrawl', 2, 100.00, 26, 1);
INSERT INTO `Results` VALUES (31, 90363, 'butterfly', 2, 100.00, 56, 1);
INSERT INTO `Results` VALUES (32, 90363, 'bryst', 2, 100.00, 43, 1);
INSERT INTO `Results` VALUES (33, 90364, 'rygcrawl', 2, 100.00, 56, 1);
INSERT INTO `Results` VALUES (34, 90364, 'butterfly', 2, 100.00, 57, 1);
INSERT INTO `Results` VALUES (35, 90364, 'bryst', 2, 100.00, 43, 1);
INSERT INTO `Results` VALUES (36, 90365, 'rygcrawl', 2, 100.00, 54, 1);
INSERT INTO `Results` VALUES (37, 90365, 'butterfly', 2, 100.00, 24, 1);
INSERT INTO `Results` VALUES (38, 90365, 'bryst', 2, 100.00, 43, 1);
INSERT INTO `Results` VALUES (39, 90366, 'rygcrawl', 2, 100.00, 57, 1);
INSERT INTO `Results` VALUES (40, 90366, 'butterfly', 2, 100.00, 53, 1);
INSERT INTO `Results` VALUES (41, 90366, 'bryst', 2, 100.00, 54, 1);
INSERT INTO `Results` VALUES (42, 90367, 'rygcrawl', 2, 100.00, 74, 1);
INSERT INTO `Results` VALUES (43, 90367, 'butterfly', 2, 100.00, 43, 1);
INSERT INTO `Results` VALUES (44, 90367, 'bryst', 2, 100.00, 36, 1);
INSERT INTO `Results` VALUES (45, 90368, 'rygcrawl', 2, 100.00, 65, 1);
INSERT INTO `Results` VALUES (46, 90368, 'butterfly', 2, 100.00, 64, 1);
INSERT INTO `Results` VALUES (47, 90368, 'bryst', 2, 100.00, 73, 1);
INSERT INTO `Results` VALUES (48, 90369, 'rygcrawl', 2, 100.00, 46, 1);
INSERT INTO `Results` VALUES (49, 90369, 'butterfly', 2, 100.00, 33, 1);
INSERT INTO `Results` VALUES (50, 90369, 'bryst', 2, 100.00, 36, 1);
INSERT INTO `Results` VALUES (51, 90370, 'rygcrawl', 3, 100.00, 70, 0);
INSERT INTO `Results` VALUES (52, 90370, 'bryst', 3, 100.00, 75, 0);
INSERT INTO `Results` VALUES (53, 90370, 'butterfly', 3, 100.00, 86, 0);
INSERT INTO `Results` VALUES (54, 90371, 'rygcrawl', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (55, 90371, 'bryst', 3, 100.00, 85, 0);
INSERT INTO `Results` VALUES (56, 90371, 'butterfly', 2, 100.00, 75, 1);
INSERT INTO `Results` VALUES (57, 90372, 'rygcrawl', 2, 100.00, 74, 1);
INSERT INTO `Results` VALUES (58, 90372, 'bryst', 3, 100.00, 72, 0);
INSERT INTO `Results` VALUES (59, 90372, 'butterfly', 3, 100.00, 78, 0);
INSERT INTO `Results` VALUES (60, 90373, 'rygcrawl', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (61, 90373, 'bryst', 3, 100.00, 76, 0);
INSERT INTO `Results` VALUES (62, 90373, 'butterfly', 3, 100.00, 56, 0);
INSERT INTO `Results` VALUES (63, 90374, 'rygcrawl', 3, 100.00, 76, 0);
INSERT INTO `Results` VALUES (64, 90374, 'bryst', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (65, 90374, 'butterfly', 3, 100.00, 89, 0);
INSERT INTO `Results` VALUES (66, 90375, 'rygcrawl', 3, 100.00, 84, 0);
INSERT INTO `Results` VALUES (67, 90375, 'bryst', 3, 100.00, 78, 0);
INSERT INTO `Results` VALUES (68, 90375, 'butterfly', 3, 100.00, 98, 0);
INSERT INTO `Results` VALUES (69, 90376, 'rygcrawl', 3, 100.00, 75, 0);
INSERT INTO `Results` VALUES (70, 90376, 'bryst', 3, 100.00, 98, 0);
INSERT INTO `Results` VALUES (71, 90376, 'crawl', 3, 100.00, 66, 0);
INSERT INTO `Results` VALUES (72, 90377, 'rygcrawl', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (73, 90377, 'bryst', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (74, 90361, 'crawl', 3, 100.00, 100, 0);
INSERT INTO `Results` VALUES (75, 90386, 'crawl', 3, 100.00, 5, 0);
INSERT INTO `Results` VALUES (76, 90426, 'bryst', 3, 100.00, 61, 0);
INSERT INTO `Results` VALUES (77, 90437, 'bryst', 3, 100.00, 59, 1);
INSERT INTO `Results` VALUES (78, 90437, 'butterfly', 2, 100.00, 75, 1);
INSERT INTO `Results` VALUES (79, 90418, 'crawl', 1, 100.00, 67, 1);
INSERT INTO `Results` VALUES (80, 90423, 'rygcrawl', 3, 100.00, 66, 0);
INSERT INTO `Results` VALUES (81, 90405, 'rygcrawl', 3, 100.00, 71, 1);
INSERT INTO `Results` VALUES (82, 90404, 'bryst', 1, 100.00, 92, 1);
INSERT INTO `Results` VALUES (83, 90402, 'butterfly', 1, 100.00, 60, 0);
INSERT INTO `Results` VALUES (84, 90408, 'rygcrawl', 3, 100.00, 63, 0);
INSERT INTO `Results` VALUES (85, 90437, 'rygcrawl', 1, 100.00, 86, 0);
INSERT INTO `Results` VALUES (86, 90408, 'crawl', 3, 100.00, 52, 0);
INSERT INTO `Results` VALUES (87, 90411, 'rygcrawl', 1, 100.00, 61, 1);
INSERT INTO `Results` VALUES (88, 90407, 'crawl', 1, 100.00, 88, 0);
INSERT INTO `Results` VALUES (89, 90420, 'rygcrawl', 3, 100.00, 100, 0);
INSERT INTO `Results` VALUES (90, 90390, 'bryst', 2, 100.00, 52, 1);
INSERT INTO `Results` VALUES (91, 90408, 'butterfly', 2, 100.00, 101, 1);
INSERT INTO `Results` VALUES (92, 90406, 'butterfly', 2, 100.00, 64, 1);
INSERT INTO `Results` VALUES (93, 90435, 'butterfly', 3, 100.00, 100, 0);
INSERT INTO `Results` VALUES (94, 90429, 'butterfly', 2, 100.00, 89, 1);
INSERT INTO `Results` VALUES (95, 90404, 'butterfly', 3, 100.00, 58, 1);
INSERT INTO `Results` VALUES (96, 90434, 'rygcrawl', 2, 100.00, 61, 1);
INSERT INTO `Results` VALUES (97, 90387, 'crawl', 3, 100.00, 86, 0);
INSERT INTO `Results` VALUES (98, 90423, 'butterfly', 2, 100.00, 94, 1);
INSERT INTO `Results` VALUES (99, 90419, 'bryst', 2, 100.00, 56, 1);
INSERT INTO `Results` VALUES (100, 90413, 'butterfly', 3, 100.00, 91, 1);
INSERT INTO `Results` VALUES (101, 90404, 'rygcrawl', 2, 100.00, 68, 1);
INSERT INTO `Results` VALUES (102, 90407, 'bryst', 3, 100.00, 91, 1);
INSERT INTO `Results` VALUES (103, 90407, 'butterfly', 3, 100.00, 85, 1);
INSERT INTO `Results` VALUES (104, 90420, 'crawl', 1, 100.00, 96, 1);
INSERT INTO `Results` VALUES (105, 90404, 'crawl', 2, 100.00, 66, 1);
INSERT INTO `Results` VALUES (106, 90399, 'butterfly', 2, 100.00, 63, 1);
INSERT INTO `Results` VALUES (107, 90398, 'rygcrawl', 1, 100.00, 90, 0);
INSERT INTO `Results` VALUES (108, 90417, 'rygcrawl', 3, 100.00, 54, 0);
INSERT INTO `Results` VALUES (109, 90388, 'bryst', 1, 100.00, 54, 0);
INSERT INTO `Results` VALUES (110, 90426, 'butterfly', 3, 100.00, 92, 1);
INSERT INTO `Results` VALUES (111, 90435, 'butterfly', 2, 100.00, 51, 1);
INSERT INTO `Results` VALUES (112, 90406, 'bryst', 1, 100.00, 65, 0);
INSERT INTO `Results` VALUES (113, 90406, 'bryst', 3, 100.00, 70, 0);
INSERT INTO `Results` VALUES (114, 90405, 'butterfly', 3, 100.00, 56, 1);
INSERT INTO `Results` VALUES (115, 90434, 'butterfly', 3, 100.00, 100, 0);
INSERT INTO `Results` VALUES (116, 90437, 'rygcrawl', 1, 100.00, 83, 1);
INSERT INTO `Results` VALUES (117, 90392, 'rygcrawl', 1, 100.00, 90, 1);
INSERT INTO `Results` VALUES (118, 90402, 'rygcrawl', 2, 100.00, 85, 1);
INSERT INTO `Results` VALUES (119, 90428, 'butterfly', 1, 100.00, 99, 0);
INSERT INTO `Results` VALUES (120, 90411, 'crawl', 1, 100.00, 100, 0);
INSERT INTO `Results` VALUES (121, 90393, 'crawl', 3, 100.00, 69, 0);
INSERT INTO `Results` VALUES (122, 90397, 'crawl', 3, 100.00, 93, 1);
INSERT INTO `Results` VALUES (123, 90402, 'crawl', 2, 100.00, 90, 1);
INSERT INTO `Results` VALUES (124, 90386, 'rygcrawl', 2, 100.00, 59, 1);
INSERT INTO `Results` VALUES (125, 90395, 'rygcrawl', 3, 100.00, 48, 0);
INSERT INTO `Results` VALUES (126, 90404, 'rygcrawl', 3, 100.00, 50, 1);
INSERT INTO `Results` VALUES (127, 90436, 'bryst', 2, 100.00, 91, 1);
INSERT INTO `Results` VALUES (128, 90388, 'rygcrawl', 2, 100.00, 72, 1);
INSERT INTO `Results` VALUES (129, 90436, 'crawl', 3, 100.00, 73, 1);
INSERT INTO `Results` VALUES (130, 90387, 'crawl', 2, 100.00, 56, 1);
INSERT INTO `Results` VALUES (131, 90409, 'bryst', 2, 100.00, 84, 1);
INSERT INTO `Results` VALUES (132, 90393, 'bryst', 2, 100.00, 70, 1);
INSERT INTO `Results` VALUES (133, 90425, 'bryst', 1, 100.00, 77, 0);
INSERT INTO `Results` VALUES (134, 90400, 'crawl', 3, 100.00, 92, 0);
INSERT INTO `Results` VALUES (135, 90402, 'rygcrawl', 2, 100.00, 59, 1);
INSERT INTO `Results` VALUES (136, 90424, 'rygcrawl', 2, 100.00, 69, 1);
INSERT INTO `Results` VALUES (137, 90388, 'rygcrawl', 3, 100.00, 95, 0);
INSERT INTO `Results` VALUES (138, 90393, 'butterfly', 1, 100.00, 90, 0);
INSERT INTO `Results` VALUES (139, 90399, 'crawl', 2, 100.00, 49, 1);
INSERT INTO `Results` VALUES (140, 90404, 'rygcrawl', 1, 100.00, 71, 1);
INSERT INTO `Results` VALUES (141, 90405, 'crawl', 2, 100.00, 67, 1);
INSERT INTO `Results` VALUES (142, 90389, 'rygcrawl', 3, 100.00, 47, 0);
INSERT INTO `Results` VALUES (143, 90410, 'rygcrawl', 1, 100.00, 72, 0);
INSERT INTO `Results` VALUES (144, 90409, 'rygcrawl', 2, 100.00, 79, 1);
INSERT INTO `Results` VALUES (145, 90407, 'butterfly', 1, 100.00, 94, 0);
INSERT INTO `Results` VALUES (146, 90426, 'butterfly', 1, 100.00, 82, 1);
INSERT INTO `Results` VALUES (147, 90412, 'crawl', 2, 100.00, 91, 1);
INSERT INTO `Results` VALUES (148, 90398, 'crawl', 2, 100.00, 62, 1);
INSERT INTO `Results` VALUES (149, 90404, 'rygcrawl', 3, 100.00, 63, 0);
INSERT INTO `Results` VALUES (150, 90388, 'butterfly', 3, 100.00, 79, 1);
INSERT INTO `Results` VALUES (151, 90409, 'rygcrawl', 2, 100.00, 69, 1);
INSERT INTO `Results` VALUES (152, 90421, 'rygcrawl', 1, 100.00, 81, 1);
INSERT INTO `Results` VALUES (153, 90428, 'crawl', 3, 100.00, 87, 0);
INSERT INTO `Results` VALUES (154, 90429, 'bryst', 1, 100.00, 84, 1);
INSERT INTO `Results` VALUES (155, 90402, 'bryst', 3, 100.00, 86, 0);
INSERT INTO `Results` VALUES (156, 90437, 'bryst', 2, 100.00, 65, 1);
INSERT INTO `Results` VALUES (157, 90435, 'crawl', 3, 100.00, 68, 1);
INSERT INTO `Results` VALUES (158, 90398, 'butterfly', 1, 100.00, 50, 0);
INSERT INTO `Results` VALUES (159, 90421, 'bryst', 2, 100.00, 58, 1);
INSERT INTO `Results` VALUES (160, 90432, 'butterfly', 3, 100.00, 84, 0);
INSERT INTO `Results` VALUES (161, 90397, 'butterfly', 1, 100.00, 49, 0);
INSERT INTO `Results` VALUES (162, 90435, 'rygcrawl', 1, 100.00, 94, 0);
INSERT INTO `Results` VALUES (163, 90401, 'rygcrawl', 3, 100.00, 97, 1);
INSERT INTO `Results` VALUES (164, 90434, 'rygcrawl', 2, 100.00, 85, 1);
INSERT INTO `Results` VALUES (165, 90425, 'butterfly', 3, 100.00, 50, 0);
INSERT INTO `Results` VALUES (166, 90402, 'crawl', 1, 100.00, 92, 0);
INSERT INTO `Results` VALUES (167, 90390, 'bryst', 1, 100.00, 86, 0);
INSERT INTO `Results` VALUES (168, 90405, 'bryst', 2, 100.00, 92, 1);
INSERT INTO `Results` VALUES (169, 90433, 'rygcrawl', 3, 100.00, 55, 1);
INSERT INTO `Results` VALUES (170, 90388, 'bryst', 3, 100.00, 72, 0);
INSERT INTO `Results` VALUES (171, 90416, 'butterfly', 1, 100.00, 77, 1);
INSERT INTO `Results` VALUES (172, 90427, 'rygcrawl', 2, 100.00, 75, 1);
INSERT INTO `Results` VALUES (173, 90408, 'bryst', 1, 100.00, 71, 0);
INSERT INTO `Results` VALUES (174, 90429, 'butterfly', 3, 100.00, 60, 0);
INSERT INTO `Results` VALUES (175, 90422, 'crawl', 1, 100.00, 101, 1);
INSERT INTO `Results` VALUES (176, 90363, 'bryst', 3, 100.00, 46, 0);
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
  CONSTRAINT `fk_TeamMembers_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fk_TeamMembers_Teams_1` FOREIGN KEY (`TeamID`) REFERENCES `Teams` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TeamMembers
-- ----------------------------
BEGIN;
INSERT INTO `TeamMembers` VALUES (1, 1, 90362);
INSERT INTO `TeamMembers` VALUES (2, 1, 90361);
INSERT INTO `TeamMembers` VALUES (3, 1, 90363);
INSERT INTO `TeamMembers` VALUES (4, 1, 90364);
INSERT INTO `TeamMembers` VALUES (5, 1, 90365);
INSERT INTO `TeamMembers` VALUES (6, 2, 90366);
INSERT INTO `TeamMembers` VALUES (7, 2, 90367);
INSERT INTO `TeamMembers` VALUES (8, 2, 90368);
INSERT INTO `TeamMembers` VALUES (9, 2, 90369);
INSERT INTO `TeamMembers` VALUES (10, 2, 90370);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Teams
-- ----------------------------
BEGIN;
INSERT INTO `Teams` VALUES (1, 'DAT', 3);
INSERT INTO `Teams` VALUES (2, 'Simonhold', 4);
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
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`,`Username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of Users
-- ----------------------------
BEGIN;
INSERT INTO `Users` VALUES (1, 'admin', 'admin', 3, '');
INSERT INTO `Users` VALUES (2, 'mod', 'mod', 2, '');
INSERT INTO `Users` VALUES (3, 'user', 'user', 1, 'Thor');
INSERT INTO `Users` VALUES (4, 'simon', 'simon', 1, 'Simon');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

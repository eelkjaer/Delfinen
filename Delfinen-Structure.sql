CREATE TABLE `Competitons`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `DateTime` datetime(0) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Members`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Birthday` date NOT NULL,
  `Email` varchar(255) NOT NULL,
  `PhoneNo` int(255) NOT NULL,
  `Membership` int(255) NOT NULL,
  `MemberSince` timestamp(255) NOT NULL DEFAULT now(),
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Memberships`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Price` double(10, 2) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Payments`  (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `MemberID` int(255) NULL,
  `Paid` double(255, 0) NOT NULL,
  `Timestamp` timestamp(255) NULL DEFAULT now(),
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Results`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `MemberID` int(0) NOT NULL,
  `Disciplin` varchar(255) NOT NULL,
  `CompetitionID` int(0) NULL,
  `ResultMeters` double(255, 0) NOT NULL,
  `ResultTime` time(0) NOT NULL,
  `Training` tinyint(0) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `TeamMembers`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `TeamID` int(0) NOT NULL,
  `MemberID` int(0) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Teams`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NULL,
  `CoachID` int(255) NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `Users`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Permissions` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

ALTER TABLE `Members` ADD CONSTRAINT `fk_Members_Memberships_1` FOREIGN KEY (`Membership`) REFERENCES `Memberships` (`ID`);
ALTER TABLE `Payments` ADD CONSTRAINT `fk_Payments_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`);
ALTER TABLE `Results` ADD CONSTRAINT `fk_Results_Competitons_1` FOREIGN KEY (`CompetitionID`) REFERENCES `Competitons` (`ID`);
ALTER TABLE `Results` ADD CONSTRAINT `fk_Results_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`);
ALTER TABLE `TeamMembers` ADD CONSTRAINT `fk_TeamMembers_Teams_1` FOREIGN KEY (`TeamID`) REFERENCES `Teams` (`ID`);
ALTER TABLE `TeamMembers` ADD CONSTRAINT `fk_TeamMembers_Members_1` FOREIGN KEY (`MemberID`) REFERENCES `Members` (`ID`);
ALTER TABLE `Teams` ADD CONSTRAINT `fk_Teams_Users_1` FOREIGN KEY (`CoachID`) REFERENCES `Users` (`ID`);


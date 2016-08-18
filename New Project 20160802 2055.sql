-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema database_task03
--

CREATE DATABASE IF NOT EXISTS database_task03;
USE database_task03;

--
-- Definition of table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `idclient` int(10) unsigned NOT NULL auto_increment,
  `Number` varchar(450) NOT NULL,
  `Name` varchar(450) NOT NULL,
  `AddressLine1` varchar(450) NOT NULL,
  `AddressLine2` varchar(450) NOT NULL,
  `City` varchar(450) NOT NULL,
  `State` varchar(450) NOT NULL,
  `zip` varchar(450) NOT NULL,
  `Email` varchar(450) NOT NULL,
  `Countact` varchar(450) NOT NULL,
  `Invoice` varchar(450) NOT NULL,
  `Freq` varchar(450) NOT NULL,
  `Billing` varchar(450) NOT NULL,
  `Terms` varchar(450) NOT NULL,
  `Invoice2` varchar(450) NOT NULL,
  `Grouping` varchar(450) NOT NULL,
  PRIMARY KEY  (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`idclient`,`Number`,`Name`,`AddressLine1`,`AddressLine2`,`City`,`State`,`zip`,`Email`,`Countact`,`Invoice`,`Freq`,`Billing`,`Terms`,`Invoice2`,`Grouping`) VALUES 
 (1,'100001','Feltz Printing Service','639 Main St','','Anchorage','AK','99501','lpaprocki@hotmail.com','Lenna Paprocki','Weekly','Due on Recipt','Project','','',''),
 (2,'100003','Morlong Associates','7 Eads St','','Cook','IL','60632','mitsue_tollner@yahoo.com','Mitsue Tollner','Monthly','Net 20 Days','Project','','',''),
 (3,'100005','Truhlar And Truhlar Attys','5 Boston Ave ','Suite 88','Minnehaha','SD','57105','sage_wieser@cox.net','Sage Wieser','Weekly','Net 60 Days','Project','','',''),
 (4,'100007','Buckley Miller & Wright','98 Connecticut Ave Nw','','Geauga','OH','44023','gruta@cox.net','Graciela Ruta','Monthly','Net 10 Days','Project','','',''),
 (5,'100009','Farmers Insurance Group','1 State Route 27','','Wayne','MI','48180','yuki_whobrey@aol.com','Yuki Whobrey','Weekly','Net 30 Days','Project','','',''),
 (6,'100011','C 4 Network Inc','6 Greenleaf Ave','','Santa Clara','CA','95111','vinouye@aol.com','Veronika Inouye','Monthly','Due on Recipt','Project','','','');
INSERT INTO `client` (`idclient`,`Number`,`Name`,`AddressLine1`,`AddressLine2`,`City`,`State`,`zip`,`Email`,`Countact`,`Invoice`,`Freq`,`Billing`,`Terms`,`Invoice2`,`Grouping`) VALUES 
 (7,'100013','U Pull It','90991 Thorburn Ave','','New York','NY','10011','wkusko@yahoo.com','Willow Kusko','Weekly','Net 20 Days','Project','','',''),
 (8,'100015','Milford Enterprises Inc','2742 Distribution Way','','New York','NY','10025','asergi@gmail.com','Alishia Sergi','Monthly','Net 60 Days','Project','','',''),
 (9,'100017','Fbs Business Finance','775 W 17th St','','Bexar','TX','78204','valentine_gillian@gmail.com','Valentine Gillian','Weekly','Net 10 Days','Project','','',''),
 (10,'100019','Orinda News','4486 W O St','Suite 1','New York','NY','10003','bbolognia@yahoo.com','Brock Bolognia','Monthly','Net 30 Days','Project','','','');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


--
-- Definition of table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `idcompany` int(10) unsigned NOT NULL auto_increment,
  `Name` varchar(450) NOT NULL,
  `AddressLine1` varchar(450) NOT NULL,
  `AddressLine2` varchar(450) NOT NULL,
  `City` varchar(450) NOT NULL,
  `State` varchar(450) NOT NULL,
  `Zip` varchar(450) NOT NULL,
  PRIMARY KEY  (`idcompany`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`idcompany`,`Name`,`AddressLine1`,`AddressLine2`,`City`,`State`,`Zip`) VALUES 
 (1,'Eagle Consluting','2501 E. Memorial Rd','','Edmond','OK','73013');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


--
-- Definition of table `people`
--

DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `idpeople` int(10) unsigned NOT NULL auto_increment,
  `Name` varchar(450) NOT NULL,
  `Title` varchar(450) NOT NULL,
  `BillRate` varchar(450) NOT NULL,
  `Role` varchar(450) NOT NULL,
  PRIMARY KEY  (`idpeople`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `people`
--

/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` (`idpeople`,`Name`,`Title`,`BillRate`,`Role`) VALUES 
 (1,'Name','Title','Bill Rate','Role'),
 (2,'Shenika Seewald','Sr. Software Engineer','125','Developer'),
 (3,'Deeanna Juhas','Quality Assurance Spec.','75','Developer'),
 (4,'Jamal Vanausdal','Project Manager','150','Project Manager'),
 (5,'Carmelina Lindall','Software Engineer','100','Developer'),
 (6,'Tawna Buvens','Graphic Artist','90','Developer'),
 (7,'Elly Morocco','Sr. Software Engineer','125','Developer'),
 (8,'Vallie Mondella','Quality Assurance Spec.','75','Developer'),
 (9,'Johnetta Abdallah','Project Manager','150','Project Manager'),
 (10,'Micaela Rhymes','Software Engineer','100','Developer'),
 (11,'Moon Parlato','Graphic Artist','90','Developer'),
 (12,'Delisa Crupi','Sr. Software Engineer','125','Developer'),
 (13,'Elza Lipke','Quality Assurance Spec.','75','Developer'),
 (14,'Timothy Mulqueen','Project Manager','150','Project Manager'),
 (15,'Dominque Dickerson','Software Engineer','100','Developer'),
 (16,'Myra Munns','Graphic Artist','90','Developer');
INSERT INTO `people` (`idpeople`,`Name`,`Title`,`BillRate`,`Role`) VALUES 
 (17,'Junita Brideau','Sr. Software Engineer','125','Developer'),
 (18,'Benton Skursky','Quality Assurance Spec.','75','Developer'),
 (19,'Merilyn Bayless','Project Manager','150','Project Manager'),
 (20,'Merlyn Lawler','Software Engineer','100','Developer'),
 (21,'Jettie Mconnell','Graphic Artist','90','Developer'),
 (22,'Melodie Knipp','Sr. Software Engineer','125','Developer'),
 (23,'Karan Karpin','Quality Assurance Spec.','75','Developer');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;


--
-- Definition of table `project_data`
--

DROP TABLE IF EXISTS `project_data`;
CREATE TABLE `project_data` (
  `idproject_data` int(10) unsigned NOT NULL auto_increment,
  `Client` varchar(450) NOT NULL,
  `Project` varchar(450) NOT NULL,
  `Number` varchar(450) NOT NULL,
  `StateDate` varchar(450) NOT NULL,
  `EndDate` varchar(450) NOT NULL,
  `Status` varchar(450) NOT NULL,
  `ProjectManager` varchar(450) NOT NULL,
  `ClientContact` varchar(450) NOT NULL,
  `Budget` varchar(450) NOT NULL,
  PRIMARY KEY  (`idproject_data`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_data`
--

/*!40000 ALTER TABLE `project_data` DISABLE KEYS */;
INSERT INTO `project_data` (`idproject_data`,`Client`,`Project`,`Number`,`StateDate`,`EndDate`,`Status`,`ProjectManager`,`ClientContact`,`Budget`) VALUES 
 (1,'100001','1001','E-Commerce','3/7/16','5/2/16','Closed','Amber Monarrez','Lenna Paprocki','80000'),
 (2,'100003','1003','Project Management','4/4/16','8/22/16','In Progress','Penney Weight','Mitsue Tollner','400000'),
 (3,'100005','1005','Document Generation','5/2/16','6/27/16','Closed','Laurel Reitler','Sage Wieser','240000'),
 (4,'100007','1007','Twitter Integration','5/30/16','10/17/16','In Progress','Amber Monarrez','Graciela Ruta','300000'),
 (5,'100009','1009','E-Commerce','6/27/16','8/22/16','In Progress','Penney Weight','Yuki Whobrey','200000'),
 (6,'100001','1011','Project Management','3/21/16','8/8/16','In Progress','Jamal Vanausdal','Veronika Inouye','200000'),
 (7,'100003','1013','Document Generation','4/18/16','6/13/16','In Progress','Johnetta Abdallah','Willow Kusko','160000'),
 (8,'100005','1015','Twitter Integration','5/16/16','10/3/16','In Progress','Timothy Mulqueen','Alishia Sergi','600000'),
 (9,'100007','1017','Backend Integration','6/13/16','8/8/16','In Progress','Merilyn Bayless','Valentine Gillian','120000');
INSERT INTO `project_data` (`idproject_data`,`Client`,`Project`,`Number`,`StateDate`,`EndDate`,`Status`,`ProjectManager`,`ClientContact`,`Budget`) VALUES 
 (10,'100009','1019','Publishing','4/4/16','8/22/16','In Progress','Amber Monarrez','Brock Bolognia','500000');
/*!40000 ALTER TABLE `project_data` ENABLE KEYS */;


--
-- Definition of table `projetc_person`
--

DROP TABLE IF EXISTS `projetc_person`;
CREATE TABLE `projetc_person` (
  `idprojetc_person` int(10) unsigned NOT NULL auto_increment,
  `ProjectNumber` varchar(450) NOT NULL,
  `ProjectName` varchar(450) NOT NULL,
  PRIMARY KEY  (`idprojetc_person`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projetc_person`
--

/*!40000 ALTER TABLE `projetc_person` DISABLE KEYS */;
INSERT INTO `projetc_person` (`idprojetc_person`,`ProjectNumber`,`ProjectName`) VALUES 
 (165,'Project Number','Project Name'),
 (166,'1001','Shenika Seewald'),
 (167,'1002','Cecily Hollack'),
 (168,'1003','Penney Weight'),
 (169,'1003','Ilene Eroman'),
 (170,'1004','Johnetta Abdallah'),
 (171,'1004','Micaela Rhymes'),
 (172,'1004','Moon Parlato'),
 (173,'1005','Delisa Crupi'),
 (174,'1005','Elza Lipke'),
 (175,'1005','Timothy Mulqueen'),
 (176,'1006','Arlette Honeywell'),
 (177,'1007','Shenika Seewald'),
 (178,'1008','Jamal Vanausdal'),
 (179,'1008','Carmelina Lindall'),
 (180,'1009','Penney Weight'),
 (181,'1009','Ilene Eroman'),
 (182,'1009','Kallie Blackwood'),
 (183,'1010','Shenika Seewald'),
 (184,'1010','Deeanna Juhas'),
 (185,'1010','Cecily Hollack'),
 (186,'1011','Cecily Hollack'),
 (187,'1012','Penney Weight'),
 (188,'1012','Ilene Eroman'),
 (189,'1013','Bobbye Rhym'),
 (190,'1013','Tamar Hoogland'),
 (191,'1014','Delisa Crupi'),
 (192,'1014','Elza Lipke'),
 (193,'1015','Timothy Mulqueen'),
 (194,'1015','Dominque Dickerson');
INSERT INTO `projetc_person` (`idprojetc_person`,`ProjectNumber`,`ProjectName`) VALUES 
 (195,'1015','Myra Munns'),
 (196,'1016','Carmela Cookey'),
 (197,'1017','Merilyn Bayless'),
 (198,'1017','Merlyn Lawler'),
 (199,'1018','Candida Corbley'),
 (200,'1018','Andra Scheyer'),
 (201,'1019','Shenika Seewald'),
 (202,'1019','Deeanna Juhas'),
 (203,'1020','Jamal Vanausdal'),
 (204,'1020','Carmelina Lindall'),
 (205,'1020','Tawna Buvens');
/*!40000 ALTER TABLE `projetc_person` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

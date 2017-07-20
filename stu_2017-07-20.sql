# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: stu
# Generation Time: 2017-07-20 03:30:10 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ip
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ip`;

CREATE TABLE `ip` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `eigenVal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx` (`eigenVal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ip` WRITE;
/*!40000 ALTER TABLE `ip` DISABLE KEYS */;

INSERT INTO `ip` (`id`, `name`, `num`, `eigenVal`)
VALUES
	(1,'9bbJsq9NyoENlC6XkA0i5E8fqlw0UHKWQWwpp84yBUM=\n','WguonB+iuuNpYhPkjKBmUg==\n','01000000'),
	(2,'zeHqQk1n6zySDxuJ4PZR00AKZUBxqDN5u0tPCnkqXKA=\n','N6H8f/4CsCLFJK5hXM2vqQ==\n','01000100'),
	(3,'NMO/rmKUmsv7TK1jWayO/YE/Hguhk0a5dJkQbC/34sw=\n','N6H8f/4CsCLFJK5hXM2vqQ==\n','01000010'),
	(4,'tIRDBfL4HH+Vqr0I0RyRvh2yhrla2CQnsGcN4QoJB3o=\n','J6T9h7ZRK2HcM9w+qaNeMA==\n','01000000'),
	(5,'qF6VKm6CMbHrPyJhbzV9gbwHLstOLdT6YC2pYQ8MuGU=\n','/is9rytcvM8Si4IH+tlz/w==\n','01000010'),
	(6,'z++RftSfk+6igrcotzuP7LfbugPzSVO08hPgd5ouvHE=\n','YuQEi0K3ANU6J8lfb+ruuQ==\n','00010000'),
	(7,'RL0ypLmtgzVnfsMMNQtuxc4PuHqcaIo9VUAPClkADX8=\n','z1ecZjnKFn5pes1aZpJbaA==\n','00010000'),
	(8,'TY+YZq/mVz6hsYsf+ulHGKnYjnxLJ9x4KEk5W9VokiM=\n','ZRIMks9bSwFGhzvQO8vNKA==\n','00010001'),
	(9,'Fx/zG2CMOuS+Gkc+mag0TS1e2kuZtRGHRI7huhsfgHs=\n','e/dUifKqmbQioUeID3Bzeg==\n','00000001'),
	(10,'JOjSnIpSVII7IUKjuPPN0qpp/ibEX9efc+iG1U+LYqs=\n','YuQEi0K3ANU6J8lfb+ruuQ==\n','00000100'),
	(11,'g81aUd+cXYOABTk9j4MAJlGXXlSUEcxdnBgqBZwKR0g=\n','hV2y+I188eST0D8fljfvAg==\n','00000000'),
	(12,'cTp4eHqQprrM4DPYqwJTV6h3ebLoLdnelx0HHfyJhJw=\n','ZRIMks9bSwFGhzvQO8vNKA==\n','00000000');

/*!40000 ALTER TABLE `ip` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

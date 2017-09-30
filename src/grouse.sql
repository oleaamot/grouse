-- Remove database if it exists
DROP DATABASE `grouse`; 
-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS `grouse`;
USE `grouse`;
-- Dumping structure for table grouse.kravspecs
CREATE TABLE IF NOT EXISTS `kravspec` (
  `kravspec_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`kravspec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping data for table concretepage.kravspecss: ~3 rows (approximately)
INSERT INTO `kravspec` (`kravspec_id`, `title`, `category`) VALUES
  (1, 'Java Concurrency', 'Java'),
  (2, 'Hibernate HQL ', 'Hibernate'),
  (3, 'Spring MVC with Hibernate', 'Spring');
		       

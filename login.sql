-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2018 at 08:36 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE IF NOT EXISTS `companies` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `id_number` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`company_id`, `name`, `adress`, `id_number`) VALUES
(1, 'Alfreds', 'Imaginary Way Anytown USA', '122577'),
(2, 'Prva', 'Adresa prve', '122578'),
(3, 'Druga', 'Adresa druge', '120457'),
(4, 'Treca', 'Adresa trece', '122777'),
(5, 'Cetvrta', 'Adresa cetvrte', '122577');

-- --------------------------------------------------------

--
-- Table structure for table `descriptor`
--

CREATE TABLE IF NOT EXISTS `descriptor` (
  `descriptor_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `document_id` int(11) NOT NULL,
  PRIMARY KEY (`descriptor_id`),
  KEY `document_id` (`document_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=33 ;

--
-- Dumping data for table `descriptor`
--

INSERT INTO `descriptor` (`descriptor_id`, `mark`, `name`, `type`, `document_id`) VALUES
(1, 'd1erer', 'd1 nesto bzvz', 'class java.lang.String', 1),
(3, 'neki desk', 'neki', 'class java.lang.String', 4),
(4, 'neki desk', 'neki', 'class java.lang.String', 5),
(5, 'neki desk', 'neki', 'class java.lang.String', 6),
(6, 'neki desk', 'neki', 'class java.lang.String', 7),
(7, 'neki desk', 'neki', 'class java.lang.String', 7),
(8, 'neki desk', 'neki', 'class java.lang.String', 8),
(9, 'neki desk', 'neki', 'class java.lang.String', 8),
(10, 'neki desk', 'neki', 'class java.lang.String', 9),
(11, 'neki desk', 'neki', 'class java.lang.String', 9),
(12, 'neki desk', 'neki', 'class java.lang.String', 10),
(13, 'neki desk', 'neki', 'class java.lang.String', 10),
(18, 'fdf', 'fdfd', 'class java.lang.String', 3),
(19, 'fdf', 'fdfd', 'class java.lang.String', 4),
(23, 'Datum', 'Datum', 'class java.lang.String', 3),
(24, 'Kupac', 'Kupac', 'class java.lang.String', 3),
(25, 'Datum', 'Datum', 'class java.lang.String', 4),
(26, 'Kupac', 'Kupac', 'class java.lang.String', 4),
(29, 'kup', 'kupac', 'class java.lang.String', 2),
(32, 'izn', 'iznos', 'class java.lang.Double', 2);

-- --------------------------------------------------------

--
-- Table structure for table `descriptor_value`
--

CREATE TABLE IF NOT EXISTS `descriptor_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `descriptor_id` int(11) NOT NULL,
  `document_instance_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`document_id`, `mark`, `name`, `description`) VALUES
(2, 'Racun', 'Racun', 'dfdfdfdfsdfds'),
(3, 'Faktura', 'Faktura', 'Neka faktura');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'superadmin'),
(2, 'default'),
(3, 'others');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=77 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `name`, `surname`, `email`, `company_id`) VALUES
(31, 'hellen', '123', 'Hellen', 'Bennet', 'hellenbennet@gmail.com', 5),
(33, 'superadmin', '123', 'Nenad', 'Mitrovic', 'nenadmitrovic04@gmail.com', 0),
(55, 'peraperic@gmail.com', '123', 'Pera', 'Peric', 'peraperic@gmail.com', 2),
(70, 'filip', '123', 'janko', 'jankovic', 'janko@gmail.com', 3),
(74, 'Ficko', '123', 'Filip', 'Aleksic', 'faleksic@gmail.com', 1),
(76, 'boka', '123', 'bojana', 'mitrovic', 'boka.mitrovic@gmail.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(33, 1),
(76, 1),
(31, 2),
(74, 2),
(55, 3),
(70, 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `users_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `users_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2016 a las 00:10:42
-- Versión del servidor: 5.7.9
-- Versión de PHP: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ijm_simple`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Parent` bigint(20) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name_Parent` (`Name`,`Id_Parent`) USING BTREE,
  KEY `Id_Parent` (`Id_Parent`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`Id`, `Name`, `Id_Parent`) VALUES
(1, 'Bolsas', NULL),
(4, 'Categoria POST', 1),
(3, 'Categoria Put', 4),
(8, 'INTENTO@', 2),
(2, 'Vasos', NULL),
(9, 'cambio', 1),
(6, 'cambioupdate', 1);

--
-- Disparadores `category`
--
DROP TRIGGER IF EXISTS `check_trigger_insert_category`;
DELIMITER $$
CREATE TRIGGER `check_trigger_insert_category` BEFORE INSERT ON `category` FOR EACH ROW BEGIN        
    IF (NEW.Id = NEW.Id_Parent) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Category cant parent itself. Insertion canceled';
    END IF;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `check_trigger_update_category`;
DELIMITER $$
CREATE TRIGGER `check_trigger_update_category` BEFORE UPDATE ON `category` FOR EACH ROW BEGIN        
    IF (NEW.Id = NEW.Id_Parent) THEN
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'Category cant parent itself. Update Canceled';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `file_type`
--

DROP TABLE IF EXISTS `file_type`;
CREATE TABLE IF NOT EXISTS `file_type` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Path` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `file_type`
--

INSERT INTO `file_type` (`Id`, `Name`, `Path`) VALUES
(1, 'Product_Image', 'C:/IJM/Images/Product/');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `FIle` mediumblob NOT NULL,
  `Extension` varchar(10) COLLATE utf8_bin NOT NULL,
  `File_Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Size` int(11) NOT NULL,
  `Checksum` varchar(64) COLLATE utf8_bin NOT NULL,
  `Id_File_Type` bigint(20) UNSIGNED NOT NULL,
  `Last_Updated` timestamp NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_FileType` (`Id_File_Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) COLLATE utf8_bin NOT NULL,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Description` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Category` bigint(20) UNSIGNED NOT NULL,
  `Id_Unit` bigint(20) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Category` (`Id_Category`),
  KEY `Id_Unit` (`Id_Unit`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`Id`, `Code`, `Name`, `Description`, `Id_Category`, `Id_Unit`) VALUES
(1, 'v77', 'Vasos desechables numero 7', 'Vasos desechables numero 7', 2, 2),
(2, 'BB-D12', 'Bolsa de Basura', 'Bolsa de Basura', 1, NULL),
(3, 'BA2', 'Bolsas con ASA 2kg', 'Bolsas con ASA 2kg', 2, 2),
(4, 'BA3', 'Bolsas con ASA 3kg', 'Bolsas con ASA 3kg', 1, 1),
(5, 'BA7', 'Bolsas con ASA 7kg', 'Bolsas con ASA 7kg', 6, NULL),
(6, 'pru11', 'prueba', 'probando', 1, 1),
(7, 'PRYEBA', 'sadsad', '', 1, 1),
(8, 'prueb2', 'prueb', '', 1, 1),
(9, 'b241231', '132sdad', '', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_image`
--

DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Id_Product` bigint(20) UNSIGNED NOT NULL,
  `Id_Image` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Product` (`Id_Product`),
  KEY `Id_Image` (`Id_Image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `Id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `unit`
--

INSERT INTO `unit` (`Id`, `Name`) VALUES
(1, 'Unidad'),
(2, 'Bolsas'),
(4, 'Milla');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`Id_Parent`) REFERENCES `category` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `image_ibfk_1` FOREIGN KEY (`Id_File_Type`) REFERENCES `file_type` (`Id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Id_Category`) REFERENCES `category` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`Id_Unit`) REFERENCES `unit` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `product_image`
--
ALTER TABLE `product_image`
  ADD CONSTRAINT `product_image_ibfk_1` FOREIGN KEY (`Id_Product`) REFERENCES `product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_image_ibfk_2` FOREIGN KEY (`Id_Image`) REFERENCES `image` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

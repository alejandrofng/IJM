-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2016 a las 02:43:00
-- Versión del servidor: 5.7.9
-- Versión de PHP: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ijm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Parent` int(10) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Parent` (`Id_Parent`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`Id`, `Name`, `Id_Parent`) VALUES
(1, 'Electrodomesticos', NULL),
(2, 'Neveras', 1),
(3, 'Microondas', 1),
(4, 'Ferreteria', NULL),
(5, 'Licuadora', 1),
(6, 'Neveras Portatiles', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) COLLATE utf8_bin NOT NULL,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Description` varchar(200) COLLATE utf8_bin NOT NULL,
  `Id_Category` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Category` (`Id_Category`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`Id`, `Code`, `Name`, `Description`, `Id_Category`) VALUES
(1, 'v77', 'Vasos Desechables numero 7', 'bla bla bla', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spec`
--

DROP TABLE IF EXISTS `spec`;
CREATE TABLE IF NOT EXISTS `spec` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` int(11) NOT NULL,
  `Id_Spec_group` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Spec_group` (`Id_Spec_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spec_group`
--

DROP TABLE IF EXISTS `spec_group`;
CREATE TABLE IF NOT EXISTS `spec_group` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Category` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Category` (`Id_Category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spec_selected_value`
--

DROP TABLE IF EXISTS `spec_selected_value`;
CREATE TABLE IF NOT EXISTS `spec_selected_value` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Id_Spec` int(10) UNSIGNED NOT NULL,
  `Value` varchar(50) COLLATE utf8_bin NOT NULL,
  `Id_Product` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Spec` (`Id_Spec`),
  KEY `Id_Product` (`Id_Product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `spec_value`
--

DROP TABLE IF EXISTS `spec_value`;
CREATE TABLE IF NOT EXISTS `spec_value` (
  `Id` int(10) UNSIGNED NOT NULL,
  `Value` int(11) NOT NULL,
  `Id_Spec` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Spec` (`Id_Spec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Id_Product` int(11) UNSIGNED NOT NULL,
  `Id_Unit` int(11) UNSIGNED NOT NULL,
  `Id_Supplier` int(11) UNSIGNED NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Cost` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_Product` (`Id_Product`),
  KEY `Id_Unit` (`Id_Unit`),
  KEY `Id_Supplier` (`Id_Supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Code` varchar(50) COLLATE utf8_bin NOT NULL,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`Id_Parent`) REFERENCES `category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Id_Category`) REFERENCES `category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `spec_group`
--
ALTER TABLE `spec_group`
  ADD CONSTRAINT `spec_group_ibfk_1` FOREIGN KEY (`Id_Category`) REFERENCES `category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `spec_selected_value`
--
ALTER TABLE `spec_selected_value`
  ADD CONSTRAINT `spec_selected_value_ibfk_1` FOREIGN KEY (`Id_Spec`) REFERENCES `spec` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `spec_selected_value_ibfk_2` FOREIGN KEY (`Id_Product`) REFERENCES `product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `spec_value`
--
ALTER TABLE `spec_value`
  ADD CONSTRAINT `spec_value_ibfk_1` FOREIGN KEY (`Id_Spec`) REFERENCES `spec` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`Id_Product`) REFERENCES `product` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`Id_Supplier`) REFERENCES `supplier` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stock_ibfk_3` FOREIGN KEY (`Id_Unit`) REFERENCES `unit` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

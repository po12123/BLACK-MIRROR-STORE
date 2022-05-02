-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sistemadeventas
CREATE DATABASE IF NOT EXISTS `sistemadeventas` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `sistemadeventas`;

-- Volcando estructura para tabla sistemadeventas.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `CICLI` int(11) NOT NULL,
  `NOMBRECLI` varchar(40) NOT NULL,
  `TELEFONOCLI` int(11) NOT NULL,
  `DIRECCIONCLI` varchar(40) NOT NULL,
  PRIMARY KEY (`CICLI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla sistemadeventas.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla sistemadeventas.datostienda
CREATE TABLE IF NOT EXISTS `datostienda` (
  `IDdatosTienda` int(11) NOT NULL AUTO_INCREMENT,
  `NombreTienda` varchar(50) NOT NULL,
  `Nit` varchar(20) NOT NULL,
  `TelefonoT` varchar(12) NOT NULL,
  `DireccionT` varchar(200) NOT NULL,
  `RazonSocial` varchar(200) NOT NULL,
  PRIMARY KEY (`IDdatosTienda`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla sistemadeventas.datostienda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `datostienda` DISABLE KEYS */;
INSERT INTO `datostienda` (`IDdatosTienda`, `NombreTienda`, `Nit`, `TelefonoT`, `DireccionT`, `RazonSocial`) VALUES
	(1, 'Black Mirror Store', '498999012', '498999', 'Calle Antezana #666, Cochabamba-Bolivia', 'Un sitio genial');
/*!40000 ALTER TABLE `datostienda` ENABLE KEYS */;

-- Volcando estructura para tabla sistemadeventas.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `CIPR` int(11) NOT NULL,
  `NOMBREPR` varchar(40) NOT NULL,
  `TELEFONOPR` int(11) NOT NULL,
  `DIRECCIONPR` varchar(40) NOT NULL,
  PRIMARY KEY (`CIPR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla sistemadeventas.proveedor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla sistemadeventas.vendedor
CREATE TABLE IF NOT EXISTS `vendedor` (
  `IDVR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBREVR` varchar(50) NOT NULL,
  `CIVR` varchar(20) NOT NULL,
  `DIRECCIONVR` varchar(50) NOT NULL,
  `TELEFONOVR` int(11) NOT NULL,
  `CORREOELECTRONICOVR` varchar(50) DEFAULT NULL,
  `FECHADENACIMIENTOVR` date NOT NULL,
  PRIMARY KEY (`IDVR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla sistemadeventas.vendedor: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` (`IDVR`, `NOMBREVR`, `CIVR`, `DIRECCIONVR`, `TELEFONOVR`, `CORREOELECTRONICOVR`, `FECHADENACIMIENTOVR`) VALUES
	(1, 'carlos', '12345678', 'ayacucho', 71450557, 'correo@gmail.com', '2022-04-01');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;

-- Volcando estructura para tabla sistemadeventas.vendedorlogin
CREATE TABLE IF NOT EXISTS `vendedorlogin` (
  `IDLOGINVR` int(11) NOT NULL AUTO_INCREMENT,
  `IDVR` int(11) NOT NULL,
  `USUARIOLOGINVR` varchar(20) NOT NULL,
  `CONTRASENIALOGINVR` varchar(20) NOT NULL,
  PRIMARY KEY (`IDLOGINVR`),
  KEY `FK_TIENE` (`IDVR`),
  CONSTRAINT `FK_TIENE` FOREIGN KEY (`IDVR`) REFERENCES `vendedor` (`IDVR`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla sistemadeventas.vendedorlogin: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `vendedorlogin` DISABLE KEYS */;
INSERT INTO `vendedorlogin` (`IDLOGINVR`, `IDVR`, `USUARIOLOGINVR`, `CONTRASENIALOGINVR`) VALUES
	(1, 1, 'contraseña', 'contraseña');
/*!40000 ALTER TABLE `vendedorlogin` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

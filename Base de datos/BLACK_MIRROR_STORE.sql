-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33065
-- Tiempo de generación: 02-05-2022 a las 18:33:18
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemadeventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `CICLI` int(11) NOT NULL,
  `NOMBRECLI` varchar(40) NOT NULL,
  `TELEFONOCLI` int(11) NOT NULL,
  `DIRECCIONCLI` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datostienda`
--

CREATE TABLE `datostienda` (
  `IDdatosTienda` int(11) NOT NULL,
  `NombreTienda` varchar(50) NOT NULL,
  `Nit` varchar(20) NOT NULL,
  `TelefonoT` varchar(12) NOT NULL,
  `DireccionT` varchar(200) NOT NULL,
  `RazonSocial` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datostienda`
--

INSERT INTO `datostienda` (`IDdatosTienda`, `NombreTienda`, `Nit`, `TelefonoT`, `DireccionT`, `RazonSocial`) VALUES
(1, 'Black Mirror Store', '498999012', '498999', 'Calle Antezana #666, Cochabamba-Bolivia', 'Un sitio genial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID` int(11) NOT NULL,
  `CODIGO` varchar(10) NOT NULL,
  `MARCA` varchar(20) NOT NULL,
  `MODELO` varchar(50) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PROVEEDOR` varchar(50) DEFAULT NULL,
  `PRECIO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID`, `CODIGO`, `MARCA`, `MODELO`, `CANTIDAD`, `PROVEEDOR`, `PRECIO`) VALUES
(4, 'Laptop', 'Dell', 'Alienware', 2, 'Proveedor', 10000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `CIPR` int(11) NOT NULL,
  `NOMBREPR` varchar(40) NOT NULL,
  `TELEFONOPR` int(11) NOT NULL,
  `DIRECCIONPR` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `IDVR` int(11) NOT NULL,
  `NOMBREVR` varchar(50) NOT NULL,
  `CIVR` varchar(20) NOT NULL,
  `DIRECCIONVR` varchar(50) NOT NULL,
  `TELEFONOVR` int(11) NOT NULL,
  `CORREOELECTRONICOVR` varchar(50) DEFAULT NULL,
  `FECHADENACIMIENTOVR` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedorlogin`
--

CREATE TABLE `vendedorlogin` (
  `IDLOGINVR` int(11) NOT NULL,
  `IDVR` int(11) NOT NULL,
  `USUARIOLOGINVR` varchar(20) NOT NULL,
  `CONTRASENIALOGINVR` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CICLI`);

--
-- Indices de la tabla `datostienda`
--
ALTER TABLE `datostienda`
  ADD PRIMARY KEY (`IDdatosTienda`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID`) KEY_BLOCK_SIZE=1000 USING BTREE;

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`CIPR`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`IDVR`);

--
-- Indices de la tabla `vendedorlogin`
--
ALTER TABLE `vendedorlogin`
  ADD PRIMARY KEY (`IDLOGINVR`),
  ADD KEY `FK_TIENE` (`IDVR`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datostienda`
--
ALTER TABLE `datostienda`
  MODIFY `IDdatosTienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IDVR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `vendedorlogin`
--
ALTER TABLE `vendedorlogin`
  MODIFY `IDLOGINVR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vendedorlogin`
--
ALTER TABLE `vendedorlogin`
  ADD CONSTRAINT `FK_TIENE` FOREIGN KEY (`IDVR`) REFERENCES `vendedor` (`IDVR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

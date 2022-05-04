-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:33065
-- Tiempo de generación: 04-05-2022 a las 12:31:57
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

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`CICLI`, `NOMBRECLI`, `TELEFONOCLI`, `DIRECCIONCLI`) VALUES
(124050, 'Juan Pereira', 4455665, 'Calle Bolivar'),
(1234001, 'Maria Reza', 4437899, 'Calle Los Cedros'),
(1240400, 'Mario Rojas', 4455667, 'Calle Nispero'),
(12404300, 'Romaria Lopez', 4460998, 'Calle los cedros'),
(12404307, 'Juan Coca', 44332211, 'Calle Los Lirios');

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
(1, 'Black Mirror Store', '498999012', '498999', 'Calle Antezana #666, Cochabamba-Bolivia', 'Un sitio genial'),
(2, 'Gav Sport', '13456288', '65773088', 'Ave Ramon Rivero', 'Gav Sport S.A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE `descuento` (
  `idDesc` int(11) NOT NULL,
  `fechaIniDesc` date NOT NULL,
  `fechaFinDesc` date NOT NULL,
  `codigoProd` varchar(20) NOT NULL,
  `nombreProd` varchar(100) NOT NULL,
  `descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `descuento`
--

INSERT INTO `descuento` (`idDesc`, `fechaIniDesc`, `fechaFinDesc`, `codigoProd`, `nombreProd`, `descuento`) VALUES
(4, '2022-05-04', '2022-05-31', '123W', 'Impresora Epson L380', 60),
(5, '2022-05-04', '2022-05-31', '13JA', 'Laptop Asus Zenbook Pro', 20),
(7, '2022-06-28', '2022-05-10', '13AS', 'Fotocopiadora HP Office jet Pro 15', 40);

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
  `PRECIO` int(11) NOT NULL,
  `CATEGORIA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID`, `CODIGO`, `MARCA`, `MODELO`, `CANTIDAD`, `PROVEEDOR`, `PRECIO`, `CATEGORIA`) VALUES
(4, '12AB', 'Dell', ' Alienware', 2, 'Proveedor', 10000, 'Laptop'),
(7, '13JA', 'Asus', 'Zenbook Pro', 8, 'Proveedor', 9800, 'Laptop'),
(9, '123W', 'Epson', 'L380', 10, 'Proveedor', 1500, 'Impresora'),
(10, '13AS', 'HP', 'Office jet Pro 15', 24, 'Proveedor', 15000, 'Fotocopiadora'),
(11, '133D', 'Sony', 'Bravia XR', 18, 'Proveedor', 6000, 'Televisor');

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

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`CIPR`, `NOMBREPR`, `TELEFONOPR`, `DIRECCIONPR`) VALUES
(2234650, 'Carlos Lopez', 4455660, 'Av Simon Lopez'),
(2234657, 'Rina Arispe', 4434080, 'Av. Circunvalacion'),
(97598800, 'Gonzalo Quinteros', 223456, 'Calle Madre Perla');

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

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`IDVR`, `NOMBREVR`, `CIVR`, `DIRECCIONVR`, `TELEFONOVR`, `CORREOELECTRONICOVR`, `FECHADENACIMIENTOVR`) VALUES
(1, 'Carlos Fernandez', '12404300', 'Calle El Paraiso', 4455787, 'carlosf@gmail.com', '01-05-1999'),
(2, 'Melanie Paz', '12404311', 'Calle La Paz', 4455668, 'melanie@gmail.com', '01-08-1999'),
(3, 'Fabio Gonzales Cespdes', '12408888', 'Calle Girasoles entre Valdivieso', 4455000, 'fabimelo@gmail.com', '01-08-2002');

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
-- Volcado de datos para la tabla `vendedorlogin`
--

INSERT INTO `vendedorlogin` (`IDLOGINVR`, `IDVR`, `USUARIOLOGINVR`, `CONTRASENIALOGINVR`) VALUES
(1, 1, 'CarlosF', '1234'),
(2, 2, 'Mel', '123HA'),
(3, 3, 'FabioG', '123ua');

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
-- Indices de la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD PRIMARY KEY (`idDesc`);

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
  MODIFY `IDdatosTienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `descuento`
--
ALTER TABLE `descuento`
  MODIFY `idDesc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IDVR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `vendedorlogin`
--
ALTER TABLE `vendedorlogin`
  MODIFY `IDLOGINVR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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

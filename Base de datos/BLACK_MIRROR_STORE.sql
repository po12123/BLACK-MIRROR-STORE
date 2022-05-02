-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2022 at 01:15 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sitemadeventas`
--

-- --------------------------------------------------------

--
-- Table structure for table `datostienda`
--
drop table if exists VENDEDOR;

drop table if exists VENDEDORLOGIN;

/*==============================================================*/
/* Table: VENDEDOR                                              */
/*==============================================================*/
create table VENDEDOR
(
   IDVR                 int not null auto_increment,
   NOMBREVR             varchar(50) not null,
   CIVR                 varchar(20) not null,
   DIRECCIONVR          varchar(50) not null,
   TELEFONOVR           int not null,
   CORREOELECTRONICOVR  varchar(50),
   FECHADENACIMIENTOVR  date not null,
   primary key (IDVR)
);
/*==============================================================*/
/* Table: VENDEDORLOGIN                                         */
/*==============================================================*/
create table VENDEDORLOGIN
(
   IDLOGINVR            int not null auto_increment,
   IDVR                 int not null,
   USUARIOLOGINVR       varchar(20) not null,
   CONTRASENIALOGINVR   varchar(20) not null,
   primary key (IDLOGINVR)
);

CREATE TABLE `datostienda` (
  `IDdatosTienda` int(11) NOT NULL,
  `NombreTienda` varchar(50) NOT NULL,
  `Nit` varchar(20) NOT NULL,
  `TelefonoT` varchar(12) NOT NULL,
  `DireccionT` varchar(200) NOT NULL,
  `RazonSocial` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table VENDEDORLOGIN add constraint FK_TIENE foreign key (IDVR)
      references VENDEDOR (IDVR) on delete restrict on update restrict;
--
-- Dumping data for table `datostienda`
--

INSERT INTO `datostienda` (`IDdatosTienda`, `NombreTienda`, `Nit`, `TelefonoT`, `DireccionT`, `RazonSocial`) VALUES
(1, 'Black Mirror Store', '498999012', '498999', 'Calle Antezana #666, Cochabamba-Bolivia', 'Un sitio genial');

INSERT INTO `vendedor` (`IDVR`, `NOMBREVR`, `CIVR`, `DIRECCIONVR`, `TELEFONOVR`, `CORREOELECTRONICOVR`, `FECHADENACIMIENTOVR`) VALUES
	(1, 'carlos', '12345678', 'ayacucho', 71450557, 'correo@gmail.com', '2022-04-01');

INSERT INTO `vendedorlogin` (`IDLOGINVR`, `IDVR`, `USUARIOLOGINVR`, `CONTRASENIALOGINVR`) VALUES
	(1, 1, 'contraseña', 'contraseña');
--
-- Indexes for dumped tables
--

--
-- Indexes for table `datostienda`
--
ALTER TABLE `datostienda`
  ADD PRIMARY KEY (`IDdatosTienda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datostienda`
--
ALTER TABLE `datostienda`
  MODIFY `IDdatosTienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-06-2018 a las 19:57:35
-- Versión del servidor: 5.7.21-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.29-1+ubuntu16.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Albaran`
--

CREATE TABLE `Albaran` (
  `CodAlbaran` int(10) NOT NULL,
  `CodRefCli` int(10) NOT NULL,
  `CdoRefPro` varchar(999) NOT NULL,
  `CIFPropio` varchar(10) NOT NULL,
  `DirArchivo` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Albaran`
--

INSERT INTO `Albaran` (`CodAlbaran`, `CodRefCli`, `CdoRefPro`, `CIFPropio`, `DirArchivo`) VALUES
(1, 1, '666452152x10-', '6666666', 'N:\\');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Clientes`
--

CREATE TABLE `Clientes` (
  `CodRefCli` int(10) NOT NULL,
  `RazonSocial` varchar(240) NOT NULL,
  `CIF` int(10) NOT NULL,
  `Num` int(11) NOT NULL,
  `Correo` varchar(360) NOT NULL,
  `Direccion` varchar(500) NOT NULL,
  `MetodoPago` varchar(30) NOT NULL,
  `Observaciones` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Clientes`
--

INSERT INTO `Clientes` (`CodRefCli`, `RazonSocial`, `CIF`, `Num`, `Correo`, `Direccion`, `MetodoPago`, `Observaciones`) VALUES
(1, 'Maños Informaticos', 666666666, 964666666, 'maños@maños.com', 'Mañolandia', 'Transferencia', 'Maños tenian que ser');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleados`
--

CREATE TABLE `Empleados` (
  `Cod.Empleado` int(10) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `DNI` varchar(10) NOT NULL,
  `Direccion` varchar(500) NOT NULL,
  `FechaAlta` date NOT NULL,
  `CopiaContrato` varchar(500) NOT NULL,
  `NCuenta` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Empleados`
--

INSERT INTO `Empleados` (`Cod.Empleado`, `Nombre`, `Apellidos`, `DNI`, `Direccion`, `FechaAlta`, `CopiaContrato`, `NCuenta`) VALUES
(1, 'Carlos', 'Basilio', '15421451H', 'Calle el rio', '2018-05-17', 'aaa', 884723877);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Existencias`
--

CREATE TABLE `Existencias` (
  `Cod.RefExistencia` int(10) NOT NULL,
  `Cod.RefPro` varchar(30) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Sitio` varchar(500) NOT NULL,
  `Proposito` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Existencias`
--

INSERT INTO `Existencias` (`Cod.RefExistencia`, `Cod.RefPro`, `Cantidad`, `Sitio`, `Proposito`) VALUES
(1, '666452152', 50, 'Almacen', 'Stock mínimo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PedidosC`
--

CREATE TABLE `PedidosC` (
  `NumPed` int(10) NOT NULL,
  `FechaPedido` date NOT NULL,
  `FormadePago` varchar(50) NOT NULL,
  `EnviadoA` varchar(500) NOT NULL,
  `CodCliente` int(10) NOT NULL,
  `CPP` varchar(999) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PedidosC`
--

INSERT INTO `PedidosC` (`NumPed`, `FechaPedido`, `FormadePago`, `EnviadoA`, `CodCliente`, `CPP`) VALUES
(1, '2018-05-31', 'E', 'Su casa', 1, '666452152x10-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PedidosP`
--

CREATE TABLE `PedidosP` (
  `NumPed` int(10) NOT NULL,
  `FechaPedido` date NOT NULL,
  `FormadePago` varchar(50) NOT NULL,
  `EnviadoA` varchar(500) NOT NULL,
  `CodProv` int(10) NOT NULL,
  `CPP` varchar(999) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PedidosP`
--

INSERT INTO `PedidosP` (`NumPed`, `FechaPedido`, `FormadePago`, `EnviadoA`, `CodProv`, `CPP`) VALUES
(1, '2018-05-31', 'Efectivo', 'Almacen', 1, '666452152x1-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Productos`
--

CREATE TABLE `Productos` (
  `Cod.RefPro` varchar(30) NOT NULL,
  `Nombre` varchar(240) NOT NULL,
  `Descripcion` varchar(600) NOT NULL,
  `PrecioNeto` double NOT NULL,
  `PVP` double NOT NULL,
  `CodRefProv` int(10) NOT NULL,
  `Familia` varchar(15) NOT NULL,
  `Existencias` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Productos`
--

INSERT INTO `Productos` (`Cod.RefPro`, `Nombre`, `Descripcion`, `PrecioNeto`, `PVP`, `CodRefProv`, `Familia`, `Existencias`) VALUES
('666452152', 'Cianuro', 'Cianurito para Olek :D', 0, 20, 1, 'Veneno', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PropiaEmpresa`
--

CREATE TABLE `PropiaEmpresa` (
  `CIF` varchar(10) NOT NULL,
  `RazonSocial` varchar(500) NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Correo` varchar(260) NOT NULL,
  `Direccion` varchar(500) NOT NULL,
  `NCuenta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PropiaEmpresa`
--

INSERT INTO `PropiaEmpresa` (`CIF`, `RazonSocial`, `Telefono`, `Correo`, `Direccion`, `NCuenta`) VALUES
('6666666', 'Oleksandr SL', 642767948, 'o.lugovskyy@gmail.com', 'Mi casa', 'Nunca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedor`
--

CREATE TABLE `Proveedor` (
  `Cod.Referencia` int(10) NOT NULL,
  `RazonSocial` varchar(120) NOT NULL,
  `CIF` int(10) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Correo` varchar(120) NOT NULL,
  `Direccion` varchar(360) NOT NULL,
  `MetodoPago` varchar(1) NOT NULL,
  `Observaciones` varchar(360) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Proveedor`
--

INSERT INTO `Proveedor` (`Cod.Referencia`, `RazonSocial`, `CIF`, `Numero`, `Correo`, `Direccion`, `MetodoPago`, `Observaciones`) VALUES
(1, 'PericoDeLosPalotes', 777777777, 964777777, 'pericodelospalotes@gmail.com', 'Sucasa', 'T', 'Ninguna');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Albaran`
--
ALTER TABLE `Albaran`
  ADD PRIMARY KEY (`CodAlbaran`),
  ADD KEY `CodRefCli` (`CodRefCli`),
  ADD KEY `CdoRefPro` (`CdoRefPro`),
  ADD KEY `CIFPropio` (`CIFPropio`);

--
-- Indices de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  ADD PRIMARY KEY (`CodRefCli`);

--
-- Indices de la tabla `Empleados`
--
ALTER TABLE `Empleados`
  ADD PRIMARY KEY (`Cod.Empleado`);

--
-- Indices de la tabla `Existencias`
--
ALTER TABLE `Existencias`
  ADD PRIMARY KEY (`Cod.RefExistencia`),
  ADD KEY `Cod.RefPro` (`Cod.RefPro`);

--
-- Indices de la tabla `PedidosC`
--
ALTER TABLE `PedidosC`
  ADD PRIMARY KEY (`NumPed`),
  ADD KEY `CodCliente` (`CodCliente`),
  ADD KEY `CPP` (`CPP`);

--
-- Indices de la tabla `PedidosP`
--
ALTER TABLE `PedidosP`
  ADD PRIMARY KEY (`NumPed`),
  ADD KEY `Cod.Prov` (`CodProv`),
  ADD KEY `CPP` (`CPP`),
  ADD KEY `Cod.Prov_2` (`CodProv`),
  ADD KEY `CPP_2` (`CPP`);

--
-- Indices de la tabla `Productos`
--
ALTER TABLE `Productos`
  ADD PRIMARY KEY (`Cod.RefPro`),
  ADD KEY `CodRefProv` (`CodRefProv`);

--
-- Indices de la tabla `PropiaEmpresa`
--
ALTER TABLE `PropiaEmpresa`
  ADD PRIMARY KEY (`CIF`);

--
-- Indices de la tabla `Proveedor`
--
ALTER TABLE `Proveedor`
  ADD PRIMARY KEY (`Cod.Referencia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Albaran`
--
ALTER TABLE `Albaran`
  MODIFY `CodAlbaran` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  MODIFY `CodRefCli` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Empleados`
--
ALTER TABLE `Empleados`
  MODIFY `Cod.Empleado` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Existencias`
--
ALTER TABLE `Existencias`
  MODIFY `Cod.RefExistencia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `PedidosC`
--
ALTER TABLE `PedidosC`
  MODIFY `NumPed` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `PedidosP`
--
ALTER TABLE `PedidosP`
  MODIFY `NumPed` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `Proveedor`
--
ALTER TABLE `Proveedor`
  MODIFY `Cod.Referencia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Albaran`
--
ALTER TABLE `Albaran`
  ADD CONSTRAINT `Albaran_ibfk_2` FOREIGN KEY (`CIFPropio`) REFERENCES `PropiaEmpresa` (`CIF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Albaran_ibfk_3` FOREIGN KEY (`CodRefCli`) REFERENCES `Clientes` (`CodRefCli`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Existencias`
--
ALTER TABLE `Existencias`
  ADD CONSTRAINT `Existencias_ibfk_1` FOREIGN KEY (`Cod.RefPro`) REFERENCES `Productos` (`Cod.RefPro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `PedidosC`
--
ALTER TABLE `PedidosC`
  ADD CONSTRAINT `PedidosC_ibfk_3` FOREIGN KEY (`CodCliente`) REFERENCES `Clientes` (`CodRefCli`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `PedidosP`
--
ALTER TABLE `PedidosP`
  ADD CONSTRAINT `PedidosP_ibfk_3` FOREIGN KEY (`CodProv`) REFERENCES `Proveedor` (`Cod.Referencia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Productos`
--
ALTER TABLE `Productos`
  ADD CONSTRAINT `Productos_ibfk_1` FOREIGN KEY (`CodRefProv`) REFERENCES `Proveedor` (`Cod.Referencia`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

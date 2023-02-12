-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-02-2023 a las 04:19:52
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admins`
--

CREATE TABLE `admins` (
  `id` int(10) NOT NULL,
  `nom_user_admin` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `admins`
--

INSERT INTO `admins` (`id`, `nom_user_admin`, `password`) VALUES
(1, 'admin', 'admin1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id_citas` int(10) NOT NULL,
  `id_paciente` int(10) NOT NULL,
  `id_horario` int(10) NOT NULL,
  `motivo` varchar(50) NOT NULL,
  `fecha_res` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historiaclinica`
--

CREATE TABLE `historiaclinica` (
  `cedula` int(10) NOT NULL,
  `alergias` longtext NOT NULL,
  `Enfermedades_pre_existentes` longtext NOT NULL,
  `medicamentos ingeridos` longtext NOT NULL,
  `operaciones_realizadas` longtext NOT NULL,
  `tratamiento` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `historiaclinica`
--

INSERT INTO `historiaclinica` (`cedula`, `alergias`, `Enfermedades_pre_existentes`, `medicamentos ingeridos`, `operaciones_realizadas`, `tratamiento`) VALUES
(1751398944, 'ALERGIA AL FRIO', 'NADA', 'NADA', 'NADA', 'VERIFICACION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL,
  `medicos_id` int(11) DEFAULT NULL,
  `Horario` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id`, `medicos_id`, `Horario`) VALUES
(3, 18, '4-1-04:00-LUNES-Juan Carlos'),
(4, 18, '5-1-05:00-LUNES-Juan Carlos'),
(5, 18, '6-1-06:00-LUNES-Juan Carlos'),
(6, 18, '7-1-07:00-LUNES-Juan Carlos'),
(7, 18, '8-1-08:00-LUNES-Juan Carlos'),
(8, 18, '9-1-09:00-LUNES-Juan Carlos'),
(9, 18, '10-1-10:00-LUNES-Juan Carlos'),
(10, 18, '11-1-11:00-LUNES-Juan Carlos'),
(11, 18, '11-2-11:00-MARTES-Juan Carlos'),
(12, 18, '12-2-12:00-MARTES-Juan Carlos'),
(13, 18, '13-2-13:00-MARTES-Juan Carlos'),
(14, 18, '14-2-14:00-MARTES-Juan Carlos'),
(15, 18, '15-2-15:00-MARTES-Juan Carlos'),
(16, 18, '16-2-16:00-MARTES-Juan Carlos'),
(17, 23, '3-4-03:00-JUEVES-Carolina Romero'),
(18, 23, '4-4-04:00-JUEVES-Carolina Romero'),
(19, 23, '5-4-05:00-JUEVES-Carolina Romero'),
(20, 23, '6-4-06:00-JUEVES-Carolina Romero'),
(21, 23, '7-4-07:00-JUEVES-Carolina Romero'),
(22, 23, '8-4-08:00-JUEVES-Carolina Romero'),
(23, 23, '9-4-09:00-JUEVES-Carolina Romero'),
(24, 23, '10-4-10:00-JUEVES-Carolina Romero'),
(25, 24, '16-3-16:00-MIERCOLES-Alma Linacia'),
(26, 24, '17-3-17:00-MIERCOLES-Alma Linacia'),
(27, 24, '18-3-18:00-MIERCOLES-Alma Linacia'),
(28, 24, '19-3-19:00-MIERCOLES-Alma Linacia'),
(29, 18, '18-1-18:00-LUNES-Juan Carlos'),
(30, 18, '19-1-19:00-LUNES-Juan Carlos'),
(31, 18, '19-2-19:00-MARTES-Juan Carlos'),
(32, 18, '21-2-21:00-MARTES-Juan Carlos'),
(33, 18, '22-2-22:00-MARTES-Juan Carlos'),
(34, 18, '23-2-23:00-MARTES-Juan Carlos'),
(35, 18, '4-4-04:00-JUEVES-Juan Carlos'),
(36, 18, '5-4-05:00-JUEVES-Juan Carlos'),
(37, 18, '7-4-07:00-JUEVES-Juan Carlos'),
(38, 18, '6-4-06:00-JUEVES-Juan Carlos'),
(39, 18, '8-4-08:00-JUEVES-Juan Carlos'),
(40, 18, '9-4-09:00-JUEVES-Juan Carlos'),
(41, 18, '10-4-10:00-JUEVES-Juan Carlos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `especialidad` varchar(50) NOT NULL,
  `numero_telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `Cedula` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`id`, `nombre`, `apellido`, `Correo`, `fecha_nacimiento`, `especialidad`, `numero_telefono`, `direccion`, `Cedula`) VALUES
(18, 'Juan', 'Carlos', 'juanca2000@salud.sa.com', '2000-12-20', 'Endovascular', '995934570', 'Quito', 0),
(22, 'Michelle', 'Andrade', 'michandra@salud.sa.com', '2000-04-03', 'Dermatología', '987518558', 'Kenedy', 1705136879),
(23, 'Carolina', 'Romero', 'caromero89@salud.sa.com', '2001-01-22', 'Cirugía Pediátrica', '995631457', 'Quinche', 1708931456),
(24, 'Alma', 'Linacia', 'linaciama99@salud.sa.com', '1968-08-24', 'Cardiología Intervencionista', '987518558', 'San Luis', 1708978463),
(25, 'Julian Daniel', 'Hernandez Lopez', 'juliandan@salud.sa.com', '2000-02-28', 'Anatomía Patológica', '0995934570', 'Loma', 1705121885);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cedula` int(10) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` varchar(50) NOT NULL,
  `numero_telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `password_pac` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id`, `nombre`, `apellido`, `cedula`, `correo`, `fecha_nacimiento`, `genero`, `numero_telefono`, `direccion`, `password_pac`) VALUES
(14, 'Santiago David', 'Brito Vega', 1751398999, 'davidbri89@outlook.com', '2002-03-28', 'Masculino', '0995934570', 'Quito', '1751398999'),
(15, 'Alexis David', 'Lomas Garcia', 1751398944, 'alex@gmail.com', '2002-12-28', 'Masculino', '0987518559', 'Pichincha', 'Alexis2002'),
(16, 'Santiago Jaime', 'Bueno Chavez', 1751398944, 'dav@salud.com', '2004-01-30', 'Masculino', '098875185', 'Elquinche', 'SantJa2004');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

CREATE TABLE `tratamientos` (
  `id` int(10) NOT NULL,
  `id_paciente` int(10) NOT NULL,
  `id_medico` int(10) NOT NULL,
  `medicamentos` varchar(50) NOT NULL,
  `indicaciones` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_citas`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `medicos_id` (`medicos_id`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id_citas` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `medicos`
--
ALTER TABLE `medicos`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`medicos_id`) REFERENCES `medicos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

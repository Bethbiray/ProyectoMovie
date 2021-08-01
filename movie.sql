-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-08-2021 a las 08:38:54
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `movie`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create` (`p_name` VARCHAR(255), `p_description` VARCHAR(255), `p_date_premiere` DATE, `p_collection` DOUBLE)  BEGIN
INSERT INTO registro_peliculas(name,description,date_premiere,collection)
VALUES (p_name, p_description, p_date_premiere,p_collection);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete` (`p_id` INT)  BEGIN
 UPDATE registro_peliculas SET status=0 WHERE id=p_id;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_findAll` ()  BEGIN
SELECT * FROM registro_peliculas;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_findById` (`p_id` INT)  BEGIN
SELECT * FROM registro_peliculas WHERE id=p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update` (`p_id` INT, `p_name` VARCHAR(255), `p_description` VARCHAR(255), `p_date_premiere` DATE, `p_collection` DOUBLE)  BEGIN
	UPDATE registro_peliculas SET name=p_name, description=p_description, date_premiere=p_date_premiere, collection=p_collection WHERE id=p_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_peliculas`
--

CREATE TABLE `registro_peliculas` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date_premiere` date NOT NULL,
  `collection` double NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `registro_peliculas`
--

INSERT INTO `registro_peliculas` (`id`, `name`, `description`, `date_premiere`, `collection`, `status`) VALUES
(1, 'Un jefe en pañales', 'Tim, de 7 años, tiene celos de su hermano, un bebé que viste traje y corbata, hasta que descubre que el bebé puede hablar.', '2021-07-14', 528, 0),
(2, 'Space Jam: una nueva era', 'Atrapado en el espacio digital, la superestrella del baloncesto LeBron James se une a la banda de los Looney Tunes', '2021-07-23', 600, 0),
(3, 'Cruella', 'La joven Estella está decidida a hacerse un nombre en el mundo de la moda.', '2021-09-08', 500, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registro_peliculas`
--
ALTER TABLE `registro_peliculas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registro_peliculas`
--
ALTER TABLE `registro_peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

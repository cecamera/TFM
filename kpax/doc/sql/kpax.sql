-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-03-2015 a las 20:29:57
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `kpax`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Ability`
--

DROP TABLE IF EXISTS `Ability`;
CREATE TABLE IF NOT EXISTS `Ability` (
  `idAbility` int(11) NOT NULL AUTO_INCREMENT,
  `nameAbility` varchar(20) NOT NULL,
  PRIMARY KEY (`idAbility`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `Ability`
--

INSERT INTO `Ability` (`idAbility`, `nameAbility`) VALUES
(1, 'Generics'),
(2, 'Siences'),
(3, 'History'),
(4, 'Humanities'),
(5, 'Languages');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `AbilityProficiency`
--

DROP TABLE IF EXISTS `AbilityProficiency`;
CREATE TABLE IF NOT EXISTS `AbilityProficiency` (
  `idAbilityProficiency` int(11) NOT NULL AUTO_INCREMENT,
  `idAbility` int(11) NOT NULL,
  `idProficiency` int(11) NOT NULL,
  PRIMARY KEY (`idAbilityProficiency`),
  KEY `Ability` (`idAbility`),
  KEY `Proficiency` (`idProficiency`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `AbilityProficiency`
--

INSERT INTO `AbilityProficiency` (`idAbilityProficiency`, `idAbility`, `idProficiency`) VALUES
(1, 1, 21),
(2, 1, 22),
(3, 1, 23),
(4, 2, 1),
(5, 2, 2),
(6, 2, 3),
(7, 2, 4),
(8, 3, 16),
(9, 3, 17),
(10, 3, 18),
(11, 3, 19),
(12, 3, 20),
(13, 4, 12),
(14, 4, 13),
(15, 4, 14),
(16, 4, 15),
(17, 5, 5),
(18, 5, 6),
(19, 5, 7),
(20, 5, 8),
(21, 5, 9),
(22, 5, 10),
(23, 5, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Award`
--

DROP TABLE IF EXISTS `Award`;
CREATE TABLE IF NOT EXISTS `Award` (
  `idAward` int(11) NOT NULL AUTO_INCREMENT,
  `idProficiency` int(11) NOT NULL,
  `maxLevel` tinyint(1) NOT NULL,
  `idGame` int(11) NOT NULL,
  `descripAward` varchar(50) NOT NULL,
  PRIMARY KEY (`idAward`),
  KEY `Proficiency` (`idProficiency`),
  KEY `Game` (`idGame`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Volcado de datos para la tabla `Award`
--

INSERT INTO `Award` (`idAward`, `idProficiency`, `maxLevel`, `idGame`, `descripAward`) VALUES
(1, 1, 4, 67, 'Award 1'),
(2, 2, 3, 67, 'Award 2'),
(3, 3, 3, 67, 'Award 3'),
(4, 4, 4, 67, 'Award 4'),
(5, 5, 3, 68, 'Award 5'),
(6, 6, 3, 68, 'Award 6'),
(7, 7, 4, 68, 'Award 7'),
(8, 8, 3, 68, 'Award 8'),
(9, 9, 4, 68, 'Award 9'),
(10, 10, 4, 69, 'Award 10'),
(11, 11, 3, 69, 'Award 11'),
(12, 12, 3, 69, 'Award 12'),
(13, 13, 4, 69, 'Award 13'),
(14, 14, 3, 87, 'Award 14'),
(15, 15, 4, 87, 'Award 15'),
(16, 16, 3, 87, 'Award 16'),
(17, 17, 3, 87, 'Award 17'),
(18, 18, 4, 87, 'Award 18'),
(19, 19, 4, 88, 'Award 19'),
(20, 20, 3, 88, 'Award 20'),
(21, 21, 3, 88, 'Award 21'),
(22, 22, 3, 88, 'Award 22'),
(23, 23, 4, 89, 'Award 23'),
(24, 1, 4, 89, 'Award 24'),
(25, 2, 4, 89, 'Award 25'),
(26, 3, 3, 89, 'Award 26'),
(27, 4, 4, 89, 'Award 27'),
(28, 5, 3, 90, 'Award 28'),
(29, 6, 4, 90, 'Award 29'),
(30, 7, 3, 90, 'Award 30'),
(31, 8, 3, 90, 'Award 31'),
(32, 9, 4, 91, 'Award 32'),
(33, 10, 4, 91, 'Award 33'),
(34, 11, 3, 91, 'Award 34'),
(35, 12, 3, 91, 'Award 35'),
(36, 13, 3, 91, 'Award 36'),
(37, 14, 4, 92, 'Award 37'),
(38, 15, 4, 92, 'Award 38'),
(39, 16, 3, 92, 'Award 39'),
(40, 17, 3, 92, 'Award 40'),
(41, 18, 4, 93, 'Award 41'),
(42, 19, 3, 93, 'Award 42'),
(43, 20, 4, 93, 'Award 43'),
(44, 21, 3, 93, 'Award 44'),
(45, 22, 3, 93, 'Award 45'),
(46, 23, 4, 93, 'Award 46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Badge`
--

DROP TABLE IF EXISTS `Badge`;
CREATE TABLE IF NOT EXISTS `Badge` (
  `idBadge` int(11) NOT NULL AUTO_INCREMENT,
  `nameBadge` varchar(40) NOT NULL,
  `descripBadge` varchar(100) NOT NULL,
  `imageBadge` varchar(12) NOT NULL,
  PRIMARY KEY (`idBadge`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `Badge`
--

INSERT INTO `Badge` (`idBadge`, `nameBadge`, `descripBadge`, `imageBadge`) VALUES
(1, 'PREMI A LA DEDICACIÓ', 'És un premi al jugador que ha fet més de 200 partides en una setmana', 'BADGE01.GIF'),
(2, 'PREMI A LA VARIETAT', 'És un premi al jugador que ha participat en 20 jocs en una setmana', 'BADGE02.GIF'),
(3, 'PREMI A LA CONSTÀNCIA EN UN JOC', 'És un premi al jugador que ha jugat 50 partides del mateix joc en un mateix dia', 'BADGE03.GIF'),
(4, 'PREMI A LA PERSISTÈNCIA', 'És un premi al jugador que ha fet més de 100 partides en un dia', 'BADGE04.GIF'),
(5, 'PREMI A LA GRAN VARIETAT', 'És un premi al jugador que ha participat en 20 jocs en un sol dia', 'BADGE05.GIF');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Category`
--

DROP TABLE IF EXISTS `Category`;
CREATE TABLE IF NOT EXISTS `Category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategory`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `name_2` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `Category`
--

INSERT INTO `Category` (`idCategory`, `name`) VALUES
(1, 'Category 1'),
(2, 'Category 2'),
(3, 'Category 3'),
(4, 'Category 4'),
(5, 'Category 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Comment`
--

DROP TABLE IF EXISTS `Comment`;
CREATE TABLE IF NOT EXISTS `Comment` (
  `idComment` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idComment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Game`
--

DROP TABLE IF EXISTS `Game`;
CREATE TABLE IF NOT EXISTS `Game` (
  `idGame` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `grantPublicAccess` tinyint(1) DEFAULT '0',
  `secretGame` varchar(150) DEFAULT NULL,
  `privateKey` text,
  `idCategory` int(11) DEFAULT '0',
  `idPlatform` int(11) DEFAULT '0',
  `idSkill` int(11) DEFAULT '0',
  `creationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `developer` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idGame`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `Game`
--

INSERT INTO `Game` (`idGame`, `name`, `grantPublicAccess`, `secretGame`, `privateKey`, `idCategory`, `creationDate`, `developer`) VALUES
(144, 'juego 18-05', 0, 'GAME.30857ce489048a9e3a4f29820c8ddb46abc4e602', 'e58b6528958990ff4998ac0e2c375881f4dbe03f', 1, '2015-05-18 09:45:46', 'admin'),
(180, 'Juego_151048', 1, 'GAME.5b53b5b6e16580edfcbf8099d2478ce2dba79922', 'c4394a4845d0fca88aae042b3a3405830c100e90', 1, '2015-03-15 12:48:06', 'admin'),
(181, 'Dani161631', 0, 'GAME.ba6bbebab8438cd1f758648c908eb7752a8f9bef', '2344f2a6d1cc9ad384ea7e2cb9c309e51578c668', 1, '2015-03-16 18:31:29', 'dani');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameAccess`
--

DROP TABLE IF EXISTS `GameAccess`;
CREATE TABLE IF NOT EXISTS `GameAccess` (
  `idGroup` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `type` varchar(10) NOT NULL DEFAULT 'allow',
  `recursive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idGroup`,`idGame`),
  KEY `GameAccess_Group` (`idGroup`),
  KEY `GameAccess_Game` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `GameInstance`
--

DROP TABLE IF EXISTS `GameInstance`;
CREATE TABLE IF NOT EXISTS `GameInstance` (
  `idGameInstance` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `state` longtext,
  PRIMARY KEY (`idGameInstance`),
  KEY `GameInstance_Game` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameDetail`
--

DROP TABLE IF EXISTS `GameDetail`;
CREATE TABLE IF NOT EXISTS `GameDetail` (
  `idGameDetail` int(11) NOT NULL AUTO_INCREMENT,
  `gameId` int(11) NOT NULL,
  `description` text,
  `logo` varchar(150) DEFAULT NULL,
  `banner` varchar(150) DEFAULT NULL,
  `videourl` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idGameDetail`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `GameDetail`
--

INSERT INTO `GameDetail` (`idGameDetail`, `gameId`, `description`, `logo`, `banner`, `videourl`) VALUES
(1, 180, '<p>Este es el juego inicial y lo modifico</p>', 'e:\\images\\image1.jpg', 'e:\\images\\image2.jpg', 'https://www.youtube.com/watch?v=j81DDY4nvos'),
(2, 181, '<p>juego de dani</p>', 'asd', 'asd', 'asd'),
(3, 144, '', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameImage`
--

DROP TABLE IF EXISTS `GameImage`;
CREATE TABLE IF NOT EXISTS `GameImage` (
  `idGameImage` int(11) NOT NULL AUTO_INCREMENT,
  `gameId` int(11) NOT NULL,
  `image` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idGameImage`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `gameimage`
--

INSERT INTO `GameImage` (`idGameImage`, `gameId`, `image`) VALUES
(1, 180, 'e:\\images\\image1.jpg'),
(2, 180, 'e:\\images\\image2.jpg'),
(3, 181, 'imagen1'),
(4, 181, 'imagen2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gameinstance`
--

DROP TABLE IF EXISTS `GameInstance`;
CREATE TABLE IF NOT EXISTS `GameInstance` (
  `idGameInstance` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `state` longtext,
  PRIMARY KEY (`idGameInstance`),
  KEY `GameInstance_Game` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameLike`
--

DROP TABLE IF EXISTS `GameLike`;
CREATE TABLE IF NOT EXISTS `GameLike` (
  `likeId` int(11) NOT NULL AUTO_INCREMENT,
  `gameId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `containerId` int(11) NOT NULL,
  PRIMARY KEY (`likeId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GameScore`
--

DROP TABLE IF EXISTS `GameScore`;
CREATE TABLE IF NOT EXISTS `GameScore` (
  `idScore` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  PRIMARY KEY (`idScore`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Group`
--

DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group` (
  `idGroup` int(11) NOT NULL,
  `description` longtext,
  `idGroupParent` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGroup`),
  KEY `GROUP_GROUP` (`idGroupParent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -------------------------------------------------------
--
-- Estructura de tabla para la tabla `Platform`
--

DROP TABLE IF EXISTS `Platform`;
CREATE TABLE IF NOT EXISTS `Platform` (
  `idPlatform` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`idPlatform`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `name_2` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `Platform`
--

INSERT INTO `Platform` (`idPlatform`, `name`) VALUES
(2, 'Android'),
(3, 'iOS'),
(4, 'Nintendo DS'),
(6, 'Nintendo Wii'),
(5, 'PSP'),
(1, 'Web'),
(7, 'XBox');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proficiency`
--

DROP TABLE IF EXISTS `Proficiency`;
CREATE TABLE IF NOT EXISTS `Proficiency` (
  `idProficiency` int(11) NOT NULL AUTO_INCREMENT,
  `nameProficiency` varchar(20) NOT NULL,
  PRIMARY KEY (`idProficiency`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `Proficiency`
--

INSERT INTO `Proficiency` (`idProficiency`, `nameProficiency`) VALUES
(1, 'Mathematics'),
(2, 'Biology'),
(3, 'Physics'),
(4, 'Geology'),
(5, 'Catalan lang.'),
(6, 'Spanish lang.'),
(7, 'English lang.'),
(8, 'French lang.'),
(9, 'German lang.'),
(10, 'European lang.'),
(11, 'Other lang.'),
(12, 'Laws'),
(13, 'Economics'),
(14, 'Literature'),
(15, 'Social sciences'),
(16, 'Prehistory'),
(17, 'Ancient hist.'),
(18, 'Postclassical hist.'),
(19, 'Modern hist.'),
(20, 'Contemporany hist.'),
(21, 'Spatial vision'),
(22, 'Reflexes'),
(23, 'Memory');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Realm`
--

DROP TABLE IF EXISTS `Realm`;
CREATE TABLE IF NOT EXISTS `Realm` (
  `idRealm` int(11) NOT NULL AUTO_INCREMENT,
  `alias` char(15) NOT NULL,
  PRIMARY KEY (`idRealm`),
  UNIQUE KEY `alias_UNIQUE` (`alias`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `Realm`
--

INSERT INTO `Realm` (`idRealm`, `alias`) VALUES
(1, 'ELGG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Session`
--

DROP TABLE IF EXISTS `Session`;
CREATE TABLE IF NOT EXISTS `Session` (
  `idSession` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `startTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campusSession` varchar(250) NOT NULL,
  PRIMARY KEY (`idSession`),
  KEY `Session_User` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Skill`
--

DROP TABLE IF EXISTS `Skill`;
CREATE TABLE IF NOT EXISTS `Skill` (
  `idSkill` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`idSkill`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `name_2` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `Skill`
--

INSERT INTO `Skill` (`idSkill`, `name`) VALUES
(1, 'Skill 1'),
(2, 'Skill 2'),
(3, 'Skill 3'),
(4, 'Skill 4'),
(5, 'skill 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tag`
--

DROP TABLE IF EXISTS `Tag`;
CREATE TABLE IF NOT EXISTS `Tag` (
  `idTag` int(11) NOT NULL AUTO_INCREMENT,
  `idGame` int(11) NOT NULL,
  `tag` varchar(255) NOT NULL,
  PRIMARY KEY (`idTag`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `Tag`
--

INSERT INTO `Tag` (`idTag`, `idGame`, `tag`) VALUES
(3, 180, 'physic'),
(5, 181, 'terror'),
(6, 144, 'terror');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `User`
--

DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `secret` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`idUser`, `login`, `password`, `secret`) VALUES
(1, 'admin', '', 'USER.bb8339b9f14d259f758475097cc81b371c65185f'),
(2, 'dani', '', 'USER.5c74f0402898226114038ed8209d481afd8a8f26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserAbility`
--

DROP TABLE IF EXISTS `UserAbility`;
CREATE TABLE IF NOT EXISTS `UserAbility` (
  `idUserAbility` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idAbility` int(11) NOT NULL,
  `levelAbility` tinyint(4) NOT NULL,
  PRIMARY KEY (`idUserAbility`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `UserAbility`
--

INSERT INTO `UserAbility` (`idUserAbility`, `idUser`, `idAbility`, `levelAbility`) VALUES
(1, 1, 1, 4),
(2, 1, 2, 3),
(3, 1, 3, 3),
(4, 1, 4, 2),
(5, 1, 5, 3),
(6, 2, 1, 3),
(7, 2, 2, 3),
(8, 2, 5, 4),
(9, 3, 1, 4),
(10, 5, 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserAward`
--

DROP TABLE IF EXISTS `UserAward`;
CREATE TABLE IF NOT EXISTS `UserAward` (
  `idUser` int(11) NOT NULL,
  `idAward` int(11) NOT NULL,
  `levelAward` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idUser`,`idAward`),
  KEY `User` (`idUser`),
  KEY `Award` (`idAward`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `UserAward`
--

INSERT INTO `UserAward` (`idUser`, `idAward`, `levelAward`) VALUES
(1, 2, 2),
(1, 5, 3),
(1, 16, 3),
(1, 20, 3),
(1, 21, 3),
(1, 23, 4),
(1, 26, 3),
(1, 35, 2),
(2, 9, 4),
(2, 22, 3),
(2, 26, 3),
(2, 30, 3),
(2, 44, 3),
(3, 12, 3),
(3, 14, 3),
(3, 22, 3),
(3, 46, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserBadge`
--

DROP TABLE IF EXISTS `UserBadge`;
CREATE TABLE IF NOT EXISTS `UserBadge` (
  `idUserBadge` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idBadge` int(11) NOT NULL,
  `dateAchiev` date NOT NULL,
  PRIMARY KEY (`idUserBadge`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `UserBadge`
--

INSERT INTO `UserBadge` (`idUserBadge`, `idUser`, `idBadge`, `dateAchiev`) VALUES
(1, 1, 1, '2013-09-08'),
(2, 1, 2, '2013-09-10'),
(3, 1, 3, '2013-07-20'),
(4, 1, 4, '2013-08-28'),
(5, 1, 5, '2013-08-28'),
(6, 5, 1, '2013-07-01'),
(7, 5, 2, '2013-07-15'),
(8, 2, 3, '2013-08-25'),
(9, 3, 1, '2013-07-20'),
(10, 3, 3, '2013-07-24'),
(11, 3, 4, '2013-08-14'),
(12, 3, 5, '2013-08-28'),
(13, 4, 5, '2013-07-29'),
(14, 5, 1, '2015-04-08'),
(15, 5, 3, '2015-04-08'),
(16, 5, 1, '2015-04-08'),
(17, 5, 3, '2015-04-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserGameInstance`
--

DROP TABLE IF EXISTS `UserGameInstance`;
CREATE TABLE IF NOT EXISTS `UserGameInstance` (
  `idUser` int(11) NOT NULL,
  `idGameInstance` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idGameInstance`),
  KEY `UserGameInstance_User` (`idUser`),
  KEY `UserGameInstance_GameInstance` (`idGameInstance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserGroup`
--

DROP TABLE IF EXISTS `UserGroup`;
CREATE TABLE IF NOT EXISTS `UserGroup` (
  `idUser` int(11) NOT NULL,
  `idGroup` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idGroup`),
  KEY `UserGroup_User` (`idUser`),
  KEY `UserGroup_Group` (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `UserRealm`
--

DROP TABLE IF EXISTS `UserRealm`;
CREATE TABLE IF NOT EXISTS `UserRealm` (
  `idUser` int(11) NOT NULL,
  `idRealm` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idRealm`),
  KEY `UserRealm_User` (`idUser`),
  KEY `UserRealm_Realm` (`idRealm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura para la vista `GameSimilitudeView`
--

DROP VIEW IF EXISTS `GameSimilitudeView`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `GameSimilitudeView` AS select 
`tag1`.`idGame` AS `idGame`,
`tag2`.`idGame` AS `similarToIdGame`,
`tag1`.`tag` AS `similitude` 
from
	(`Tag` `tag1` join `Tag` `tag2` on(((`tag1`.`tag` = `tag2`.`tag`) and (`tag1`.`idGame` <> `tag2`.`idGame`)))) union select 
		`game1`.`idGame` AS `idGame`,
		`game2`.`idGame` AS `similarToIdGame`,
		`Category`.`name` AS `similitude` 
		from 
			((`Game` `game1` join `Game` `game2` 
				on(((`game1`.`idCategory` = `game2`.`idCategory`) 
					and (`game1`.`idGame` <> `game2`.`idGame`)))) 
			join `Category` on((`game1`.`idCategory` = `Category`.`idCategory`))) 
		order by `idGame`,`similarToIdGame`;

-- --------------------------------------------------------

--
-- Estructura para la vista `GameView`
--

DROP VIEW IF EXISTS `GameView`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `GameView` AS select
`Game`.`idGame` AS `idGame`,
`Game`.`name` AS `name`,
`Game`.`grantPublicAccess` AS `grantPublicAccess`,
`Game`.`secretGame` AS `secretGame`,
`Game`.`privateKey` AS `privateKey`,
`Game`.`idCategory` AS `idCategory`,
`Game`.`creationDate` AS `creationDate`,
(select count(`Comment`.`idComment`) from `Comment` where (`Comment`.`idGame` = `Game`.`idGame`)) AS `timesCommented`,
(select count(`GameLike`.`likeId`) from `GameLike` where (`GameLike`.`gameId` = `Game`.`idGame`)) AS `popularity`,
(select count(`GameScore`.`idScore`) from `GameScore` where (`GameScore`.`idGame` = `Game`.`idGame`)) AS `timesPlayed`,
(select count(`GameInstance`.`idGameInstance`) from `GameInstance` where ((`GameInstance`.`idGame` = `Game`.`idGame`) and (`GameInstance`.`state` = 'INIT'))) AS `activity` from `Game`;

-- --------------------------------------------------------

--
-- Estructura para la vista `TotalGameSimilitudeView`
--

DROP VIEW IF EXISTS `TotalGameSimilitudeView`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `TotalGameSimilitudeView` AS select 
`GameSimilitudeView`.`idGame` AS `idGame`,
`GameSimilitudeView`.`similarToIdGame` AS `similarToIdGame`,
count(0) AS `totalSimilitude`
from `GameSimilitudeView` group by `GameSimilitudeView`.`idGame`,`GameSimilitudeView`.`similarToIdGame`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

/*
SQLyog Ultimate v9.02 
MySQL - 8.0.18 : Database - integradordb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`integradordb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `integradordb`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `alu_dni` int(10) unsigned NOT NULL,
  `alu_nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `alu_apellido` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `alu_fec_nac` date NOT NULL,
  `alu_domicilio` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `alu_telefono` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `alu_insc_cod` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`alu_dni`),
  KEY `FK_alumno` (`alu_insc_cod`),
  CONSTRAINT `FK_alumno` FOREIGN KEY (`alu_insc_cod`) REFERENCES `inscripcion` (`insc_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `alumno` */

insert  into `alumno`(`alu_dni`,`alu_nombre`,`alu_apellido`,`alu_fec_nac`,`alu_domicilio`,`alu_telefono`,`alu_insc_cod`) values (34567876,'Ramiro','Gonzalez','1996-09-13','Lujan','2615457345',NULL),(34987564,'Leandro','Mercado','1996-06-21','Corralito','261676676',NULL),(39237216,'Gabriel Maximiliano','Bermudez','1995-10-06','Niñas de Ayohuma 1395','2614269628',NULL);

/*Table structure for table `carrera` */

DROP TABLE IF EXISTS `carrera`;

CREATE TABLE `carrera` (
  `car_cod` int(10) unsigned NOT NULL,
  `car_nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `car_duracion` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`car_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `carrera` */

insert  into `carrera`(`car_cod`,`car_nombre`,`car_duracion`) values (230,'Quimica','3'),(320,'Sistemas','5');

/*Table structure for table `cursado` */

DROP TABLE IF EXISTS `cursado`;

CREATE TABLE `cursado` (
  `cur_alu_dni` int(10) unsigned NOT NULL,
  `cur_mat_cod` int(10) unsigned NOT NULL,
  `cur_nota` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cur_alu_dni`,`cur_mat_cod`),
  KEY `FK_cursado` (`cur_mat_cod`),
  CONSTRAINT `FK_cursado` FOREIGN KEY (`cur_mat_cod`) REFERENCES `materia` (`mat_cod`),
  CONSTRAINT `FK_cursadoAlu` FOREIGN KEY (`cur_alu_dni`) REFERENCES `alumno` (`alu_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `cursado` */

insert  into `cursado`(`cur_alu_dni`,`cur_mat_cod`,`cur_nota`) values (34567876,230,6),(34567876,430,8),(34567876,490,0),(34987564,230,10),(34987564,490,7),(39237216,230,10),(39237216,430,8),(39237216,490,10);

/*Table structure for table `inscripcion` */

DROP TABLE IF EXISTS `inscripcion`;

CREATE TABLE `inscripcion` (
  `insc_cod` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `insc_nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `insc_fecha` date NOT NULL,
  `insc_car_cod` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`insc_cod`),
  KEY `FK_inscripcion` (`insc_car_cod`),
  CONSTRAINT `FK_inscripcion` FOREIGN KEY (`insc_car_cod`) REFERENCES `carrera` (`car_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `inscripcion` */

insert  into `inscripcion`(`insc_cod`,`insc_nombre`,`insc_fecha`,`insc_car_cod`) values (5,'34567876','2020-06-01',230);

/*Table structure for table `materia` */

DROP TABLE IF EXISTS `materia`;

CREATE TABLE `materia` (
  `mat_cod` int(10) unsigned NOT NULL,
  `mat_nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `mat_prof_dni` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`mat_cod`),
  KEY `FK_materia` (`mat_prof_dni`),
  CONSTRAINT `FK_materia` FOREIGN KEY (`mat_prof_dni`) REFERENCES `profesor` (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `materia` */

insert  into `materia`(`mat_cod`,`mat_nombre`,`mat_prof_dni`) values (230,'Laboratorio II',23456734),(430,'Estadistica',22876678),(490,'Programacion',22876453);

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `prof_dni` int(10) unsigned NOT NULL,
  `prof_nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `prof_apellido` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `prof_fec_nac` date NOT NULL,
  `prof_domicilio` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `prof_telefono` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `profesor` */

insert  into `profesor`(`prof_dni`,`prof_nombre`,`prof_apellido`,`prof_fec_nac`,`prof_domicilio`,`prof_telefono`) values (22876453,'Martin Ezequiel','Vargas','1985-07-20','Desconocido','2615647834'),(22876678,'Maria','Esposito','1985-07-20','Desconocido','2615647834'),(23456734,'Julio','Monetti','1960-06-24','Desconocido','2615673456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

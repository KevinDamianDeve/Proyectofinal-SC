/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.31-MariaDB : Database - siscolegio_v2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`siscolegio_v2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `siscolegio_v2`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `dni` char(8) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `nombre` varchar(90) DEFAULT NULL,
  `apellidos` varchar(90) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `procedencia` varchar(100) DEFAULT NULL COMMENT '	\\nInstitución educativa de donde proviene el estudiante.',
  `alergia` varchar(100) DEFAULT NULL COMMENT 'Almacena si el alumno es alérgico a algún medicamento o no.',
  `limitaciones` varchar(500) DEFAULT NULL COMMENT 'limitaciones fisicas del alumno',
  `usuario` varchar(30) DEFAULT NULL,
  `contraseña` varchar(50) DEFAULT NULL,
  `idApoderado` int(11) NOT NULL,
  `idGrado` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT 'NO MATRICULADO',
  `diaRegistro` date DEFAULT NULL,
  PRIMARY KEY (`idAlumno`),
  UNIQUE KEY `dni` (`dni`),
  KEY `fk_Alumno_Apoderado_idx` (`idApoderado`),
  KEY `fk_Alumno_Grado1_idx` (`idGrado`),
  CONSTRAINT `fk_Alumno_Apoderado` FOREIGN KEY (`idApoderado`) REFERENCES `apoderado` (`idApoderado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_Grado1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`idGrado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `alumno` */

insert  into `alumno`(`idAlumno`,`dni`,`foto`,`nombre`,`apellidos`,`fechanacimiento`,`direccion`,`celular`,`email`,`sexo`,`procedencia`,`alergia`,`limitaciones`,`usuario`,`contraseña`,`idApoderado`,`idGrado`,`estado`,`diaRegistro`) values (1,'49635320','','MARIA iSABER','Salazar Zubiga','2017-06-15','Piura','987654565','kevindamian3011@gmail.com','Femenino','San Juan Bautista','NINGUNA','persona normal','mari123','123456',1,7,'MATRICULADO','2019-12-04'),(2,'61137034','','Claribel','Sandoval Cabrera','2017-06-15','Piura','987878765','','Femenino','Premiun','NINGUNA','persona normal','claribel123','123456',2,7,'MATRICULADO','2019-12-11'),(3,'64021447','','Claudia','Camizan Lopez','2017-06-15','Piura','','','Femenino','Premiun','NINGUNA','persona normal','claudia123','12334',3,1,'MATRICULADO','2019-12-11'),(4,'14125615','','Monica','More Alburjar','2017-06-15','Piura','','','Femenino','Premiun','NINGUNA','persona normal','monica123','123456',4,1,'MATRICULADO','2019-12-06'),(5,'38062321',NULL,'Alejadra','Campoverde Campoverde','2017-06-15','Piura','','','Femenino','Premiun','NINGUNA','persona normal','Alejandra17','123456',5,1,'MATRICULADO','2019-12-06'),(6,'24660171',NULL,'Abel','Lopez Lopez','2017-06-15','Piura','','','Masculino','Premiun','NINGUNA','persona normal','AbelLopez','123456',6,2,'MATRICULADO','2019-12-06'),(7,'28363345',NULL,'Anthony','Camacho Camacho','2017-06-15','Piura','','antony@gmail.com','MASCULINO','Premiun','NINGUNA','persona normal','Antony1234','123456',7,2,'MATRICULADO','2019-12-06'),(8,'95325351',NULL,'Reynaldo','Arriaga','2017-06-15','Piura','','reynaldo@gmail.com','Masculino','San Juan Bautista','NINGUNA','persona normal','reinaldo1234','123456',8,2,'MATRICULADO','2019-12-06'),(9,'59626773',NULL,'Yuri','Zurita Campoverde','2017-06-15','Piura','','','Femenino','San Juan Bautista','NINGUNA','persona normal','yuri1234','123456',9,2,'MATRICULADO','2019-12-01'),(12,'54022939',NULL,'Juby','Lobato Mondragon','2017-06-15','Piura','','','Femenino','San Juan Bautista','NINGUNA','persona normal','juby','123456',11,4,'MATRICULADO','2019-12-01'),(13,'69747516',NULL,'Sami','Llatas Merino','2017-06-15','Piura','','','Femenino','Premiun','NINGUNA','persona normal','sami1234','12345',12,4,'MATRICULADO','2019-12-01'),(14,'23832993',NULL,'Ana Cristina','Ruiz Robledo','2017-06-15','Piura','','','Femenino','San Juan Bautista','NINGUNA','persona normal','ana123','123456',13,4,'MATRICULADO','2019-12-01'),(15,'79699985',NULL,'Selene','Sandoval ruiz','2017-06-15','Piura','','','Femenino','Premiun','NINGUNA','persona normal','selene1234','123456',14,4,'MATRICULADO','2019-12-01'),(17,'12345678',NULL,'DEYSI','MAZA','2019-10-03','PIURA','989888767','DEYSI@GMAIL.COM','FEMENINO','SAN JUAN BAUTISTA','NINGUNA','persona normal','DEYSI123','12345',15,3,'MATRICULADO','2019-12-01'),(19,'77876565','','DANIEL','TORRES','2009-12-12','piura','998787656','daniel@gmail.com','Masculino','SAN JUAN BAUTISTA','ninguna','persona normal','daniel123','12345',61,7,'MATRICULADO','2019-12-11'),(20,'12432345','','isael','maza','1999-12-12','PIURA','','isael@gmail.com','MASCULINO','SAN JUAN BAUTISTA','NINGUNA','persona normal','isael1234','12345',62,2,'MATRICULADO','2019-12-11'),(21,'90126612','','JOSE SANTOS','MORALES','2014-12-12','PIURA','','MORALES@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NINGUNA','persona normal','MORALES123','1234567',1,7,'MATRICULADO','2019-12-11'),(22,'77878767','','ANTONY','INGA','2019-12-03','piura','98989898','ANTONY@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NUNGUNA','persona normal','antony32','daniel12345',2,4,'MATRICULADO','2019-12-11'),(23,'87878787','','Antonio','alvarez','2019-11-26','PIURA','928238964','ANTONY@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','ninguna','persona normal','antonio443','1234567',3,1,'MATRICULADO','2019-12-11'),(24,'12667665','Fotos/Alumnos/2.jpg','julio','INGA','2019-12-04','piura','988887709','MILI@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NINGUNA','persona normal','CRISTIAN1234','1234567',4,1,'MATRICULADO','2019-12-11'),(28,'43434567','','JULIO','MAZA','2019-12-05','PIURA','456789098','KEVINDAMIAN3011@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NINGUNA','persona normal','danielfano1234','123',5,2,'MATRICULADO','2019-12-20'),(29,'98989896','','ANDRES','SUARES','2019-12-17','PIURA CASTILLA','12345678','KEVINDAMIAN3011@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NINGUNA','persona normal','jairerazo','esta',6,1,'MATRICULADO','2019-12-20'),(31,'94500989','','MAURICIO','BAYONS','2011-05-21','PIURA','12345678','KEVINDAMIAN3011@GMAIL.COM','Masculino','SAN JUAN BAUTISTA','NINGUNA','persona normal','jairerazo','123456',7,2,'MATRICULADO','2019-12-20'),(32,'98980012','','Milagros ','Ramos','1999-08-22','piura','98876765','mili@GMAIL.COM','Femenino','SAN JUAN BAUTISTA','NINGUNA','persona normal','98980012','123456',8,8,'MATRICULADO','2020-01-07'),(33,'10293847','Fotos/Alumnos/f17.jpg','jose','castameda','2000-06-21','PIURA','987876565','jose@gmail.com','Masculino','I. e. san juan','NINGUNA','persona normal','jose1234','123456',64,10,'MATRICULADO','2020-01-10'),(34,'83486209','','SARA','VARGAS','2000-08-21','PIURA','989876545','SARA@GMAIL.COM','Femenino','I. e. san juan','ninguna','persona normal','sara123','123456',64,11,'MATRICULADO','2020-01-10'),(35,'98752343','','DANIEL ','inga','2000-04-12','PIURA','987876566','fano@gmail.com','Masculino','I. e. san juan','ninguna','persona normal','daniel1234','123456',6,12,'MATRICULADO','2020-01-10'),(36,'65738654','','Ana','Chavez','2000-07-12','piura','988888887','ana@gmail.com','Femenino','I. e. san juan','ninguna','persona normal','ana123','123456',13,13,'MATRICULADO','2020-01-10');

/*Table structure for table `apoderado` */

DROP TABLE IF EXISTS `apoderado`;

CREATE TABLE `apoderado` (
  `idApoderado` int(11) NOT NULL AUTO_INCREMENT,
  `dni` char(8) DEFAULT NULL,
  `foto` varchar(50) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(90) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `usuario` varchar(60) DEFAULT NULL,
  `clave` varchar(40) DEFAULT NULL,
  `estado` varchar(45) DEFAULT 'Activo',
  `diaRegistar` date DEFAULT NULL,
  `parentesco` varchar(50) DEFAULT NULL,
  `nivelacademico` varchar(50) DEFAULT NULL,
  `oficio` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idApoderado`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `apoderado` */

insert  into `apoderado`(`idApoderado`,`dni`,`foto`,`nombre`,`apellidos`,`genero`,`fechanacimiento`,`email`,`celular`,`direccion`,`usuario`,`clave`,`estado`,`diaRegistar`,`parentesco`,`nivelacademico`,`oficio`) values (1,'45789856','Fotos/Apoderados/9.jpg','MARIA','Sin Fuentes','FEMENINO','1998-12-05','kevindamian3011@gmail.com','765654444','Castilla','maria123','123456','Activo','2019-12-04','Madre','SECUNDARIA','COMERCIANTE'),(2,'82875772',NULL,'Pancho','Sandoval Zurita','Masculino','2017-06-15','panchi@gmai.com','196936131','PIURA','pancho231','1234','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(3,'66873693',NULL,'Jaime','Cobeñas More','Masculino','2017-06-15','jaime@gmail.com','559541994','PIURA','jaime123','123456','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(4,'23753838',NULL,'Santiago','More More','Masculino','2017-06-15','santiago@gmail.com','604772657','PIURA','santi321','123456','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(5,'25430825',NULL,'Emilio','Campoverde Llatas','Masculino','2017-06-15','emilio@gmail.com','376931756','PIURA','emilio321','123456','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(6,'94227457',NULL,'Edson','Lopez Lobato','Masculino','2017-06-15','edson@gmail.com','963034725','PIURA','edson321','123456','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(7,'25340459',NULL,'Ernesto','Camacho Camacho','Masculino','2017-06-15','ernesto@gmail.com','951413470','PIURA','ernesto321','12345678','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(8,'34223133',NULL,'Carolina','Arriaga Chira','Femenino','2017-06-15','caro@gmail.com','717691929','PIURA','carolina123','123456','Activo','2019-12-04','MADRE','SECUNDARIA','COMERCIANTE'),(9,'52487301',NULL,'Nilda','Campoverde Abad','Femenino','2017-06-15','nilda@gmai.com','308288135','PIURA','nilda123','123456','Activo','2019-12-04','MADRE','SECUNDARIA','COMERCIANTE'),(11,'56944288',NULL,'Mirian','Mondragon Diez','Femenino','2017-06-15','miriam@gmail.com','647769215','PIURA','miriam123','1234','Activo','2019-12-04','MADRE','SECUNDARIA','COMERCIANTE'),(12,'54784828',NULL,'Kiara','Merino Calle','Femenino','2017-06-15','kiara@gmail.com','868584522','PIURA','kiara123','123456','Activo','2019-12-04','MADRE','SECUNDARIA','COMERCIANTE'),(13,'90819381',NULL,'Monika','Robledo Latssahuanga','Femenino','2017-06-15','monica@gmail.com','204782714','PIURA','monica321','123456','Activo','2019-12-04','MADRE','SECUNDARIA','COMERCIANTE'),(14,'79154544',NULL,'Eliseo','Sandoval Ruiz','Masculino','2017-06-15','eliseo@gmail.com','415492537','PIURA','eliseo321','12345','Activo','2019-12-04','PADRE','SECUNDARIA','COMERCIANTE'),(15,'22710310','','Brittany','Ubillus Dias','Femenino','2017-06-15','britany@gmail.com','459062988','PIURA','bri1234','123456','Activo','2019-12-04','Madre','SECUNDARIA','COMERCIANTE'),(61,'09123232',NULL,'Sintiaasas','Sin Fuentes','Femenino','1999-07-12','sintia@hmail.com','989999898','Castilla','sintia1234','123456','Activo','2019-12-09','MADRE','SECUNDARIA','COMERCIANTE'),(62,'12667665','Fotos/Apoderados/1.jpg','SAMIR','BAYONA','Masculino','1998-05-13','SAMIR@GMAIL.COM','909889098','PIURA','SAMIR123','123456','Activo','2019-12-11','PADRE','SECUNDARIA','CHOFER'),(63,'84456666',NULL,'MARTA','GONZALES','FEMENINO','1988-08-08','marta@gmail.com','999898765','piura','MARTA123','123456','Activo','2020-01-08','MADRE','SECUNDARIA','AMA DE CASA'),(64,'65738291','','MARIO ','CASTAMENDA','Masculino','1987-05-12','mario@gmail.com','989876543','piura','mario123','123456','Activo','2020-01-10','PADRE','SECUNDARIA','CHOFER');

/*Table structure for table `asistencia` */

DROP TABLE IF EXISTS `asistencia`;

CREATE TABLE `asistencia` (
  `idAsistencia` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `idAlumno` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `idGrado` int(11) NOT NULL,
  PRIMARY KEY (`idAsistencia`),
  KEY `fk_Asistencia_alumno1_idx` (`idAlumno`),
  KEY `fk_Asistencia_curso1_idx` (`idCurso`),
  KEY `fk_Asistencia_grado1_idx` (`idGrado`),
  CONSTRAINT `fk_Asistencia_alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asistencia_curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asistencia_grado1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`idGrado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `asistencia` */

insert  into `asistencia`(`idAsistencia`,`fecha`,`idAlumno`,`idCurso`,`descripcion`,`idGrado`) values (1,'2019-12-23 18:54:16',3,1,'ASISTIO',1);

/*Table structure for table `cargo` */

DROP TABLE IF EXISTS `cargo`;

CREATE TABLE `cargo` (
  `idcargo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cargo` */

insert  into `cargo`(`idcargo`,`descripcion`,`estado`) values (1,'Administrador','Activo'),(2,'Secretaria','Activo'),(4,'Director','Activo');

/*Table structure for table `curso` */

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecurso` varchar(80) DEFAULT NULL,
  `estado` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `curso` */

insert  into `curso`(`idCurso`,`nombrecurso`,`estado`) values (1,'Matematicas 1','ACTIVO'),(2,'Comunicacion 1','ACTIVO'),(3,'Idioma 1','ACTIVO'),(4,'Historias 1','ACTIVO'),(5,'GEOGRAFIAS 1','ACTIVO'),(7,'CTA 2','ACTIVO'),(8,'AMBIENTE 2','ACTIVO'),(9,'ED. FISICA 2','ACTIVO'),(10,'RELIGION 2','ACTIVO'),(11,'ARTE 2','ACTIVO'),(12,'MATEMATICA 3','ACTIVO'),(13,'COMUNICACION 3','ACTIVO'),(14,'HISTORIA 3','ACTIVO'),(15,'CTA 3','ACTIVO'),(16,'PERSONAL SOCIAL 3','ACTIVO'),(17,'COMUNICACION 4','ACTIVO'),(18,'MATEMATICA 4','ACTIVO'),(19,'HISTORIA 4 ','ACTIVO'),(20,'CTA 4','ACTIVO'),(21,'PERSONAL SOCIAL 4','ACTIVO'),(22,'MATEMATICA 5','ACTIVO'),(23,'COMUNICACION 5','ACTIVO'),(24,'GEOGRAFIA 5','ACTIVO'),(25,'CTA 5 ','ACTIVO'),(26,'FISICA 5','ACTIVO');

/*Table structure for table `curso_docente` */

DROP TABLE IF EXISTS `curso_docente`;

CREATE TABLE `curso_docente` (
  `idcursodocente` int(11) NOT NULL AUTO_INCREMENT,
  `idGrado` int(11) DEFAULT NULL,
  `idCurso` int(11) DEFAULT NULL,
  `idDocente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcursodocente`),
  KEY `fk_Curso_has_Docente_Docente1_idx` (`idDocente`),
  KEY `fk_Curso_has_Docente_Curso1_idx` (`idCurso`),
  KEY `idGrado` (`idGrado`),
  CONSTRAINT `curso_docente_ibfk_1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`idGrado`),
  CONSTRAINT `fk_Curso_has_Docente_Curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Curso_has_Docente_Docente1` FOREIGN KEY (`idDocente`) REFERENCES `docente` (`idDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `curso_docente` */

insert  into `curso_docente`(`idcursodocente`,`idGrado`,`idCurso`,`idDocente`) values (1,1,1,1),(2,1,2,2),(3,1,3,3),(4,1,4,4),(5,1,5,5),(6,2,1,7),(7,2,2,8),(8,2,3,9),(10,2,4,1),(12,2,5,2),(13,3,7,9),(14,3,8,7),(15,3,9,3),(16,3,10,4),(17,3,11,1),(18,4,7,2),(19,4,8,3),(20,4,9,5),(23,4,10,7),(24,4,11,8),(26,7,12,1),(27,7,13,2),(28,7,14,3),(29,7,15,4),(30,7,16,5),(32,8,12,7),(33,8,13,8),(34,8,14,9),(35,8,15,10),(36,8,16,1),(37,10,17,2),(38,10,18,3),(39,10,19,4),(40,10,20,5),(41,10,21,7),(42,11,17,8),(43,11,18,9),(44,11,19,10),(45,11,20,1),(46,11,21,2),(47,12,22,3),(48,12,23,4),(49,12,24,5),(50,12,25,7),(51,12,26,8),(52,13,22,9),(53,13,23,10),(54,13,24,1),(55,13,25,2),(56,13,26,3);

/*Table structure for table `docente` */

DROP TABLE IF EXISTS `docente`;

CREATE TABLE `docente` (
  `idDocente` int(11) NOT NULL AUTO_INCREMENT,
  `foto` varchar(100) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(90) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono_fijo` varchar(15) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT 'Activo',
  `diaRegistro` date DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contraseña` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDocente`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `docente` */

insert  into `docente`(`idDocente`,`foto`,`dni`,`nombres`,`apellidos`,`direccion`,`telefono_fijo`,`celular`,`fechanacimiento`,`correo`,`titulo`,`estado`,`diaRegistro`,`usuario`,`contraseña`) values (1,'Fotos/Docente/f28.jpg','89291496','Carlos','Anastasio Salas','Castilla','76789098765','786414394','2017-06-15','kevindamian3011@gmail.com','profesor de redes','Activo','2019-12-04','lucas123','123456'),(2,NULL,'26115697','Monica','Quiroz Rios','Castilla','475274','834513997','2017-06-15','monigmail.com','PROFESORA','Activo','2019-12-04','monica321','123456'),(3,NULL,'83059748','Ivan','More Lopez','Castilla','425447','807326373','2017-06-15','ivangmail.com','PROFESOR','Activo','2019-12-04','ivan321','123456'),(4,NULL,'43691830','Jair','Liviapoma Huaman','Castilla','784531','688844986','2017-06-15','jair@gmail.com','PROFESOR','Activo','2019-12-04','jair3234','123456'),(5,'Fotos/Docente/f10.jpg','72710634','Jordy','Guzman Salazar','Castilla','789564','515690537','2017-06-15','jordy@gmail.com','PROFESOR','Activo','2019-12-04','jordy321','123456'),(7,NULL,'98989823','SAMUEL','MAZA','CASTILLA','98678765','989876543','2000-12-12','samuel@gmail.com','PROFESOR','Activo','2019-12-12','samuel432','123456'),(8,NULL,'91121222','MARIELA ','FERNZANDES','PIURA','98765434','987656543','2001-12-12','mariela@gmail.com','PROFESORA','Activo','2019-12-12','mariela123','123456'),(9,NULL,'90003232','MARIA ','VELA','PIURA','98776532','987000987','1999-12-12','maria@gmail.com','PROFESORA','Activo','2019-12-12','mariav123','123456'),(10,NULL,'09066666','SAIRA ','MAZA','PIURA','76543234','945959678','2000-05-12','saira@gmail.com','profesional','Activo','2020-01-07','saira123','123456');

/*Table structure for table `grado` */

DROP TABLE IF EXISTS `grado`;

CREATE TABLE `grado` (
  `idGrado` int(11) NOT NULL AUTO_INCREMENT,
  `gradoseccion` varchar(90) DEFAULT NULL,
  `maxalumnos` int(11) DEFAULT NULL COMMENT '	\\nNúmero máximo de alumnos que se pueden recibir en este grado.\\n',
  `total` int(11) DEFAULT '0',
  PRIMARY KEY (`idGrado`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `grado` */

insert  into `grado`(`idGrado`,`gradoseccion`,`maxalumnos`,`total`) values (1,'PRIMERO A',50,6),(2,'PRIMERO B',55,7),(3,'SEGUNDO A',22,1),(4,'SEGUNDO B',22,5),(7,'TERCERO A',50,4),(8,'TERCERO B',40,1),(10,'CUARTO A',20,1),(11,'CUARTO B',40,1),(12,'QUINTO A',40,1),(13,'QUINTO B',50,1);

/*Table structure for table `matricula` */

DROP TABLE IF EXISTS `matricula`;

CREATE TABLE `matricula` (
  `idMatricula` int(11) NOT NULL AUTO_INCREMENT,
  `fechamatricula` date DEFAULT NULL,
  `idpago` int(11) NOT NULL,
  `idPeriodo` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idMatricula`),
  KEY `fk_Matricula_pago1_idx` (`idpago`),
  KEY `fk_matricula_Periodo1_idx` (`idPeriodo`),
  KEY `fk_matricula_usuario1_idx` (`idusuario`),
  CONSTRAINT `fk_Matricula_pago1` FOREIGN KEY (`idpago`) REFERENCES `pago` (`idpago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_Periodo1` FOREIGN KEY (`idPeriodo`) REFERENCES `periodo` (`idPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_matricula_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `matricula` */

insert  into `matricula`(`idMatricula`,`fechamatricula`,`idpago`,`idPeriodo`,`idusuario`) values (1,'2019-12-04',1,1,1),(2,'2019-12-04',2,1,1),(3,'2019-12-04',3,1,1),(4,'2019-12-04',4,1,1),(5,'2019-12-04',5,1,1),(6,'2019-12-04',6,1,1),(7,'2019-12-04',7,1,1),(8,'2019-12-04',8,1,1),(9,'2019-12-04',9,1,1),(10,'2019-12-04',10,1,1),(11,'2019-12-04',11,1,1),(12,'2019-12-08',12,1,1),(13,'2019-12-08',10,1,1),(14,'2019-12-11',14,1,1),(15,'2019-12-11',17,1,1),(16,'2019-12-11',14,1,1),(17,'2019-12-11',18,1,1),(18,'2020-01-07',19,1,1),(19,'2020-01-07',20,1,3),(20,'2020-01-10',21,1,3),(21,'2020-01-10',15,1,3),(22,'2020-01-10',16,1,3),(23,'2020-01-10',17,1,3),(24,'2020-01-10',22,1,3),(25,'2020-01-10',23,1,3),(26,'2020-01-10',24,1,3),(27,'2020-01-10',25,1,3),(28,'2020-01-10',26,1,3);

/*Table structure for table `pago` */

DROP TABLE IF EXISTS `pago`;

CREATE TABLE `pago` (
  `idpago` int(11) NOT NULL AUTO_INCREMENT,
  `fechapago` date DEFAULT NULL,
  `idAlumno` int(11) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `estado` varchar(25) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idpago`),
  KEY `fk_pago_Alumno1_idx` (`idAlumno`),
  CONSTRAINT `fk_pago_Alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `pago` */

insert  into `pago`(`idpago`,`fechapago`,`idAlumno`,`monto`,`estado`) values (1,'2019-12-04',1,50.00,'Activo'),(2,'2019-12-04',2,50.00,'Activo'),(3,'2019-12-04',3,50.00,'Activo'),(4,'2019-12-04',6,50.00,'Activo'),(5,'2019-12-04',7,50.00,'Activo'),(6,'2019-12-04',8,50.00,'Activo'),(7,'2019-12-04',9,50.00,'Activo'),(8,'2019-12-04',12,50.00,'Activo'),(9,'2019-12-04',13,50.00,'Activo'),(10,'2019-12-04',14,50.00,'Activo'),(11,'2019-12-04',15,50.00,'Activo'),(12,'2019-12-08',17,100.00,'Activo'),(13,'2019-12-11',19,50.00,'Activo'),(14,'2019-12-11',20,50.00,'Activo'),(15,'2019-12-11',21,50.00,'Activo'),(16,'2019-12-11',23,50.00,'Activo'),(17,'2019-12-11',22,60.00,'Activo'),(18,'2019-12-11',24,50.00,'Activo'),(19,'2020-01-07',28,10.00,'Activo'),(20,'2020-01-07',32,34.00,'Activo'),(21,'2020-01-10',33,20.00,'Activo'),(22,'2020-01-10',29,20.00,'Activo'),(23,'2020-01-10',31,10.00,'Activo'),(24,'2020-01-10',34,10.00,'Activo'),(25,'2020-01-10',35,10.00,'Activo'),(26,'2020-01-10',36,10.00,'Activo');

/*Table structure for table `periodo` */

DROP TABLE IF EXISTS `periodo`;

CREATE TABLE `periodo` (
  `idPeriodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `periodo` */

insert  into `periodo`(`idPeriodo`,`periodo`,`estado`) values (1,'2020','Activo');

/*Table structure for table `registro` */

DROP TABLE IF EXISTS `registro`;

CREATE TABLE `registro` (
  `idRegistro` int(11) NOT NULL AUTO_INCREMENT,
  `idAlumno` int(11) NOT NULL,
  `idCurso` int(11) NOT NULL,
  `idTri` int(11) NOT NULL,
  `nota` decimal(9,2) DEFAULT NULL,
  `observacion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idRegistro`),
  KEY `fk_Notas_Alumno1_idx` (`idAlumno`),
  KEY `fk_Notas_Curso1_idx` (`idCurso`),
  KEY `fk_Registro_Trimestre1_idx` (`idTri`),
  CONSTRAINT `fk_Notas_Alumno1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Notas_Curso1` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registro_Trimestre1` FOREIGN KEY (`idTri`) REFERENCES `trimestre` (`idTri`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `registro` */

insert  into `registro`(`idRegistro`,`idAlumno`,`idCurso`,`idTri`,`nota`,`observacion`) values (2,1,12,2,14.00,''),(3,1,12,3,12.00,''),(4,1,13,1,14.00,''),(5,1,13,2,14.00,''),(6,1,13,3,14.00,''),(7,1,14,1,15.00,''),(8,1,14,2,16.00,''),(9,1,14,3,12.00,''),(10,1,15,1,11.00,''),(11,1,15,2,9.00,''),(12,1,15,3,17.00,''),(13,1,16,1,19.00,'todo ok'),(15,1,16,2,8.00,'todo ok'),(16,1,16,3,16.00,'todo ok'),(17,3,1,1,20.00,'felicidades'),(18,6,4,1,19.00,'todo ok'),(19,3,1,2,19.00,'ninguna'),(20,32,16,1,19.00,'felicidades'),(21,2,12,1,5.00,'hay que estudiar mas'),(22,2,15,1,19.00,'felicidades'),(23,24,1,1,5.00,'ptracy'),(24,17,11,1,20.00,'felicidades'),(25,1,12,1,14.00,'practique');

/*Table structure for table `reuniones` */

DROP TABLE IF EXISTS `reuniones`;

CREATE TABLE `reuniones` (
  `idreuniones` int(11) NOT NULL AUTO_INCREMENT,
  `idDocente` int(11) NOT NULL,
  `idGrado` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `descripción` longtext,
  `filer` longtext,
  PRIMARY KEY (`idreuniones`),
  KEY `fk_reuniones_docente1_idx` (`idDocente`),
  KEY `fk_reuniones_grado1_idx` (`idGrado`),
  CONSTRAINT `fk_reuniones_docente1` FOREIGN KEY (`idDocente`) REFERENCES `docente` (`idDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reuniones_grado1` FOREIGN KEY (`idGrado`) REFERENCES `grado` (`idGrado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `reuniones` */

insert  into `reuniones`(`idreuniones`,`idDocente`,`idGrado`,`fecha`,`descripción`,`filer`) values (2,1,1,'2020-01-08','el dia 07 de enero fue la reunion','Reuniones/FE Y ALEGRIA.pdf'),(9,10,8,'2020-01-09','HOY FUE LA REUNION Y SE TRATO  LO SIGUIENTE:','Reuniones/FE Y ALEGRIA.pdf');

/*Table structure for table `trimestre` */

DROP TABLE IF EXISTS `trimestre`;

CREATE TABLE `trimestre` (
  `idTri` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTri`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `trimestre` */

insert  into `trimestre`(`idTri`,`descripcion`) values (1,'Primer Trimestre'),(2,'Segundo Trimestre'),(3,'Tercer Trimestre');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `diaingreso` date DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT '123456',
  `estado` varchar(45) DEFAULT NULL,
  `idcargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `idcargo` (`idcargo`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`idusuario`,`dni`,`foto`,`nombre`,`apellidos`,`genero`,`fechanacimiento`,`email`,`telefono`,`celular`,`direccion`,`diaingreso`,`usuario`,`clave`,`estado`,`idcargo`) values (1,'45789856','','Jimena','Sin Fuentes','Femenino','1998-12-05','sintia18@gmail.com','765654444','897845562','Castilla','2019-12-04','Secretaria2019','123456','Activo',2),(3,'77097355','Fotos/Apoderados/f1.jpg','CRISTIAN','INFANTE','Masculino','2000-09-12','kevindamian3011@gmail.com','65654567898','988887709','PIURA','2019-12-11','CRISTIAN1234','123456','ACTIVO',1);

/* Trigger structure for table `alumno` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `sp_grado` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `sp_grado` AFTER INSERT ON `alumno` FOR EACH ROW BEGIN
    declare can int;
    
    
    SELECT COUNT(a.`idAlumno`) into can
FROM alumno a INNER JOIN grado g ON a.`idGrado`=g.`idGrado`
WHERE g.`idgrado`=new.idgrado;
update grado set total = can where idgrado = new.idgrado;
    END */$$


DELIMITER ;

/* Trigger structure for table `alumno` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `sp_actualiza_grado` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `sp_actualiza_grado` AFTER UPDATE ON `alumno` FOR EACH ROW BEGIN
    DECLARE can INT;
    declare cana int;
SELECT COUNT(a.`idAlumno`) INTO cana
FROM alumno a INNER JOIN grado g ON a.`idGrado`=g.`idGrado`
WHERE g.`idgrado`=old.idgrado;
UPDATE grado SET total = cana WHERE idgrado = old.idgrado;
    
SELECT COUNT(a.`idAlumno`) INTO can
FROM alumno a INNER JOIN grado g ON a.`idGrado`=g.`idGrado`
WHERE g.`idgrado`=new.idgrado;
UPDATE grado SET total = can WHERE idgrado = new.idgrado;
    END */$$


DELIMITER ;

/* Trigger structure for table `alumno` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `sp_resta_grado` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `sp_resta_grado` AFTER DELETE ON `alumno` FOR EACH ROW BEGIN
     DECLARE can INT;
    
    
    SELECT COUNT(a.`idAlumno`) INTO can
FROM alumno a INNER JOIN grado g ON a.`idGrado`=g.`idGrado`
WHERE g.`idgrado`=old.idgrado;
UPDATE grado SET total = can WHERE idgrado = old.idgrado;
    END */$$


DELIMITER ;

/* Procedure structure for procedure `sp_alumnos_grado` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_alumnos_grado` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_alumnos_grado`( g int)
BEGIN
    
    
SELECT idalumno, concat(nombre, ' ', apellidos) as alumno, dni FROM alumno WHERE idGrado=g AND estado='MATRICULADO';
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNOS_POR_APODERADO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNOS_POR_APODERADO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNOS_POR_APODERADO`(ida int)
BEGIN
   
SELECT a.idalumno, CONCAT(a.nombre, ' ' , a.apellidos) AS alumno
FROM alumno a INNER JOIN apoderado ap ON a.idapoderado=ap.idapoderado   
   WHERE ap.idapoderado=ida;
   
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNO_ELIMINA`(id int)
BEGIN
    delete from alumno where  idAlumno=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNO_GRADO_DOCENTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNO_GRADO_DOCENTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNO_GRADO_DOCENTE`(gr int, al int, idd int)
BEGIN
    
SELECT  CONCAT(a.nombre,' ', a.apellidos) AS alumno ,c.idcurso, c.nombrecurso
FROM curso_docente cd INNER JOIN grado g ON cd.idgrado=g.idgrado
INNER JOIN docente d ON d.`idDocente`=cd.`idDocente`
INNER JOIN alumno a  ON cd.idgrado=a.idgrado
INNER JOIN curso c ON c.idcurso=cd.idcurso
WHERE  a.idgrado=gr AND a.idalumno=al AND d.`idDocente`=idd;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNO_INGRESA`(dn char(8), fot varchar(50), nom varchar(90), ape varchar(90), fe date, dir varchar(200),
    cel varchar(9), ema varchar(45), sex varchar(45), pro varchar(100), aler varchar(100), limi varchar(500), usu varchar(30),
    contra varchar(50), idapo int, idgr int )
BEGIN
    insert into alumno (dni, foto, nombre, apellidos, fechanacimiento, direccion, celular, email, sexo, procedencia, alergia, limitaciones,
    usuario,contraseña,idApoderado, idGrado, diaRegistro) values ( dn, fot,nom,ape, fe,dir, cel,ema,sex,pro,aler,limi,usu,contra,idapo,idgr, CURDATE() );
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNO_MODIFICA`( id int, dn CHAR(8), fot VARCHAR(50), nom VARCHAR(90), ape VARCHAR(90), fe DATE, dir VARCHAR(200),
    cel VARCHAR(9), ema VARCHAR(45), sex VARCHAR(45), pro VARCHAR(100), aler VARCHAR(100), limi VARCHAR(500), usu VARCHAR(30),
    contra VARCHAR(50), idapo INT, idgr INT , est varchar(45))
BEGIN
    update alumno set dni=dn, foto=fot, nombre=nom, apellidos=ape, fechanacimiento=fe, direccion=dir, celular=cel, email=ema,
    sexo=sex, procedencia=pro, alergia=aler, limitaciones=limi, usuario=usu, contraseña=contra, idApoderado=idapo, idGrado=idgr,
     estado=est where idAlumno=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ALUMNO_SELECCIONA_CURSO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ALUMNO_SELECCIONA_CURSO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ALUMNO_SELECCIONA_CURSO`( ida int)
BEGIN
     SELECT g.gradoseccion, cd.idcurso, c.nombrecurso
  
 FROM curso_docente cd INNER JOIN  grado g ON g.idgrado=cd.idgrado
   INNER JOIN alumno a ON a.idgrado=g.idgrado 
   INNER JOIN curso c ON c.idcurso=cd.idcurso
    WHERE a.idalumno  =ida;
    
   
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_APODERADO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_APODERADO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_APODERADO_ELIMINA`(id INT)
BEGIN
    DELETE FROM apoderado WHERE idapoderado=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_APODERADO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_APODERADO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_APODERADO_INGRESA`( dn CHAR(8), fot VARCHAR(50), nom VARCHAR(40), ape VARCHAR(40), gen VARCHAR(20),
   fnac DATE, ema VARCHAR(45), cel CHAR(20), dire VARCHAR(45), usu VARCHAR(45), cla VARCHAR(45), 
    par VARCHAR(45), nivel varchar(20), ofi varchar(50))
BEGIN
    INSERT INTO apoderado (dni, foto, Nombre, Apellidos, genero, fechanacimiento, email, celular,
    direccion, usuario, clave, diaRegistar, parentesco, nivelacademico, oficio) 
    VALUES (dn, fot, nom,ape,gen, fnac, ema, cel, dire,usu,cla,CURDATE(), par,nivel,ofi);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_APODERADO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_APODERADO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_APODERADO_MODIFICA`(id INT, dn VARCHAR(8), fot VARCHAR(50), nom VARCHAR(40), ape VARCHAR(40),
     gen VARCHAR(20),fnac DATE, ema VARCHAR(45), tel varCHAR(20), dire VARCHAR(45), usu VARCHAR(45), cla VARCHAR(45),est varchar(20),  par VARCHAR(45), niv varchar(30), ofi varchar(30))
BEGIN
    UPDATE apoderado SET dni = dn,
     foto=fot, nombre=nom, Apellidos=ape, genero=gen, fechanacimiento=fnac, email=ema, celular=tel,
    direccion=dire, usuario=usu, clave=cla,  parentesco=par , nivelacademico=niv, estado=est, oficio=ofi
    WHERE idapoderado=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_CARGO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_CARGO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CARGO_ELIMINA`( id int)
BEGIN
    delete from Cargo where idcargo=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_CARGO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_CARGO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CARGO_INGRESA`( des varchar(20), est varchar(20)  )
BEGIN
    insert into cargo (descripcion, estado) values (des, est);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_CARGO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_CARGO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CARGO_MODIFICA`( id int, des varchar(30), est varchar(30))
BEGIN
    update Cargo set descripcion=des, estado=est where idcargo=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_Cursos_del_Docente` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_Cursos_del_Docente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Cursos_del_Docente`(id int )
BEGIN
    SELECT g.idgrado,  g.`gradoseccion`,c.idcurso, c.`nombrecurso`
FROM curso_docente cd INNER JOIN docente d ON cd.`idDocente`=d.`idDocente`
INNER JOIN curso c ON cd.`idCurso`=c.`idCurso`
INNER JOIN grado g ON g.`idGrado`=cd.`idGrado`
WHERE d.`idDocente`= id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DETALLES_GRADO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DETALLES_GRADO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DETALLES_GRADO`( g varchar(20))
BEGIN
    SELECT * FROM `v_curso_docente` WHERE grado=g;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_CURSO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_CURSO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_CURSO_ELIMINA`(idc int)
BEGIN
    delete from curso_docente  where idcursodocente=idc;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_CURSO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_CURSO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_CURSO_INGRESA`(idg int ,idc int, idd int)
BEGIN
    insert into curso_docente ( idGrado,idCurso, idDocente) values (idg,idc, idd);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_DEL_ALUMNO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_DEL_ALUMNO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_DEL_ALUMNO`(ida int)
BEGIN
     SELECT c.nombrecurso, d.iddocente, CONCAT(d.nombres,' ', d.apellidos) AS docente
 FROM curso_docente cd INNER JOIN  grado g ON g.idgrado=cd.idgrado
   INNER JOIN alumno a ON a.idgrado=g.idgrado 
   INNER JOIN curso c ON c.idcurso=cd.idcurso
   INNER JOIN docente d ON d.iddocente=cd.iddocente
    WHERE a.idalumno  =ida;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_ELIMINA`(id int)
BEGIN
    delete from docente where idDocente=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_INGRESA`( fot varchar(100), dn char(8), nom varchar(60), ape varchar(49), dir varchar(50),
    tel varchar(15), celu char(9), fnaci date, co varchar(50), titu varchar(45), usu varchar(45), contra varchar(50))
BEGIN
    insert into docente (foto,dni,nombres, apellidos,direccion,telefono_fijo, celular, fechanacimiento,correo, titulo, diaRegistro, usuario,
     contraseña ) values (fot,dn,nom,ape,dir,tel,celu,fnaci,co ,titu, CURDATE(),usu, contra);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_DOCENTE_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_DOCENTE_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_DOCENTE_MODIFICA`(id int, fot varchar(100), dn CHAR(8), nom VARCHAR(60), ape VARCHAR(49), dir VARCHAR(50),
    tel VARCHAR(15), celu CHAR(9), fnaci DATE, co varchar(50), titu VARCHAR(45), est varchar(45), usu VARCHAR(45), contra VARCHAR(50) )
BEGIN
    update docente set foto=fot, dni=dn, nombres=nom, apellidos=ape, direccion=dir, telefono_fijo=tel,celular=celu, fechanacimiento=fnaci,
    correo=co, titulo=titu, estado=est, usuario=usu, contraseña=contra where idDocente=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_ELIMINA_CURSO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_ELIMINA_CURSO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ELIMINA_CURSO`(id int)
BEGIN
    delete from curso where idCurso=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_GRADO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_GRADO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GRADO_ELIMINA`(id int)
BEGIN
    delete from grado where idGrado=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_GRADO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_GRADO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GRADO_INGRESA`( gr varchar(90), ma int )
BEGIN
    insert into grado (gradoseccion, maxalumnos) values (gr, ma);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_GRADO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_GRADO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GRADO_MODIFICA`( Id INT, gr varchar(90), maxi int )
BEGIN
    update grado set gradoseccion=gr, maxalumnos=maxi where idGrado=Id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_HORARIO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_HORARIO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_HORARIO_ELIMINA`(id int)
BEGIN
    delete from horario2 where idhorario=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_HORARIO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_HORARIO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_HORARIO_INGRESA`(d varchar(30), h varchar(40), idp int, idg int, idc int)
BEGIN
    insert into horario2 (dia, hora, idPeriodo, idgrado, idcurso) values (d,h,dp, idg, idc);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_HORARIO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_HORARIO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_HORARIO_MODIFICA`(id int,d varchar(30), h varchar(40), idp int, idg int, idc int)
BEGIN
    update horario2 set dia=d, hora=h, idPeriodo=idp, idGrado=idg, idCurso=idc where idhorario=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_IDGRADO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_IDGRADO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_IDGRADO`(ida int)
BEGIN
     SELECT g.idgrado, g.gradoseccion
  
 FROM curso_docente cd INNER JOIN  grado g ON g.idgrado=cd.idgrado
   INNER JOIN alumno a ON a.idgrado=g.idgrado 
   INNER JOIN curso c ON c.idcurso=cd.idcurso
    WHERE a.idalumno  =ida;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_INGRESA_CURSO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_INGRESA_CURSO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_INGRESA_CURSO`( nom varchar(45), est varchar(45))
BEGIN
    insert into curso (nombrecurso, estado) values(nom, est);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_ListaApoderados` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_ListaApoderados` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ListaApoderados`()
BEGIN
		SELECT CONCAT(nombre,' ',apellidos)AS Nombres,dni AS DNI,fechanacimiento AS Fecha_Nacimiento,genero AS Genero,celular AS Celular,parentesco AS Parentesco
		FROM apoderado;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTAGRADO` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTAGRADO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAGRADO`()
BEGIN
    SELECT gradoseccion, maxalumnos FROM GRADO ;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTAMATRICULA` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTAMATRICULA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAMATRICULA`()
BEGIN
    SELECT m.`idMatricula`, m.`fechamatricula`, p.`fechapago`, p.`idAlumno`, CONCAT(a.`nombre`,' ',a.`apellidos`) AS alumno, pe.`periodo`, CONCAT( u.`apellidos`,' ', U.`nombre`) AS usuario
FROM matricula m INNER JOIN pago p ON m.`idpago`=p.`idpago`
INNER JOIN alumno a ON p.`idAlumno`=a.`idAlumno` INNER JOIN periodo pe ON pe.`idPeriodo`=m.`idPeriodo`
INNER JOIN usuario u ON u.`idusuario`=m.`idusuario`;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_listanotasprofesor` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_listanotasprofesor` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listanotasprofesor`(idd int , idc int)
BEGIN
   
    
     SELECT
  `r`.`idRegistro`  AS `idRegistro`,
  CONCAT(`a`.`nombre`,' ',`a`.`apellidos`) AS `alumno`,
  g.`gradoseccion` AS grado,
  `c`.`nombrecurso` AS `nombrecurso`,
  `t`.`descripcion` AS `descripcion`, 
  pe.periodo AS periodo,
  `r`.`nota`        AS `nota`,  
   `r`.`observacion` AS `observacion`, 
   CONCAT(  d.`nombres`,' ', d.apellidos) AS docente  
FROM registro r
      INNER JOIN alumno a  ON a.idAlumno = r.idAlumno
     INNER JOIN trimestre t  ON t.idTri = r.idTri
   INNER JOIN curso c ON c.idCurso = r.idCurso
   INNER JOIN curso_docente cd ON cd.idCurso=c.idCurso
   INNER JOIN DOCENTE d ON d.`idDocente`=cd.`idDocente`
   INNER JOIN grado g ON g.`idGrado`=cd.`idGrado`
   INNER JOIN pago pa ON a.`idAlumno`=pa.idalumno
   INNER JOIN matricula ma ON ma.idpago=pa.idpago
   INNER JOIN periodo pe ON ma.idperiodo=pe.idperiodo
   WHERE d.`idDocente`=idd AND c.`idCurso`=idc;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_LISTAPAGOS` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_LISTAPAGOS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LISTAPAGOS`()
BEGIN
    SELECT P.FECHAPAGO, CONCAT(A.NOMBRE, A.APELLIDOS) AS NOMBRES, P.MONTO
    FROM PAGO P INNER JOIN ALUMNO A ON P.idalumno=A.idalumno where a.estado='PAGO MATRICULA' ;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTARALU` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTARALU` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTARALU`()
BEGIN
		SELECT CONCAT(nombre,' ',apellidos)AS nombres,fechanacimiento, dni,sexo,procedencia,direccion FROM alumno; 
	END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_LISTATRI` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_LISTATRI` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LISTATRI`()
BEGIN
	select * from trimestre;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTAuSUARIOS` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTAuSUARIOS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTAuSUARIOS`()
BEGIN
    SELECT CONCAT(nombre,' ',apellidos)AS Nombres,dni AS DNI,fechanacimiento AS Fecha_Nacimiento,genero AS Genero,telefono AS Celular,direccion AS Direccion
		FROM usuario;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTA_ALUMNO_NO_MATRICULADOS` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTA_ALUMNO_NO_MATRICULADOS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTA_ALUMNO_NO_MATRICULADOS`()
BEGIN
    		SELECT CONCAT(nombre,' ',apellidos)AS nombres,fechanacimiento, dni,sexo,procedencia,direccion FROM alumno
    		WHERE estado='NO MATRICULADO'; 
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_LISTA_DOCENTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_LISTA_DOCENTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LISTA_DOCENTE`()
BEGIN
    SELECT CONCAT(nombres,' ',apellidos)AS Nombres,dni AS DNI,fechanacimiento AS Fecha_Nacimiento,direccion AS direccion,celular AS Celular,
correo AS correo
		FROM docente;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTA_GRADOS` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTA_GRADOS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTA_GRADOS`()
BEGIN
    SELECT descripcion, estado FROM CARGO;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_LISTA_NOTAS_PROFE_SELECCIONA_GRADO_DOCENTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_LISTA_NOTAS_PROFE_SELECCIONA_GRADO_DOCENTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LISTA_NOTAS_PROFE_SELECCIONA_GRADO_DOCENTE`(idd int, idg int)
BEGIN
    SELECT concat(a.`nombre`, ' ', a.apellidos) AS alumno, g.`gradoseccion`, c.`nombrecurso`
FROM curso_docente cd INNER JOIN docente d ON cd.`idDocente`=d.`idDocente`
INNER JOIN curso c ON cd.`idCurso`=c.`idCurso`
INNER JOIN grado g ON g.`idGrado`=cd.`idGrado`
INNER JOIN alumno a ON a.`idGrado`=g.`idGrado`
WHERE d.`idDocente`=idd  AND g.`idGrado`=idg;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_LISTA_NOTA_ALUMNO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_LISTA_NOTA_ALUMNO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_LISTA_NOTA_ALUMNO`(ialu varchar(95))
BEGIN
    SELECT * FROM v_registro where alumno=ialu;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `SP_LISTA_PERIODO` */

/*!50003 DROP PROCEDURE IF EXISTS  `SP_LISTA_PERIODO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LISTA_PERIODO`()
BEGIN
    SELECT periodo, estado FROM PERIODO;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_MATRICULA_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_MATRICULA_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_MATRICULA_INGRESA`( idp INT, idper INT, idusu INT)
BEGIN
    DECLARE ida INT;
    SELECT a.idAlumno INTO ida FROM alumno a INNER JOIN pago p ON a.idalumno=p.idAlumno WHERE a.estado='PAGO DE MATRICULA' AND p.idpago= idp;
    INSERT INTO matricula (idpago, fechamatricula, idPeriodo, idusuario) VALUES (idp, CURDATE(), idper, idusu);
    
    UPDATE  alumno SET estado ='MATRICULADO' WHERE idAlumno=ida;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_MODIFICA_CURSO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_MODIFICA_CURSO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_MODIFICA_CURSO`(id int, nom varchar(45), es varchar(45))
BEGIN
    update curso set nombrecurso=nom, estado=es where idCurso=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_PAGO_INGRESAR` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_PAGO_INGRESAR` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_PAGO_INGRESAR`(ida int, mon decimal(10,2) )
BEGIN
    insert into pago (fechapago,idAlumno, monto) values (curdate(),ida,mon);
    update alumno set estado='PAGO DE MATRICULA' where idAlumno=ida;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_NOTAS_ALUMNO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_NOTAS_ALUMNO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_NOTAS_ALUMNO`(ida int, idc int)
BEGIN
  
  
   SELECT a.`idAlumno`, CONCAT(a.nombre,' ', a.apellidos) AS alumno, a.`idGrado`, 
   g.`gradoseccion`, c.`nombrecurso`, r.`nota`, r.observacion, t.`descripcion`, pe.`periodo`
FROM registro r 
INNER JOIN alumno a ON r.`idAlumno`=a.`idAlumno`
INNER JOIN curso c ON c.`idCurso`=r.`idCurso`
INNER JOIN trimestre t ON t.`idTri`=r.`idTri`
INNER JOIN grado g ON g.`idGrado`=a.`idGrado`
  INNER JOIN pago pa ON a.`idAlumno`=pa.idalumno
   INNER JOIN matricula ma ON ma.idpago=pa.idpago
   INNER JOIN periodo pe ON ma.idperiodo=pe.idperiodo
WHERE a.`idAlumno`=ida AND c.`idCurso`=idc;
   
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_PERIODO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_PERIODO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_PERIODO_ELIMINA`(id int)
BEGIN
    delete from periodo where idPeriodo=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_PERIODO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_PERIODO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_PERIODO_INGRESA`(peri varchar(45), esta varchar(45))
BEGIN
    insert into periodo (periodo, estado) values(peri,esta);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_PERIODO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_PERIODO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_PERIODO_MODIFICA`(id int, peri varchar(45), est varchar(45))
BEGIN
    update periodo set periodo=peri, estado=est where idPeriodo=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REGISTRO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REGISTRO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REGISTRO_INGRESA`( ida int, idcu int, idtr int, nt decimal(9,2), obs varchar(20))
BEGIN
    insert into registro (idAlumno, idCurso, idTri, nota, observacion) values (ida, idcu,idtr, nt,obs);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REGISTRO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REGISTRO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REGISTRO_MODIFICA`(id int,ida INT, idcu INT, idtr INT, nt DECIMAL(9,2), obs VARCHAR(20))
BEGIN
    update registro set idAlumno=ida, idcurso=idcu, idtri=idtr, nota=nt, observacion=obs where idRegistro=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REUNIONESPORDOCENTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REUNIONESPORDOCENTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REUNIONESPORDOCENTE`(iddo int)
BEGIN
    SELECT r.`idreuniones`, d.iddocente, CONCAT(d.`nombres`,' ', d.`apellidos`) AS docente, g.gradoseccion, r.`fecha`, r.`descripción`, r.`filer`
FROM reuniones r INNER JOIN docente d ON r.`idDocente`=d.`idDocente`
INNER JOIN grado g ON g.idgrado=r.`idGrado`
where d.iddocente=iddo;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REUNIONES_APO` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REUNIONES_APO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REUNIONES_APO`(idg int)
BEGIN
    SELECT  r.idreuniones, CONCAT( d.nombres,' ',d.apellidos) AS docente, g.gradoseccion, r.fecha, r.descripción, r.filer
FROM reuniones r   
INNER JOIN grado g ON r.idgrado=g.idgrado
INNER JOIN docente d ON d.iddocente=r.iddocente
WHERE r.idgrado=idg;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REUNION_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REUNION_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REUNION_ELIMINA`(id int)
BEGIN
    DELETE FROM reuniones WHERE idReuniones=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REUNION_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REUNION_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REUNION_MODIFICA`( idr int, idd INT, idg INT, des LONGTEXT, fi LONGTEXT)
BEGIN
    update reuniones set idDocente=idd, idGrado=idg, descripción=des, filer=fi where idReuniones=idr;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_REUNION_REGISTRA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_REUNION_REGISTRA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_REUNION_REGISTRA`( idd int,  idg int, des longtext, fi longtext )
BEGIN
    insert into reuniones (idDocente,  idGrado, fecha, descripción, filer) values(idd,  idg, curdate(), des, fi ) ;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_SELECCIONA_ALUMNO_PARA_NOTA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_SELECCIONA_ALUMNO_PARA_NOTA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_SELECCIONA_ALUMNO_PARA_NOTA`(gradoa int)
BEGIN
SELECT idalumno , CONCAT(nombre, ' ', apellidos) AS alumno
FROM alumno 
WHERE idGrado=gradoa AND estado='MATRICULADO';
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_SELECCIONA_GRADO_ALUMNO_PARANOTA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_SELECCIONA_GRADO_ALUMNO_PARANOTA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_SELECCIONA_GRADO_ALUMNO_PARANOTA`(gr int, al int)
BEGIN
 SELECT  CONCAT(a.nombre,' ', a.apellidos) AS alumno ,c.idcurso, c.nombrecurso
FROM curso_docente cd INNER JOIN grado g ON cd.idgrado=g.idgrado
INNER JOIN alumno a  ON cd.idgrado=a.idgrado
INNER JOIN curso c ON c.idcurso=cd.idcurso
WHERE  a.idgrado=gr AND a.idalumno=al;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_TRIMESTRE_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_TRIMESTRE_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TRIMESTRE_ELIMINA`(id int)
BEGIN
    delete from  trimestre where  idTri=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_TRIMESTRE_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_TRIMESTRE_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TRIMESTRE_INGRESA`(des VARCHAR(45))
BEGIN
    INSERT INTO trimestre (descripcion) VALUES (des);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_TRIMESTRE_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_TRIMESTRE_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TRIMESTRE_MODIFICA`(id int, des varchar(45))
BEGIN
    update trimestre set descripcion=des
    where idTri=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_USUARIO_ELIMINA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_USUARIO_ELIMINA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_USUARIO_ELIMINA`(id INT)
BEGIN
    DELETE FROM usuario WHERE idusuario=id;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_USUARIO_INGRESA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_USUARIO_INGRESA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_USUARIO_INGRESA`( dn CHAR(8), fot VARCHAR(50), nom VARCHAR(40), ape VARCHAR(40), gen VARCHAR(20),
   fnac DATE, ema VARCHAR(45), tel CHAR(20), cel char(9), dire VARCHAR(45), usu VARCHAR(45), est VARCHAR(45), 
   idc INT)
BEGIN
    INSERT INTO usuario (dni, foto, nombre, apellidos, genero, fechanacimiento, email, telefono, celular,
    direccion,diaingreso,  usuario,  estado, idcargo) VALUES ( dn, fot, nom,ape,gen, fnac, ema, tel,cel, dire, CURDATE(),
    usu,est,idc);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_USUARIO_MODIFICA` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_USUARIO_MODIFICA` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_USUARIO_MODIFICA`(id INT, dn CHAR(8), fot VARCHAR(50), nom VARCHAR(40), ape VARCHAR(40),
     gen VARCHAR(20),fnac DATE, ema VARCHAR(45), tel CHAR(20), cel char(9), dire VARCHAR(45), usu VARCHAR(45), cont VARCHAR(45), 
     est VARCHAR(45), idc INT)
BEGIN
     UPDATE usuario SET dni = dn,
     foto=fot, nombre=nom, apellidos=ape, genero=gen, fechanacimiento=fnac, email=ema, telefono=tel,celular=cel, 
    direccion=dire, usuario=usu, clave=cont, estado=est, idcargo=idc 
    WHERE idusuario=id;
    END */$$
DELIMITER ;

/*Table structure for table `apo` */

DROP TABLE IF EXISTS `apo`;

/*!50001 DROP VIEW IF EXISTS `apo` */;
/*!50001 DROP TABLE IF EXISTS `apo` */;

/*!50001 CREATE TABLE  `apo`(
 `idApoderado` int(11) ,
 `dni` char(8) ,
 `foto` varchar(50) ,
 `nombre` varchar(45) ,
 `apellidos` varchar(90) ,
 `genero` varchar(45) ,
 `fechanacimiento` date ,
 `email` varchar(100) ,
 `celular` varchar(9) ,
 `direccion` varchar(50) ,
 `usuario` varchar(60) ,
 `clave` varchar(40) ,
 `estado` varchar(45) ,
 `diaRegistar` date ,
 `parentesco` varchar(50) ,
 `nivelacademico` varchar(50) ,
 `oficio` varchar(60) 
)*/;

/*Table structure for table `v_alumno` */

DROP TABLE IF EXISTS `v_alumno`;

/*!50001 DROP VIEW IF EXISTS `v_alumno` */;
/*!50001 DROP TABLE IF EXISTS `v_alumno` */;

/*!50001 CREATE TABLE  `v_alumno`(
 `idAlumno` int(11) ,
 `dni` char(8) ,
 `foto` varchar(50) ,
 `nombre` varchar(90) ,
 `apellidos` varchar(90) ,
 `fechanacimiento` date ,
 `direccion` varchar(200) ,
 `celular` varchar(9) ,
 `email` varchar(45) ,
 `sexo` varchar(45) ,
 `procedencia` varchar(100) ,
 `alergia` varchar(100) ,
 `limitaciones` varchar(500) ,
 `usuario` varchar(30) ,
 `contraseña` varchar(50) ,
 `apoderado` varchar(136) ,
 `grado` varchar(90) ,
 `diaRegistro` date ,
 `estado` varchar(45) 
)*/;

/*Table structure for table `v_alumno_ids` */

DROP TABLE IF EXISTS `v_alumno_ids`;

/*!50001 DROP VIEW IF EXISTS `v_alumno_ids` */;
/*!50001 DROP TABLE IF EXISTS `v_alumno_ids` */;

/*!50001 CREATE TABLE  `v_alumno_ids`(
 `idAlumno` int(11) ,
 `dni` char(8) ,
 `foto` varchar(50) ,
 `nombre` varchar(90) ,
 `apellidos` varchar(90) ,
 `fechanacimiento` date ,
 `direccion` varchar(200) ,
 `celular` varchar(9) ,
 `email` varchar(45) ,
 `sexo` varchar(45) ,
 `procedencia` varchar(100) ,
 `alergia` varchar(100) ,
 `limitaciones` varchar(500) ,
 `usuario` varchar(30) ,
 `contraseña` varchar(50) ,
 `idApoderado` int(11) ,
 `idGrado` int(11) ,
 `estado` varchar(45) ,
 `diaRegistro` date 
)*/;

/*Table structure for table `v_alumno_pagomatricula` */

DROP TABLE IF EXISTS `v_alumno_pagomatricula`;

/*!50001 DROP VIEW IF EXISTS `v_alumno_pagomatricula` */;
/*!50001 DROP TABLE IF EXISTS `v_alumno_pagomatricula` */;

/*!50001 CREATE TABLE  `v_alumno_pagomatricula`(
 `idpago` int(11) ,
 `FECHAPAGO` date ,
 `NOMBRES` varchar(180) ,
 `MONTO` decimal(10,2) ,
 `estado` varchar(25) 
)*/;

/*Table structure for table `v_apoderado` */

DROP TABLE IF EXISTS `v_apoderado`;

/*!50001 DROP VIEW IF EXISTS `v_apoderado` */;
/*!50001 DROP TABLE IF EXISTS `v_apoderado` */;

/*!50001 CREATE TABLE  `v_apoderado`(
 `idapoderado` int(11) ,
 `dni` char(8) ,
 `foto` varchar(50) ,
 `nombres` varchar(45) ,
 `Apellidos` varchar(90) ,
 `genero` varchar(45) ,
 `fechanacimiento` date ,
 `email` varchar(100) ,
 `telefono` varchar(9) ,
 `direccion` varchar(50) ,
 `usuario` varchar(60) ,
 `contraseña` varchar(40) ,
 `estado` varchar(45) ,
 `diaRegistro` date ,
 `parentesco` varchar(50) ,
 `nivelacademico` varchar(50) ,
 `oficio` varchar(60) 
)*/;

/*Table structure for table `v_cargo` */

DROP TABLE IF EXISTS `v_cargo`;

/*!50001 DROP VIEW IF EXISTS `v_cargo` */;
/*!50001 DROP TABLE IF EXISTS `v_cargo` */;

/*!50001 CREATE TABLE  `v_cargo`(
 `idcargo` int(11) ,
 `descripcion` varchar(20) ,
 `estado` varchar(20) 
)*/;

/*Table structure for table `v_curso` */

DROP TABLE IF EXISTS `v_curso`;

/*!50001 DROP VIEW IF EXISTS `v_curso` */;
/*!50001 DROP TABLE IF EXISTS `v_curso` */;

/*!50001 CREATE TABLE  `v_curso`(
 `idCurso` int(11) ,
 `nombrecurso` varchar(80) ,
 `estado` varchar(25) 
)*/;

/*Table structure for table `v_curso_docente` */

DROP TABLE IF EXISTS `v_curso_docente`;

/*!50001 DROP VIEW IF EXISTS `v_curso_docente` */;
/*!50001 DROP TABLE IF EXISTS `v_curso_docente` */;

/*!50001 CREATE TABLE  `v_curso_docente`(
 `id` int(11) ,
 `idcurso` int(11) ,
 `CURSO` varchar(80) ,
 `DOCENTE` varchar(151) ,
 `iddocente` int(11) ,
 `idgrado` int(11) ,
 `grado` varchar(90) 
)*/;

/*Table structure for table `v_docente` */

DROP TABLE IF EXISTS `v_docente`;

/*!50001 DROP VIEW IF EXISTS `v_docente` */;
/*!50001 DROP TABLE IF EXISTS `v_docente` */;

/*!50001 CREATE TABLE  `v_docente`(
 `idDocente` int(11) ,
 `foto` varchar(100) ,
 `dni` char(8) ,
 `nombres` varchar(60) ,
 `apellidos` varchar(90) ,
 `direccion` varchar(45) ,
 `telefono_fijo` varchar(15) ,
 `celular` varchar(9) ,
 `fechanacimiento` date ,
 `correo` varchar(60) ,
 `titulo` varchar(45) ,
 `estado` varchar(45) ,
 `diaRegistro` date ,
 `usuario` varchar(45) ,
 `contraseña` varchar(100) 
)*/;

/*Table structure for table `v_grado` */

DROP TABLE IF EXISTS `v_grado`;

/*!50001 DROP VIEW IF EXISTS `v_grado` */;
/*!50001 DROP TABLE IF EXISTS `v_grado` */;

/*!50001 CREATE TABLE  `v_grado`(
 `idgrado` int(11) ,
 `gradoseccion` varchar(90) ,
 `maxalumnos` int(11) ,
 `total` int(11) 
)*/;

/*Table structure for table `v_matricula` */

DROP TABLE IF EXISTS `v_matricula`;

/*!50001 DROP VIEW IF EXISTS `v_matricula` */;
/*!50001 DROP TABLE IF EXISTS `v_matricula` */;

/*!50001 CREATE TABLE  `v_matricula`(
 `idMatricula` int(11) ,
 `fechamatricula` date ,
 `fechapago` date ,
 `idAlumno` int(11) ,
 `alumno` varchar(181) ,
 `periodo` varchar(45) ,
 `usuario` varchar(91) 
)*/;

/*Table structure for table `v_pago` */

DROP TABLE IF EXISTS `v_pago`;

/*!50001 DROP VIEW IF EXISTS `v_pago` */;
/*!50001 DROP TABLE IF EXISTS `v_pago` */;

/*!50001 CREATE TABLE  `v_pago`(
 `idpago` int(11) ,
 `FECHAPAGO` date ,
 `NOMBRES` varchar(180) ,
 `MONTO` decimal(10,2) ,
 `estado` varchar(25) 
)*/;

/*Table structure for table `v_periodo` */

DROP TABLE IF EXISTS `v_periodo`;

/*!50001 DROP VIEW IF EXISTS `v_periodo` */;
/*!50001 DROP TABLE IF EXISTS `v_periodo` */;

/*!50001 CREATE TABLE  `v_periodo`(
 `idPeriodo` int(11) ,
 `periodo` varchar(45) ,
 `estado` varchar(45) 
)*/;

/*Table structure for table `v_registro` */

DROP TABLE IF EXISTS `v_registro`;

/*!50001 DROP VIEW IF EXISTS `v_registro` */;
/*!50001 DROP TABLE IF EXISTS `v_registro` */;

/*!50001 CREATE TABLE  `v_registro`(
 `idRegistro` int(11) ,
 `alumno` varchar(181) ,
 `nombrecurso` varchar(80) ,
 `grado` varchar(90) ,
 `descripcion` varchar(45) ,
 `nota` decimal(9,2) ,
 `observacion` varchar(20) 
)*/;

/*Table structure for table `v_reuniones` */

DROP TABLE IF EXISTS `v_reuniones`;

/*!50001 DROP VIEW IF EXISTS `v_reuniones` */;
/*!50001 DROP TABLE IF EXISTS `v_reuniones` */;

/*!50001 CREATE TABLE  `v_reuniones`(
 `idreuniones` int(11) ,
 `iddocente` int(11) ,
 `docente` varchar(151) ,
 `gradoseccion` varchar(90) ,
 `fecha` date ,
 `descripción` longtext ,
 `filer` longtext 
)*/;

/*Table structure for table `v_trimestre` */

DROP TABLE IF EXISTS `v_trimestre`;

/*!50001 DROP VIEW IF EXISTS `v_trimestre` */;
/*!50001 DROP TABLE IF EXISTS `v_trimestre` */;

/*!50001 CREATE TABLE  `v_trimestre`(
 `idTri` int(11) ,
 `descripcion` varchar(45) 
)*/;

/*Table structure for table `v_usuario` */

DROP TABLE IF EXISTS `v_usuario`;

/*!50001 DROP VIEW IF EXISTS `v_usuario` */;
/*!50001 DROP TABLE IF EXISTS `v_usuario` */;

/*!50001 CREATE TABLE  `v_usuario`(
 `idusuario` int(11) ,
 `dni` varchar(45) ,
 `foto` varchar(45) ,
 `nombres` varchar(45) ,
 `Apellidos` varchar(45) ,
 `genero` varchar(45) ,
 `fechanacimiento` date ,
 `email` varchar(45) ,
 `telefono` varchar(15) ,
 `celular` varchar(9) ,
 `direccion` varchar(45) ,
 `diaIngreso` date ,
 `usuario` varchar(45) ,
 `clave` varchar(45) ,
 `estado` varchar(45) ,
 `descripcion` varchar(20) 
)*/;

/*Table structure for table `v_usuario_id` */

DROP TABLE IF EXISTS `v_usuario_id`;

/*!50001 DROP VIEW IF EXISTS `v_usuario_id` */;
/*!50001 DROP TABLE IF EXISTS `v_usuario_id` */;

/*!50001 CREATE TABLE  `v_usuario_id`(
 `idusuario` int(11) ,
 `dni` varchar(45) ,
 `foto` varchar(45) ,
 `nombre` varchar(45) ,
 `apellidos` varchar(45) ,
 `genero` varchar(45) ,
 `fechanacimiento` date ,
 `email` varchar(45) ,
 `telefono` varchar(15) ,
 `celular` varchar(9) ,
 `direccion` varchar(45) ,
 `diaingreso` date ,
 `usuario` varchar(45) ,
 `clave` varchar(45) ,
 `estado` varchar(45) ,
 `idcargo` int(11) 
)*/;

/*View structure for view apo */

/*!50001 DROP TABLE IF EXISTS `apo` */;
/*!50001 DROP VIEW IF EXISTS `apo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `apo` AS select `apoderado`.`idApoderado` AS `idApoderado`,`apoderado`.`dni` AS `dni`,`apoderado`.`foto` AS `foto`,`apoderado`.`nombre` AS `nombre`,`apoderado`.`apellidos` AS `apellidos`,`apoderado`.`genero` AS `genero`,`apoderado`.`fechanacimiento` AS `fechanacimiento`,`apoderado`.`email` AS `email`,`apoderado`.`celular` AS `celular`,`apoderado`.`direccion` AS `direccion`,`apoderado`.`usuario` AS `usuario`,`apoderado`.`clave` AS `clave`,`apoderado`.`estado` AS `estado`,`apoderado`.`diaRegistar` AS `diaRegistar`,`apoderado`.`parentesco` AS `parentesco`,`apoderado`.`nivelacademico` AS `nivelacademico`,`apoderado`.`oficio` AS `oficio` from `apoderado` */;

/*View structure for view v_alumno */

/*!50001 DROP TABLE IF EXISTS `v_alumno` */;
/*!50001 DROP VIEW IF EXISTS `v_alumno` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_alumno` AS select `alumno`.`idAlumno` AS `idAlumno`,`alumno`.`dni` AS `dni`,`alumno`.`foto` AS `foto`,`alumno`.`nombre` AS `nombre`,`alumno`.`apellidos` AS `apellidos`,`alumno`.`fechanacimiento` AS `fechanacimiento`,`alumno`.`direccion` AS `direccion`,`alumno`.`celular` AS `celular`,`alumno`.`email` AS `email`,`alumno`.`sexo` AS `sexo`,`alumno`.`procedencia` AS `procedencia`,`alumno`.`alergia` AS `alergia`,`alumno`.`limitaciones` AS `limitaciones`,`alumno`.`usuario` AS `usuario`,`alumno`.`contraseña` AS `contraseña`,concat(`apoderado`.`apellidos`,' ',`apoderado`.`nombre`) AS `apoderado`,`grado`.`gradoseccion` AS `grado`,`alumno`.`diaRegistro` AS `diaRegistro`,`alumno`.`estado` AS `estado` from ((`alumno` join `grado` on((`alumno`.`idGrado` = `grado`.`idGrado`))) join `apoderado` on((`apoderado`.`idApoderado` = `alumno`.`idApoderado`))) */;

/*View structure for view v_alumno_ids */

/*!50001 DROP TABLE IF EXISTS `v_alumno_ids` */;
/*!50001 DROP VIEW IF EXISTS `v_alumno_ids` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_alumno_ids` AS select `alumno`.`idAlumno` AS `idAlumno`,`alumno`.`dni` AS `dni`,`alumno`.`foto` AS `foto`,`alumno`.`nombre` AS `nombre`,`alumno`.`apellidos` AS `apellidos`,`alumno`.`fechanacimiento` AS `fechanacimiento`,`alumno`.`direccion` AS `direccion`,`alumno`.`celular` AS `celular`,`alumno`.`email` AS `email`,`alumno`.`sexo` AS `sexo`,`alumno`.`procedencia` AS `procedencia`,`alumno`.`alergia` AS `alergia`,`alumno`.`limitaciones` AS `limitaciones`,`alumno`.`usuario` AS `usuario`,`alumno`.`contraseña` AS `contraseña`,`alumno`.`idApoderado` AS `idApoderado`,`alumno`.`idGrado` AS `idGrado`,`alumno`.`estado` AS `estado`,`alumno`.`diaRegistro` AS `diaRegistro` from `alumno` */;

/*View structure for view v_alumno_pagomatricula */

/*!50001 DROP TABLE IF EXISTS `v_alumno_pagomatricula` */;
/*!50001 DROP VIEW IF EXISTS `v_alumno_pagomatricula` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_alumno_pagomatricula` AS select `p`.`idpago` AS `idpago`,`p`.`fechapago` AS `FECHAPAGO`,concat(`a`.`nombre`,`a`.`apellidos`) AS `NOMBRES`,`p`.`monto` AS `MONTO`,`p`.`estado` AS `estado` from (`pago` `p` join `alumno` `a` on((`p`.`idAlumno` = `a`.`idAlumno`))) where (`a`.`estado` = 'PAGO DE MATRICULA') */;

/*View structure for view v_apoderado */

/*!50001 DROP TABLE IF EXISTS `v_apoderado` */;
/*!50001 DROP VIEW IF EXISTS `v_apoderado` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_apoderado` AS (select `a`.`idApoderado` AS `idapoderado`,`a`.`dni` AS `dni`,`a`.`foto` AS `foto`,`a`.`nombre` AS `nombres`,`a`.`apellidos` AS `Apellidos`,`a`.`genero` AS `genero`,`a`.`fechanacimiento` AS `fechanacimiento`,`a`.`email` AS `email`,`a`.`celular` AS `telefono`,`a`.`direccion` AS `direccion`,`a`.`usuario` AS `usuario`,`a`.`clave` AS `contraseña`,`a`.`estado` AS `estado`,`a`.`diaRegistar` AS `diaRegistro`,`a`.`parentesco` AS `parentesco`,`a`.`nivelacademico` AS `nivelacademico`,`a`.`oficio` AS `oficio` from `apoderado` `a`) */;

/*View structure for view v_cargo */

/*!50001 DROP TABLE IF EXISTS `v_cargo` */;
/*!50001 DROP VIEW IF EXISTS `v_cargo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_cargo` AS (select `a`.`idcargo` AS `idcargo`,`a`.`descripcion` AS `descripcion`,`a`.`estado` AS `estado` from `cargo` `a`) */;

/*View structure for view v_curso */

/*!50001 DROP TABLE IF EXISTS `v_curso` */;
/*!50001 DROP VIEW IF EXISTS `v_curso` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_curso` AS select `curso`.`idCurso` AS `idCurso`,`curso`.`nombrecurso` AS `nombrecurso`,`curso`.`estado` AS `estado` from `curso` */;

/*View structure for view v_curso_docente */

/*!50001 DROP TABLE IF EXISTS `v_curso_docente` */;
/*!50001 DROP VIEW IF EXISTS `v_curso_docente` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_curso_docente` AS select `cd`.`idcursodocente` AS `id`,`cd`.`idCurso` AS `idcurso`,`c`.`nombrecurso` AS `CURSO`,concat(`d`.`nombres`,' ',`d`.`apellidos`) AS `DOCENTE`,`cd`.`idDocente` AS `iddocente`,`cd`.`idGrado` AS `idgrado`,`g`.`gradoseccion` AS `grado` from (((`curso_docente` `cd` join `curso` `c` on((`cd`.`idCurso` = `c`.`idCurso`))) join `docente` `d` on((`cd`.`idDocente` = `d`.`idDocente`))) join `grado` `g` on((`g`.`idGrado` = `cd`.`idGrado`))) */;

/*View structure for view v_docente */

/*!50001 DROP TABLE IF EXISTS `v_docente` */;
/*!50001 DROP VIEW IF EXISTS `v_docente` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_docente` AS select `docente`.`idDocente` AS `idDocente`,`docente`.`foto` AS `foto`,`docente`.`dni` AS `dni`,`docente`.`nombres` AS `nombres`,`docente`.`apellidos` AS `apellidos`,`docente`.`direccion` AS `direccion`,`docente`.`telefono_fijo` AS `telefono_fijo`,`docente`.`celular` AS `celular`,`docente`.`fechanacimiento` AS `fechanacimiento`,`docente`.`correo` AS `correo`,`docente`.`titulo` AS `titulo`,`docente`.`estado` AS `estado`,`docente`.`diaRegistro` AS `diaRegistro`,`docente`.`usuario` AS `usuario`,`docente`.`contraseña` AS `contraseña` from `docente` */;

/*View structure for view v_grado */

/*!50001 DROP TABLE IF EXISTS `v_grado` */;
/*!50001 DROP VIEW IF EXISTS `v_grado` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_grado` AS select `grado`.`idGrado` AS `idgrado`,`grado`.`gradoseccion` AS `gradoseccion`,`grado`.`maxalumnos` AS `maxalumnos`,`grado`.`total` AS `total` from `grado` */;

/*View structure for view v_matricula */

/*!50001 DROP TABLE IF EXISTS `v_matricula` */;
/*!50001 DROP VIEW IF EXISTS `v_matricula` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_matricula` AS select `m`.`idMatricula` AS `idMatricula`,`m`.`fechamatricula` AS `fechamatricula`,`p`.`fechapago` AS `fechapago`,`p`.`idAlumno` AS `idAlumno`,concat(`a`.`nombre`,' ',`a`.`apellidos`) AS `alumno`,`pe`.`periodo` AS `periodo`,concat(`u`.`apellidos`,' ',`u`.`nombre`) AS `usuario` from ((((`matricula` `m` join `pago` `p` on((`m`.`idpago` = `p`.`idpago`))) join `alumno` `a` on((`p`.`idAlumno` = `a`.`idAlumno`))) join `periodo` `pe` on((`pe`.`idPeriodo` = `m`.`idPeriodo`))) join `usuario` `u` on((`u`.`idusuario` = `m`.`idusuario`))) */;

/*View structure for view v_pago */

/*!50001 DROP TABLE IF EXISTS `v_pago` */;
/*!50001 DROP VIEW IF EXISTS `v_pago` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_pago` AS select `p`.`idpago` AS `idpago`,`p`.`fechapago` AS `FECHAPAGO`,concat(`a`.`nombre`,`a`.`apellidos`) AS `NOMBRES`,`p`.`monto` AS `MONTO`,`p`.`estado` AS `estado` from (`pago` `p` join `alumno` `a` on((`p`.`idAlumno` = `a`.`idAlumno`))) */;

/*View structure for view v_periodo */

/*!50001 DROP TABLE IF EXISTS `v_periodo` */;
/*!50001 DROP VIEW IF EXISTS `v_periodo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_periodo` AS select `periodo`.`idPeriodo` AS `idPeriodo`,`periodo`.`periodo` AS `periodo`,`periodo`.`estado` AS `estado` from `periodo` */;

/*View structure for view v_registro */

/*!50001 DROP TABLE IF EXISTS `v_registro` */;
/*!50001 DROP VIEW IF EXISTS `v_registro` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_registro` AS select `r`.`idRegistro` AS `idRegistro`,concat(`a`.`nombre`,' ',`a`.`apellidos`) AS `alumno`,`c`.`nombrecurso` AS `nombrecurso`,`g`.`gradoseccion` AS `grado`,`t`.`descripcion` AS `descripcion`,`r`.`nota` AS `nota`,`r`.`observacion` AS `observacion` from ((((`registro` `r` join `alumno` `a` on((`a`.`idAlumno` = `r`.`idAlumno`))) join `trimestre` `t` on((`t`.`idTri` = `r`.`idTri`))) join `curso` `c` on((`c`.`idCurso` = `r`.`idCurso`))) join `grado` `g` on((`g`.`idGrado` = `a`.`idGrado`))) */;

/*View structure for view v_reuniones */

/*!50001 DROP TABLE IF EXISTS `v_reuniones` */;
/*!50001 DROP VIEW IF EXISTS `v_reuniones` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_reuniones` AS select `r`.`idreuniones` AS `idreuniones`,`d`.`idDocente` AS `iddocente`,concat(`d`.`nombres`,' ',`d`.`apellidos`) AS `docente`,`g`.`gradoseccion` AS `gradoseccion`,`r`.`fecha` AS `fecha`,`r`.`descripción` AS `descripción`,`r`.`filer` AS `filer` from ((`reuniones` `r` join `docente` `d` on((`r`.`idDocente` = `d`.`idDocente`))) join `grado` `g` on((`g`.`idGrado` = `r`.`idGrado`))) */;

/*View structure for view v_trimestre */

/*!50001 DROP TABLE IF EXISTS `v_trimestre` */;
/*!50001 DROP VIEW IF EXISTS `v_trimestre` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_trimestre` AS select `trimestre`.`idTri` AS `idTri`,`trimestre`.`descripcion` AS `descripcion` from `trimestre` */;

/*View structure for view v_usuario */

/*!50001 DROP TABLE IF EXISTS `v_usuario` */;
/*!50001 DROP VIEW IF EXISTS `v_usuario` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_usuario` AS (select `a`.`idusuario` AS `idusuario`,`a`.`dni` AS `dni`,`a`.`foto` AS `foto`,`a`.`nombre` AS `nombres`,`a`.`apellidos` AS `Apellidos`,`a`.`genero` AS `genero`,`a`.`fechanacimiento` AS `fechanacimiento`,`a`.`email` AS `email`,`a`.`telefono` AS `telefono`,`a`.`celular` AS `celular`,`a`.`direccion` AS `direccion`,`a`.`diaingreso` AS `diaIngreso`,`a`.`usuario` AS `usuario`,`a`.`clave` AS `clave`,`a`.`estado` AS `estado`,`c`.`descripcion` AS `descripcion` from (`usuario` `a` join `cargo` `c` on((`a`.`idcargo` = `c`.`idcargo`)))) */;

/*View structure for view v_usuario_id */

/*!50001 DROP TABLE IF EXISTS `v_usuario_id` */;
/*!50001 DROP VIEW IF EXISTS `v_usuario_id` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_usuario_id` AS select `usuario`.`idusuario` AS `idusuario`,`usuario`.`dni` AS `dni`,`usuario`.`foto` AS `foto`,`usuario`.`nombre` AS `nombre`,`usuario`.`apellidos` AS `apellidos`,`usuario`.`genero` AS `genero`,`usuario`.`fechanacimiento` AS `fechanacimiento`,`usuario`.`email` AS `email`,`usuario`.`telefono` AS `telefono`,`usuario`.`celular` AS `celular`,`usuario`.`direccion` AS `direccion`,`usuario`.`diaingreso` AS `diaingreso`,`usuario`.`usuario` AS `usuario`,`usuario`.`clave` AS `clave`,`usuario`.`estado` AS `estado`,`usuario`.`idcargo` AS `idcargo` from `usuario` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

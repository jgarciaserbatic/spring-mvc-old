--
-- Estructura de tabla para la tabla `alumnos`
--
DROP TABLE `alumnos`
CREATE TABLE `alumnos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL
);

ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID`);
COMMIT;


DROP TABLE `profesores`
CREATE TABLE `profesores` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `MATERIA_ID` int(11) NOT NULL
);

ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);
COMMIT;

DROP TABLE `materias`
CREATE TABLE `materias` (
  `ID` int(11) NOT NULL,
  `MATERIA` varchar(250) NOT NULL,
  `PROFESOR_ID` int(11) NOT NULL
);

ALTER TABLE `materias`
  ADD PRIMARY KEY (`ID`);
COMMIT;

DROP TABLE `notas`
CREATE TABLE `notas` (
  `ID` int(11) NOT NULL,
  `MATERIA_ID` int(11) NOT NULL,
  `ALUMNO_ID` int(11) NOT NULL,
  `NOTA` int(2) NOT NULL
);

ALTER TABLE `notas`
  ADD PRIMARY KEY (`ID`);
COMMIT;


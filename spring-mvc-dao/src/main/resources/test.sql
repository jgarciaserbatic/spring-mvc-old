--

-- Estructura de tabla para la tabla `alumnos`
DROP TABLE `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
 `ID` int(11) NOT NULL,
 `NOMBRE` varchar(250) NOT NULL,
 `APELLIDO_1` varchar(250) NOT NULL,
 `APELLIDO_2` varchar(250) NOT NULL);--


----

-- Indices de la tabla `alumnos`

--
ALTER TABLE `alumnos`
 ADD PRIMARY KEY (`ID`);
COMMIT;--

-- Estructura de tabla para la tabla `profesores`
DROP TABLE `profesores`;
CREATE TABLE IF NOT EXISTS `profesores` (
 `ID` int(11) NOT NULL,
 `NOMBRE` varchar(250) NOT NULL,
 `APELLIDO_1` varchar(250) NOT NULL,
 `APELLIDO_2` varchar(250) NOT NULL);--


----

-- Indices de la tabla `profesores`

--
ALTER TABLE `profesores`

 ADD PRIMARY KEY (`ID`);

COMMIT;--

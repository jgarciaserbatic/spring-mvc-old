--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID`);
  
CREATE TABLE `profesores` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `MATERIA` varchar(250) NOT NULL
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);  
  
 CREATE TABLE `materia` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL
);
ALTER TABLE `materia`
  ADD PRIMARY KEY (`ID`);

COMMIT;

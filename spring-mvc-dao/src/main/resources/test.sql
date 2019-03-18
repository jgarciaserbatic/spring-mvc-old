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
-- Indices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ID`);
COMMIT;


--
-- Estructura de tabla para la tabla `profesores`
--
DROP TABLE `profesores`;

CREATE TABLE `profesores` (
  `IDPROFESOR` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `TELEFONO` varchar(250) NOT NULL
);

--
-- Indices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);
COMMIT;


CREATE TABLE `materias` (
  `IDMATERIA` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `FECHAEXAMEN` date
);

--
-- Indices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`ID`);
COMMIT;

DROP TABLE  `profesor_materia`;

CREATE TABLE `profesor_materia` (
  `IDMATERIA` int(11) NOT NULL,
  `IDPROFESOR` int(11) NOT NULL,
);

ALTER TABLE `profesor_materia`
  ADD PRIMARY KEY (`IDMATERIA`);
  ADD PRIMARY KEY (`IDPROFESOR`);
COMMIT;

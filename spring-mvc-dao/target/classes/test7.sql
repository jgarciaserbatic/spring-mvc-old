--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `MAIL` varchar(250) NOT NULL
);

--
-- Ã�ndices para tablas volcadas
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

CREATE TABLE `profesores` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `FECHA` date NOT NULL
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);
COMMIT;

DROP TABLE `asignaturas`;

CREATE TABLE IF NOT EXISTS  `asignaturas` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `DESCRIPCION` varchar(250) NOT NULL
);

ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`ID`);
COMMIT;

CREATE TABLE IF NOT EXISTS  `profesores_asignaturas` (
  `ID_PROFESOR` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL,

  ALTER TABLE `profesores_asignaturas`
  ADD PRIMARY KEY (`ID_PROFESOR`, `ID_ASIGNATURA`);
COMMIT;
  
);


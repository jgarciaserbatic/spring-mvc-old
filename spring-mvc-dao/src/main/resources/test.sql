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
COMMIT;

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `ID_PROFESOR` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `ID_MATERIA` int(11) NOT NULL
  
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID_PROFESOR`);
COMMIT;


--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `ID_MATERIA` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  
  
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`ID_MATERIA`);
COMMIT;


--
-- Estructura de tabla para la tabla `profesores_materias`
--

CREATE TABLE `profesores_materias` (
  `ID_MATERIA` int(11) NOT NULL,
  `ID_PROFESOR` int(11) NOT NULL,
  
  
);

--
-- Ã�ndices para tablas volcadas
--

--
-- Indices de la tabla `materias`
--
--ALTER TABLE `profesores_materias`
--  ADD PRIMARY KEY (`ID_MATERIA`);
COMMIT;

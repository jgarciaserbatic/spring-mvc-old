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
-- Índices para tablas volcadas
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
  `APELLIDO_2` varchar(250) NOT NULL
);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);
COMMIT;



--
-- Estructura de tabla para la tabla `asinaturas`
--
CREATE TABLE `asignaturas` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `ID_PROFESOR` varchar(250) NOT NULL,
);

--
-- Índices para tablas volcadas
--



--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`ID`);
COMMIT;

ALTER TABLE `asignaturas`
ADD FOREIGN KEY (`ID_PROFESOR`) REFERENCES profesores(`ID`);



--
-- Estructura de tabla para la tabla `alumnos_asignaturas`
--
CREATE TABLE `alumnos_asignaturas` (
  `ID_ALUMNO` int(11) NOT NULL,
  `ID_ASIGNATURA` int(11) NOT NULL,
  `NOTA` int(2)  
);

ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`ID_ALUMNO`,`ID_ASIGNATURA`);
COMMIT;

ALTER TABLE `asignaturas`
ADD FOREIGN KEY (`ID_ALUMNO`) REFERENCES alumnos(`ID`);

ALTER TABLE `asignaturas`
ADD FOREIGN KEY (`ID_ASIGNATURA`) REFERENCES asignaturas(`ID`);


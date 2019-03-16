--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumno` (
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
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`ID`);


INSERT INTO ALUMNO VALUES (1, 'Carlos', 'Padilla', 'Diaz');

COMMIT;

CREATE TABLE `profesor` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL,
  `APELLIDO_1` varchar(250) NOT NULL,
  `APELLIDO_2` varchar(250) NOT NULL,
  `FECHA_ALTA` date
);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`ID`);


INSERT INTO PROFESOR VALUES (1, 'Jacinto', 'Garcia', 'Perez', DATE '2019-03-16');

COMMIT;


CREATE TABLE `materia` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(250) NOT NULL
);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`ID`);
COMMIT;

CREATE TABLE `profesor_materia` (
  `ID_PROFESOR` int(11) NOT NULL,
   `ID_MATERIA` int(11) NOT NULL
);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `profesor_materia`
  ADD PRIMARY KEY (`ID_PROFESOR`, `ID_MATERIA`);
COMMIT;


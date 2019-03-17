<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url"></spring:url>
<spring:url value="/profesores" var="urlprof"></spring:url>
<spring:url value="/materias" var="urlmat"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

CRUDS PUROS

<a href="${ url }">Mostrar alumnos</a><br>

<a href="${ urlprof }">Mostrar Profesores</a><br>

<a href="${ urlmat }">Mostrar Materias</a>
</body>
</html>

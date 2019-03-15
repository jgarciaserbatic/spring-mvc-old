<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="urlA"></spring:url>
<spring:url value="/profesores" var="urlP"></spring:url>
<spring:url value="/materias" var="urlM"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ urlA }">Mostrar alumnos</a>
<a href="${ urlP }">Mostrar Profesores</a>
<a href="${ urlM }">Mostrar Materias</a>

</body>
</html>

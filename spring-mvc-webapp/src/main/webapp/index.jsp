<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url"></spring:url>

<spring:url value="/profesores" var="urlp"></spring:url>

<spring:url value="/materias" var="urlm"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ url }">Mostrar alumnos</a>

<a href="${ urlp }">Mostrar profesores</a>

<a href="${ urlm }">Mostrar materias</a>
</body>
</html>

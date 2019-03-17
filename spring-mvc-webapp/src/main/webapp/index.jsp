<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url"></spring:url>
<spring:url value="/profesores" var="urlProfesor"></spring:url>
<spring:url value="/materias" var="urlMateria"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ url }">Mostrar alumnos</a>
<br>
<a href="${ urlProfesor }">Mostrar profesores</a>
<br>
<a href="${ urlMateria }">Mostrar materias</a>

</body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="urlAlumnos"></spring:url>
<spring:url value="/profesores" var="urlProfesores"></spring:url>
<spring:url value="/asignaturas" var="urlAsignaturas"></spring:url>



<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ urlAlumnos }">Mostrar alumnos</a>
<a href="${ urlProfesores }">Mostrar profesores</a>
<a href="${ urlAsignaturas }">Mostrar Asignaturas</a>
</body>
</html>

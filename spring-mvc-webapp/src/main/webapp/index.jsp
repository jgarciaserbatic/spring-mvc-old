<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url"></spring:url>
<spring:url value="/profesor" var="urlprofesores"></spring:url>
<spring:url value="/materia" var="urlmaterias"></spring:url>
<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ url }">Mostrar alumnos</a>
<a href="${ urlprofesores }">Mostrar profesores</a>
<a href="${ urlmaterias }">Mostrar materias</a>
</body>
</html>

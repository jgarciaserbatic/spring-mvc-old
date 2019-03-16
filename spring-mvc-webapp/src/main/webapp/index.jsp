<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url_alumnos"></spring:url>
<spring:url value="/profesores" var="url_profesores"></spring:url>
<spring:url value="/materias" var="url_materias"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ url_alumnos }">Mostrar alumnos</a>
<br/>
<a href="${ url_profesores }">Mostrar profesores</a> 
<br/>
<a href="${ url_materias }">Mostrar materias</a>
</body>
</html>

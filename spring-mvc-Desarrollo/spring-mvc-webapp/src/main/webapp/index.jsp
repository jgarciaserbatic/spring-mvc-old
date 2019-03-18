<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/alumnos" var="url"></spring:url>

<html>
<body>
<h2>Bienvenido al Curso Java Serbatic</h2>

<a href="${ url }">Mostrar alumnos</a>
</body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="index.welcome" var="welcomeTitle"/>
<spring:message code="login.button.access" var="button"/>
<spring:url value="/alumnos" var="alumnos"></spring:url>
<spring:url value="/profesores" var="profesores"></spring:url>
<spring:url value="/asignaturas" var="asignaturas"></spring:url>



<html>
<body>
<h1>${ welcomeTitle }</h1>
<a href="?lang=es"><spring:message code="header.espanol" /></a> <br>
<a href="?lang=en"><spring:message code="header.english" /></a> <br>
<hr>

<a href="${ alumnos }">Ir a lista de alumnos</a><br>
<a href="${ profesores }">Ir a lista de profesores</a><br>
<a href="${ asignaturas }">Ir a lista de asignaturas</a><br>
 
</body>
</html>

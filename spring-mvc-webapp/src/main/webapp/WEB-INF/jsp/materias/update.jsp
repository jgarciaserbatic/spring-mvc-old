<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h>Actualizar materias</h>
<br><br>
<form:form modelAttribute="materia" action="/spring-mvc-webapp/materias/updateMateria"> 

	<form:hidden path="id"/>

	<label>Nombre</label>
	<form:input type="text" path="nombre" value="${materia.nombre}" />
	<br>
	
	<label>Fecha examen</label>
	
		<fmt:parseDate value="${materias.fechaExamen}" pattern="yyyy-MM-dd" var="myDate"/>					
	<form:input type="date" path="fechaExamen" value="${myDate}" />
	<br>
	
	<form:button type="submit">Update</form:button>

</form:form>

</body>
</html>
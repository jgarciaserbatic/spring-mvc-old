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

<h>add materias</h>
<br><br>
<form:form modelAttribute="materia" action="/spring-mvc-webapp/materias/addMateria"> 

	<form:hidden path="id"/>

	<label>Nombre</label>
	<form:input type="text" path="nombre" />
	<br>
	
	<label>Fecha examen</label>
	<form:input type="date" path="fechaExamen" />
	<br>

	<form:button type="submit">Add</form:button>

</form:form>

</body>
</html>
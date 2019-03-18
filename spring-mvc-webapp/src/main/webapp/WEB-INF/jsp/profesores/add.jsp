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

<h>add profesores</h>
<br><br>
<form:form modelAttribute="profesor" action="/spring-mvc-webapp/profesores/addProfesor"> 

	<form:hidden path="id"/>

	<label>Nombre</label>
	<form:input type="text" path="nombre" />
	<br>
	
	<label>Apellido 1</label>
	<form:input type="text" path="apellido1" />
	<br>
	
	<label>Apellido 2</label>
	<form:input type="text" path="apellido2" />
	<br>
	
	<label>Telefono</label>
	<form:input type="text" path="telefono" />
	<br>
	
	<label>Materia: por implementar</label>

	
	<form:button type="submit">Add</form:button>

</form:form>

</body>
</html>
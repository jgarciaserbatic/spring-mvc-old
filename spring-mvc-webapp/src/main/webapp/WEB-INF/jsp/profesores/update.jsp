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

<h>Actualizar profesores</h>
<br><br>
<form:form modelAttribute="profesor" action="/spring-mvc-webapp/profesores/updateProfesor"> 

	<form:hidden path="id"/>

	<label>Nombre</label>
	<form:input type="text" path="nombre" value="${profesor.nombre}" />
	<br>
	
	<label>Apellido 1</label>
	<form:input type="text" path="apellido1" value="${profesor.apellido1}" />
	<br>
	
	<label>Apellido 2</label>
	<form:input type="text" path="apellido2" value="${profesor.apellido2}" />
	<br>
	
	<label>Telefono</label>
	<form:input type="text" path="telefono" value="${profesor.telefono}" />
	<br>
	
	<label>Materia</label>
	<form:input type="number" path="materia" value="${profesor.materia}" />
	<br>
	
	<form:button type="submit">Update</form:button>

</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<th>Id</th>
			<th><spring:message code="profesores.nombre"></spring:message></th>
			<th><spring:message code="profesores.apellido1"></spring:message></th>
			<th><spring:message code="profesores.apellido2"></spring:message></th>
			<th><spring:message code="profesores.options"></spring:message></th>
		</thead>
		<tbody>
			<c:forEach items="${ profesoresList }" var="profesor">
				<tr>
					<td>${profesor.id}</td>
					<td>${profesor.nombre}</td>
					<td>${profesor.apellido1}</td>
					<td>${profesor.apellido2}</td>
					<td><a href="<spring:url value="/profesores/delete/${ profesor.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/profesores/update/${ profesor.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<spring:url value="/profesores" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="profesores.options.add"></spring:message></button>
	</form:form>
	</table>
</body>
</html>
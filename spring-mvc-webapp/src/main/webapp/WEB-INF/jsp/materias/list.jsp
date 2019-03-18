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
			<th><spring:message code="materias.nombre"></spring:message></th>
			<th><spring:message code="materias.options"></spring:message></th>
		</thead>
		<tbody>
			<c:forEach items="${ materias }" var="materia">
				<tr>
					<td>${ materia.id }</td>
					<td>${ materia.nombre }</td>
					<td><a href="<spring:url value="/materias/delete/${ materia.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/materias/update/${ materia.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<spring:url value="/materias" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="materias.options.add"></spring:message></button>
	</form:form>
	</table>
</body>
</html>
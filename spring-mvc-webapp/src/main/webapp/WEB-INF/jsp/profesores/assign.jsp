<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="profesores.nombre"></spring:message></th>
		<th><spring:message code="profesores.apellido1"></spring:message></th>
		<th><spring:message code="profesores.apellido2"></spring:message></th>
		<th><spring:message code="profesores.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ profesores }" var="profesor">
				<tr>
					<td>${profesor.id}</td>
					<td>${profesor.name}</td>
					<td>${profesor.surname1}</td>
					<td>${profesor.surname2}</td>
					<td>
						<a href="<spring:url value="/profesores/assign/${ profesor.id }/${ materia }" ></spring:url>">Asignar Materia</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/profesores/" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="profesores.options.add"></spring:message></button>
	</form:form>
</table>
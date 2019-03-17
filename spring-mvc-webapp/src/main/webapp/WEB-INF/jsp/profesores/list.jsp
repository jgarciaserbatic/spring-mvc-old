<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="profesores.nombre"></spring:message></th>
		<th><spring:message code="profesores.apellido1"></spring:message></th>
		<th><spring:message code="profesores.apellido2"></spring:message></th>
		<th><spring:message code="profesores.telefono"></spring:message></th>
		<th><spring:message code="profesores.materia"></spring:message></th>
		<th><spring:message code="profesores.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ listProfesores }" var="profesores">
				<tr>
					<td>${profesores.id}</td>
					<td>${profesores.nombre}</td>
					<td>${profesores.apellido1}</td>
					<td>${profesores.apellido2}</td>
					<td>${profesores.telefono}</td>
					<td>${profesores.materias}</td>
					<td>
						<a href="<spring:url value="/profesores/delete/${ profesores.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/profesores/update/${ profesores.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/profesores" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="profesores.options.add"></spring:message></button>
	</form:form>
</table>
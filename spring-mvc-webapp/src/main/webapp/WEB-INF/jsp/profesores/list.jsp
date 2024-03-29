<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="profesores.nombre"></spring:message></th>
		<th><spring:message code="profesores.apellido1"></spring:message></th>
		<th><spring:message code="profesores.apellido2"></spring:message></th>
		<th>Materias</th>
		<th><spring:message code="profesores.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ profesores }" var="profesor">
				<tr>
					<td>${profesor.id}</td>
					<td>${profesor.nombre}</td>
					<td>${profesor.apellido1}</td>
					<td>${profesor.apellido2}</td>
					<td>
						<c:forEach items="${profesor.materias}" var="materia">
							<c:out value="${materia.nombre}"></c:out> - 
						</c:forEach> 
					</td>
					<td>
						<a href="<spring:url value="/profesores/delete/${ profesor.id }" ></spring:url>">Eliminar</a>
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
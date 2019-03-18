<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
	<tr>
		<th>Id</th>
		<th><spring:message code="asignaturas.nombre"></spring:message></th>
		<th><spring:message code="asignaturas.descripcion"></spring:message></th>

	<tr>
	</thead>
	<tbody>
		
			<c:forEach items="${ asignaturas }" var="asignatura">
				<tr>
					<td>${asignatura.id}</td>
					<td>${asignatura.nombre}</td>
					<td>${asignatura.descripcion}</td>
					<td>
						<a href="<spring:url value="/asignaturas/delete/${ asignatura.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/asignaturas/update/${ asignatura.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/asignaturas" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="asignaturas.options.add"></spring:message></button>
	</form:form>
</table>
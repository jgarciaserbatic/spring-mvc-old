<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<h1><spring:message code="alumno.h1.listado"></spring:message>:</h1>
<br>
<a href="${pageContext.request.contextPath}">Volver</a>


<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="alumnos.nombre"></spring:message></th>
		<th><spring:message code="alumnos.apellido1"></spring:message></th>
		<th><spring:message code="alumnos.apellido2"></spring:message></th>
		<th><spring:message code="alumnos.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ alumnos }" var="alumno">
				<tr>
					<td>${alumno.id}</td>
					<td>${alumno.nombre}</td>
					<td>${alumno.apellido1}</td>
					<td>${alumno.apellido2}</td>
					<td>
						<a href="<spring:url value="/alumnos/delete/${ alumno.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/alumnos/update/${ alumno.id }" ></spring:url>">Actualizar</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/alumnos" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="alumnos.options.add"></spring:message></button>
	</form:form>
</table>
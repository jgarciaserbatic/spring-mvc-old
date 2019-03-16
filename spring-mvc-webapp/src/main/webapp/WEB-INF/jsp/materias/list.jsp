<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
	<thead>
		<th>Id</th>
		<th><spring:message code="materia.nombre"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${ materia }" var="materia">
				<tr>
					<td>${materia.id}</td>
					<td>${materia.nombre}</td>
					<td>
						<a href="<spring:url value="/materia/delete/${ materia.id }" ></spring:url>">Eliminar</a>
						<a href="<spring:url value="/materia/update/${ materia.id }" ></spring:url>">Actualizar</a>
						<a href="<spring:url value="/materia/setprofesor/${ materia.id }" ></spring:url>">Asignar a profesor</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
	
	<spring:url value="/materia" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="materia.options.add"></spring:message></button>
	</form:form>
</table>
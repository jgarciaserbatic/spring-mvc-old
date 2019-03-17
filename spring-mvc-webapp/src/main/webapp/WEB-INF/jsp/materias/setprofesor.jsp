<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<spring:url value="asignar/${profesor.id}" var="url"></spring:url>

<form:form modelAttribute="profesor" action="${ url }" >
<input type="hidden" value="${materia}" name="materiaid"/>
<table>
	<thead>
		<th><spring:message code="profesor.nombre"></spring:message></th>
		<th><spring:message code="profesor.apellido1"></spring:message></th>
		<th><spring:message code="profesor.apellido2"></spring:message></th>
		<th><spring:message code="profesor.options"></spring:message></th>
	</thead>
	<tbody>
		
			<c:forEach items="${profesor}" var="profesor">
				<tr>
					<input type="hidden" value="${profesor.id}" name="profid"/>
					<td>${profesor.nombre}</td>
					<td>${profesor.apellido1}</td>
					<td>${profesor.apellido2}</td>
					<td>
					</td>
					<a href="${url}">Asingar materia</a>
				</tr>
			</c:forEach>

	</tbody>
</table>
</form:form>
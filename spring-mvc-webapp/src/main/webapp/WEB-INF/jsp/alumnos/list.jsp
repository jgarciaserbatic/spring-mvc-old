<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:message code="options.update" var="update"/>
<spring:message code="options.delete" var="delete"/>


<%-- <a href="?lang=es_ES"><spring:message code="header.espanol" /></a> <br> --%>
<%-- <a href="?lang=en_EN"><spring:message code="header.english" /></a> <br> --%>
<table>

	<thead>
	<tr>
		<th>Id</th>
		<th><spring:message code="alumnos.nombre"></spring:message></th>
		<th><spring:message code="alumnos.apellido1"></spring:message></th>
		<th><spring:message code="alumnos.apellido2"></spring:message></th>
		<th><spring:message code="alumnos.mail"></spring:message></th>
		<th><spring:message code="alumnos.options"></spring:message></th>
		
	<tr>
	</thead>
	<tbody>
		
			<c:forEach items="${ alumnos }" var="alumno">
				<tr>
					<td>${alumno.id}</td>
					<td>${alumno.nombre}</td>
					<td>${alumno.apellido1}</td>
					<td>${alumno.apellido2}</td>
					<td>${alumno.mail}</td>
					<td>
						<a href="<spring:url value="/alumnos/delete/${ alumno.id }" ></spring:url>">${ update }</a>
						<a href="<spring:url value="/alumnos/update/${ alumno.id }" ></spring:url>">${ delete }</a>
					</td>
				</tr>
			</c:forEach>
		
	</tbody>
	
	<spring:url value="/alumnos" var="url"></spring:url>
	<form:form action="${ url }" >
		<button type="submit"><spring:message code="alumnos.options.add"></spring:message></button>
	</form:form>
</table>
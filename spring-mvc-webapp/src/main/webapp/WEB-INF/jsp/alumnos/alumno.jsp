<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url value="/alumnos/new" var="url"></spring:url>
<spring:message code="alumnos.new.title" var="insertTitle"/>
<spring:message code="alumnos.update.title" var="updateTitle"/>
<c:choose >
	<c:when test="${ alumno.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="alumno" action="${ url }" >

	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="alumnos.nombre"></spring:message>: <form:input path="nombre"/><form:errors path="nombre"></form:errors><br/>
	<spring:message code="alumnos.apellido1"></spring:message><form:input path="apellido1"/><form:errors path="apellido1"></form:errors><br/>
	<spring:message code="alumnos.apellido2"></spring:message><form:input path="apellido2"/><br/>
	
	<form:button value="submit">Enviar</form:button>
</form:form>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Crear alguna taglib para la practica -->


<spring:url value="/alumnos/new" var="url"></spring:url>
<spring:message code="alumnos.new.title" var="insertTitle"/>
<spring:message code="alumnos.update.title" var="updateTitle"/>
<spring:message code="alumnos.button.update" var="updateButton"/>
<spring:message code="alumnos.button.save" var="saveButton"/>
<c:choose >
	<c:when test="${ alumno.id == null}">
		<c:set value="${ insertTitle }" var="title" />
		<c:set value="${ saveButton }" var="button" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
		<c:set value="${ updateButton }" var="button" />
	</c:otherwise>
</c:choose>

<!-- comand funcionaria igual que modelAttribute -->
<form:form modelAttribute="alumno" action="${ url }" > 

	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="alumnos.nombre"></spring:message>: <form:input path="nombre" /><form:errors path="nombre" /><br/>
	<spring:message code="alumnos.apellido1"></spring:message><form:input path="apellido1"/><form:errors path="apellido1" /><br/>
	<spring:message code="alumnos.apellido2"></spring:message><form:input path="apellido2"/><form:errors path="apellido2" /><br/>
	<spring:message code="alumnos.mail"></spring:message><form:input path="mail"/><form:errors path="mail" /><br/>
			
	
	<form:button value="submit">${ button }</form:button>
</form:form>
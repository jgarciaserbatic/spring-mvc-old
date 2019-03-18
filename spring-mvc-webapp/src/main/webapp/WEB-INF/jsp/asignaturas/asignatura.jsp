<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Crear alguna taglib para la practica -->

<spring:url value="/asignaturas/new" var="url"></spring:url>
<spring:message code="asignaturas.new.title" var="insertTitle"/>
<spring:message code="asignaturas.update.title" var="updateTitle"/>
<spring:message code="asignaturas.button.update" var="updateButton"/>
<spring:message code="asignaturas.button.save" var="saveButton"/>
<c:choose >
	<c:when test="${ asignatura.id == null}">
		<c:set value="${ insertTitle }" var="title" />
		<c:set value="${ saveButton }" var="button" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
		<c:set value="${ updateButton }" var="button" />
	</c:otherwise>
</c:choose>

<!-- comand funcionaria igual que modelAttribute -->
<form:form modelAttribute="asignatura" action="${ url }" > 
	
	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="asignaturas.nombre"></spring:message>: <form:input path="nombre" /><br/>
	<spring:message code="asignaturas.descripcion"></spring:message>: <form:input path="descripcion" /><br/>		
	<form:button value="submit">${ button }</form:button>
</form:form>
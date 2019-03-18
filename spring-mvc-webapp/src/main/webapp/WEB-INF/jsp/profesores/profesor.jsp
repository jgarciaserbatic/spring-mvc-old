<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Crear alguna taglib para la practica -->


<spring:url value="/profesores/new" var="url"></spring:url>
<spring:message code="profesores.new.title" var="insertTitle"/>
<spring:message code="profesores.update.title" var="updateTitle"/>
<spring:message code="profesores.button.update" var="updateButton"/>
<spring:message code="profesores.button.save" var="saveButton"/>
<c:choose >
	<c:when test="${ profesor.id == null}">
		<c:set value="${ insertTitle }" var="title" />
		<c:set value="${ saveButton }" var="button" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
		<c:set value="${ updateButton }" var="button" />
	</c:otherwise>
</c:choose>

<!-- comand funcionaria igual que modelAttribute -->
<form:form modelAttribute="profesor" action="${ url }" > 
	
	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="profesores.nombre"></spring:message>: <form:input path="nombre" /><br/>
	<spring:message code="profesores.apellido1"></spring:message><form:input path="apellido1"/><br/>
	<spring:message code="profesores.apellido2"></spring:message><form:input path="apellido2"/><br/>
	<spring:message code="profesores.direccion"></spring:message><form:input path="direccion"/><br/>
	<spring:message code="profesores.asignaturas" ></spring:message><br>

<%-- 	<form:select path="asignaturasElegidas"> --%>
<%--      	<form:option value="-" label="--Selecciona tus asignaturas"/> --%>
<%--       	<form:options items="${asignaturas}" itemValue="id" itemLabel="nombre"/> --%>
<%--  	</form:select>				 --%>
		
	<form:checkboxes items="${asignaturas}" path="asignaturasElegidas" itemLabel="nombre" itemValue="id" title="Asignaturas"/>
	<br/>
	
	<form:button value="submit">${ button }</form:button>
</form:form>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/profesores/new" var="url"></spring:url>
<spring:message code="profesores.new.title" var="insertTitle" />
<spring:message code="profesores.update.title" var="updateTitle" />
<spring:url value="/" var="urlInicio"></spring:url>
<spring:url value="/profesores" var="urlP"></spring:url>
<c:choose>
	<c:when test="${ profesor.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="profesor" action="${ url }">

	<h1>${ title }</h1>
	<form:hidden path="id" />
	<spring:message code="profesores.nombre"></spring:message>: <form:input
		path="nombre" />
	<br />
	<spring:message code="profesores.apellido1"></spring:message>
	<form:input path="apellido1" />
	<br />
	<spring:message code="profesores.apellido2"></spring:message>
	<form:input path="apellido2" />
	<br />
<%-- 	<spring:message code="materias.listMaterias"></spring:message> --%>
<%-- 	<form:input path="Materias" /> --%>
	<br />

	<form:button value="submit">Enviar</form:button>
	
	<a href="${ urlP }">Atrás</a>
	<a href="${ urlInicio }">Inicio</a>
	
	
</form:form>
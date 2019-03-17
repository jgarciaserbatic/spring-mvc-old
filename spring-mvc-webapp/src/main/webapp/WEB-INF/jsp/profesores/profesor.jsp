<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/profesores/new" var="url"></spring:url>
<spring:message code="profesores.new.title" var="insertTitle" />
<spring:message code="profesores.update.title" var="updateTitle" />
<c:choose>
	<c:when test="${ profesorEntrada.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="profesorEntrada" action="${ url }">

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
	<spring:message code="profesores.fechaAlta"></spring:message>
	<form:input type="date" path="fechaAlta" />
	<br />
	<spring:message code="profesores.materias"></spring:message>
	<br />
	<form:checkboxes path="materias" values="materias" items="${ materias }" multiple="true" itemLabel="nombre"/>
	


	<form:button value="submit">Enviar</form:button>
</form:form>
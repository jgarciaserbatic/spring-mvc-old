<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url value="/materias/new" var="url"></spring:url>
<spring:message code="materias.new.title" var="insertTitle"/>
<spring:message code="materias.update.title" var="updateTitle"/>
<c:choose >
	<c:when test="${ materia.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="materia" action="${ url }" >
	
	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="materias.nombre"></spring:message>: <form:input path="nombre" /><br/>
	<spring:message code="materias.descripcion"></spring:message><form:input path="descripcion"/><br/>
	<spring:message code="materias.profesores"></spring:message><form:input path="profesores"/><br/>
	
	<form:button value="submit">Enviar</form:button>
</form:form>
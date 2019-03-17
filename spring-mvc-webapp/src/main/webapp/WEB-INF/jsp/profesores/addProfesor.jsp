<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url value="/profesores/new" var="url"></spring:url>
<spring:message code="profesores.new.title" var="insertTitle"/>
<spring:message code="profesores.update.title" var="updateTitle"/>
<c:choose >
	<c:when test="${ profesores.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="profesores" action="${ url }" >
	
	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="profesores.nombre"></spring:message>: <form:input path="name" /><br/>
	<spring:message code="profesores.apellido1"></spring:message><form:input path="surname1"/><br/>
	<spring:message code="profesores.apellido2"></spring:message><form:input path="surname2"/><br/>
	
	<form:button value="submit">Enviar</form:button>
</form:form>
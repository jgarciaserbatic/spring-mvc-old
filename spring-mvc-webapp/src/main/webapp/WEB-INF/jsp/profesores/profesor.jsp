<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url value="/profesor/new" var="url"></spring:url>
<spring:message code="profesor.new.title" var="insertTitle"/>
<spring:message code="profesor.update.title" var="updateTitle"/>
<c:choose >
	<c:when test="${ profesor.id == null}">
		<c:set value="${ insertTitle }" var="title" />
	</c:when>
	<c:otherwise>
		<c:set  value="${ updateTitle }" var="title" />
	</c:otherwise>
</c:choose>

<form:form modelAttribute="profesor" action="${ url }" >
	
	<h1>${ title }</h1>
	<form:hidden path="id"/>
	<spring:message code="profesor.nombre"></spring:message>: <form:input path="nombre" /><br/>
	<spring:message code="profesor.apellido1"></spring:message><form:input path="apellido1"/><br/>
	<spring:message code="profesor.apellido2"></spring:message><form:input path="apellido2"/><br/>
	
	<form:button value="submit">Enviar</form:button>
</form:form>


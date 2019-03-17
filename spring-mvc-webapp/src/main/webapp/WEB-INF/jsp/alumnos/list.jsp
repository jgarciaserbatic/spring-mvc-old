<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="./static/css/bootstrap.css" var="bootstrap"></spring:url>
<spring:url value="./static/css/bootstrap.css" var="css"></spring:url>


<html>
<head>
<link href="${bootstrap}" rel="stylesheet"></link>
<link href="${css}" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="lead">Lista de alumnos</span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido 1</th>
						<th>Apellido 2</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${alumnos}" var="alumno">
						<tr>
							<td>${alumno.id}</td>
							<td>${alumno.nombre}</td>
							<td>${alumno.apellido1}</td>
							<td>${alumno.apellido2}</td>
							<td><a href="<c:url value='/alumnos/update/${alumno.id}' />"
								class="btn btn-success custom-width">Modificar</a></td>
							<td><a href="<c:url value='/alumnos/delete/${alumno.id}' />"
								class="btn btn-danger custom-width">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<spring:url value="/alumnos" var="url"></spring:url>
			<form:form action="${ url }">
				<button type="submit">
					<spring:message code="alumnos.options.add"></spring:message>
				</button>
			</form:form>
		</div>
	</div>
</body>
</html>
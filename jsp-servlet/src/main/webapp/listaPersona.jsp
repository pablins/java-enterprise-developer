<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de Personas</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" 
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
		  crossorigin="anonymous">
</head>
<body>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr class="info">
					<th>ID</th>
					<th>NOMBRES</th>
					<th>NOMBRE COMPLETO</th>
					<th colspan="2">ACCIÓN</th>
				</tr>
			</thead>
			<tbody>
				<!-- El siguiente código es JSTL y representa un for -->
				<!-- El "$ { } " se conoce como EL, expresion language  -->
				<c:forEach items="${lstPersonas}" var="per">
					<tr class="active">
						<td><c:out value="${per.id}"/></td>
						<td><c:out value="${per.nombres}" /> </td>
						<td><c:out value="${per.nombreCompleto}"/></td>
						<td><a href="PersonaController?accion=EDITAR&id=<c:out value="${per.id}"/>">Actualizar</a></td>
						<td><a href="PersonaController?accion=ELIMINAR&id=<c:out value="${per.id}"/>">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<a class="btn-primary" href="PersonaController?accion=INSERTAR">Agregar con Link</a>
	
	<form action="PersonaController" method="get">
		<input type="hidden" name="accion" value="INSERTAR" />
		<button class="btn-primary">Agregar</button>
	</form>
</body>
</html>
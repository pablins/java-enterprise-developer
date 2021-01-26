<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Permite realizar la navegación entre un JSP a otro JSP o un JSP a un servlet -->
	<jsp:forward page="/PersonaController?accion=LISTAR"></jsp:forward><!-- Realiza un llamado al por method GET -->

</body>
</html>
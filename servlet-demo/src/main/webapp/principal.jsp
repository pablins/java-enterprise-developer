<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		if("mitocode".equals(usuario) && "code".equals(clave)) {
			out.println("Bienvenido " + usuario);
		} else {
			out.println("usuario/clave incorrecto");
		}
	%>

</body>
</html>
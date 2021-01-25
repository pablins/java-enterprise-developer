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
		//Esto es un SCRIPTLESS
		out.println("Tú dirección IP es: " + request.getRemoteAddr());
	%>
	
	<form action="principal.jsp" method="post">
		Usuario <input type="text" name="usuario"/>
		Clave <input type="text" name="clave"/> <br/>
		<input type="submit" value="Iniciar">
	</form>

</body>
</html>
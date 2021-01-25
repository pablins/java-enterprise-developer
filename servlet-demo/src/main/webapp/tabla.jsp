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
		String parametroNumero = request.getParameter("numero");
		int numero = 0;
		
		if(parametroNumero != null) {
			numero = Integer.parseInt(parametroNumero);
		} else {
			
	%>
	
	<%
			//establecemos un numero por default
			numero = 99;
		}
	
	%>
	
	<%="Tabla del " + numero %>
	
	<br/>
	
	<%
		for(int i=0; i<=12; i++) {
			out.println(numero + " * " + i + " = ");
			out.println((numero*i));
			out.println("<br/>");//los "saltos de línea" en html es un <br>
		}
	%>

</body>
</html>
package com.mitocode.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * -El atributo "name", es el homologo de especificar en el tag "<servlet-name>" del archivo WEB-INF/web.xml
 * -El atributo "description" es para especificar al programador la utilidad del servlet
 * -El atributo "urlPatterns" son las urls que el servlet va a interceptar y hacerse cargo de su gestión
 * -El atributo "initParams" corresponde a los valores por defecto y se asigna apenas se cree el servlet. 
 */
@WebServlet(name = "ParameterServlet", 
			description = "Este es un servlet de ejemplo para aprender sobre parametros",
			urlPatterns = {"/parameter", "/parameters"},
			initParams = {
					@WebInitParam(name = "param1", value = "Mito"),
					@WebInitParam(name = "param2", value = "Code")
			})
public class ParameterHttpServlet extends HttpServlet {

	/*
	 * Se puede probar desde el navegador con la URL: 
	 * -http://localhost:8080/servlet-demo/parameter?param1=Pablo&param2=Rodriguez
	 * -http://localhost:8080/servlet-demo/parameters?param1=Pablo&param2=Rodriguez
	 * -http://localhost:8080/servlet-demo/parameter
	 * -http://localhost:8080/servlet-demo/parameters
	 * -http://localhost:8080/servlet-demo/parameters?param1=Pablo
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Forma de capturar los parametros que vienen de la URL
		String var1 = req.getParameter("param1");
		String var2 = req.getParameter("param2");
		
		//seteamos valores por los valores por defecto creaods en el tag @WebServlet
		if(var1 == null) {
			var1 = getInitParameter("param1");
		}

		if(var2 == null) {
			var2 = getInitParameter("param2");
		}
		
		resp.getWriter().write("Parámetros en URL. param1: " + var1 + ", param2: " + var2);		

	}
	
	

}

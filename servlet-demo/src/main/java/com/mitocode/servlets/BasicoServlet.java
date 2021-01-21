package com.mitocode.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasicoServlet extends GenericServlet {//Es necesario agregar la dependencia de "Java EE"

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//forma como se solia trabajar anteriormente, era necesario generar todo el html que se mostraría en la página
		res.getWriter().write("<html><head></head><body>Generic Servlet - MitoCode</body></html>");
	}

}

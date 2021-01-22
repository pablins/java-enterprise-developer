package com.mitocode.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mito")//podriamos acceder con la URL: http://localhost:8080/servlet-demo/loquesea.mito, ya no hay necesidad de registrarlo en web.xml
public class AnotacionServlet extends HttpServlet {

	//El método GET se podría probar desde un navegador colocando la URL: http://localhost:8080/servlet-demo/loquesea.mito
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><head></head><body>AnotacionServlet [GET] - MitoCode</body></html>");
	}

	//Para probar los métodos POST, PUT y DELETE podriamos usar el programa Postman colocando la URL: http://localhost:8080/servlet-demo/loquesea.mito y seleccionando el tipo de method
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><head></head><body>AnotacionServlet [POST] - MitoCode</body></html>");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><head></head><body>AnotacionServlet [PUT] - MitoCode</body></html>");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><head></head><body>AnotacionServlet [DELETE] - MitoCode</body></html>");
	}
	

}

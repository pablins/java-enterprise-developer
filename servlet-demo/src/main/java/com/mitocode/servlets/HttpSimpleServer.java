package com.mitocode.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpSimpleServer extends HttpServlet {//Forma que salio luego para hacer las cosas, dado que tienes métodos para peticiones get, post, put, etc

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<html><head></head><body>HttpServlet [GET] - MitoCode</body></html>");
	}
	
	

}

package com.mitocode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.dao.PersonaDAOImpl;
import com.mitocode.model.Persona;

@WebServlet("/PersonaController")
public class PersonaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IPersonaDAO dao = new PersonaDAOImpl();
		
		String redireccion = "";
		String accion = req.getParameter("accion");
		
		if("ELIMINAR".equalsIgnoreCase(accion)) {
			redireccion = "/listaPersona.jsp";
			int id = Integer.parseInt(req.getParameter("id"));
			
			dao.eliminar(id);
			req.setAttribute("lstPersonas", dao.listarTodos());
			
		} else if("EDITAR".equalsIgnoreCase(accion)) {
			redireccion = "/persona.jsp";
			int id = Integer.parseInt(req.getParameter("id"));
			
			Persona persona = dao.listarPorId(id);
			req.setAttribute("persona", persona);
			
		} else if("INSERTAR".equalsIgnoreCase(accion)) {
			redireccion = "/persona.jsp";
			
		} else {//Por ejemplo cuando es "LISTAR"
			redireccion = "/listaPersona.jsp";
			req.setAttribute("lstPersonas", dao.listarTodos());
			
		}
		
		//Ejecuta la navegación pasando la información de requeste y response
		RequestDispatcher vista = req.getRequestDispatcher(redireccion);
		vista.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IPersonaDAO dao = new PersonaDAOImpl();
		
		Persona persona = new Persona();
		persona.setNombres(req.getParameter("nombres"));
		persona.setApellidos(req.getParameter("apellidos"));
		
		String id = req.getParameter("id");
		
		if(id == null || id.isEmpty()) {//inserto el registro
			dao.agregar(persona);
		} else {//actualizo el registro
			persona.setId(Integer.parseInt(id));
			dao.actualizar(persona);
		}
		
		RequestDispatcher vista = req.getRequestDispatcher("/listaPersona.jsp");
		req.setAttribute("lstPersonas", dao.listarTodos());
		vista.forward(req, resp);
	}
	
}

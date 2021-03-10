package com.mitocode.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

/**
 * @author Pablo Rodriguez
 * Servlet encargado de devolver las imagenes de la persona que reciba por id en la URL.
 * 
 * Aunque tambien se podría usar el componente de primefaces para download
 */
@WebServlet("/imagen/*")//captura las URL que tenga "/imagen/<CUALQUIER_CONTENIDO>"
public class ImageServlet extends HttpServlet {
	
	@Inject
	private IPersonaService service;

	/* 
	 * De acuerdo al ID recibido, consulta en la DB y devuelve la foto que encuentre
	 */
	//Sobreescribimos el método "doGet" debido a que es una petición sobre una URL, en caso que fuese un submit sería el doPost 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String capturaIdPersona = req.getPathInfo().substring(1); //Por ejemplo se espera un path como: "/imagen/1", El getPathInfo me devuelve "/1", por tanto se hace un substring(1) para que devuelva solo el id que sería: "1"
			
			if(capturaIdPersona != null && !capturaIdPersona.equalsIgnoreCase("")) {
				int id = Integer.parseInt(capturaIdPersona);
				
				//creamos un objeto persona con el id recibido
				Persona persona = new Persona();
				persona.setId(id);
				
				//llamamos el servicio que me devuelve toda la información de la persona
				persona = service.listarPorId(persona);//sobreescribimos el objeto persona con la inforamción recibida
				
				if(persona.getFoto() != null) {
					//Parametros para que no se quede pegada la foto despues de actualizarla en el mantenedor de persona (además, se crea bean en faces-config y se llama desde la url que se le coloca en la página personas.xhtml, aunque en pruebas realizadas este parametro adicional no era tan necesario)
					//Debido a que el navegador tiende a guardar en su cache la respuesta que ya tenía
					resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//HTTP 1.1
					resp.setHeader("Pragma", "no-cache");//HTTP 1.0
					resp.setDateHeader("Expires", 0);//Proxies
					
					resp.setContentType(getServletContext().getMimeType("image/jpg"));//establecemos el formato de la respuesta del archivo a devolver
					resp.setContentLength(persona.getFoto().length);//tamaño de la foto
					resp.getOutputStream().write(persona.getFoto());//escribimos la foto
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

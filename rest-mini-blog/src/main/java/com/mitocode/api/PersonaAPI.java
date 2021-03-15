package com.mitocode.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mitocode.model.Persona;

//Indica que es una salida de un servicio REST
@Path("/personas")
public class PersonaAPI {

	//Se debe indicar bajo que operación se va a trabajar
	@GET
	@Path("/saludar")//le podemos especificar que para entrar la recurso debe pasar por: "rest/personas/saludar", es decir: "http://localhost:8080/rest-mini-blog/rest/personas/saludar"
	public String saludar() {
		return "Hola Coders!!!";
	}
	
	@GET
	@Path("/objeto")
	//Indicamos que produzca una salida en JSON
	//Si no se hace obtendremos: Could not find MessageBodyWriter for response object of type: com.mitocode.model.Persona of media type: text/html;charset=UTF-8
	@Produces("application/json")//puede ser json, xml o genericos como archivos, etc
	//@Produces("application/xml")
	public Persona ejemploRetornarObjeto() {
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("Pablins");
		
		return persona;
	}
}

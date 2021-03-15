package com.mitocode.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//Indica que es una salida de un servicio REST
@Path("/personas")
public class PersonaAPI {

	//Se debe indicar bajo que operación se va a trabajar
	@GET
	@Path("/saludar")//le podemos especificar que para entrar la recurso debe pasar por: "rest/personas/saludar", es decir: "http://localhost:8080/rest-mini-blog/rest/personas/saludar"
	public String saludar() {
		return "Hola Coders!!!";
	}
	
}

package com.mitocode.service.impl;

import java.io.Serializable;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mitocode.service.IPersonaService;

@WebService//marcamos la clase para ser usada como web service. Le indica al servidor que se está creando un servicio web y debe publicarlo en una dirección
public class PersonaServiceImpl implements IPersonaService, Serializable {

	@WebMethod//Le indica que es una operación del servicio
	@Override
	public String saludar() {
		return "Hola Coders!!!";
	}

	@WebMethod(operationName="saludar2")//establecemos un nombre dado que por defecto JAX-WS nos colocará el nombre del método y no pueden existir 2 operaciones con el mismo nombre
	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

}

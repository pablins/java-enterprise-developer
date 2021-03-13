package com.mitocode.service.impl;

import java.io.Serializable;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mitocode.service.IPersonaService;

@WebService//marcamos la clase para ser usada como web service. Le indica al servidor que se est� creando un servicio web y debe publicarlo en una direcci�n
public class PersonaServiceImpl implements IPersonaService, Serializable {

	@WebMethod//Le indica que es una operaci�n del servicio
	@Override
	public String saludar() {
		return "Hola Coders!!!";
	}

}

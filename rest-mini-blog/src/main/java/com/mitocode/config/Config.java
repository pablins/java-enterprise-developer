package com.mitocode.config;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Indicamos el prefijo que debemos tener para acceder a todos los servicios REST
@ApplicationPath("/rest")//Suelen colocarle 'rest' o 'api'
public class Config extends Application {

	/*
	 * Busca todas las clases donde tenga la anotación de servicio REST
	 * (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}
	
	

}

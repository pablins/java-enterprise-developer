package com.mitocode.dao;

import javax.ejb.Local;

import com.mitocode.model.Persona;

@Local//Indica que cuando se despliegue la aplicaci�n, los m�todos van a estar en la misma JVM donde ser�n consumidos
public interface IPersonaDAO extends ICRUD<Persona> {//extendemos las operaciones comunes
	
	//definimos las operaciones particulares

}

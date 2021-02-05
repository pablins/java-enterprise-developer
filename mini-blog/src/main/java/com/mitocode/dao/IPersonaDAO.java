package com.mitocode.dao;

import javax.ejb.Local;

import com.mitocode.model.Persona;

@Local//Indica que cuando se despliegue la aplicación, los métodos van a estar en la misma JVM donde serán consumidos
public interface IPersonaDAO extends ICRUD<Persona> {//extendemos las operaciones comunes
	
	//definimos las operaciones particulares

}

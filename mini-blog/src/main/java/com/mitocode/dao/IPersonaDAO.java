package com.mitocode.dao;

import java.util.List;

import javax.ejb.Local;

import com.mitocode.model.Persona;

@Local//Indica que cuando se despliegue la aplicación, los métodos van a estar en la misma JVM donde serán consumidos
public interface IPersonaDAO {
	
	Integer registrar(Persona per) throws Exception;
	
	Integer modificar(Persona per) throws Exception;

	Integer eliminar(Persona per) throws Exception;
	
	List<Persona> listar() throws Exception;
	
	Persona listarPorId(Persona per) throws Exception;

}

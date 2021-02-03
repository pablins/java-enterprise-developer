package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Named//Le indicamos a la clase que debe ser gestionada por el contenedor JEE
public class PersonaDAOImpl implements IPersonaDAO, Serializable {

	public Integer registrar(Persona per) throws Exception {
		System.out.println("Registrando a: " + per.getNombres());
		return 1;
	}

	public Integer modificar(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer eliminar(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> listar() throws Exception {
		List<Persona> lista = new ArrayList<>();
		
		Persona per = new Persona();
		per.setIdPersona(1);
		per.setNombres("Pablo");
		lista.add(per);

		per = new Persona();
		per.setIdPersona(2);
		per.setNombres("Code");
		lista.add(per);
		
		return lista;
	}

	public Persona listarPorId(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

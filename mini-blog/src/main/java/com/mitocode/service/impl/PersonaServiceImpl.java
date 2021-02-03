package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Named
public class PersonaServiceImpl implements IPersonaService, Serializable {
	
	@Inject//obtiene la instancia que está guardada en el contenedor JEE. Con esto ya no es necesario instanciar con el operador "new"
	private IPersonaDAO dao;
	
	/*
	public PersonaServiceImpl() {
		dao = new PersonaDAOImpl();//Forma tradicional de creación de instancia para comunicar el service con el DAO
	}
	*/

	public Integer registrar(Persona per) throws Exception {
		return dao.registrar(per);
	}

	public Integer modificar(Persona per) throws Exception {
		return dao.modificar(per);
	}

	public Integer eliminar(Persona per) throws Exception {
		return dao.eliminar(per);
	}

	public List<Persona> listar() throws Exception {
		return dao.listar();
	}

	public Persona listarPorId(Persona per) throws Exception {
		return dao.listarPorId(per);
	}

}

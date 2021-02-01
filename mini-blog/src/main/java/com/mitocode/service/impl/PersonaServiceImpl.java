package com.mitocode.service.impl;

import java.util.List;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.dao.impl.PersonaDAOImpl;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

public class PersonaServiceImpl implements IPersonaService {
	
	private IPersonaDAO dao;
	
	public PersonaServiceImpl() {
		dao = new PersonaDAOImpl();//Forma tradicional de creación de instancia para comunicar el service con el DAO
	}

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

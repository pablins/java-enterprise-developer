package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@WebService
public class PersonaServiceImpl implements IPersonaService, Serializable {
	
	@EJB//Lo inyectamos con esta nueva anotación. Ahora representa mejor lo que hay en la capa DAO, es decir, un EJB
	private IPersonaDAO dao;

	@WebMethod
	public Integer registrar(Persona per) throws Exception {
		int rpta = dao.registrar(per);
		return rpta > 0 ? 1 : 0;
	}

	@WebMethod
	public Integer modificar(Persona per) throws Exception {
		int rpta = dao.modificar(per);
		return rpta > 0 ? 1 : 0;
	}

	@WebMethod
	public List<Persona> listar() throws Exception {
		return dao.listar();
	}

	@WebMethod
	public Persona listarPorId(Persona per) throws Exception {
		return dao.listarPorId(per);
	}

}

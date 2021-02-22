package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.model.UsuarioRol;
import com.mitocode.service.IRolService;

@Named
public class RolServiceImpl implements IRolService, Serializable {
	
	@EJB
	private IRolDAO dao;

	@Override
	public Integer registrar(Rol t) throws Exception {
		return dao.registrar(t);
	}

	@Override
	public Integer modificar(Rol t) throws Exception {
		return dao.modificar(t);
	}

	@Override
	public Integer eliminar(Rol t) throws Exception {
		return dao.eliminar(t);
	}

	@Override
	public List<Rol> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Rol listarPorId(Rol t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public Integer asignar(Usuario usuario, List<Rol> roles) {
		
		//En esta capa de servicio realizamos la transformación de negocio necesaria, con el fin de no sobrecargar el DAO haciendo lógica que no le corresponda
		List<UsuarioRol> lstUsuarioRol = new ArrayList<>();
		
		roles.forEach(r -> {
			UsuarioRol ur = new UsuarioRol();
			ur.setUsuario(usuario);
			ur.setRol(r);
			lstUsuarioRol.add(ur);
		});
		
		//Preparamos los datos que deben ser enviados al DAO
		return dao.asignar(usuario, lstUsuarioRol);
	}

}

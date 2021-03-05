package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mitocode.dao.IPublicacionDAO;
import com.mitocode.model.Persona;
import com.mitocode.model.Publicacion;

@Stateless
public class PublicacionDAOImpl implements IPublicacionDAO, Serializable {
	
	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;

	@Override
	public Integer registrar(Publicacion t) throws Exception {
		int idGenerado = 0;
		try {
			em.persist(t);
			em.flush();//necesario para liberar recursos y la referencia de la ultima operación se estable a la variable que se acaba de hacer persist
			idGenerado = t.getId();//para que lo devuelva sí o sí es necesario antes hacer el flush
		} catch (Exception e) {
			throw e;
		}
		//retornamos el ID del objeto creado
		return idGenerado;
	}

	@Override
	public Integer modificar(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminar(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publicacion listarPorId(Publicacion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listarPublicacionesPorPublicador(Persona publicador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listarPublicacionesDeSeguidores(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

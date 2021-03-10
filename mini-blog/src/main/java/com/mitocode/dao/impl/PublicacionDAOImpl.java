package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IPublicacionDAO;
import com.mitocode.model.Persona;
import com.mitocode.model.Publicacion;
import com.mitocode.model.PublicadorSeguidor;

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
		
		List<Publicacion> lista = new ArrayList<>();
		
		try {
			Query query = em.createQuery("FROM Publicacion p WHERE p.publicador = ?1");
			query.setParameter(1, publicador);
			
			//OTRA FORMA VIABLE:
//			Query query = em.createQuery("FROM Publicacion p WHERE p.publicador.id = ?1");
//			query.setParameter(1, publicador.getId());
			
			lista = (List<Publicacion>)query.getResultList();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public List<Publicacion> listarPublicacionesDeSeguidores(Persona persona) throws Exception {
		List<PublicadorSeguidor> listaSeguidos = new ArrayList<>();
		List<Publicacion> listaPublicaciones = new ArrayList<>();
		
		try {
			//1- Consultamos los publicadores a los que seguimos
			Query query = em.createQuery("FROM PublicadorSeguidor ps WHERE ps.seguidor.id = ?1");
			query.setParameter(1, persona.getId());
			
			listaSeguidos = (List<PublicadorSeguidor>) query.getResultList();
			
			//2- Consultamos las publicaciones de cada uno de los publicadores que seguimos
			listaSeguidos.forEach(ls -> {
				Query q = em.createQuery("FROM Publicacion p WHERE p.publicador.id = ?1");
				q.setParameter(1, ls.getPublicador().getId());
				
				List<Publicacion> lista = (List<Publicacion>) q.getResultList();
				
				listaPublicaciones.addAll(lista);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPublicaciones;
	}

}

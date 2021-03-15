package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Stateless//Es de una especificación mayor a JPA, es de EJB.
public class PersonaDAOImpl implements IPersonaDAO, Serializable {
	
	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;

	public Integer registrar(Persona per) throws Exception {
		try {
			//necesitamos especificar la transacción debido a que no estamos manejando EJB
			//Las transacciones ya no son manuales sino que ahora son manejadas por el contenedor de EJB
//			em.getTransaction().begin();
			em.persist(per);
//			em.getTransaction().commit();
		} catch(Exception e) {
//			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return per.getId();
	}

	public Integer modificar(Persona per) throws Exception {
		em.merge(per);
		return per.getId();
	}

	public List<Persona> listar() throws Exception {
		
		List<Persona> lista = new ArrayList<>();
		
		try {
			Query query = em.createQuery("FROM Persona p");
			lista = (List<Persona>)query.getResultList();
		} catch (Exception e) {
			throw e;
		}
		
		return lista;
	}

	public Persona listarPorId(Persona per) throws Exception {
		Persona personaEncontrada = new Persona();
		
		try {
			Query query = em.createQuery("FROM Persona p WHERE p.id = ?1");
			query.setParameter(1, per.getId());
			
			List<Persona> lista = (List<Persona>)query.getResultList();
			
			if(lista != null && !lista.isEmpty()) {
				personaEncontrada = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		
		return personaEncontrada;
	}

}

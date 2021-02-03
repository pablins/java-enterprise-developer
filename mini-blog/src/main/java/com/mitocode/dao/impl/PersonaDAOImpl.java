package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Named//Le indicamos a la clase que debe ser gestionada por el contenedor JEE
public class PersonaDAOImpl implements IPersonaDAO, Serializable {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("miniBlogPU");
		em = emf.createEntityManager();
	}

	public Integer registrar(Persona per) throws Exception {
		try {
			//necesitamos especificar la transacción debido a que no estamos manejando EJB
			em.getTransaction().begin();
			em.persist(per);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
		
		return per.getIdPersona();
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

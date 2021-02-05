package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

//@Named//Le indicamos a la clase que debe ser gestionada por el contenedor JEE
@Stateless//Es de una especificación mayor a JPA, es de EJB.
public class PersonaDAOImpl implements IPersonaDAO, Serializable {
	
	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;
	
	/*YA NO SERÍA NECESARIO ESTE CÓDIGO, DADO QUE HAREMOS USO DE EJB
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("miniBlogPU");
		em = emf.createEntityManager();
	}
	*/

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
		per.setId(1);
		per.setNombres("Pablo");
		lista.add(per);

		per = new Persona();
		per.setId(2);
		per.setNombres("Code");
		lista.add(per);
		
		return lista;
	}

	public Persona listarPorId(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

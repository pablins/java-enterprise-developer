package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;

@Stateless
public class RolDAOImpl implements IRolDAO, Serializable {
	
	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;

	@Override
	public Integer registrar(Rol t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer modificar(Rol t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer eliminar(Rol t) throws Exception {
		em.remove(em.merge(t));//para eliminar necesitamos hacer un merge para hacer una transacción no confirmada en la DB. Porque para eliminar algo debe estar en la DB. Esto es una buena practica
		return 1;//retornamos 1 sí todo es exitoso
	}

	@Override
	public List<Rol> listar() throws Exception {
		//Lenguaje conocido como JPQL (Java Persistence Query Language). Querys a base de datos pero con JPA, variante a SQL
		//Realizamos el import de "javax.persistence"
		Query query = em.createQuery("SELECT r FROM Rol r");//Consulta a la ENTIDAD Rol (clase), que indirectamente representa la tabla ROL. Ojo que la clase creada es 'Rol' con R mayuscula
		List<Rol> lista = (List<Rol>)query.getResultList();//Se recomienda el casteo explicito, dado que por default devuelve un object
		return lista;
	}

	@Override
	public Rol listarPorId(Rol t) throws Exception {
		Query query = em.createQuery("FROM Rol r WHERE r.id = ?1");//Podemos obviar el 'SELECT R'
		query.setParameter(1, t.getId());//Seteamos el parametro que hemos definido como 1
		
		List<Rol> lista = (List<Rol>)query.getResultList();//Se recomienda el casteo explicito, dado que por default devuelve un object
		//Código limpio recomienda que las capas no devuelvan NULL, por tanto en caso de no encontrar el objeto devolveremos una instancia de Rol vacia
		return lista != null && !lista.isEmpty() ? lista.get(0) : new Rol();
	}

}

package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.model.UsuarioRol;

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
		Query query = em.createQuery("FROM Rol r WHERE r.id = ?1");//Podemos obviar el 'SELECT r'
		query.setParameter(1, t.getId());//Seteamos el parametro que hemos definido como 1
		
		List<Rol> lista = (List<Rol>)query.getResultList();//Se recomienda el casteo explicito, dado que por default devuelve un object
		//Código limpio recomienda que las capas no devuelvan NULL, por tanto en caso de no encontrar el objeto devolveremos una instancia de Rol vacia
		return lista != null && !lista.isEmpty() ? lista.get(0) : new Rol();
	}

	@Override
	public Integer asignar(Usuario usuario, List<UsuarioRol> roles) {
		
		//1-Primero eliminamos todos los roles que ya tenga el usuario
		Query query = em.createNativeQuery("DELETE FROM usuario_rol ur WHERE ur.id_usuario = ?1");//en esta ocasión estamos usando un query nativo, SQL normal. Por tanto, usamos el nombre de la tabla en la DB
		query.setParameter(1, usuario.getPersona().getId());
		query.executeUpdate();//Realizamos la ejecución del query
		
		
		//2-Insertamos los nuevos roles - Aprovechamos el uso de Java 8 con las lambdas
//		int i = 0;
		//Truco para poder usar variable local
		int[] i = { 0 };//Iniciamos el arreglo asignando el valor cero a la primera posicion. Es decir, creamos un arreglo de una posicion
		//iteramos la lista de roles para insertar los nuevos roles
		roles.forEach(r -> {
			em.persist(r);//IMPORTANTE: El EntityManager se satura cuando se hacen muchas persistencias dentro de un bucle
			
			//Tip - Limpiamos el EntityManager cada N iteraciones
			//if(i % 100 == 0) {//cada 100 iteraciones hacemos una limpieza (puede ser 10, 20, etc. Por ahora es un número que se me ocurre)
			if(i[0] % 100 == 0) {//Verificamos el valor en la posicion 0
				em.flush();
				em.clear();
			}
			
//			i++;//Las lambdas son funciones anónimas y no tienen visibilidad a lo que hay hacia afuera de ella, salvo que sea atributo de clase (por eso el EntityManager sí lo puede leer)
			i[0]++; 
		});
		
		return i[0];//Retornamos el valor del contador (lo que se nos ocurra)
	}

}

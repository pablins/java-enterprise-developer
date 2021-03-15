package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO, Serializable {

	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;

	@Override
	public Integer registrar(Usuario t) throws Exception {
		em.persist(t);
		System.out.println(String.format("Id usuario: %d, id persona: %d", t.getId(), t.getPersona().getId()));
		return t.getPersona().getId();
	}

	@Override
	public Integer modificar(Usuario t) throws Exception {
		em.merge(t);
		return t.getPersona().getId();
	}

	@Override
	public List<Usuario> listar() throws Exception {
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			Query query = em.createQuery("SELECT u FROM Usuario");
			lista = (List<Usuario>) query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		Usuario usuario = new Usuario();
		List<Usuario> lista = new ArrayList<>();
		
		try {
			Query query = em.createQuery("FROM Usuario u WHERE u.id = ?1");
			query.setParameter(1, t.getPersona().getId());

			lista = (List<Usuario>) query.getResultList();
			
			if(lista != null && !lista.isEmpty()) {
				usuario = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return usuario;
	}

	@Override
	public String traerClaveHashed(String nameUsuario) {
		Usuario usuario = null;
		try {
			Query query = em.createQuery("FROM Usuario u WHERE u.usuario = ?1");//Se quiere llegar a "SELECT u.contrasena FROM usuario u WHERE u.usuario = ''"
			query.setParameter(1, nameUsuario);
			
			List<Usuario> lista = query.getResultList();
			if(!lista.isEmpty()) {
				usuario = lista.get(0);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return usuario != null ? usuario.getContrasena() : "";
	}

	@Override
	public Usuario obtenerPorNombreUsuario(String nameUsuario) {
		
		Usuario usuario = new Usuario();
		
		try {
			Query query = em.createQuery("FROM Usuario u WHERE u.usuario = ?1");
			query.setParameter(1, nameUsuario);
			
			List<Usuario> lista = (List<Usuario>)query.getResultList();
			
			System.out.println("UsuarioDAOImpl.obtenerPorNombreUsuario: lista=" + lista);
			
			if(!lista.isEmpty()) {
				usuario = lista.get(0);
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return usuario;
	}

}

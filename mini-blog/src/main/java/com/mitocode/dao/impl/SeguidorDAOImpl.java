package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.ISeguidorDAO;
import com.mitocode.model.Persona;
import com.mitocode.model.PublicadorSeguidor;

@Stateless
public class SeguidorDAOImpl implements ISeguidorDAO, Serializable {
	
	@PersistenceContext(unitName = "miniBlogPU")
	private EntityManager em;

	@Override
	public Integer registrarPublicadoresSeguidores(List<PublicadorSeguidor> publicadoresSeguidores) throws Exception {
		
		try {
			int[] i = {0};//truquillo para modificar el valor de la variable aunque esté fuera de la lambda
			publicadoresSeguidores.forEach(ps -> {
				em.merge(ps);
				
				if(i[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				
				i[0]++;
				
			});
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	@Override
	public List<PublicadorSeguidor> listarSeguidores(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mitocode.dao.ISeguidorDAO#dejarDeSeguir(java.util.List)
	 * 
	 * Se interpreta como un delete.
	 */
	@Override
	public Integer dejarDeSeguir(List<PublicadorSeguidor> publicadoresSeguidores) throws Exception {
		int respuesta  = 0;
		
		try {
			publicadoresSeguidores.forEach(ps -> {
				Query query = em.createQuery("DELETE FROM PublicadorSeguidor ps WHERE ps.publicador.id = ?1 AND ps.seguidor.id = ?2");
				query.setParameter(1, ps.getPublicador().getId());
				query.setParameter(2, ps.getSeguidor().getId());
				
				query.executeUpdate();//Se usa para sentencias Delete, Update e Insert
			});
			
			respuesta = 1;
		} catch (Exception e) {
			respuesta = 0;
			e.printStackTrace();
		}
		
		return respuesta;
	}

	@Override
	public List<PublicadorSeguidor> listarSeguidos(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

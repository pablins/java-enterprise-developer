package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@Override
	public Integer dejarDeSeguir(List<PublicadorSeguidor> publicadoresSeguidores) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PublicadorSeguidor> listarSeguidos(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

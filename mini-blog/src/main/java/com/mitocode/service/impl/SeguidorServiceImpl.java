package com.mitocode.service.impl;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.ISeguidorDAO;
import com.mitocode.model.Persona;
import com.mitocode.model.PublicadorSeguidor;
import com.mitocode.service.ISeguidorService;

@Named
public class SeguidorServiceImpl implements ISeguidorService, Serializable {
	
	@EJB//Debido a que la capa DAO está definido como un Stateless con @Local 
	private ISeguidorDAO dao;

	@Override
	public Integer registrarPublicadoresSeguidores(List<Persona> seguidores, List<Persona> publicadores)
			throws Exception {
		
		int respuesta = 0;
		
		try {
			List<PublicadorSeguidor> publicadoresSeguidores = new ArrayList<>();
			
			publicadores.forEach(p -> {
				seguidores.forEach(s -> {
					PublicadorSeguidor publicadorSeguidor = new PublicadorSeguidor();
					publicadorSeguidor.setPublicador(p);
					publicadorSeguidor.setSeguidor(s);
					publicadorSeguidor.setFecha(LocalDateTime.now());//Antes de JDK8 se podia usar Calendar.getInstance().getTime()
					
					publicadoresSeguidores.add(publicadorSeguidor);
				});
			});
			
			respuesta = dao.registrarPublicadoresSeguidores(publicadoresSeguidores);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}

	@Override
	public List<PublicadorSeguidor> listarSeguidores(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer dejarDeSeguir(List<Persona> seguidores, List<Persona> publicadores) throws Exception {
		
		int respuesta  = 0;
		
		try {
			List<PublicadorSeguidor> publicadoresSeguidores = new ArrayList<>();
			
			publicadores.forEach(p -> {
				seguidores.forEach(s -> {
					PublicadorSeguidor publicadorSeguidor = new PublicadorSeguidor();
					publicadorSeguidor.setPublicador(p);
					publicadorSeguidor.setSeguidor(s);
					publicadorSeguidor.setFecha(LocalDateTime.now());
					
					publicadoresSeguidores.add(publicadorSeguidor);
				});
			});
			
			respuesta = dao.dejarDeSeguir(publicadoresSeguidores);
		} catch (Exception e) {
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

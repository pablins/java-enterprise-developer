package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IPublicacionDAO;
import com.mitocode.model.Mencion;
import com.mitocode.model.Persona;
import com.mitocode.model.Publicacion;
import com.mitocode.model.Tag;
import com.mitocode.service.IPublicacionService;

@Named
public class PublicacionServiceImpl implements IPublicacionService, Serializable {
	
	@EJB
	private IPublicacionDAO dao;

	@Override
	public Integer registrar(Publicacion publicacion) throws Exception {
		
		//Antes de enviar a la capa DAO realizamos la lógica de llenar las listas de tags y menciones para que la capa DAO inserte en las tablas publicacion, tag y mencion
		List<Tag> tags = new ArrayList<>();
		List<Mencion> menciones = new ArrayList<>();
		
		String textoCuerpoPublicacion = publicacion.getCuerpo();
		textoCuerpoPublicacion = textoCuerpoPublicacion.replaceAll(",", "");
		textoCuerpoPublicacion = textoCuerpoPublicacion.replaceAll("\\.", "");//reemplazamos los puntos por espacio en blanco
		
		String[] arregloPalabras = textoCuerpoPublicacion.split(" ");
		
		for(String palabra : arregloPalabras) {
			if(palabra.startsWith("#")) {
				palabra = palabra.substring(1);
				tags.add(new Tag(publicacion, palabra));
				
			} else if(palabra.startsWith("@")) {
				palabra = palabra.substring(1);//eliminamos el @ de la palabra
				menciones.add(new Mencion(publicacion, palabra));
			}
		}
		
		publicacion.setTags(tags);
		publicacion.setMenciones(menciones);
		
		return dao.registrar(publicacion);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> listarPublicacionesDeSeguidores(Persona persona) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

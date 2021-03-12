package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.Publicacion;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPublicacionService;

@Named
@ViewScoped
public class PrincipalBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IPublicacionService publicacionService;
	
	//Atributos de la clase
	private Usuario usuarioLogueado;
	
	private List<Publicacion> publicaciones;
	
	@PostConstruct
	private void init() {
		this.usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		this.listarPublicaciones();
	}
	
	public void listarPublicaciones() {
		try {
			publicaciones = publicacionService.listarPublicacionesDeSeguidores(usuarioLogueado.getPersona());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Getters & Setters
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	
	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
}

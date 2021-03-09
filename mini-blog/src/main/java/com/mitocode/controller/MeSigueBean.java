package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.PublicadorSeguidor;
import com.mitocode.model.Usuario;
import com.mitocode.service.ISeguidorService;

@Named
@ViewScoped
public class MeSigueBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private ISeguidorService seguidorService;
	
	//Atributos de la clase
	private Usuario usuarioLogueado;
	
	private List<PublicadorSeguidor> seguidores;
	
	@PostConstruct
	private void init() {
		this.usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		this.listarSeguidores();
	}
	
	private void listarSeguidores() {
		try {
			this.seguidores = seguidorService.listarSeguidores(usuarioLogueado.getPersona());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Getters & Setters
	public List<PublicadorSeguidor> getSeguidores() {
		return seguidores;
	}
	
	public void setSeguidores(List<PublicadorSeguidor> seguidores) {
		this.seguidores = seguidores;
	}
	
}

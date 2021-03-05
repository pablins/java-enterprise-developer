package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.Persona;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.ISeguidorService;

@Named
@ViewScoped
public class SeguirBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IPersonaService personaService;
	
	@Inject
	private ISeguidorService seguidorService;
	
	//Atributos de la clase
	private Usuario usuarioLogueado;
	
	private List<Persona> personas;
	
	@PostConstruct
	private void init() {
		this.usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		this.listarPersonas();
	}

	private void listarPersonas() {
		try {
			this.personas = personaService.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void seguir(Persona personaASeguir) {
		try {
			List<Persona> seguidores = new ArrayList<>();
			List<Persona> publicadores = new ArrayList<>();
			
			seguidores.add(this.usuarioLogueado.getPersona());//corresponde a la persona que inicia sesión
			publicadores.add(personaASeguir);//persona a la que se le da seguir
			
			
			this.seguidorService.registrarPublicadoresSeguidores(seguidores, publicadores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Getters & Setters -> Es de las variables que se usarán en la vista
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}

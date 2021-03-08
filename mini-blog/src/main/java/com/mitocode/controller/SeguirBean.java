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
import com.mitocode.model.PublicadorSeguidor;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.ISeguidorService;

@Named
@ViewScoped
public class SeguirBean implements Serializable {
	
	//Inyecci�n de dependencias
	@Inject
	private IPersonaService personaService;
	
	@Inject
	private ISeguidorService seguidorService;
	
	//Atributos de la clase
	private Usuario usuarioLogueado;
	
	/*
	 * Corresponde a la lista de personas que se sigue (es decir, publicadores que sigue el usuario que se logueo)
	 */
	private List<PublicadorSeguidor> seguidos;
	
	private List<Persona> personas;
	
	@PostConstruct
	private void init() {
		this.usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		this.listarSeguidos();//m�todo encargado de devolver las personas a quienes estoy seguiendo (es decir, los publicadores que sigue el usuario que inicio sesi�n)
		this.listarPersonas();
	}
	
	private void listarSeguidos() {
		try {
			this.seguidos = this.seguidorService.listarSeguidos(this.usuarioLogueado.getPersona());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listarPersonas() {
		try {
			//obtenemos toda la lista de las personas
			this.personas = personaService.listar();
			
			//seteamos s� la persona ya la estamos siguiendo
			this.personas.forEach(p -> {
				this.seguidos.forEach(s -> {
					if(s.getPublicador().getId() == p.getId()) {
						p.setEsSeguido(true);//por default el campo esSeguido es false, por tanto s�lo seteamos a true los que identificamos que est� siguiendo la persona que est� logueada
					}
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void seguir(Persona personaASeguir) {
		try {
			List<Persona> seguidores = new ArrayList<>();
			List<Persona> publicadores = new ArrayList<>();
			
			seguidores.add(this.usuarioLogueado.getPersona());//corresponde a la persona que inicia sesi�n
			publicadores.add(personaASeguir);//persona a la que se le da seguir
			
			
			this.seguidorService.registrarPublicadoresSeguidores(seguidores, publicadores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * m�todo con la l�gica de dejar de seguir a una persona
	 */
	public void dejar(Persona personaADejarDeSeguir) {
		try {
			List<Persona> seguidores = new ArrayList<>();
			List<Persona> publicadores = new ArrayList<>();
			
			seguidores.add(this.usuarioLogueado.getPersona());//corresponde a la persona que inicio sesi�n
			publicadores.add(personaADejarDeSeguir);//persona que se selecciona. Publicador a quien sigo y ya no quiero seguir m�s
			
			this.seguidorService.dejarDeSeguir(seguidores, publicadores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Getters & Setters -> Es de las variables que se usar�n en la vista
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}

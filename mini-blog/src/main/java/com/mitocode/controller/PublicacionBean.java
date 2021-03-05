package com.mitocode.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.Persona;
import com.mitocode.model.Publicacion;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPublicacionService;

@Named
@ViewScoped
public class PublicacionBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IPublicacionService service;
	
	//Atributos de la clase
	/*
	 * información del usuario obtenido de la sesion
	 */
	private Usuario usuarioLogueado;
	
	private Publicacion publicacion;
	
	@PostConstruct
	private void init() {
		this.publicacion = new Publicacion();
		
		//Recuperamos de la memoria de JSF el usuario logeado
		this.usuarioLogueado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");//corresponde al guardado en IndexBean.java cuando se logueo exitosamente el usuario
	}
	
	public void publicar() {
		try {
			Persona publicador = new Persona();
			publicador.setId(usuarioLogueado.getPersona().getId());//creo que sería suficiente con obtener el id del usuario, sin tener que entrar hasta persona. Pero bueno, así es más correcto
			
			this.publicacion.setPublicador(publicador);
			
			this.service.registrar(publicacion);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Getters & Setters
	public Publicacion getPublicacion() {
		return publicacion;
	}
	
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	

}

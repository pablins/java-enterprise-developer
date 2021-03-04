package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.mitocode.model.Persona;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.IRolService;

@Named
@ViewScoped
public class AsignarBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IPersonaService personaService;
	@Inject
	private IRolService rolService;
	
	//Atributos de clase
	private List<Persona> personas;
	
	/*
	 * usado para el pickList de la página asignar.xhtml
	 */
	private DualListModel<Rol> dual;
	
	/*
	 * Corresponde a la persona que seleccióna el usuario en el selectOneMenu
	 */
	private Persona persona;
	
	@PostConstruct
	public void init() {
		this.listarPersonas();
		this.listarRoles();
	}
	
	private void listarPersonas() {
		try {
			this.personas = this.personaService.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listarRoles() {
		try {
			List<Rol> roles = rolService.listar();
			//Recibe 2 parametros. Source corresponde a la fuente origen de selección y target corresponde a lo seleccionado por el usuario
			this.dual = new DualListModel<>(roles, new ArrayList<Rol>());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void asignar() {
		try {
			Usuario usuario = new Usuario();
			usuario.setId(this.persona.getId());
			usuario.setPersona(this.persona);
			
			rolService.asignar(usuario, this.dual.getTarget());//No sé por qué no se pasa directamente el usuario que ya está en persona
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Getters & Setters
	public List<Persona> getPersonas() {
		return personas;
	}
	
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DualListModel<Rol> getDual() {
		return dual;
	}

	public void setDual(DualListModel<Rol> dual) {
		this.dual = dual;
	}
	
}

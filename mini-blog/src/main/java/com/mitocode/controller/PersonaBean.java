package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.impl.PersonaServiceImpl;

@Named
@RequestScoped
public class PersonaBean implements Serializable {
	
	private IPersonaService service;
	
	private Persona persona;
	
	private List<Persona> lista;
	
	public PersonaBean() {
		this.persona = new Persona();
		this.service = new PersonaServiceImpl();
		
		listar();
	}
	
	public void registrar() {
		try {
			this.service.registrar(persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listar() {
		try {
			this.lista = this.service.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Getters & Setters
	 */
	//TODO LO QUE QUERAMOS QUE SE VEA EN LA VISTA DEBE TENER SU GET Y SET
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}
	
	
	
}

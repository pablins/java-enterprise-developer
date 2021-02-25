package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.impl.PersonaServiceImpl;

@Named
@RequestScoped
public class PersonaBean implements Serializable {
	
	//Inyección de dependencia - CDI
	@Inject
	private IPersonaService service;
	
	//Atributos de clase
	private Persona persona;
	
	private List<Persona> lista;
	
	//Atributo de primefaces para el manejo de archivos. No se deja en la clase del modelo debido a que lo ataríamos a PrimeFaces
	private UploadedFile uploadedFileFoto;
	
	public PersonaBean() {
		this.persona = new Persona();
		//this.service = new PersonaServiceImpl();//Ya no es necesario usar el "new"
		
		//this.listar();//CDI no está disponible en la construcción del objeto, por tanto debemos usar el @PostConstruct para que se llame despues de que se ha construido el objeto
	}
	
	@PostConstruct
	public void init() {
		this.listar();
	}
	
	public void registrar() {
		try {
			this.service.registrar(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void operar(String accion) {
		try {
			if(uploadedFileFoto != null) {
				this.persona.setFoto(uploadedFileFoto.getContents());//obtenemos el objeto de bytes del objeto de primefaces
			}
			
			if("R".equalsIgnoreCase(accion)) {
				this.service.registrar(this.persona);
			} else if("M".equalsIgnoreCase(accion)) {
				this.service.modificar(this.persona);
			}
			
		} catch (Exception e) {
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

	public UploadedFile getUploadedFileFoto() {
		return uploadedFileFoto;
	}

	public void setUploadedFileFoto(UploadedFile uploadedFileFoto) {
		this.uploadedFileFoto = uploadedFileFoto;
	}
	
}

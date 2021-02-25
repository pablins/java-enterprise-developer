package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.mitocode.model.Rol;
import com.mitocode.service.IRolService;

@Named
@ViewScoped
public class RolBean implements Serializable {
	
	//Inyecci�n de dependencias
	@Inject
	private IRolService service;
	
	//Atributos de la clase
	private List<Rol> lista;
	
	@PostConstruct
	public void init() {
		this.listar();
	}
	
	public void listar() {
		try {
			lista = service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void onRowEdit(RowEditEvent event) {
		try {
			this.service.modificar((Rol) event.getObject());
			FacesMessage msg = new FacesMessage("Se modific�", ((Rol)event.getObject()).getTipo());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	//Getters & Setters
	public List<Rol> getLista() {
		return lista;
	}

	public void setLista(List<Rol> lista) {
		this.lista = lista;
	}

}

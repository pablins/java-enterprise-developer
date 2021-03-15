package com.mitocode.model;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement//importante para que pueda devolver un XML el API en el produces
public class Persona {
	
	private int id;
	
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

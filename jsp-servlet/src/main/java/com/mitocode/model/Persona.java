package com.mitocode.model;

//Representación modelo DB utilizando JDBC
public class Persona {
	
	private int id;
	
	private String nombres;
	
	private String apellidos;
	
	private String nombreCompleto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNombreCompleto() {
		return new StringBuilder()
				.append(this.nombres)
				.append(", ")
				.append(this.apellidos)
				.toString();
	}

}

package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	@Id
	private Integer id;//Esta llave primaría es a la vez la llave foranea que representa a Persona
	
	//Establecemos la dependencia de uno a uno
	@OneToOne(cascade = CascadeType.ALL)//Lo que le pase a la tabla persona tambien le pase a la tabla Usuario
	//Anotación especial para indicar que la llave primaria tambien es llave foranea
	@MapsId//además, buscara en la tabla Persona la referencia a la tabla Usuario
	//indicamos nombre de la llave foranea a representar
	//name = "id" --> Es como queremos que se llame el campo que tiene la llave foranea en la tabla usuario
	@JoinColumn(name = "id", nullable = false)
	private Persona persona;
	
	@Column(name = "usuario", nullable = false, length = 30)
	private String usuario;
	
	@Column(name = "contrasena", nullable = false, length = 80)//Se deja largo dado que se encriptará
	private String contrasena;
	
	@Column(name = "estado", nullable = false, length = 1)
	//Por default lo dejamos como Activo
	private String estado = "A";//Indica sí el usuario está activo o no. A: Activo, I: Inactivo

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}

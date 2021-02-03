package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//para indicarle que es una entidad de JPA
@Table(name = "persona")//nombre de la tabla como se creará en la DB
public class Persona implements Serializable {//las clases de entidad deben tener la capacidad de ser serializables 
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia de generación autoincremental por cada inserción
	private Integer idPersona;
	
	private String nombres;
	
	private String apellidos;
	
	private String sexo;
	
	private String pais;
	
	private String direccion;
	
	//vamos a guardar una foto en la DB
	private byte[] foto;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}

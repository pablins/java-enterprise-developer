package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity//para indicarle que es una entidad de JPA
@Table(name = "persona")//nombre de la tabla como se creará en la DB
public class Persona implements Serializable {//las clases de entidad deben tener la capacidad de ser serializables 
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia de generación autoincremental por cada inserción
	private Integer id;
	
	//Debido a que Usuario tiene @MapsId en Persona estamos obligados a realizar la reciprocidad de esta manera
	@OneToOne(cascade = CascadeType.ALL, mappedBy="persona")
	private Usuario usuario;
	
	//name -> es para especificar el nombre de la columna
	//nullable=false -> Es para especificar que no acepta nulos
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;
	
	@Column(name = "pais", nullable = false, length = 25)
	private String pais;
	
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	
	//vamos a guardar una foto en la DB
	@Column(name = "foto", nullable = true)
	private byte[] foto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

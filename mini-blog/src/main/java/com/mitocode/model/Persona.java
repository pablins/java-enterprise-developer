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
import javax.persistence.Transient;

@Entity//para indicarle que es una entidad de JPA
@Table(name = "persona")//nombre de la tabla como se creará en la DB
public class Persona implements Serializable {//las clases de entidad deben tener la capacidad de ser serializables 
	
	@Id//llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//estrategia de generación autoincremental por cada inserción
	private Integer id;
	
	//Debido a que Usuario tiene @MapsId en Persona estamos obligados a realizar la reciprocidad de esta manera
	@OneToOne(cascade = CascadeType.ALL, mappedBy="persona")//'mappedBy=persona' -> corresponde al nombre del atributo en la clase Usuario
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
	
	//atributo transitivo, no se agregará en la DB
	/*
	 * usado para indicar sí ya estamos siguiendo a esta persona en la página seguir.xhtml
	 */
	@Transient
	private boolean esSeguido;

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

	public boolean isEsSeguido() {
		return esSeguido;
	}

	public void setEsSeguido(boolean esSeguido) {
		this.esSeguido = esSeguido;
	}

	//Establece el criterio de comparación que utiliza Java al momento de remover o comparar objetos
	//con el fin de que al comparar 2 objetos no lo haga con referencia a memoria, sino que lo compare por medio de un criterio
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

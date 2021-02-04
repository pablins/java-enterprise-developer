package com.mitocode.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {//Esta es tambien conocida como tabla maestro (representa la parte fija)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//generada como correlativo automático
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_publicador", nullable = false)
	private Persona publicador;//llave foranea de persona, forma de saber que persona hizo la publicacion
	
	@Column(name = "cuerpo", nullable = false, length = 250)
	private String cuerpo;//corresponde al texto de la publicación

	//Estos son utiles debido a que al insertar una publicación, se podría insertar la lista de tags y menciones al mismo tiempo
	
	@OneToMany(mappedBy="publicacion",//(Definición bidireccional)significa que en la entidad Tag existe un atributo llamado 'publicacion' que es el dueño de la relación y definio esta relación
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.LAZY, //Carga peresoza, no traerá la lista de tags al consultar Publicación, sino hasta que el programador lo decida
			orphanRemoval = true //permitirá eliminar algunos de sus hijos
	)
	private List<Tag> tags;
	
	@OneToMany(
			mappedBy="publicacion",//(Definición bidireccional)significa que en la entidad Mencion existe un atributo llamado 'publicacion' que es el dueño de la relación y definio esta relación
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
			fetch = FetchType.LAZY, //Carga peresoza
			orphanRemoval = true
	)
	private List<Mencion> menciones;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPublicador() {
		return publicador;
	}

	public void setPublicador(Persona publicador) {
		this.publicador = publicador;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}

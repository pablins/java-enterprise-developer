package com.mitocode.mbean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named //ManagedBean está como obsoleto en JSF 2.3
@RequestScoped //javax.faces.bean.RequestScoped está como obsoleto en JSF 2.3
public class EjemploBean implements Serializable {//importante que implemente la interface dado que permite transformar el objeto como secuencia de datos para enviarlo por la red y al recibirlo se pueda transformar como objeto

	private String nombre;
	
	private String saludo;
	
	//metodos del negocio
	public void aceptar() {
		this.saludo = "Hola " + nombre;
	}
	
	//Recomendación GETTER y SETTER al final
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}

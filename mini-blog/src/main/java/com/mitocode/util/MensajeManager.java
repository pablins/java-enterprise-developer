package com.mitocode.util;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Clase utilitaria para mostrar mensajes.
 * 
 * Esta clase es utilitaria para no estar repitiendo el FacesContext... y con eso en los bean sólo se preocupa por enviar los textos a mostrar y ya
 * @author Pablo Rodriguez
 *
 */
@Named
@RequestScoped//Usado debido a que queremos una instancia independiente por para petición, para que no se guarde el estado de la petición anterior
public class MensajeManager implements Serializable {
	
	public void mostrarMensaje(String titulo, String cuerpo, String severidad) {
		
		switch (severidad) {
		case "INFO":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, cuerpo));
			break;
		case "WARN":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, cuerpo));
			break;
		case "ERROR":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, cuerpo));
			break;
		case "FATAL":
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, cuerpo));
			break;

		}
		
	}

}

package com.mitocode.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.mitocode.model.Usuario;

/*
 * Controller que controlar� la plantilla (al controlar la plantilla estar�a controlando pr�cticamente
 * todas las p�ginas -casi todas las p�ginas a excepci�n del index utilizan el template-).
 */
@Named
@ViewScoped
public class MasterBean implements Serializable {

	/*
	 * m�todo usado para verificar que el usuario haya iniciado sesi�n. Se usa en el template master.xhtml
	 * antes de que se renderice la vista
	 */
	public void verificarSesion() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");//corresponde al key que se coloca cuando un usuario inicia sesi�n correctamente en IndexBean.java
			
			if(usuario == null) {
				context.getExternalContext().redirect("./../index.xhtml");//Redirigimos a la p�gina de inicio
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			context.getExternalContext().redirect("./../index.xhtml");//tambien se podr�a crear una p�gina de error para manejar las excepciones
		}
	}
	
}

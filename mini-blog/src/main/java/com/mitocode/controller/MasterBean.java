package com.mitocode.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.mitocode.model.Usuario;

/*
 * Controller que controlará la plantilla (al controlar la plantilla estaría controlando prácticamente
 * todas las páginas -casi todas las páginas a excepción del index utilizan el template-).
 */
@Named
@ViewScoped
public class MasterBean implements Serializable {

	/*
	 * método usado para verificar que el usuario haya iniciado sesión. Se usa en el template master.xhtml
	 * antes de que se renderice la vista
	 */
	public void verificarSesion() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuario");//corresponde al key que se coloca cuando un usuario inicia sesión correctamente en IndexBean.java
			
			if(usuario == null) {
				context.getExternalContext().redirect("./../index.xhtml");//Redirigimos a la página de inicio
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			context.getExternalContext().redirect("./../index.xhtml");//tambien se podría crear una página de error para manejar las excepciones
		}
	}
	
}

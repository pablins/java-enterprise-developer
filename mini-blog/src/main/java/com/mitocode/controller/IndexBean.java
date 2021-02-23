package com.mitocode.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IUsuarioService service;
	
	//Atributos de clase
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();//Si no se hace, obtendremos => /index.xhtml @26,87 value="#{indexBean.usuario.usuario}": Target Unreachable, 'null' returned null: javax.el.PropertyNotFoundException: /index.xhtml @26,87 value="#{indexBean.usuario.usuario}": Target Unreachable, 'null' returned null
	}
	
	public String login() {
		String redireccion = "";//Sí el login es correcto iría a la página despues del login, pero si es incorrecto se quedaría en la página de login 
		
		try {
			Usuario informacionUsuario = service.login(usuario);
			
			if(informacionUsuario != null && "A".equalsIgnoreCase(informacionUsuario.getEstado())) {//TODO: OJO pendiente verificar con otro argumento como por ejemplo que el ID sea diferente de nulo, dado que así por default cumpliria cuando no se encuentra el usuario
				//Almacenar en la sesión de JSF y proseguir con la navegación
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "CORRECTO"));
			} else {
				//clientId= Es para representar el cliente de la aplicación, es como un apodo a la aplicación. Puede dejarse como null
				//message= Es un objeto de tipo FacesMessage. Recibe la severidad, titulo y cuerpo del mensaje
				//El mensaje se mostrará en la etiqueta p:growl
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//En la práctica no se imprimen los errores directamente, mejor se maneja un mensaje genérico o un código de error
			//El mensaje se mostrará en la etiqueta p:growl
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));//se realiza para ver sí hay un fallo en la etapa de desarrollo
		}
		
		return redireccion;
	}

	//Get & Set
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

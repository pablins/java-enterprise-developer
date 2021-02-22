package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.mitocode.model.Persona;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.IRolService;

@Named
//El tipo ViewScoped nos da soporte para AJAX y nos facilita que los datos se mantengan vigentes en la misma página. Con viewscoped mantenemos el estado anterior siempre y cuando no cambiemos de página
@ViewScoped//Se importa del paquete javax.faces.view dado que estamos usando CDI, con JSF 2.3. Lo que viene de javax.faces.bean es obsoleto (escogemos el que no está obsoleto)
public class RegistroBean implements Serializable {
	
	//Inyección de dependencias
	@Inject
	private IPersonaService personaService;
	
	@Inject
	private IRolService rolService;
	
	//Atributos de la clase
	private Persona persona;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		//Inicializamos las variables para evitar NullPointerException. Es importante porque en la página la estamos llamando como: "registroBean.persona.nombres"
		persona = new Persona();
		usuario = new Usuario();
	}
	
	public void registrar() {
		try {
			//Encriptamos la contraseña
			String clave = this.usuario.getContrasena();//Obtenemos clave original
			String claveHash = BCrypt.hashpw(clave, BCrypt.gensalt());//Devuelve un hash de 60 caracteres. Corresponderá a la clave encriptada
			this.usuario.setContrasena(claveHash);
			
			//Desde aquí podriamos hacer un "this.usuario.setEstado(ENLAZAR_UN_PROPERTIES)" en vez de dejarlo en Entity de Usuario ó tambien podría ser un valor por default en la DB
			this.persona.setUsuario(this.usuario);//seteamos la información de usuario para que al registrar la persona tambien se inserte esta información
			this.usuario.setPersona(this.persona);//es importante indicarlo debido a que es una relación en ambas direcciones (debe hacerse una bidirección). Parece redundancia pero es necesario
			this.personaService.registrar(this.persona);//Al mandar el objeto persona ya tiene el reconocimiento en ambos sentidos y así puede hacer la asignación automática del id generado
			
			List<Rol> roles = new ArrayList<>();
			Rol rolDefaultAdmin = new Rol();
			rolDefaultAdmin.setId(1);//En la DB debería corresponder al rol ADMIN
			roles.add(rolDefaultAdmin);
			
			rolService.asignar(this.usuario, roles);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Get & Set
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

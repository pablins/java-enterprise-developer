package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Named
//@RequestScoped//Recibe la petici�n la procesa y se olvida de la petici�n (con cada petici�n 'reinicia' los atributos)
//vewScoped nos permite que la p�gina tenga muchas funciones ajax y se mantenga el valor de las variables guardado en memoria siempre y cuando est�s en la misma p�gina
@ViewScoped//Usada debido a que en una petici�n sube la foto y en la siguiente procesa el registro (es decir, necesitamos mantener la informaci�n de la petici�n anterior). Usada para que se mantenga el estado en la misma p�gina donde nos encontramos
public class PersonaBean implements Serializable {
	
	//Inyecci�n de dependencia - CDI
	@Inject
	private IPersonaService service;
	
	//Atributos de clase
	private Persona persona;
	
	private List<Persona> lista;
	
	/*
	 * para indicar s� el dialogo se abre desde el bot�n nuevo o editar
	 */
	private String tituloDialogo;
	
	//Atributo de primefaces para el manejo de archivos. No se deja en la clase del modelo debido a que lo atar�amos a PrimeFaces
	//private UploadedFile uploadedFileFoto;
	
//	public PersonaBean() {//Ya no ser�a necesario dado que no tendr�a ninguna implementaci�n
//		this.persona = new Persona();//Aqu� se puede y funciona, pero mejor lo establecemos en el postcontruct para llevar un control y evitar incoherencias
		//this.service = new PersonaServiceImpl();//Ya no es necesario usar el "new"
		
		//this.listar();//CDI no est� disponible en la construcci�n del objeto, por tanto debemos usar el @PostConstruct para que se llame despues de que se ha construido el objeto
//	}
	
	@PostConstruct//tambien se llama cuando le damos recargar a la p�gina: 'http://localhost:8080/mini-blog/protegido/personas.xhtml' desde la URL del navegador
	public void init() {
		this.persona = new Persona();
		this.listar();
		this.tituloDialogo = "Nuevo";//Asignamos un valor por default para el t�tulo del dialogo
	}
	
	public void registrar() {
		try {
			this.service.registrar(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//m�todo encargado de realizar la subida de un archivo cuando el componente fileUpload es mode=advanced
	public void handleFileUpload(FileUploadEvent event) {//evento que s�lo procesa el file
		if(event.getFile() != null) {
			this.persona.setFoto(event.getFile().getContents());//obtenemos los bytes del archivo
		}
    }
	
	public void operar(String accion) {
		try {
			//Ya no ser�a necesario debido a que lo estamos haciendo en el m�todo handleFileUpload
//			if(uploadedFileFoto != null) {
//				this.persona.setFoto(uploadedFileFoto.getContents());//obtenemos el objeto de bytes del objeto de primefaces
//			}
			
			if("R".equalsIgnoreCase(accion)) {
				this.service.registrar(this.persona);
			} else if("M".equalsIgnoreCase(accion)) {
				this.service.modificar(this.persona);
			}
			
			//actualizamos la lista, debido a que al modificar un registro se debe actualizar la informaci�n de la lista
			this.listar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		try {
			this.lista = this.service.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarData(Persona p) {
		this.persona = p;//Debido a que el modal muestra la informaci�n del atributo persona, entonces asignamos el valor que recibimos por parametro, para que al editar un item de la lista se precargue esta informaci�n
		this.tituloDialogo = "Modificar";
	}

	public void limpiarControles() {
		this.persona = new Persona();
		this.tituloDialogo = "Nuevo";
	}
	
	/*
	 * Getters & Setters
	 */
	//TODO LO QUE QUERAMOS QUE SE VEA EN LA VISTA DEBE TENER SU GET Y SET
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

//	public UploadedFile getUploadedFileFoto() {
//		return uploadedFileFoto;
//	}
//
//	public void setUploadedFileFoto(UploadedFile uploadedFileFoto) {
//		this.uploadedFileFoto = uploadedFileFoto;
//	}
	
	public String getTituloDialogo() {
		return tituloDialogo;
	}

	public void setTituloDialogo(String tipoDialogo) {
		this.tituloDialogo = tipoDialogo;
	}
	
}

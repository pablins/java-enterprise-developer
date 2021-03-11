package com.mitocode.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped//Dado que el socket se usará a lo largo de la aplicación
public class PushBean implements Serializable {

	@Inject//no tener en cuenta la advertencia que hace el IDE 
	@Push(channel = "notify")//Asignamos el nombre del canal, desde donde transmitiremos los datos. Es es que utilizarán los que quieran enviar datos
	private PushContext pushContext;//Utilizamos la versión de JSF (En primefaces 6.3+ el push -con socket- ya no se usa dado que JSF 2.3+ lo hace de manera nativa)

	
	//método para hacer algo a penas suceda un evento
	public void sendMessage() {
		pushContext.send("");//forma para enviar un mensaje
	}
}

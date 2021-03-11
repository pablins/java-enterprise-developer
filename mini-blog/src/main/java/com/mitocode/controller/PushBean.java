package com.mitocode.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped//Dado que el socket se usar� a lo largo de la aplicaci�n
public class PushBean implements Serializable {

	@Inject//no tener en cuenta la advertencia que hace el IDE 
	@Push(channel = "notify")//Asignamos el nombre del canal, desde donde transmitiremos los datos. Es es que utilizar�n los que quieran enviar datos
	private PushContext pushContext;//Utilizamos la versi�n de JSF (En primefaces 6.3+ el push -con socket- ya no se usa dado que JSF 2.3+ lo hace de manera nativa)

	
	//m�todo para hacer algo a penas suceda un evento
	public void sendMessage() {
		pushContext.send("");//forma para enviar un mensaje
	}
}

package com.mitocode.controller;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

/**
 * Punto de acceso falso (es como se�uelo). Necesario para la configuraci�n de socket en JSF 2.3+ (JSF SOCKETS)
 * @author Pablo Rodriguez
 *
 */
public class FakeEndpoint extends Endpoint {

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		//Se deja vac�o es parte de la configuraci�n		
	}

}

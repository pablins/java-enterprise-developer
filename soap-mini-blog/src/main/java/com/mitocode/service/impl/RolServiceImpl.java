package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.mitocode.dao.IRolDAO;
import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;
import com.mitocode.model.UsuarioRol;
import com.mitocode.service.IRolService;
import com.mitocode.service.IUsuarioService;

@WebService
public class RolServiceImpl implements IRolService, Serializable {
	
	@EJB
	private IRolDAO dao;
	
	@Resource
	private WebServiceContext context;

	@Inject
	private IUsuarioService usuarioService;
	
	/*
	 * Método encargado de realizar lógica básica para validación de peticiones autenticadas
	 */
	private boolean isAutenticado() {
		MessageContext message = context.getMessageContext();
		Map requestHeader = (Map) message.get(MessageContext.HTTP_REQUEST_HEADERS);//Obtenemos el header que viene en el mensaje SOAP
		//Se obtiene una lista debido a que header devuelve una lista de datos
		List lstUsuarios = (List) requestHeader.get("usuario");
		List lstClaves = (List) requestHeader.get("clave");
		
		String usuario = "";
		String clave = "";
		
		if(lstUsuarios != null && lstClaves != null) {
			usuario = String.valueOf(lstUsuarios.get(0));
			clave = String.valueOf(lstClaves.get(0));
		}
		
		Usuario usuarioEntity = new Usuario();
		usuarioEntity.setUsuario(usuario);
		usuarioEntity.setContrasena(clave);
		
		usuarioEntity = usuarioService.login(usuarioEntity);
		
		return usuarioEntity != null && usuarioEntity.getId() > 0;
		
		
	}

	@WebMethod
	@Override
	public Integer registrar(Rol t) throws Exception {
		int rpta = dao.registrar(t);
		return rpta > 0 ? 1 : 0;
	}

	@WebMethod
	@Override
	public Integer modificar(Rol t) throws Exception {
		int rpta = dao.modificar(t);
		return rpta > 0 ? 1 : 0;
	}

	@WebMethod
	@Override
	public List<Rol> listar() throws Exception {
		if(isAutenticado()) {
			return dao.listar();
		}
		
		return new ArrayList<Rol>();
	}

	@WebMethod
	@Override
	public Rol listarPorId(Rol t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public Integer asignar(Usuario usuario, List<Rol> roles) {
		
		//En esta capa de servicio realizamos la transformación de negocio necesaria, con el fin de no sobrecargar el DAO haciendo lógica que no le corresponda
		List<UsuarioRol> lstUsuarioRol = new ArrayList<>();
		
		roles.forEach(r -> {
			UsuarioRol ur = new UsuarioRol();
			ur.setUsuario(usuario);
			ur.setRol(r);
			lstUsuarioRol.add(ur);
		});
		
		//Preparamos los datos que deben ser enviados al DAO
		return dao.asignar(usuario, lstUsuarioRol);
	}

}

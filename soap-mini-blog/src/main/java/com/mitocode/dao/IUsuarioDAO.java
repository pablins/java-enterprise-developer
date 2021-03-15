package com.mitocode.dao;

import javax.ejb.Local;

import com.mitocode.model.Usuario;

@Local
public interface IUsuarioDAO extends ICRUD<Usuario> {

	//Lo hacemos con el fin de poder contrastar la clave del usuario que hay en la DB versus la clave que dijita el usuario en el campo de texto
	String traerClaveHashed(String nameUsuario);
	
	Usuario obtenerPorNombreUsuario(String nameUsuario);
	
}

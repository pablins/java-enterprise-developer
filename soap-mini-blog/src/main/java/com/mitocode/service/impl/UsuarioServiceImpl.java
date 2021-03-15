package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {
	
	@EJB
	private IUsuarioDAO dao;

	@Override
	public Integer registrar(Usuario t) throws Exception {
		return dao.registrar(t);
	}

	@Override
	public Integer modificar(Usuario t) throws Exception {
		return dao.modificar(t);
	}

	@Override
	public List<Usuario> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public Usuario login(Usuario usuario) throws Exception {
		String claveTextoPlano = usuario.getContrasena();//Clave que diligenci� el usuario en el formulario
		String claveHash = dao.traerClaveHashed(usuario.getUsuario());//Clave que existe en la DB para el nombre de usuario
		
		if(BCrypt.checkpw(claveTextoPlano, claveHash)) {
			//usuario.setContrasena("");//por seguridad dejamos en blanco la informaci�n de contrase�a, es decir, que s�lo devolveremos el nombre del usuario
			return dao.obtenerPorNombreUsuario(usuario.getUsuario());//Mejor se crea un nuevo m�todo para obtener el idUsuario y as� poder devolver la informaci�n
		}
		
		return new Usuario();//Si no coinciden las claves se devolver� un objeto usuario vacio. Se recomienda nunca devolver NULL en un m�todo dado que es propenso a que en la aplicaci�n por alg�n motivo se escape el control de este valor y tenga errores NullPointerException
	}


}

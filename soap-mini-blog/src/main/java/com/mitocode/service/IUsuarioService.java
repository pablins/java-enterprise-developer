package com.mitocode.service;

import com.mitocode.model.Usuario;

public interface IUsuarioService extends IService<Usuario> {
	
	Usuario login(Usuario usuario) throws Exception;

}

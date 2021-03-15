package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Rol;
import com.mitocode.model.Usuario;

//Esta capa service es un puente, sí uno quiere no la utiliza, pero se recomienda para desacoplar el código. Podría tener lógica de negocio o alguna validación en especial antes de invocar a la capa DAO. Dado que al DAO ya debe llegar la info definitiva
public interface IRolService extends IService<Rol> {
	
	Integer asignar(Usuario usuario, List<Rol> roles);

}

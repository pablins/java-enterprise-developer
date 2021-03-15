package com.mitocode.service;

import java.util.List;

//Centralizamos los métodos comunes de la capa de servicio
public interface IService<T> {
	
	Integer registrar(T t) throws Exception;
	
	Integer modificar(T t) throws Exception;
	
	List<T> listar() throws Exception;
	
	T listarPorId(T t) throws Exception;

}

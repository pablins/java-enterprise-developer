package com.mitocode.dao;

import java.util.List;

//Centralizamos las clases de la aplicacion con las operaciones comunes del CRUD
public interface ICRUD<T> {
	
	Integer registrar(T t) throws Exception;
	
	Integer modificar(T t) throws Exception;
	
	List<T> listar() throws Exception;
	
	T listarPorId(T t) throws Exception;

}

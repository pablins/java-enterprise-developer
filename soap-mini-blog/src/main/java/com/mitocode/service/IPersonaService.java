package com.mitocode.service;

import java.util.List;

public interface IPersonaService {
	
	String saludar();
	
	String saludar(String nombre);
	
	List<String> listar();

}

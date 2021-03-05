package com.mitocode.dao;

import java.util.List;

import javax.ejb.Local;

import com.mitocode.model.Persona;
import com.mitocode.model.PublicadorSeguidor;

@Local
public interface ISeguidorDAO {
	
	//seguir
	Integer registrarPublicadoresSeguidores(List<PublicadorSeguidor> publicadoresSeguidores) throws Exception;
	
	//listar mis seguidores
	List<PublicadorSeguidor> listarSeguidores(Persona persona) throws Exception;
	
	//dejar de seguir
	Integer dejarDeSeguir(List<PublicadorSeguidor> publicadoresSeguidores) throws Exception;
	
	//List<PublicadorSeguidor> listarSeguidores() throws Exception;//Más adelante se realizará un reporte en Jasper
	
	//listar quien me está siguiendo
	List<PublicadorSeguidor> listarSeguidos(Persona persona) throws Exception;

}

package com.mitocode.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//Esta clase se encarga de gestionar la conexi�n a la DB
//M�s adelante cuando se hable de persistencia a DB con JPA, esta clase desaparece debido a que es manejada por el "persistence.xml"
public class Conexion {
	
	protected static Connection conn;
	
	public static Connection conectar() {
		if(conn != null) {
			return conn;
		}
		
		InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(inputStream);
			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			//L�nea opcional pero se usa para que en caso que si no est� la librer�a salte una exception
			Class.forName(driver);//Comprobaci�n del driver. Verifica si tenemos el driver en las librer�as
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Se conect� a la DB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void desconectar() {
		if(conn == null) {
			return;//Nos salimos debido a que la conexi�n es nula y por tanto no es necesario realizar la desconexi�n (entra al classLoader del programa)
		}
		
		try {
			conn.close();
			System.out.println("Se desconect� de la DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

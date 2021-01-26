package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Persona;

public class PersonaDAOImpl implements IPersonaDAO {
	
	private Connection conn;
	
	public PersonaDAOImpl() {
		conn = Conexion.conectar();
	}

	@Override
	public void agregar(Persona persona) {
		try {
			String sql = "INSERT INTO persona (nombres, apellidos) VALUES (?,?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int idPersona) {
		try {
			String sql = "DELETE FROM persona WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, idPersona);
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizar(Persona persona) {
		try {
			String sql = "UPDATE persona SET nombres = ?, apellidos = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, persona.getNombres());
			preparedStatement.setString(2, persona.getApellidos());
			preparedStatement.setInt(3, persona.getId());
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Persona> listarTodos() {
		List<Persona> lstPersonas = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM persona";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Persona persona = new Persona();
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
				
				lstPersonas.add(persona);
			}
			
			resultSet.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstPersonas;
	}

	@Override
	public Persona listarPorId(int idPersona) {
		Persona persona = new Persona();
		
		try {
			String sql = "SELECT * FROM persona WHERE id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, idPersona);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				persona.setId(resultSet.getInt("id"));
				persona.setNombres(resultSet.getString("nombres"));
				persona.setApellidos(resultSet.getString("apellidos"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return persona;
	}

}

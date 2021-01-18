package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.List;
import com.petSmile.conexion.*;
import com.petSmile.model.*;

public class MascotaDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	public boolean guardar(Mascota mascota) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO mascota ( rutDueno, nombreMascota) VALUES(?,?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, mascota.getRutDueno());
			statement.setString(2, mascota.getNombreMascota());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// editar producto
	public boolean editar(Mascota mascota) throws SQLException{
		
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE mascota SET nombreMascota = ? WHERE idMascota=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, mascota.getNombreMascota());
			statement.setInt(2, mascota.getIdMascota());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
		
		
		
		
	}

	// eliminar producto
	public boolean eliminar(int idMascota) throws SQLException{
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM mascota WHERE idMascota=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idMascota);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener lista de productos
	public List<Mascota> obtenerMascotas() throws SQLException {

		ResultSet resultSet = null;
		List<Mascota> listaMascotas = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM mascota";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Mascota m = new Mascota();
				m.setIdMascota(resultSet.getInt(1));
				m.setRutDueno(resultSet.getString(2));
				m.setNombreMascota(resultSet.getString(3));
				m.setCreado(resultSet.getDate(4));
				listaMascotas.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaMascotas;
	}

	// obtener lista de productos
	public Mascota obtenerMascota(int idMascota)throws SQLException {
		ResultSet resultSet = null;
		Mascota m=new Mascota();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM mascota WHERE idMascota =?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idMascota);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {				
				m.setIdMascota(resultSet.getInt(1));
				m.setRutDueno(resultSet.getString(2));
				m.setNombreMascota(resultSet.getString(3));
				m.setCreado(resultSet.getDate(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}

	// obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}

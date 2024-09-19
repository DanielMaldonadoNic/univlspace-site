package com.misitio.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.misitio.connection.Conexion;
import com.misitio.connection.EncryptUtil;
import com.misitio.model.Usuario;

public class UsuarioDb {

	private Conexion sqlServerConnection = new Conexion();
	
	public String crearUsuario(Usuario usuario) {
		int rows=0;
		String mensaje="";
		Connection connection;
		try {
			connection = sqlServerConnection.getConecction();
			String sqlInsert = "INSERT INTO CodigoRupestre.dbo.usuarios"
					+ "(NOMBRE, APELLIDOS, TELEFONO, EMAIL, PASSWORD, ACTIVO)"
					+ "VALUES(?,?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getApellidos());
			preparedStatement.setString(3, usuario.getTelefono());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, EncryptUtil.encode(usuario.getPassword()));
			preparedStatement.setBoolean(6, usuario.isActivo());
			
			mensaje = "Usuario creado con exito";
			rows = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		mensaje = rows>0?"Usuario creado con exito":"Error creando Usuario";
		return mensaje;
	}
	
	public void activarCuenta(String email) {
		try {
			Connection conecction = sqlServerConnection.getConecction();
			String sqlUpdate = "UPDATE USUARIOS SET activo = 1 WHERE email = '"+email+"'";
			Statement statament = conecction.createStatement();
			statament.executeUpdate(sqlUpdate);
			System.out.println("Cuenta " + email + "Se activo de forma exitosa.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario login(String email, String password) {
		Usuario user = null;
		try {
			Connection conecction = sqlServerConnection.getConecction();
			String sqlSelect = "select NOMBRE, APELLIDOS, TELEFONO, EMAIL, PASSWORD, ACTIVO from CodigoRupestre.dbo.usuarios where email='"+email+"'";
			Statement statament = conecction.createStatement();
			
			ResultSet rs = statament.executeQuery(sqlSelect);
			while(rs.next()) {
				user = new Usuario();
				user.setNombre(rs.getString("nombre"));
				user.setApellidos(rs.getString("apellidos"));
				user.setTelefono(rs.getString("telefono"));
				user.setEmail(rs.getString("email"));
				user.setPassword(EncryptUtil.decode(rs.getString("password")));
				user.setActivo(rs.getBoolean("activo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}

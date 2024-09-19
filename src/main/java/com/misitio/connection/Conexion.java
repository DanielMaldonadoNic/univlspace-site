package com.misitio.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Conexion {

	static {
		new SQLServerDriver();
	}
	
	public Connection getConecction() throws SQLException {
		
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CodigoRupestre;encrypt=false", "SA", "CodigoRupestre11SpaceNative");
	}
	
}

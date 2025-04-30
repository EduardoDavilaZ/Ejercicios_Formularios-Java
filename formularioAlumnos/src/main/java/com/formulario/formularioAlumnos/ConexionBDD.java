package com.formulario.formularioAlumnos;

import java.sql.*;

public class ConexionBDD {

	private String URL = "jdbc:mysql://localhost/formulario";
	private String USUARIO = "root";
	private String CONTRASENIA = "";
	
	public Connection conexion;
	
	public Connection conectarBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Clase del controlador JDBC de MySQL. Evita el ClassNotFoundException
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
			System.out.println("The Bluetooth device is connected successfully");
		} catch (Exception e) { e.printStackTrace(); }
		return conexion;
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}
}
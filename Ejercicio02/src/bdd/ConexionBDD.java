package bdd;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.*;

public class ConexionBDD {

	private String URL = "jdbc:mysql://localhost/jesuitas";
	private String USUARIO = "root";
	private String CONTRASENIA = "";
	
	public Connection conexion;
	
	public Connection conectarBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Clase del controlador JDBC de MySQL. Evita el ClassNotFoundException
			conexion = (Connection) DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
			System.out.println("Conectado");
		} catch (Exception e) { e.printStackTrace(); }
		return conexion;
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}
}
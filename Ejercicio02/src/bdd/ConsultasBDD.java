package bdd;

import java.sql.*;

public class ConsultasBDD {

    private Connection conexion;

    public ConsultasBDD() {
        conexion = new ConexionBDD().conectarBD();
    }
    
    public void introducirAlumno(String codigo, String nombre, String nombreAl, String firmaES, String firmaENG) {
    	String sql = "INSERT INTO JESUITA (codigo, nombre, nombreAlumno, firma, firmaIngles) VALUES (";
    	if (codigo.isEmpty()) {
    		sql = sql + "NULL";
    	} else {
    		sql = sql + "'" + codigo + "'";
    	}
    	sql = sql + ",'" +nombre + "','" + nombreAl + "','" + firmaES + "','" + firmaENG + "');";
    	System.out.println(sql);
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql);
    		consulta.executeUpdate(sql);
    	} catch (SQLException e) {e.printStackTrace();}
    }
}
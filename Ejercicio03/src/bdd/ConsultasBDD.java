package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chk.Mensajes;
import chk.Procesar;
import chk.Validar;

public class ConsultasBDD {

    public Connection conexion;

    public ConsultasBDD() {
        conexion = new ConexionBDD().conectarBD();
    }
    
    public void introducirAlumno(String codigo, String nombre, String nombreAl, String firmaES, String firmaENG) {
    	if (!Validar.validarCadena(nombre) || !Validar.validarCadena(nombreAl) || 
        	!Validar.validarCadena(firmaES)|| !Validar.validarCadena(firmaENG)) return;
    	
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
    		Validar.validarConsulta(consulta.executeUpdate(sql));
    	} catch (SQLException e) {e.printStackTrace();}
    }
    
    public void introducirLugar(String ip, String nombre, String lugar) {
    	if (!Validar.validarCadena(nombre) || !Validar.validarCadena(lugar)) return;
    	
    	String sql = "INSERT INTO LUGAR (ip, nombre_maquina, lugar) VALUES ('" + ip + "', '" + nombre + "', '" + lugar + "');";
    	System.out.println(sql);
    	
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql);
    		Validar.validarConsulta(consulta.executeUpdate(sql));
    	} catch (SQLException e) {e.printStackTrace();}
    }
    
    public void visualizarLugares(Connection conexion, ArrayList<String> alLugares) {
    	String sql = "SELECT nombre_maquina, lugar FROM lugar ORDER BY nombre_maquina;";
    	
    	try {
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next() == true) {
                String nombre = resultado.getString("nombre_maquina");
                String lugar = resultado.getString("lugar");
                String cadena = nombre + " - " + lugar;
                alLugares.add(cadena);
            }
        } catch(SQLException e) {e.printStackTrace();}
    }
    
    public void introducirVisita(String codigo, String lugar ) {
    	if (!Validar.validarCadena(lugar) || !Validar.validarCadena(codigo)) return;
    	
    	lugar = Procesar.obtenerNombreEquipo(lugar);
    	int idJesuita = obtenerIdJesuita(codigo);
    	String ip = obtenerIp(lugar);
    	
    	if (idJesuita == -1) {
    		Mensajes.usuarioNoEncontrado();
    		return;
    	};
    	
    	System.out.println(codigo);
    	System.out.println(ip);
    	
    	String sql = "INSERT INTO VISITA (idJesuita, ip) VALUES (" + idJesuita + ", '" + ip + "')";
    	System.out.println(sql);
    	
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql);
    		Validar.validarConsulta(consulta.executeUpdate());
    	} catch (SQLException e) {Mensajes.visitaDuplicada();}
    	
    }
    
    private String obtenerIp(String lugar) {
        String ip = "";
        String sql = "SELECT ip FROM lugar WHERE nombre_maquina = '" + lugar + "';";

        try {
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) ip = resultado.getString("ip");
        } catch (SQLException e) {e.printStackTrace();}
        
        System.out.println(ip);
        return ip;
    }
    
    private int obtenerIdJesuita(String codigo) {
    	int idJesuita = -1;
    	
    	String sql = "SELECT idJesuita FROM jesuita WHERE codigo = '" + codigo + "';";

        try {
            PreparedStatement consulta = conexion.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) idJesuita = resultado.getInt("idJesuita");
        } catch (SQLException e) {e.printStackTrace();}
        
        System.out.println(idJesuita);
    	
    	return idJesuita;
    }
}
package com.formulario.formularioAlumnos;

import java.sql.*;
import java.util.*;

import javax.swing.*;

public class ConsultasBDD implements Estilos{

    private Connection conexion;

    public ConsultasBDD() {
        conexion = new ConexionBDD().conectarBD();
    }

    public void generarCheckBoxes(JPanel jpnEste) {
        int pos = 50;
        
        try {
        	Statement consulta = conexion.createStatement();
        	String sql = "SELECT nombre FROM aficiones;";
        	ResultSet resultado = consulta.executeQuery(sql);
        	
        	while(resultado.next() == true) {
        		String nombreAficion = resultado.getString("nombre");
        		JCheckBox jcbAficiones = new JCheckBox(nombreAficion);
        		
        		jcbAficiones.setBounds(90, pos, 200, 30);
        		jcbAficiones.setBackground(color1);
        		pos += 30;
        		
        		jpnEste.add(jcbAficiones);
        	}
        } catch (SQLException e) { e.printStackTrace(); }

    }
    
    public void generarItems (JComboBox<String> jbcEstudios) {
    	try {
    		Statement consulta = conexion.createStatement();
    		String sql = "SELECT nombre FROM estudios;";
    		ResultSet resultado = consulta.executeQuery(sql);
    		
    		while(resultado.next() == true) {
    			String nombreEstudios = resultado.getString("nombre");
    			jbcEstudios.addItem(nombreEstudios);
    		}
    		
    	} catch (SQLException e) { e.printStackTrace(); }
    }
    
    public int insertarAlumno (String nombre, String apodo, String sobreMi, char aspiracion, int idEstudio) {
    	int idAlumno = -1;
    	String sql = "INSERT INTO alumnos(nombre, apodo, sobreMi, aspiracion, idEstudio) VALUES(?, ?, ?, ?, ?);";
    	
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	
    		consulta.setString(1, nombre);
    		consulta.setString(2, apodo);
    		consulta.setString(3, sobreMi);
    		consulta.setString(4, String.valueOf(aspiracion));
    		consulta.setInt(5, idEstudio);
    		consulta.executeUpdate();
    		
    		ResultSet resultado = consulta.getGeneratedKeys();
    		if (resultado.next() == true) idAlumno = resultado.getInt(1);
    		System.out.println("Alumno is connected successfully");
    	} catch (SQLException e) { e.printStackTrace(); }
    		
    	return idAlumno;
    }
    
    public int obtenerAficion (String nombre) {
    	int idAficion = -1;
    	String sql = "SELECT idAficion FROM aficiones WHERE nombre = ?";
    	
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql);
    		consulta.setString(1, nombre);
    		ResultSet resultado = consulta.executeQuery();
    		if (resultado.next() == true) idAficion = resultado.getInt("idAficion");
    	} catch(SQLException e) {e.printStackTrace();};
    	
    	return idAficion;
    }
    
    public void insertarAficiones(int idAlumno, ArrayList<Integer> alAficiones) {
    	String sql = "INSERT INTO alumnosAficiones(idAlumno, idAficion) VALUES(?, ?);";
    	
    	try {
    		PreparedStatement consulta = conexion.prepareStatement(sql);
	    	for (int idAficion : alAficiones) {
	    		consulta.setInt(1, idAlumno);
	    		consulta.setInt(2, idAficion);
	    		consulta.executeUpdate();
	    	}
    	} catch(SQLException e) {e.printStackTrace(); }
    }
}
package formulario;

import java.util.*;

public class Alumno {

	private int nExpediente;
	private String nombre;
	private int calificacion;
	
	public Alumno(int nExpediente, String nombre, int calificacion) {
		this.nExpediente = nExpediente;
		this.nombre = nombre;
		this.calificacion = calificacion;
	}

	public int getnExpediente() {
		return nExpediente;
	}

	public void setnExpediente(int nExpediente) {
		this.nExpediente = nExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public String toString() {
		return nombre + " - " + calificacion;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Alumno alumno = (Alumno) obj;
	    return calificacion == alumno.calificacion && nombre.equals(alumno.nombre);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(nombre, calificacion);
	}
	
}

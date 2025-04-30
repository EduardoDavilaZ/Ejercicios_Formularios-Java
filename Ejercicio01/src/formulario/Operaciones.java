package formulario;

import java.util.*;

public class Operaciones {

	protected static ArrayList<Alumno> alAlumno;
	
	public Operaciones() {
		alAlumno = new ArrayList<>();
	}
	
	public void añadir(String nombre, int nota) {
		int nExpediente = alAlumno.size() + 1;
		alAlumno.add(new Alumno(nExpediente, nombre, nota));
		Interfaz.modeloLista.addElement(new Alumno(nExpediente, nombre, nota));
		Interfaz.actualizarResultados();
	}
	
	public void modificar(Alumno alumno, String nombre, int nota) {
	    int i = alAlumno.indexOf(alumno);
	    
        alAlumno.get(i).setNombre(nombre);
        alAlumno.get(i).setCalificacion(nota);
        Interfaz.modeloLista.setElementAt(alAlumno.get(i), i);
        Interfaz.actualizarResultados();
	}
	
	public void eliminar(Alumno alumno) {
		alAlumno.remove(alumno);
		int i = Interfaz.modeloLista.indexOf(alumno);
		Interfaz.modeloLista.remove(i);
		Interfaz.actualizarResultados();
	}
	
	public static int obtenerMayor() {
		if (alAlumno.isEmpty()) return 0;
		int mayor = alAlumno.get(0).getCalificacion();
		for (Alumno alumno : alAlumno) {
			if (alumno.getCalificacion() > mayor) {
				mayor = alumno.getCalificacion();
			}
		}
		return mayor;
	}
	
	public static int obtenerMenor() {
		if (alAlumno.isEmpty()) return 0;
		int menor = alAlumno.get(0).getCalificacion();
		for (Alumno alumno : alAlumno) {
			if (alumno.getCalificacion() < menor) {
				menor = alumno.getCalificacion();
			}
		}
		return menor;
	}
	
	public ArrayList<Alumno> obtenerAlumnos(){
		return alAlumno;
	}
}

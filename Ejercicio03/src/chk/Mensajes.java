package chk;

import javax.swing.JOptionPane;

public class Mensajes {
	
	public static void visitaDuplicada() {
		JOptionPane.showMessageDialog(null, "Ya has visitado este lugar", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void usuarioNoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void camposVacíos() {
		JOptionPane.showMessageDialog(null, "Existen campos vacíos", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
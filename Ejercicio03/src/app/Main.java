package app;

import javax.swing.SwingUtilities;
import ui.Interfaz;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater( () -> {
			new Interfaz();
		});
	}
}
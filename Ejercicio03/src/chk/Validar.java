package chk;

import javax.swing.JOptionPane;

public class Validar {
	
	/*public String validarIp(JTextField[] jtfIp) {
	    String ip = "";
	    String watcher = "";
	    for (int i = 0; i < 4; i++) {
	        String aux = jtfIp[i].getText();
	        if (aux.length() > 0 && aux.length() <= 3 && aux.matches("\\d+")) {
	            while (aux.length() < 3) {
	                aux = "0" + aux;
	            }
	            watcher = watcher + aux + ".";
	            ip = ip + aux;
	        } else {
	            return null;
	        }
	    }
	    watcher = watcher.substring(0, watcher.length() - 1);
	    System.out.println("IP: " + watcher);
	    return ip;
	}*/
	
	public static boolean validarCadena(String cadena) {
		if (cadena == null) {
			JOptionPane.showMessageDialog(null, "IP fuera de rango", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (cadena.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Existen campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean validarConsulta(int filas) {
		if (filas > 0) {
			JOptionPane.showMessageDialog(null, "Datos insertados exitosamente", "Mensaje", JOptionPane.PLAIN_MESSAGE);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Inserción fallida", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}

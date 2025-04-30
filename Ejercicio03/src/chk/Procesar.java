package chk;

public class Procesar {

	public static String obtenerNombreEquipo(String lugar) {
		lugar = lugar.substring(0, lugar.indexOf(" - "));
		System.out.println(lugar);
		return lugar;
	}

	/*public static String obtenerFecha() {
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return formato.format(new Date());
	}*/
}

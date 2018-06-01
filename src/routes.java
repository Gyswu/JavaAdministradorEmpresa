import java.io.IOException;
/**
 * <h2> Archivo de configuracion de ruta, modo y ip </h2>
 * Este archivo guarda o modifica la ruta del JSON, el modo sin conexion y la IP del servidor de base de datos.
 * @author Gyswu
 */
public class routes {
	/**
	 * Atributo de ruta donde se guarda el archivo
	 */
static private String rutaarchivo;
/**
 * Atributo que guarda el modo con conexion o sin conexion
 */
static private int mode = 0;
/**
 * Atributo que guarda la IP del servidor de base de datos
 */
static protected String ip = "-";


	public static void main(String[] args) throws IOException {
		
	}
	/**
	 * Indica y guarda la ruta para posteriormente ser leido
	 * @param ruta
	 */
	public void setrutaarchivo(String ruta) {
		rutaarchivo = ruta;
	}
	/**
	 * Devuelve la ruta del archivo
	 * @return rutaarchvio
	 */
	public String getruta() {
		return rutaarchivo;
	}
	/**
	 * Cambia el modo a online
	 */
	public void seton() {
		mode = 1;
	}
	/**
	 * Cambia el modo a funcionamiento sin internet
	 */
	public static void setoff() {
		mode = 0;
	}
	/**
	 * Devuelve el modo de conexion en el que esta
	 * @return mode
	 */
	public int getmode() {
		return mode;
	}
	/**
	 * Cambia la ip del servidor de base de datos
	 * @param is
	 */
	public void setip(String is) {
		ip = is;
	}
}

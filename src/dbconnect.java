import java.sql.*;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * <h2>Conexion con la base de datos </h2>
 * Este archivo se encarga de conectarse a la base de datos cogiendo datos del archivo routes, como la IP.
 * @author other
 */
public class dbconnect extends routes{
	/**
	 * Atributo de conexion
	 */
	protected Connection con;
	/**
	 * Atributo de orden
	 */
	protected Statement st;
	/**
	 * Atributo de respuesta
	 */
	protected ResultSet rs;

	
	public dbconnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://"+routes.ip+":3306/empresa?useSSL=false","software","sasijui");
			
			
			st = con.createStatement();
			
		}catch(Exception ex) {
			routes.setoff();
			JOptionPane.showMessageDialog(null, "No hay conexion con el servidor - Modo Sin Conexion \n"
					+ "error: "+ex);
			
		}
		
		

	}
	
}

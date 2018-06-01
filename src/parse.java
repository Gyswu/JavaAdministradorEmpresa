import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 * <h2> Clase de lectura del JSON previamente guardado </h2>
 * Esta clase lee el JSON y esta dividida en un metodo para cada tabla para así no tener que hacerlo todo si solo queremos una tabla.
 * @author Gyswu
 */
public class parse {
routes router = new routes();
String ruta = router.getruta();
private String rute = ruta + "data.json";
/**
 * Array de Albaranes
 * @deprecated
 */
public String[][] arrayalbaranes = new String [100][4];
/**
 * Array de Clientes
 * @deprecated
 */
public String[][] arrayclientes = new String [100][8];
/**
 * Array de Empleados
 * @deprecated
 */
public String[][] arrayempleados = new String [50][8];
/**
 * Array de Existencias
 * @deprecated
 */
public String[][] arrayexistencias = new String [100][5];
/**
 * Array de PedidosC
 * @deprecated
 */
public String[][] arraypc = new String [100][6];
/**
 * Array de PedidosP
 * @deprecated
 */
public String[][] arraypp = new String [100][6];
/**
 * Array de Productos
 * @deprecated
 */
public String[][] arrayproductos = new String [100][8];
/**
 * Array de Albaranes
 * 
 */
public String[][] arraype = new String [1][6];
/**
 * Array de Proveedores
 * @deprecated
 */
public String[][] arrayprv = new String [100][8];

	public parse() {
		
	}
	
	public void parsealbaranes() throws IOException {
		/**
		 * Parse de los albaranes mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
			try{
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray albaranes = (JSONArray) rootJSON.get(0);
			    for (int i = 0; i < albaranes.size(); i++) {
			    JSONObject la = (JSONObject) albaranes.get(i);
			    p++;
			    arrayalbaranes[p][0] = (String) la.get("codalbaran");
			    arrayalbaranes[p][1] = (String) la.get("codRefCli");
			    arrayalbaranes[p][2] = (String) la.get("codrefpro");
			    arrayalbaranes[p][3] = (String) la.get("directorio");
			    }
			    
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		}
	
	public void parseclientes() throws IOException {
		/**
		 * Parse de los clientes mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray cl = (JSONArray) rootJSON.get(1);
			    for (int i = 0; i < cl.size(); i++) {
			    JSONObject lpro = (JSONObject) cl.get(i);
			    p++;
			    arrayclientes[p][0] = (String) lpro.get("codrefcli");
			    arrayclientes[p][1] = (String) lpro.get("razonsocial");
			    arrayclientes[p][2] = (String) lpro.get("cif");
			    arrayclientes[p][3] = (String) lpro.get("num");
			    arrayclientes[p][4] = (String) lpro.get("correo");
			    arrayclientes[p][5] = (String) lpro.get("direccion");
			    arrayclientes[p][6] = (String) lpro.get("metodopago");
			    arrayclientes[p][7] = (String) lpro.get("observaciones");
			    }

			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		}
	
	public void parseempleados() throws IOException {
		/**
		 * Parse de los empleados mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray empleados = (JSONArray) rootJSON.get(2);
			    for (int i = 0; i < empleados.size(); i++) {
			    JSONObject lpro = (JSONObject) empleados.get(i);
			    p++;
			    
			    arrayempleados[p][0] = (String) lpro.get("codempleado");
			    arrayempleados[p][1] = (String) lpro.get("nombre");
			    arrayempleados[p][2] = (String) lpro.get("apellidos");
			    arrayempleados[p][3] = (String) lpro.get("dni");
			    arrayempleados[p][4] = (String) lpro.get("direccion");
			    arrayempleados[p][5] = (String) lpro.get("fechaalta");
			    arrayempleados[p][6] = (String) lpro.get("copiacontrato");
			    arrayempleados[p][7] = (String) lpro.get("numcuenta");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parseexistencias() throws IOException {
		/**
		 * Parse de los existencias mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray ex = (JSONArray) rootJSON.get(3);
			    for (int i = 0; i < ex.size(); i++) {
			    JSONObject lpro = (JSONObject) ex.get(i);
			    p++;
			    arrayexistencias[p][0] = (String) lpro.get("codrefexistencia");
			    arrayexistencias[p][1] = (String) lpro.get("codrefproducto");
			    arrayexistencias[p][2] = (String) lpro.get("cantidad");
			    arrayexistencias[p][3] = (String) lpro.get("sitio");
			    arrayexistencias[p][4] = (String) lpro.get("proposito");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parsepc() throws IOException {
		/**
		 * Parse de los pedidos clientes mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray pc = (JSONArray) rootJSON.get(4);
			    for (int i = 0; i < pc.size(); i++) {
			    JSONObject lpro = (JSONObject) pc.get(i);
			    p++;
			    arraypc[p][0] = (String) lpro.get("numped");
			    arraypc[p][1] = (String) lpro.get("fechapedido");
			    arraypc[p][2] = (String) lpro.get("formapago");
			    arraypc[p][3] = (String) lpro.get("enviadoa");
			    arraypc[p][4] = (String) lpro.get("codcliente");
			    arraypc[p][5] = (String) lpro.get("cpp");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	
	public void parsepp() throws IOException {
		/**
		 * Parse de los pedidos proveedores mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray ppp = (JSONArray) rootJSON.get(5);
			    for (int i = 0; i < ppp.size(); i++) {
			    JSONObject lpro = (JSONObject) ppp.get(i);
			    p++;
			    arraypp[p][0] = (String) lpro.get("numped");
			    arraypp[p][1] = (String) lpro.get("fechapedido");
			    arraypp[p][2] = (String) lpro.get("formapago");
			    arraypp[p][3] = (String) lpro.get("enviadoa");
			    arraypp[p][4] = (String) lpro.get("codprov");
			    arraypp[p][5] = (String) lpro.get("cpp");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parseproductos() throws IOException {
		/**
		 * Parse de los productos mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray productos = (JSONArray) rootJSON.get(6);
			    for (int i = 0; i < productos.size(); i++) {
			    JSONObject lpro = (JSONObject) productos.get(i);
			    p++;
			    arrayproductos[p][0] = (String) lpro.get("crf");
			    arrayproductos[p][1] = (String) lpro.get("name");
			    arrayproductos[p][2] = (String) lpro.get("desc");
			    arrayproductos[p][3] = (String) lpro.get("pve");
			    arrayproductos[p][4] = (String) lpro.get("pvp");
			    arrayproductos[p][5] = (String) lpro.get("cdp");
			    arrayproductos[p][6] = (String) lpro.get("familia");
			    arrayproductos[p][7] = (String) lpro.get("existencias");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parsepe() throws IOException {
		/**
		 * Parse de los Propia Empresa mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray pe = (JSONArray) rootJSON.get(7);
			    JSONObject lpro = (JSONObject) pe.get(0);
			    arraype[0][0] = (String) lpro.get("cif");
			    arraype[0][1] = (String) lpro.get("razonsocial");
			    arraype[0][2] = (String) lpro.get("telef");
			    arraype[0][3] = (String) lpro.get("correo");
			    arraype[0][4] = (String) lpro.get("direccion");
			    arraype[0][5] = (String) lpro.get("ncuenta");

		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parseprov() throws IOException {
		/**
		 * Parse de los proveedores mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		int p = -1;
		JSONParser parser = new JSONParser();
		try {
			    JSONArray rootJSON = (JSONArray) new JSONParser().parse(new FileReader(rute));
			    JSONArray prv = (JSONArray) rootJSON.get(8);
			    for (int i = 0; i < prv.size(); i++) {
			    JSONObject lpro = (JSONObject) prv.get(i);
			    p++;
			    arrayprv[p][0] = (String) lpro.get("crf");
			    arrayprv[p][1] = (String) lpro.get("razonsocial");
			    arrayprv[p][2] = (String) lpro.get("cif");
			    arrayprv[p][3] = (String) lpro.get("num");
			    arrayprv[p][4] = (String) lpro.get("correo");
			    arrayprv[p][5] = (String) lpro.get("direccion");
			    arrayprv[p][6] = (String) lpro.get("metodopago");
			    arrayprv[p][7] = (String) lpro.get("observaciones");
			    }
			
		}
		catch (FileNotFoundException e) { e.printStackTrace();}
		catch (IOException e) { e.printStackTrace();}
		catch (ParseException e) { e.printStackTrace();}
		catch (Exception e) { e.printStackTrace();}
		} 
	
	public void parseall() throws IOException {
		/**
		 * Parse de TODAS las tablas mediante la ruta previamente guardada en "routes"
		 * y guardado en un un array estatico
		 * Proximamente arrays no estaticos
		 * @version 1-2018
		 * 
		 */
		parseprov();
		parsepe();
		parseproductos();
		parsepp();
		parsepc();
		parsealbaranes();
		parseclientes();
		parseempleados();
		parseexistencias();
	}
	
	}
		
		

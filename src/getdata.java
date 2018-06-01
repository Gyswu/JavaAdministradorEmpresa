import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class getdata extends dbconnect{
	/**
	 * <h2> Clase de peticion y guardado de datos</h2>
	*
	*Este archvio es el que realiza todas las peticiones de SELECT del servidor mysql y los introduce en un archivo JSON.
	*Puesto que lo que nos atre son todas las tablas las descargamos todas a la vez desde un mismo metodo.
	*Este metodo guarda todos los datos en la ruta que coge del archivo request
	*@author Gyswu
	*/
	public void getData() throws IOException {
		int i = 0;

		JSONArray listt = new JSONArray();
		
		JSONObject jobj = new JSONObject();
		JSONObject jobjt1 = new JSONObject();
		JSONObject jobjt2 = new JSONObject();
		JSONObject jobjt3 = new JSONObject();
		JSONObject jobjt4 = new JSONObject();
		JSONObject jobjt5 = new JSONObject();
		JSONObject jobjt6 = new JSONObject();
		JSONObject jobjt7 = new JSONObject();
		JSONObject jobjt8 = new JSONObject();
		JSONObject jobjt9 = new JSONObject();
		JSONArray lista1 = new JSONArray();
		JSONArray lista2 = new JSONArray();
		JSONArray lista3 = new JSONArray();
		JSONArray lista4 = new JSONArray();
		JSONArray lista5 = new JSONArray();
		JSONArray lista6 = new JSONArray();
		JSONArray lista7 = new JSONArray();
		JSONArray lista8 = new JSONArray();
		JSONArray lista9 = new JSONArray();
		
		try {
			String query1 = "select * from Albaran";
			rs = st.executeQuery(query1);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String a1= rs.getString("CodAlbaran");
				String a2= rs.getString("CodRefCli");
				String a3= rs.getString("CdoRefPro");
				String a4= rs.getString("CIFPropio");
				String a5= rs.getString("DirArchivo");
				
				jobja.put("codalbaran", a1);
				jobja.put("codRefCli", a2);
				jobja.put("codrefpro",a3 );
				jobja.put("cifpropio", a4);
				jobja.put("directorio", a5);		
				 
				lista1.add(jobja);
				 
			}
			listt.add(lista1);

			String query2 = "select * from Clientes";
			rs = st.executeQuery(query2);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String b1 = rs.getString("CodRefCli");
				String b2 = rs.getString("RazonSocial");
				String b3 = rs.getString("CIF");
				String b4 = rs.getString("Num");
				String b5 = rs.getString("Correo");
				String b6 = rs.getString("Direccion");
				String b7 = rs.getString("MetodoPago");
				String b8 = rs.getString("Observaciones");
				
				 jobja.put("codrefcli", b1);
				 jobja.put("razonsocial", b2);
				 jobja.put("cif", b3);
				 jobja.put("num", b4);
				 jobja.put("correo", b5);
				 jobja.put("direccion", b6);
				 jobja.put("metodopago", b7);
				 jobja.put("observaciones", b8);
				
				 lista2.add(jobja);
				 
			}
			listt.add(lista2);
			
			String query3 = "select * from Empleados";
			rs = st.executeQuery(query3);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String c1 = rs.getString("Cod.Empleado");
				String c2 = rs.getString("Nombre");
				String c3 = rs.getString("Apellidos");
				String c4 = rs.getString("DNI");
				String c5 = rs.getString("Direccion");
				String c6 = rs.getString("FechaAlta");
				String c7 = rs.getString("CopiaContrato");
				String c8 = rs.getString("NCuenta");
				
				 jobja.put("codempleado", c1);
				 jobja.put("nombre", c2);
				 jobja.put("apellidos", c3);
				 jobja.put("dni", c4);
				 jobja.put("direccion", c5);
				 jobja.put("fechaalta", c6);
				 jobja.put("copiacontrato", c7);
				 jobja.put("numcuenta", c8);
				 
				 lista3.add(jobja);
				 
			}
			listt.add(lista3);
			//Existencias
			String query4 = "select * from Existencias";
			rs = st.executeQuery(query4);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String d1 = rs.getString("Cod.RefExistencia");
				String d2 = rs.getString("Cod.RefPro");
				String d3 = rs.getString("Cantidad");
				String d4 = rs.getString("Sitio");
				String d5 = rs.getString("Proposito");
				
				 jobja.put("codrefexistencia", d1);
				 jobja.put("codrefproducto", d2);
				 jobja.put("cantidad", d3);
				 jobja.put("sitio", d4);
				 jobja.put("proposito", d5);
				 
				 lista4.add(jobja);
				 
			}
			listt.add(lista4);
			//PedidosClientes
			String query5 = "select * from PedidosC";
			rs = st.executeQuery(query5);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String e1= rs.getString("NumPed");
				String e2= rs.getString("FechaPedido");
				String e3= rs.getString("FormadePago");
				String e4 = rs.getString("EnviadoA");
				String e5 = rs.getString("CodCliente");
				String e6 = rs.getString("CPP");
				
				 jobja.put("numped", e1);
				 jobja.put("fechapedido", e2);
				 jobja.put("formapago", e3);
				 jobja.put("enviadoa", e4);
				 jobja.put("codcliente", e5);
				 jobja.put("cpp", e6);
				 
				 lista5.add(jobja);
				 
			}
			listt.add(lista5);
			//PedidosProveedores
			String query6 = "select * from PedidosP";
			rs = st.executeQuery(query6);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				
				String f1= rs.getString("NumPed");
				String f2= rs.getString("FechaPedido");
				String f3 = rs.getString("FormadePago");
				String f4 = rs.getString("EnviadoA");
				String f5 = rs.getString("CodProv");
				String f6 = rs.getString("CPP");
				
				 jobja.put("numped", f1);
				 jobja.put("fechapedido", f2);
				 jobja.put("formapago", f3);
				 jobja.put("enviadoa", f4);
				 jobja.put("codprov", f5);
				 jobja.put("cpp", f6);
				 
				 lista6.add(jobja);
				 
			}
			listt.add(lista6);
			//Productos
			String query7 = "select * from Productos";
			rs = st.executeQuery(query7);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				String g1= rs.getString("Cod.RefPro");
				String g2= rs.getString("Nombre");
				String g3 = rs.getString("Descripcion");
				String g4 = rs.getString("PrecioNeto");
				String g5 = rs.getString("pvp");
				String g6 = rs.getString("CodRefProv");
				String g7 = rs.getString("Familia");
				String g8 = rs.getString("Existencias");
				 
				 jobja.put("crf", g1);
				 jobja.put("name", g2);
				 jobja.put("desc", g3);
				 jobja.put("pve", g4);
				 jobja.put("pvp", g5);
				 jobja.put("cdp", g6);
				 jobja.put("familia", g7);
				 jobja.put("existencias", g8);

				 
				 lista7.add(jobja);
				 

			}
			listt.add(lista7);
			//PropiaEmpresa
			String query8 = "select * from PropiaEmpresa";
			rs = st.executeQuery(query8);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();

				String p1= rs.getString("CIF");
				String p2= rs.getString("RazonSocial");
				String p3 = rs.getString("Telefono");
				String p4 = rs.getString("Correo");
				String p5 = rs.getString("Direccion");
				String p6 = rs.getString("NCuenta");
				
				 jobja.put("cif", p1);
				 jobja.put("razonsocial", p2);
				 jobja.put("telef", p3);
				 jobja.put("correo", p4);
				 jobja.put("direccion", p5);
				 jobja.put("ncuenta", p6);
				 
				 lista8.add(jobja);
				 
			}
			listt.add(lista8);
			//Proveedor
			String query9 = "select * from Proveedor";
			rs = st.executeQuery(query9);
			i=0;
			while(rs.next()) {
				JSONObject jobja = new JSONObject();
				

				String h1= rs.getString("Cod.Referencia");
				String h2= rs.getString("RazonSocial");
				String h3 = rs.getString("CIF");
				String h4 = rs.getString("Numero");
				String h5 = rs.getString("Correo");
				String h6 = rs.getString("Direccion");
				String h7 = rs.getString("MetodoPago");
				String h8 = rs.getString("Observaciones");
				
				 jobja.put("crf", h1);
				 jobja.put("razonsocial", h2);
				 jobja.put("cif", h3);
				 jobja.put("num", h4);
				 jobja.put("correo", h5);
				 jobja.put("direccion", h6);
				 jobja.put("metodopago", h7);
				 jobja.put("observaciones", h8);
				 
				 lista9.add(jobja);
				 
			}
			listt.add(lista9);
			routes router = new routes();
			String ruta = router.getruta();
			
			try (FileWriter file = new FileWriter(ruta+"data.json")) {
				file.write(listt.toJSONString());
				file.flush();
			}
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
}

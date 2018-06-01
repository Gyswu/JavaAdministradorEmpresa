import java.sql.SQLException;
/**
 * <h2> Archivo de peticiones SQL </h2>
 * Los metodos reciben las variables necesarias para los campos de cada tabla.
 * @author Gyswu
 */
public class sql extends dbconnect{

	public sql() {
	}
	/**
	 * Metodos add... para añadir (add*Tabla*(INSERT))
	 */
	public void adda(String crct, String crpt, String crm, String all) {
		String query = "INSERT INTO `Albaran` (`CodAlbaran`, `CodRefCli`, `CdoRefPro`, `CIFPropio`, `Dir.Archivo`) VALUES (NULL, '"+crct+"', '"+crpt+"', '"+crm+"', '"+all+"')  ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addcliente(String rzt, String cift, String numtt, String cet, String dirt, String obt, String mt) {
		String query = "INSERT INTO `Clientes` (`CodRefCli`, `RazonSocial`, `CIF`, `Num`, `Correo`, `Direccion`, `MetodoPago`, `Observaciones`) VALUES (NULL, '"+rzt+"', '"+cift+"', '"+numtt+"', '"+cet+"', '"+dirt+"', '"+mt+"', '"+obt+"') ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addempleado(String nmt, String apt, String dnit,String dirt, String datat, String cpt, String nct) {
		String query = "INSERT INTO `Empleados` (`Nombre`, `Apellidos`, `DNI`, `Direccion`, `FechaAlta`, `CopiaContrato`, `Ncuenta`) VALUES (NULL, '"+nmt+"', '"+apt+"', '"+dirt+"', '"+dnit+"', '"+datat+"', '"+cpt+"', '"+nct+"' ) ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addex(String crpt, String cantt, String sitt, String prt) {
		String query = "INSERT INTO `Existencias` (`Cod.RefExistencia`, `Cod.RefPro`, `Cantidad`, `Sitio`, `Proposito`) VALUES (NULL, '"+crpt+"', '"+cantt+"', '"+sitt+"', '"+prt+"')  ; ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	public void addipc(String fecha, String mpt, String dirt, String cdct, String all) {
		String query = "INSERT INTO `PedidosC` (`NumPed`, `FechaPedido`, `FormadePago`, `EnviadoA`, `CodCliente`, `CPP`) VALUES (NULL, '"+fecha+"', '"+mpt+"', '"+dirt+"', '"+cdct+"', '"+all+"')  ; ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addipv(String fecha, String mpt, String dirt, String cdct, String all) {
		String query = "INSERT INTO `PedidosP` (`NumPed`, `FechaPedido`, `FormadePago`, `EnviadoA`, `CodProv`, `CPP`) VALUES (NULL, '"+fecha+"', '"+mpt+"', '"+dirt+"', '"+cdct+"', '"+all+"')  ; ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addprov(String rzt, String cift, String numtt, String cet, String dirt, String obt, String mt) {
		String query = "INSERT INTO `Proveedor` (`Cod.Referencia`, `RazonSocial`, `CIF`, `Numero`, `Correo`, `Direccion`, `MetodoPago`, `Observaciones`) VALUES (NULL, '"+rzt+"', '"+cift+"', '"+numtt+"', '"+cet+"', '"+dirt+"', '"+mt+"', '"+obt+"'); ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addprod(String codt, String npt, String pnt, String pvpt, String crpt, String fmt, String ext, String desct) {
		String query = "INSERT INTO `Productos` (`Cod.RefPro`, `Nombre`, `Descripcion`, `PrecioNeto`, `PVP`, `CodRefProv`, `Familia`, `Existencias`) VALUES ('"+codt+"', '"+npt+"', '"+desct+"', '"+pnt+"', '"+pvpt+"', '"+crpt+"', '"+fmt+"', '"+ext+"') ; ";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodos de i... para eliminar (i*TABLA(DELETE))
	 */
	public void dal(String cdct) {
		String query = "DELETE FROM `PedidosP` WHERE `PedidosP`.`NumPed` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dcli(String cdct) {
		String query = "DELETE FROM `Clientes` WHERE `Clientes`.`CodRefCli` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void demp(String cdct) {
		String query = "DELETE FROM `Empleados` WHERE `Empleados`.`Cod.Empleado` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dex(String cdct) {
		String query = "DELETE FROM `Existencias` WHERE `Existencias`.`Cod.RefExistencia` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dpc(String cdct) {
		String query = "DELETE FROM `PedidosC` WHERE `PedidosC`.`NumPed` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dpv(String cdct) {
		String query = "DELETE FROM `PedidosC` WHERE `PedidosP`.`NumPed` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dpro(String cdct) {
		String query = "DELETE FROM `Productos` WHERE `Productos`.`RefPro` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dprv(String cdct) {
		String query = "DELETE FROM `Proveedor` WHERE `Proveedor`.`Cod.Referencia` = "+cdct+";";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodos de m... para modificar (m*TABLA(UPDATE))
	 */
	public void mal(String crct, String crpt, String allt, String cat) {
		String query = "UPDATE `Albaran` SET `CodRefCli` = '"+crct+"', `CdoRefPro` = '"+crpt+"', `DirArchivo` = '"+allt+"' WHERE `Albaran`.`CodAlbaran` = "+cat+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mcli(String codclit, String rzt, String cift, String numtt, String cet, String dirt, String obt, String mt) {
		String query = "UPDATE `Clientes` SET `RazonSocial` = '"+rzt+"', `CIF` = '"+cift+"', `NUM` = '"+numtt+"', `Correo` = '"+cet+"', `Direccion` = '"+dirt+"', `MetodoPago` = '"+mt+"', `Observaciones` = '"+obt+"' WHERE `Clientes`.`CodRefCli` = "+codclit+"  ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mem(String codemt, String nmt, String aot, String dnit, String dirt, String data, String cont, String nct) {
		String query = "UPDATE `Empleados` SET `Nombre`= '"+nmt+"', `Apellidos` = '"+aot+"', `DNI` = '"+dnit+"', `Direccion` = '"+dirt+"', `FechaAlta` = '"+data+"', `CopiaContrato` = '"+cont+"', `NCuenta` = '"+nct+"' WHERE `Empleados`.`Cod.Empleado` = "+codemt+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mex(String excodt, String crpt, String cantt, String sitt, String prt) {
		String query = "UPDATE `Existencias` SET `Cod.RefPro`= '"+crpt+"', `Cantidad` = '"+cantt+"', `Sitio` = '"+sitt+"', `Proposito` = '"+prt+"' WHERE `Existencias`.`Cod.RefExistencia` = "+excodt+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mpc(String cp, String fecha, String mpt, String dirt, String cdct, String all) {
		String query = "UPDATE `PedidosC` SET `FechaPedido`= '"+fecha+"', `FormadePago` = '"+mpt+"', `EnviadoA` = '"+dirt+"', `CodCliente` = '"+cdct+"', `CPP` = '"+all+"' WHERE `PedidosC`.`Numped` = "+cp+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mpp(String cp, String fecha, String mpt, String dirt, String cdct, String all) {
		String query = "UPDATE `PedidosP` SET `FechaPedido`= '"+fecha+"', `FormadePago` = '"+mpt+"', `EnviadoA` = '"+dirt+"', `CodProv` = '"+cdct+"', `CPP` = '"+all+"' WHERE `PedidosP`.`Numped` = "+cp+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mpe(String cift, String rzt, String tlft, String cet, String dirt, String nct, String ocif) {
		String query = "UPDATE `PropiaEmpresa` SET `CIF`= '"+cift+"', `RazonSocial` = '"+rzt+"', `Telefono` = '"+tlft+"', `Correo` = '"+cet+"', `Direccion` = '"+dirt+"', `NCuenta` = '"+nct+"'  WHERE `PropiaEmpresa`.`CIF` = "+ocif+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mprd(String od, String codt, String npt, String pvpt, String crpt, String fmt, String ext, String desct) {
		String query = "UPDATE `Productos` SET `Cod.RefPro`= '"+codt+"', `Nombre` = '"+npt+"', `Descripcion` = '"+desct+"', `PrecioNeto` = '"+npt+"', `PVP` = '"+pvpt+"', `CodRefProv` = '"+crpt+"', `Familia` = '"+fmt+"', `Existencias` = '"+ext+"'  WHERE `Productos`.`Cod.RefPro` = "+od+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mpro(String crpt, String rzt, String cift, String numtt, String cet, String dirt, String obt, String mt, String l) {
		String query = "UPDATE `Proveedor` SET `Cod.Referencia`= '"+crpt+"', `RazonSocia` = '"+rzt+"', `CIF` = '"+cift+"', `Numero` = '"+numtt+"', `Correo` = '"+cet+"', `Direccion` = '"+dirt+"', `MetodoPago` = '"+mt+"', `Observaciones` = '"+obt+"'  WHERE `Proveedor`.`Cod.Reeferencia` = "+l+" ;";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

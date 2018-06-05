import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.json.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;

public class maine extends JFrame {


	private JPanel contentPane;
	private JTable table_8;
	private JTable table_9;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTable table_10;
	private routes router = new routes();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maine frame = new maine();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setUndecorated(true);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @throws IOException 
	 */
private void updatebd() throws IOException{
	getdata gd = new getdata();
	gd.getData();
}
	
	public maine() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setTitle("Administrador de Empresa");
		setBackground(UIManager.getColor("Button.highlight"));
		if (router.getmode() == 1) {
			updatebd();
		}
		parse parsex = new parse();
		parsex.parseall();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 800);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.light"));
		setJMenuBar(menuBar);
		
		JMenu mnAlbaranes = new JMenu("Albaranes");
		menuBar.add(mnAlbaranes);
		
		JMenuItem mntmNuevoAlbaran = new JMenuItem("Nuevo Albaran");
		mntmNuevoAlbaran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ial frame;
				frame = new ial();
				frame.setVisible(true);
			}
		});
		mnAlbaranes.add(mntmNuevoAlbaran);
		
		JMenuItem mntmEliminarAlbaran = new JMenuItem("Eliminar Albaran");
		mntmEliminarAlbaran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dal frame;
				frame = new dal();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarAlbaran = new JMenuItem("Modificar Albaran");
		mntmModificarAlbaran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mal frame;
				frame = new mal();
				frame.setVisible(true);
			}
		});
		mnAlbaranes.add(mntmModificarAlbaran);
		
		JMenuItem mntmVisualizarAlbaran = new JMenuItem("Visualizar Albaran");
		mntmVisualizarAlbaran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				val frame;
				try {
					frame = new val();
					frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
		mnAlbaranes.add(mntmVisualizarAlbaran);
		mnAlbaranes.add(mntmEliminarAlbaran);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmCliente = new JMenuItem("Nuevo Cliente");
		mnClientes.add(mntmCliente);
		
		JMenuItem mntmBajaDeUn = new JMenuItem("Baja de un Cliente");
		mntmBajaDeUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dcli frame;
				frame = new dcli();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarCliente = new JMenuItem("Modificar Cliente");
		mntmModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mcli frame;
				frame = new mcli();
				frame.setVisible(true);
			}
		});
		mnClientes.add(mntmModificarCliente);
		mnClientes.add(mntmBajaDeUn);
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				icli frame;
				frame = new icli();
				frame.setVisible(true);
			}
		});
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Empleado");
		mnEmpleados.add(mntmNewMenuItem);
		
		JMenuItem mntmBajaDeUn_1 = new JMenuItem("Baja de un Empleado");
		mntmBajaDeUn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dem frame;
				frame = new dem();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarEmpleado = new JMenuItem("Modificar Empleado");
		mntmModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mem frame;
				frame = new mem();
				frame.setVisible(true);
			}
		});
		mnEmpleados.add(mntmModificarEmpleado);
		mnEmpleados.add(mntmBajaDeUn_1);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			iem frame;
			frame = new iem();
			frame.setVisible(true);
			}
		});
		
		JMenu mnExistencias = new JMenu("Existencias");
		menuBar.add(mnExistencias);
		
		JMenuItem mntmAadir = new JMenuItem("Nueva Existencia");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iex frame;
				frame = new iex();
				frame.setVisible(true);
			}
		});
		mnExistencias.add(mntmAadir);
		
		JMenuItem mntmEliminarExistencia = new JMenuItem("Eliminar existencia");
		mntmEliminarExistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dex frame;
				frame = new dex();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarExistencia = new JMenuItem("Modificar Existencia");
		mntmModificarExistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mex frame;
				try {
					frame = new mex();
					frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		mnExistencias.add(mntmModificarExistencia);
		mnExistencias.add(mntmEliminarExistencia);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);
		
		JMenu mnClientes_1 = new JMenu("Clientes");
		mnPedidos.add(mnClientes_1);
		
		JMenuItem mntmNuevoPedido = new JMenuItem("Nuevo Pedido Cliente");
		mntmNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ipc frame;
				frame = new ipc();
				frame.setVisible(true);
			}
		});
		mnClientes_1.add(mntmNuevoPedido);
		
		JMenuItem mntmCancelarPedido = new JMenuItem("Cancelar Pedido");
		mntmCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dpc frame;
				frame = new dpc();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarPedido = new JMenuItem("Modificar Pedido");
		mntmModificarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mpc frame;
				try {
					frame = new mpc();
					frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnClientes_1.add(mntmModificarPedido);
		
		JMenuItem mntmVisualizarPedido = new JMenuItem("Visualizar Pedido");
		mntmVisualizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vpc frame;
				try {
					frame = new vpc();
					frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnClientes_1.add(mntmVisualizarPedido);
		mnClientes_1.add(mntmCancelarPedido);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		mnPedidos.add(mnProveedores);
		
		JMenuItem mntmNuevoPedidoDe = new JMenuItem("Nuevo Pedido de Proveedor");
		mntmNuevoPedidoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ipp frame;
				frame = new ipp();
				frame.setVisible(true);
			}
		});
		mnProveedores.add(mntmNuevoPedidoDe);
		
		JMenuItem mntmCancelarPedido_1 = new JMenuItem("Cancelar Pedido");
		mntmCancelarPedido_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dpp frame;
				frame = new dpp();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificar = new JMenuItem("Modificar Pedido");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mpp frame;
				try {
					frame = new mpp();
					frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mnProveedores.add(mntmModificar);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar Pedido");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vpp frame;
				try {
					frame = new vpp();
					frame.setVisible(true);
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		mnProveedores.add(mntmVisualizar);
		mnProveedores.add(mntmCancelarPedido_1);
		
		JMenu mnProductos = new JMenu("Productos");
		menuBar.add(mnProductos);
		
		JMenuItem mntmProducto = new JMenuItem("Nuevo Producto");
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iprd frame;
				frame = new iprd();
				frame.setVisible(true);
			}
		});
		mnProductos.add(mntmProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar Producto");
		mntmEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dprd frame;
				frame = new dprd();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarProducto = new JMenuItem("Modificar Producto");
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mprd frame;
				frame = new mprd();
				frame.setVisible(true);
			}
		});
		mnProductos.add(mntmModificarProducto);
		mnProductos.add(mntmEliminarProducto);
		
		JMenu mnProveedores_1 = new JMenu("Proveedores");
		menuBar.add(mnProveedores_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nuevo Proveedor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ipro frame;
				frame = new ipro();
				frame.setVisible(true);
			}
		});
		mnProveedores_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmEliminarProveedor = new JMenuItem("Eliminar Proveedor");
		mntmEliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dpro frame;
				frame = new dpro();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificarProveedor = new JMenuItem("Modificar Proveedor");
		mntmModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mpro frame;
				try {
					frame = new mpro();
					frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		mnProveedores_1.add(mntmModificarProveedor);
		mnProveedores_1.add(mntmEliminarProveedor);
		
		JMenu mnEmpresa = new JMenu("Empresa");
		menuBar.add(mnEmpresa);
		
		JMenuItem mntmDatos = new JMenuItem("Datos");
		mntmDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mpe frame;
				try {
					frame = new mpe();
					frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnEmpresa.add(mntmDatos);
		
		JMenu mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		JMenuItem mntmCambiarIp = new JMenuItem("Cambiar IP");
		mntmCambiarIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				router.seton();
				ip frame;
				frame = new ip();
				frame.setVisible(true);
				dispose();
				
			}
		});
		mnDatos.add(mntmCambiarIp);
		
		JMenuItem mntmActualizarArchivo = new JMenuItem("Actualizar archivo");
		mnDatos.add(mntmActualizarArchivo);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 29, 988, 700);
		contentPane.add(tabbedPane);
		
		JScrollPane Albaran = new JScrollPane();
		Albaran.setViewportBorder(null);
		tabbedPane.addTab("Albaranes", null, Albaran, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		table_1 = new JTable();
		table_1.setCellSelectionEnabled(true);
		table_1.setModel(new DefaultTableModel(
			parsex.arrayalbaranes,
			new String[] {
				"Numero Albaran", "Codigo Referencia Cliente", "Codigos Productos", "Ruta"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(138);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(161);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(213);
		Albaran.setViewportView(table_1);
		
		JScrollPane Clientes = new JScrollPane();
		tabbedPane.addTab("Clientes", null, Clientes, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			parsex.arrayclientes,
			new String[] {
				"Codigo Cliente", "Razon Social", "CIF", "Numero", "Correo Electronico", "Direccion", "Metodo de Pago", "Observaciones"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(95);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(151);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(131);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(187);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(118);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(156);
		Clientes.setViewportView(table_2);
		
		JScrollPane Empleados = new JScrollPane();
		tabbedPane.addTab("Empleados", null, Empleados, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			parsex.arrayempleados,
			new String[] {
				"Codigo de Empleado", "Nombre", "Apellidos", "DNI", "Direccion", "Fecha de Alta", "Copia del Contrato", "N\u00BA de Cuenta"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_3.getColumnModel().getColumn(0).setPreferredWidth(126);
		table_3.getColumnModel().getColumn(5).setPreferredWidth(133);
		table_3.getColumnModel().getColumn(6).setPreferredWidth(144);
		Empleados.setViewportView(table_3);
		
		JScrollPane Existencias = new JScrollPane();
		tabbedPane.addTab("Existencias", null, Existencias, null);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			parsex.arrayexistencias,
			new String[] {
				"Codigo Referencia Existencia", "Codigo Referencia Proveedor", "Cantidad", "Sitio", "Proposito"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_4.getColumnModel().getColumn(0).setPreferredWidth(170);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(157);
		Existencias.setViewportView(table_4);
		
		JScrollPane pedcli = new JScrollPane();
		tabbedPane.addTab("Pedidos de los Clientes", null, pedcli, null);
		tabbedPane.setBackgroundAt(4, Color.WHITE);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			parsex.arraypc,
			new String[] {
				"Numero de Pedido", "FechaPedido", "Metodo de Pago", "Direccion de Envio", "Codigo Cliente", "Codigo de Productos Pedidos"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_5.getColumnModel().getColumn(2).setPreferredWidth(122);
		table_5.getColumnModel().getColumn(3).setPreferredWidth(123);
		table_5.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_5.getColumnModel().getColumn(5).setPreferredWidth(225);
		pedcli.setViewportView(table_5);
		
		JScrollPane PedidosProv = new JScrollPane();
		tabbedPane.addTab("Pedidos a proveedores", null, PedidosProv, null);
		tabbedPane.setBackgroundAt(5, Color.WHITE);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			parsex.arraypp,
			new String[] {
				"Numero de Pedido", "Fecha Pedido", "Forma de Pago", "Direccion del pedido", "Codigo Proveedor", "Codigo Producto Pedido"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_6.getColumnModel().getColumn(0).setPreferredWidth(124);
		table_6.getColumnModel().getColumn(2).setPreferredWidth(116);
		table_6.getColumnModel().getColumn(3).setPreferredWidth(133);
		table_6.getColumnModel().getColumn(4).setPreferredWidth(126);
		table_6.getColumnModel().getColumn(5).setPreferredWidth(156);
		PedidosProv.setViewportView(table_6);
		
		JScrollPane Productos = new JScrollPane();
		tabbedPane.addTab("Productos", null, Productos, null);
		tabbedPane.setBackgroundAt(6, Color.WHITE);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			parsex.arrayproductos ,
			new String[] {
				"Codigo Referencia Producto", "Nombre", "Descripcion", "Precio Neto", "PVP", "Codigo Referencia Proveedor", "Familia", "Existencias"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(165);
		Productos.setViewportView(table);
		
		JScrollPane Proveedores = new JScrollPane();
		tabbedPane.addTab("Proveedores", null, Proveedores, null);
		tabbedPane.setBackgroundAt(7, Color.WHITE);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			parsex.arrayprv,
			new String[] {
				"Codigo de Referencia", "Razon Social", "CIF", "Numero", "Correo", "Direccion", "Metodo de Pago", "Observaciones"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_7.getColumnModel().getColumn(0).setPreferredWidth(127);
		table_7.getColumnModel().getColumn(6).setPreferredWidth(109);
		table_7.getColumnModel().getColumn(7).setPreferredWidth(141);
		Proveedores.setViewportView(table_7);

	}
}

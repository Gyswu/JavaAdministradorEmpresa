import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vpp extends JFrame {

	private JPanel contentPane;
	private JTextField codal;
	private JTable table;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vpp frame = new vpp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vpp() throws IOException {
		parse parsex = new parse();
		parsex.parsepp();
		parsex.parseprov();
		parsex.parseproductos();
		String[][] arraydedatos = new String [25][4];
		String[] datos = {"Codigo de Referencia", "Nombre", "Cantidad", "PVP"};
		
		setTitle("Visualizacion de Pedidos de cliente");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 573);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		codal = new JTextField();
		codal.setBounds(205, 36, 86, 20);
		contentPane.add(codal);
		codal.setColumns(10);
		
		JLabel lblCodigoDeAlbarn = new JLabel("Codigo de Pedido");
		lblCodigoDeAlbarn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeAlbarn.setBounds(10, 39, 167, 14);
		contentPane.add(lblCodigoDeAlbarn);
		
		JLabel cif = new JLabel("");
		JLabel rz = new JLabel("");
		JLabel num = new JLabel("");
		JLabel dir = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("Datos del proveedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 84, 602, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCif = new JLabel("CIF:");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(37, 109, 140, 14);
		contentPane.add(lblCif);
		
		JLabel lblRazonSocial = new JLabel("Razon Social:");
		lblRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRazonSocial.setBounds(37, 134, 140, 14);
		contentPane.add(lblRazonSocial);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(37, 159, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(37, 184, 140, 14);
		contentPane.add(lblDireccion);
		
		
		cif.setBounds(187, 109, 400, 14);
		contentPane.add(cif);
		
		
		rz.setBounds(187, 134, 400, 14);
		contentPane.add(rz);
		
		
		num.setBounds(205, 159, 382, 14);
		contentPane.add(num);
		
		
		dir.setBounds(205, 184, 382, 14);
		contentPane.add(dir);
		
		JLabel lblPedidoDelCliente = new JLabel("Pedido");
		lblPedidoDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidoDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPedidoDelCliente.setBounds(10, 209, 602, 14);
		contentPane.add(lblPedidoDelCliente);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(427, 485, 89, 27);
		contentPane.add(lblTotal);
		
		JLabel price = new JLabel("");
		price.setFont(new Font("Tahoma", Font.PLAIN, 18));
		price.setBounds(526, 485, 86, 27);
		contentPane.add(price);
		
		JButton btnGuardarComo = new JButton("Guardar como");
		btnGuardarComo.setEnabled(false);
		btnGuardarComo.setBounds(10, 485, 167, 23);
		contentPane.add(btnGuardarComo);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Busqueda de datos en pedidos a proveedores para luego consultar en el resto de arrays y presentar todos los datos
				 */
				int xxx = 0;
				double tota = 0;
				for (int i = 0; i < parsex.arraypp.length; i++) {
					if (codal.getText().equals(parsex.arraypp[i][0])) {
						for (int z = 0; z < parsex.arrayprv.length; z++) {
							if (parsex.arraypp[i][4].equals(parsex.arrayprv[z][0])) {
								cif.setText(parsex.arrayprv[z][2]);
								rz.setText(parsex.arrayprv[z][1]);
								num.setText(parsex.arrayprv[z][3]);
								dir.setText(parsex.arrayprv[z][5]);
							}
						}
						/**
						 * Busquedas y cotejamientos para mostrar los datos de productos en pantalla y el precio total
						 */
						String productos = parsex.arraypp[i][5];
						String arrayp[] = productos.split("-");
						for(int v = 0; v < arrayp.length; v++) {
							String stri = arrayp[v];
							String arrayt[] = stri.split("x");
							for (int z = 0; z < parsex.arrayproductos.length; z++) {
								if (arrayt[0].equals(parsex.arrayproductos[z][0])) {
									arraydedatos[xxx][0] = parsex.arrayproductos[z][0];
									arraydedatos[xxx][1] = parsex.arrayproductos[z][1];
									arraydedatos[xxx][2] = arrayt[1];
									arraydedatos[xxx][3] = parsex.arrayproductos[z][4];
									xxx++;
								}
							}
						}
					}
				}
				table.setModel(new DefaultTableModel(arraydedatos, datos));
				for (int i = 0; i < arraydedatos.length; i++) {
					if (arraydedatos[i][3] == null) {
						i = arraydedatos.length;
					} else {
					double b1 =	Double.parseDouble(arraydedatos[i][3]);
					double b2 =	Double.parseDouble(arraydedatos[i][2]);
					double b3 = b1 * b2;
					double total = tota + b3;
					tota = total;}
				}
				price.setText(String.valueOf(tota)+"€");
				
				
			}
		});
		btnCargar.setBounds(321, 35, 89, 23);
		contentPane.add(btnCargar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 602, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
	}
}

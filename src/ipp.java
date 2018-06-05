import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class ipp extends JFrame {

	private JPanel contentPane;
	private JTextField mp;
	private JTextField dir;
	private JTextField cdc;
	private JTextField tt;
	private JTextField yy;
	private JTextField cp;
	private JTextField mm;
	private JTextField dd;
	private JTextField cant;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ipp frame = new ipp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ipp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setBackground(Color.WHITE);
		setTitle("Nuevo pedido proveedor");
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mp = new JTextField();
		mp.setBounds(146, 92, 296, 20);
		contentPane.add(mp);
		mp.setColumns(10);
		
		dir = new JTextField();
		dir.setBounds(146, 123, 296, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		cdc = new JTextField();
		cdc.setBounds(146, 154, 296, 20);
		contentPane.add(cdc);
		cdc.setColumns(10);
		
		tt = new JTextField();
		tt.setEditable(false);
		tt.setBounds(146, 185, 296, 101);
		contentPane.add(tt);
		tt.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Forma de pago");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 92, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Direccion de envio");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 123, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Codigo de proveedor");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 154, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Productos pedidos");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 179, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del pedido a proveedor");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		yy = new JTextField();
		yy.setText("yyyy");
		yy.setColumns(10);
		yy.setBounds(146, 61, 55, 20);
		contentPane.add(yy);
		
		JLabel lblCodigoDeProducto = new JLabel("Fecha del pedido");
		lblCodigoDeProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeProducto.setBounds(10, 61, 126, 14);
		contentPane.add(lblCodigoDeProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fecha = yy.getText()+"-"+mm.getText()+"-"+dd.getText();
				String mpt = mp.getText();
				String dirt = dir.getText();
				String cdct = cdc.getText();
				String all = tt.getText();
				sql order = new sql();
				order.addipv(fecha, mpt, dirt, cdct, all);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(316, 362, 126, 23);
		contentPane.add(btnAceptar);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBackground(Color.WHITE);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cdct = cdc.getText();
				try {
					parsex.parseprov();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);

				int ciftest = 0;
				for (int i = 0; i < parsex.arrayprv.length; i++) {
					if (cdct.equals(parsex.arrayprv[i][0])) {
						ciftest = 2;
					}
					if (parsex.arrayprv[i][0] == null) {
						i = parsex.arrayprv.length;
					}
				}
				
				if (ciftest == 0) {
					JOptionPane.showMessageDialog(null, "Ya existe un provedor con el cif que intentas introducir");
				}
				if (ciftest == 2) {

					btnAceptar.setEnabled(true);
				}
				
			}
		});
		btnComprobar.setBounds(146, 362, 126, 23);
		contentPane.add(btnComprobar);
		
		JLabel label = new JLabel("Cod.Producto");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 300, 126, 14);
		contentPane.add(label);
		
		cp = new JTextField();
		cp.setColumns(10);
		cp.setBounds(146, 297, 130, 20);
		contentPane.add(cp);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(Color.WHITE);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpt = cp.getText();
				try {
					parsex.parseproductos();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);

				int ciftest = 0;
				for (int i = 0; i < parsex.arrayproductos.length; i++) {
					if (cpt.equals(parsex.arrayproductos[i][0])) {
						ciftest++;
					}
					if (parsex.arrayproductos[i][0] == null) {
						i = parsex.arrayproductos.length;
					}
				}

				if (ciftest < 1) {
					JOptionPane.showMessageDialog(null, "El producto que intentas introducir no existe");
				} else {
				tt.setText(tt.getText()+cpt+"x"+cant.getText()+"-");	
				cp.setText("");
				cant.setText("");
				}
				}
		});
		btnAadir.setBounds(146, 328, 89, 23);
		contentPane.add(btnAadir);
		
		mm = new JTextField();
		mm.setText("mm");
		mm.setColumns(10);
		mm.setBounds(212, 61, 27, 20);
		contentPane.add(mm);
		
		dd = new JTextField();
		dd.setText("dd");
		dd.setColumns(10);
		dd.setBounds(249, 61, 27, 20);
		contentPane.add(dd);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(286, 300, 100, 14);
		contentPane.add(lblCantidad);
		
		cant = new JTextField();
		cant.setBounds(396, 297, 46, 20);
		contentPane.add(cant);
		cant.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tt.setText("");
			}
		});
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(47, 204, 89, 23);
		contentPane.add(btnLimpiar);
	}
}

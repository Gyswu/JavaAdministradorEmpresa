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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class iem extends JFrame {

	private JPanel contentPane;
	private JTextField rz;
	private JTextField cif;
	private JTextField numt;
	private JTextField ce;
	private JTextField yy;
	private JTextField ob;
	private JTextField mm;
	private JTextField dd;
	private JTextField con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iem frame = new iem();
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
	public iem() {
		setBackground(Color.WHITE);
		setTitle("Nuevo Empleado");
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rz = new JTextField();
		rz.setBounds(146, 56, 296, 20);
		contentPane.add(rz);
		rz.setColumns(10);
		
		cif = new JTextField();
		cif.setBounds(146, 87, 296, 20);
		contentPane.add(cif);
		cif.setColumns(10);
		
		numt = new JTextField();
		numt.setBounds(146, 118, 296, 20);
		contentPane.add(numt);
		numt.setColumns(10);
		
		ce = new JTextField();
		ce.setBounds(146, 149, 296, 20);
		contentPane.add(ce);
		ce.setColumns(10);
		
		ob = new JTextField();
		ob.setBounds(146, 242, 296, 20);
		contentPane.add(ob);
		ob.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Nombre");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 56, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Apellidos");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 87, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Dni");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 118, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Direccion");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 149, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Fecha de alta");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 180, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Ruta copia Contrato");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 211, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Numero de cuenta");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 242, 126, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Empleado");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		yy = new JTextField();
		yy.setText("yyyy");
		yy.setBounds(146, 180, 62, 20);
		contentPane.add(yy);
		yy.setColumns(10);
		
		mm = new JTextField();
		mm.setText("mm");
		mm.setBounds(220, 180, 34, 20);
		contentPane.add(mm);
		mm.setColumns(10);
		
		dd = new JTextField();
		dd.setText("dd");
		dd.setBounds(265, 180, 34, 20);
		contentPane.add(dd);
		dd.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(213, 180, 6, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(255, 180, 6, 20);
		contentPane.add(label_1);
		
		con = new JTextField();
		con.setColumns(10);
		con.setBounds(146, 211, 296, 20);
		contentPane.add(con);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nmt = rz.getText();
				String apt = cif.getText();
				String dnit = numt.getText();
				String dirt = ce.getText();
				String data = yy.getText()+"-"+mm.getText()+"-"+dd.getText();
				String cont = con.getText();
				String nct = ob.getText();
				sql order = new sql();
				order.addempleado(nmt, apt, dnit, dirt, data, cont, nct);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(282, 267, 126, 23);
		contentPane.add(btnAceptar);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBackground(Color.WHITE);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					parsex.parseempleados();
				} catch (IOException e) {
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);
				String nmt = rz.getText();
				String apt = cif.getText();
				String dnit = numt.getText();
				String dirt = ce.getText();
				String data = yy.getText()+"-"+mm.getText()+"-"+dd.getText();
				String cont = con.getText();
				String nct = ob.getText();
				int ciftest = 0;
				
				for (int i = 0; i < parsex.arrayempleados.length; i++) {
					if (dnit.equals(parsex.arrayempleados[i][3])) {
						ciftest = 1;
					}
					if (parsex.arrayclientes[i][3] == null) {
						i = parsex.arrayempleados.length;
					}
				}
				
				if (ciftest == 0) {
					btnAceptar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Ya existe un empleado con el dni que intentas introducir");
				}
				
			}
		});
		btnComprobar.setBounds(146, 267, 126, 23);
		contentPane.add(btnComprobar);
	}
}

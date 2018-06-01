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

public class mem extends JFrame {

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
	private JTextField code;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mem frame = new mem();
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
	public mem() {
		setTitle("Modificar datos de empleado");
		setBackground(Color.WHITE);
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 372);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rz = new JTextField();
		rz.setBounds(146, 89, 296, 20);
		contentPane.add(rz);
		rz.setColumns(10);
		
		cif = new JTextField();
		cif.setBounds(146, 120, 296, 20);
		contentPane.add(cif);
		cif.setColumns(10);
		
		numt = new JTextField();
		numt.setBounds(146, 151, 296, 20);
		contentPane.add(numt);
		numt.setColumns(10);
		
		ce = new JTextField();
		ce.setBounds(146, 182, 296, 20);
		contentPane.add(ce);
		ce.setColumns(10);
		
		ob = new JTextField();
		ob.setBounds(146, 275, 296, 20);
		contentPane.add(ob);
		ob.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Nombre");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 89, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Apellidos");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 120, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Dni");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 151, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Direccion");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 182, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Fecha de alta");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 213, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Ruta copia Contrato");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 244, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Numero de cuenta");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 275, 126, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Empleado");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		yy = new JTextField();
		yy.setText("yyyy");
		yy.setBounds(146, 213, 62, 20);
		contentPane.add(yy);
		yy.setColumns(10);
		
		mm = new JTextField();
		mm.setText("mm");
		mm.setBounds(220, 213, 34, 20);
		contentPane.add(mm);
		mm.setColumns(10);
		
		dd = new JTextField();
		dd.setText("dd");
		dd.setBounds(265, 213, 34, 20);
		contentPane.add(dd);
		dd.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(213, 213, 6, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(255, 213, 6, 20);
		contentPane.add(label_1);
		
		con = new JTextField();
		con.setColumns(10);
		con.setBounds(146, 244, 296, 20);
		contentPane.add(con);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codemt = code.getText();
				String nmt = rz.getText();
				String apt = cif.getText();
				String dnit = numt.getText();
				String dirt = ce.getText();
				String data = yy.getText()+"-"+mm.getText()+"-"+dd.getText();
				String cont = con.getText();
				String nct = ob.getText();
				sql order = new sql();
				order.mem(codemt, nmt, apt, dnit, dirt, data, cont, nct);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(146, 306, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblCodigoDeEmpleado = new JLabel("Codigo de Empleado");
		lblCodigoDeEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeEmpleado.setBounds(10, 56, 126, 14);
		contentPane.add(lblCodigoDeEmpleado);
		
		code = new JTextField();
		code.setBounds(146, 58, 108, 20);
		contentPane.add(code);
		code.setColumns(10);
		
		JButton btnCargarDatos = new JButton("Cargar Datos");
		btnCargarDatos.setBackground(Color.WHITE);
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codet = code.getText();
				try {
					parsex.parseempleados();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int ciftest = 0;
				for (int i = 0; i < parsex.arrayempleados.length; i++) {
					if (codet.equals(parsex.arrayempleados[i][0])) {
						rz.setText(parsex.arrayempleados[i][1]);
						cif.setText(parsex.arrayempleados[i][2]);
						numt.setText(parsex.arrayempleados[i][3]);
						ce.setText(parsex.arrayempleados[i][4]);
						String date = parsex.arrayempleados[i][5];
						String arraydate[]= date.split("-");
						yy.setText(arraydate[0]);
						mm.setText(arraydate[1]);
						dd.setText(arraydate[2]);
						con.setText(parsex.arrayempleados[i][6]);
						ob.setText(parsex.arrayempleados[i][3]);
						ciftest++;
						btnAceptar.setEnabled(true);
					}
					if (parsex.arrayempleados[i][0] == null) {
						i = parsex.arrayempleados.length;
					}
				}

				if (ciftest < 1) {
					JOptionPane.showMessageDialog(null, "El empleado que buscas no existe");
				} else {
				
				}
			}
		});
		btnCargarDatos.setBounds(265, 56, 177, 23);
		contentPane.add(btnCargarDatos);
	}
}

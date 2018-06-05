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

public class mcli extends JFrame {

	private JPanel contentPane;
	private JTextField rz;
	private JTextField cif;
	private JTextField numt;
	private JTextField ce;
	private JTextField dir;
	private JTextField ob;
	private JTextField codcli;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mcli frame = new mcli();
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
	public mcli() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setTitle("Modificar datos cliente");
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rz = new JTextField();
		rz.setEnabled(false);
		rz.setBounds(146, 89, 296, 20);
		contentPane.add(rz);
		rz.setColumns(10);
		
		cif = new JTextField();
		cif.setEnabled(false);
		cif.setBounds(146, 120, 296, 20);
		contentPane.add(cif);
		cif.setColumns(10);
		
		numt = new JTextField();
		numt.setEnabled(false);
		numt.setBounds(146, 151, 296, 20);
		contentPane.add(numt);
		numt.setColumns(10);
		
		ce = new JTextField();
		ce.setEnabled(false);
		ce.setBounds(146, 182, 296, 20);
		contentPane.add(ce);
		ce.setColumns(10);
		
		dir = new JTextField();
		dir.setEnabled(false);
		dir.setBounds(146, 213, 296, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		ob = new JTextField();
		ob.setEnabled(false);
		ob.setBounds(146, 275, 296, 135);
		contentPane.add(ob);
		ob.setColumns(10);
		
		JComboBox mp = new JComboBox();
		mp.setEnabled(false);
		mp.setModel(new DefaultComboBoxModel(new String[] {"", "Transferencia", "Efectivo"}));
		mp.setBounds(146, 244, 296, 20);
		contentPane.add(mp);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 89, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 120, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Numero de Telefono");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 151, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 182, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 213, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Metodo de pago habitual");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 244, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 275, 126, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codclit = codcli.getText();
				String rzt = rz.getText();
				String cift = cif.getText();
				String numtt = numt.getText();
				String cet = ce.getText();
				String dirt = dir.getText();
				String obt = ob.getText();
				String mt = (String) mp.getSelectedItem();
				sql order = new sql();
				order.mcli(codclit, rzt, cift, numtt, cet, dirt, obt, mt);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(146, 421, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblCodigoDelCliente = new JLabel("Codigo del cliente");
		lblCodigoDelCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDelCliente.setBounds(10, 56, 126, 14);
		contentPane.add(lblCodigoDelCliente);
		
		codcli = new JTextField();
		codcli.setBounds(146, 56, 86, 20);
		contentPane.add(codcli);
		codcli.setColumns(10);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codclit = codcli.getText();
				try {
					parsex.parseclientes();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int ciftest = 0;
				for (int i = 0; i < parsex.arrayclientes.length; i++) {
					if (codclit.equals(parsex.arrayclientes[i][0])) {
						rz.setText(parsex.arrayclientes[i][1]);
						cif.setText(parsex.arrayclientes[i][2]);
						numt.setText(parsex.arrayclientes[i][3]);
						ce.setText(parsex.arrayclientes[i][4]);
						dir.setText(parsex.arrayclientes[i][5]);
						ob.setText(parsex.arrayclientes[i][7]);
						
						rz.setEnabled(true);
						cif.setEnabled(true);
						numt.setEnabled(true);
						ce.setEnabled(true);
						dir.setEnabled(true);
						ob.setEnabled(true);
						mp.setEnabled(true);
						btnAceptar.setEnabled(true);
						ciftest++;
					}
					if (parsex.arrayclientes[i][0] == null) {
						i = parsex.arrayclientes.length;
					}
				}

				if (ciftest < 1) {
					JOptionPane.showMessageDialog(null, "El albaran que buscas no existe");
				} else {
				
				}
			}
		});
		btnCargarDatos.setBounds(242, 56, 126, 23);
		contentPane.add(btnCargarDatos);
	}
}

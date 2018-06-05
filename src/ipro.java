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

public class ipro extends JFrame {

	private JPanel contentPane;
	private JTextField rz;
	private JTextField cif;
	private JTextField numt;
	private JTextField ce;
	private JTextField dir;
	private JTextField ob;
	private String mt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ipro frame = new ipro();
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
	public ipro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setTitle("Nuevo Proveedor");
		setBackground(Color.WHITE);
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 474);
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
		
		dir = new JTextField();
		dir.setBounds(146, 180, 296, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		ob = new JTextField();
		ob.setBounds(146, 242, 296, 135);
		contentPane.add(ob);
		ob.setColumns(10);
		
		JComboBox mp = new JComboBox();
		mp.setModel(new DefaultComboBoxModel(new String[] {"", "Transferencia", "Efectivo"}));
		mp.setBounds(146, 211, 296, 20);
		contentPane.add(mp);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 56, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 87, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Numero de Telefono");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 118, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 149, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 180, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Metodo de pago habitual");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 211, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 242, 126, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Proveedor");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rzt = rz.getText();
				String cift = cif.getText();
				String numtt = numt.getText();
				String cet = ce.getText();
				String dirt = dir.getText();
				String obt = ob.getText();
				sql order = new sql();
				order.addprov(rzt, cift, numtt, cet, dirt, obt, mt);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(282, 388, 126, 23);
		contentPane.add(btnAceptar);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBackground(Color.WHITE);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					parsex.parseprov();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);
				String rzt = rz.getText();
				String cift = cif.getText();
				String numtt = numt.getText();
				String cet = ce.getText();
				String dirt = dir.getText();
				String obt = ob.getText();
				int ciftest = 0;
				
				if (mp.getSelectedIndex()==1) {
					mt = "T";
				} else if (mp.getSelectedIndex()==2) {
					mt = "E";
				}
				
				for (int i = 0; i < parsex.arrayprv.length; i++) {
					if (cift.equals(parsex.arrayprv[i][2])) {
						ciftest = 1;
					}
					if (parsex.arrayprv[i][2] == null) {
						i = parsex.arrayprv.length;
					}
				}
				
				if (ciftest == 0) {
					btnAceptar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Ya existe un proveedor con el cif que intentas introducir");
				}
				
			}
		});
		btnComprobar.setBounds(146, 388, 126, 23);
		contentPane.add(btnComprobar);
	}
}

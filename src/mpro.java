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

public class mpro extends JFrame {

	private JPanel contentPane;
	private JTextField rz;
	private JTextField cif;
	private JTextField numt;
	private JTextField ce;
	private JTextField dir;
	private JTextField ob;
	private String mt;
	private JTextField crp;
	private String l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mpro frame = new mpro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public mpro() throws IOException {
		setTitle("Modificar Proveedor");
		setBackground(Color.WHITE);
		parse parsex = new parse();
		parsex.parseprov();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Proveedor");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		rz = new JTextField();
		rz.setBounds(146, 95, 296, 20);
		contentPane.add(rz);
		rz.setColumns(10);
		
		cif = new JTextField();
		cif.setBounds(146, 126, 296, 20);
		contentPane.add(cif);
		cif.setColumns(10);
		
		numt = new JTextField();
		numt.setBounds(146, 157, 296, 20);
		contentPane.add(numt);
		numt.setColumns(10);
		
		ce = new JTextField();
		ce.setBounds(146, 188, 296, 20);
		contentPane.add(ce);
		ce.setColumns(10);
		
		dir = new JTextField();
		dir.setBounds(146, 219, 296, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		ob = new JTextField();
		ob.setBounds(146, 281, 296, 135);
		contentPane.add(ob);
		ob.setColumns(10);
		
		JComboBox mp = new JComboBox();
		mp.setModel(new DefaultComboBoxModel(new String[] {"", "Transferencia", "Efectivo"}));
		mp.setBounds(146, 250, 296, 20);
		contentPane.add(mp);
		
		JLabel lblRaznSocial = new JLabel("Raz\u00F3n Social");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 95, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 126, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Numero de Telefono");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 157, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 188, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 219, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Metodo de pago habitual");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 250, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 281, 126, 14);
		contentPane.add(lblObservaciones);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String crpt = crp.getText();
				String rzt = rz.getText();
				String cift = cif.getText();
				String numtt = numt.getText();
				String cet = ce.getText();
				String dirt = dir.getText();
				String obt = ob.getText();
				mt = (String) mp.getSelectedItem();
				sql order = new sql();
				order.mpro(crpt, rzt, cift, numtt, cet, dirt, obt, mt, l);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(146, 427, 126, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("Cod. Ref Proveedor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 70, 126, 14);
		contentPane.add(lblNewLabel);
		
		crp = new JTextField();
		crp.setBounds(146, 67, 86, 20);
		contentPane.add(crp);
		crp.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String crpt = crp.getText();
				l = crpt;
				int ciftest = 0;
				for (int i = 0; i < parsex.arrayprv.length; i++) {
					if (crpt.equals(parsex.arrayprv[i][0])) {
						rz.setText(parsex.arrayprv[i][1]);
						cif.setText(parsex.arrayprv[i][2]);
						numt.setText(parsex.arrayprv[i][3]);
						ce.setText(parsex.arrayprv[i][4]);
						dir.setText(parsex.arrayprv[i][5]);
						ob.setText(parsex.arrayprv[i][7]);
						btnAceptar.setEnabled(true);
						ciftest = 1;
					}
				}
				if (ciftest == 1) {
					JOptionPane.showMessageDialog(null, "El codigo de producto que buscas no existe");
				}
			}
		});
		btnCargar.setBounds(242, 66, 89, 23);
		contentPane.add(btnCargar);
	}
}

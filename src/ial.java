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

public class ial extends JFrame {

	private JPanel contentPane;
	private JTextField cli;
	private JTextField prov;
	private JTextField tt;
	private JTextField cp;
	private JTextField cant;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ial frame = new ial();
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
	public ial() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setTitle("Nuevo Albaran");
		parse parsex = new parse();
		try {
			parsex.parsepe();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cli = new JTextField();
		cli.setBounds(146, 48, 296, 20);
		contentPane.add(cli);
		cli.setColumns(10);
		
		prov = new JTextField();
		prov.setBounds(146, 79, 296, 20);
		contentPane.add(prov);
		prov.setColumns(10);
		
		tt = new JTextField();
		tt.setEditable(false);
		tt.setBounds(146, 116, 296, 101);
		contentPane.add(tt);
		tt.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Cod.Ref.Cliente");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 48, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Ruta Archivo");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 79, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblCorreoElectronico = new JLabel("Productos pedidos");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 116, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Albaran");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mpt = cli.getText();
				String dirt = prov.getText();
				String all = tt.getText();
				
				String crm = parsex.arraype[0][0];
				sql order = new sql();
				order.adda(mpt, all, crm, dirt);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(286, 293, 126, 23);
		contentPane.add(btnAceptar);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBackground(Color.WHITE);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cdct = cli.getText();
				String dirt = prov.getText();
				try {
					parsex.parseclientes();
					parsex.parseprov();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);

				int ciftest = 0;
				for (int i = 0; i < parsex.arrayclientes.length; i++) {
					if (cdct.equals(parsex.arrayclientes[i][0])) {
						ciftest = 2;
					}
					if (parsex.arrayclientes[i][0] == null) {
						i = parsex.arrayclientes.length;
					}
				}
				if (ciftest == 2 ) {
					btnAceptar.setEnabled(true);
				}
				if (ciftest == 0) {
					JOptionPane.showMessageDialog(null, "No existe un cliente con el cif que intentas introducir");
				}
				
			}
		});
		btnComprobar.setBounds(146, 293, 130, 23);
		contentPane.add(btnComprobar);
		
		JLabel label = new JLabel("Cod.Producto");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 231, 126, 14);
		contentPane.add(label);
		
		cp = new JTextField();
		cp.setColumns(10);
		cp.setBounds(146, 228, 130, 20);
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
		btnAadir.setBounds(146, 259, 89, 23);
		contentPane.add(btnAadir);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(286, 231, 100, 14);
		contentPane.add(lblCantidad);
		
		cant = new JTextField();
		cant.setBounds(396, 228, 46, 20);
		contentPane.add(cant);
		cant.setColumns(10);
	}
}

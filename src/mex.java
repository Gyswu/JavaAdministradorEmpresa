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
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class mex extends JFrame {

	private JPanel contentPane;
	private JTextField can;
	private JTextField sit;
	private JTextField prop;
	private JTextField crp;
	private JTextField excod;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mex frame = new mex();
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
	public mex() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setBackground(UIManager.getColor("Button.highlight"));
		setTitle("Modificar existencia");
		parse parsex = new parse();
		parsex.parseexistencias();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 353);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDelCliente = new JLabel("Modificar Existencia");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		can = new JTextField();
		can.setBounds(146, 111, 296, 20);
		contentPane.add(can);
		can.setColumns(10);
		
		sit = new JTextField();
		sit.setBounds(146, 142, 296, 20);
		contentPane.add(sit);
		sit.setColumns(10);
		
		prop = new JTextField();
		prop.setBounds(146, 173, 296, 101);
		contentPane.add(prop);
		prop.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Cantidad");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 111, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Sitio");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 142, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Proposito");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 173, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		crp = new JTextField();
		crp.setColumns(10);
		crp.setBounds(146, 80, 296, 20);
		contentPane.add(crp);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de Producto");
		lblCodigoDeProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeProducto.setBounds(10, 80, 126, 14);
		contentPane.add(lblCodigoDeProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.textHighlightText);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String excodt = excod.getText();
				String crpt = crp.getText();
				String cantt = can.getText();
				String sitt = sit.getText();
				String prt = prop.getText();
				sql order = new sql();
				order.mex(excodt, crpt, cantt, sitt, prt);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setBounds(146, 280, 89, 23);
		contentPane.add(btnAceptar);
		
		excod = new JTextField();
		excod.setBounds(146, 49, 107, 20);
		contentPane.add(excod);
		excod.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String excodt = excod.getText();
				int ciftest = 0;
				for (int i = 0; i < parsex.arrayexistencias.length; i++) {
					if (excodt.equals(parsex.arrayexistencias[i][0])) {
						crp.setText(parsex.arrayexistencias[i][1]);
						can.setText(parsex.arrayexistencias[i][2]);
						sit.setText(parsex.arrayexistencias[i][3]);
						prop.setText(parsex.arrayexistencias[i][4]);
						ciftest++;
					}
					if (parsex.arrayalbaranes[i][0] == null) {
						i = parsex.arrayexistencias.length;
					}
				}
				if (ciftest == 1) {
					btnAceptar.setEnabled(true);
				}
				if (ciftest == 0) {
					JOptionPane.showMessageDialog(null, "El codigo de existencia que buscas no existe");
				}
				
			}
		});
		btnCargar.setBounds(263, 46, 89, 23);
		contentPane.add(btnCargar);
		
		JLabel lblCodigoExistencia = new JLabel("Codigo Existencia");
		lblCodigoExistencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoExistencia.setBounds(34, 55, 102, 14);
		contentPane.add(lblCodigoExistencia);
	}
}

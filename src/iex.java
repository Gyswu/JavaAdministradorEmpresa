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
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class iex extends JFrame {

	private JPanel contentPane;
	private JTextField can;
	private JTextField sit;
	private JTextField prop;
	private JTextField crp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iex frame = new iex();
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
	public iex() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setForeground(UIManager.getColor("Button.highlight"));
		setTitle("Nueva existencia");
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 334);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		can = new JTextField();
		can.setBounds(146, 92, 296, 20);
		contentPane.add(can);
		can.setColumns(10);
		
		sit = new JTextField();
		sit.setBounds(146, 123, 296, 20);
		contentPane.add(sit);
		sit.setColumns(10);
		
		prop = new JTextField();
		prop.setBounds(146, 154, 296, 101);
		contentPane.add(prop);
		prop.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Cantidad");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 92, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Sitio");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 123, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Proposito");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 154, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblDatosDelCliente = new JLabel("Nueva Existencia");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		crp = new JTextField();
		crp.setColumns(10);
		crp.setBounds(146, 61, 296, 20);
		contentPane.add(crp);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de Producto");
		lblCodigoDeProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeProducto.setBounds(10, 61, 126, 14);
		contentPane.add(lblCodigoDeProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.textHighlightText);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String crpt = crp.getText();
				String cantt = can.getText();
				String sitt = sit.getText();
				String prt = prop.getText();
				sql order = new sql();
				order.addex(crpt, cantt, sitt, prt);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setBounds(146, 266, 89, 23);
		contentPane.add(btnAceptar);
	}
}

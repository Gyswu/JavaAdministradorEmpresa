import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mpe extends JFrame {

	private JPanel contentPane;
	private JTextField cif;
	private JTextField rz;
	private JTextField tlf;
	private JTextField ce;
	private JTextField dir;
	private JTextField nc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mpe frame = new mpe();
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
	public mpe() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		parse parsex = new parse();
		parsex.parsepe();
		
		
		setBackground(Color.WHITE);
		setTitle("Daros de Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 291);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCif = new JLabel("CIF");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 70, 140, 14);
		contentPane.add(lblCif);
		
		JLabel lblRazonSocial = new JLabel("Razon Social");
		lblRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRazonSocial.setBounds(10, 95, 140, 14);
		contentPane.add(lblRazonSocial);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(10, 120, 140, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setBounds(10, 145, 140, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 170, 140, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblNumeroDeCuenta = new JLabel("Numero de Cuenta");
		lblNumeroDeCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeCuenta.setBounds(10, 195, 140, 14);
		contentPane.add(lblNumeroDeCuenta);
		
		cif = new JTextField();
		cif.setBounds(190, 67, 207, 20);
		contentPane.add(cif);
		cif.setColumns(10);
		
		rz = new JTextField();
		rz.setBounds(190, 92, 207, 20);
		contentPane.add(rz);
		rz.setColumns(10);
		
		tlf = new JTextField();
		tlf.setBounds(190, 117, 207, 20);
		contentPane.add(tlf);
		tlf.setColumns(10);
		
		ce = new JTextField();
		ce.setBounds(190, 142, 207, 20);
		contentPane.add(ce);
		ce.setColumns(10);
		
		dir = new JTextField();
		dir.setBounds(190, 167, 207, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		nc = new JTextField();
		nc.setBounds(190, 192, 207, 20);
		contentPane.add(nc);
		nc.setColumns(10);
		
		cif.setText(parsex.arraype[0][0]);
		rz.setText(parsex.arraype[0][1]);
		tlf.setText(parsex.arraype[0][2]);
		ce.setText(parsex.arraype[0][3]);
		dir.setText(parsex.arraype[0][4]);
		nc.setText(parsex.arraype[0][5]);
		
		JButton btnGuardar = new JButton("Guardar todo");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cift = cif.getText();
				String rzt = rz.getText();
				String tlft = tlf.getText();
				String cet = ce.getText();
				String dirt = dir.getText();
				String nct = nc.getText();
				String ocif = parsex.arraype[0][0];
				sql order = new sql();
				order.mpe(cift, rzt, tlft, cet, dirt, nct, ocif);
			}
		});
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(190, 218, 207, 23);
		contentPane.add(btnGuardar);
		
		JLabel tit = new JLabel("Datos de empresa");
		tit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tit.setHorizontalAlignment(SwingConstants.CENTER);
		tit.setBounds(10, 11, 410, 48);
		contentPane.add(tit);
	}

}

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

public class mprd extends JFrame {

	private JPanel contentPane;
	private JTextField np;
	private JTextField pn;
	private JTextField pvp;
	private JTextField vrp;
	private JTextField fm;
	private JTextField desc;
	private JTextField ex;
	private JTextField cod;
	/**
	 * Launch the application.
	 */
	private String od = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mprd frame = new mprd();
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
	public mprd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setBackground(Color.WHITE);
		setTitle("Modificacion Producto");
		parse parsex = new parse();
		try {
			parsex.parseproductos();
			parsex.parseprov();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		np = new JTextField();
		np.setBounds(146, 92, 296, 20);
		contentPane.add(np);
		np.setColumns(10);
		
		pn = new JTextField();
		pn.setBounds(146, 123, 296, 20);
		contentPane.add(pn);
		pn.setColumns(10);
		
		pvp = new JTextField();
		pvp.setBounds(146, 154, 296, 20);
		contentPane.add(pvp);
		pvp.setColumns(10);
		
		vrp = new JTextField();
		vrp.setBounds(146, 185, 296, 20);
		contentPane.add(vrp);
		vrp.setColumns(10);
		
		fm = new JTextField();
		fm.setBounds(146, 216, 296, 20);
		contentPane.add(fm);
		fm.setColumns(10);
		
		desc = new JTextField();
		desc.setBounds(146, 276, 296, 101);
		contentPane.add(desc);
		desc.setColumns(10);
		
		JLabel lblRaznSocial = new JLabel("Nombre del producto");
		lblRaznSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaznSocial.setBounds(10, 92, 126, 14);
		contentPane.add(lblRaznSocial);
		
		JLabel lblCif = new JLabel("Precio Neto");
		lblCif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCif.setBounds(10, 123, 126, 14);
		contentPane.add(lblCif);
		
		JLabel lblNumeroTelefono = new JLabel("Precio venta al publico");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 154, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblCorreoElectronico = new JLabel("Codigo Ref. Proveedor");
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreoElectronico.setBounds(10, 185, 126, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblDireccion = new JLabel("Familia");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 216, 126, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblMetodoDePago = new JLabel("Existencias");
		lblMetodoDePago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetodoDePago.setBounds(10, 247, 126, 14);
		contentPane.add(lblMetodoDePago);
		
		JLabel lblObservaciones = new JLabel("Descripcion");
		lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservaciones.setBounds(10, 276, 126, 14);
		contentPane.add(lblObservaciones);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Producto");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		ex = new JTextField();
		ex.setColumns(10);
		ex.setBounds(146, 247, 296, 20);
		contentPane.add(ex);
		
		cod = new JTextField();
		cod.setColumns(10);
		cod.setBounds(146, 61, 99, 20);
		contentPane.add(cod);
		
		JLabel lblCodigoDeProducto = new JLabel("Codigo de Producto");
		lblCodigoDeProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoDeProducto.setBounds(10, 61, 126, 14);
		contentPane.add(lblCodigoDeProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codt = cod.getText();
				String npt = np.getText();
				String pnt = pn.getText();
				String pvpt = pvp.getText();
				String crpt = vrp.getText();
				String fmt = fm.getText();
				String ext = ex.getText();
				String desct = desc.getText();
				sql order = new sql();
				order.mprd(od, codt, npt, pvpt, crpt, fmt, ext, desct);
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
				
				btnAceptar.setEnabled(false);
				String crpt = vrp.getText();
				int ciftest1 = 0;
				for (int i = 0; i < parsex.arrayprv.length; i++) {
					if (crpt.equals(parsex.arrayprv[i][0])) {
						ciftest1 = 2;
					}
					if (parsex.arrayprv[i][0] == null) {
						i = parsex.arrayprv.length;
					}
				}
				
				if (ciftest1 == 2) {
					btnAceptar.setEnabled(true);
				}
				if (ciftest1 == 0) {
					JOptionPane.showMessageDialog(null, "No existe un proveedor con el codigo que indicas");
				}
				
			}
		});
		btnComprobar.setBounds(146, 388, 126, 23);
		contentPane.add(btnComprobar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codt = cod.getText();
				for (int i = 0; i < parsex.arrayproductos.length; i++) {
					if (codt.equals(parsex.arrayproductos[i][0])) {
						od = parsex.arrayproductos[i][0];
						pn.setText(parsex.arrayproductos[i][3]);
						pvp.setText(parsex.arrayproductos[i][4]);
						vrp.setText(parsex.arrayproductos[i][5]);
						fm.setText(parsex.arrayproductos[i][6]);
						ex.setText(parsex.arrayproductos[i][7]);
						desc.setText(parsex.arrayproductos[i][2]);
						np.setText(parsex.arrayproductos[i][1]);
					}
					if (parsex.arrayproductos[i][0] == null) {
						i = parsex.arrayproductos.length;
					}
				}
				String npt = np.getText();
				String pnt = pn.getText();
				String pvpt = pvp.getText();
				String crpt = vrp.getText();
				String fmt = fm.getText();
				String ext = ex.getText();
				String desct = desc.getText();
			}
		});
		btnCargar.setBounds(255, 58, 89, 23);
		contentPane.add(btnCargar);
	}
}

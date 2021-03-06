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

public class dprd extends JFrame {

	private JPanel contentPane;
	private JTextField cdc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dprd frame = new dprd();
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
	public dprd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\logoxxx.png"));
		setBackground(Color.WHITE);
		setTitle("Baja de un producto");
		parse parsex = new parse();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 154);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cdc = new JTextField();
		cdc.setBounds(146, 56, 296, 20);
		contentPane.add(cdc);
		cdc.setColumns(10);
		
		JLabel lblNumeroTelefono = new JLabel("Codigo de Producto");
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTelefono.setBounds(10, 56, 126, 14);
		contentPane.add(lblNumeroTelefono);
		
		JLabel lblDatosDelCliente = new JLabel("Baja de un producto");
		lblDatosDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setBounds(10, 11, 432, 34);
		contentPane.add(lblDatosDelCliente);
		
		JButton btnAceptar = new JButton("Eliminar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cdct = cdc.getText();
				sql order = new sql();
				order.dpro(cdct);
				btnAceptar.setEnabled(false);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(282, 87, 126, 23);
		contentPane.add(btnAceptar);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.setBackground(Color.WHITE);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cdct = cdc.getText();
				try {
					parsex.parseproductos();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnAceptar.setEnabled(false);

				int ciftest = 0;
				for (int i = 0; i < parsex.arrayproductos.length; i++) {
					if (cdct.equals(parsex.arrayproductos[i][0])) {
						ciftest = 2;
					}
					if (parsex.arrayproductos[i][0] == null) {
						i = parsex.arrayproductos.length;
					}
				}
				
				if (ciftest == 0) {
					JOptionPane.showMessageDialog(null, "No existe ningun producto con el codigo que intentas eliminar");
				}
				if (ciftest == 2) {
					btnAceptar.setEnabled(true);
				}
				
			}
		});
		btnComprobar.setBounds(146, 87, 126, 23);
		contentPane.add(btnComprobar);
	}
}

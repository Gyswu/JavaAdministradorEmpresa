import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;


public class request extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					request frame = new request();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public request() {
		setTitle("Gestor de Empresa - Ruta de Archivo");
		setBackground(Color.WHITE);
		routes route = new routes();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 162);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduceLaRuta = new JLabel("Introduce la ruta del directorio en el que esta el archivo JSON");
		lblIntroduceLaRuta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLaRuta.setBounds(10, 31, 494, 14);
		contentPane.add(lblIntroduceLaRuta);
		
		textField = new JTextField();
		textField.setBounds(10, 63, 494, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JCheckBox check = new JCheckBox("Modo sin conexion");
		check.setBackground(Color.WHITE);
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Coge la ruta y la carga en el archivo routes, tambien define el estado de "Sin Conexion"
				 */
				String ruta = textField.getText();
				File r = new File(ruta);
				if (r.isDirectory()) {
					route.setrutaarchivo(ruta);
					if (check.isSelected()) {
						route.setoff();
						maine frame;
						try {
							frame = new maine();
							frame.setVisible(true);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					if (!check.isSelected()) {
						route.seton();
						ip frame;
						frame = new ip();
						frame.setVisible(true);
					}
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ruta incorrecta");
				}
				
			}
		});
		btnConfirmar.setBounds(376, 94, 128, 23);
		contentPane.add(btnConfirmar);
		
		check.setBounds(10, 97, 361, 23);
		contentPane.add(check);
	}
}

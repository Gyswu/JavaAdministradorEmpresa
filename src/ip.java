import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ip frame = new ip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
ip() {
	setBackground(Color.WHITE);
		setTitle("Administrador de Empresa - IP de la base de datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 143);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIndicaLaIp = new JLabel("Indica la IP del servidor");
		lblIndicaLaIp.setBounds(10, 20, 414, 14);
		contentPane.add(lblIndicaLaIp);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				routes router = new routes();
				router.setip(textField.getText());
				maine frame;
				try {
					frame = new maine();
					frame.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnAceptar.setBounds(157, 76, 89, 23);
		contentPane.add(btnAceptar);
	}

}

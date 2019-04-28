package alert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class exit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exit frame = new exit();
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
	public exit() {
		initComponent();
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	public void initComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 120);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldeseaSalir = new JLabel("\u00BFDesea salir?");
		lbldeseaSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lbldeseaSalir.setFont(new Font("Consolas", Font.BOLD, 14));
		lbldeseaSalir.setBounds(10, 11, 260, 14);
		contentPane.add(lbldeseaSalir);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAceptar.setFont(new Font("Consolas", Font.ITALIC, 12));
		btnAceptar.setBounds(10, 58, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Consolas", Font.ITALIC, 12));
		btnCancelar.setBounds(174, 58, 96, 23);
		contentPane.add(btnCancelar);
	}
}

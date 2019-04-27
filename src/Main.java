import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import mysql.conexion;
import alert.database_error;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setUndecorated(true);
		setName("main");
		initComponent();
		setLocationRelativeTo(null);
	}
	
	private void initComponent() {
		setResizable(false);
		setAutoRequestFocus(false);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTituloDelPrograma = new JLabel("Titulo del programa centrado");
		lblTituloDelPrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloDelPrograma.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTituloDelPrograma.setFont(new Font("Consolas", Font.BOLD, 17));
		lblTituloDelPrograma.setBounds(0, 22, 600, 16);
		panel.add(lblTituloDelPrograma);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Consolas", Font.ITALIC, 12));
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(198, 170, 222, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(198, 265, 222, 20);
		panel.add(txtPassword);
		
		JLabel lblUsuarioOIdentificacin = new JLabel("Usuario o identificaci\u00F3n");
		lblUsuarioOIdentificacin.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblUsuarioOIdentificacin.setBounds(198, 142, 222, 16);
		panel.add(lblUsuarioOIdentificacin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblContrasea.setBounds(198, 237, 222, 16);
		panel.add(lblContrasea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setRequestFocusEnabled(false);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Input != null*/
				//try {
				String data = null;
				String usuario = txtUser.getText();
				String password = new String (txtPassword.getPassword());
				try {
					if(txtUser.getText().isEmpty() || txtPassword.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Revise los campos, estan vacios.");
					else {
						conexion conector = new conexion();
						Connection connect = conector.conexion();
						String sentencia = "SELECT * FROM user WHERE user ='"+usuario+"' AND password ='"+password+"'";
						try {
							Statement st = (Statement) connect.createStatement();
							ResultSet rs = st.executeQuery(sentencia);
							while(rs.next()) { /*Metodo para buscar la sentencia devuelve un boolean*/
								data = rs.getString("idUser");
							}
							if(data == null) { /*Busca el Id y si no lo encuentra retorna null*/
								JOptionPane.showMessageDialog(null, "No hay ningun usuario asociado.");
							}else {
								Home windowHome = new Home();
								windowHome.setVisible(true);
								dispose();
							}
						} catch (SQLException e) {
							database_error window = new database_error();
							window.setVisible(true);
						}
					}
				}catch(NullPointerException errorNull) {
					
				}
			}
		});
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnIngresar.setBackground(Color.WHITE);
				btnIngresar.setForeground(Color.BLACK);
			}
		});
		btnIngresar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnIngresar.setBackground(new Color(12, 149, 37));
				btnIngresar.setForeground(Color.WHITE);
			}
		});
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFocusable(false);
		btnIngresar.setFocusTraversalKeysEnabled(false);
		btnIngresar.setFocusPainted(false);
		btnIngresar.setBorderPainted(false);
		btnIngresar.setFont(new Font("Consolas", Font.BOLD, 14));
		btnIngresar.setBounds(198, 308, 222, 26);
		panel.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBorderPainted(false);
		btnSalir.setRequestFocusEnabled(false);
		btnSalir.setFocusable(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnSalir.setBackground(new Color(240, 52, 52));
				btnSalir.setForeground(Color.WHITE);
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBackground(Color.WHITE);
				btnSalir.setForeground(Color.BLACK);
			}
		});
		btnSalir.setFont(new Font("Consolas", Font.ITALIC, 12));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(12, 412, 98, 26);
		panel.add(btnSalir);
	}
}

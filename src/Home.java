import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import alert.exit;
import layout.AddProducto;

import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setUndecorated(true);
		setResizable(false);
		initComponent();
		setLocationRelativeTo(null);
	}
	
	public void initComponent() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnSalir.setBackground(new Color(240, 52, 52));
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSalir.setBackground(new Color(154, 205, 50));
				btnSalir.setForeground(new Color(255, 255, 255));
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(154, 205, 50));
		btnSalir.setBorder(null);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit windowExit = new exit();
				windowExit.setVisible(true);
			}
		});
		btnSalir.setFocusable(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBounds(711, 0, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 24, 780, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddProducto = new JButton("Agregar producto");
		btnAddProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProducto window = new AddProducto();
				window.setVisible(true);
			}
		});
		btnAddProducto.setForeground(Color.WHITE);
		btnAddProducto.setBackground(Color.GRAY);
		btnAddProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAddProducto.setBackground(Color.GRAY);
				btnAddProducto.setForeground(Color.WHITE);
			}
		});
		btnAddProducto.setFocusable(false);
		btnAddProducto.setFocusTraversalKeysEnabled(false);
		btnAddProducto.setFocusPainted(false);
		btnAddProducto.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnAddProducto.setBackground(new Color(10, 15, 6));
				btnAddProducto.setForeground(Color.white);
			}
		});
		btnAddProducto.setBorder(null);
		btnAddProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddProducto.setFont(new Font("Consolas", Font.ITALIC, 13));
		btnAddProducto.setBounds(10, 11, 201, 182);
		panel.add(btnAddProducto);
		
		JButton btnModificar = new JButton("Modificar producto");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setActionCommand("Modificar producto");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Consolas", Font.ITALIC, 13));
		btnModificar.setFocusable(false);
		btnModificar.setFocusTraversalKeysEnabled(false);
		btnModificar.setFocusPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.GRAY);
		btnModificar.setBounds(291, 11, 201, 182);
		panel.add(btnModificar);
		
		JButton btnDelete = new JButton("Eliminar producto");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setActionCommand("Delete producto");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Consolas", Font.ITALIC, 13));
		btnDelete.setFocusable(false);
		btnDelete.setFocusTraversalKeysEnabled(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setBackground(Color.GRAY);
		btnDelete.setBounds(567, 11, 201, 182);
		panel.add(btnDelete);
	}
}

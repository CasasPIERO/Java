package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField cajaNombre1;
	private JTextField cajaNombre2;
	private JButton botonGuardar;
	private String usuario1;
	private String usuario2;
	private JLabel etiquetaMuestra1;
	private JLabel etiquetaMuestra2;
	private JButton botonComenzar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
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
	public VentanaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 461);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel etiquetaTitulo = new JLabel("Tres en Raya");
		etiquetaTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(0, 28, 704, 36);
		panel.add(etiquetaTitulo);
		
		JLabel etiquetaNombre1 = new JLabel("Digite el nombre del Usuario 1:");
		etiquetaNombre1.setFont(new Font("Arial", Font.PLAIN, 18));
		etiquetaNombre1.setBounds(49, 113, 263, 20);
		panel.add(etiquetaNombre1);
		
		JLabel etiquetaNombre2 = new JLabel("Digite el nombre del Usuario 2:");
		etiquetaNombre2.setFont(new Font("Arial", Font.PLAIN, 18));
		etiquetaNombre2.setBounds(49, 164, 263, 20);
		panel.add(etiquetaNombre2);
		
		cajaNombre1 = new JTextField();
		cajaNombre1.setFont(new Font("Arial", Font.PLAIN, 14));
		cajaNombre1.setBounds(322, 113, 290, 20);
		panel.add(cajaNombre1);
		cajaNombre1.setColumns(10);
		
		cajaNombre2 = new JTextField();
		cajaNombre2.setFont(new Font("Arial", Font.PLAIN, 14));
		cajaNombre2.setBounds(322, 164, 290, 20);
		panel.add(cajaNombre2);
		cajaNombre2.setColumns(10);
		
		JLabel etiquetaGif = new JLabel("");
		etiquetaGif.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\gifcito.gif"));
		etiquetaGif.setBounds(454, 232, 240, 180);
		panel.add(etiquetaGif);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuario1 = cajaNombre1.getText();
				usuario2 = cajaNombre2.getText();
				botonGuardar.setVisible(false);
				etiquetaMuestra1.setText(usuario1 + ", jugará primero su ficha es: X");
				etiquetaMuestra2.setText(usuario2 + " su ficha es: O");
				botonComenzar.setVisible(true);
			}
		});
		botonGuardar.setFont(new Font("Arial", Font.PLAIN, 18));
		botonGuardar.setBounds(121, 215, 112, 23);
		panel.add(botonGuardar);
		
		etiquetaMuestra1 = new JLabel("");
		etiquetaMuestra1.setFont(new Font("Arial", Font.PLAIN, 18));
		etiquetaMuestra1.setBounds(49, 271, 395, 20);
		panel.add(etiquetaMuestra1);
		
		etiquetaMuestra2 = new JLabel("");
		etiquetaMuestra2.setFont(new Font("Arial", Font.PLAIN, 18));
		etiquetaMuestra2.setBounds(49, 302, 395, 20);
		panel.add(etiquetaMuestra2);
		
		botonComenzar = new JButton("Comenzar Juego");
		botonComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal p = new VentanaPrincipal(usuario1,usuario2);
				p.setVisible(true);
				dispose();
			}
		});
		botonComenzar.setVisible(false);
		botonComenzar.setFont(new Font("Arial", Font.PLAIN, 20));
		botonComenzar.setBounds(90, 352, 191, 23);
		panel.add(botonComenzar);
	}

}

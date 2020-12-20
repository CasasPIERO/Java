package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField cajaUsuario;
	private JPasswordField cajaContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 369);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario:");
		lblNombreUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombreUsuario.setBounds(10, 193, 155, 14);
		panel.add(lblNombreUsuario);
		
		cajaUsuario = new JTextField();
		cajaUsuario.setForeground(Color.BLACK);
		cajaUsuario.setBackground(Color.WHITE);
		cajaUsuario.setBounds(175, 191, 153, 20);
		panel.add(cajaUsuario);
		cajaUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(10, 243, 138, 14);
		panel.add(lblContrasea);
		
		JButton btnIniciarSesion = new JButton("Aceptar\r\n");
		btnIniciarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = cajaUsuario.getText();
				String contraseña = new String(cajaContraseña.getPassword());
				
				if(usuario.equals("") || contraseña.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
				}else{
					if(usuario.equals("colegioamericana.edu.pe") && contraseña.equals("68652f31009")){
						VentanaInicio ventana = new VentanaInicio();
						ventana.setVisible(true);
						dispose();
						
					}else{
						JOptionPane.showMessageDialog(null, "Datos Incorrectos","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnIniciarSesion.setBounds(175, 285, 112, 23);
		panel.add(btnIniciarSesion);
		
		JLabel lblInicioDeSesion = new JLabel("Inicio de Sesi\u00F3n");
		lblInicioDeSesion.setBackground(new Color(153, 255, 102));
		lblInicioDeSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesion.setBounds(10, 128, 441, 38);
		panel.add(lblInicioDeSesion);
		
		cajaContraseña = new JPasswordField();
		cajaContraseña.setForeground(Color.BLACK);
		cajaContraseña.setBackground(Color.WHITE);
		cajaContraseña.setBounds(175, 241, 153, 20);
		panel.add(cajaContraseña);
		
		
		ImageIcon imagen = new ImageIcon("loginfifi.png");
		JLabel label = new JLabel("");
		label.setBounds(351, 177, 100, 100);
		label.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(label.getWidth(),label.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(label);
		
		ImageIcon imagen2 = new ImageIcon("titulo.png");
		JLabel etiquetaTitulo = new JLabel();
		etiquetaTitulo.setBounds(22, 28, 417, 75);
		etiquetaTitulo.setIcon(new ImageIcon (imagen2.getImage().getScaledInstance(etiquetaTitulo.getWidth(),etiquetaTitulo.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(etiquetaTitulo);
		
		ImageIcon imagen1= new ImageIcon("fondologin.png");
		JLabel etiquetaFondo = new JLabel();
		etiquetaFondo.setBounds(0, 0, 461, 331);
		etiquetaFondo.setIcon(new ImageIcon (imagen1.getImage().getScaledInstance(etiquetaFondo.getWidth(),etiquetaFondo.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(etiquetaFondo);
	}
}

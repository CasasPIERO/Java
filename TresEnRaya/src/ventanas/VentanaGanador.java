package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaGanador extends JDialog {
	private String usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaGanador dialog = new VentanaGanador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaGanador(String usuario) {
		this.usuario = usuario;
		setBounds(100, 100, 517, 244);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalir.setBounds(402, 166, 89, 23);
		panel.add(btnSalir);
		
		JButton btnJugarDeNuevo = new JButton("Jugar de nuevo");
		btnJugarDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnJugarDeNuevo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnJugarDeNuevo.setBounds(346, 132, 145, 23);
		panel.add(btnJugarDeNuevo);
		
		JLabel lblGan = new JLabel("Ganaste!!!");
		lblGan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblGan.setBounds(10, 166, 175, 29);
		panel.add(lblGan);
		
		JLabel lblFelicitaciones = new JLabel("Felicitaciones " + usuario);
		lblFelicitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblFelicitaciones.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblFelicitaciones.setBounds(0, 11, 500, 29);
		panel.add(lblFelicitaciones);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 500, 204);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\ganador.gif"));
		panel.add(lblNewLabel);
	}
}

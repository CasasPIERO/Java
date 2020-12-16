package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEmpate extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaEmpate dialog = new VentanaEmpate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaEmpate() {
		
		setBounds(100, 100, 510, 300);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel label = new JLabel("");
				label.setBounds(162, 68, 161, 160);
				label.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TresEnRaya\\empate.gif"));
				panel.add(label);
			}
			{
				JLabel lblEmpate = new JLabel("Empate");
				lblEmpate.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmpate.setForeground(Color.WHITE);
				lblEmpate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
				lblEmpate.setBounds(0, 11, 494, 36);
				panel.add(lblEmpate);
			}
			{
				JButton btnJugarDeNuevo = new JButton("Jugar de nuevo");
				btnJugarDeNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnJugarDeNuevo.setFont(new Font("Arial", Font.PLAIN, 14));
				btnJugarDeNuevo.setBounds(96, 228, 152, 23);
				panel.add(btnJugarDeNuevo);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				btnSalir.setFont(new Font("Arial", Font.PLAIN, 14));
				btnSalir.setBounds(301, 228, 89, 23);
				panel.add(btnSalir);
			}
		}
	}

}

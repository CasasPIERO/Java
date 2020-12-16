package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaTurno extends JDialog {
	
	private String usuario1,usuario2;
	private String turno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaTurno dialog = new VentanaTurno(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public String getTurno(){
		return turno;
	}
	
	public VentanaTurno(String usuario,String usuarios) {
		this.usuario1 = usuario;
		this.usuario2 = usuarios;
		setBounds(100, 100, 567, 180);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblquinJuegaPrimero = new JLabel("\u00BFQui\u00E9n juega primero?");
				lblquinJuegaPrimero.setHorizontalAlignment(SwingConstants.CENTER);
				lblquinJuegaPrimero.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
				lblquinJuegaPrimero.setBounds(0, 11, 551, 57);
				panel.add(lblquinJuegaPrimero);
			}
			{
				JButton btnNewButton = new JButton(usuario1);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						turno = "usuario1";
						dispose();
					}
				});
				btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
				btnNewButton.setBounds(85, 91, 160, 23);
				panel.add(btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton(usuario2);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						turno = "usuario2";
						dispose();
					}
				});
				btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
				btnNewButton_1.setBounds(306, 91, 160, 23);
				panel.add(btnNewButton_1);
			}
		}
	}

}

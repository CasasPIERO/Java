package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

public class VentanaResultados extends JDialog {
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private String usuario1, usuario2;
	private int gano1, gano2, empate;
	private JScrollPane p;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaResultados dialog = new VentanaResultados(null,null,0,0,0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void cargarDatosTabla(){
		modeloTabla.addColumn("Nº victorias de " + usuario1);
		modeloTabla.addColumn("Nº victorias de " + usuario2);
		modeloTabla.addColumn("Nº de empates");
		
		String[] fila = {String.valueOf(gano1),String.valueOf(gano2),String.valueOf(empate)};
		
		modeloTabla.addRow(fila);
	}
	
	/**
	 * Create the dialog.
	 */
	public VentanaResultados(String usuario1, String usuario2, int gano1, int gano2, int empate) {
		setBounds(100, 100, 581, 243);
		this.setLocationRelativeTo(null);
		this.usuario1 = usuario1;
		this.usuario2 = usuario2;
		this.gano1 = gano1;
		this.gano2 = gano2;
		this.empate = empate;
		cargarDatosTabla();
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblTablaDe = new JLabel("Tabla de resultados");
				lblTablaDe.setFont(new Font("Arial", Font.PLAIN, 36));
				panel.add(lblTablaDe, BorderLayout.NORTH);
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.SOUTH);
				{
					JButton btnRegresar = new JButton("Regresar");
					btnRegresar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
					btnRegresar.setFont(new Font("Arial", Font.PLAIN, 14));
					panel_1.add(btnRegresar);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);
				
				table = new JTable(modeloTabla);
				table.setBounds(0, 0, 565, 127);
				panel_1.add(table);
				
				JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setBounds(0, 0, 565, 127);
				panel_1.add(scrollPane);
			}
		}
	}
}

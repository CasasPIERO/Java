package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Coneccion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentanaGeneral extends JFrame {

	private JPanel contentPane;
	public JTable tablaAlumno;
	private JScrollPane p,p2;
	private JTable tablaMuestra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGeneral frame = new VentanaGeneral(null);
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
	public VentanaGeneral(DefaultTableModel modelo) {
		setTitle("Lista de Alumnos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblListaAlumnos = new JLabel("Lista de alumnos matriculados");
		lblListaAlumnos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblListaAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaAlumnos.setBounds(10, 30, 657, 36);
		panel.add(lblListaAlumnos);
		
		tablaAlumno = new JTable();
		tablaAlumno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				DefaultTableModel modelo = new DefaultTableModel();
				tablaMuestra.setModel(modelo);
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					int fila = tablaAlumno.getSelectedRow();
					int codigo = Integer.parseInt(tablaAlumno.getValueAt(fila, 0).toString());
					
					ps = conexion.prepareStatement("select nombre_m,nombre_p"
							+ " from materia_alumno inner join materia on materia_alumno.clave_m1 = materia.clave_m"
							+ " inner join materia_profesor on materia_profesor.clave_m2 = materia.clave_m"
							+ " inner join profesor on profesor.clave_p = materia_profesor.clave_p2"
							+ " where matricula_alu2=?");
					ps.setInt(1, codigo);
					rs = ps.executeQuery();
					
					modelo.addColumn("Curso");
					modelo.addColumn("Profesor");
					
					while(rs.next()){
						Object fila2[] = new Object[2];
						for(int i=0;i<2;i++){
							fila2[i] = rs.getObject(i+1);
						}
						
						modelo.addRow(fila2);
					}
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
			}
		});
		tablaAlumno.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Secci\u00F3n", "Grado"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaAlumno.setModel(modelo);
		tablaAlumno.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaAlumno.setBounds(10, 95, 367, 156);
		panel.add(tablaAlumno);
		
		p = new JScrollPane(tablaAlumno,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.setBounds(10, 95, 367, 156);
		panel.add(p);
		
		tablaMuestra = new JTable();
		tablaMuestra.setRowHeight(20);
		tablaMuestra.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Curso", "Profesor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaMuestra.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablaMuestra.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaMuestra.setBounds(387, 121, 280, 101);
		panel.add(tablaMuestra);
		
		p2 = new JScrollPane(tablaMuestra,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p2.setBounds(387, 121, 280, 101);
		panel.add(p2);
		
		ImageIcon imagen = new ImageIcon("fondologin.png");
		JLabel etiquetaFondo = new JLabel();
		etiquetaFondo.setBounds(0, 0, 677, 262);
		etiquetaFondo.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(etiquetaFondo.getWidth(),etiquetaFondo.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(etiquetaFondo);
	}
}

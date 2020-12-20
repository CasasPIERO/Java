package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import modelo.Coneccion;
import modelo.ConsultasCurso;
import modelo.Profesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentanaCursos extends JFrame {

	private JPanel contentPane;
	private JTable tablaCursos;
	private JTable tablaMuestra;
	private JTextField cajaBuscar;
	private JScrollPane p;
	private JScrollPane p2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCursos frame = new VentanaCursos();
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
	public VentanaCursos() {
		setTitle("Lista de cursos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 343);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tablaCursos = new JTable();
		tablaCursos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo del curso", "Nombre del Curso"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaCursos.setBounds(30, 111, 253, 162);
		panel.add(tablaCursos);
		
		p = new JScrollPane(tablaCursos,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.setBounds(30, 111, 253, 162);
		panel.add(p);
		
		JLabel lblListaDeCursos = new JLabel("Lista de Cursos");
		lblListaDeCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeCursos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblListaDeCursos.setBounds(10, 25, 734, 31);
		panel.add(lblListaDeCursos);
		
		tablaMuestra = new JTable();
		tablaMuestra.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo del Curso", "Nombre del Curso", "Nombre del Profesor"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaMuestra.getColumnModel().getColumn(0).setPreferredWidth(93);
		tablaMuestra.getColumnModel().getColumn(1).setPreferredWidth(130);
		tablaMuestra.getColumnModel().getColumn(2).setPreferredWidth(150);
		tablaMuestra.setBounds(341, 185, 420, 55);
		panel.add(tablaMuestra);
		
		p2 = new JScrollPane(tablaMuestra,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p2.setBounds(324, 185, 420, 55);
		panel.add(p2);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!"".equals(cajaBuscar.getText())){
					Curso curso = new Curso();
					Profesor profesor = new Profesor();
					ConsultasCurso consulta = new ConsultasCurso();
					curso.setCodigo(Integer.parseInt(cajaBuscar.getText()));
					
					if(consulta.buscar(curso, profesor)){
						DefaultTableModel modelo1 = new DefaultTableModel();
						tablaMuestra.setModel(modelo1);
						modelo1.addColumn("Código del Curso");
						modelo1.addColumn("Nombre del Curso");
						modelo1.addColumn("Nombre del Profesor");
						Object[] fila = {curso.getCodigo(),curso.getNombre(),profesor.getNombre()};
						modelo1.addRow(fila);
						
					}else{
						JOptionPane.showMessageDialog(null, "NO existe un curso con esa clave");
					}
				}			
			}
		});
		botonBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonBuscar.setBounds(616, 131, 89, 23);
		panel.add(botonBuscar);
		
		cajaBuscar = new JTextField();
		cajaBuscar.setBounds(476, 133, 130, 20);
		panel.add(cajaBuscar);
		cajaBuscar.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo del curso:");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCdigo.setBounds(344, 133, 122, 19);
		panel.add(lblCdigo);
		
		JButton btnCargarTabla = new JButton("Cargar Tabla");
		btnCargarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps;
				ResultSet rs;
				
				
				DefaultTableModel modelo = new DefaultTableModel();
				tablaCursos.setModel(modelo);
				
				String campo = cajaBuscar.getText();
				String where = "";
				
				if(!"".equals(campo)){
					where = "where matricula_alu = " + Integer.parseInt(campo);
				}
				
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					ps = conexion.prepareStatement("select * from materia " + where);
					rs = ps.executeQuery();
					
					modelo.addColumn("Código del curso");
					modelo.addColumn("Nombre del Curso");
					
					/*int anchos[] = {180,200,50,100,100,100};
					
					for(int i = 0;i<6;i++){
						tablaCursos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					}
					*/
					
					while(rs.next()){
						Object fila[] = new Object[2];
						for(int i=0;i<2;i++){
							fila[i] = rs.getObject(i+1);
						}
						
						modelo.addRow(fila);
					}
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
			}
		});
		btnCargarTabla.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCargarTabla.setBounds(93, 77, 119, 23);
		panel.add(btnCargarTabla);
		
		ImageIcon imagen = new ImageIcon("fondologin.png");
		JLabel etiquetaFondo = new JLabel();
		etiquetaFondo.setBounds(0, 0, 754, 305);
		etiquetaFondo.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(etiquetaFondo.getWidth(),etiquetaFondo.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(etiquetaFondo);
	}
}

package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Coneccion;
import modelo.Alumno;
import modelo.ConsultasAlumno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	public JTextField cajaCodigo;
	private JTextField cajaNombre;
	private JTable table;
	private JScrollPane p;
	private JTextField cajaBuscar;
	private JComboBox comboGenero;
	private JButton botonEliminar;
	private JButton botonModificar;
	private JButton botonGuardar;
	private JButton botonLimpiar;
	private JComboBox comboSeccion;
	private JComboBox comboGrado;
	private JButton botonBuscar;
	private JSpinner numeroEdad;
	private Vector<Curso> vectorcurso = new Vector<Curso>();
	private JTextField cajaPrecio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void limpiarCajas(){
		cajaCodigo.setText(null);
		cajaNombre.setText(null);
		numeroEdad.setValue(0);
		comboGenero.setSelectedIndex(0);
		comboSeccion.setSelectedIndex(0);
		comboGrado.setModel(new DefaultComboBoxModel(new String[] {}));
		cajaPrecio.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setResizable(false);
		setTitle("Matr\u00EDcula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 463);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMen = new JMenu("Men\u00FA");
		mnMen.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnMen);
		
		JMenuItem menuProfesores = new JMenuItem("Listado de docentes");
		menuProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaProfesor vp = new VentanaProfesor();
				vp.setVisible(true);
			}
		});
		
		JMenuItem mntmListadoDeAlumnos = new JMenuItem("Listado de Alumnos");
		mntmListadoDeAlumnos.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TRABAJOFINAL\\alumno.jpg"));
		mntmListadoDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				DefaultTableModel modelo = new DefaultTableModel();
				
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					ps = conexion.prepareStatement("select matricula_alu,nombre_alu,seccion_alu,grado_alu from alumno");
					rs = ps.executeQuery();
					
					modelo.addColumn("Código");
					modelo.addColumn("Nombre");
					modelo.addColumn("Sección");
					modelo.addColumn("Grado");
					
					//int anchos[] = {180,200,50,100,100,100};
					
					/*for(int i = 0;i<6;i++){
						table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					}
					*/
					while(rs.next()){
						Object fila[] = new Object[4];
						for(int i=0;i<4;i++){
							fila[i] = rs.getObject(i+1);
						}
						
						modelo.addRow(fila);
					}
					
					conexion.close();
					
					VentanaGeneral vg = new VentanaGeneral(modelo);
					vg.setVisible(true);
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
			}
		});
		mntmListadoDeAlumnos.setFont(new Font("Arial", Font.PLAIN, 14));
		mnMen.add(mntmListadoDeAlumnos);
		menuProfesores.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TRABAJOFINAL\\menuProfesor.png"));
		menuProfesores.setFont(new Font("Arial", Font.PLAIN, 14));
		mnMen.add(menuProfesores);
		
		JMenuItem menuCursos = new JMenuItem("Listado de cursos");
		menuCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCursos vc = new VentanaCursos();
				vc.setVisible(true);
			}
		});
		menuCursos.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TRABAJOFINAL\\menuCurso.png"));
		menuCursos.setFont(new Font("Arial", Font.PLAIN, 14));
		mnMen.add(menuCursos);
		
		JSeparator separator = new JSeparator();
		mnMen.add(separator);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuSalir.setIcon(new ImageIcon("C:\\Users\\scalderon\\Desktop\\Java\\TRABAJOFINAL\\salir.png"));
		menuSalir.setFont(new Font("Arial", Font.PLAIN, 14));
		mnMen.add(menuSalir);
		
		JMenu mnPlataforma = new JMenu("Plataforma");
		mnPlataforma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.colegioamericana.edu.pe/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		});
		mnPlataforma.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnPlataforma);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnSeleccionarCursos = new JButton("Seleccionar Cursos");
		btnSeleccionarCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionarCursos sc = new SeleccionarCursos(vectorcurso);
				sc.setVisible(true);
			}
		});
		btnSeleccionarCursos.setBounds(150, 283, 149, 23);
		panel.add(btnSeleccionarCursos);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setBounds(150, 317, 149, 20);
		panel.add(cajaPrecio);
		cajaPrecio.setColumns(10);
		
		JLabel lblCosteDeMatrcula = new JLabel("Coste de matr\u00EDcula:");
		lblCosteDeMatrcula.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCosteDeMatrcula.setBounds(10, 314, 130, 20);
		panel.add(lblCosteDeMatrcula);
		
		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursos.setBounds(10, 283, 63, 20);
		panel.add(lblCursos);
		
		JLabel lblProcesoDeMatrcula = new JLabel("PROCESO DE MATR\u00CDCULA 2021");
		lblProcesoDeMatrcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcesoDeMatrcula.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 26));
		lblProcesoDeMatrcula.setBounds(10, 19, 974, 30);
		panel.add(lblProcesoDeMatrcula);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo de matr\u00EDcula:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 97, 130, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos y Nombres:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 128, 130, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 159, 46, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblSeccin = new JLabel("Secci\u00F3n:");
		lblSeccin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSeccin.setBounds(10, 221, 63, 20);
		panel.add(lblSeccin);
		
		JLabel lblGrado = new JLabel("Grado:");
		lblGrado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGrado.setBounds(10, 252, 46, 20);
		panel.add(lblGrado);
		
		JLabel lblNewLabel_3 = new JLabel("G\u00E9nero:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 190, 46, 20);
		panel.add(lblNewLabel_3);
		
		cajaCodigo = new JTextField();
		cajaCodigo.setBounds(150, 98, 149, 20);
		panel.add(cajaCodigo);
		cajaCodigo.setColumns(10);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(150, 129, 149, 20);
		panel.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		numeroEdad = new JSpinner();
		numeroEdad.setBounds(150, 160, 63, 20);
		panel.add(numeroEdad);
		
		comboGenero = new JComboBox();
		comboGenero.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar g\u00E9nero", "Femenino", "Masculino"}));
		comboGenero.setBounds(150, 191, 149, 20);
		panel.add(comboGenero);
		
		comboSeccion = new JComboBox();
		comboSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboSeccion.getSelectedItem().equals("Primaria")){
					comboGrado.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar grado", "1er grado", "2do grado", "3er grado", "4to grado", "5to grado", "6to grado"}));
					cajaPrecio.setText("250");
				}else if(comboSeccion.getSelectedItem().equals("Secundaria")){
					comboGrado.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar grado", "1er grado", "2do grado", "3er grado", "4to grado", "5to grado"}));
					cajaPrecio.setText("280");
				}
			}
		});
		comboSeccion.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar secci\u00F3n", "Primaria", "Secundaria"}));
		comboSeccion.setBounds(150, 222, 149, 20);
		panel.add(comboSeccion);
		
		comboGrado = new JComboBox();
		comboGrado.setBounds(150, 253, 149, 20);
		panel.add(comboGrado);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					int fila = table.getSelectedRow();
					int codigo = Integer.parseInt(table.getValueAt(fila, 0).toString());
					
					ps = conexion.prepareStatement("select * from alumno where matricula_alu=?");
					ps.setInt(1, codigo);
					rs = ps.executeQuery();
					
					while(rs.next()){
						cajaCodigo.setText(String.valueOf(rs.getInt("matricula_alu")));
						cajaNombre.setText(rs.getString("nombre_alu"));
						numeroEdad.setValue(rs.getInt("edad_alu"));
						comboGenero.setSelectedItem(rs.getString("genero_alu"));
						comboSeccion.setSelectedItem(rs.getString("seccion_alu"));
						comboGrado.setSelectedItem(rs.getString("grado_alu"));
					}
					
					cajaCodigo.setEditable(false);
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
			}
		});
		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo de matr\u00EDcula", "Apellidos y Nombres", "Edad", "G\u00E9nero", "Secci\u00F3n", "Grado", "Coste de matr\u00EDcula"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(6).setPreferredWidth(109);
		table.setBounds(335, 97, 639, 237);
		panel.add(table);
		
		
		
		p = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.setBounds(335, 97, 639, 237);
		panel.add(p);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				Coneccion con = new Coneccion();
				Alumno alumno = new Alumno();
				ConsultasAlumno consultas = new ConsultasAlumno();
				Curso curso = new Curso();
				
				alumno.setMatricula(Integer.parseInt(cajaCodigo.getText()));
				alumno.setNombre(cajaNombre.getText());
				alumno.setEdad((int)numeroEdad.getValue());
				alumno.setGenero(String.valueOf(comboGenero.getSelectedItem()));
				alumno.setSeccion(String.valueOf(comboSeccion.getSelectedItem()));
				alumno.setGrado(String.valueOf(comboGrado.getSelectedItem()));
				
				if(consultas.insertar(alumno,vectorcurso)){
					Connection conexion = con.getConnection();
					try{
						ps = conexion.prepareStatement("insert into matricula (id_alumno,costo) values (?,?)");
						ps.setInt(1, alumno.getMatricula());
						ps.setFloat(2, Float.parseFloat(cajaPrecio.getText()));
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
						vectorcurso.removeAllElements();
						limpiarCajas();
						
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Error al guardar el registro");
					limpiarCajas();
				}
				
			}
		});
		botonGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonGuardar.setBounds(101, 361, 89, 23);
		panel.add(botonGuardar);
		
		botonModificar = new JButton("Modificar");
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				Coneccion con = new Coneccion();
				ConsultasAlumno consulta = new ConsultasAlumno();
				Alumno alumno = new Alumno();
				alumno.setMatricula(Integer.parseInt(cajaCodigo.getText()));
				alumno.setNombre(cajaNombre.getText());
				alumno.setEdad((int)numeroEdad.getValue());
				alumno.setGenero(String.valueOf(comboGenero.getSelectedItem()));
				alumno.setSeccion(String.valueOf(comboSeccion.getSelectedItem()));
				alumno.setGrado(String.valueOf(comboGrado.getSelectedItem()));
				
				if(consulta.modificar(alumno)){
					Connection conexion = con.getConnection();
					try{
						ps = conexion.prepareStatement("update matricula set costo=? where id_alumno=?");
						ps.setFloat(1, Float.parseFloat(cajaPrecio.getText()));
						ps.setInt(2, alumno.getMatricula());
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
						limpiarCajas();
						cajaCodigo.setEditable(true);
						
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}	
				}else{
					JOptionPane.showMessageDialog(null, "Error al modificar el registro");
					limpiarCajas();
					cajaCodigo.setEditable(true);
				}
			}
		});
		botonModificar.setFont(new Font("Arial", Font.PLAIN, 12));		
		botonModificar.setBounds(325, 361, 89, 23);
		panel.add(botonModificar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultasAlumno consultas = new ConsultasAlumno();
				Alumno alumno = new Alumno();
				alumno.setMatricula(Integer.parseInt(cajaCodigo.getText()));
				
				if(consultas.eliminar(alumno)){
					JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
					limpiarCajas();
					cajaCodigo.setEditable(true);
				}else{
					JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
					limpiarCajas();
					cajaCodigo.setEditable(true);
				}
			}
		});
		botonEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonEliminar.setBounds(562, 361, 89, 23);
		panel.add(botonEliminar);
		
		botonLimpiar = new JButton("Limpiar");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajas();
				cajaCodigo.setEditable(true);
			}
		});
		botonLimpiar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonLimpiar.setBounds(789, 361, 89, 23);
		panel.add(botonLimpiar);
		
		cajaBuscar = new JTextField();
		cajaBuscar.setBounds(604, 66, 86, 20);
		panel.add(cajaBuscar);
		cajaBuscar.setColumns(10);
		
		botonBuscar = new JButton("Cargar tabla");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps;
				ResultSet rs,rs2;
				
				
				DefaultTableModel modelo = new DefaultTableModel();
				table.setModel(modelo);
				
				String campo = cajaBuscar.getText();
				String where = "";
				
				if(!"".equals(campo)){
					where = "where matricula_alu = " + Integer.parseInt(campo);
				}
				
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					ps = conexion.prepareStatement("select * from alumno " + where);
					rs = ps.executeQuery();
					
					modelo.addColumn("Código de matrícula");
					modelo.addColumn("Apellidos y nombres");
					modelo.addColumn("Edad");
					modelo.addColumn("Género");
					modelo.addColumn("Sección");
					modelo.addColumn("Grado");
					modelo.addColumn("Coste de matrícula");
					
					int anchos[] = {180,200,50,100,100,100,180};
					
					for(int i = 0;i<7;i++){
						table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					}
					
					while(rs.next()){
						Object fila[] = new Object[7];
						for(int i=0;i<6;i++){
							fila[i] = rs.getObject(i+1);
						}
						
						int n = (int)fila[0];
						
						ps = conexion.prepareStatement("select costo from matricula where id_alumno = ?");
						ps.setInt(1, n);
						rs2 = ps.executeQuery();
						
						while(rs2.next()){
							fila[6] = rs2.getObject(1);
						}
								
						modelo.addRow(fila);
					}
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
			}
		});
		botonBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonBuscar.setBounds(700, 63, 112, 23);
		panel.add(botonBuscar);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigo.setBounds(531, 66, 63, 20);
		panel.add(lblCdigo);
		
		ImageIcon imagen = new ImageIcon("fondologin.png");
		JLabel labelFondo = new JLabel();
		labelFondo.setFont(new Font("Arial", Font.PLAIN, 12));
		labelFondo.setBounds(0, 0, 994, 414);
		labelFondo.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(labelFondo.getWidth(),labelFondo.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(labelFondo);
	}
}

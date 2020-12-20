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
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import modelo.Coneccion;
import modelo.ConsultasProfesor;
import modelo.Profesor;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentanaProfesor extends JFrame {

	private JPanel contentPane;
	private JTable tablaProfesor;
	private JScrollPane p;
	private JTextField cajaCodigo;
	private JTextField cajaCampo;
	private JButton botonGuardar;
	private JComboBox comboCampo;
	private JLabel etiquetaCampo;
	private JButton botonCargar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProfesor frame = new VentanaProfesor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void limpiarCajas(){
		cajaCodigo.setText(null);
		comboCampo.setSelectedIndex(0);
		cajaCampo.setText(null);
		cajaCampo.setVisible(false);
		etiquetaCampo.setText(null);
		etiquetaCampo.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaProfesor() {
		setResizable(false);
		setTitle("Lista de Profesores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 849, 416);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblListadoDeProfesores = new JLabel("Listado de Profesores");
		lblListadoDeProfesores.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeProfesores.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		lblListadoDeProfesores.setBounds(10, 45, 813, 30);
		panel.add(lblListadoDeProfesores);
		
		tablaProfesor = new JTable();
		tablaProfesor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Direcci\u00F3n", "Tel\u00E9fono"
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
		tablaProfesor.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaProfesor.getColumnModel().getColumn(1).setPreferredWidth(150);
		tablaProfesor.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaProfesor.setBounds(27, 146, 351, 221);
		panel.add(tablaProfesor);
		
		p = new JScrollPane(tablaProfesor,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p.setBounds(27, 146, 385, 221);
		panel.add(p);
		
		botonCargar = new JButton("Cargar Tabla");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				DefaultTableModel modelo = new DefaultTableModel();
				tablaProfesor.setModel(modelo);
	
				try{
					Coneccion con = new Coneccion();
					Connection conexion = con.getConnection();
					
					ps = conexion.prepareStatement("select * from profesor");
					rs = ps.executeQuery();
					
					modelo.addColumn("Código");
					modelo.addColumn("Nombre");
					modelo.addColumn("Dirección");
					modelo.addColumn("Teléfono");
					
					int anchos[] = {90,220,240,130};
					
					for(int i = 0;i<4;i++){
						tablaProfesor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					}
					
					
					while(rs.next()){
						Object fila[] = new Object[4];
						for(int i=0;i<4;i++){
							fila[i] = rs.getObject(i+1);
						}
						
						modelo.addRow(fila);
					}
					
					conexion.close();
					
				}catch(Exception e){
					System.err.println("ERROR: " + e);
				}
				
			}
		});
		botonCargar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonCargar.setBounds(170, 103, 113, 23);
		panel.add(botonCargar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(422, 126, 401, 241);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigo.setBounds(58, 42, 93, 23);
		panel_1.add(lblCdigo);
		
		cajaCodigo = new JTextField();
		cajaCodigo.setBounds(161, 42, 173, 23);
		panel_1.add(cajaCodigo);
		cajaCodigo.setColumns(10);
		
		comboCampo = new JComboBox();
		comboCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!"".equals(cajaCodigo.getText())){
					PreparedStatement ps = null;
					ResultSet rs = null;
					Coneccion con = new Coneccion();
					Profesor profesor = new Profesor();
					profesor.setCodigo(Integer.parseInt(cajaCodigo.getText()));
					
					try{
						Connection conexion = con.getConnection();
						ps = conexion.prepareStatement("select * from profesor where clave_p=?");
						ps.setInt(1, profesor.getCodigo());
						rs = ps.executeQuery();
						
						if(rs.next()){
							profesor.setCodigo(rs.getInt("clave_p"));
							profesor.setNombre(rs.getString("nombre_p"));
							profesor.setDireccion(rs.getString("direccion_p"));
							profesor.setTelefono(rs.getString("telefono_p"));
						}
						
						conexion.close();
						
						if(comboCampo.getSelectedItem().equals("Nombre")){
							etiquetaCampo.setText("Nombre:");
							etiquetaCampo.setVisible(true);
							cajaCampo.setText(profesor.getNombre());
							cajaCampo.setVisible(true);
						}
						if(comboCampo.getSelectedItem().equals("Dirección")){
							etiquetaCampo.setText("Dirección:");
							etiquetaCampo.setVisible(true);
							cajaCampo.setText(profesor.getDireccion());
							cajaCampo.setVisible(true);
						}
						if(comboCampo.getSelectedItem().equals("Teléfono")){
							etiquetaCampo.setText("Teléfono:");
							etiquetaCampo.setVisible(true);
							cajaCampo.setText(profesor.getTelefono());
							cajaCampo.setVisible(true);
						}
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
			}
		});
		comboCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar campo", "Nombre", "Direcci\u00F3n", "Tel\u00E9fono"}));
		comboCampo.setBounds(107, 95, 173, 23);
		panel_1.add(comboCampo);
		
		etiquetaCampo = new JLabel("New label");
		etiquetaCampo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCampo.setVisible(false);
		etiquetaCampo.setFont(new Font("Arial", Font.PLAIN, 12));
		etiquetaCampo.setBounds(58, 150, 93, 23);
		panel_1.add(etiquetaCampo);
		
		cajaCampo = new JTextField();
		cajaCampo.setVisible(false);
		cajaCampo.setBounds(161, 150, 173, 23);
		panel_1.add(cajaCampo);
		cajaCampo.setColumns(10);
		
		botonGuardar = new JButton("Guardar Cambio");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cajaCodigo.getText().equals("") || cajaCampo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Por favor complete los 2 campos necesarios para la modificación");
				}else{
					PreparedStatement ps = null;
					ResultSet rs = null;
					Coneccion con = new Coneccion();
					Profesor profesor = new Profesor();
					ConsultasProfesor consultas = new ConsultasProfesor();					
					profesor.setCodigo(Integer.parseInt(cajaCodigo.getText()));
					
					try{
						Connection conexion = con.getConnection();
						ps = conexion.prepareStatement("select * from profesor where clave_p=?");
						ps.setInt(1, profesor.getCodigo());
						rs = ps.executeQuery();
						
						if(rs.next()){
							profesor.setCodigo(rs.getInt("clave_p"));
							profesor.setNombre(rs.getString("nombre_p"));
							profesor.setDireccion(rs.getString("direccion_p"));
							profesor.setTelefono(rs.getString("telefono_p"));
						}
						
						conexion.close();
						
						if(comboCampo.getSelectedItem().equals("Nombre")){
							profesor.setNombre(cajaCampo.getText());
						}
						if(comboCampo.getSelectedItem().equals("Dirección")){
							profesor.setDireccion(cajaCampo.getText());
						}
						if(comboCampo.getSelectedItem().equals("Teléfono")){
							profesor.setTelefono(cajaCampo.getText());
						}
						
						if(consultas.modificarProfe(profesor)){
							JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
							limpiarCajas();
						}else{
							JOptionPane.showMessageDialog(null, "Error al modificar");
							limpiarCajas();
						}
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
					
				}
			}
		});
		botonGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		botonGuardar.setBounds(132, 195, 134, 23);
		panel_1.add(botonGuardar);
		
		ImageIcon imagen = new ImageIcon("fondologin.png");
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 833, 378);
		label.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(label.getWidth(),label.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(label);
	}
}

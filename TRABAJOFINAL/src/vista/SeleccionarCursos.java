package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.JLabel;

import modelo.Alumno;
import modelo.Coneccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeleccionarCursos extends JDialog {
	
	private JCheckBox casillaBiologia;
	private JCheckBox casillaAlgebra;
	private JCheckBox casillaAritmetica;
	private JCheckBox casillaCivica;
	private JCheckBox casillaComputacion;
	private JCheckBox casillaComunicacion;
	private JCheckBox casillaArte;
	private JCheckBox casillaEconomia;
	private JCheckBox casillaEducacionFisica;
	private JCheckBox casillaGeografia;
	private JCheckBox casillaNatacion;
	private JCheckBox casillaHistoriaUniversal;
	private JCheckBox casillaGeometria;
	private JCheckBox casillaLiteratura;
	private JCheckBox casillaHistoriaDelPeru;
	private JCheckBox casillaFisica;
	private JCheckBox casillaIngles;
	private JCheckBox casillaLenguaje;
	private JCheckBox casillaTutoria;
	private JCheckBox casillaPersonal;
	private JCheckBox casillaReligion;
	private JCheckBox casillaRM;
	private JCheckBox casillaQuimica;
	private JCheckBox casillaTrigonometria;
	private JCheckBox casillaRV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SeleccionarCursos dialog = new SeleccionarCursos(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SeleccionarCursos(final Vector<Curso> vectorcursos) {
		setTitle("Seleccionar cursos");
		setBounds(100, 100, 507, 336);
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		casillaAlgebra = new JCheckBox("\u00C1lgebra");
		casillaAlgebra.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaAlgebra.setBounds(6, 19, 97, 23);
		panel.add(casillaAlgebra);
		
		casillaAritmetica = new JCheckBox("Aritm\u00E9tica");
		casillaAritmetica.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaAritmetica.setBounds(6, 45, 97, 23);
		panel.add(casillaAritmetica);
		
		casillaArte = new JCheckBox("Arte");
		casillaArte.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaArte.setBounds(6, 71, 97, 23);
		panel.add(casillaArte);
		
		casillaBiologia = new JCheckBox("Biolog\u00EDa");
		casillaBiologia.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaBiologia.setBounds(6, 97, 97, 23);
		panel.add(casillaBiologia);
		
		casillaComputacion = new JCheckBox("Computaci\u00F3n");
		casillaComputacion.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaComputacion.setBounds(6, 123, 107, 23);
		panel.add(casillaComputacion);
		
		casillaFisica = new JCheckBox("F\u00EDsica");
		casillaFisica.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaFisica.setBounds(163, 20, 97, 23);
		panel.add(casillaFisica);
		
		casillaGeografia = new JCheckBox("Geograf\u00EDa");
		casillaGeografia.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaGeografia.setBounds(163, 46, 97, 23);
		panel.add(casillaGeografia);
		
		casillaGeometria = new JCheckBox("Geometr\u00EDa");
		casillaGeometria.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaGeometria.setBounds(163, 72, 128, 23);
		panel.add(casillaGeometria);
		
		casillaHistoriaDelPeru = new JCheckBox("Historia del Per\u00FA");
		casillaHistoriaDelPeru.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaHistoriaDelPeru.setBounds(163, 98, 128, 23);
		panel.add(casillaHistoriaDelPeru);
		
		casillaHistoriaUniversal = new JCheckBox("Historia Universal");
		casillaHistoriaUniversal.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaHistoriaUniversal.setBounds(163, 124, 128, 23);
		panel.add(casillaHistoriaUniversal);
		
		casillaPersonal = new JCheckBox("Personal Social");
		casillaPersonal.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaPersonal.setBounds(307, 20, 155, 23);
		panel.add(casillaPersonal);
		
		casillaQuimica = new JCheckBox("Qu\u00EDmica");
		casillaQuimica.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaQuimica.setBounds(307, 46, 155, 23);
		panel.add(casillaQuimica);
		
		casillaRM = new JCheckBox("Razonamiento Matem\u00E1tico");
		casillaRM.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaRM.setBounds(307, 72, 178, 23);
		panel.add(casillaRM);
		
		casillaRV = new JCheckBox("Razonamiento Verbal");
		casillaRV.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaRV.setBounds(307, 98, 155, 23);
		panel.add(casillaRV);
		
		casillaReligion = new JCheckBox("Religi\u00F3n");
		casillaReligion.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaReligion.setBounds(307, 124, 97, 23);
		panel.add(casillaReligion);
		
		casillaComunicacion = new JCheckBox("Comunicaci\u00F3n Integral");
		casillaComunicacion.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaComunicacion.setBounds(6, 149, 155, 23);
		panel.add(casillaComunicacion);
		
		casillaIngles = new JCheckBox("Ingl\u00E9s");
		casillaIngles.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaIngles.setBounds(163, 149, 97, 23);
		panel.add(casillaIngles);
		
		casillaTrigonometria = new JCheckBox("Trigonometr\u00EDa");
		casillaTrigonometria.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaTrigonometria.setBounds(307, 150, 128, 23);
		panel.add(casillaTrigonometria);
		
		casillaEconomia = new JCheckBox("Econom\u00EDa");
		casillaEconomia.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaEconomia.setBounds(6, 175, 135, 23);
		panel.add(casillaEconomia);
		
		casillaLenguaje = new JCheckBox("Lenguaje");
		casillaLenguaje.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaLenguaje.setBounds(163, 175, 97, 23);
		panel.add(casillaLenguaje);
		
		casillaCivica = new JCheckBox("Educaci\u00F3n C\u00EDvica");
		casillaCivica.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaCivica.setBounds(6, 201, 135, 23);
		panel.add(casillaCivica);
		
		casillaLiteratura = new JCheckBox("Literatura");
		casillaLiteratura.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaLiteratura.setBounds(163, 201, 128, 23);
		panel.add(casillaLiteratura);
		
		casillaEducacionFisica = new JCheckBox("Educaci\u00F3n F\u00EDsica");
		casillaEducacionFisica.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaEducacionFisica.setBounds(6, 227, 135, 23);
		panel.add(casillaEducacionFisica);
		
		casillaNatacion = new JCheckBox("Nataci\u00F3n");
		casillaNatacion.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaNatacion.setBounds(163, 227, 97, 23);
		panel.add(casillaNatacion);
		
		casillaTutoria = new JCheckBox("Tutor\u00EDa");
		casillaTutoria.setFont(new Font("Arial", Font.PLAIN, 12));
		casillaTutoria.setBounds(307, 175, 97, 23);
		panel.add(casillaTutoria);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				if(casillaAlgebra.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Álgebra");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaAritmetica.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Aritmética");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaArte.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Arte");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaBiologia.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Biología");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaComputacion.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Computación");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaComunicacion.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Comunicación Integral");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaEconomia.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Economía");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaCivica.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Educación Cívica");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaEducacionFisica.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Ed. Física");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaFisica.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Física");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaGeografia.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Geografía");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaGeometria.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Geometría");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaHistoriaDelPeru.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Historia del Perú");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaHistoriaUniversal.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Historia Universal");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaIngles.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Inglés");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaLenguaje.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Lenguaje");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaLiteratura.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Literatura");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaNatacion.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Natación");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaPersonal.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Personal Social");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaQuimica.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Química");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaRM.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Razonamiento Matemático");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaRV.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Razonamiento Verbal");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaReligion.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Religión");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaTrigonometria.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Trigonometría");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				if(casillaTutoria.isSelected()){
					try{
						Coneccion con = new Coneccion();
						Connection conexion = con.getConnection();											
						ps = conexion.prepareStatement("select * from materia where nombre_m=?");
						ps.setString(1, "Tutoría");
						rs = ps.executeQuery();
						
						if(rs.next()){
							Curso cursete = new Curso();
							cursete.setCodigo(rs.getInt("clave_m"));
							cursete.setNombre(rs.getString("nombre_m"));
							vectorcursos.addElement(cursete);
						}											
											
						conexion.close();
						
					}catch(Exception e){
						System.err.println("ERROR: " + e);
					}
				}
				
				dispose();
			}
		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(202, 264, 89, 23);
		panel.add(btnGuardar);
		
		ImageIcon imagen = new ImageIcon("fondologin.png");
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 491, 298);
		label.setIcon(new ImageIcon (imagen.getImage().getScaledInstance(label.getWidth(),label.getHeight() , Image.SCALE_SMOOTH)));
		panel.add(label);
	}
}

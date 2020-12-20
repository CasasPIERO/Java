package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import vista.Curso;

public class ConsultasAlumno {
	
	private void alumnoMateria(Alumno alumno, Vector<Curso> vectorcursos){
		for(int i=0;i<vectorcursos.size();i++){
			Curso cursete = new Curso();
			cursete = vectorcursos.elementAt(i);
			PreparedStatement ps = null;
			Coneccion con = new Coneccion();
			Connection conexion = con.getConnection();
			try{
				ps = conexion.prepareStatement("insert into materia_alumno (clave_m1,matricula_alu2) values (?,?)");
				ps.setInt(1, cursete.getCodigo());
				ps.setInt(2, alumno.getMatricula());
				int resultado = ps.executeUpdate();
				if(resultado > 0){
					ps = conexion.prepareStatement("insert into alumno_profesor (matricula_alu1,clave_p1) values (?,?)");
					ps.setInt(1,alumno.getMatricula());
					ps.setInt(2, cursete.getCodigo());
					ps.executeUpdate();
				}
				conexion.close();
			}catch(Exception e){
				System.out.println("ERROR: " + e);
			}
		}
	}
	
	public boolean insertar(Alumno alumno,Vector<Curso> vectorcursos){
		PreparedStatement ps = null;
		Coneccion con = new Coneccion();
		Connection conexion = con.getConnection();
		try{			
			ps = conexion.prepareStatement("insert into alumno (matricula_alu,nombre_alu,edad_alu,seccion_alu,grado_alu,genero_alu) values (?,?,?,?,?,?)");
			ps.setInt(1, alumno.getMatricula());
			ps.setString(2, alumno.getNombre());
			ps.setInt(3, alumno.getEdad());
			ps.setString(4, alumno.getSeccion());
			ps.setString(5, alumno.getGrado());
			ps.setString(6, alumno.getGenero());
			
			int resultado = ps.executeUpdate();
			
			if(resultado>0){
				alumnoMateria(alumno,vectorcursos);
				return true;
			}else{
				return false;
			}
						
		}catch(Exception e){
			System.err.println("ERROR: " + e);
			return false;
		}finally{
			try{
				conexion.close();
			}catch(Exception e){
				System.err.println("ERROR: " + e);
			}
		}
	}
	
	public boolean modificar(Alumno alumno){
		PreparedStatement ps = null;
		Coneccion con = new Coneccion();
		Connection conexion = con.getConnection();
		
		try{
			ps = conexion.prepareStatement("update alumno set nombre_alu=?,edad_alu=?,seccion_alu=?,grado_alu=?,genero_alu=? where matricula_alu=?");			
			ps.setString(1,alumno.getNombre());
			ps.setInt(2, alumno.getEdad());
			ps.setString(3, alumno.getSeccion());
			ps.setString(4, alumno.getGrado());
			ps.setString(5, alumno.getGenero());
			ps.setInt(6, alumno.getMatricula());
			
			int resultado = ps.executeUpdate();
			
			if(resultado > 0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			System.err.println("ERROR: " + e);
			return false;
			
		}finally{
			try{
				conexion.close();
			}catch(Exception e){
				System.err.println("ERROR: " + e);
			}
		}
	}
	
	public boolean eliminar(Alumno alumno){
		PreparedStatement ps = null;
		Coneccion con = new Coneccion();
		Connection conexion = con.getConnection();
		
		try{
			ps = conexion.prepareStatement("delete from alumno where matricula_alu = ?");
			ps.setInt(1, alumno.getMatricula());
			
			int resultado = ps.executeUpdate();
			
			if(resultado > 0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			System.err.println("ERROR: " + e);
			return false;
			
		}finally{
			try{
				conexion.close();
			}catch(Exception e){
				System.err.println("ERROR: " + e);
			}
		}
	}
}

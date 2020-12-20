package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vista.Curso;

public class ConsultasCurso {
	
	public boolean buscar(Curso curso,Profesor profesor){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Coneccion con = new Coneccion();
		Connection conexion = con.getConnection();
		
		try{
			ps = conexion.prepareStatement("select clave_m,nombre_m,nombre_p "
					+ "from materia inner join materia_profesor on materia.clave_m = materia_profesor.clave_m2 "
					+ "inner join profesor on profesor.clave_p = materia_profesor.clave_p2 "
					+ "where clave_m = ?");
			ps.setInt(1,curso.getCodigo());
			rs = ps.executeQuery();
			
			if(rs.next()){
				curso.setCodigo(rs.getInt("clave_m"));
				curso.setNombre(rs.getString("nombre_m"));
				profesor.setNombre(rs.getString("nombre_p"));
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

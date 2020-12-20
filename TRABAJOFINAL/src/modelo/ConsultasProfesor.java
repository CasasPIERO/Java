package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConsultasProfesor {
	
	public boolean modificarProfe(Profesor profesor){
		PreparedStatement ps = null;
		Coneccion con = new Coneccion();
		Connection conexion = con.getConnection();
		
		try{
			ps = conexion.prepareStatement("update profesor set nombre_p=?,direccion_p=?,telefono_p=? where clave_p=?");			
			ps.setString(1, profesor.getNombre());
			ps.setString(2, profesor.getDireccion());
			ps.setString(3, profesor.getTelefono());
			ps.setInt(4, profesor.getCodigo());
			
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

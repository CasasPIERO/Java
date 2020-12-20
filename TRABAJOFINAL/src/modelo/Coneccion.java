package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Coneccion {
	public static final String URL = "jdbc:sqlserver://SCALDERON-PC\\SQLEXPRESS:1433;databaseName=escuela;user=sa;password=68652f31009;";
	
	public Connection getConnection(){
		Connection conexion = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(URL);
			//JOptionPane.showMessageDialog(null, "Conección Exitosa");
			
		}catch(Exception e){
			System.err.println("ERROR: " + e);
		}
		
		return conexion;
	}
}

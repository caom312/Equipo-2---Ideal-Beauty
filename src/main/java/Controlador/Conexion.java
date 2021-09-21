package Controlador;


import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
	
	private String bd="IdealBeauty";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="";
	Connection conec = null;
		
	public Connection Conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			conec = DriverManager.getConnection(url,user,pass);
			//JOptionPane.showMessageDialog(null, "La conexion fue Exitosa!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la conexion"+e);
		}
		return conec;
	}

}

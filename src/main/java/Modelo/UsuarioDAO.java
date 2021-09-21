package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	public boolean InsertarUsuario(UsuarioDTO usuario) {
	    boolean resultado = false;
		try {
		   String sql="INSERT INTO usuarios VALUES(?,?,?,?,?)" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros
		   ps.setLong(1, usuario.getCedula_usuario());
		   ps.setString(2, usuario.getEmail_usuario());
		   ps.setString(3, usuario.getNombre_usuario());
		   ps.setString(4, usuario.getPassword());
		   ps.setString(5, usuario.getUsuario());
		   //executar la consulta, si es mayor que cero quiere decir 
           // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Insertar un Usuario"+e);
		
		}
		return resultado;
	}
	
	public UsuarioDTO ConsultarUsuario1(long cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public UsuarioDTO ConsultarUsuario(long cedula) {
		 //crear un objeto para guardar los datos que trajo la consulta
		  UsuarioDTO usu = null;
		  try {
			  String sql="SELECT * FROM usuarios WHERE cedula_usuario=?";
			  ps = con.prepareStatement(sql);
			  ps.setLong(1, cedula);  
			  res = ps.executeQuery();
			  while(res.next()) {
				  //en usuario cargo los datos del usuario 
				  usu = new UsuarioDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  }
			  
		  }catch(Exception e) {
			  JOptionPane.showMessageDialog(null,"Error al Consultar un Usuario"+e);
			  
		  }
		  //retornar el usuario al controlador
	      return usu;
		
	}
	
	
	public boolean ActualizarUsuario(UsuarioDTO usuario) {
	    boolean resultado = false;
		try {
		   String sql="UPDATE usuarios SET email_usuario=?,nombre_usuario=?,password=?,usuario=? WHERE cedula_usuario=?" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros			   
		   ps.setString(1, usuario.getEmail_usuario());
		   ps.setString(2, usuario.getNombre_usuario());
		   ps.setString(3, usuario.getPassword());
		   ps.setString(4, usuario.getUsuario());
		   //el orden cambio porqu este es el where
		   ps.setLong(5, usuario.getCedula_usuario());
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el Usuario"+e);
		
		}
		return resultado;
	}
	
	public boolean EliminarUsuario(Long cedula) {
	    boolean resultado = false;
		try {
		   String sql="DELETE FROM usuarios WHERE cedula_usuario=?" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasar los parametros			   
		   ps.setLong(1, cedula);
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el Usuario"+e);
		
		}
		return resultado;
  }

	
	
	

}

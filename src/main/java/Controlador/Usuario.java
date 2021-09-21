package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;


@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuariodao = new UsuarioDAO();
		//pregunto si el cliente hizo clic en el boton registrar
		if(request.getParameter("registrar")!=null) {
			String email,nombre,password,usuario;
			long cedula;
			cedula = Long.parseLong(request.getParameter("cedula"));
			email = request.getParameter("email");
			nombre = request.getParameter("nombre");
			password = request.getParameter("password");
			usuario = request.getParameter("usuario");
			UsuarioDTO usuariodto = new UsuarioDTO(cedula,email,nombre,password,usuario);
		    if(usuariodao.InsertarUsuario(usuariodto)) {
		      JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente!");	
              response.sendRedirect("MenuAdmin.jsp?men=Usuario Registrado Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Usuario no se Registro");	
	          response.sendRedirect("MenuAdmin.jsp?men=El Usuario no se Registro");
		    }
		}
		
		if(request.getParameter("consultar")!=null){
			String email,nombre,password,usuario;
		    long cedula;
			cedula =Long.parseLong(request.getParameter("cedula2"));
			UsuarioDTO usu = usuariodao.ConsultarUsuario(cedula);
			if(usu!=null) {
				cedula= usu.getCedula_usuario();
				email = usu.getEmail_usuario();
				nombre = usu.getNombre_usuario();
				password =  usu.getPassword();
				usuario = usu.getUsuario();
				
				//ahora enviar por la url con el response a Libros.jsp o la vista jsp
				response.sendRedirect("MenuAdmin.jsp?cedula="+cedula+"&&email="+email+"&&nombre="
						+nombre+"&&password="+password+"&&usuario="+usuario);
				
			}else {
				response.sendRedirect("MenuAdmin.jsp?men=El Usuario no Existe");
	     	}
         }
		
		if(request.getParameter("actualizar")!=null) {
			String email,nombre,password,usuario;
			Long cedula;
			cedula = Long.parseLong(request.getParameter("ced"));
			email = request.getParameter("email");
			nombre = request.getParameter("nombre");
			password = request.getParameter("password");
			usuario = request.getParameter("usuario");
			UsuarioDTO usudto_Act = new UsuarioDTO(cedula,email,nombre,password,usuario);
		    if(usuariodao.ActualizarUsuario(usudto_Act)) {
		      JOptionPane.showMessageDialog(null, "El Usuario se Actualizo Exitosamente!");	
              response.sendRedirect("MenuAdmin.jsp?men=El Usurio se Actualizo Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Usuario no se Actualizo");	
	          response.sendRedirect("MenuAdmin.jsp?men=El Usurio no se Actualizo");
		    }
		}
		
		if(request.getParameter("eliminar")!=null) {
			long codisbn;
			codisbn = Long.parseLong(request.getParameter("ced"));
			int op = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el libro "+codisbn);
			if(op==0) {
				if(usuariodao.EliminarUsuario(codisbn)) {
					response.sendRedirect("MenuAdmin.jsp?men=El Usuario fue Eliminado");
				}else {
					response.sendRedirect("MenuAdmin.jsp?men=El Usuario no se Elimino");
				}
			}else {
				response.sendRedirect("MenuAdmin.jsp");
			}
		}
	}

}

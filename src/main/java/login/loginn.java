package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/loginn")
public class loginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginn() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("send")!=null) {
			
			String usuario,clave;
			String mensaje;
			
			usuario=request.getParameter("user");
			clave=request.getParameter("key");
			
			if(usuario.equals("admininicial") && clave.equals("admin123456")) {
				
				/*JOptionPane.showMessageDialog(null, "Bienvenido Administrador");*/
				mensaje="Bienvenido Administrador";
				response.sendRedirect("MenuAdmin.jsp?mens="+mensaje);
			}else {
				/*JOptionPane.showMessageDialog(null, "datos incorrectos");*/
				mensaje="Datos incorrectos";
				response.sendRedirect("login.jsp?mens="+mensaje);
			}
			
		}
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

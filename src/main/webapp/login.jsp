<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<link rel="stylsheet" type="text/css" href="css/login.css" />
<style type="text/css">
  <%@include file="login.css" %>
</style>
</head>

<body>
	<div class="log">
		<div class="log1">
			<form action="loginn" method="post" id="formul">
			    <div class="input">
			    	<h1><a href="Index.jsp" id="principal">Ideal Beauty</a></h1>
			    </div>
			    <hr>			
			    <div > 
			        <input type="text" placeholder="Ingrese su Usuario" name="user" class="input1" required>
			    </div>
			    <div>
			        <input type="password" placeholder="Ingrese su Contraseña" name="key" class="input1" required>
			    </div>			    
			    <div>
			        <div><input type="submit" value="Aceptar" name="send"  class="boton"></div>
			        <div><a href="Index.jsp"><input type="button" value="Cancelar" class="boton"></a></div>
			   </div>
			   <hr>
			   <div id=status>
					<%String msg=request.getParameter("mens"); %>
					
					Status: <%=msg %>
				</div>
			</form>
		</div>	
	</div>
	
	</body>
</html>
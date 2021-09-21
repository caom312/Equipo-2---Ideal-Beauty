<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminMenu</title>
<style type="text/css">
  <%@include file="MenuAdmin.css" %>
</style>

</head>
<body id="fondo">
<div class="content">
<div class="box-area">
		<header>
			<div class="wrapper">
				<div class="logo">
					<a href="Index.jsp">Ideal Beauty</a>
				</div>
				<nav>
					<a href="MenuAdmin.jsp">Usuarios</a>
                    <a href="Clientes.jsp">Clientes</a>
                    <a href="#">Proveedores</a>
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Reportes</a>
				</nav>
			</div>
		</header>
	</div>
<hr>

<form class=formul>
    <table class="tablit">
        <caption>Ingrese los datos para crear un nuevo usuario</caption>
        	<tr><th id="padin"><label>Cédula</label>
        	<input type="number" placeholder="ingrese su número Cédula" id="cedula" required>
        	</th>
        	<th id="padin"><label>Usuario</label>
    		<input type="text" placeholder="ingrese su Nombre de usuario" id="usuario" required></th>
        	</tr>
        	<tr><th id="padin"><label>Nombre Completo</label>
    		<input type="text" placeholder="ingrese su Nombre Completo" required></th>
    		<th id="padin"><label>contraseña</label>
    		<input type="password" placeholder="ingrese su clave"></th>
    		</tr>
        	<tr><th id="padin"><label>Correo electronico</label>
        	<input type="email" placeholder="ingrese su email" required></th></tr>
    </table>
    <div class="boton">
        <input type="button" value="Consultar" >
        <input type="button" value="Crear" >
        <input type="button" value="Actualizar" >
        <input type="button" value="Borrar" >
    </div>
</form>
</div>
</body>
</html>
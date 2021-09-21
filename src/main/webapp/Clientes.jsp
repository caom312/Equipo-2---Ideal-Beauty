<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Clientes.css">
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
	
</head>
<body>

<header id="o">
		<nav class="op">
			<ul>	
			   <li><a href="Index.jsp" id="l">Ideal Beauty</a></li>
			   <li><a href="MenuAdmin.jsp">Usuarios</a></li>
		       <li><a href="#">Clientes</a></li>
		       <li><a href="#">Proveedores</a></li>
		       <li><a href="#">Productos</a></li>
		       <li><a href="#">Ventas</a></li>
		       <li><a href="#">Reportes</a></li>
			</ul>
		</nav>
</header>

<%
	Conexion con=new Conexion();
%>
<%!String mensaje="";
	long cedula=0;
	long tel=0;
	String nom="";
	String corr="";
	String direc="";
	String estado="";
%>

<%
	if(request.getParameter("cedula")!=null){
		cedula=Integer.parseInt(request.getParameter("cedula"));
		tel= Integer.parseInt(request.getParameter("tel"));
		nom=request.getParameter("nom");
		corr=request.getParameter("corr");
		direc=request.getParameter("direc");
		estado="disabled";
	}
%>
<%
	if(request.getParameter("men")!=null){
		cedula=0;
		tel=0;
		nom="";
		corr="";
		direc="";
		estado="";
		mensaje=request.getParameter("men");
}
%>

<form action="Cliente" method="post">
	<fieldset>
		<legend><h2>Clientes</h2></legend>
		<div>
			<label class="l1"> Cedula   </label>
			<input type="number" name="Cedu" value="<%=cedula%>" required <%=estado%>>
		</div>
		<input type="hidden" name="cod" value="<%=cedula%>">
		<div>
			<label class="l1">Telefono </label>
			<input type="text" name="Tel" value="<%=tel%>" required>
		</div>
		<div>
			<label>Nombre Completo </label>
			<input type="text" name="Nom" value="<%=nom%>" required>
		</div>
		<div>
			<label>Correo Electronico </label>
			<input type="text" name="CorrEl" value="<%=corr%>" required>
		</div>
		<div>
			<label class="l1">Direccion </label>
			<input type="text" name="Direccion" value="<%=direc%>">
		</div>
		<div>
			<input type="submit" name="registrar" value="Registrar" class="btn">
			<input type="submit" name="actualizar" value="Actualizar" class="btn">
			<input type="submit" name="eliminar" value="Eliminar" class="btn">
		</div>
	</fieldset>
</form>
<form action="Cliente" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>
<div><label class="l1">Cedula: </label><input type="text" name="CeduCon" required></div>
<div><input type="submit" name="consultar" value="Consultar" class="btn"></div>
</fieldset>
</form>

<h2><%=mensaje %></h2>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type"
 	content="text/html; charset=UTF-8">
 <style><%@include file="/css/empStyle.css"%></style>
 <title>Inicio - Cliente | Gallina Elegante</title>
 </head>
 <body>
	<div class="header">
		<h1>GALLINA ELEGANTE</h1>
		<img class="avatar" src="recursos/gallina.png">
		<p>SESION CLIENTE</p>
		<%
		out.print("Bienvenid@ " + session.getAttribute("cli_nombre"));
		%>
	</div>
	<div class="topnav">
		<a href="solicitarDomicilio.jsp">Solicitar Domicilio</a> <a
			href="reservarMesa.jsp">Reservar Mesa</a>
	</div> 
		<div class="button">
		<input type="submit" value="Cerrar sesion"><br> <a href="#">
	</div>
  </body>
</html>

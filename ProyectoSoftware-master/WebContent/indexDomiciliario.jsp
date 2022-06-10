<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/css/empStyle.css"%></style>
<title>INDEX DOMICILIARIO</title>
</head>
<body>
	<div class="header">
		<h1>GALLINA ELEGANTE</h1>
		<img class="avatar" src="recursos/gallina.png">
		<p> SESION DOMICILIARIO</p>
		<%
		out.print("Bienvenid@ " + session.getAttribute("dom_nombre"));
		%>
	</div>
	<div class="topnav">
		<a href="domiciliarios.jsp">Ver lista de domicilios</a> <a
			href="notificacion.jsp">Notificar entrega de domicilio</a>
	</div>
	<div class="button">
		<input type="submit" value="Cerrar sesion"><br> <a href="#">
	</div>
	
</body>
</html>
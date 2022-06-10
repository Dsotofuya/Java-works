<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/css/empStyle.css"%></style>
<title>INDEX EMPLEADO</title>
</head>
<body>
	<div class="header">
		<h1>GALLINA ELEGANTE</h1>
		<img class="avatar" src="recursos/gallina.png">
		<p> SESION EMPLEADO</p>
		<%
			out.print("Bienvenid@ " + session.getAttribute("emp_nombre"));
		%>
	</div>
	<div class="topnav">
		<a href="verEmpleados.jsp"> Ver empleados</a> <a
			href="domiciliarios.jsp">Ver domiciliarios</a> <a
			href="reservas.jsp">Lista de reservas</a> <a
			href="agregar.jsp">Agregar Plato</a>
	</div>
	<div class="button">
		<input type="submit" value="Cerrar sesion"><br> <a href="#">
	</div>
	
</body>
</html>


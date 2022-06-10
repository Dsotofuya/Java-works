<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Reservaciones</title>
<style><%@include file="/css/empStyle.css"%></style>
</head>
<body>
	<h4>Solicitud de reservaciones</h4>
	<h2>Por favor ingrese los siguientes datos para solicitar su
		reserva</h2>
	<form action="reservacionServlet" method="post">
		<label for="sucursal"> Seleccione la ciudad en la que desea la reservación:</label> <select id="sucursal" name="sucursal">
			<option value="bogota">Bogotá</option>
			<option value="medellin">Medellin</option>
			<option value="tunja">Tunja</option>
		</select>
		
		<table cellspacing="4" cellpadding="4" border="2">
			<tr>
				<td align="id">id la reservación:</td>
				<td><input type="text" name="id_reserva"></td>
			</tr>
			<tr>
				<td align="fecha">Fecha para la reservacion:</td>
				<td><input type="text" name="fecha_reserva" placeholder="dd-mm-yyyy"></td>
			</tr>
			<tr>
				<td align="hora">Hora para la reservación:</td>
				<td><input type="text" name="hora_reserva" placeholder="hh:mm(24 hrs)"></td>
			</tr>
			<tr>
				<td align="personas">Cantidad de personas para la reservación:
				</td>
				<td><input type="text" name="cant_personas"></td>
			</tr>
			<tr>
				<td align="id mesa">id mesa:
				</td>
				<td><input type="text" name="id_mesa"></td>
			</tr>
		</table>
		<input type="submit" class="Button" value="Enviar">
	</form>
</body>
</html>
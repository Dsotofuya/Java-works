<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar domicilio</title>
<style><%@include file="/css/empStyle.css"%></style>
</head>
<div class="content">
	<body>
		<div class="header">
			<h1>GALLINA ELEGANTE</h1>
			<img class="avatar" src="recursos/gallina.png">
			<p>SESION CLIENTE</p>
			<p>SOLICITAR DOMICILIO</p>
		</div>
		<h5>Por favor ingrese los siguientes datos para solicitar el
			domicilio</h5>
		<form action="clientServlet" method="post">

			<label for="sucursal"> - Ciudad de donde desea el envío:</label> <select id="sucursal" name="sucursal">
				<option value="bogota">Bogotá</option>
				<option value="medellin">Medellin</option>
				<option value="tunja">Tunja</option>
			</select>
			<table cellspacing="8" cellpadding="8" border="0">
				<tr>
					<td align="Nombre del plato">- Nombre del plato:</td>
					<td><input type="text" name="nom_prod"></td>
				</tr>
				<tr>
					<td align="cantidad">- Cantidad:</td>
					<td><input type="text" name="cant_product"></td>
				</tr>
			</table>
			<label for="FormaPago"> - Seleccione la forma de pago:</label> <select id="formaPago" name="formaPago">
				<option value="efectivo">Efectivo</option>
				<option value="tarjetaCredito">TarjetaCredito</option>
				<option value="tarjetaDebito">TarjetaDebito</option>
			</select> <input type="submit" class="Button" value="Enviar">
		</form>
	</body>
</div>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
</head>
<body>
	<div class="content">
		<form action="addState.jsp">
			<input type="submit" value="addState" />
		</form>
		<h1>xD App</h1>
		<h2>Ingrese datos del residente</h2>
		<form action="AddResidentServlet" method="post">
			<table cellspacing="3" cellpadding="3" border="1">
				<tr>
					<td align="right">id del residente:</td>
					<td><input type="text" name="resident_id"></td>
				</tr>
				<tr>
					<td align="right">nombre:</td>
					<td><input type="text" name="resident_name"></td>
				</tr>
				<tr>
					<td align="right">Apellido:</td>
					<td><input type="text" name="resident_last_name"></td>
				</tr>
				<tr>
					<td align="right">numero de telefono:</td>
					<td><input type="text" name="resident_phone_number"></td>
				</tr>
				<tr>
					<td align="right">dirección:</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td align="right">bloque:</td>
					<td><input type="text" name="block"></td>
				</tr>
				<tr>
					<td align="right">id interna:</td>
					<td><input type="text" name="internal_id"></td>
				</tr>
			</table>
			<input type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<input type="text" name="user"> <input type="text"
			name="password">
		<form action="addState.jsp">
			<input type="submit" value="Login" />
		</form>
		<form action="ZzzTestServlet" method="post">
			<table cellspacing="3" cellpadding="3" border="1">
				<tr>
					<td align="right">id admin:</td>
					<td><input type="text" name="admin_id"></td>
				</tr>
				<tr>
					<td align="right">nombre:</td>
					<td><input type="text" name="admin_name"></td>
				</tr>
				<tr>
					<td align="right">telefono:</td>
					<td><input type="text" name="admin_phone"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
		<div><h1>Crear residente</h1>
		<form action="AddResidentServlet" method="post">
			<table border="1">
				<tr>
					<td align="right">id residente:</td>
					<td><input type="text" name="resident_id"></td>
				</tr>
				<tr>
					<td align="right">nombre:</td>
					<td><input type="text" name="resident_name"></td>
				</tr>
				<tr>
					<td align="right">apellido:</td>
					<td><input type="text" name="resident_last_name"></td>
				</tr>
				<tr>
					<td align="right">telefono:</td>
					<td><input type="text" name="resident_phone_number"></td>
				</tr>
				<tr>
					<td align="right">estado de la cuenta:</td>
					<td><input type="text" name="account_state_type_id"></td>
				</tr>
				<tr>
					<td align="right">contraseña:</td>
					<td><input type="text" name="resident_password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<div class="content"></div>
</body>
<footer>
	<p>Ingenieria de Software I - 2020 Copyright UPTC Tunja</p>
</footer>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/css/style2.css"%></style>
<title>Registrar Cliente en la Gallina Elegante</title>
</head>
<body>
	<div class="login-box">
		<img class="avatar" src="recursos/gallina.png">
		<h1> La Gallina Elegante </h1>
		<form action="ServletRegistrerCliente" method="post">
			<input type="text" placeholder="Enter name" name="name_registrer">
			<input type="text" placeholder="Enter telephone" name="telephone_registrer">
			<input type="text" placeholder="Enter direction" name="direction_registrer">
			<input type="text" placeholder="Enter email" name="mail_registrer">
			<input type="password" placeholder="Enter password" name="password_registrer"> 
			<label for="FormaPago"> Seleccione la forma de pago que desea usar normalmente:</label>
  			<select id="formaPago" name="formaPago">
    			<option value="efectivo">Efectivo</option>
    			<option value="tarjetaCredito">TarjetaCredito</option>
    			<option value="tarjetaDebito">TarjetaDebito</option>
  			</select>
			<input type="submit" value="Sign In"><br> <a href="#">
			Sig In</a><br> <a href="#">olvido su contraseña?</a>
		</form>
	</div>
</body>
<footer>
</footer>
</html>
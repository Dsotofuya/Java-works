<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/css/style.css"%></style>
<title>Log In | La Gallina Elegante</title>
</head>
<body>
	<div class="login-box">
	<form action="servletCreateAccount" method="post">
		<img class="avatar" src="recursos/gallina.png">
		<h1> La Gallina Elegante </h1>
		<h2> Registro de clientes </h2>
		<input type="text" placeholder="Enter CC" name="CC_createAccount">
			<input type="text" placeholder="Enter name" name="name_createAccount">
			<input type="text" placeholder="Enter lastName" name="lastName_createAccount">
			<input type="text" placeholder="Enter telephone" name="tel_createAccount">
			<input type="text" placeholder="Enter email" name="mail_createAccount"> 
			<input type="password" placeholder="Enter password" name="password_createAccount">
			<input type="text" placeholder="Enter direction" name="direccion_createAccount">
			<input type="submit" value="Sign In"><br> <a href="#">
			Create account</a><br> <a href="#">Forgot your password?</a>
		</form>
	</div>
</body>
</html>
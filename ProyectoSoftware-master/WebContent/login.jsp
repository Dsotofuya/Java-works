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
	<form action="ServletLogin" method="post">
		<img class="avatar" src="recursos/gallina.png">
		<h1> La Gallina Elegante </h1>
			<input type="text" placeholder="Enter email" name="mail_login"> 
			<input type="password" placeholder="Enter password" name="password_login">
			<input type="submit" value="Sign In"><br> <a href="registroCliente.jsp">
			Create account</a><br> <a href="#">Forgot your password?</a>
		</form>
	</div>
</body>
<footer>
	<button type="button"><img  src="recursos/facebook.png"></button>
	<button type="button"><img  src="recursos/whatsApp.png"></button>
	<button type="button"><img  src="recursos/instagram.png"></button>
	<button type="button"><img  src="recursos/gmail.png"></button>
</footer>
</html>
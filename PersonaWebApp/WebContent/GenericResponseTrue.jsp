<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> <%out.print(request.getAttribute("a")); %>ha sido adicionada exitosamente!</h1>
	<h2>
		<a href="index.jsp"> Volver a la p�gina inicial!</a>
	</h2>
</body>
</html>
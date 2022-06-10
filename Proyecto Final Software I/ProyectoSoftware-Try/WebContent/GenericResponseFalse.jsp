<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Error en la adición de <%
		out.print(request.getAttribute("generic"));
		%> !
	</h1>
	<h2>
		<a href="index.jsp"> Volver a la página inicial!</a>
	</h2>
</body>
</html>
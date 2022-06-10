<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control panel</title>
</head>
<body>
<div class="content">
<form action="PrepareResidentServlet" method = "post">
<input type="submit" value="Addd Residents" />
</form>
<form action="PrepareUpdateResidentServlet" method = "post">
<input type="submit" value="Update Resident" />
</form>
<form action="PrepareResidentServlet" method = "post">
<input type="submit" value="Real States Bills" />
</form>
<form action="AddReservationServlet" method = "get">
<input type="submit" value="Add Reservations" />
</form>
<form action="ChangeStatusAccountServlet" method = "get">
<input type="submit" value="Change Account State" />
</form>
</div>
</body>
</html>
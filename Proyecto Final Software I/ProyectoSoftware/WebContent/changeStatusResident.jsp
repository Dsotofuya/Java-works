<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/css/stockTableStyle.css"%></style> 
<script type="text/javascript" src="js/scripts.js"> async</script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/jqueryScript.js"></script>
<meta charset="ISO-8859-1">
<title>Change Status Resident</title>
</head>
<body>
	<form action="ChangeStatusAccountServlet" method="post">
	<h2>Cambiar Status de cuentas de usuarios</h2>
	<span>Seleccione el usuario:  </span>
	<select name="residentSelector">
		<option value="">---------</option>
		<c:forEach items="${residentsList}" var="resident">
			<option value="${resident.resident_id}">${resident.resident_id} </option>
			<%-- - ${resident.resident_name} ${resident.resident_last_name} </option> --%>
		</c:forEach>
	</select>
	<span>Seleccione nuevo estado de la cuenta del usuario:  </span>
 	<select name="stateSelector">
		<option value="">---------</option>
		<c:forEach items="${stateAccountList}" var="stateAccount">
			<option name="${stateAccount.getRealStateTypeID()}">
				${stateAccount.toString()}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Listo">
	</form>
</body>
</html>
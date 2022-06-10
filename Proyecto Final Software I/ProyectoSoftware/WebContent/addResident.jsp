<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REAL-STATES</title>
<style><%@include file="/css/stockTableStyle.css"%></style> 
<script type="text/javascript" src="js/scripts.js"> async</script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/jqueryScript.js"></script>
</head>
<body>
<div class="content">
<h1>Real State App</h1>
<h2>Add new Resident</h2>
<form action="AddResidentServlet" method="post">
<table border="1">
<tr>
<td align="right">id del residente:</td>
<td><input type="text" id = "residentIDInbox"name="resident_id"z></td>
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
<td align="right">address:
<select id = "addressSelector" name = "addressSelector" onChange = "unlockBlocksByAddress()">
<option value="">
Choose an Address
</option>
<c:forEach items="${realStatesList}" var="realState">
<option name = "${realState.realStateID.address}">
${realState.realStateID.address}
</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td align="right">block:
<select  disabled id ="blockSelector" name = "blockSelector" onchange = "unlockinternalIDSelectorByBlock()">
<option value="">Choose a Block</option>
<c:forEach items="${realStatesList}" var="realState">
<option name = "${realState.realStateID.address}">
${realState.realStateID.block}
</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td align="right">internal_id:>
<select disabled id ="internalIDSelector" name = "internalIDSelector">
<option value="">Choose a Number</option>
<c:forEach items="${realStatesList}" var="realState">
<option name = "${realState.realStateID.address}+${realState.realStateID.block}">
${realState.realStateID.internal_id}
</option>
</c:forEach>
</select>
</td>
</tr>
</table>
<input type="submit" value="Enviar">
</form>
</div>
</body>
</html>
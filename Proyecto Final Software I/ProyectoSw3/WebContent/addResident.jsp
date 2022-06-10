<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
<style> <%@ include file="/css/stockTableStyle.css"%> </style>
<script type="text/javascript" src="js/scripts.js">
	async
</script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/jqueryScript.js"></script>
</head>
<body>
	<div class="content">
		<h1>xD App</h1>
		<h2>Ingrese datos del residente</h2>
		<form action="AddResidentServlet" method="post">
			<table border="1">
				<tr>
					<td align="right">id del residente:</td>
					<td><input type="text" id="residentIDInbox" name="resident_id"></td>
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
					<td align="right">address:</td>
					<select id="addressSelector" onChange="unlockBlocksByAddress()">
						<option value="">Choose an Address</option>
						<c:forEach items="${realStatesList}" var="realState">
							<option>${realState.realStateID.address}</option>
						</c:forEach>
					</select>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td align="right">block:</td>
					<select disabled id="blockSelector"
						onChange="unlockinternalIDSelectorByBlock()">
						<option value="">Choose a Block</option>
						<c:forEach items="${realStatesList}" var="realState">
							<option name="${realState.realStateID.address}">
								${realState.realStateID.block}</option>
						</c:forEach>
					</select>
					<td><input type="text" name="block"></td>
				</tr>
				<tr>
					<td align="right">internal_id:</td>
					<select disabled id="internalIDSelector">
						<option value="">Choose a Number</option>
						<c:forEach items="${realStatesList}" var="realState">
							<option
								name="${realState.realStateID.address}+${realState.realStateID.block}">
								${realState.realStateID.internal_id}</option>
						</c:forEach>
					</select>
					<td><input type="text" name="internal_id"></td>
				</tr>
			</table>
			<input type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>
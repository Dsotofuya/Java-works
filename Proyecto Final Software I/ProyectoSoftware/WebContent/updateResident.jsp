<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REAL STATE</title>
<script type="text/javascript" src="js/updateResidentScripts.js">
	async
</script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="content">
		<h1>Real State App</h1>
		<h2>Add new Resident</h2>
		<form action="UpdateResidentServlet" method="post">
			<table border="1">
				<tr>
					<td><select id="residentIDSelector" name="residentIDSelector">
							<option value="${onUpdateResident.resident_id}">
								${onUpdateResident eq null ? 'Choose an ID' : onUpdateResident.resident_id}
							</option>
							<c:forEach items="${residentsList}" var="resident">
								<option name="${resident.resident_id}">
									${resident.resident_id}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" id="searchResidentByIDButton"
						name="searchResidentByIDButton" value="Search"></td>
				</tr>
				<tr>
					<td align="right">Name:</td>
					<td><input type="text" id="residentNameInput"
						name="residentNameInput" value="${onUpdateResident.resident_name}"
						${onUpdateResident eq null ? 'disabled' : ''}></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td><input type="text" id="residentLastNameInput"
						name="residentLastNameInput"
						value="${onUpdateResident.resident_last_name}"
						${onUpdateResident eq null ? 'disabled' : ''}></td>
				</tr>
				<tr>
					<td align="right">Phone Number:</td>
					<td><input type="text" id="residentLastNameInput"
						name="residentPhoneNumberInput"
						value="${onUpdateResident.resident_phone_number}"
						${onUpdateResident eq null ? 'disabled' : ''}></td>
				</tr>
			</table>
			<input id="updateResidentButton" name="updateResidentButton"
				type="submit" value="Update"
				${onUpdateResident eq null ? 'disabled' : ''}>
		</form>
	</div>
</body>
</html>
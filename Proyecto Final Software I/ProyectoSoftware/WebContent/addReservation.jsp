<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/scripts.js">
	async
</script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/jqueryScript.js"></script>
<title>Add reservation</title>
</head>
<body>
<form action="AddReservationServlet" method="post">
	<div>
		Ingrese el id de la reserva <input type="text" name="reservation_id">
	</div>
	<div>
		seleccione el cc del residente <select id="residentSelector"
			name="residentSelector">
			<option value="">--------------</option>
			<c:forEach items="${residentsList}" var="resident">
				<option name="${resident.resident_id}">${resident.resident_id}
				</option>
				<%-- - ${resident.resident_name} ${resident.resident_last_name} </option> --%>
			</c:forEach>
		</select>
	</div>
	seleccione un lugar para reservar
	<div>
		Dirección: <select id="addressSelector" name="addressSelector"
			onChange="unlockBlocksByAddress()">
			<option value="">--------------</option>
			<c:forEach items="${realStatesList}" var="realState">
				<option name="${realState.realStateID.address}">
					${realState.realStateID.address}</option>
			</c:forEach>
		</select> bloque: <select disabled id="blockSelector" name="blockSelector"
			onchange="unlockinternalIDSelectorByBlock()">
			<option value="">------------</option>
			<c:forEach items="${realStatesList}" var="realState">
				<option name="${realState.realStateID.address}">
					${realState.realStateID.block}</option>
			</c:forEach>
		</select> número: <select disabled id="internalIDSelector"
			name="internalIDSelector">
			<option value="">-------------</option>
			<c:forEach items="${realStatesList}" var="realState">
				<option
					name="${realState.realStateID.address}+${realState.realStateID.block}">
					${realState.realStateID.internal_id}</option>
			</c:forEach>
		</select>
	</div>
	Seleccione la fecha
	<div>
		Mes <select name="monthSelector">
			<option >-------------</option>
			<option >01</option>
			<option >02</option>
			<option >03</option>
			<option >04</option>
			<option >05</option>
			<option >06</option>
			<option >07</option>
			<option >08</option>
			<option >09</option>
			<option >10</option>
			<option >11</option>
			<option >12</option>
		</select> Dia <select name="daySelector">
			<option value="">-------------</option>
			<option >01</option>
			<option >02</option>
			<option >03</option>
			<option >04</option>
			<option >05</option>
			<option >06</option>
			<option >07</option>
			<option >08</option>
			<option >09</option>
			<option >10</option>
			<option >11</option>
			<option>12</option>
			<option >13</option>
			<option >14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
			<option>24</option>
			<option>25</option>
			<option>26</option>
			<option>27</option>
			<option>28</option>
			<option>29</option>
			<option>30</option>
			<option>31</option>
		</select> Hora: <select name="startinHourSelector">
			<option value="">-------------</option>
			<option>00</option>
			<option>01</option>
			<option>02</option>
			<option>03</option>
			<option>04</option>
			<option>05</option>
			<option>06</option>
			<option>07</option>
			<option>08</option>
			<option>09</option>
			<option>10</option>
			<option>11</option>
			<option>12</option>
			<option>13</option>
			<option>14</option>
			<option>15</option>
			<option>16</option>
			<option>17</option>
			<option>18</option>
			<option>19</option>
			<option>20</option>
			<option>21</option>
			<option>22</option>
			<option>23</option>
			<option>24</option>
		</select> Numero de horas<select name="hoursAmountSelector">
			<option value="">-------------</option>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
	</div>
	<input type="submit" value="Enviar">
	</form>
</body>
</html>
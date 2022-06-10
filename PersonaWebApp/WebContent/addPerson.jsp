<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vehicle</title>
<style><%@include file="/css/vehStyle.css"%></style>
</head>
<div class="content"> 
<body>
<h1> PERSON APP</h1>
 <h2> Hola, por favor ingrese los datos de la persona</h2>
 <form action="AddPersonaServlet" method="post">
 <table cellspacing="3" cellpadding="3" border="1" >
 <tr>
 <td align="right"> Documento: </td>
 <td><input type="text" name="documento"></td>
 </tr>
 <tr>
 <td align="right"> Tipo documento: </td>
 <td> <input type="text" name="tipo"> </td>
 </tr>
 <tr>
 <td align="right"> Nombres: </td>
 <td> <input type="text" name="nombres"> </td>
 </tr>
 <tr>
 <td align="right"> Apellidos: </td>
 <td> <input type="text" name="apellidos"> </td>
 </tr>
 </table>
 <input type="submit" value="Enviar">
 </form>
</body>
</div>
</html>
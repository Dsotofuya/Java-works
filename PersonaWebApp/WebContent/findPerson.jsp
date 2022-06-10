<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
 <h2> Consulta Persona </h2>
 <h2> Los siguientes son los datos de la persona: </h2>
 <table cellspacing="3" cellpadding="3" border="1" >
 <tr>
 <td align="right"> Documento: </td>
 <td><c:out value="${documento}"></c:out></td>
 </tr>
 <tr>
 <td align="right"> Tipo documento: </td>
 <td><c:out value="${tipo}"></c:out></td>
 </tr>
 <tr>
 <td align="right"> Nombres: </td>
 <td> <c:out value="${nombres}"></c:out></td>
 </tr>
 <tr>
 <td align="right"> Apellidos: </td>
 <td> <c:out value="${apellidos}"></c:out></td>
 </tr>
 </table>
 <h2><a href="index.jsp"> Volver a la página inicial!</h2> 
</body>
</div>
</html>